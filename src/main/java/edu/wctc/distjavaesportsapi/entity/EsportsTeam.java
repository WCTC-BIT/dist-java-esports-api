package edu.wctc.distjavaesportsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="esports_team")
@Data
@NoArgsConstructor
public class EsportsTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private int id;
//    @NotNull
    @Column(name="team_name")
    private String teamName;
//    @NotNull
    @Column(name="game_name")
    private String gameName;
    @Column(name="wins")
    private int wins;
    @Column(name="losses")
    private int losses;

}
