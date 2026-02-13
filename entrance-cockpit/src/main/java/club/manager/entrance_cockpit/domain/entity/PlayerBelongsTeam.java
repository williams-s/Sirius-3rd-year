package club.manager.entrance_cockpit.domain.entity;

import club.manager.common_library.keys.PlayerBelongsTeamId;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "player_belongs_team")
public class PlayerBelongsTeam {

    @EmbeddedId
    private PlayerBelongsTeamId id;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

    @ManyToOne
    @MapsId("teamId")
    @JoinColumn(name = "id_team")
    private Team team;


}