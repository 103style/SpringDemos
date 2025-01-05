package com.style103.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2025/1/5 17:13
 * github:https://github.com/103style
 */
@Controller
public class TestViewController {

    /**
     * ThymeleafView
     */
    @RequestMapping("/testHello")
    public String testHello() {
        return "hello";
    }

    /**
     * 转发视图
     * org.springframework.web.servlet.view.InternalResourceView: [InternalResourceView]; URL [/testHello]
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testHello";
    }

    /**
     * 重定向视图
     * org.springframework.web.servlet.view.RedirectView: name [redirect:]; URL [/testHello]
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testHello";
    }

}
