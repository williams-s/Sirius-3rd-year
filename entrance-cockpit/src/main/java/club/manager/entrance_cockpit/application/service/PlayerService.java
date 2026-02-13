package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.entrance_cockpit.application.mapper.PlayerMapper;
import club.manager.entrance_cockpit.domain.entity.Player;
import club.manager.entrance_cockpit.domain.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    public PlayerResponseDTO getPlayerById(Long playerId){
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()){
            log.debug("getting player {}",playerId);
            return playerMapper.toDTO(player.get());
        }
        return null;
    }
}
