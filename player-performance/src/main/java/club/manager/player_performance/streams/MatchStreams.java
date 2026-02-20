package club.manager.player_performance.streams;

import club.manager.common_library.dto.*;
import club.manager.common_library.keys.PlayerKey;
import club.manager.common_library.parentDTO.PayloadDTO;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.player_performance.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@AllArgsConstructor
@Slf4j
public class MatchStreams {

    private final ObjectMapper objectMapper;
    private final PlayerService playerService;
    private final ConcurrentHashMap<PlayerKey, PlayerPositionDTO> currentPlayerPositions = new ConcurrentHashMap<>();
    private final ExtractPayload extractPayload = new ExtractPayload();

    @Bean
    public KStream<String, MatchEventDTO> matchStream(StreamsBuilder builder) {


        KStream<String, MatchEventDTO> matchEvents =
                builder.stream("match-events", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractMatchEvent)
                        .filter((k, v) -> v != null);

        KStream<String, List<PlayerPositionDTO>> playerPosition =
                builder.stream("players-position", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractPlayersPositions)
                        .filter((k, v) -> v != null);

        KStream<String, List<PlayerHealthDTO>> playerHealth =
                builder.stream("players-health", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractPlayersHealth)
                        .filter((k, v) -> v != null);

        KStream<String, MatchEventDTO> matchByPlayer =
                matchEvents
                        .peek((k,v) -> playerService.addStats(v))
                        .selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, PayloadDTO> positionByPlayer  =
                playerPosition
                        .selectKey((k, v) -> {
                            return v.isEmpty() ? "unknown" : String.valueOf(v.getFirst().getMatchId());
                        })
                        .mapValues((k, listPositions) -> updatePlayerPositions(listPositions));

        KStream<String, PayloadDTO> statsByPlayer =
                playerPosition
                        .selectKey((k, v) -> {
                            return v.isEmpty() ? "unknown" : String.valueOf(v.getFirst().getMatchId());
                        })
                        .mapValues((k, v) -> getStatsPlayers(v));

        positionByPlayer.to("heat-map-player-position", Produced.with(Serdes.String(), payloadSerde()));
        statsByPlayer.to("stats-player-position", Produced.with(Serdes.String(), payloadSerde()));

        KStream<String, PlayerHealthDTO> healthByPlayer =
                playerHealth
                        .flatMapValues(l -> l)
                        .selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        Serde<PlayerLiveMatchDetailDTO> playerSerde = playerSerde();

        StreamJoined<String, PlayerLiveMatchDetailDTO, PlayerLiveMatchDetailDTO> joined =
                StreamJoined.with(Serdes.String(), playerSerde, playerSerde);

        /*KStream<String, PlayerLiveMatchDetailDTO> playerPositionAndHealth =
                positionByPlayer.join(
                        healthByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );

        KStream<String, PlayerLiveMatchDetailDTO> allPlayerInfos =
                playerPositionAndHealth.leftJoin(
                        matchByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );
        allPlayerInfos.peek((k, playerLiveMatchDetailDTO) -> playerService.addStats(playerLiveMatchDetailDTO)).to("front-data", Produced.with(Serdes.String(), playerSerde));
        //allPlayerInfos.peek((k, v) -> log.info("Player info [{}] : {}", k, v));
        return allPlayerInfos;*/
        return matchByPlayer;
    }

    private Serde<PlayerLiveMatchDetailDTO> playerSerde() {

        Serializer<PlayerLiveMatchDetailDTO> serializer = (key, data) -> {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Deserializer<PlayerLiveMatchDetailDTO> deserializer = (key, data) -> {
            try {
                return objectMapper.readValue(data, PlayerLiveMatchDetailDTO.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return Serdes.serdeFrom(serializer, deserializer);
    }

    private Serde<PayloadDTO> payloadSerde() {

        Serializer<PayloadDTO> serializer = (key, data) -> {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Deserializer<PayloadDTO> deserializer = (key, data) -> {
            try {
                return objectMapper.readValue(data, PayloadDTO.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return Serdes.serdeFrom(serializer, deserializer);
    }


    private PayloadDTO updatePlayerPositions(List<PlayerPositionDTO> positions) {
        var heatMapPlayerDTOs = positions.stream().map(this::updatePlayerPosition).toList();
        return new PayloadDTO(heatMapPlayerDTOs);
    }

    private HeatMapPlayerDTO updatePlayerPosition(PlayerPositionDTO playerPositionDTO) {
        currentPlayerPositions.put(new PlayerKey(playerPositionDTO.getMatchId(), playerPositionDTO.getPlayerId()), playerPositionDTO);
        playerService.addDistanceCovered(playerPositionDTO);
        int[][] positions = playerService.updatePositionInMatch(playerPositionDTO);
        return new HeatMapPlayerDTO(playerPositionDTO.getMatchId(), playerPositionDTO.getPlayerId(), positions);
    }

    private PayloadDTO getStatsPlayers(List<PlayerPositionDTO> positions) {
        List<StatsDTO> stats =  positions.stream().map(p -> playerService.getPlayerStats(new PlayerKey(p.getMatchId(), p.getPlayerId()))).toList();
        return new PayloadDTO(stats);
    }
}
