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
        if (isLive){
            log.info("The match with id : {} just started", matchId);
            log.info("Will now send ball information for match with id : {} to static-server-backend", matchId);
            log.info("Will now send heat-map of players for match with id : {} to static-server-backend", matchId);
            log.info("Will now send match sheet for match with id : {} to static-server-backend", matchId);
            log.info("Will now send match states for match with id : {} to static-server-backend", matchId);
            log.info("Will now send healh stats of players for match with id : {} to static-server-backend", matchId);
            log.info("Will now send positions of players for match with id : {} to static-server-backend", matchId);
            log.info("Will now send stats of players for match with id : {} to static-server-backend", matchId);
            log.info("Will now send health stats by team for match with id : {} to static-server-backend", matchId);
            log.info("Will now send stats by team for match with id : {} to static-server-backend", matchId);
        }
        else
            log.info("The match with id : {} just finished", matchId);
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
            log.info("Sending notification to static-server-backend on topic /topic/notif-live-match/{} and /topic/notif-live-match/{}", clubId1, clubId2);
            webSocketService.sendObjectToTopic(matchResponseDTO, "notif-live-match/" + clubId1);
            webSocketService.sendObjectToTopic(matchResponseDTO, "notif-live-match/" + clubId2);
        }
    }
}