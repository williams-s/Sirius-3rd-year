package club.manager.entrance_cockpit.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import club.manager.common_library.enums.MatchStatusEnum;
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Data
@Table(name = "match")
public class Match {

    @Id
    @Column(name = "id_match")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @ManyToOne
    @JoinColumn(name = "id_team_home")
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "id_team_away")
    private Team teamAway;

    @Column(name = "score_home")
    private Short scoreHome;

    @Column(name = "score_away")
    private Short scoreAway;

    @Column(name = "competition")
    private String competition;

    @Column(name = "match_day")
    private String matchDay;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "season")
    private String season;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MatchStatusEnum status;


}