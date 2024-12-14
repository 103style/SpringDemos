package org.example.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * create by 103style on 2024/12/14 19:13
 * https://www.bilibili.com/video/BV1kR4y1b7Qc 61小节
 */
@Component
// 方式二
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
// 方式一
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringJunit5Test {

    @Autowired
    private User user;

    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }
}