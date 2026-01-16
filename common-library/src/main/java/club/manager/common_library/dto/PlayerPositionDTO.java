package club.manager.common_library.dto;

import club.manager.common_library.enums.PositionEnum;
import club.manager.common_library.parentDTO.GenericDTO;
import club.manager.common_library.utils.Coordinates.Coordinates2D;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPositionDTO {

    private Long matchId;

    //private String team;
    //@JsonProperty("player_id")
    private Long playerId;

    //@JsonProperty("team_id")
    private Long teamId;

    //@JsonProperty("player_coordinates")
    private Coordinates2D playerCoordinates;

    //@JsonProperty("distance_covered")
    private Double distanceCovered;

    //@JsonProperty("has_ball")
    private Boolean hasBall;

    private PositionEnum position;
    
}
