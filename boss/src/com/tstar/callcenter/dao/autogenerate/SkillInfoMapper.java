package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.SkillInfo;
import com.tstar.callcenter.model.autogenerate.SkillInfoExample;

public interface SkillInfoMapper {
    int countByExample(SkillInfoExample example);

    int deleteByExample(SkillInfoExample example);

    int deleteByPrimaryKey(long skillId);

    int insert(SkillInfo record);

    int insertSelective(SkillInfo record);

    List<SkillInfo> selectByExample(SkillInfoExample example);

    SkillInfo selectByPrimaryKey(long skillId);

    int updateByExampleSelective(@Param("record") SkillInfo record, @Param("example") SkillInfoExample example);

    int updateByExample(@Param("record") SkillInfo record, @Param("example") SkillInfoExample example);

    int updateByPrimaryKeySelective(SkillInfo record);

    int updateByPrimaryKey(SkillInfo record);
}