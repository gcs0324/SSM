package com.mybatis.test;

import com.mybatis.mapper.SpecialSQLMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper specialSQLMapper=sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = specialSQLMapper.getUserByLike("1");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper specialSQLMapper=sqlSession.getMapper(SpecialSQLMapper.class);
        specialSQLMapper.deleteMoreUser("8,9,10");
        sqlSession.close();
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper specialSQLMapper=sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = specialSQLMapper.getUserList("t_user");
        for(User u:users){
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper specialSQLMapper=sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"xiaoming","123456",23,"男","1231445@qq.com");
        specialSQLMapper.insertUser(user);
        sqlSession.close();
        System.out.println(user);
    }
}
