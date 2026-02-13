package club.manager.entrance_cockpit.application.service;

import club.manager.entrance_cockpit.domain.entity.PlayerBelongsTeam;
import club.manager.entrance_cockpit.domain.repository.PlayerBelongsTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerBelongsTeamService {

    private final PlayerBelongsTeamRepository playerBelongsTeamRepository;

    public PlayerBelongsTeam getPlayerByPlayerId(Long playerId){
        return playerBelongsTeamRepository.findByPlayer_PlayerId(playerId);
    }
}
