package com.style103.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by 103style on 2025/1/13 22:32
 * github:https://github.com/103style
 */
@RestController
public class StartSprtingIOController {
    /**
     * 访问 http://localhost:8080/hello
     */
    @GetMapping("/hello")
    public String hello() {
        return "Create by start.spring.io!";
    }
}
