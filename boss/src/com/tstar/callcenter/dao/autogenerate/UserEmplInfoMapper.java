package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.UserEmplInfo;
import com.tstar.callcenter.model.autogenerate.UserEmplInfoExample;

public interface UserEmplInfoMapper {
    int countByExample(UserEmplInfoExample example);

    int deleteByExample(UserEmplInfoExample example);

    int insert(UserEmplInfo record);

    int insertSelective(UserEmplInfo record);

    List<UserEmplInfo> selectByExample(UserEmplInfoExample example);

    int updateByExampleSelective(@Param("record") UserEmplInfo record, @Param("example") UserEmplInfoExample example);

    int updateByExample(@Param("record") UserEmplInfo record, @Param("example") UserEmplInfoExample example);
}