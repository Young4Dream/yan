/**
 * 
 */
package com.tstar.ocs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidFeeMapper;
import com.tstar.ocs.dao.SidOpMapper;
import com.tstar.ocs.model.SidFee;
import com.tstar.ocs.model.SidOp;
import com.tstar.ocs.service.SidFeeService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SidFeeServiceImpl implements SidFeeService {

	@Resource
	private SidFeeMapper daoSidFee;
	
	@Resource
	private SidOpMapper daoSidOp;
	
	public List<SidFee> selectByPage(int start, int length) {
		return daoSidFee.selectByPage(start, length);
	}

	public List<SidFee> selectAll() {
		return daoSidFee.selectAll();
	}
	
	public List<SidFee> selectOpFee(String opId) {
		return daoSidFee.selectOpFee(opId);
	}
	
	public List<SidFee> selectOpFeeByName(String name) {
		SidOp sidOp = daoSidOp.selectByName(name);
		if (sidOp == null) {
			return new ArrayList<SidFee>();
		} else {
			return daoSidFee.selectOpFee(sidOp.getId());
		}
	}

	public int countAll() {
		return daoSidFee.countAll();
	}

	public String[] insert(SidFee obj) {
		obj.setId(UUID.get());
		int res = daoSidFee.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidFee obj) {
		int res = daoSidFee.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}
	
	public String[] delete(String id) {
		int res = daoSidFee.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
