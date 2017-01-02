package com.yan.ssm.dao.mapper;

import com.yan.ssm.pojo.Dept;
import com.yan.ssm.pojo.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DeptMapper {
    int countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Short deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Short deptno);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}