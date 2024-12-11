package org.example.bean.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public void addUserDao() {
        System.out.println("addUserDao");
    }
}
