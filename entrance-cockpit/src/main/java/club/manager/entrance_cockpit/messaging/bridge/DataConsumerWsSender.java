package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.BallEventDTO;
import club.manager.common_library.dto.LiveMatchDTO;
import club.manager.common_library.dto.MatchStateDTO;
import club.manager.common_library.dto.PlayerLiveMatchDetailDTO;
import club.manager.common_library.enums.MatchEventEnum;
import club.manager.common_library.keys.PlayerKey;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataConsumerWsSender {
    private final WebSocketService webSocketService;
    private final ObjectMapper mapper;
    private BallEventDTO lastBallEvent;
    private MatchStateDTO lastMatchState;
    private final ConcurrentHashMap<PlayerKey, PlayerLiveMatchDetailDTO> playersInMatch = new ConcurrentHashMap<>();

    private boolean matchIsLive = false;
    private boolean halfTime = false;
    @KafkaListener(topics = "front-data", groupId = "entrance-cockpit")
    public void consumeFrontData(String message) {
        //log.debug("Received message: {}", message);
        PlayerLiveMatchDetailDTO playerLiveMatchDetailDTO = mapper.readValue(message, PlayerLiveMatchDetailDTO.class);
        playersInMatch.put(new PlayerKey(playerLiveMatchDetailDTO.getMatchId(), playerLiveMatchDetailDTO.getPlayerId()), playerLiveMatchDetailDTO);
    }


    @KafkaListener(topics = "ball-events", groupId = "entrance-cockpit")
    public void consumeBallEvent(String message) {
        //log.debug("Received message: {}", message);
        JsonNode jsonNode = mapper.readTree(message);
        String payload = jsonNode.get("payload").asString();
        lastBallEvent = mapper.readValue(payload, BallEventDTO.class);
    }

    @KafkaListener(topics = "match-state", groupId = "entrance-cockpit")
    public void consumeMatchState(String message) {
        //log.debug("Received message: {}", message);
        JsonNode jsonNode = mapper.readTree(message);
        String payload = jsonNode.get("payload").asString();
        lastMatchState = mapper.readValue(payload, MatchStateDTO.class);
        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.KICK_OFF)) {
            matchIsLive = true;
        }
        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.SECOND_HALF_KICK_OFF)) {
            halfTime = false;
        }
    }

    @Scheduled(fixedRate = 33)
    public void sendPlayersInMatch() {
        if (halfTime || !matchIsLive || lastBallEvent == null || lastMatchState == null || playersInMatch.isEmpty()) {
            return;
        }
        LiveMatchDTO liveMatchDTO =
                LiveMatchDTO.builder()
                        .ballEvent(lastBallEvent)
                        .allPlayers(playersInMatch.values().stream().toList())
                        .matchState(lastMatchState)
                .build();

        webSocketService.sendLiveMatchToTopic(liveMatchDTO, "live-match");

        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.FULL_TIME)) {
            matchIsLive = false;
        }
        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.HALF_TIME)) {
            halfTime = true;
        }
    }
}
