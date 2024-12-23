package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 23:12
 * github:https://github.com/103style
 * <p>
 * 路径中的占位符测试
 */
@Controller
public class RequestMappingPlaceholderTest {

    /**
     * @PathVariable 配置参数获取对应的占位符
     */
    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
}
