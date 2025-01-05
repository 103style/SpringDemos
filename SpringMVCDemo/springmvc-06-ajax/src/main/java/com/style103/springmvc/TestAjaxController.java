package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by 103style on 2025/1/5 22:50
 * github:https://github.com/103style
 */
@Controller
public class TestAjaxController {

    @PostMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        response.getWriter().write("hello, ajax.");
    }
}
