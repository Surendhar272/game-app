package com.tekion.cricketgame.serviceImpl;

import com.tekion.cricketgame.entity.ScoreCardEntity;
import com.tekion.cricketgame.model.ScoreBoardModel;
import com.tekion.cricketgame.repository.ScoreBoardRepository;
import com.tekion.cricketgame.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    private final ScoreBoardRepository scoreBoardRepository;

    @Autowired
    public ScoreBoardServiceImpl(ScoreBoardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

}
