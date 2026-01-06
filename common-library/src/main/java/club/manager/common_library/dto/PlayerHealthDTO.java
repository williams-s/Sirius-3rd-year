package club.manager.common_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHealthDTO {

    private String team;

    @JsonProperty("player_health")
    PlayerHealth playerHealth;

    private record PlayerHealth(@JsonProperty("heart_rate") Integer heartRate, Double stamina, Double temperature) {}
}
