package mybatis;

import com.style103.mybatis.mapper.EmpMapper;
import com.style103.mybatis.pojo.Emp;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * create by 103style on 2024/12/16 23:36
 * github:https://github.com/103style
 */
public class ResultMapTest {

    @Test
    public void testSelectEmpById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void testSelectEmpWithResultMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpByIdWithResultMap(1);
        System.out.println(emp);
    }


    @Test
    public void testGetEmpAndDepByEmpId() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDepByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDepByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDepByStep(2);
        System.out.println(emp);
    }
}
