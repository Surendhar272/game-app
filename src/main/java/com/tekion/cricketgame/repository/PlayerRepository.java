package com.tekion.cricketgame.repository;
import com.tekion.cricketgame.entity.PlayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Collection;

public interface PlayerRepository extends MongoRepository<PlayerEntity, String> {
    Collection<PlayerEntity> findByTeamIdTeamCode(String teamCode);

    public PlayerEntity findByPlayerName(String playerName);
}