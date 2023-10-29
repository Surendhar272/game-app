package com.tekion.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "teams")
public class TeamEntity {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private Integer teamId;  // MongoDB will automatically generate a unique ID

    @Indexed(unique = true) // Add this annotation to create a unique index
    private String teamCode;

//    @Indexed(unique = true) // Add this annotation to create a unique index
//    private String teamName;

}
