package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.Knowledge;
import com.tstar.callcenter.model.autogenerate.KnowledgeExample;

public interface KnowledgeMapper {
    int countByExample(KnowledgeExample example);

    int deleteByExample(KnowledgeExample example);

    int deleteByPrimaryKey(Long klId);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    List<Knowledge> selectByExampleWithBLOBs(KnowledgeExample example);

    List<Knowledge> selectByExample(KnowledgeExample example);

    Knowledge selectByPrimaryKey(Long klId);

    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExampleWithBLOBs(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKeyWithBLOBs(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
}