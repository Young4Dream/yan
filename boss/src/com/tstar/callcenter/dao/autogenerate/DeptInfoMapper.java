package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.DeptInfo;
import com.tstar.callcenter.model.autogenerate.DeptInfoExample;

public interface DeptInfoMapper {
    int countByExample(DeptInfoExample example);

    int deleteByExample(DeptInfoExample example);

    int deleteByPrimaryKey(long deptId);

    int insert(DeptInfo record);

    int insertSelective(DeptInfo record);

    List<DeptInfo> selectByExample(DeptInfoExample example);

    DeptInfo selectByPrimaryKey(long deptId);

    int updateByExampleSelective(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    int updateByExample(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    int updateByPrimaryKeySelective(DeptInfo record);

    int updateByPrimaryKey(DeptInfo record);
}