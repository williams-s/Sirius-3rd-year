package club.manager.entrance_cockpit.application.mapper;

import club.manager.common_library.dto.PlayerAttributesDTO;
import club.manager.entrance_cockpit.domain.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerAttributesMapper {

    public PlayerAttributesDTO toDTO(Player player){
        return PlayerAttributesDTO.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .firstName(player.getFirstName())
                .birthDate(player.getBirthDate())
                .height(player.getHeight())
                .weight(player.getWeight())
                .strongFoot(player.getStrongFoot())
                .nationality(player.getNationality())
                .position(player.getPosition())
                .build();
    }
}
