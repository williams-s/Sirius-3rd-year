package club.manager.player_performance.model;

import club.manager.player_performance.enums.EventType;
import club.manager.player_performance.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @JsonProperty("match_id")
    private Long matchId;

    @JsonProperty("player_id")
    private Long playerId;

    private String team;
    private String timestamp;
    private Double x;
    private Double y;

    @JsonProperty("distance_covered")
    private Double distanceCovered;

    @JsonProperty("has_ball")
    private Boolean hasBall;

    private Double stamina;

    @JsonProperty("heart_rate")
    private Integer heartRate;

    private Double temperature;

    @JsonProperty("event_type")
    private EventType eventType;

    private Position position;

    private Stats stats;

}