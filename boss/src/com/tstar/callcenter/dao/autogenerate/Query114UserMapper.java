package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.Query114User;
import com.tstar.callcenter.model.autogenerate.Query114UserExample;

public interface Query114UserMapper {
    int countByExample(Query114UserExample example);

    int deleteByExample(Query114UserExample example);

    int insert(Query114User record);

    int insertSelective(Query114User record);

    List<Query114User> selectByExample(Query114UserExample example);

    int updateByExampleSelective(@Param("record") Query114User record, @Param("example") Query114UserExample example);

    int updateByExample(@Param("record") Query114User record, @Param("example") Query114UserExample example);
}