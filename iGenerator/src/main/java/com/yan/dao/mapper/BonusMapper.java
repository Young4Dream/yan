package com.yan.dao.mapper;

import com.yan.pojo.Bonus;
import com.yan.pojo.BonusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusMapper {
    int countByExample(BonusExample example);

    int deleteByExample(BonusExample example);

    int insert(Bonus record);

    int insertSelective(Bonus record);

    List<Bonus> selectByExample(BonusExample example);

    int updateByExampleSelective(@Param("record") Bonus record, @Param("example") BonusExample example);

    int updateByExample(@Param("record") Bonus record, @Param("example") BonusExample example);
}