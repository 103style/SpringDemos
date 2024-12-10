package org.example.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 1.通过配置id获取对象
        User user = (User) context.getBean("user");
        System.out.println("1.根据配置id获取bean：" + user);

        // 2.根据类型获取对象
        User user2 = context.getBean(User.class);
        System.out.println("2.根据类型获取bean：" + user2);

        // 2.根据id和类型获取对象
        User user3 = context.getBean("user", User.class);
        System.out.println("3.根据id和类型获取bean：" + user3);
    }
}
