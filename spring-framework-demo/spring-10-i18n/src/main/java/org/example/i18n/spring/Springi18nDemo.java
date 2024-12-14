package org.example.i18n.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * create by 103style on 2024/12/14 14:45
 */
public class Springi18nDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        String name = context.getMessage("name", null, Locale.getDefault());
        System.out.println(name);

        Object[] objs = new Object[]{"103style", new Date().toString()};
        String message = context.getMessage("message", objs, new Locale("en", "GB"));
        System.out.println(message);
    }
}
