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
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlayersPositionsBridge {
    private final WebSocketService webSocketService;
    private final ExtractPayload extractPayload = new ExtractPayload();
    private final ConcurrentHashMap<Long, List<PlayerPositionDTO>> playersPositions = new ConcurrentHashMap<>();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "players-position", groupId = "entrance-cockpit-players-position")
    public void consumePlayersPosition(String message) {
        //log.debug("Received message: {}", message);
        List<PlayerPositionDTO> playerPositionsDTO = extractPayload.extractPlayersPositions(message);
        if (playerPositionsDTO != null && !playerPositionsDTO.isEmpty()) {
            //log.debug("Extracted player positions: {}", playerPositions);
            Long matchId = playerPositionsDTO.getFirst().getMatchId();
            playersPositions.put(matchId,playerPositionsDTO);
        }
    }

    @Scheduled(fixedRate = 33)
    public void sendPlayersPositions() {
        playersPositions.forEach((matchId, playersPositionList) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            webSocketService.sendPlayersPositionsToTopic(playersPositionList, "live-match/" + matchId + "/players-position");
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        playersPositions.forEach((matchId, playersPositionsList) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(playersPositions::remove);
    }

}
