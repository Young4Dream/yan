/**
 * 
 */
package com.tstar.activiti.servicetask;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.dao.CrmOrderMapper;
import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserBroadMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CrmUserPhoneMapper;
import com.tstar.crm.dao.CrmUserPlMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class SetupCancelServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserMapper daoUser;
	@Resource
	private CrmUserPhoneMapper daoUserPhone;
	@Resource
	private CrmUserAdslMapper daoUserAdsl;
	@Resource 
	private CrmUserBroadMapper daoUserBroad;
	@Resource
	private CrmUserPlMapper daoUserPl;
	
	@Resource
	private CrmOrderMapper dao;
	
	@Resource
	private CrmOrderItemMapper daoOrderItem;
	
	@Resource
	private ResPhoneNumberMapper daoPhoneNumber;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance == null) { return; }
			String userId = instance.getUserId();
			CrmUser user = daoUser.selectByPrimaryKey(userId);
			if (user != null) {
				// 删除订单信息
				daoOrderItem.deleteByOrderId(userId);
				dao.deleteByPrimaryKey(userId);
				if ("p".equals(user.getBusinessKey())) {
					daoUserPhone.deleteByPrimaryKey(userId);
					// 解锁电话号码
					daoPhoneNumber.unlockPhoneNumber(user.getBusinessKey());
				} else if ("a".equals(user.getBusinessKey())) {
					daoUserAdsl.deleteByPrimaryKey(userId);
				} else if ("b".equals(user.getBusinessKey())) {
					daoUserBroad.deleteByPrimaryKey(userId);
				} else if ("l".equals(user.getBusinessKey())) {
					daoUserPl.deleteByPrimaryKey(userId);
				}
				// 删除用户信息
				daoUser.deleteByPrimaryKey(userId);
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

}
