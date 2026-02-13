package club.manager.entrance_cockpit.domain.repository;

import club.manager.entrance_cockpit.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
