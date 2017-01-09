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
import com.tstar.res.dao.ResAccMapper;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.res.model.ResAcc;
import com.tstar.res.model.ResPhoneNumber;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class DeleteCompletedServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserMapper daoCrmUser;
	
	@Resource
	private ResPhoneNumberMapper daoResPhoneNumber;
	@Resource
	private ResAccMapper daoResAcc;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				Date now = new Date();
				// 更新用户状态、失效时间
				String userId = instance.getUserId();
				if (!StringUtil.isEmpty(userId)) {
					CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
					user.setStatus(91);
					user.setExpiryTime(now);
					daoCrmUser.updateByPrimaryKey(user);
					if ("p".equals(user.getBusinessType())) {
						// 如果是电话业务，释放号码资源
						ResPhoneNumber phoneNumber = daoResPhoneNumber.selectByNumber(user.getBusinessKey());
						phoneNumber.setCustomerName("");
						phoneNumber.setStatus(2);
						// 解锁时间为三个月后
						phoneNumber.setUnlockTime(DateUtil.addMonth(now, 3));
						daoResPhoneNumber.updateByPrimaryKey(phoneNumber);
					} else if ("a".equals(user.getBusinessType()) || "b".equals(user.getBusinessType())) {
						// ADSL和宽带业务，释放账号
						ResAcc resAcc = daoResAcc.selectByAcc(user.getBusinessKey());
						resAcc.setCustomerName("");
						resAcc.setStatus(2);
						resAcc.setUnlockTime(DateUtil.addMonth(now, 3));
						daoResAcc.updateByPrimaryKey(resAcc);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

}
