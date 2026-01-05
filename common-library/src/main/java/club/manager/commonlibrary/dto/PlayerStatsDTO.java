package club.manager.commonlibrary.dto;

import club.manager.commonlibrary.enums.EventType;
import club.manager.commonlibrary.enums.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsDTO {
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

    private StatsDTO statsDTO;

}