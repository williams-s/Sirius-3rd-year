package club.manager.entrance_cockpit.domain.entity;

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
    private club.manager.common_library.enums.MatchStatusEnum status;
    private String competition;

}
