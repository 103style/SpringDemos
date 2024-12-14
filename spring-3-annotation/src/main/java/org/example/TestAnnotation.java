package org.example;

import org.example.bean.User;
import org.example.bean.controller.UserController;
import org.example.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    /**
     * 1.bean.xml配置自动扫描
     * 2.给对应的类配置注解 @Component
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    /**
     * 1.bean.xml配置自动扫描
     * 2.给对应的类配置注解 @Repository @Servic @Controller
     * 3.给对应的属性配置注解 @Autowired
     */
    @Test
    public void testAutoWired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.addUser();
    }

    /**
     * 通过配置累的方式，完成注入， 不需要写xml配置
     */
    @Test
    public void testConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.addUser();
    }
}
