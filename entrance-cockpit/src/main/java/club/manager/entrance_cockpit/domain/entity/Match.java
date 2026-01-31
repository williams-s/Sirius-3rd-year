package club.manager.entrance_cockpit.domain.entity;

import club.manager.entrance_cockpit.domain.enums.MatchStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
//@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Match {

    //@Id
    private Long idMatch;
    private String homeTeam;
    private String awayTeam;
    private Short homeScore;
    private Short awayScore;
    private LocalDateTime date;
    private MatchStatus status;
    private String competition;

}
