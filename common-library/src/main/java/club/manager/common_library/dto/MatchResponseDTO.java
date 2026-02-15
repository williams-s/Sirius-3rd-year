package club.manager.common_library.dto;

import club.manager.common_library.enums.MatchStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDTO {
    private Long idMatch;
    private TeamResponseDTO homeTeam;
    private TeamResponseDTO awayTeam;
    private Short homeScore;
    private Short awayScore;
    private LocalDateTime date;
    private MatchStatusEnum status;
    private String competition;
    private String season;
    private String matchDay;
}
