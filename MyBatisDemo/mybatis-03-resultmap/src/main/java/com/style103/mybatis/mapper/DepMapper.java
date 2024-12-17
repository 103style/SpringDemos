package com.style103.mybatis.mapper;

import com.style103.mybatis.pojo.Dep;
import org.apache.ibatis.annotations.Param;

/*
 * created by 103style on 2024/12/17 16:33
 * github:https://github.com/103style
 */
public interface DepMapper {

    Dep getDepByDepId(@Param("depId") int depId);
}
