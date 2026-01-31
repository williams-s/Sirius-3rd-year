package club.manager.entrance_cockpit.application.dto;

import club.manager.entrance_cockpit.domain.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
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
    private MatchStatus status;
    private String competition;
}
