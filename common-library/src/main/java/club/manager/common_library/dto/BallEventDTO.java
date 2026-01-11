package club.manager.common_library.dto;

import club.manager.common_library.utils.Coordinates.Coordinates3D;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BallEventDTO extends GenericDTO {

    private Double speed;

    @JsonProperty("ball_coordinates")
    private Coordinates3D ballCoordinates;

}
