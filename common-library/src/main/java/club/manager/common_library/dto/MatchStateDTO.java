package club.manager.common_library.dto;

import club.manager.common_library.enums.MatchStateEnum;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchStateDTO {

    private Long matchId;

    private MatchStateEnum matchStateEnum;

    private Double matchTime;

    private Score score;

    private record Score(TeamScoreDTO homeTeam, TeamScoreDTO awayTeam) {}
}
