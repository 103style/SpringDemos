package com.style103.mybatis.mapper;

import com.style103.mybatis.User;

import java.util.List;

/**
 * create by 103style on 2024/12/15 15:46
 * <p>
 * 类名命名规则  实体类名+Mapper
 */
public interface UserMapper {

    int insertUser();

    int updateUser();

    int deleteUser();

    User getUserById();

    List<User> getAllUser();
}
