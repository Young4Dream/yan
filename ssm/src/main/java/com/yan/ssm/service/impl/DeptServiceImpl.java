package com.yan.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.ssm.dao.mapper.DeptMapper;
import com.yan.ssm.pojo.Dept;
import com.yan.ssm.pojo.DeptExample;
import com.yan.ssm.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
private DeptMapper deptMapper;
	@Override
	public int countByExample(DeptExample example) {
		// TODO Auto-generated method stub
		return deptMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(DeptExample example) {
		// TODO Auto-generated method stub
		return deptMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Short deptno) {
		// TODO Auto-generated method stub
		return deptMapper.deleteByPrimaryKey(deptno);
	}

	@Override
	public int insert(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insertSelective(record);
	}

	@Override
	public List<Dept> selectByExample(DeptExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept selectByPrimaryKey(Short deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Dept record, DeptExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Dept record, DeptExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
