package org.example.validation.three;

import jakarta.validation.constraints.*;

public class Teacher {
    @NotNull
    private String name;

    @Min(0)
    @Max(150)
    private int age;

    @NotBlank
    @Pattern(regexp = "^1[34578]\\d{9}$")
    private String phone;

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
