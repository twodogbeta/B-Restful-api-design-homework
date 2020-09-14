package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public StudentRepository(){
        initStudentList();
    }
    public static List<Student> studentList = new ArrayList<>();
    private int initId = 1;
    private List<String> initStudentList = Arrays.asList(
            "沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇", "杨思雨", "江雨舟",
            "廖燊", "胡晓", "但杰", "盖迈达", "肖美琪", "黄云洁",
            "齐瑾浩", "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪", "党泽",
            "肖伊佐", "贠晨曦", "李康宁", "马庆", "商婕", "余榕", "谌哲",
            "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强",
            "刘柯", "廖浚斌", "凌凤仪");

    private Student addNewStudent(String name) {
        return Student.builder()
                .id(String.valueOf(initId++))
                .gender(Gender.Female)
                .name(name)
                .build();
    }

    private void initStudentList() {
        studentList.clear();
        for (int i = 0; i < initStudentList.size(); i++)
            studentList.add(addNewStudent(initStudentList.get(i)));
    }

    public List<Student> findAll() {
        return studentList;
    }

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