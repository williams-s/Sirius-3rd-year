package club.manager.entrance_cockpit.application.mapper;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.entrance_cockpit.domain.entity.Club;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {
    public ClubResponseDTO toDTO(Club club){
        return ClubResponseDTO.builder()
                .clubId(club.getClubId())
                .name(club.getName())
                .president(club.getPresident())
            .build();
    }
}
