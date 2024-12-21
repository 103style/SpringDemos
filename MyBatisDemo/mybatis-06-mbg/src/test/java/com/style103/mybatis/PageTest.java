package com.style103.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.style103.mybatis.mapper.EmpMapper;
import com.style103.mybatis.pojo.Emp;
import com.style103.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * create by 103style on 2024/12/21 21:58
 * github:https://github.com/103style
 */
public class PageTest {

    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //查询之后开启分页
        Page<Object> page = PageHelper.startPage(1, 4);
        // 返回第1页的4条数据
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(System.out::println);
        System.out.println(page);

        // 第二个参数:导航分页的页码书
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
        /**
         * PageInfo{
         *  pageNum=1, 当前页的页码
         *  pageSize=4, 每页显示的条数
         *  size=4, 当前页显示的真实条数
         *  startRow=1,
         *  endRow=4,
         *  total=35, 总记录数
         *  pages=9, 总页数
         *  prePage=0, 上一页的页码
         *  nextPage=2, 下一页的页码
         *  isFirstPage=true, isLastPage=false, 是否为第一页/最后一页
         *  hasPreviousPage=false, hasNextPage=true, 是否存在上一页/下一页
         *  navigatePages=5, 导航分页的页码数
         *  navigateFirstPage=1,
         *  navigateLastPage=5,
         *  navigatepageNums=[1, 2, 3, 4, 5]} 导航分页的页码，[1,2,3,4,5]
         */
        System.out.println(pageInfo);

    }
}
