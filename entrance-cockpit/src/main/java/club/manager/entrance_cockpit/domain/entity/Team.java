package club.manager.entrance_cockpit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "team")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team {

    @Id
    @Column(name = "id_team")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column(name = "name")
    private String name;

    @Column(name = "coach")
    private String coach;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "league")
    private String league;

    @ManyToOne
    @JoinColumn(name = "id_club")
    private Club club;

}