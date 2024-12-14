package org.example.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {

    /**
     * 通过类型获取对象， 如果传入的是接口，可以获取到他的实现类对象
     * 不过 如果有多个实现，就会报错了。
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 如果接口 UserDao 有一个实现类， 这里就能获取到实现类对象。
        // 如果接口 UserDao 有多个实现类， 这里就会报错。
        UserDao bean = context.getBean(UserDao.class);
        bean.run();
    }
}
