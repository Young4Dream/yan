/**
 * 
 */
package com.tstar.ac.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.dao.AcCommandMapper;
import com.tstar.ac.model.AcAction;
import com.tstar.ac.model.AcCommand;
import com.tstar.ac.service.AcActionService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class AcActionServiceImpl implements AcActionService {

	@Resource
	private AcActionMapper daoAcAction;
	@Resource
	private AcCommandMapper daoAcCommand;
	
	public int countByCriteria(Map<String, Object> map) {
		return daoAcAction.countByCriteria(map);
	}

	public List<AcAction> selectByPage(Map<String, Object> map) {
		return daoAcAction.selectByPage(map);
	}

	public List<AcCommand> selectCmdsByActId(String actionId) {
		return daoAcCommand.selectByActionId(actionId);
	}

	public String[] reset(String actionId) {
		daoAcCommand.deleteByActionId(actionId);
		int res = daoAcAction.updateStatusByPrimaryKey(actionId);
		if (res > 0) {
			return new String[]{"0", "重置成功"};
		} else {
			return new String[]{"1", "重置失败"};
		}
	}

}
