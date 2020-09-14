package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public static List<Student> studentList = new ArrayList<>();

    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    public void deleteById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                break;
            }
        }
    }

    public List<Student> findAll() {
        return studentList;
    }

    public List<Student> findByGender(Gender gender) {
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }


    public Student findById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        throw new IllegalArgumentException("此学生id不存在");
    }

    public Student update(String id, Student newStudent) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setGender(newStudent.getGender());
                student.setName(newStudent.getName());
                student.setNote(newStudent.getNote());
                return student;
            }
        }
        throw new IllegalArgumentException("此学生id不存在,无法更新");
    }


}