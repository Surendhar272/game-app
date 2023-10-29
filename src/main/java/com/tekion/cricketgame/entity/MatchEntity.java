package com.tekion.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "match")
@Entity
public class MatchEntity {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private Integer matchId;

    private String team1;

    private String team2;

    private LocalDate matchDate;

    private LocalTime matchTime;

    private List<ScoreCardEntity> teamResults;

    private String winner;

    public void addTeamResult(String battingTeam, String bowlingTeam,int totalScore,String overs, int wickets, List<String> ballByBall,List<String> playerByPlayer,List<String> overByOver) {
        if (teamResults == null) {
            teamResults = new ArrayList<>();
        }
        ScoreCardEntity teamresult = new ScoreCardEntity(battingTeam, bowlingTeam, totalScore,overs, wickets, ballByBall ,playerByPlayer,overByOver);
        teamResults.add(teamresult);
    }
}
