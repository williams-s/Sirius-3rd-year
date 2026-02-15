package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.PlayerAttributesDTO;
import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.PlayerService;
import club.manager.entrance_cockpit.application.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final ClubService clubService;
    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerResponseDTO> getPlayer(@PathVariable Long playerId) {
        PlayerResponseDTO playerResponseDTO = playerService.getPlayerById(playerId);
        if (playerResponseDTO != null) {
            return ResponseEntity.ok(playerResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{teamId}/all")
    public ResponseEntity<List<PlayerAttributesDTO>> getPlayersFromTeam(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long teamId)
    {
        var club = clubService.getClub(email);
        if (club != null){
            if (teamService.isTeamBelongsToClub(club.clubId(),teamId)){
                List<PlayerAttributesDTO> players = playerService.getAllPlayersAttributesFromTeam(teamId);
                if (players != null)
                    return ResponseEntity.ok(players);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
