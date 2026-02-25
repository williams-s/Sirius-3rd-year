package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.MatchStateDTO;
import club.manager.common_library.dto.TeamScoreDTO;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import club.manager.entrance_cockpit.utils.LiveMatchState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiveMatchStateService {

    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, LiveMatchState> matchStates = new ConcurrentHashMap<>();
    private final MatchService matchService;
    public boolean isMatchLive(Long matchId) {
        return matchStates.getOrDefault(matchId, new LiveMatchState()).isLive();
    }

    public void setMatchLive(Long matchId, boolean isLive) {
        matchStates.computeIfAbsent(matchId, k -> new LiveMatchState()).setLive(isLive);
        matchService.updateMatchStatus(matchId, isLive);
        sendToWebsocketNotif(matchId);
    }

    public boolean isHalfTime(Long matchId) {
        return matchStates.getOrDefault(matchId, new LiveMatchState()).isHalfTime();
    }

    public void setHalfTime(Long matchId, boolean halfTime) {
        matchStates.computeIfAbsent(matchId, k -> new LiveMatchState()).setHalfTime(halfTime);
    }

    public void clearMatchState(Long matchId) {
        matchStates.remove(matchId);
    }

    public boolean isMatchFinished(Long matchId){
        return  !matchStates.containsKey(matchId);
    }

    public boolean isMatchNotRunning(Long matchId) {
        return !isMatchLive(matchId) || isHalfTime(matchId);
    }


    public void updateScore(Long matchId ,MatchStateDTO matchStateDTO){
        TeamScoreDTO awayTeam = matchStateDTO.getScore().awayTeam();
        TeamScoreDTO homeTeam = matchStateDTO.getScore().homeTeam();
        matchService.updateScore(matchId, homeTeam, awayTeam);
        sendToWebsocketNotif(matchId);
    }

    private void sendToWebsocketNotif(Long matchId){
        MatchResponseDTO matchResponseDTO = matchService.getMatch(matchId);
        if (matchResponseDTO != null) {
            Long clubId1 = matchResponseDTO.getHomeTeam().club().clubId();
            Long clubId2 = matchResponseDTO.getAwayTeam().club().clubId();
            webSocketService.sendObjectToTopic(matchResponseDTO, "notif-live-match/" + clubId1);
            webSocketService.sendObjectToTopic(matchResponseDTO, "notif-live-match/" + clubId2);
        }
    }
}