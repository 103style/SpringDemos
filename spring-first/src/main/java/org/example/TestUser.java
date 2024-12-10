package org.example;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private final Logger logger = LoggerFactory.getLogger(TestUser.class);


    @Test
    public void testUserObject() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 通过id获取对应的对象
        User user = (User) context.getBean("user");
        user.run();
        logger.info("执行成功");
    }

    @Test
    public void testUserReflex() throws Exception {
        Class<?> clazz = Class.forName("org.example.User");

        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println("user:" + user);
        user.run();
    }


}
