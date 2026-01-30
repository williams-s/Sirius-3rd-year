package club.manager.player_performance.service;

import club.manager.common_library.dto.*;
import club.manager.common_library.keys.PlayerKey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {

    public final HashMap<PlayerKey, PlayerLiveMatchDetailDTO> playersInMatch = new HashMap<>();
    public final HashMap<PlayerKey, StatsDTO> playersStats = new HashMap<>();
   /* public PlayerLiveMatchDetailDTO mergeTopics(PlayerLiveMatchDetailDTO p1, PlayerLiveMatchDetailDTO p2) {
        PlayerLiveMatchDetailDTO res = null;
        if (p1 == null) {
            res = merge(getPlayerInMatch(p2),p2);
        }
        if (p2 == null) {
            res = merge(getPlayerInMatch(p1),p1);
        }
        if (p1 != null && p2 != null) {
            res = merge(merge(getPlayerInMatch(p1),p1),p2);
        }
        return res;
    }*/

    /*private PlayerLiveMatchDetailDTO merge(PlayerLiveMatchDetailDTO p1, PlayerLiveMatchDetailDTO p2) {

        PlayerLiveMatchDetailDTO.PlayerLiveMatchDetailDTOBuilder merge = PlayerLiveMatchDetailDTO.builder()
                .matchId(p1.getMatchId())
                .timestamp(p1.getTimestamp())
                .playerId(p1.getPlayerId())
                .playerPosition(p1.getPlayerPosition())
                .playerHealth(p1.getPlayerHealth())
                .matchEvent(p1.getMatchEvent())
                .statsDTO(p1.getStatsDTO());


        if (p2.getPlayerPosition() != null) merge.playerPosition(p2.getPlayerPosition());
        if (p2.getPlayerHealth() != null) merge.playerHealth(p2.getPlayerHealth());
        if (p2.getMatchEvent() != null) merge.matchEvent(p2.getMatchEvent());

        return merge.build();
    }*/

    public PlayerLiveMatchDetailDTO getPlayerInMatch(PlayerLiveMatchDetailDTO p) {
        addPlayerInMatchIfNotExist(p);
        return playersInMatch.get(new PlayerKey(p.getMatchId(), p.getPlayerId()));
    }

    public void addPlayerInMatchIfNotExist(PlayerLiveMatchDetailDTO p) {
        if (!playersInMatch.containsKey(new PlayerKey(p.getMatchId(), p.getPlayerId()))) {
            p.setStatsDTO(new StatsDTO());
            playersInMatch.put(new PlayerKey(p.getMatchId(), p.getPlayerId()), p);
            log.debug(p.toString());
        }
    }

    public StatsDTO getPlayerStats(PlayerKey playerKey) {
        addStatsIfNotExist(playerKey);
        return playersStats.get(playerKey);
    }

    private void addStatsIfNotExist(PlayerKey playerKey) {
        if (!playersStats.containsKey(playerKey)) {
            StatsDTO statsDTO = new StatsDTO();
            statsDTO.setPlayerId(playerKey.playerId());
            statsDTO.setMatchId(playerKey.matchId());
            playersStats.put(playerKey, statsDTO);
        }
    }

    public void addStats(MatchEventDTO matchEventDTO) {
        if (matchEventDTO != null) {
            if (matchEventDTO.getEventType() != null) {
                StatsDTO statsDTO = getPlayerStats(new PlayerKey(matchEventDTO.getMatchId(), matchEventDTO.getPlayerId()));
                matchEventType(matchEventDTO, statsDTO);
            }
        }
        //statsDTO.setDistanceCovered(statsDTO.getDistanceCovered() + p.getPlayerPosition().getDistanceCovered());
    }

    public void addDistanceCovered(PlayerPositionDTO p) {
        StatsDTO statsDTO = getPlayerStats(new PlayerKey(p.getMatchId(), p.getPlayerId()));
        statsDTO.setDistanceCovered(statsDTO.getDistanceCovered() + p.getDistanceCovered());
    }

    private void matchEventType(MatchEventDTO matchEventDTO, StatsDTO statsDTO) {
        switch (matchEventDTO.getEventType()) {
            case GOAL -> statsDTO.setGoals(statsDTO.getGoals() + 1);
            case ASSIST -> statsDTO.setAssists(statsDTO.getAssists() + 1);

            case SHOT_MISS -> statsDTO.setShots(statsDTO.getShots() + 1);
            case SHOT_ON_TARGET -> {
                statsDTO.setShots(statsDTO.getShots() + 1);
                statsDTO.setShotsOnTarget(statsDTO.getShotsOnTarget() + 1);
            }

            case PASS_FAILED -> statsDTO.setPasses(statsDTO.getPasses() + 1);
            case PASS_SUCCESS -> {
                statsDTO.setPassesSuccess(statsDTO.getPassesSuccess() + 1);
                statsDTO.setPasses(statsDTO.getPasses() + 1);
            }

            case TACKLE_FAILED -> statsDTO.setTackles(statsDTO.getTackles() + 1);
            case TACKLE_SUCCESS -> {
                statsDTO.setTackles(statsDTO.getTackles() + 1);
                statsDTO.setTacklesSuccess(statsDTO.getTacklesSuccess() + 1);
            }

            case SHOT_SAVED -> statsDTO.setSaves(statsDTO.getSaves() + 1);
            case INTERCEPTION -> statsDTO.setInterceptions(statsDTO.getInterceptions() + 1);

            case DRIBBLE_FAILED -> statsDTO.setDribbles(statsDTO.getDribbles() + 1);
            case DRIBBLE_SUCCESS -> {
                statsDTO.setDribbles(statsDTO.getDribbles() + 1);
                statsDTO.setDribblesSuccess(statsDTO.getDribblesSuccess() + 1);
            }

        }
    }

}
