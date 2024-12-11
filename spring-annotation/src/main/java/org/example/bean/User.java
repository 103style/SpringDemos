package org.example.bean;

import org.springframework.stereotype.Component;

@Component(value = "user") // 等价于 <bean id="user" class="...."/>
//@Repository(value = "user")
//@Service(value = "user")
//@Controller(value = "user")
// 四个注解都可以，主要是不同的注解用于标识处理不同的功能类
public class User {
}
