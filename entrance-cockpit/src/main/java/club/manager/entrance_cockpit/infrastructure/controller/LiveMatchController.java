package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.*;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.bridge.BallEventBridge;
import club.manager.entrance_cockpit.messaging.bridge.MatchSheetBridge;
import club.manager.entrance_cockpit.messaging.bridge.MatchStateBridge;
import club.manager.entrance_cockpit.messaging.bridge.PlayersPositionsBridge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{matchId}")
    public ResponseEntity<LiveMatchDTO> getLiveMatch(@PathVariable Long matchId) {
        if (liveMatchStateService.isMatchFinished(matchId))
            return ResponseEntity.notFound().build();

        List<PlayerPositionDTO> currentPositions = playersPositionsBridge.getCurrentPositions(matchId);
        MatchStateDTO currentMatchState = matchStateBridge.getCurrentMatchState(matchId);
        BallEventDTO currentBallEvent = ballEventBridge.getCurrentBallEvent(matchId);
        List<PlayerResponseDTO> matchSheet = matchSheetBridge.getMatchSheet(matchId);
        if (matchSheet == null || currentBallEvent == null || currentPositions == null || currentMatchState == null) {
            return ResponseEntity.notFound().build();
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