package org.example.bean.service;


import org.example.bean.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    // 第一种方式 属性注入
    @Autowired
    private IUserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("addUserService userDao:" + userDao);
        if (userDao != null) {
            userDao.addUserDao();
        }
    }
}
