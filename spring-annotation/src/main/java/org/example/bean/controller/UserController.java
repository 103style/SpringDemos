package org.example.bean.controller;


import org.example.bean.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 第一种方式 属性注入
//    @Autowired
//    private IUserService service;


    // 第二种方式 set方法注入
//    private IUserService service;
//    @Autowired
//    public void setService(IUserService service) {
//        this.service = service;
//    }

    // 第三种方式构造函数注入
//    private IUserService service;
//    @Autowired
//    public UserController(IUserService service) {
//        this.service = service;
//    }


    // 第四种方式 行参注入
    private IUserService service;
    public UserController(@Autowired IUserService service) {
        this.service = service;
    }

    public void addUser() {
        System.out.println("addUser, service:" + service);
        if (service != null) {
            service.addUserService();
        }
    }
}
