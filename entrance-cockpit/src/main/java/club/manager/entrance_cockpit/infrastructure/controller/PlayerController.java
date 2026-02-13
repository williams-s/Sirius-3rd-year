package club.manager.entrance_cockpit.infrastructure.controller;

import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.entrance_cockpit.application.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerResponseDTO> getPlayer(@PathVariable Long playerId){
        PlayerResponseDTO playerResponseDTO = playerService.getPlayerById(playerId);
        if (playerResponseDTO != null){
            return ResponseEntity.ok(playerResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
