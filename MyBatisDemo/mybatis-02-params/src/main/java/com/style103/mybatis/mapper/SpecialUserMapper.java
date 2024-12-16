package com.style103.mybatis.mapper;

import com.style103.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by 103style on 2024/12/16 21:50
 * github:https://github.com/103style
 */
public interface SpecialUserMapper {

    /**
     * 模糊查询用户名
     */
    List<User> getUserByLike(@Param("like") String like);

}
