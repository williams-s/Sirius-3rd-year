package club.manager.common_library.dto;

import club.manager.common_library.enums.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAttributesDTO {
    private Long playerId;
    private String name;
    private String firstName;
    private Date birthDate;
    private float height;
    private float weight;
    private String strongFoot;
    private String nationality;
    private PositionEnum position;
}
