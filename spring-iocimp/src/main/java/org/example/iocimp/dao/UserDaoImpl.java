package org.example.iocimp.dao;

import annotation.Bean;

@Bean
public class UserDaoImpl implements IUserDao {
    @Override
    public void run() {
        System.out.println("dao run....");
    }
}
