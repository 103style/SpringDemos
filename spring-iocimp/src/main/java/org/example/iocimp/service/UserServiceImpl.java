package org.example.iocimp.service;

import annotation.Bean;
import annotation.DI;
import org.example.iocimp.dao.IUserDao;

@Bean
public class UserServiceImpl implements IUserService {

    @DI
    private IUserDao userDao;

    @Override
    public void run() {
        System.out.println("service run.....");
        if (userDao != null) {
            userDao.run();
        }
    }
}
