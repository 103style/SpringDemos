package org.example.iocxml.diothertype;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {

    @Test
    public void testStudent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-other-type.xml");
        Student studentA = context.getBean("studentA", Student.class);
        System.out.println(studentA);

        Student studentB = context.getBean("studentB", Student.class);
        System.out.println(studentB);
    }
}
