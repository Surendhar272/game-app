package com.tekion.cricketgame.service;

import com.tekion.cricketgame.entity.PlayerEntity;
import com.tekion.cricketgame.model.PlayerModel;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface PlayerService {
    public Collection<PlayerModel> getPlayersByTeamCode(String teamCode);

    public Collection<PlayerModel> getAllPlayers();

    public PlayerEntity insertPlayer(PlayerEntity player);
}
