package org.example.iocxml.diothertype;

public class Teacher {

    private Lesson teacherLesson;

    private String name;

    public Lesson getTeacherLesson() {
        return teacherLesson;
    }

    public void setTeacherLesson(Lesson teacherLesson) {
        this.teacherLesson = teacherLesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherLesson=" + teacherLesson +
                ", name='" + name + '\'' +
                '}';
    }
}
