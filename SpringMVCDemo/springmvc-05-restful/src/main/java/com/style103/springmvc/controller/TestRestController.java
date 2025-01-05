package com.style103.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * create by 103style on 2025/1/5 17:36
 * github:https://github.com/103style
 * <p>
 * 查询所有的用户信息 /user --->get
 * 通过id查询用户信息 /user/1 --->get
 * 添加用户信息 /user --->post
 * 修改用户信息 /user --->put
 * 通过id删除用户信息 /user/1 --->delete
 *
 * put 和 delete 方法需要配置 HiddenHttpMethodFilter 过滤器
 * 1.form的method需要设置为 post
 * 2.需要增加一个 name="_method" type="hidden" value="put/delete"的input标签
 * <form method="post" th:action="@{/user}">
 *     <input name="_method" type="hidden" value="put">
 *     <input type="submit" value="修改用户信息">
 * </form>
 */
@Controller
public class TestRestController {


    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("查询所有的用户信息 /user --->get");
        return "success";
    }

    @GetMapping("/user/{id}")
    public String getAllUser(@PathVariable("id") Integer id) {
        System.out.println("通过id查询用户信息 /user/" + id + " --->get");
        return "success";
    }


    @PostMapping("/user")
    public String addUser() {
        System.out.println("添加用户信息 /user --->post");
        return "success";
    }


    @PutMapping("/user")
    public String updateUser() {
        System.out.println("修改用户信息 /user --->put");
        return "success";
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("通过id删除用户信息 /user/" + id + " --->delete");
        return "success";
    }
}
