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
    private Long playerId;

    private Long teamId;

    private Coordinates2D playerCoordinates;

    private Double distanceCovered;

    private Boolean hasBall;

    private PositionEnum position;
    
}
