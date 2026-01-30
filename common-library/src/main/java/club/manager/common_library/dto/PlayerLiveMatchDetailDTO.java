package club.manager.common_library.dto;

import club.manager.common_library.parentDTO.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerLiveMatchDetailDTO{

    private Long matchId;

    private Long playerId;

    private Long teamId;

    @JsonProperty("player_position_data")
    private PlayerPositionDTO playerPosition;

    @JsonProperty("player_health_data")
    private PlayerHealthDTO playerHealth;

    @JsonProperty("match_event_data")
    private MatchEventDTO matchEvent;

    private StatsDTO statsDTO;
}