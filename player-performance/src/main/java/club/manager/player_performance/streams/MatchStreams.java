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

        KStream<String, PayloadDTO> healthByPlayer =
                playerHealth
                        .selectKey((k, v) ->  {
                            return v.isEmpty() ? "unknown" : String.valueOf(v.getFirst().getMatchId());
                        })
                        .mapValues((k, v ) -> updatePlayerHealthStats(v));


        positionByPlayer.to("heat-map-player-live", Produced.with(Serdes.String(), payloadSerde()));
        statsByPlayer.to("stats-player-live", Produced.with(Serdes.String(), payloadSerde()));
        healthByPlayer.to("health-player-live", Produced.with(Serdes.String(), payloadSerde()));
        return matchByPlayer;
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
        playerService.addTouchesPlayers(positions);
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

    private PayloadDTO updatePlayerHealthStats(List<PlayerHealthDTO> healths){
        healths.forEach(playerService::updatePlayerHealth);
        List<PlayerHealthStatsDTO> statsHealths =  healths.stream().map(p -> playerService.getPlayerHealthStats(new PlayerKey(p.getMatchId(), p.getPlayerId()))).toList();
        return new PayloadDTO(statsHealths);
    }

}
