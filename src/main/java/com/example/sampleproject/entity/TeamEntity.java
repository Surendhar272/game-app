package com.example.sampleproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeamEntity {

    @Id
    private Integer teamId;
    private String teamName;
    private String teamCode;
    private Integer overs;
    private Integer wicket;

}
