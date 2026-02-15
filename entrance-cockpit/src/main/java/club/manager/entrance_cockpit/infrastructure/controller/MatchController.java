package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.common_library.enums.MatchStatusEnum;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.MatchService;
import club.manager.entrance_cockpit.application.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
@Slf4j
public class MatchController {

    private final MatchService matchService;
    private final TeamService teamService;
    private final ClubService clubService;

    @GetMapping("/{teamId}/all")
    public ResponseEntity<List<MatchResponseDTO>> getMatches(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long teamId)
    {
        var club = clubService.getClub(email);
        if (club != null) {
            if (teamService.isTeamBelongsToClub(club.clubId(), teamId)) {
                List<MatchResponseDTO> matchResponseDTOS = matchService.getMatches(teamId);
                if (matchResponseDTOS != null)
                    return ResponseEntity.ok(matchResponseDTOS);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{matchId}")
    public ResponseEntity<MatchResponseDTO> getMatch(@PathVariable Long matchId){
        MatchResponseDTO matchResponseDTO = matchService.getMatch(matchId);
        if (matchResponseDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(matchResponseDTO);
    }

    @GetMapping("/{matchId}/teams")
    public ResponseEntity<List<TeamResponseDTO>> getTeams(@PathVariable Long matchId){
        List<TeamResponseDTO> teamResponseDTOs = matchService.getTeamsFromMatch(matchId);
        if (teamResponseDTOs == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(teamResponseDTOs);
    }

}
