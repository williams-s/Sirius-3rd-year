package club.manager.common_library.dto;

import club.manager.common_library.parentDTO.GenericDTO;
import club.manager.common_library.parentDTO.PlayerParentDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHealthDTO {

    private Long matchId;

    //@JsonProperty("player_id")
    private Long playerId;

    //@JsonProperty("team_id")
    private Long teamId;

    //private String team;

    //@JsonProperty("player_health")
    //private PlayerHealthInformation playerHealth;

    //private record PlayerHealthInformation(@JsonProperty("heart_rate") Integer heartRate, Double stamina, Double temperature) {}

    //@JsonProperty("heart_rate")
    private Integer heartRate;

    private Double stamina;

    private Double temperature;

}
