package org.example.iocimp;

import annotation.support.AnnotationApplicationContext;
import annotation.support.ApplicationContext;
import org.example.iocimp.service.IUserService;
import org.junit.Test;

public class TestIocImpl {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationApplicationContext("org.example.iocimp");
        IUserService userService = (IUserService) context.getBean(IUserService.class);
        userService.run();
    }
}
