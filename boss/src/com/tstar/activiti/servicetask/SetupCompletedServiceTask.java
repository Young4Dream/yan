/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.Date;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.portal.dao.ProfileMapper;
import com.tstar.portal.model.Profile;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class SetupCompletedServiceTask implements JavaDelegate {
	
	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserMapper daoCrmUser;
	
	@Resource
	private CrmOrderItemMapper daoOrderItem;
	
	@Resource
	private ProfileMapper daoProfile;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				Date now = new Date();
				// 更新用户状态、生效时间、账期日
				String userId = instance.getUserId();
				if (!StringUtil.isEmpty(userId)) {
					CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
					Profile profile = daoProfile.selectByUk("ocs", user.getBusinessType() + "BillingDay");
					int billingDay = Integer.parseInt(profile.getProfileValue());
					user.setStatus(2);
					user.setEffectiveTime(now);
					if (billingDay == 0 || billingDay > 31) {
						// 账期日为生效日
						//user.setBillingDay(DateUtil.getDay(now));
						user.setBillingDay(0);
					} else {
						// 账期日为系统参数值
						user.setBillingDay(billingDay);
					}
					user.setUpdateTime(now);
					daoCrmUser.updateByPrimaryKey(user);
				}
				// 更新订单状态、生效时间
				String orderId = instance.getOrderId();
				if (!StringUtil.isEmpty(orderId)) {
					daoOrderItem.makeEffective(orderId, now);
				}
				// 更新流程信息状态
				instance.setStatus(9);
				daoJobOpInstance.updateByPrimaryKey(instance);
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
		log.info("executing job completed event...");
		log.info("process finished.");
	}

}
