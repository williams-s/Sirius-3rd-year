package club.manager.entrance_cockpit.domain.repository;

import club.manager.entrance_cockpit.domain.entity.Club;
import club.manager.entrance_cockpit.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,Long> {

    Optional<List<Team>> findAllByClub_ClubId(Long clubClubId);
}
