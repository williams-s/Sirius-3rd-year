package club.manager.player_performance.streams;

import club.manager.player_performance.model.Player;

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
    public KStream<String, Player> matchStream(StreamsBuilder builder) {

        KStream<String, Player> matchEvents =
                builder.stream("match-events", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, Player> playerPosition =
                builder.stream("players-position", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, Player> playerHealth =
                builder.stream("players-health", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(this::extractPayload)
                        .filter((k, v) -> v != null);

        KStream<String, Player> matchByPlayer =
                matchEvents.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, Player> positionByPlayer =
                playerPosition.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        KStream<String, Player> healthByPlayer =
                playerHealth.selectKey((k, v) -> v.getMatchId() + "|" + v.getPlayerId());

        Serde<Player> playerSerde = playerSerde();

        StreamJoined<String, Player, Player> joined =
                StreamJoined.with(Serdes.String(), playerSerde, playerSerde);

        KStream<String, Player> playerPositionAndHealth =
                positionByPlayer.join(
                        healthByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );

        KStream<String, Player> allPlayerInfos =
                playerPositionAndHealth.leftJoin(
                        matchByPlayer,
                        playerService::mergeTopics,
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(100)),
                        joined
                );
        allPlayerInfos.peek((k, player) -> playerService.addStats(player));
        allPlayerInfos.filter((k, v) -> v.getHasBall()).peek((k, v) -> log.info("Player info [{}] : {}", k, v));
        return allPlayerInfos;
    }

    private Player extractPayload(String value) {
        try {
            JsonNode root = objectMapper.readTree(value);
            if (root.has("payload")) {
                return objectMapper.readValue(root.get("payload").asString(), Player.class);
            }
            return objectMapper.treeToValue(root, Player.class);
        } catch (Exception e) {
            log.error("Invalid JSON: {}", value, e);
            return null;
        }
    }

    private Serde<Player> playerSerde() {

        Serializer<Player> serializer = (key, data) -> {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Deserializer<Player> deserializer = (key, data) -> {
            try {
                return objectMapper.readValue(data, Player.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return Serdes.serdeFrom(serializer, deserializer);
    }
}
