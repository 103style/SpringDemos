package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 21:49
 * github:https://github.com/103style
 */
@Controller
@RequestMapping("/position")
public class RequestMappingPositionTest {

    @RequestMapping("/index")
    public String index() {
        // 对应的访问链接是 /position/index
        return "position";
    }

    @RequestMapping("/position")
    public String position() {
        // 对应的访问链接是 /position/index
        return "position";
    }
}
