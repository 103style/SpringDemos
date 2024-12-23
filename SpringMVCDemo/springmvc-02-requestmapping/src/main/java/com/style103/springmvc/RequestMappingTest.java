package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 21:42
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingTest {

    /**
     * RequestMapping 的 value是一个数组，可以配置多个地址对应同一个内容
     */
    @RequestMapping(value = {"/", "/home", "/index"})
    public String index() {
        return "index";
    }
}
