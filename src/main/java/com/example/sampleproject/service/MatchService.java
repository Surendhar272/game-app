package com.example.sampleproject.service;

import com.example.sampleproject.entity.MatchEntity;

import java.util.List;

public interface MatchService {
    public MatchEntity addMatch(MatchEntity match);

    public List<MatchEntity> fetchAllMatch();

    public String play(Integer matchId);


}
