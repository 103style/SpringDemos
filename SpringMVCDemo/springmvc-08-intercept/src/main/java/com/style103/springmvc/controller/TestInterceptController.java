package com.style103.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2025/1/11 22:00
 * github:https://github.com/103style
 */

@Controller
public class TestInterceptController {

    @RequestMapping("/test/hello")
    public String hello() {
        return "success";
    }
}
