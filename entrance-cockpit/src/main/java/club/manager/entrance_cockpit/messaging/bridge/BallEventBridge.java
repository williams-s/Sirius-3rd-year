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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class BallEventBridge {
    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, BallEventDTO> ballEvents = new ConcurrentHashMap<>();
    private final ExtractPayload extractPayload = new ExtractPayload();
    private final LiveMatchStateService liveMatchStateService;

    @KafkaListener(topics = "ball-events", groupId = "entrance-cockpit-ball-events")
    public void consumeBallEvent(String message) {
        //log.debug("Received message: {}", message);
        BallEventDTO ballEventDTO = extractPayload.extractBallEvent(message);
        if (ballEventDTO != null) {
            Long matchId = ballEventDTO.getMatchId();
            ballEvents.put(matchId,ballEventDTO);
        }
    }

    @Scheduled(fixedRate = 33)
    public void sendBallEvent() {
        ballEvents.forEach((matchId, ballEvent) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            webSocketService.sendObjectToTopic(ballEvent, "live-match/" + matchId + "/ball-events");
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        ballEvents.forEach((matchId, ballEvent) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(ballEvents::remove);
    }
}
