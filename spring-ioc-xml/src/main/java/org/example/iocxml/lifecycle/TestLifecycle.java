package org.example.iocxml.lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.bean对象创建
 * 2.给bean对象设置相关属性
 * 3.bean后置处理器（初始化之前）
 * 4.bean对象初始化（调用指定初始化方法）
 * 5.bean后置处理器（初始化之后）
 * 6.bean对象创建完成了，可以使用了
 * 7.bean对象销毁（配置指定销毁的方法）
 * 8.IoC容器关闭
 */
public class TestLifecycle {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6.对象创建完成 可以使用");
        System.out.println(user);
        // 销毁的时候 会触发调用 destroy-method
        context.close();
    }
}
