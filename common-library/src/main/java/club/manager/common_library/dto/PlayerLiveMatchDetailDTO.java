package club.manager.common_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerLiveMatchDetailDTO extends GenericDTO {

    @JsonProperty("player_id")
    private Long playerId;

    @JsonProperty("player_position_data")
    private PlayerPositionDTO playerPosition;

    @JsonProperty("player_health_data")
    private PlayerHealthDTO playerHealth;

    @JsonProperty("match_event_data")
    private MatchEventDTO matchEvent;

    private StatsDTO statsDTO;
}