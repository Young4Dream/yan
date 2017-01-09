/**
 * 
 */
package com.tstar.activiti.servicetask;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.crm.dao.CrmUserPhoneMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class AdjustCompletedServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserPhoneMapper daoCrmUserPhone;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		System.out.println("Adjust Phone Level");
		System.out.println("BusinessKey=" + instanceId);
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			System.out.println(instance.getBusinessOpParms());
			if (instance != null) {
				// 更新用户级别
				String userId = instance.getUserId();
				System.out.println("userId=" + userId);
				if (!StringUtil.isEmpty(userId)) {
					CrmUserPhone userPhone = new CrmUserPhone();
					userPhone.setId(userId);
					userPhone.setPhoneLevel((String)execution.getVariable("newPhoneLevel"));
					System.out.println(userPhone.getPhoneLevel());
					daoCrmUserPhone.updateByPrimaryKeySelective(userPhone);
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
