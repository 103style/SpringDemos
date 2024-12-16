package com.style103.mybatis.pojo;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class Emp {
    private int empId;
    private String empName;
    private int empAge;
    private int deptId;

    public Emp() {
    }

    public Emp(int empId, String empName, int empAge, int deptId) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.deptId = deptId;
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

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" + "empId=" + empId + ", empName='" + empName + '\'' + ", empAge=" + empAge + ", deptId=" + deptId + '}';
    }
}
