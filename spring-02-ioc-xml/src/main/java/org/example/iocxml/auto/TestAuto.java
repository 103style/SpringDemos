package org.example.iocxml.auto;

import org.example.iocxml.auto.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAuto {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController controller = context.getBean("controller", UserController.class);
        controller.addUser();
    }
}
