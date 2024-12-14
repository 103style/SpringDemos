package org.example.iocxml.auto.controller;

import org.example.iocxml.auto.service.IUserService;

public class UserController {

    private IUserService service;

    public void setService(IUserService service) {
        this.service = service;
    }

    public void addUser() {
        System.out.println("addUser");

//        IUserService service = new UserServiceImpl();
//        service.addUserService();

        if (service != null) {
            service.addUserService();
        }
    }
}
