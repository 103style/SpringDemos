package com.style103.mybatis.pojo;

public class Emp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.emp_id
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.emp_name
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private String empName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.emp_age
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private Integer empAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.emp_dep_id
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private Integer empDepId;

    public Emp() {
    }

    public Emp(Integer empId, String empName, Integer empAge, Integer empDepId) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empDepId = empDepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.emp_id
     *
     * @return the value of t_emp.emp_id
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.emp_id
     *
     * @param empId the value for t_emp.emp_id
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.emp_name
     *
     * @return the value of t_emp.emp_name
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.emp_name
     *
     * @param empName the value for t_emp.emp_name
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.emp_age
     *
     * @return the value of t_emp.emp_age
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public Integer getEmpAge() {
        return empAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.emp_age
     *
     * @param empAge the value for t_emp.emp_age
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.emp_dep_id
     *
     * @return the value of t_emp.emp_dep_id
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public Integer getEmpDepId() {
        return empDepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.emp_dep_id
     *
     * @param empDepId the value for t_emp.emp_dep_id
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setEmpDepId(Integer empDepId) {
        this.empDepId = empDepId;
    }

    @Override
    public String toString() {
        return "Emp{" + "empId=" + empId + ", empName='" + empName + '\'' + ", empAge=" + empAge + ", empDepId=" + empDepId + '}';
    }
}