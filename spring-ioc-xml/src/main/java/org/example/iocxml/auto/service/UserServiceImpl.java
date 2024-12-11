package org.example.iocxml.auto.service;

import org.example.iocxml.auto.dao.IUserDao;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("addUserService");
//        IUserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();

        if (userDao != null) {
            userDao.addUserDao();
        }
    }
}
