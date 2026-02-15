package club.manager.entrance_cockpit.application.mapper;

import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.domain.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final ClubMapper clubMapper;
    public TeamResponseDTO toDTO(Team team){
        return TeamResponseDTO.builder()
                .teamId(team.getTeamId())
                .name(team.getName())
                .coach(team.getCoach())
                .stadium(team.getStadium())
                .club(clubMapper.toDTO(team.getClub()))
                .league(team.getLeague())
                .build();
    }
}
