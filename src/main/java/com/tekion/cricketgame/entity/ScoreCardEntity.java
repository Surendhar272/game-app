package com.tekion.cricketgame.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collation = "scoreboards")
public class ScoreCardEntity {
    private String battingTeam;
    private String bowlingTeam;
    private int totalScore;
    private String oversDone;
    private int wickets;
    private List<String> ballByBall;
    private List<String> playerByPlayer;
    private List<String> overByOver;
}
