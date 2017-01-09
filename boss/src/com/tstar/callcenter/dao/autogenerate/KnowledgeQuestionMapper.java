package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.KnowledgeQuestion;
import com.tstar.callcenter.model.autogenerate.KnowledgeQuestionExample;

public interface KnowledgeQuestionMapper {
    int countByExample(KnowledgeQuestionExample example);

    int deleteByExample(KnowledgeQuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KnowledgeQuestion record);

    int insertSelective(KnowledgeQuestion record);

    List<KnowledgeQuestion> selectByExample(KnowledgeQuestionExample example);

    KnowledgeQuestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") KnowledgeQuestion record, @Param("example") KnowledgeQuestionExample example);

    int updateByExample(@Param("record") KnowledgeQuestion record, @Param("example") KnowledgeQuestionExample example);

    int updateByPrimaryKeySelective(KnowledgeQuestion record);

    int updateByPrimaryKey(KnowledgeQuestion record);
}