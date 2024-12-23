package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * create by 103style on 2024/12/23 22:17
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingParamTest {


    /**
     * params = {"username"}：通过属性参数匹配，参数不匹配会报错 400
     * 1."username"：表示请求必须携带 username 参数
     * 2."!username"：表示请求一定不能携带 username 参数
     * 3."username=value"：表示请求必须携带 username 参数，并且值要等于value
     * 4."username!=value"：表示请求如果携带 username参数，值一定不能为value，可以不带username参数
     */
    @RequestMapping(value = {"/paramtest1"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"username"})
    public String paramtest1() {
        return "success";
    }

    @RequestMapping(value = {"/paramtest2"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"!username"})
    public String paramtest2() {
        return "success";
    }

    @RequestMapping(value = {"/paramtest3"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"username=haha"})
    public String paramtest3() {
        return "success";
    }

    @RequestMapping(value = {"/paramtest4"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"username!=haha"})
    public String paramtest4() {
        return "success";
    }
}
