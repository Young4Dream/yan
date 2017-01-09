/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.Date;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class ResetCompletedServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserMapper daoCrmUser;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		System.out.println("reset completed handler=====================================");
		System.out.println("instanceId=" + instanceId);
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				System.out.println("instanceId=" + instance.getId());
				Date now = new Date();
				// 更新用户地址
				String userId = instance.getUserId();
				System.out.println("userId=" + userId);
				if (!StringUtil.isEmpty(userId)) {
					CrmUser user = new CrmUser();
					user.setId(userId);
					user.setStatus(Integer.parseInt(instance.getBusinessOpParms()));
					/*
					if ("3".equals(instance.getBusinessOpParms())) {
						user.setStatus(3);
					} else {
						user.setStatus(2);
					} */
					user.setUpdateTime(now);
					daoCrmUser.updateByPrimaryKeySelective(user);
					System.out.println("update user status: " + instance.getBusinessOpParms());
				}
				// 更新流程信息状态
				instance.setStatus(9);
				daoJobOpInstance.updateByPrimaryKey(instance);
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

}
