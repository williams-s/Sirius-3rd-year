package club.manager.common_library.dto;

import lombok.Builder;

@Builder
public record ClubResponseDTO(Long clubId, String name, String president) {
}
