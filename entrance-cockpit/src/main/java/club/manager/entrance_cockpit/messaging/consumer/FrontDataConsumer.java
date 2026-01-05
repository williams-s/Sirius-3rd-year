package club.manager.entrance_cockpit.messaging.consumer;

import club.manager.commonlibrary.dto.PlayerStatsDTO;
import club.manager.commonlibrary.keys.PlayerKey;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class FrontDataConsumer {

    private final WebSocketService webSocketService;
    ConcurrentHashMap<PlayerKey, PlayerStatsDTO> playersInMatch = new ConcurrentHashMap<>();
    @KafkaListener(topics = "front-data", groupId = "entrance-cockpit")
    public void consume(String message ) {
        //log.debug("Received message: {}", message);
        ObjectMapper mapper = new ObjectMapper();
        PlayerStatsDTO playerStatsDTO = mapper.readValue(message, PlayerStatsDTO.class);
        playersInMatch.put(new PlayerKey(playerStatsDTO.getMatchId(), playerStatsDTO.getPlayerId()), playerStatsDTO);
    }

    @Scheduled(fixedRate = 200)
    public void sendPlayersInMatch() {
        webSocketService.sendPlayersStatsToTopic(playersInMatch.values().stream().toList(), "live-match");
    }
}
