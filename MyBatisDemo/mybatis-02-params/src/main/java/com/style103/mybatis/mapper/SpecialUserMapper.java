package com.style103.mybatis.mapper;

import com.style103.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by 103style on 2024/12/16 21:50
 * github:https://github.com/103style
 */
public interface SpecialUserMapper {

    /**
     * 模糊查询用户名
     */
    List<User> getUserByLike(@Param("like") String like);


    /**
     * DELETE FROM t_user WHERE id = 6 OR id = 7
     * DELETE FROM t_user WHERE id IN(8,9)
     */
    void deleteUserById(@Param("startId") int startId, @Param("endId") int endId);

    /**
     * DELETE FROM t_user WHERE id IN(8,9)
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态传入 表名 和 id 来查数据
     */
    User selectUserByTableNameAndId(@Param("tableName") String tableName, @Param("id") int id);
}
