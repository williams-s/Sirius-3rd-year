package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.*;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.application.service.MatchService;
import club.manager.entrance_cockpit.messaging.bridge.BallEventBridge;
import club.manager.entrance_cockpit.messaging.bridge.MatchSheetBridge;
import club.manager.entrance_cockpit.messaging.bridge.MatchStateBridge;
import club.manager.entrance_cockpit.messaging.bridge.PlayersPositionsBridge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Pair;
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
}