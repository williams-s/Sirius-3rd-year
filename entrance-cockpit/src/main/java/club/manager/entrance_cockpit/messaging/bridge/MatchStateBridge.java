package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.MatchStateDTO;
import club.manager.common_library.enums.MatchEventEnum;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

@Component
@RequiredArgsConstructor
@Slf4j
public class MatchStateBridge {

    private final WebSocketService webSocketService;
    private final LiveMatchStateService liveMatchStateService;
    private MatchStateDTO lastMatchState;
    private final ExtractPayload extractPayload = new ExtractPayload();
    @KafkaListener(topics = "match-state", groupId = "entrance-cockpit")
    public void consumeMatchState(String message) {
        MatchStateDTO matchStateDTO = extractPayload.extractMatchState(message);
        if (matchStateDTO != null) {
            lastMatchState = matchStateDTO;
        }
        if (lastMatchState == null) {
            return;
        }
        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.KICK_OFF)) {
            liveMatchStateService.setMatchLive(lastMatchState.getMatchId(), true);
        }
        if (lastMatchState.getMatchEvent().equals(MatchEventEnum.SECOND_HALF_KICK_OFF)) {
            liveMatchStateService.setHalfTime(lastMatchState.getMatchId(),false);
        }
    }
}
