package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.PlayerTeamInfoDTO;
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
@RequestMapping("/api/playerBelongsTeam")
@RequiredArgsConstructor
@Slf4j
public class PlayerBelongsTeamController {

    private final PlayerBelongsTeamService playerBelongsTeamService;

    @GetMapping("/{teamId}")
    public ResponseEntity<List<PlayerTeamInfoDTO>> getPlayerIdPositionTeamId(@PathVariable Long teamId){
        List<PlayerTeamInfoDTO> playerTeamInfoDTOS = playerBelongsTeamService.getPlayerIdPositionTeamId(teamId);
        if (playerTeamInfoDTOS == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(playerTeamInfoDTOS);
    }
}
