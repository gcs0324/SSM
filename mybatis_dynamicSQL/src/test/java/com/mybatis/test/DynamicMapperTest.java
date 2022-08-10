package com.mybatis.test;

import com.mybatis.mapper.DynamicSQLMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"",null,"");
        List<Emp> emps = mapper.getEmpByCondition(emp);
        for (int i = 0; i < emps.size(); i++) {
            System.out.println(emps.get(i));
        }
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明1", 20, "男");
        Emp emp2 = new Emp(null, "小明2", 20, "男");
        Emp emp3 = new Emp(null, "小明3", 20, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);
    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{5,6,7};
        mapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
}
