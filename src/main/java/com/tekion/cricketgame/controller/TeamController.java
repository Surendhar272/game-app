package com.tekion.cricketgame.controller;

import com.tekion.cricketgame.entity.TeamEntity;
import com.tekion.cricketgame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;
    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getAllTeam")
    public List<TeamEntity> getAllTeam(){
        return teamService.getAllTeam();
    }

    @PostMapping("/insertTeam")
    public TeamEntity insertTeam(@RequestBody TeamEntity team){
        return teamService.insertTeam(team);
    }

    @PutMapping("/update/{id}")
    public TeamEntity updateTeam(@PathVariable int id , @RequestBody TeamEntity team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/delete/{id}")
    public TeamEntity deleteTeam(@PathVariable int id){
        return teamService.deleteTeam(id);
    }
}
