package com.style103.mybatis;

import com.style103.mybatis.mapper.EmpMapper;
import com.style103.mybatis.pojo.Emp;
import com.style103.mybatis.pojo.EmpExample;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * create by 103style on 2024/12/21 16:57
 * github:https://github.com/103style
 */
public class MybatisMBGTest {

    @Test
    public void testSelectByPrimaryKey() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 通过主键查询
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }

    @Test
    public void testSelectByExample() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 通过条件查询
        // 无条件查询
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(System.out::println);

        // 有条件查询
        EmpExample example = new EmpExample();
        // 创建条件对象  select emp_id, emp_name, emp_age, emp_dep_id from t_emp WHERE ( emp_dep_id = ? and emp_age > ? ) or( emp_name in ( ? , ? ) )
        // 查询 部门id是 1 并且 年龄大于23的员工
        example.createCriteria().andEmpDepIdEqualTo(1).andEmpAgeGreaterThan(23);
        // 或者 名字是 tom 和 ponny 的员工
        example.or().andEmpNameIn(Arrays.asList("tom", "ponny"));

        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);
    }


    @Test
    public void testUpdateByExample() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // update t_emp set emp_name = ?, emp_age = ?, emp_dep_id = ? where emp_id = ?
//        Emp emp = new Emp(1, "103style", 25, 3);
//        mapper.updateByPrimaryKey(emp);

        // update t_emp set emp_name = ?, emp_age = ?, emp_dep_id = ? where emp_id = ?
//        Emp emp = new Emp(2, "Android", null , null);
//        mapper.updateByPrimaryKey(emp);

        // update t_emp SET emp_name = ? where emp_id = ?
        // 选择性修改指挥修改属性值不是null的
        Emp emp = new Emp(2, "Android", null , null);
        mapper.updateByPrimaryKeySelective(emp);

    }
}
