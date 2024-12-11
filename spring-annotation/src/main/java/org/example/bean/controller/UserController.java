package org.example.bean.controller;


import org.example.bean.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 第一种方式 属性注入
    @Autowired
    private IUserService service;

    public void addUser() {
        System.out.println("addUser, service:" + service);
        if (service != null) {
            service.addUserService();
        }
    }
}
