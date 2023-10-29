package com.tekion.cricketgame.repository;

import com.tekion.cricketgame.entity.ScoreCardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreBoardRepository extends MongoRepository<ScoreCardEntity, Integer> {
//    ScoreCardEntity findByScoreBoardId(Integer scoreBoardId);
}
