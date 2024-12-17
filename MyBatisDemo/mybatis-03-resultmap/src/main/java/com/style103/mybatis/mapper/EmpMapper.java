package com.style103.mybatis.mapper;

import com.style103.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by 103style on 2024/12/16 23:25
 * github:https://github.com/103style
 */
public interface EmpMapper {

    Emp selectEmpById(@Param("empId") int empId);

    Emp selectEmpByIdWithResultMap(@Param("empId") int empId);

    /**
     * 通过员工id 查找 员工信息和部门信息
     */
    Emp getEmpAndDepByEmpId(@Param("empId") int empId);

    /**
     * 通过分布查询 返回员工信息和部门信息
     */
    Emp getEmpAndDepByStep(@Param("empId") int empId);


    /**
     * 通过部门id查部门信息和员工信息 第二步：同步部门id查员工信息
     */
    List<Emp> getDepAndEmpByDepIdStepTwo(@Param("depId") int depId);
}
