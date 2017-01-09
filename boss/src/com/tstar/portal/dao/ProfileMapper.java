package com.tstar.portal.dao;

import com.tstar.portal.model.Profile;

public interface ProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKey(Profile record);
    
    Profile selectByUk(String sectionName, String profileName);
}