package org.example.bean.service;


import org.example.bean.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

//    // 第四种方式 形参注入
//    private final IUserDao userDao;
//    public UserServiceImpl(@Autowired IUserDao userDao) {
//        this.userDao = userDao;
//    }

//    // 第五种方式 ⚠️⚠️⚠️当只有一个构造函数时⚠️⚠️⚠️，可以不添加 @Autowired 注解，也能完成注入
//    private final IUserDao userDao;
//    public UserServiceImpl( IUserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第六种方式 通过两个注解，添加 @Qualifier 根据名称来注入。
    @Autowired
    @Qualifier(value = "userTestDaoImpl")
    private IUserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("addUserService userDao:" + userDao);
        if (userDao != null) {
            userDao.addUserDao();
        }
    }
}
