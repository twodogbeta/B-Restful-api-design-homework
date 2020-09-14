package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class TeamRepository {
    private int teamCount = 6;
    public static List<Team> teamList = new ArrayList<>();

    public List<Team> findAll() {
        return teamList;
    }
    
    public List<Student> deepCopy() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(StudentRepository.studentList);
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Student.class);
        return objectMapper.readValue(jsonString, jt);
    }
    public void swapStudent(List<Student> tL, int indexA, int indexB) {
        Student StudentA = tL.get(indexA);
        Student StudentB = tL.get(indexB);
        Student tempA = new Student(StudentA.getId(), StudentA.getName(),StudentA.getGender(),StudentA.getNote());

        tL.set(indexA, StudentB);
        tL.set(indexB, tempA);
    }
    public List<Student> shuffleList() throws JsonProcessingException {
        List<Student> toShuffle = deepCopy();

        int size = StudentRepository.studentList.size();

        Random random = new Random();
        for(int i = size - 1; i > 0; i --) {
            int swapIndex = random.nextInt(i);
            swapStudent(toShuffle, i , swapIndex);
        }

        return toShuffle;
    }
    public List<Team> getTeamList() throws JsonProcessingException {

        List<Team> TeamList = new ArrayList<>(teamCount);
        for (int i = 0; i < teamCount; i++) {
            TeamList.add(new Team());
        }
        List<Student> shuffledStudent = shuffleList();
        for (int i = 0; i < shuffledStudent.size(); i++) {
            TeamList.get(i % teamCount).getStudentList().add(shuffledStudent.get(i));
        }
        teamList = TeamList;
        return TeamList;
    }

    public Team updateTeamName(String id, String teamName) {
        for (Team team : teamList) {
            if (team.getId().equals(id)) {
                team.setName(teamName);
                return team;
            }
        }
        throw new IllegalArgumentException("此组id不存在,无法更新");
    }
}