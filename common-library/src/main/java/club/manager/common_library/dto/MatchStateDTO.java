package club.manager.common_library.dto;

import club.manager.common_library.enums.MatchEventEnum;
import club.manager.common_library.parentDTO.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MatchStateDTO extends GenericDTO {

    @JsonProperty("match_event")
    private MatchEventEnum matchEvent;

    @JsonProperty("match_time")
    private Double matchTime;

    private String team;

    private Score score;

    private record Score(TeamScoreDTO homeTeam, TeamScoreDTO awayTeam) {}
}
