/**
 * 
 */
package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidFeeMapper;
import com.tstar.ocs.dao.SidOpMapper;
import com.tstar.ocs.model.SidFee;
import com.tstar.ocs.model.SidOp;
import com.tstar.ocs.service.SidOpService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SidOpServiceImpl implements SidOpService {

	@Resource
	private SidOpMapper daoSidOp;
	
	@Resource 
	private SidFeeMapper daoSidFee;
	
	public List<SidOp> selectByPage(int start, int length) {
		List<SidOp> lst = daoSidOp.selectByPage(start, length);
		if (lst != null && lst.size() > 0) { 
			for (SidOp obj : lst) {
				List<SidFee> fees = daoSidFee.selectOpFee(obj.getId());
				String feeItems = "";
				if (fees != null && fees.size() > 0) {
					for (SidFee fee : fees) {
						if (feeItems.length() > 0) {
							feeItems += "，";
						}
						feeItems += fee.getName();
					}
				}
				obj.setFeeItems(feeItems);
			}
		}
		return lst;
	}
	
	public int countAll() {
		return daoSidOp.countAll();
	}

	public String[] insert(SidOp obj) {
		obj.setId(UUID.get());
		int res = daoSidOp.insert(obj);
		if (res > 0) {
			saveOpFee(obj.getId(), obj.getFeeItems());
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidOp obj) {
		int res = daoSidOp.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			saveOpFee(obj.getId(), obj.getFeeItems());
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}
	
	public String[] updateModelKey(SidOp obj) {
		int res = daoSidOp.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = daoSidOp.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
	private void saveOpFee(String opId, String feeIds) {
		daoSidOp.deleteOpFee(opId);
		if (feeIds == null || "".equals(feeIds)) return;
		String[] ids = feeIds.split(",");
		if (ids.length == 0) return;
		for (String feeId : ids) {
			String id = UUID.get();
			daoSidOp.insertOpFee(id, opId, feeId);
		}
	}
	
}
