package club.manager.common_library.dto;

import club.manager.common_library.parentDTO.GenericDTO;
import club.manager.common_library.utils.Coordinates.Coordinates3D;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BallEventDTO {

    private Long matchId;

    private Double speed;

    private Coordinates3D ballCoordinates;


}
