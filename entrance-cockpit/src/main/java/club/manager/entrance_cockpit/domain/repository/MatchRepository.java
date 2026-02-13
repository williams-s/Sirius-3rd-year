package club.manager.entrance_cockpit.domain.repository;

import club.manager.entrance_cockpit.domain.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
