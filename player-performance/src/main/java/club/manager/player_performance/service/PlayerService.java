package club.manager.player_performance.service;

import club.manager.commonlibrary.dto.PlayerStatsDTO;
import club.manager.commonlibrary.dto.StatsDTO;
import club.manager.commonlibrary.keys.PlayerKey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {

    public final HashMap<PlayerKey, PlayerStatsDTO> playersInMatch = new HashMap<>();

    public PlayerStatsDTO mergeTopics(PlayerStatsDTO p1, PlayerStatsDTO p2) {
        PlayerStatsDTO res = null;
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
    }

    private PlayerStatsDTO merge(PlayerStatsDTO p1, PlayerStatsDTO p2) {

        PlayerStatsDTO.PlayerStatsDTOBuilder merge = PlayerStatsDTO.builder()
                .matchId(p1.getMatchId())
                .playerId(p1.getPlayerId())
                .team(p1.getTeam())
                .distanceCovered(p1.getDistanceCovered())
                .hasBall(p1.getHasBall())
                .x(p1.getX())
                .y(p1.getY())
                .stamina(p1.getStamina())
                .heartRate(p1.getHeartRate())
                .position(p1.getPosition())
                .temperature(p1.getTemperature())
                .eventType(p1.getEventType())
                .statsDTO(p1.getStatsDTO())
                .timestamp(p1.getTimestamp());

        if (p2.getX() != null) merge.x(p2.getX());
        if (p2.getY() != null) merge.y(p2.getY());
        if (p2.getStamina() != null) merge.stamina(p2.getStamina());
        if (p2.getEventType() != null) merge.eventType(p2.getEventType());
        if (p2.getTimestamp() != null) merge.timestamp(p2.getTimestamp());
        if (p2.getDistanceCovered() != null) merge.distanceCovered(p2.getDistanceCovered());
        if (p2.getHasBall() != null) merge.hasBall(p2.getHasBall());
        if (p2.getHeartRate() != null) merge.heartRate(p2.getHeartRate());
        if (p2.getTemperature() != null) merge.temperature(p2.getTemperature());
        if (p2.getPosition() != null) merge.position(p2.getPosition());

        return merge.build();
    }

    public PlayerStatsDTO getPlayerInMatch(PlayerStatsDTO p) {
        addPlayerInMatchIfNotExist(p);
        return playersInMatch.get(new PlayerKey(p.getMatchId(), p.getPlayerId()));
    }

    public void addPlayerInMatchIfNotExist(PlayerStatsDTO p) {
        if (!playersInMatch.containsKey(new PlayerKey(p.getMatchId(), p.getPlayerId()))) {
            p.setStatsDTO(new StatsDTO());
            playersInMatch.put(new PlayerKey(p.getMatchId(), p.getPlayerId()), p);
        }
    }


    public void addStats(PlayerStatsDTO p) {
        addPlayerInMatchIfNotExist(p);
        if (p.getEventType() != null) {
            matchEventType(p);
        }
        if (p.getHasBall() != null) {
            if (p.getHasBall()) {
                StatsDTO statsDTO = p.getStatsDTO();
                statsDTO.setTouches(statsDTO.getTouches() + 1);
            }
        }
        StatsDTO statsDTO = p.getStatsDTO();
        statsDTO.setDistanceCovered(statsDTO.getDistanceCovered() + p.getDistanceCovered());
    }

    private void matchEventType(PlayerStatsDTO p) {
        StatsDTO statsDTO = p.getStatsDTO();
        switch (p.getEventType()) {
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
