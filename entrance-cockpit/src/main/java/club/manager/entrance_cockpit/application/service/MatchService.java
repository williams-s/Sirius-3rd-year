package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.TeamResponseDTO;
import club.manager.entrance_cockpit.application.mapper.MatchMapper;
import club.manager.entrance_cockpit.domain.entity.Club;
import club.manager.entrance_cockpit.domain.entity.Match;
import club.manager.entrance_cockpit.domain.entity.Team;
import club.manager.entrance_cockpit.domain.repository.ClubRepository;
import club.manager.entrance_cockpit.domain.repository.MatchRepository;
import club.manager.entrance_cockpit.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    public MatchResponseDTO getMatch(Long matchId){
        Optional<Match> match = matchRepository.findById(matchId);
        if (match.isPresent()){
            return matchMapper.toDTO(match.get());
        }
        return null;
    }

    public List<MatchResponseDTO> getMatchesFromClub(Long clubId){
        Optional<List<Match>> matches = matchRepository.findMatchesByClubId(clubId);
        return matches.map(list -> list.stream().map(matchMapper::toDTO).toList()).orElse(null);
    }

    public List<MatchResponseDTO> getMatches(Long teamId){
        Optional<List<Match>> matches = matchRepository.findMatchesByTeamId(teamId);
        return matches.map(list -> list.stream().map(matchMapper::toDTO).toList()).orElse(null);
    }

    public List<TeamResponseDTO> getTeamsFromMatch(Long matchId){
        MatchResponseDTO match = getMatch(matchId);
        if (match != null){
            TeamResponseDTO homeTeam = match.getHomeTeam();
            TeamResponseDTO awayTeam = match.getAwayTeam();
            return List.of(homeTeam,awayTeam);
        }
        return null;
    }

    public Pair<MatchResponseDTO, HttpStatus> isMatchPlayedByThisClub(Long clubId, Long matchId){
        var allMatches = getMatchesFromClub(clubId);
        if (allMatches != null) {
            Optional<MatchResponseDTO> matchResponseDTO = allMatches.stream().filter(m -> m.getIdMatch().equals(matchId)).findFirst();
            if (matchResponseDTO.isPresent())
                return new Pair<>(matchResponseDTO.get(),HttpStatus.OK);
            return new Pair<>(null,HttpStatus.FORBIDDEN);
        }
        return new Pair<>(null,HttpStatus.NOT_FOUND);
    }
}


