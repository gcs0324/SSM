package com.mybatis.test;

import com.mybatis.mapper.SelectMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /**
     * 根据返回值不同，底层调用sqlsession的方法不同
     * 返回值为User：调用sqlSession.selectOne
     * 返回值为List<User>：调用sqlSession.selectList
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);//sqlSession.selectOne
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();//sqlSession.selectList
        for(User user:users){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testGetCountint(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        int count = mapper.getCountint();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testgetUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.getUserToMap(7);
        System.out.println(userToMap);
        sqlSession.close();
    }

    @Test
    public void testgetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> userToMaps = mapper.getAllUserToMap();
        System.out.println(userToMaps);
        sqlSession.close();
    }
}
