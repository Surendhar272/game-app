package com.tekion.cricketgame.serviceImpl;

import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.ResultSummaryEntity;
import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.exception.MatchNotFoundException;
import com.tekion.cricketgame.exception.TeamAlreadyExistsException;
import com.tekion.cricketgame.repository.MatchRepository;
import com.tekion.cricketgame.repository.TeamRepository;
import com.tekion.cricketgame.service.MatchService;
import com.tekion.cricketgame.service.SequenceGeneratorService;
import com.tekion.cricketgame.utils.CricketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    private final CricketUtils cricketUtils;

    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, TeamRepository teamRepository, CricketUtils cricketUtils, SequenceGeneratorService sequenceGeneratorService) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.cricketUtils = cricketUtils;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public List<MatchEntity> getAllMatchs() {
        try{
            return matchRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public MatchEntity insertMatch(MatchEntity match) {
        MatchEntity existingMatch = matchRepository.findByMatchId(match.getMatchId());
        if (existingMatch != null) {
            throw new TeamAlreadyExistsException("A team with this name already exists.");
        }

        match.setMatchId(sequenceGeneratorService.getSequenceNumber(TeamEntity.SEQUENCE_NAME));
        return matchRepository.save(match);
    }

    @Override
    public MatchEntity updateMatch(int id, MatchEntity match) {
        MatchEntity OriginalMatch = matchRepository.findById(id).get();
        OriginalMatch.setTeam1(match.getTeam1());
        OriginalMatch.setTeam2(match.getTeam2());
        matchRepository.save(OriginalMatch);
        return OriginalMatch;
    }

    @Override
    public MatchEntity deleteMatch(int id) {
        MatchEntity matchEntity = matchRepository.findById(id).get();
        matchRepository.delete(matchEntity);
        return matchEntity;
    }


    @Override
    public MatchEntity StartMatch(String teamACode, String teamBCode, int over, int playerSize) {
            TeamEntity team1 = teamRepository.findByTeamCode(teamACode);
            TeamEntity team2 = teamRepository.findByTeamCode(teamBCode);

            LocalDate MatchDate = LocalDate.now();
            LocalTime MatchTime = LocalTime.now();
            DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            String customTime = MatchTime.format(customFormatter);

            MatchEntity match = new MatchEntity();
            match.setTeam1(team1.getTeamCode());
            match.setTeam2(team2.getTeamCode());
            match.setMatchDate(MatchDate);
            match.setMatchTime(LocalTime.parse(customTime,customFormatter));

            int totalBalls = over*6;

            cricketUtils.play(match, team1, team2, totalBalls, playerSize);
            cricketUtils.play(match, team2, team1, totalBalls, playerSize);

            int teamAScore = cricketUtils.calculateTeamScore(match, team1.getTeamCode());
            int teamBScore = cricketUtils.calculateTeamScore(match, team2.getTeamCode());


            String winner = (teamAScore > teamBScore) ? team1.getTeamCode() : team2.getTeamCode();
            match.setWinner(winner);

            match.setMatchId(sequenceGeneratorService.getSequenceNumber(TeamEntity.SEQUENCE_NAME));
            matchRepository.save(match);
            return match;
    }

    @Override
    public ResultSummaryEntity getMatchResults(Integer matchId) {
        MatchEntity match = matchRepository.findById(matchId)
                .orElseThrow(() -> new MatchNotFoundException("Match not found"));

        ResultSummaryEntity matchResult = new ResultSummaryEntity();
        matchResult.setTeamA(match.getTeam1());
        matchResult.setTeamB(match.getTeam2());
        matchResult.setMatchDate((match.getMatchDate()));
        matchResult.setMatchTime((match.getMatchTime()));
        matchResult.setTeamResults(match.getTeamResults());
        matchResult.setWinner(match.getWinner());

        return matchResult;
    }

}
