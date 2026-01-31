package club.manager.common_library.parentDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerParentDTO {

    private Long matchId;
    private String timestamp;

    //@JsonProperty("player_id")
    private Long playerId;

    //@JsonProperty("team_id")
    private Long teamId;
}
