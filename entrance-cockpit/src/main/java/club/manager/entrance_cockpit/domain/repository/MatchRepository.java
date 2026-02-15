package club.manager.entrance_cockpit.domain.repository;

import club.manager.entrance_cockpit.domain.entity.Match;
import club.manager.entrance_cockpit.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT match.* FROM match " +
            "JOIN team ON match.id_team_away = team.id_team " +
            "OR match.id_team_home = team.id_team " +
            "JOIN club ON team.id_club = club.id_club " +
            "WHERE club.id_club = :clubId ORDER BY match.date_time", nativeQuery = true)
    Optional<List<Match>> findMatchesByClubId(@Param("clubId") Long clubId);

    @Query(value = "SELECT match.* FROM match " +
            "JOIN team on match.id_team_away = team.id_team or match.id_team_home = team.id_team " +
            "where team.id_team = :teamId ORDER BY match.date_time", nativeQuery = true)
    Optional<List<Match>> findMatchesByTeamId(@Param("teamId") Long teamId);
}


