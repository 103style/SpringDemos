package org.example.iocxml.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    @Test
    public void testSetter() {
        // set方法注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);

        // 构造器注入
        Book book2 = context.getBean("bookConstruct", Book.class);
        System.out.println(book);
    }
}
