package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2025/1/11 23:27
 * github:https://github.com/103style
 */
@Controller
@ControllerAdvice //将当前的类表示为异常处理的组件
public class TestExceptionController {

    @RequestMapping("/test/exception")
    public String testException() {
        int a = 1 / 0;
        return "success";
    }

    // 配置要处理的异常
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        System.out.println("-------handleException ex:" + ex);
        System.out.println("-------handleException ex:" + ex);
        model.addAttribute("ex", ex);
        return "error";
    }
}
