package club.manager.player_performance.streams;

import club.manager.common_library.dto.PlayerLiveMatchDetailDTO;
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
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;

@Configuration
@AllArgsConstructor
@Slf4j
public class MatchStreams {

    private final ObjectMapper objectMapper;
    private final PlayerService playerService;

    @Bean
    public KStream<String, PlayerLiveMatchDetailDTO> matchStream(StreamsBuilder builder) {

        KStream<String, PlayerLiveMatchDetailDTO> matchEvents =
                builder.stream("match-events", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerLiveMatchDetailDTO> playerPosition =
                builder.stream("players-position", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerLiveMatchDetailDTO> playerHealth =
                builder.stream("players-health", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerLiveMatchDetailDTO> matchByPlayer =
                matchEvents.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, PlayerLiveMatchDetailDTO> positionByPlayer =
                playerPosition.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, PlayerLiveMatchDetailDTO> healthByPlayer =
                playerHealth.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        Serde<PlayerLiveMatchDetailDTO> playerSerde = playerSerde();

        StreamJoined<String, PlayerLiveMatchDetailDTO, PlayerLiveMatchDetailDTO> joined =
                StreamJoined.with(Serdes.String(), playerSerde, playerSerde);

        KStream<String, PlayerLiveMatchDetailDTO> playerPositionAndHealth =
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
        return allPlayerInfos;
    }

    private PlayerLiveMatchDetailDTO extractPayload(String value) {
        try {
            JsonNode root = objectMapper.readTree(value);
            if (root.has("payload")) {
                return objectMapper.readValue(root.get("payload").asString(), PlayerLiveMatchDetailDTO.class);
            }
            return objectMapper.treeToValue(root, PlayerLiveMatchDetailDTO.class);
        } catch (Exception e) {
            log.error("Invalid JSON: {}", value, e);
            return null;
        }
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
}
