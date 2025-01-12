package com.style103.springmvc.controller;

import com.style103.springmvc.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * create by 103style on 2025/1/12 22:27
 * github:https://github.com/103style
 */
@Controller
public class TestController {

    @Autowired
    private ITestService testService;

}
