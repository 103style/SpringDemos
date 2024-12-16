package com.style103.mybatis.mapper;

import com.style103.mybatis.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * created by 103style on 2024/12/16 10:59
 * github:https://github.com/103style
 */
public interface UserMapper {

    /**
     * 通过id查询信息
     */
    User getUserById(int id);

    /**
     * 通过username查询信息
     */
    User getUserByName(String username);

    /**
     * 查询全部的数据
     */
    List<User> getAllUser();

    /**
     * 通过id更新对应的username
     */
    void updateUserNameById(int id, String name);

    /**
     * @return 获取表里数据的总条数
     */
    int getUserCount();

    /**
     * 通过id查找数据信息 以map结构返回
     */
    Map<String, Object> getUserByIdToMap(@Param("id") int id);

    /**
     * 查找所有数据信息 以map结构返回
     */
    //        List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    List<Map<String, Object>> getAllUserToMap();

    /**
     * 通过实体类参数入库
     * insert into t_user (username, password) values (#{username}, #{password})
     * 需要用属性对应的名字做参数
     */
    void insertUser(User user);

    /**
     * 通过id删除对应的数据
     */
    void deleteUserById(@Param("id") int id);

}
