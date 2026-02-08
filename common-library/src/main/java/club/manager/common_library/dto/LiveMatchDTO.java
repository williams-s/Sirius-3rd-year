package club.manager.common_library.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record LiveMatchDTO(BallEventDTO ballEvent, List<PlayerPositionDTO> playersPositions, MatchStateDTO matchState) {}
