package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository = new TeamRepository();

    public List<Team> getTeamList() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamListRandomization() throws JsonProcessingException {
        return teamRepository.getTeamList();
    }
}