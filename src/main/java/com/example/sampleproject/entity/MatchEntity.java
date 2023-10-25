package com.example.sampleproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MatchEntity {

    @Id
    private Integer matchId;
    private String matchName;
    private TeamEntity teamA;
    private TeamEntity teamB;

}

