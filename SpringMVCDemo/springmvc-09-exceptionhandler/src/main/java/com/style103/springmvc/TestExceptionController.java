package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2025/1/11 23:27
 * github:https://github.com/103style
 */
@Controller
public class TestExceptionController {

    @RequestMapping("/test/exception")
    public String testException() {
        int a = 1 / 0;
        return "success";
    }
}
