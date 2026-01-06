package club.manager.common_library.dto;

import club.manager.common_library.enums.Position;
import club.manager.common_library.utils.Coordinates;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPositionDTO  {

    private String team;

    @JsonProperty("player_coordinates")
    private Coordinates.Coordinates2D playerCoordinates;

    @JsonProperty("distance_covered")
    private Double distanceCovered;

    @JsonProperty("has_ball")
    private Boolean hasBall;

    private Position position;
    
}
