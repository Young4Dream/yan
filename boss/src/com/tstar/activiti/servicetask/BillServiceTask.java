/**
 * 
 */
package com.tstar.activiti.servicetask;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.crm.service.OcsBillService;
import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class BillServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	@Resource
	private OcsBillService ocsBillService;

	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				// 更新用户状态、生效时间、账期日
				String userId = instance.getUserId();
				// 立即对用户订单进行累账并更新订单项状态（账务到期日）
				ocsBillService.generateOrderBill(userId);
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
