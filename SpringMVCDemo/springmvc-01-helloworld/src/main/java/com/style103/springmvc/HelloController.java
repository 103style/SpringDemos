package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/22 14:33
 * github:https://github.com/103style
 * 本地安装的
 *  apache-maven-3.9.9
 *  apache-tomcat-10.1.34
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        // 返回逻辑视图
        // index 对应 /WEB-INF/templates/index.html
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        // 对应 /WEB-INF/templates/hello.html
        return "hello";
    }
}
