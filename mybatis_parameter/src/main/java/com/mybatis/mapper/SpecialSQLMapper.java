package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 模糊查询
 */
public interface SpecialSQLMapper {
    List<User>  getUserByLike(@Param("mohu")String mohu);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户并获取她的id
     */
    void insertUser(User user);
}
