package com.style103.mybatis.cache.mapper;

import com.style103.mybatis.cache.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * create by 103style on 2024/12/18 22:24
 * github:https://github.com/103style
 */
public interface CacheMapper {

    Emp getEmpById(@Param("eId") Integer eId);


    void updateEmpNameById(@Param("eId") int eId, @Param("empName") String empName);
}
