package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 21:42
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingTest {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
