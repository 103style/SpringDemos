package com.style103.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            // 获取核心配置的的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取 builder对象
            SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
            // 获取factory对象
            SqlSessionFactory sessionFactory = sqlBuilder.build(is);
            sqlSession = sessionFactory.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
