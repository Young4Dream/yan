package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.SkillGroups;
import com.tstar.callcenter.model.autogenerate.SkillGroupsExample;

public interface SkillGroupsMapper {
    int countByExample(SkillGroupsExample example);

    int deleteByExample(SkillGroupsExample example);

    int deleteByPrimaryKey(long groupId);

    int insert(SkillGroups record);

    int insertSelective(SkillGroups record);

    List<SkillGroups> selectByExample(SkillGroupsExample example);

    SkillGroups selectByPrimaryKey(long groupId);

    int updateByExampleSelective(@Param("record") SkillGroups record, @Param("example") SkillGroupsExample example);

    int updateByExample(@Param("record") SkillGroups record, @Param("example") SkillGroupsExample example);

    int updateByPrimaryKeySelective(SkillGroups record);

    int updateByPrimaryKey(SkillGroups record);
}