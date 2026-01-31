package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.BallEventDTO;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
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
public class BallEventBridge {
    private final WebSocketService webSocketService;
    private BallEventDTO lastBallEvent;
    //private final ConcurrentHashMap<Long, BallEventDTO> ballEventsByMatchId = new ConcurrentHashMap<>();
    private final ExtractPayload extractPayload = new ExtractPayload();
    private final ObjectMapper mapper = new ObjectMapper();
    private final LiveMatchStateService liveMatchStateService;

    @KafkaListener(topics = "ball-events", groupId = "entrance-cockpit")
    public void consumeBallEvent(String message) {
        //log.debug("Received message: {}", message);
        BallEventDTO ballEventDTO = extractPayload.extractBallEvent(message);
        if (ballEventDTO != null) {
            lastBallEvent = ballEventDTO;
        }
    }

    @Scheduled(fixedRate = 33)
    public void sendBallEvent() {
        if (lastBallEvent != null) {
            Long matchId = lastBallEvent.getMatchId();
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            //log.debug("Sending ball event: {}", lastBallEvent);
            webSocketService.sendObjectToTopic(lastBallEvent, "live-match/" + matchId + "/ball-events");
        }
    }
}
