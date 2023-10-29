package com.tekion.cricketgame.repository;

import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchEntity, Integer> {
    public MatchEntity findByMatchId(Integer teamId);

}
