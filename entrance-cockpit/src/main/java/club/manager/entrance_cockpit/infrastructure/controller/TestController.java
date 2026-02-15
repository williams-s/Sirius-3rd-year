package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.PlayerAttributesDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.MatchService;
import club.manager.entrance_cockpit.application.service.PlayerService;
import club.manager.entrance_cockpit.application.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final MatchService matchService;
    private final TeamService teamService;
    private final ClubService clubService;
    private final PlayerService playerService;

    @GetMapping("match/all/{teamId}")
    public ResponseEntity<List<MatchResponseDTO>> getMatchesTest(@PathVariable Long teamId){
        var test = matchService.getMatches(teamId);
        if (test == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(test);
    }

    @GetMapping("team/{clubId}")
    public ResponseEntity<List<TeamResponseDTO>> getMyTeamsTest(@PathVariable Long clubId){
        List<TeamResponseDTO> teamResponseDTOS = teamService.getAllTeamsFromClub(clubId);
        if (teamResponseDTOS != null)
            return ResponseEntity.ok(teamResponseDTOS);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("player/all/{teamId}")
    public ResponseEntity<List<PlayerAttributesDTO>> getMyPlayers(@PathVariable Long teamId){
        List<PlayerAttributesDTO> players = playerService.getAllPlayersAttributesFromTeam(teamId);
        if (players != null)
            return ResponseEntity.ok(players);
        return ResponseEntity.notFound().build();
    }
}
