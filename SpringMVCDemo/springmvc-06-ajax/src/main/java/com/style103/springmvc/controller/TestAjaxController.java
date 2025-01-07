package com.style103.springmvc.controller;

import com.style103.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by 103style on 2025/1/5 22:50
 * github:https://github.com/103style
 */
@Controller
//@RestController 相当于@Controller和给每个方法加上@ResponseBody注解
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

    /**
     * @ResponseBody 注解表示 将方法的返回值作为请求的响应体
     */
    @GetMapping("/test/reponsebody")
    @ResponseBody
    public String testResponseBody() {
        return "this is testResponseBody";
    }


    /**
     * 使用@ResponseBody注解 响应浏览器json格式的数据
     * 1.导入jackson的依赖
     * 2.springmvc.xml配置中需要开启  <mvc:annotation-driven/>
     * 3.将要转换为json返回的java对象作为返回值
     * 4.方法添加@ResponseBody注解
     */
    @GetMapping("/test/responsebody/json")
    @ResponseBody
    public User testResponseBodyJson() {
        User user = new User(1, "103style", "123", 21, "男");
        return user;
    }

    /**
     * 返回map
     */
//    @GetMapping("/test/responsebody/json")
//    @ResponseBody
//    public Map<String, Object> testResponseBodyJson() {
//        Map<String, Object> map = new HashMap<>();
//        User user1 = new User(1, "103style1", "123", 21, "男");
//        User user2 = new User(2, "103style2", "123", 21, "男");
//        User user3 = new User(3, "103style3", "123", 21, "男");
//        map.put(user1.getId().toString(), user1);
//        map.put(user2.getId().toString(), user2);
//        map.put(user3.getId().toString(), user3);
//        return map;
//    }

    /**
     * 返回list
     */
//    @GetMapping("/test/responsebody/json")
//    @ResponseBody
//    public List<User> testResponseBodyJson() {
//        List<User> list = new ArrayList<>();
//        User user1 = new User(1, "103style1", "123", 21, "男");
//        User user2 = new User(2, "103style2", "123", 21, "男");
//        User user3 = new User(3, "103style3", "123", 21, "男");
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        return list;
//    }
}

