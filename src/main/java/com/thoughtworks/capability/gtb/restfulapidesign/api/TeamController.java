package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import com.thoughtworks.capability.gtb.restfulapidesign.vo.StudentVo;
import com.thoughtworks.capability.gtb.restfulapidesign.vo.TeamVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> getTeamList() {
        return teamService.getTeamList();
    }

    @PutMapping("")
    public List<Team> getTeamListRandomization() throws JsonProcessingException {
        return teamService.getTeamListRandomization();
    }

    @PutMapping("/{id}")
    public Team updateTeamName(@PathVariable String id, @RequestBody String newTeamName) {
        return teamService.updateTeamName(id, newTeamName);
    }

}
