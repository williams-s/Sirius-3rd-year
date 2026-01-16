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

    //@JsonProperty("player_id")
    private Long playerId;

    //@JsonProperty("team_id")
    private Long teamId;

    @JsonProperty("player_position_data")
    private PlayerPositionDTO playerPosition;

    @JsonProperty("player_health_data")
    private PlayerHealthDTO playerHealth;

    @JsonProperty("match_event_data")
    private MatchEventDTO matchEvent;

    private StatsDTO statsDTO;
}