package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /*
     * 用到了工厂模式和代理模式
     */
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取Sql的会话对象SqlSession(不会自动提交事务)，是Mybatis提供的操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*
        //获取Sql的会话对象SqlSession(会自动提交事务)，不用commmit
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        */
        //获取UserMapper的代理实现类对象
        /*
         * 代理模式
         * 自动创建实例对象，执行sql语句
         *
         * 创建接口的实现类(代理实现类对象)，然后将实现类的对象进行返回
         */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        /*
         * 底层的实现原理
         * 在实现类中重写接口的方法
         * 根据唯一的标识找到sql并执行，唯一标识是namespace.sqlId
         * int result = sqlSession.insert("com.mybatis.mapper.UserMapper.insertUser");
         */
        int result = mapper.insertUser();
        System.out.println(result);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        sqlSession.close();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }
}
