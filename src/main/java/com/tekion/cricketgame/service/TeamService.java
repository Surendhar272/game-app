package com.tekion.cricketgame.service;

import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.model.TeamModel;

import java.util.List;

public interface TeamService {

    public List<TeamEntity> getAllTeam();

    public TeamEntity insertTeam(TeamEntity team);

    public TeamEntity updateTeam(int id, TeamEntity team);

    public TeamEntity deleteTeam(int id);

    public TeamEntity getTeamEntityById(Integer teamId);

    public TeamModel getTeamEntityByCode(String teamCode);
}
