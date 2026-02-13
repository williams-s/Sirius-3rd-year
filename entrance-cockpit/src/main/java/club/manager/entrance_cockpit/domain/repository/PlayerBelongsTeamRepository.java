package club.manager.entrance_cockpit.domain.repository;

import club.manager.common_library.keys.PlayerBelongsTeamId;
import club.manager.entrance_cockpit.domain.entity.PlayerBelongsTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerBelongsTeamRepository extends JpaRepository<PlayerBelongsTeam, PlayerBelongsTeamId> {

    List<PlayerBelongsTeam> findAllByTeam_TeamId(Long teamId);

    PlayerBelongsTeam findByPlayer_PlayerIdAndTeam_TeamId(Long playerId, Long teamId);

    PlayerBelongsTeam findByPlayer_PlayerId(Long playerId);
}