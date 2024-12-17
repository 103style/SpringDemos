package mybatis;

import com.style103.mybatis.mapper.DepMapper;
import com.style103.mybatis.mapper.EmpMapper;
import com.style103.mybatis.pojo.Dep;
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
//        System.out.println(emp);

        // 开启延迟加载 mybatis的配置属性 lazyLoadingEnabled
        // 指挥执行 查询员工的sql语句，不会执行查询部门的sql
        // 等读部门信息的时候才执行查部门信息的sql
        System.out.println(emp.getEmpName());
    }


    @Test
    public void testGetDepAndEmpByDepId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepMapper mapper = sqlSession.getMapper(DepMapper.class);
        Dep dep = mapper.getDepAndEmpByDepId(1);
        System.out.println(dep);
    }


    @Test
    public void testGetDepAndEmpByDepIdStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepMapper mapper = sqlSession.getMapper(DepMapper.class);
        Dep dep = mapper.getDepAndEmpByDepIdStepOne(1);
        System.out.println(dep);
    }

}
