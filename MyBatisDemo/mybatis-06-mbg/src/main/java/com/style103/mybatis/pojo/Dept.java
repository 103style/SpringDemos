package com.style103.mybatis.pojo;

public class Dept {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dep.dep_id
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private Integer depId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dep.dep_name
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    private String depName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dep.dep_id
     *
     * @return the value of t_dep.dep_id
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public Integer getDepId() {
        return depId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dep.dep_id
     *
     * @param depId the value for t_dep.dep_id
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dep.dep_name
     *
     * @return the value of t_dep.dep_name
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public String getDepName() {
        return depName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dep.dep_name
     *
     * @param depName the value for t_dep.dep_name
     *
     * @mbg.generated Sat Dec 21 16:55:15 CST 2024
     */
    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }
}