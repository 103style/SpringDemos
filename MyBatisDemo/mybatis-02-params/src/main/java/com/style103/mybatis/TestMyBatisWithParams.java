package com.style103.mybatis;

import com.style103.mybatis.bean.User;
import com.style103.mybatis.mapper.UserMapper;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/*
 * created by 103style on 2024/12/16 17:05
 * github:https://github.com/103style
 */
public class TestMyBatisWithParams {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUserByName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("103style");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUpdateUserNameById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUserNameById(1, "root");
        sqlSession.close();
    }

    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getUserCount();
        System.out.println("count:" + count);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        System.out.println("map:" + map);
        sqlSession.close();
    }


    @Test
    public void testGetAllUseToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> maps = mapper.getAllUserToMap();
        System.out.println("map:" + maps);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("haha");
        user.setPassword("123456");
        mapper.insertUser(user);
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(4);
        sqlSession.close();
    }

}

