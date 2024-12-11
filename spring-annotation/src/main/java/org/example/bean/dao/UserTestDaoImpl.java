package org.example.bean.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserTestDaoImpl implements IUserDao {
    @Override
    public void addUserDao() {
        System.out.println("UserTestDaoImpl: addUserDao");
    }
}
