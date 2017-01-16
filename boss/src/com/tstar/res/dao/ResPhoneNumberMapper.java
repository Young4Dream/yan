package com.tstar.res.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResPhoneNumber;

public interface ResPhoneNumberMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResPhoneNumber record);

    int insertSelective(ResPhoneNumber record);

    ResPhoneNumber selectByPrimaryKey(String id);
    
    ResPhoneNumber selectByNumber(String phoneNo);

    int updateByPrimaryKeySelective(ResPhoneNumber record);

    int updateByPrimaryKey(ResPhoneNumber record);
    
    int countByCriteria(Map<String, Object> criteria);
    
    List<ResPhoneNumber> selectByPage(Map<String, Object> criteria);
    
    int updateStatus(String phoneNo, Integer status, String userName);
    
    int lockPhoneNumber(String phoneNo, Date unlockTime);
    
    int unlockPhoneNumber(String phoneNo);
    ResPhoneNumber findAreaByPhoneNumber(String phoneNumber);
}