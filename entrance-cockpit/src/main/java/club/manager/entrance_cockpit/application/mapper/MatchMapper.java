package club.manager.entrance_cockpit.application.mapper;

import club.manager.entrance_cockpit.application.dto.MatchResponseDto;
import club.manager.entrance_cockpit.domain.entity.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public MatchResponseDto toDto(Match match) {
        return MatchResponseDto.builder()
                .idMatch(match.getIdMatch())
                .homeTeam(match.getHomeTeam())
                .awayTeam(match.getAwayTeam())
                .homeScore(match.getHomeScore())
                .awayScore(match.getAwayScore())
                .date(match.getDate())
                .status(match.getStatus())
                .competition(match.getCompetition())
                .build();
    }
}
