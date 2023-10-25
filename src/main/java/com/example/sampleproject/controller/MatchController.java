package com.example.sampleproject.controller;

import com.example.sampleproject.entity.MatchEntity;
import com.example.sampleproject.entity.ResultEntity;
import com.example.sampleproject.entity.TeamEntity;
import com.example.sampleproject.service.MatchService;
import com.example.sampleproject.service.ResultService;
import com.example.sampleproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;
    private final TeamService teamService;
    private final ResultService resultService;

    @Autowired
    public MatchController(MatchService matchService, TeamService teamService, ResultService resultService) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.resultService = resultService;
    }

    @PostMapping("/regMatch")
    public MatchEntity regMatch(@RequestBody MatchEntity match){
        return matchService.addMatch(match);
    }


    @GetMapping("/fetchResult")
    public List<MatchEntity> fetchMatch(){
        return matchService.fetchAllMatch();
    }

    @PostMapping("/team")
    public TeamEntity addTeam(@RequestBody TeamEntity team){
        return teamService.addTeam(team);
    }


    @GetMapping("/playmatch/{id}")
    public String play(@PathVariable("id") Integer matchId){
        return matchService.play(matchId);
    }

    @GetMapping("/matchresult")
    public List<ResultEntity> getResultOfMatch(){
        return resultService.fetchAllResult();
    }


}
