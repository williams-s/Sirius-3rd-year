package club.manager.entrance_cockpit.infrastructure.controller;


import club.manager.common_library.dto.PlayerTeamInfoDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.application.service.MatchService;
import club.manager.entrance_cockpit.application.service.PlayerBelongsTeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mock")
@RequiredArgsConstructor
@Slf4j
public class MockController {

    private final PlayerBelongsTeamService playerBelongsTeamService;
    private final MatchService matchService;

    @GetMapping("playerBelongsTeam/{teamId}")
    public ResponseEntity<List<PlayerTeamInfoDTO>> getPlayerIdPositionTeamId(@PathVariable Long teamId){
        List<PlayerTeamInfoDTO> playerTeamInfoDTOS = playerBelongsTeamService.getPlayerIdPositionTeamId(teamId);
        if (playerTeamInfoDTOS == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(playerTeamInfoDTOS);
    }

    @GetMapping("match/{matchId}/teams")
    public ResponseEntity<List<TeamResponseDTO>> getTeams(@PathVariable Long matchId){
        List<TeamResponseDTO> teamResponseDTOs = matchService.getTeamsFromMatch(matchId);
        if (teamResponseDTOs == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(teamResponseDTOs);
    }

    @GetMapping("match/{matchId}/team/{teamId}/side")
    public ResponseEntity<String> getTeamSide(@PathVariable Long matchId,
                                              @PathVariable Long teamId) {

        String side = matchService.findTeamSide(matchId, teamId);

        if (side == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(side);
    }
}
