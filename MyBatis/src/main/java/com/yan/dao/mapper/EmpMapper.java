package com.yan.dao.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yan.po.Emp;
import com.yan.po.EmpExample;

public interface EmpMapper {
	/**
	 * 通过association级联查询员工所在部门信息
	 * @param empno
	 * @return
	 */
	Emp findByAss(short empno);
	/**
	 * 通过id获取员工信息
	 * @param i
	 * @return
	 */
    Emp selectByPrimaryKey(short i);
    /**
     * 通过JavaBean、动态if获取员工信息
     * 如果empno不为空，那么以empno为准查询
     * 如果empno为空，那么以ename字段进行模糊查询
     * @return
     */
    Emp selectByDynParamsIf(Emp emp);
    /**
     * 通过JavaBean、动态choose获取员工信息
     * 若empno不为空，则只以empno为准查询
     * 若empno为空但ename不为空，则以ename为准模糊查询
     * 否则只取第一行记录
     * @param emp
     * @return
     */
    Emp selectByDynParamsChoose(Emp emp);
    /**
     * 通过foreach获取部门id在一定范围内的员工信息
     * 除了例子中的数组类型参数，也可以遍历List、Set、Map等集合
     */
    List<Emp> selectByDynParamsForeach(List<Short> deptnos);
    /**
     * 通过bind元素预处理参数来查询员工信息
     */
    Emp selectByDynParamsBind(@Param("ename") String ename,@Param("sal")BigDecimal sal );
    /**
     * 通过自动生成的模板查询
     */
    List<Emp> selectByExample(EmpExample example);
}