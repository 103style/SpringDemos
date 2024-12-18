package com.style103.mybatis.mapper;

import com.style103.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by 103style on 2024/12/18 20:23
 * github:https://github.com/103style
 */
public interface DynamicSqlMapper {

    /**
     * 通过相关字段查信息
     */
    List<Emp> selectByIf(@Param("emp") Emp emp);

    List<Emp> selectByIf2(@Param("emp") Emp emp);

    List<Emp> selectByWhere(@Param("emp") Emp emp);

    List<Emp> selectByTrim(@Param("emp") Emp emp);

    List<Emp> selectByChooseWhenOtherwise(@Param("emp") Emp emp);

    /**
     * 批量添加数据
     */
    void insertListForeach(@Param("list") List<Emp> list);

    /**
     * 批量删除数据
     */
    void deleteArrayForeach(@Param("empIds") Integer[] empIds);


    List<Emp> selectBySqlPart();
}
