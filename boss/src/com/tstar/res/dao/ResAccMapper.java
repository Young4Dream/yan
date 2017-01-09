package com.tstar.res.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResAcc;

public interface ResAccMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResAcc record);

    int insertSelective(ResAcc record);

    ResAcc selectByPrimaryKey(String id);
    
    ResAcc selectByAcc(String acc);

    int updateByPrimaryKeySelective(ResAcc record);

    int updateByPrimaryKey(ResAcc record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<ResAcc> selectByPage(Map<String, Object> map);
    
    int lockAcc(String acc, Date unlockTime);
    
    int unlockAcc(String acc);
    
    int updateStatus(String acc, Integer status, String userName);
    
    String selectTopUsable(String pattern, String businessType);
}