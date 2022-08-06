package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    User getUserByUsername(String username);

    //验证登录
    User checklogin(String username,String password);

    //以Map集合为参数验证登录
    User checkloginByMap(Map<String,String> map);

    //验证登录(使用@Param)
    User checkloginByParam(@Param("username") String username, @Param("password") String password);

    //添加用户信息
    void insertUesr(User user);

}
