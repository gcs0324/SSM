package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询获取员工以及对应的部门信息的第二步
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
}
