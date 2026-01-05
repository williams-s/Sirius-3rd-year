package club.manager.player_performance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

    private int goals;

    private int touches;
    private int passesSuccess;
    private int passes;
    // int crosses;
    private int shots;
    private int shotsOnTarget;
    private int tackles;
    private int tacklesSuccess;
    private int interceptions;
    private int duels;
    private int duelsWon;
    private int dribbles;
    private int dribblesSuccess;
    private int fouls;
    private int foulsDrawn;

    private int saves;
}
