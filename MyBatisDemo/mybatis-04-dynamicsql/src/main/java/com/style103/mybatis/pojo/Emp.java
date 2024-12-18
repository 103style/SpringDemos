package com.style103.mybatis.pojo;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class Emp {
    private int empId;
    private String empName;
    private int empAge;
    private int empDepId;


    public Emp() {
    }

    public Emp(Integer empId, String empName, int empAge, int empDepId) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empDepId = empDepId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public int getEmpDepId() {
        return empDepId;
    }

    public void setEmpDepId(int empDepId) {
        this.empDepId = empDepId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empDepId=" + empDepId +
                '}';
    }
}
