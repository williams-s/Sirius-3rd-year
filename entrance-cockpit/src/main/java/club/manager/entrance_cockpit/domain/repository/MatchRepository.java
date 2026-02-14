package club.manager.entrance_cockpit.domain.repository;

import club.manager.entrance_cockpit.domain.entity.Match;
import club.manager.entrance_cockpit.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
