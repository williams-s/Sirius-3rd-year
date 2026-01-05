package club.manager.player_performance.streams;

import club.manager.commonlibrary.dto.PlayerStatsDTO;
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
import java.util.List;

@Configuration
@AllArgsConstructor
@Slf4j
public class MatchStreams {

    private final ObjectMapper objectMapper;
    private final PlayerService playerService;
    private static final List<String> TOPICS = List.of(
            "match-events",
            "players-position",
            "players-health"
    );

    @Bean
    public KStream<String, PlayerStatsDTO> matchStream(StreamsBuilder builder) {

        KStream<String, PlayerStatsDTO> matchEvents =
                builder.stream("match-events", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerStatsDTO> playerPosition =
                builder.stream("players-position", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerStatsDTO> playerHealth =
                builder.stream("players-health", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, PlayerStatsDTO> matchByPlayer =
                matchEvents.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, PlayerStatsDTO> positionByPlayer =
                playerPosition.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, PlayerStatsDTO> healthByPlayer =
                playerHealth.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        Serde<PlayerStatsDTO> playerSerde = playerSerde();

        StreamJoined<String, PlayerStatsDTO, PlayerStatsDTO> joined =
                StreamJoined.with(Serdes.String(), playerSerde, playerSerde);

        KStream<String, PlayerStatsDTO> playerPositionAndHealth =
                positionByPlayer.join(
                        healthByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );

        KStream<String, PlayerStatsDTO> allPlayerInfos =
                playerPositionAndHealth.leftJoin(
                        matchByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );
        allPlayerInfos.peek((k, playerStatsDTO) -> playerService.addStats(playerStatsDTO)).to("front-data", Produced.with(Serdes.String(), playerSerde));
        //allPlayerInfos.filter((k, v) -> v.getHasBall()).peek((k, v) -> log.info("Player info [{}] : {}", k, v));
        return allPlayerInfos;
    }

    private PlayerStatsDTO extractPayload(String value) {
        try {
            JsonNode root = objectMapper.readTree(value);
            if (root.has("payload")) {
                return objectMapper.readValue(root.get("payload").asString(), PlayerStatsDTO.class);
            }
            return objectMapper.treeToValue(root, PlayerStatsDTO.class);
        } catch (Exception e) {
            log.error("Invalid JSON: {}", value, e);
            return null;
        }
    }

    private Serde<PlayerStatsDTO> playerSerde() {

        Serializer<PlayerStatsDTO> serializer = (key, data) -> {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Deserializer<PlayerStatsDTO> deserializer = (key, data) -> {
            try {
                return objectMapper.readValue(data, PlayerStatsDTO.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return Serdes.serdeFrom(serializer, deserializer);
    }
}
