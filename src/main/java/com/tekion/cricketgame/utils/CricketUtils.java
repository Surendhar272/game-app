package com.tekion.cricketgame.utils;


import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.ResultSummaryEntity;
import com.tekion.cricketgame.entity.ScoreCardEntity;
import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.exception.MatchNotFoundException;
import com.tekion.cricketgame.model.*;
import com.tekion.cricketgame.repository.MatchRepository;
import com.tekion.cricketgame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CricketUtils {

    @Autowired
    private MatchRepository matchRepo;

    @Autowired
    private TeamRepository teamRepo;

    public int calculateTeamScore(MatchEntity match, String teamName) {
        int totalScore = 0 ;
        for(ScoreCardEntity teamResults : match.getTeamResults()){
            if(teamName.equals(teamResults.getBattingTeam())){
                totalScore += teamResults.getTotalScore();
            }
        }
        return  totalScore;
    }

    public void play(MatchEntity match, TeamEntity BattingTeam, TeamEntity BowlingTeam, int totalBalls, int maxWickets) {
        int totalScore = 0;
        int wicketCount = 0;
        List<String> ballByBall = new ArrayList<>();
        List<String> playerByPlayer = new ArrayList<>();
        List<String> overByOver  = new ArrayList<>();
        int curr_player = 0 ;
        int ballsInOver = 0 ;
        int overCount = 1 ;
        int overRuns = 0 ;
        String overs = Integer.toString(totalBalls/6);

        for (int ball = 1; ball <= totalBalls; ball++) {
            if (wicketCount == maxWickets) {
                System.out.println("Total ball taken : "+ball);
                int UsedOver = ball/6;
                System.out.println("Used over "+UsedOver);
                int UsedBalls = ball%6;
                System.out.println("Used balls "+UsedBalls);
                overs = UsedOver+" Overs "+(UsedBalls-1)+" Balls ";
                break;
            }
            int ballResult = BallResult();
            if (ballResult == 7) {
                wicketCount++;
                if(curr_player < playerByPlayer.size()){
                    int playerscore = Integer.parseInt(playerByPlayer.get(curr_player));
                    playerByPlayer.set(curr_player,String.valueOf(playerscore));
                }else{
                    playerByPlayer.add(String.valueOf(0));
                }
                ballByBall.add("Batsman " + (curr_player+1) +" - Ball " + ball +" : "+"W");
                ballsInOver++;
                System.out.println("in wicket part also increase the ball count "+ballsInOver);
                curr_player = (curr_player+1)%maxWickets;

            } else {

                if (ballsInOver == 6) {
                    overByOver.add(overRuns + " runs in "+overCount+ " over");
                    overCount++;
                    overRuns = 0;
                    ballsInOver = 0;
                }
                if (curr_player < playerByPlayer.size()) {
                    int playerscore = Integer.parseInt(playerByPlayer.get(curr_player));
                    playerByPlayer.set(curr_player, String.valueOf(playerscore + ballResult));
                } else {
                    playerByPlayer.add(String.valueOf(ballResult));
                }
                ballByBall.add("Batsman " + (curr_player + 1) + " - Ball " + ball + " : " + ballResult);
                ballsInOver++;
                System.out.println("Ball in over :"+ ballsInOver);
                overRuns += ballResult;
                System.out.println("Current Over result :" + overRuns);
                totalScore += ballResult;
            }
        }
        if(ballsInOver <= 6){
            overByOver.add(overRuns+" runs in "+overCount+" over");
        }
        match.addTeamResult(BattingTeam.getTeamCode(),BowlingTeam.getTeamCode(), totalScore,overs,wicketCount, ballByBall , playerByPlayer , overByOver);
    }

    private int BallResult() {

        return (int) (Math.random() * 8);
    }


}