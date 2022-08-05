package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.Map;

public interface UserMapper {

    User getUserByUsername(String username);

    //验证登录
    User checklogin(String username,String password);

    //以Map集合为参数验证登录
    User checkloginByMap(Map<String,String> map);

    //添加用户信息
    void insertUesr(User user);

}
