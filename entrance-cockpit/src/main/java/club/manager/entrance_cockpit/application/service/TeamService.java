package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.PlayerAttributesDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.application.mapper.TeamMapper;
import club.manager.entrance_cockpit.domain.entity.Team;
import club.manager.entrance_cockpit.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    public List<TeamResponseDTO> getAllTeamsFromClub(Long clubId){
        return teamRepository.findAllByClub_ClubId(clubId).map(list -> list.stream().map(teamMapper::toDTO).toList()).orElse(null);
    }

    public boolean isTeamBelongsToClub(Long clubId, Long teamId){
        var teams = getAllTeamsFromClub(clubId);
        if (teams != null){
            List<Long> teamIds = teams.stream().map(t -> t.teamId()).toList();
            return teamIds.contains(teamId);
        }
        return false;
    }
}
