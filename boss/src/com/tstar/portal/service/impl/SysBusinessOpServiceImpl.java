/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysBusinessOpMapper;
import com.tstar.portal.model.SysBusinessOp;
import com.tstar.portal.service.SysBusinessOpService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysBusinessOpServiceImpl implements SysBusinessOpService {

	@Resource
	private SysBusinessOpMapper dao;
	
	public int countAll() {
		return dao.countAll();
	}

	public List<SysBusinessOp> selectByPage(int start, int length) {
		return dao.selectByPage(start, length);
	}

	public String[] update(SysBusinessOp obj) {
		int res = dao.updateByPrimaryKey(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

}
