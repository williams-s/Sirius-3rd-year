package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.PlayerAttributesDTO;
import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.entrance_cockpit.application.mapper.PlayerAttributesMapper;
import club.manager.entrance_cockpit.application.mapper.PlayerMapper;
import club.manager.entrance_cockpit.domain.entity.Player;
import club.manager.entrance_cockpit.domain.repository.PlayerBelongsTeamRepository;
import club.manager.entrance_cockpit.domain.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerBelongsTeamRepository playerBelongsTeamRepository;
    private final PlayerMapper playerMapper;
    private final PlayerAttributesMapper playerAttributesMapper;
    public PlayerResponseDTO getPlayerById(Long playerId){
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()){
            log.debug("getting player {}",playerId);
            return playerMapper.toDTO(player.get());
        }
        return null;
    }

    public List<PlayerAttributesDTO> getAllPlayersAttributesFromTeam(Long teamId){
         var playersTeam = playerBelongsTeamRepository.findAllByTeam_TeamId(teamId);
         if (playersTeam.isPresent()){
             var allPlayersAttributes = playersTeam.get().stream().map(p ->p.getPlayer());
             return allPlayersAttributes.map(playerAttributesMapper::toDTO).toList();
         }
         return null;
    }
}
