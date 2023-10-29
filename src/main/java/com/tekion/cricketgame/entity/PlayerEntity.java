package com.tekion.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "players")
public class PlayerEntity {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private Integer id;  // MongoDB will automatically generate a unique ID

    @DBRef
    private TeamEntity teamId;

    private String playerName;

    // Other fields specific to your MongoDB entity

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PlayerEntity [id=");
        builder.append(id);
        builder.append(", teamId=");
        builder.append(teamId);
        builder.append(", playerName=");
        builder.append(playerName);
        builder.append("]");
        return builder.toString();
    }
}