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
public class MatchResponseDto {
    private Long idMatch;
    private String homeTeam;
    private String awayTeam;
    private Short homeScore;
    private Short awayScore;
    private LocalDateTime date;
    private MatchStatusEnum status;
    private String competition;
}
