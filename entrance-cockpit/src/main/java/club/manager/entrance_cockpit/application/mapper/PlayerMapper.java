package club.manager.entrance_cockpit.application.mapper;

import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.entrance_cockpit.application.service.PlayerBelongsTeamService;
import club.manager.entrance_cockpit.domain.entity.Player;
import club.manager.entrance_cockpit.domain.entity.PlayerBelongsTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapper {

    private final PlayerBelongsTeamService playerBelongsTeamService;

    public PlayerResponseDTO toDTO(Player player){
        PlayerBelongsTeam playerTeam = playerBelongsTeamService.getPlayerByPlayerId(player.getPlayerId());
        return PlayerResponseDTO.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .firstName(player.getFirstName())
                .teamId(playerTeam.getTeam().getTeamId())
                .shirtNumber(playerTeam.getId().shirtNumber())
            .build();
    }
}
