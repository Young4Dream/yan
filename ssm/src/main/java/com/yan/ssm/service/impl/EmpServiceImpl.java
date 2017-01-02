package com.yan.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yan.ssm.pojo.Emp;
import com.yan.ssm.pojo.EmpExample;
import com.yan.ssm.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{

	@Override
	public int countByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Short empno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Emp> selectByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp selectByPrimaryKey(Short empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Emp record, EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Emp record, EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
