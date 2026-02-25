package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.*;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.application.service.MatchService;
import club.manager.entrance_cockpit.messaging.bridge.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.common.metrics.Stat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/live-match")
@RequiredArgsConstructor
@Slf4j
public class LiveMatchController {

    private final PlayersPositionsBridge playersPositionsBridge;
    private final MatchStateBridge matchStateBridge;
    private final BallEventBridge ballEventBridge;
    private final MatchSheetBridge matchSheetBridge;
    private final HeatMapPositionBridge heatMapPositionBridge;
    private final StatsBridge statsBridge;
    private final PlayerHealthStatsBridge playerHealthStatsBridge;
    private final TeamStatsBridge teamStatsBridge;
    private final TeamHealthStatsBridge teamHealthStatsBridge;

    private final LiveMatchStateService liveMatchStateService;
    private final ClubService clubService;
    private final MatchService matchService;

    @GetMapping("/{matchId}")
    public ResponseEntity<LiveMatchDTO> getLiveMatch(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<PlayerPositionDTO> currentPositions = playersPositionsBridge.getCurrentPositions(matchId);
        MatchStateDTO currentMatchState = matchStateBridge.getCurrentMatchState(matchId);
        BallEventDTO currentBallEvent = ballEventBridge.getCurrentBallEvent(matchId);
        List<PlayerResponseDTO> matchSheet = matchSheetBridge.getMatchSheet(matchId);
        if (matchSheet == null || currentBallEvent == null || currentPositions == null || currentMatchState == null) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }

        LiveMatchDTO liveMatchDTO = LiveMatchDTO.builder()
                .matchState(currentMatchState)
                .ballEvent(currentBallEvent)
                .playersPositions(currentPositions)
                .matchSheet(matchSheet)
                .build();

        log.debug("Sending live match infos for matchId {}",matchId);
        return ResponseEntity.ok(liveMatchDTO);
    }


    @GetMapping("/{matchId}/heatMap/{playerId}")
    public ResponseEntity<HeatMapPlayerDTO> getHeatMapPlayer(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId, @PathVariable Long playerId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<HeatMapPlayerDTO> currentHeatMap = heatMapPositionBridge.getCurrentHeatMap(matchId);
        if (currentHeatMap == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

        var requestedHeatMap = currentHeatMap.stream().filter(heatMap -> heatMap.playerId().equals(playerId)).toList().getFirst();
        if (requestedHeatMap == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(requestedHeatMap);
    }


    @GetMapping("/{matchId}/stats/{playerId}")
    public ResponseEntity<StatsDTO> getStatsPlayer(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId, @PathVariable Long playerId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<StatsDTO> currentStats = statsBridge.getCurrentStats(matchId);
        if (currentStats == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

        var requestedStats = currentStats.stream().filter(stats -> stats.getPlayerId().equals(playerId)).toList().getFirst();
        if (requestedStats == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(requestedStats);
    }

    @GetMapping("/{matchId}/playerHealthStats/{playerId}")
    public ResponseEntity<PlayerHealthStatsDTO> getPlayerHealthStats(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId, @PathVariable Long playerId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<PlayerHealthStatsDTO> currentStats = playerHealthStatsBridge.getCurrentPlayerHealthStats(matchId);
        if (currentStats == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

        var requestedStats = currentStats.stream().filter(stats -> stats.getPlayerId().equals(playerId)).toList().getFirst();
        if (requestedStats == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(requestedStats);
    }

    @GetMapping("/{matchId}/teamStats/{teamId}")
    public ResponseEntity<StatsDTO> getTeamStats(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId, @PathVariable Long teamId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<StatsDTO> currentStats = teamStatsBridge.getCurrentTeamStats(matchId);
        if (currentStats == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

        var requestedStats = currentStats.stream().filter(stats -> stats.getTeamId().equals(teamId)).toList().getFirst();
        if (requestedStats == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(requestedStats);
    }

    @GetMapping("/{matchId}/myTeam")
    public ResponseEntity<TeamResponseDTO> getMyTeam(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        var res = matchService.getTeamFromClubThatPlayMatch(club.clubId(), matchId);
        if (res.a == null)
            return ResponseEntity.status(res.b).build();
        return ResponseEntity.ok(res.a);
    }


    @GetMapping("/{matchId}/teamHealthStats/{teamId}")
    public ResponseEntity<TeamHealthStatsDTO> getTeamHealthStats(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId, @PathVariable Long teamId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.a == null)
            return ResponseEntity.status(isPlayedByClub.b).build();

        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.status(HttpStatus.GONE).build();

        List<TeamHealthStatsDTO> currentStats = teamHealthStatsBridge.getCurrentTeamHealthStats(matchId);
        if (currentStats == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

        var requestedStats = currentStats.stream().filter(stats -> stats.getTeamId().equals(teamId)).toList().getFirst();
        if (requestedStats == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(requestedStats);
    }


    @GetMapping("/me/all")
    public ResponseEntity<List<MatchResponseDTO>> getAllLiveMatches(
            @RequestHeader("X-Auth-Request-Email") String email)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        var res = matchService.getAllMatchesLive(club.clubId());
        if (res.a == null){
            return ResponseEntity.status(res.b).build();
        }
        return ResponseEntity.ok(res.a);
    }

}