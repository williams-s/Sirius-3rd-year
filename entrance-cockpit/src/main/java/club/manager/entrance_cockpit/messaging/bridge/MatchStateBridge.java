package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.MatchStateDTO;
import club.manager.common_library.enums.MatchStateEnum;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
@Slf4j
public class MatchStateBridge {

    private final WebSocketService webSocketService;
    private final LiveMatchStateService liveMatchStateService;
    private final AtomicReference<MatchStateDTO> lastMatchState = new AtomicReference<>();
    private final ExtractPayload extractPayload = new ExtractPayload();
    @KafkaListener(topics = "match-state", groupId = "entrance-cockpit")
    public void consumeMatchState(String message) {
        MatchStateDTO matchStateDTO = extractPayload.extractMatchState(message);
        if (matchStateDTO != null) {
            lastMatchState.set(matchStateDTO);
            if (matchStateDTO.getMatchStateEnum().equals(MatchStateEnum.KICK_OFF)) {
                liveMatchStateService.setMatchLive(matchStateDTO.getMatchId(), true);
            }
            if (matchStateDTO.getMatchStateEnum().equals(MatchStateEnum.SECOND_HALF_KICK_OFF)) {
                liveMatchStateService.setHalfTime(matchStateDTO.getMatchId(), false);
            }
        }
    }

    @Scheduled(fixedRate = 2000)
    public void sendMatchState(){
        MatchStateDTO currentState = lastMatchState.get();
        if (currentState != null){
            log.debug(currentState.toString());
            Long matchId = currentState.getMatchId();
            if (liveMatchStateService.isMatchNotRunning(matchId)){
                return;
            }
            webSocketService.sendObjectToTopic(currentState,String.format("live-match/%d/match-state",matchId));
            if (currentState.getMatchStateEnum().equals(MatchStateEnum.HALF_TIME))
                liveMatchStateService.setHalfTime(matchId,true);
            if (currentState.getMatchStateEnum().equals(MatchStateEnum.FULL_TIME))
                liveMatchStateService.setMatchLive(matchId,false);
        }
    }
}
