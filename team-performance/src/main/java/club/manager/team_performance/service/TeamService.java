package club.manager.team_performance.service;

import club.manager.common_library.dto.*;
import club.manager.common_library.keys.PlayerKey;
import club.manager.common_library.keys.TeamKey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
@Slf4j
public class TeamService {

    public final ConcurrentHashMap<TeamKey, StatsDTO> teamStats = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<PlayerKey, HealthMesures> playerHealthStats = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<TeamKey, TeamHealthMesures> teamHealthStats = new ConcurrentHashMap<>();


    public StatsDTO getTeamStats(TeamKey teamKey) {
        addStatsIfNotExist(teamKey);
        return teamStats.get(teamKey);
    }

    private void addStatsIfNotExist(TeamKey teamKey) {
        if (!teamStats.containsKey(teamKey)) {
            StatsDTO statsDTO = new StatsDTO();
            statsDTO.setMatchId(teamKey.matchId());
            statsDTO.setTeamId(teamKey.teamId());
            teamStats.put(teamKey, statsDTO);
        }
    }

    public void addStats(MatchEventDTO matchEventDTO) {
        if (matchEventDTO != null) {
            if (matchEventDTO.getEventType() != null) {
                StatsDTO statsDTO = getTeamStats(new TeamKey(matchEventDTO.getMatchId(), matchEventDTO.getTeamId()));
                matchEventType(matchEventDTO, statsDTO);
            }
        }
        //statsDTO.setDistanceCovered(statsDTO.getDistanceCovered() + p.getPlayerPosition().getDistanceCovered());
    }

    public void addDistanceCovered(List<PlayerPositionDTO> playerPositionDTOS) {
        for (PlayerPositionDTO p : playerPositionDTOS){
            StatsDTO statsDTO = getTeamStats(new TeamKey(p.getMatchId(), p.getTeamId()));
            statsDTO.setDistanceCovered(statsDTO.getDistanceCovered() + p.getDistanceCovered());
        }
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

    public void updateTeamHealth(List<PlayerHealthDTO> playerHealthDTOS){
        TeamKey teamKey = new TeamKey(playerHealthDTOS.getFirst().getMatchId(),playerHealthDTOS.getFirst().getTeamId());
        var teamHealthMesures = getTeamHealthMesures(teamKey);
        for (PlayerHealthDTO p : playerHealthDTOS){
            updatePlayerHealth(p);
            teamHealthMesures.allHeartRates.add(p.getHeartRate());
            teamHealthMesures.allStamina.add(p.getStamina());
            teamHealthMesures.allTemperatues.add(p.getTemperature());
        }
        teamHealthMesures.teamHealthStatsDTO.setPlayerHealthStatsDTOList(playerHealthDTOS.stream().map(p -> getPlayerHealthStats(new PlayerKey(p.getMatchId(), p.getPlayerId()))).toList());
        teamHealthMesures.teamHealthStatsDTO.setAvgTemperature(teamHealthMesures.allTemperatues.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
        teamHealthMesures.teamHealthStatsDTO.setAvgHeartRate(teamHealthMesures.allHeartRates.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        teamHealthMesures.teamHealthStatsDTO.setAvgStamina(teamHealthMesures.allStamina.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
        teamHealthMesures.allStamina.clear();
        teamHealthMesures.allHeartRates.clear();
        teamHealthMesures.allTemperatues.clear();

    }

    public TeamHealthStatsDTO getTeamHealthStats(TeamKey teamKey){
        return getTeamHealthMesures(teamKey).teamHealthStatsDTO;
    }

    public void updatePlayerHealth(PlayerHealthDTO playerHealthDTO){
        PlayerKey playerKey = new PlayerKey(playerHealthDTO.getMatchId(), playerHealthDTO.getPlayerId());
        HealthMesures healthMesures = getHealthMesures(playerKey);
        Integer heartRate = playerHealthDTO.getHeartRate();
        Double stamina = playerHealthDTO.getStamina();
        Double temperature = playerHealthDTO.getTemperature();

        PlayerHealthStatsDTO healthStatsDTO = healthMesures.playerHealthStatsDTO;

        healthStatsDTO.setCurrentStamina(stamina);
        healthStatsDTO.setCurrentHeartRate(heartRate);
        healthStatsDTO.setCurrentTemperature(temperature);

        healthMesures.allHeartRates.add(heartRate);
        healthMesures.allTemperatues.add(temperature);

        var heartRateStats = healthMesures.allHeartRates.stream().mapToInt(Integer::intValue).summaryStatistics();
        var temperatureStats = healthMesures.allTemperatues.stream().mapToDouble(Double::doubleValue).summaryStatistics();

        healthStatsDTO.setAvgHeartRate(heartRateStats.getCount() > 0 ? heartRateStats.getAverage() : 0.0);
        healthStatsDTO.setMinHeartRate(heartRateStats.getCount() > 0 ? heartRateStats.getMin() : 0);
        healthStatsDTO.setMaxHeartRate(heartRateStats.getCount() > 0 ? heartRateStats.getMax() : 0);

        healthStatsDTO.setAvgTemperature(temperatureStats.getCount() > 0 ? temperatureStats.getAverage() : 0.0);
        healthStatsDTO.setMinTemperature(temperatureStats.getCount() > 0 ? temperatureStats.getMin() : 0.0);
        healthStatsDTO.setMaxTemperature(temperatureStats.getCount() > 0 ? temperatureStats.getMax() : 0.0);

    }

    public PlayerHealthStatsDTO getPlayerHealthStats(PlayerKey playerKey){
        return getHealthMesures(playerKey).playerHealthStatsDTO;
    }

    private HealthMesures getHealthMesures(PlayerKey playerKey){
        if (!playerHealthStats.containsKey(playerKey)) {
            PlayerHealthStatsDTO playerHealthStatsDTO = new PlayerHealthStatsDTO();
            playerHealthStatsDTO.setMatchId(playerKey.matchId());
            playerHealthStatsDTO.setPlayerId(playerKey.playerId());
            playerHealthStats.put(playerKey, new HealthMesures(playerHealthStatsDTO, new ArrayList<>(), new ArrayList<>()));
        }
        return playerHealthStats.get(playerKey);
    }
    private TeamHealthMesures getTeamHealthMesures(TeamKey teamKey){
        if (!teamHealthStats.containsKey(teamKey)) {
            TeamHealthStatsDTO teamHealthStatsDTO = new TeamHealthStatsDTO();
            teamHealthStatsDTO.setMatchId(teamKey.matchId());
            teamHealthStatsDTO.setTeamId(teamKey.teamId());
            teamHealthStats.put(teamKey, new TeamHealthMesures(teamHealthStatsDTO, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        }
        return teamHealthStats.get(teamKey);
    }


    public record HealthMesures(PlayerHealthStatsDTO playerHealthStatsDTO, List<Integer> allHeartRates, List<Double> allTemperatues){}
    public record TeamHealthMesures(TeamHealthStatsDTO teamHealthStatsDTO, List<Integer> allHeartRates, List<Double> allTemperatues, List<Double> allStamina){}
}
