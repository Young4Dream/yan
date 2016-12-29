package com.yan.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.yan.po.Emp;

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
}