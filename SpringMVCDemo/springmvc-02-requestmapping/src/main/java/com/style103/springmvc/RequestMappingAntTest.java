package com.style103.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 103style on 2024/12/23 22:52
 * github:https://github.com/103style
 */
@Controller
public class RequestMappingAntTest {
    /**
     * 可以在路径中添加 ?、*、** 三个匹配符
     * ?:表示任意的单个字符（不包括 ? 这些特殊字符）
     * *:表示任意的0个或多个字符（不包括 ? 这些特殊字符）
     * **:匹配任意层数的任意目录， 前后不能有其他字符，**只能写在双斜线中
     */
    @RequestMapping(value = {"/anttest1/a?a"})
    public String antTest1() {
        return "success";
    }

    @RequestMapping(value = {"/anttest2/a*a"})
    public String antTest2() {
        return "success";
    }

    @RequestMapping(value = {"/anttest3/**"})
    public String antTest3() {
        return "success";
    }

}
