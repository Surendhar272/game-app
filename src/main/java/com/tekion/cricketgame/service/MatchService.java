package com.tekion.cricketgame.service;

import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.ResultSummaryEntity;
import com.tekion.cricketgame.model.MatchModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MatchService {
    public List<MatchEntity> getAllMatchs();

    public MatchEntity insertMatch(MatchEntity match);

    public MatchEntity updateMatch(int id, MatchEntity match);

    public MatchEntity deleteMatch(int id);

    public MatchEntity StartMatch(String teamAId, String teamBId, int over, int playerSize);

    ResultSummaryEntity getMatchResults(Integer matchId);

}
