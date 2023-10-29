package com.tekion.cricketgame.serviceImpl;

import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.exception.TeamAlreadyExistsException;
import com.tekion.cricketgame.model.TeamModel;
import com.tekion.cricketgame.repository.TeamRepository;
import com.tekion.cricketgame.service.SequenceGeneratorService;
import com.tekion.cricketgame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.teamRepository = teamRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }
    @Override
    public List<TeamEntity> getAllTeam() {
        try{
            return teamRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public TeamEntity insertTeam(TeamEntity team) {
        TeamEntity existingTeam = teamRepository.findByTeamCode(team.getTeamCode());
        if (existingTeam != null) {
            throw new TeamAlreadyExistsException("A team with this name already exists.");
        }

        team.setTeamId(sequenceGeneratorService.getSequenceNumber(TeamEntity.SEQUENCE_NAME));
        return teamRepository.save(team);
    }

    @Override
    public TeamEntity updateTeam(int id, TeamEntity team) {
        TeamEntity OriginalTeam = teamRepository.findByTeamId(id);
        OriginalTeam.setTeamCode(team.getTeamCode());
//        OriginalTeam.setTeamName(team.getTeamName());
        teamRepository.save(OriginalTeam);
        return OriginalTeam;
    }

    @Override
    public TeamEntity deleteTeam(int id) {
        TeamEntity teamEntity = teamRepository.findByTeamId(id);
        teamRepository.delete(teamEntity);
        return teamEntity;
    }

    @Override
    public TeamEntity getTeamEntityById(Integer teamId) {
        return teamRepository.findByTeamId(teamId);
    }

    public TeamModel getTeamEntityByCode(String teamCode) {
        TeamEntity teamEntity = teamRepository.findByTeamCode(teamCode);
        TeamModel teamModel = new TeamModel();
        teamModel.setTeamId(teamEntity.getTeamId());
        teamModel.setTeamCode(teamEntity.getTeamCode());
//        teamModel.setTeamName(teamEntity.getTeamName());
        return teamModel;
    }
}
