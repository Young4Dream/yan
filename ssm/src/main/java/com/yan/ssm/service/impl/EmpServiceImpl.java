package com.yan.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.ssm.dao.mapper.EmpMapper;
import com.yan.ssm.pojo.Emp;
import com.yan.ssm.pojo.EmpExample;
import com.yan.ssm.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
EmpMapper empMapper;
	@Override
	public int countByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return empMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return empMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Short empno) {
		// TODO Auto-generated method stub
		return empMapper.deleteByPrimaryKey(empno);
	}

	@Override
	public int insert(Emp record) {
		// TODO Auto-generated method stub
		return empMapper.insert(record);
	}

	@Override
	public int insertSelective(Emp record) {
		// TODO Auto-generated method stub
		return empMapper.insertSelective(record);
	}

	@Override
	public List<Emp> selectByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return empMapper.selectByExample(example);
	}

	@Override
	public Emp selectByPrimaryKey(Short empno) {
		// TODO Auto-generated method stub
		return empMapper.selectByPrimaryKey(empno);
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
