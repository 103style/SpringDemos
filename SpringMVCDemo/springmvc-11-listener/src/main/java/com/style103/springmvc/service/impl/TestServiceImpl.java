package com.style103.springmvc.service.impl;

import com.style103.springmvc.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * create by 103style on 2025/1/12 22:27
 * github:https://github.com/103style
 */
@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void test() {
        System.out.println("---TestServiceImpl, ---test");
    }
}
