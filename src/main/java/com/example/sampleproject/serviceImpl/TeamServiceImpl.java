package com.example.sampleproject.serviceImpl;

import com.example.sampleproject.database.DataBase;
import com.example.sampleproject.entity.TeamEntity;
import com.example.sampleproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private DataBase dataBase;

    @Autowired
    public TeamServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public TeamEntity addTeam(TeamEntity team) {
        dataBase.getTeamList().add(team);
        return team;
    }



}
