package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.common_library.enums.MatchStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
@Slf4j
public class MatchController {

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchResponseDTO> getMatch(@PathVariable Long matchId){
        var teams = randomTeams();
        MatchResponseDTO matchResponseDTO =  MatchResponseDTO.builder()
                .idMatch(matchId)
                .homeTeam(teams.getFirst())
                .awayTeam(teams.getLast())
                .homeScore((short) 0)
                .awayScore((short) 0)
                .date(LocalDateTime.now())
                .status(MatchStatusEnum.SCHEDULED)
                .competition("Ligue1")
            .build();
        return ResponseEntity.ok(matchResponseDTO);
    }

    private List<TeamResponseDTO> randomTeams(){
        return List.of(
                TeamResponseDTO.builder().teamId(1L).name("PSG").coach("Enrique").stadium("Le parc").league("Ligue1")
                    .club(generateClub(1L,"Paris saint germain","Nasser"))
                    .build(),
                TeamResponseDTO.builder().teamId(2L).name("OM").coach("De Zerbi").stadium("Veledrome").league("Ligue1")
                        .club(generateClub(2L,"Olympique de Marseille", "Longoria"))
                        .build()
        );
    }

    private ClubResponseDTO generateClub(Long clubId, String name, String president){
        return ClubResponseDTO.builder()
                .clubId(clubId)
                .name(name)
                .president(president)
                .build();
    }
}
