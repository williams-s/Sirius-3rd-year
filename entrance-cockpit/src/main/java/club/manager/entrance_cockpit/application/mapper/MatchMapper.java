package club.manager.entrance_cockpit.application.mapper;

import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.entrance_cockpit.domain.entity.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchMapper {

    private final TeamMapper teamMapper;

    public MatchResponseDTO toDTO(Match match) {
        return MatchResponseDTO.builder()
                .idMatch(match.getMatchId())
                .homeTeam(teamMapper.toDTO(match.getTeamHome()))
                .awayTeam(teamMapper.toDTO(match.getTeamAway()))
                .homeScore(match.getScoreHome())
                .awayScore(match.getScoreAway())
                .date(match.getDateTime())
                .status(match.getStatus())
                .competition(match.getCompetition())
                .season(match.getSeason()).matchDay(match.getMatchDay())
                .build();
    }
}
