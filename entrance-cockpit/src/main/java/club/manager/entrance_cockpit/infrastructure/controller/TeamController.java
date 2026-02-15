package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.application.service.ClubService;
import club.manager.entrance_cockpit.application.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;
    private final ClubService clubService;
    @GetMapping("/me")
    public ResponseEntity<List<TeamResponseDTO>> getMyTeams(
            @RequestHeader("X-Auth-Request-Email") String email) {
        ClubResponseDTO clubResponseDTO = clubService.getClub(email);
        if (clubResponseDTO != null){
            List<TeamResponseDTO> teamResponseDTOS = teamService.getAllTeamsFromClub(clubResponseDTO.clubId());
            if (teamResponseDTOS != null)
                return ResponseEntity.ok(teamResponseDTOS);
        }
        return ResponseEntity.notFound().build();
    }

}
