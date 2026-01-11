package club.manager.common_library.dto;

import club.manager.common_library.enums.PositionEnum;
import club.manager.common_library.utils.Coordinates.Coordinates2D;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPositionDTO  {

    private String team;

    @JsonProperty("player_coordinates")
    private Coordinates2D playerCoordinates;

    @JsonProperty("distance_covered")
    private Double distanceCovered;

    @JsonProperty("has_ball")
    private Boolean hasBall;

    private PositionEnum position;
    
}
