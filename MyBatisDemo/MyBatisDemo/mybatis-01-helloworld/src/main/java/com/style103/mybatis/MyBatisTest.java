package com.style103.mybatis;

import com.style103.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        // 获取会话对象 sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用对应的方法
        int result = mapper.insertUser();
        System.out.println("result:" + result);
        // 提交事务
        sqlSession.commit();
        // 关闭session
        sqlSession.close();
    }
}
