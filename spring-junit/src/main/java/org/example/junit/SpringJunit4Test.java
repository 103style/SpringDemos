package org.example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * create by 103style on 2024/12/14 21:18
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringJunit4Test {

    @Autowired
    private User user;

    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }
}
