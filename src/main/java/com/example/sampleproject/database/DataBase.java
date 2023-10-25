package com.example.sampleproject.database;

import com.example.sampleproject.entity.MatchEntity;
import com.example.sampleproject.entity.ResultEntity;
import com.example.sampleproject.entity.TeamEntity;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataBase {

    List<MatchEntity> matchList = new ArrayList<>();

    List<TeamEntity> TeamList = new ArrayList<>();

    List<ResultEntity> resultEntityList = new ArrayList<>();


}
