package com.style103.mybatis;

import com.style103.mybatis.bean.User;
import com.style103.mybatis.mapper.SpecialUserMapper;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * create by 103style on 2024/12/16 21:52
 * github:https://github.com/103style
 */
public class SpecialMapperTest {

    @Test
    public void testSpecialQuery() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialUserMapper mapper = sqlSession.getMapper(SpecialUserMapper.class);
        List<User> result = mapper.getUserByLike("a");
        result.forEach(System.out::println);
    }

    @Test
    public void testSpecialDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialUserMapper mapper = sqlSession.getMapper(SpecialUserMapper.class);
        mapper.deleteUserById(10, 11);
    }

    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialUserMapper mapper = sqlSession.getMapper(SpecialUserMapper.class);
        mapper.deleteMoreUser("12,13");
    }

    @Test
    public void testSelectWithTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialUserMapper mapper = sqlSession.getMapper(SpecialUserMapper.class);
        User user = mapper.selectUserByTableNameAndId("t_user", 1);
        System.out.println(user);
    }


    @Test
    public void testJdbc() throws Exception {
        Connection connection = DriverManager.getConnection("", "", "");
        // select * from t_user where username like '%#{}%'
        // #{} 会被替换成 ? 变成 select * from t_user where username like '%?%'
        String sql = "select * from t_user where username like '%?%'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置第一个参数的时候就会编译报错， 因为?在引号里面，所以无法找到参数
//        preparedStatement.setString(1, "a");
    }

    @Test
    public void testInsertUserAndUpdateId() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialUserMapper mapper = sqlSession.getMapper(SpecialUserMapper.class);
        User user = new User(null, "xm", "mm123", 21, "男", "12323@qq.com");
        mapper.insertUserAndSetPrimaryKey(user);
        System.out.println(user);
    }


}
