package com.style103.springmvc;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

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
}

