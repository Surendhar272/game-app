package com.tekion.cricketgame.serviceImpl;

import com.tekion.cricketgame.entity.PlayerEntity;
import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.exception.PlayerAlreadyExistsException;
import com.tekion.cricketgame.model.PlayerModel;
import com.tekion.cricketgame.repository.PlayerRepository;
import com.tekion.cricketgame.service.PlayerService;
import com.tekion.cricketgame.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.playerRepository = playerRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }
    @Override
    public Collection<PlayerModel> getPlayersByTeamCode(String teamCode) {
        Collection<PlayerModel> playerModels = new ArrayList<>();
        for(PlayerEntity playerEntity : playerRepository.findByTeamIdTeamCode(teamCode)) {
            PlayerModel playerModel = new PlayerModel();
            playerModel.setPlayerName(playerEntity.getPlayerName());
            playerModel.setPlayerName(playerEntity.getPlayerName());
            playerModel.setTeamId(playerEntity.getTeamId());
            playerModels.add(playerModel);
        }
        return playerModels;
    }

    @Override
    public Collection<PlayerModel> getAllPlayers() {
        Collection<PlayerModel> responseModels = new ArrayList<PlayerModel>();

        Collection<PlayerEntity> playerEntities = playerRepository.findAll();

        for(PlayerEntity responseEntity :playerEntities) {
            PlayerModel responseModel = new PlayerModel();
            responseModel.setPlayerName(responseEntity.getPlayerName());
            responseModel.setTeamId(responseEntity.getTeamId());
            responseModel.setPlayerName(responseEntity.getPlayerName());
            responseModels.add(responseModel);
        }
        return responseModels;
    }

    @Override
    public PlayerEntity insertPlayer(PlayerEntity player) {
        PlayerEntity existingPlayer = playerRepository.findByPlayerName(player.getPlayerName());
        if (existingPlayer != null) {
            throw new PlayerAlreadyExistsException("A Player with this name already exists.");
        }

        player.setId(sequenceGeneratorService.getSequenceNumber(PlayerEntity.SEQUENCE_NAME));
        return playerRepository.save(player);
    }
}
