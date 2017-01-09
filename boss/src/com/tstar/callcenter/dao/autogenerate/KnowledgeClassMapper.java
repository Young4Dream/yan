package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.KnowledgeClass;
import com.tstar.callcenter.model.autogenerate.KnowledgeClassExample;

public interface KnowledgeClassMapper {
    int countByExample(KnowledgeClassExample example);

    int deleteByExample(KnowledgeClassExample example);

    int deleteByPrimaryKey(Long klcId);

    int insert(KnowledgeClass record);

    int insertSelective(KnowledgeClass record);

    List<KnowledgeClass> selectByExample(KnowledgeClassExample example);

    KnowledgeClass selectByPrimaryKey(Long klcId);

    int updateByExampleSelective(@Param("record") KnowledgeClass record, @Param("example") KnowledgeClassExample example);

    int updateByExample(@Param("record") KnowledgeClass record, @Param("example") KnowledgeClassExample example);

    int updateByPrimaryKeySelective(KnowledgeClass record);

    int updateByPrimaryKey(KnowledgeClass record);
}