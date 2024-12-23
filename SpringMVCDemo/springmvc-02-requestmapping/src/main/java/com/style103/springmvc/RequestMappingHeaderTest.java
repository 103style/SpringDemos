package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 22:42
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingHeaderTest {

    /**
     * headers={"referer"}：通过请求头匹配，不匹配会报错 404
     * 1."referer"：表示请求头必须携带 referer 参数
     * 2."!referer"：表示请求头一定不能携带 referer 参数
     * 3."referer=value"：表示请求头必须携带 referer 参数，并且值要等于value
     * 4."referer!=value"：表示请求头如果携带 referer，值一定不能为value，可以不带 referer
     */
    @RequestMapping(value = {"/header"}, headers = {"referer"})
    public String headerTest() {
        return "success";
    }
}
