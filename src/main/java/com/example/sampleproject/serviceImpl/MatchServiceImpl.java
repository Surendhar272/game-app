package com.example.sampleproject.serviceImpl;

import com.example.sampleproject.database.DataBase;
import com.example.sampleproject.entity.MatchEntity;
import com.example.sampleproject.service.MatchService;
import com.example.sampleproject.utils.CricketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final CricketUtils cricketUtils;
    private final DataBase dataBase;

    @Autowired
    public MatchServiceImpl(CricketUtils cricketUtils, DataBase dataBase) {
        this.cricketUtils = cricketUtils;
        this.dataBase = dataBase;
    }

    @Override
    public MatchEntity addMatch(MatchEntity match) {
        dataBase.getMatchList().add(match);
        return match;
    }

    @Override
    public List<MatchEntity> fetchAllMatch() {
        return dataBase.getMatchList();
    }

    @Override
    public String play(Integer matchId) {
        return cricketUtils.playMatch(matchId);
    }


}
