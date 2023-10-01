package edu.wctc.distjavaesportsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="player")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_id")
    private int id;
    @Column(name="team_id")
    private int teamId;
    @NotBlank
    @Column(name="first_name")
    private String firstName;
    @NotBlank
    @Column(name="last_name")
    private String lastName;
}
