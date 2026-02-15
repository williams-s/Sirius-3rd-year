package club.manager.common_library.dto;

import club.manager.common_library.enums.PositionEnum;

public record PlayerTeamInfoDTO(Long playerId, Long teamId, PositionEnum position) {}
