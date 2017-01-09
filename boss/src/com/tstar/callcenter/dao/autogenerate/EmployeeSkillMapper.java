package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.EmployeeSkill;
import com.tstar.callcenter.model.autogenerate.EmployeeSkillExample;

public interface EmployeeSkillMapper {
    int countByExample(EmployeeSkillExample example);

    int deleteByExample(EmployeeSkillExample example);

    int deleteByPrimaryKey(long id);

    int insert(EmployeeSkill record);

    int insertSelective(EmployeeSkill record);

    List<EmployeeSkill> selectByExample(EmployeeSkillExample example);

    EmployeeSkill selectByPrimaryKey(long id);

    int updateByExampleSelective(@Param("record") EmployeeSkill record, @Param("example") EmployeeSkillExample example);

    int updateByExample(@Param("record") EmployeeSkill record, @Param("example") EmployeeSkillExample example);

    int updateByPrimaryKeySelective(EmployeeSkill record);

    int updateByPrimaryKey(EmployeeSkill record);
}