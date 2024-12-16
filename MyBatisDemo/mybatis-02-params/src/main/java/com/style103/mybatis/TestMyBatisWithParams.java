package com.style103.mybatis;

import com.style103.mybatis.bean.User;
import com.style103.mybatis.mapper.UserMapper;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 * created by 103style on 2024/12/16 17:05
 * github:https://github.com/103style
 */
public class  TestMyBatisWithParams {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
}
