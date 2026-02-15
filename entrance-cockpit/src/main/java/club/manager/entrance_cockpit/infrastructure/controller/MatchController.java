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
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


    @GetMapping("/{matchId}")
    public ResponseEntity<MatchResponseDTO> getMatch(
            @RequestHeader("X-Auth-Request-Email") String email,
            @PathVariable Long matchId)
    {
        var club = clubService.getClub(email);
        if (club == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pair<MatchResponseDTO, HttpStatus> isPlayedByClub = matchService.isMatchPlayedByThisClub(club.clubId(),matchId);
        if (isPlayedByClub.b == HttpStatus.OK)
            return ResponseEntity.ok(isPlayedByClub.a);
        return ResponseEntity.status(isPlayedByClub.b).build();
    }


}
