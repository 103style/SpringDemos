package com.style103.mybatis.pojo;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class Emp {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private Integer empDepId;


    public Emp() {
    }

    public Emp(Integer empId, String empName, Integer empAge, Integer empDepId) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empDepId = empDepId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public Integer getEmpDepId() {
        return empDepId;
    }

    public void setEmpDepId(Integer empDepId) {
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
