package club.manager.common_library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamHealthStatsDTO {
    private Long matchId;

    private Long teamId;

    private Double avgHeartRate = 0.0;
    private Double avgTemperature = 0.0;
    private Double avgStamina = 0.0;

    private List<PlayerHealthStatsDTO> playerHealthStatsDTOList;
}
