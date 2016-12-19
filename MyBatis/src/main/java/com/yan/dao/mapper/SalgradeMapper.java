package com.yan.dao.mapper;

import com.yan.po.Salgrade;
import com.yan.po.SalgradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalgradeMapper {
    int countByExample(SalgradeExample example);

    int deleteByExample(SalgradeExample example);

    int insert(Salgrade record);

    int insertSelective(Salgrade record);

    List<Salgrade> selectByExample(SalgradeExample example);

    int updateByExampleSelective(@Param("record") Salgrade record, @Param("example") SalgradeExample example);

    int updateByExample(@Param("record") Salgrade record, @Param("example") SalgradeExample example);
}