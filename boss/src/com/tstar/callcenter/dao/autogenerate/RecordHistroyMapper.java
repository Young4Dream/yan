package com.tstar.callcenter.dao.autogenerate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tstar.callcenter.model.autogenerate.RecordHistroy;
import com.tstar.callcenter.model.autogenerate.RecordHistroyExample;

public interface RecordHistroyMapper {
    int countByExample(RecordHistroyExample example);

    int deleteByExample(RecordHistroyExample example);

    int deleteByPrimaryKey(long id);

    int insert(RecordHistroy record);

    int insertSelective(RecordHistroy record);

    List<RecordHistroy> selectByExample(RecordHistroyExample example);

    RecordHistroy selectByPrimaryKey(long id);

    int updateByExampleSelective(@Param("record") RecordHistroy record, @Param("example") RecordHistroyExample example);

    int updateByExample(@Param("record") RecordHistroy record, @Param("example") RecordHistroyExample example);

    int updateByPrimaryKeySelective(RecordHistroy record);

    int updateByPrimaryKey(RecordHistroy record);
}