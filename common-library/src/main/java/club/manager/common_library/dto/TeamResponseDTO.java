package club.manager.common_library.dto;

import lombok.Builder;

@Builder
public record TeamResponseDTO(Long teamId, String name, String coach, String stadium, String league, ClubResponseDTO club){

}
