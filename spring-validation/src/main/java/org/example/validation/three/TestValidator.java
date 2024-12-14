package org.example.validation.three;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by 103style on 2024/12/14 17:10
 */
public class TestValidator {

    @Test
    public void testMethodValidation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        ValidatorService service = context.getBean(ValidatorService.class);
        Teacher teacher = new Teacher();
        teacher.setName("John");
//        teacher.setPhone("123123");
        teacher.setPhone("13313313322");
        service.validator(teacher);
    }
}
