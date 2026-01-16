package club.manager.common_library.dto;

import club.manager.common_library.enums.MatchEventEnum;
import club.manager.common_library.parentDTO.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchStateDTO {

    private Long matchId;

    private Long teamId;

    private MatchEventEnum matchEvent;

    private Double matchTime;

    private String team;

    private Score score;

    private record Score(TeamScoreDTO homeTeam, TeamScoreDTO awayTeam) {}
}
