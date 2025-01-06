package com.style103.springmvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by 103style on 2024/12/26 22:12
 * github:https://github.com/103style
 */
@Controller
public class GetRequestParamTest {

    @RequestMapping("/get_param")
    public String paramIndex() {
        return "params";
    }

    /**
     * Spring5.6+版本 用 javax.servlet 会报错
     * 需要替换成 jakarta.servlet 依赖
     */
    @RequestMapping("/by_http_servlet_request")
    public String get(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }


    @RequestMapping("/by_param_name")
    public String getParams(String username, String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/by_param_name2")
    public String getParams2(
            @RequestParam(value = "username", required = true, defaultValue = "103style") String name,
            @RequestParam(value = "password", required = true, defaultValue = "123123") String password
    ) {
        System.out.println("username: " + name + ", password: " + password);
        return "success";
    }


    @RequestMapping("/by_param_name3")
    public String getParams3(
            @RequestParam(value = "username", required = true, defaultValue = "103style") String name,
            @RequestParam(value = "password", required = true, defaultValue = "123123") String password,
            @RequestHeader("referer") String referer
    ) {
        System.out.println("username: " + name + ", password: " + password + ", referer: " + referer);
        return "success";
    }

    @RequestMapping("/by_pojo")
    public String getParams3(User user) {
        System.out.println("user: " + user);
        return "success";
    }
}
