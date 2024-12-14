package org.example.validation.three;

import jakarta.validation.constraints.*;
import org.example.validation.annotation.Gender;

public class Teacher {
    @NotNull
    private String name;

    @Min(0)
    @Max(150)
    private int age;

    @Gender
    private int gender;

    @NotBlank
    @Pattern(regexp = "^1[34578]\\d{9}$")
    private String phone;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
