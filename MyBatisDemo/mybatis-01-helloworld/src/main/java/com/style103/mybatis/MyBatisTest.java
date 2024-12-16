package com.style103.mybatis;

import com.style103.mybatis.mapper.UserMapper;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * create by 103style on 2024/12/15 15:56
 */
public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        // 获取核心配置的的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取 builder对象
        SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
        // 获取factory对象
        SqlSessionFactory sessionFactory = sqlBuilder.build(is);

        // 不常用方式：
//        // 获取会话对象 sqlSession 不会自动提交
//        SqlSession sqlSession = sessionFactory.openSession();
//        // 参数为： mapper配置的 namespace （com.style103.mybatis.mapper.UserMapper） + sql语句的id（insertUser）
//        int result = sqlSession.insert("com.style103.mybatis.mapper.UserMapper.insertUser");
//        // 提交事务
//        sqlSession.commit();

        // 通用方式
        // 获取会话对象 sqlSession, 配置参数为 true，即会自动提交
        SqlSession sqlSession = sessionFactory.openSession(true);
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用对应的方法
        int result = mapper.insertUser();

        System.out.println("result:" + result);
        // 关闭session
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        System.out.println(result);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        System.out.println(result);
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }

}
