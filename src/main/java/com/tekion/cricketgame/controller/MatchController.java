package com.tekion.cricketgame.controller;

import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.service.MatchService;
import com.tekion.cricketgame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;
    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/getAllMatch")
    public List<MatchEntity> getAllMatchs(){
        return matchService.getAllMatchs();
    }

    @PostMapping("/insertMatch")
    public MatchEntity insertMatch(@RequestBody MatchEntity match){
        return matchService.insertMatch(match);
    }

    @PutMapping("/update/{id}")
    public MatchEntity updateMatch(@PathVariable int id , @RequestBody MatchEntity match){
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/delete/{id}")
    public MatchEntity deleteTeam(@PathVariable int id){
        return matchService.deleteMatch(id);
    }



//    @PostMapping("/startmatch")
//    public ResponseEntity<MatchEntity> startMatch(@RequestParam String TeamAId, @RequestParam String TeamBId, @RequestParam int Over ,@RequestParam int PlayerSize ){
//        MatchEntity match  = matchService.StartMatch(TeamAId,TeamBId, Over, PlayerSize);
//        return ResponseEntity.status(HttpStatus.CREATED).body(match);
//    }
//
//    @GetMapping("/results/{matchId}")
//    public ResponseEntity<TeamResultsDTO> getMatchResults(@PathVariable String matchId) {
//        TeamResultsDTO matchResult = matchService.getMatchResults(matchId);
//        return ResponseEntity.ok(matchResult);
//    }
}
