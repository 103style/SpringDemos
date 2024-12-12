package org.example.reflection;

/**
 * 反射测试类
 */
public class User {

    public String name;
    private int age;

    private int gender;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private void run() {
        System.out.println("run......");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
