package com.style103.springmvc.controller;

import com.style103.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

/**
 * create by 103style on 2025/1/5 22:50
 * github:https://github.com/103style
 */
@Controller
public class TestAjaxController {

    /**
     * @RequestParam 获取请求参数
     * @RequestBody 获取请求内容
     */
    @PostMapping("/test/ajax")
    public void testAjax(@RequestParam("id") Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("---------testAjax id:" + id);
        System.out.println("---------testAjax requestBody:" + requestBody);
        response.setContentType("text/plain"); // 设置响应内容类型
        response.getWriter().write("hello, ajax.");
    }

    /**
     * 使用@RequestBody注解将请求参数转换为实体类
     * 1.导入jackson的依赖
     * 2.springmvc.xml配置中需要开启  <mvc:annotation-driven/>
     * 3.在处理请求的方法形参设置json参数要转换的java实体类型，添加 @RequestBody注解
     */
    @PostMapping("/test/ajax/requestbody/json")
    public void testAjaxRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("---------testAjaxRequestBody user：" + user);
        response.getWriter().write("hello, ajax request body.");
    }

    /**
     * 也可以使用 map集合
     */
//    @PostMapping("/test/ajax/requestbody/json")
    public void testAjaxRequestBody(@RequestBody Map<String, Object> usermap, HttpServletResponse response) throws IOException {
        System.out.println("---------testAjaxRequestBody usermap：" + usermap);
        response.getWriter().write("hello, ajax request body.");
    }
}

