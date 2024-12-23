package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * create by 103style on 2024/12/23 22:03
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingMethodTest {

    /**
     * method 也是数组类型，可以同时配置 get 和 post
     */
    @RequestMapping(value = {"/gettest"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "success";
    }

    /**
     * @GetMapping =  @RequestMapping(method = {RequestMethod.GET})
     */
    @GetMapping(value = {"/getMethod"})
    public String getMethod() {
        return "success";
    }

    /**
     * @PostMapping =  @RequestMapping(method = {RequestMethod.POST})
     */
    @PostMapping(value = {"/postMethod"})
    public String postMethod() {
        return "success";
    }

    /**
     * @PutMapping =  @RequestMapping(method = {RequestMethod.PUT})
     */
    @PutMapping(value = {"/putMethod"})
    public String putMethod() {
        return "success";
    }

}
