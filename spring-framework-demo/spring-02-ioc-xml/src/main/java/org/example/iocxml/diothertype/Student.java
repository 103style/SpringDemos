package org.example.iocxml.diothertype;

import java.util.List;
import java.util.Map;

public class Student {

    private String name;
    private Map<Lesson, Integer> grades;

    private List<Teacher> teacherList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Lesson, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<Lesson, Integer> grades) {
        this.grades = grades;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                ", teacherList=" + teacherList +
                '}';
    }
}
