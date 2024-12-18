package mybatis;

import com.style103.mybatis.mapper.DynamicSqlMapper;
import com.style103.mybatis.pojo.Emp;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * create by 103style on 2024/12/18 21:02
 * github:https://github.com/103style
 * <p>
 * 动态拼接sql的相关标签测试
 * 1.if
 * 通过test属性中的表达式判断标签中的内容是否有效（是否拼接到sql语句上）
 * 2.where
 * a.有条件成立时才会生成 where 关键字
 * b.会自动将 where 生成语句前面多余的 and 关键字去掉，⚠⚠⚠但是后面多余的and去不掉⚠⚠⚠
 * 3.trim
 * prefix,suffix:在标签前后添加对应的内容
 * prefixOverrides,suffixOverrides: 在标签前后移除对应的内容
 * 4.choose、when、otherwise
 * 相当于 if elseif else
 * when最少一个， otherwise最多一个
 * 5.foreach
 * collection: 设置要循环的数组和集合的参数名
 * item:用一个字符串表示 数组或集合的 每一项
 * separator: 设置每次循环之间的分隔符，会自动在分隔符前后加上空格
 * open:循环的所有内容以什么开始
 * close:循环的所有内容以什么结束
 * 6.sql片段：记录一段sql，可以通过 <include refid="xx"/> 来引入这个片段
 */
public class DynamicSqlTest {

    /**
     * 1.if
     * 通过test属性中的表达式判断标签中的内容是否有效（是否拼接到sql语句上）
     */
    @Test
    public void testDynamicSqlIf() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        // 运行正常 拼接sql: select * from t_emp where emp_name = ? and emp_age = ? and emp_dep_id = ?
        // Emp emp = new Emp(null,"jack", 21, 3);

        // 运行正常 拼接sql:  select * from t_emp where emp_name = ? and emp_age = ?
        // Emp emp = new Emp(null,"jack", 21, null);

        // 拼接错误 拼接sql: select * from t_emp where and emp_age = ? and emp_dep_id = ?
        // 可以在 where 后面默认添加一个 1=1 这种横成立的语句
        Emp emp = new Emp(null, null, 21, 1);
        List<Emp> emps = mapper.selectByIf(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testDynamicSqlIf2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 可以在 where 后面默认添加一个 1=1 这种横成立的语句
        // 运行成功 拼接sql: select * from t_emp where 1=1 and emp_dep_id = ?
        Emp emp = new Emp(null, null, null, 1);
        List<Emp> emps = mapper.selectByIf2(emp);
        emps.forEach(System.out::println);
    }


    /**
     * 2.where
     * a.有条件成立时才会生成 where 关键字
     * b.会自动将 where 生成语句前面多余的 and 关键字去掉，⚠⚠⚠但是后面多余的and去不掉⚠⚠⚠
     * <p>
     * 结合 if
     */
    @Test
    public void testDynamicSqlWhere() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 执行成功 拼接sql: select * from t_emp WHERE emp_age = ? and emp_dep_id = ?
        // Emp emp = new Emp(null,null, 21, 1);

        // 执行成功 拼接sql: select * from t_emp
        Emp emp = new Emp(null, null, null, null);
        List<Emp> emps = mapper.selectByWhere(emp);
        emps.forEach(System.out::println);
    }

    /**
     * 3.trim
     * prefix,suffix:在标签前后添加对应的内容
     * prefixOverrides,suffixOverrides: 在标签前后移除对应的内容
     * <p>
     * 结合 if
     */
    @Test
    public void testDynamicSqlTrim() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        // 执行成功 拼接sql: select * from t_emp where emp_name = ? and emp_age = ? and emp_dep_id = ?
        // Emp emp = new Emp(null,"哈哈", 22, 1);
        // 执行成功 拼接sql: select * from t_emp where emp_age = ?
        // Emp emp = new Emp(null,null, 22, null);

        // 执行成功 拼接sql: select * from t_emp where emp_name = ?
        Emp emp = new Emp(null, "as", null, null);
        List<Emp> emps = mapper.selectByTrim(emp);
        emps.forEach(System.out::println);
    }

    /**
     * 4.choose、when、otherwise
     * 相当于 if elseif else
     * when最少一个， otherwise最多一个
     * <p>
     * 结合 where
     */
    @Test
    public void testDynamicSqlChooseWhenOtherwise() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 拼接sql: select * from t_emp WHERE emp_name = ?
        // Emp emp = new Emp(null,"as", 12, 1);

        // 拼接sql: select * from t_emp WHERE emp_age = ?
        // Emp emp = new Emp(null,null, 12, 1);

        // 拼接sql: select * from t_emp
        Emp emp = new Emp(null, null, null, null);
        List<Emp> emps = mapper.selectByChooseWhenOtherwise(emp);
        emps.forEach(System.out::println);
    }

    /**
     * 5.foreach
     * collection: 设置要循环的数组和集合的参数名
     * item:用一个字符串表示 数组或集合的 每一项
     * separator: 设置每次循环之间的分隔符，会自动在分隔符前后加上空格
     * open:循环的所有内容以什么开始
     * close:循环的所有内容以什么结束
     */
    @Test
    public void testDynamicSqlForeachInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Emp emp1 = new Emp(null, "xx1", 23, 1);
        Emp emp2 = new Emp(null, "xx2", 23, 1);
        Emp emp3 = new Emp(null, "xx3", 23, 1);
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        // 拼接sql:  insert into t_emp values (null,?,?,?) , (null,?,?,?) , (null,?,?,?)
        mapper.insertListForeach(list);
        list.forEach(System.out::println);
    }

    /**
     * 5.foreach
     * collection: 设置要循环的数组和集合的参数名
     * item:用一个字符串表示 数组或集合的 每一项
     * separator: 设置每次循环之间的分隔符，会自动在分隔符前后加上空格
     * open:循环的所有内容以什么开始
     * close:循环的所有内容以什么结束
     */
    @Test
    public void testDynamicSqlForeachDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] empIds = new Integer[]{6, 7, 5, 9, 8, 10};
        // 拼接sql: delete from t_emp where emp_id in ( ? , ? , ? , ? , ? , ? )
        mapper.deleteArrayForeach(empIds);
    }


    /**
     * 6.sql片段：记录一段sql，可以通过 <include refid="xx"/> 来引入这个片段
     */
    @Test
    public void testDynamicSqlPart() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.selectBySqlPart();
        emps.forEach(System.out::println);
    }
}
