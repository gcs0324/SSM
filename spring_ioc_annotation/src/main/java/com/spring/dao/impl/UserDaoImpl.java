package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
