package edu.wctc.distjavaesportsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
    @NotBlank
    @Column(name="team_name")
    private String teamName;
    @NotBlank
    @Column(name="game_name")
    private String gameName;
    @PositiveOrZero
    @Column(name="wins")
    private int wins;
    @Min(value=0)
    @Column(name="losses")
    private int losses;

}
