package com.example.sampleproject.utils;

import com.example.sampleproject.database.DataBase;
import com.example.sampleproject.entity.BallsResult;
import com.example.sampleproject.entity.ResultEntity;
import com.example.sampleproject.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CricketUtils {


    private DataBase dataBase;

    @Autowired
    public CricketUtils( DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String playMatch(Integer matchId){
        String winner = "";
         dataBase.getMatchList().stream().forEach(t-> {
             if(t.getMatchId().equals(matchId)) {
                 dataBase.getResultEntityList().add(gamePlay(t.getTeamA()));
                 dataBase.getResultEntityList().add(gamePlay(t.getTeamB()));
             }
         });

        if (dataBase.getResultEntityList().get(0).getTotalRuns() > dataBase.getResultEntityList().get(1).getTotalRuns()) {
             winner = dataBase.getResultEntityList().get(0).getTeam().getTeamName() + " wins the match!";
//            dataBase.getResultEntityList().get(0).setWinner(winner);
            return winner;
        } else if (dataBase.getResultEntityList().get(1).getTotalRuns() > dataBase.getResultEntityList().get(0).getTotalRuns()) {
             winner = dataBase.getResultEntityList().get(1).getTeam().getTeamName() + " wins the match!";
//            dataBase.getResultEntityList().get(1).setWinner(winner);
            return winner;
        } else {
             return "It's a tie!";

        }

     }

     public List<ResultEntity> getResult(){
        return dataBase.getResultEntityList();
     }


public ResultEntity gamePlay(TeamEntity team){
         ResultEntity obj = new ResultEntity();
         List<BallsResult> ballCount = new ArrayList<>();
       int balls = team.getOvers()*6;
       int totalScore=0, players= team.getWicket(), wicketCount=0;

    for(int i=1;i<=balls;i++){
        if(players<=0){
            break;
        }
        BallsResult ball = new BallsResult();
        ball.setBall(i);
        int score = randomMethod();
        switch (score){
            case 1:
                ball.setScoreOrWicket("Single");
                break;
            case 2:
                ball.setScoreOrWicket("Double");
                break;
            case 3:
                ball.setScoreOrWicket("Triple");
                break;
            case 4:
                ball.setScoreOrWicket("Four");
                break;
            case 5:
                ball.setScoreOrWicket("Five");
                break;
            case 6:
                ball.setScoreOrWicket("It's Sixer");
                break;
            default:
                ball.setScoreOrWicket("wicket");
                wicketCount++;
                break;
        }
        ballCount.add(ball);
        totalScore +=score;
    }
    obj.setResultId(randomMethod());
    obj.setTeam(team);
    obj.setTotalRuns(totalScore);
    obj.setNumberOfwickets(wicketCount);
    obj.setScore(ballCount);
    return obj;
}


    private int randomMethod(){
        Random random = new Random();
        return random.nextInt(8);
    }

}
