package mybatis.cache;

import com.style103.mybatis.cache.mapper.CacheMapper;
import com.style103.mybatis.cache.pojo.Emp;
import com.style103.mybatis.cache.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * create by 103style on 2024/12/18 22:25
 * github:https://github.com/103style
 */
public class CacheTest {

    /**
     * 一级缓存是 SqlSession 级别， 第二次查询会使用第一次的缓存结果
     * 如果两次查询中间有增删改操作，缓存就会失效
     */
    @Test
    public void testFirstCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        // 一级缓存 sqlSession级别
        // 第二次查询会直接使用上一次查询的剞劂
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);

        // 如果中间进行了增删改 一级缓存就会失效
        mapper.updateEmpNameById(1,"asd");

        // 不回使用缓存  sql查询
        Emp emp3 = mapper.getEmpById(1);
        System.out.println(emp3);
    }

    /**
     * 二级缓存  SqlSessionFactory级别
     * 开启二级缓存的条件：
     * 1.需要在mapper文件中，添加 <cache /> 标签
     * 2.需要将实体类实现 Serializable 序列化接口
     * 3.需要在mybatis配置文件中 settings下 配置 cacheEnabled 为 true（默认就是true）
     *
     * 需要前一个 session 调用 commit() 或者 close() 后
     * 第二个 session对象才能使用二级缓存
     *
     * 同样只要中间进行了 增删改操作 会使一二级缓存失效
     */
    @Test
    public void testSecondCache() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(stream);

        SqlSession session1 = sessionFactory.openSession(true);
        CacheMapper mapper1 = session1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        // 需要前一个 session 调用 commit() 或者 close() 后，
        // 第二个 session对象才能使用二级缓存
//        session1.commit();
        session1.close();

        SqlSession session2 = sessionFactory.openSession(true);
        CacheMapper mapper2 = session2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);

    }

}
