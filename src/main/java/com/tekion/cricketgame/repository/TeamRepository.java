package com.tekion.cricketgame.repository;

import com.tekion.cricketgame.entity.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamEntity,Integer> {
    public TeamEntity findByTeamId(Integer teamId);
//    public TeamEntity findByTeamName(String teamName);
    public TeamEntity findByTeamCode(String teamCode);
}
