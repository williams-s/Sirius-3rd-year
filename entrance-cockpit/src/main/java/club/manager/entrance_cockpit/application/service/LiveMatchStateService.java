package club.manager.entrance_cockpit.application.service;

import club.manager.entrance_cockpit.utils.LiveMatchState;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class LiveMatchStateService {

    private final ConcurrentHashMap<Long, LiveMatchState> matchStates = new ConcurrentHashMap<>();

    public boolean isMatchLive(Long matchId) {
        return matchStates.getOrDefault(matchId, new LiveMatchState()).isLive();
    }

    public void setMatchLive(Long matchId, boolean isLive) {
        matchStates.computeIfAbsent(matchId, k -> new LiveMatchState()).setLive(isLive);
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

    public boolean isMatchNotRunning(Long matchId) {
        return !isMatchLive(matchId) || isHalfTime(matchId);
    }
}