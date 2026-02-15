package club.manager.entrance_cockpit.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "club")
@Data
public class Club {

    @Id
    @Column(name = "id_club")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    @Column(name = "name")
    private String name;

    @Column(name = "president")
    private String president;

    @Column(name = "email", unique = true)
    private String email;

}