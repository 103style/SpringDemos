package com.style103.mybatis.pojo;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class Emp {
    private int empId;
    private String empName;
    private int empAge;
    private int empDeptId;

    public Emp() {
    }

    public Emp(int empId, String empName, int empAge, int empDeptId) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empDeptId = empDeptId;
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

    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    @Override
    public String toString() {
        return "Emp{" + "empId=" + empId + ", empName='" + empName + '\'' + ", empAge=" + empAge + ", empDeptId=" + empDeptId + '}';
    }
}
