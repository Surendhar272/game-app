package com.tekion.cricketgame.controller;

import com.tekion.cricketgame.entity.MatchEntity;
import com.tekion.cricketgame.entity.ResultSummaryEntity;
import com.tekion.cricketgame.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayMatchController {
    private final MatchService matchService;
    @Autowired
    public PlayMatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/getAllMatch")
    public List<MatchEntity> getAllmatchs(){
        return matchService.getAllMatchs();
    }

    @PostMapping("/startmatch")
    public ResponseEntity<MatchEntity> startMatch(@RequestParam String teamACode, @RequestParam String teamBCode, @RequestParam int over ,@RequestParam int playerSize ){
        MatchEntity match  = matchService.StartMatch(teamACode,teamBCode, over , playerSize);
        return ResponseEntity.status(HttpStatus.CREATED).body(match);
    }

    @GetMapping("/results/{matchId}")
    public ResponseEntity<ResultSummaryEntity> getMatchResults(@PathVariable Integer matchId) {
        ResultSummaryEntity matchResult = matchService.getMatchResults(matchId);
        return ResponseEntity.ok(matchResult);
    }

}
