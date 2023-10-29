package com.tekion.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "resultsSummary")
public class ResultSummaryEntity {

    @Id
    private String id; // MongoDB document ID

    private String teamA;
    private String teamB;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private List<ScoreCardEntity> teamResults;
    private String winner;

}
