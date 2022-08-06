package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    //根据用户id查询用户信息
    User getUserById(@Param("id") int id);

    //查询所有用户信息
    List<User> getAllUser();

    //查询用户的总数量
    Integer getCount();

    int getCountint();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此
    时可以将这些map放在一个list集合中获取
     */
    List<Map<String, Object>> getAllUserToMap();

}
