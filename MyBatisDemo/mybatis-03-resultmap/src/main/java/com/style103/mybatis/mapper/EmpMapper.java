package com.style103.mybatis.mapper;

import com.style103.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * create by 103style on 2024/12/16 23:25
 * github:https://github.com/103style
 */
public interface EmpMapper {

    Emp selectEmpById(@Param("empId") int empId);

    Emp selectEmpByIdWithResultMap(@Param("empId") int empId);
}
