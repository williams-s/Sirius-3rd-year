package club.manager.common_library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHealthStatsDTO {

    private Long matchId;

    private Long playerId;

    private Integer maxHeartRate = 0;
    private Double maxTemperature = 0.0;

    private Integer minHeartRate = 0;
    private Double minTemperature = 0.0;

    private Double avgHeartRate = 0.0;
    private Double avgTemperature = 0.0;

    private Integer currentHeartRate = 0;
    private Double currentTemperature = 0.0;
    private Double currentStamina = 0.0;

}
