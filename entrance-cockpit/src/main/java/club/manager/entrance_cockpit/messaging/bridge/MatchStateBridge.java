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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
@Slf4j
public class MatchStateBridge {

    private final WebSocketService webSocketService;
    private final LiveMatchStateService liveMatchStateService;
    //private final ConcurrentHashMap<Long,MatchStateDTO> matchStates = new ConcurrentHashMap<>();
    private final ExtractPayload extractPayload = new ExtractPayload();
    @KafkaListener(topics = "match-state", groupId = "entrance-cockpit-match-state")
    public void consumeMatchState(String message) {
        MatchStateDTO matchStateDTO = extractPayload.extractMatchState(message);
        if (matchStateDTO != null) {
            Long matchId = matchStateDTO.getMatchId();
            //matchStates.put(matchId, matchStateDTO);
            if (matchStateDTO.getMatchStateEnum().equals(MatchStateEnum.KICK_OFF)) {
                liveMatchStateService.setMatchLive(matchId, true);
            }
            if (matchStateDTO.getMatchStateEnum().equals(MatchStateEnum.SECOND_HALF_KICK_OFF)) {
                liveMatchStateService.setHalfTime(matchId, false);
            }
            sendMatchState(matchStateDTO);
        }
    }

    private void sendMatchState(MatchStateDTO matchState){
        Long matchId = matchState.getMatchId();
        if (liveMatchStateService.isMatchNotRunning(matchId)) {
            return;
        }
        webSocketService.sendObjectToTopic(matchState,String.format("live-match/%d/match-state",matchId));
        if (matchState.getMatchStateEnum().equals(MatchStateEnum.HALF_TIME))
            liveMatchStateService.setHalfTime(matchId,true);
        if (matchState.getMatchStateEnum().equals(MatchStateEnum.FULL_TIME)){
            liveMatchStateService.setMatchLive(matchId,false);
            liveMatchStateService.clearMatchState(matchId);
        }
    }
}
