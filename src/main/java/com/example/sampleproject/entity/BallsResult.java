package com.example.sampleproject.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BallsResult {
    private Integer ball;
    private String scoreOrWicket;

}
