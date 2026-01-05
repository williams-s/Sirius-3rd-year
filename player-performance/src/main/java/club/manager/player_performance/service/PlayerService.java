package club.manager.player_performance.service;

import club.manager.player_performance.model.Player;
import club.manager.player_performance.model.Stats;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {

    public record PlayerKey(Long matchId, Long playerId) {}

    public final HashMap<PlayerKey, Player> playersInMatch = new HashMap<>();

    public Player mergeTopics(Player p1, Player p2) {
        Player res = null;
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

    private Player merge(Player p1, Player p2) {

        Player.PlayerBuilder merge = Player.builder()
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
                .stats(p1.getStats())
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

    public Player getPlayerInMatch(Player p) {
        addPlayerInMatchIfNotExist(p);
        return playersInMatch.get(new PlayerKey(p.getMatchId(), p.getPlayerId()));
    }

    public void addPlayerInMatchIfNotExist(Player p) {
        if (!playersInMatch.containsKey(new PlayerKey(p.getMatchId(), p.getPlayerId()))) {
            p.setStats(new Stats());
            playersInMatch.put(new PlayerKey(p.getMatchId(), p.getPlayerId()), p);
        }
    }


    public void addStats(Player p) {
        addPlayerInMatchIfNotExist(p);
        if (p.getEventType() != null) {
            matchEventType(p);
        }
        if (p.getHasBall() != null) {
            if (p.getHasBall()) {
                Stats stats = p.getStats();
                stats.setTouches(stats.getTouches() + 1);
            }
        }
        Stats stats = p.getStats();
        stats.setDistanceCovered(stats.getDistanceCovered() + p.getDistanceCovered());
    }

    private void matchEventType(Player p) {
        Stats stats = p.getStats();
        switch (p.getEventType()) {
            case GOAL -> stats.setGoals(stats.getGoals() + 1);
            case ASSIST -> stats.setAssists(stats.getAssists() + 1);

            case SHOT_MISS -> stats.setShots(stats.getShots() + 1);
            case SHOT_ON_TARGET -> {
                stats.setShots(stats.getShots() + 1);
                stats.setShotsOnTarget(stats.getShotsOnTarget() + 1);
            }

            case PASS_FAILED -> stats.setPasses(stats.getPasses() + 1);
            case PASS_SUCCESS -> {
                stats.setPassesSuccess(stats.getPassesSuccess() + 1);
                stats.setPasses(stats.getPasses() + 1);
            }

            case TACKLE_FAILED -> stats.setTackles(stats.getTackles() + 1);
            case TACKLE_SUCCESS -> {
                stats.setTackles(stats.getTackles() + 1);
                stats.setTacklesSuccess(stats.getTacklesSuccess() + 1);
            }

            case SHOT_SAVED -> stats.setSaves(stats.getSaves() + 1);
            case INTERCEPTION -> stats.setInterceptions(stats.getInterceptions() + 1);

            case DRIBBLE_FAILED -> stats.setDribbles(stats.getDribbles() + 1);
            case DRIBBLE_SUCCESS -> {
                stats.setDribbles(stats.getDribbles() + 1);
                stats.setDribblesSuccess(stats.getDribblesSuccess() + 1);
            }

        }
    }

}
