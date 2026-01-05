package club.manager.commonlibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsDTO {

    private Integer goals = 0;
    private Integer assists = 0;
    private Integer touches = 0;
    private Integer passesSuccess = 0;
    private Integer passes = 0;
    // Integer crosses;
    private Integer shots = 0;
    private Integer shotsOnTarget = 0;
    private Integer tackles = 0;
    private Integer tacklesSuccess = 0;
    private Integer interceptions = 0;
    private Integer duels = 0;
    private Integer duelsWon = 0;
    private Integer dribbles = 0;
    private Integer dribblesSuccess = 0;
    private Integer fouls = 0;
    private Integer foulsDrawn = 0;

    private Double distanceCovered = 0.0;

    private Integer saves = 0;
}
