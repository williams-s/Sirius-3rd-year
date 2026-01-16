package club.manager.common_library.dto;

import club.manager.common_library.enums.EventTypeEnum;
import club.manager.common_library.parentDTO.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchEventDTO {

    private Long matchId;

    //private String team;

    //@JsonProperty("player_id")
    private Long playerId;

    //@JsonProperty("team_id")
    private Long teamId;

    //@JsonProperty("event_type")
    private EventTypeEnum eventType;

    private boolean ballTouched;

}
