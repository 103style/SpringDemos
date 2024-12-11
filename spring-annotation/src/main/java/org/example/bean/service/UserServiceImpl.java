package org.example.bean.service;


import org.example.bean.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    // 第一种方式 属性注入
//    @Autowired
//    private IUserDao userDao;

    // 第二种方式 方法注入
//    private IUserDao userDao;
//
//    @Autowired
//    public void setUserDao(IUserDao userDao) {
//        this.userDao = userDao;
//    }


//    // 第三种方式 构造函数注入
//    private IUserDao userDao;
//    @Autowired
//    public UserServiceImpl(IUserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第四种方式 行参注入
    private final IUserDao userDao;
    public UserServiceImpl(@Autowired IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("addUserService userDao:" + userDao);
        if (userDao != null) {
            userDao.addUserDao();
        }
    }
}
