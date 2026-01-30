package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.PlayerPositionDTO;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlayersPositionsBridge {
    private final WebSocketService webSocketService;
    private final ExtractPayload extractPayload = new ExtractPayload();
    private List<PlayerPositionDTO> lastPlayerPositions = new ArrayList<>();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "players-position", groupId = "entrance-cockpit")
    public void consumePlayersPosition(String message) {
        //log.debug("Received message: {}", message);
        List<PlayerPositionDTO> playerPositions = extractPayload.extractPlayersPositions(message);
        if (playerPositions != null && !playerPositions.isEmpty()) {
            //log.debug("Extracted player positions: {}", playerPositions);
            lastPlayerPositions = playerPositions;
        }
    }

    @Scheduled(fixedRate = 33)
    public void sendPlayersPositions() {
        if (!lastPlayerPositions.isEmpty()) {
            Long matchId = lastPlayerPositions.getFirst().getMatchId();
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            //log.debug("Sending players positions: {}", lastPlayerPositions);
            webSocketService.sendPlayersPositionsToTopic(lastPlayerPositions, "live-match/" + matchId + "/players-position");        }
    }

}
