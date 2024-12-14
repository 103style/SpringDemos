package org.example.validation.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by 103style on 2024/12/14 15:59
 */
public class TestValidation {

    @Test
    public void testJakartaValidation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyJakartaValidation jakartaValidation = context.getBean(MyJakartaValidation.class);
        User user = new User();
        user.setName("Jakarta Validation");
        user.setAge(20);
        boolean result = jakartaValidation.validatorPerson(user);
        System.out.println(result);
    }

    @Test
    public void testSpringValidation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MySpringValidation springValidation = context.getBean(MySpringValidation.class);
        User user = new User();
        user.setName("Spring Validation");
        user.setAge(20);
        boolean result = springValidation.validatorPerson(user);
        System.out.println(result);
    }
}
