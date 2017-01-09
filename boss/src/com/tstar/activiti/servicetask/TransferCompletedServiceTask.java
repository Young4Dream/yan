/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.Date;
import java.util.List;

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
import com.tstar.crm.model.CrmOrder;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.crm.model.CrmUserPl;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Component
public class TransferCompletedServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	@Resource
	private CrmUserMapper daoCrmUser;
	@Resource
	private CrmUserPhoneMapper daoCrmUserPhone;
	@Resource
	private CrmUserAdslMapper daoCrmUserAdsl;
	@Resource
	private CrmUserBroadMapper daoCrmUserBroad;
	@Resource
	private CrmUserPlMapper daoCrmUserPl;
	@Resource
	private CrmOrderMapper daoCrmOrder;
	@Resource
	private CrmOrderItemMapper daoCrmOrderItem;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		String newCustomerId = (String)execution.getVariable("newCustomerId");
		String newUserName = (String)execution.getVariable("newUserName");
		String newLinkPhone = (String)execution.getVariable("newLinkPhone");
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				Date now = new Date();
				String userId = instance.getUserId();
				if (!StringUtil.isEmpty(userId)) {
					CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
					// 原用户设置到期日
					user.setExpiryTime(now);
					user.setUpdateTime(now);
					user.setStatus(91);
					daoCrmUser.updateByPrimaryKey(user);
					// 复制用户信息
					user.setId(UUID.get());
					user.setCustomerId(newCustomerId);
					user.setName(newUserName);
					user.setLinkPhone(newLinkPhone);
					user.setCreator(instance.getOriginator());
					user.setCreateTime(now);
					user.setEffectiveTime(now);
					daoCrmUser.insert(user);
					String relTable = user.getRelTable();
					if ("crm_user_phone".equals(relTable)) {
						CrmUserPhone userPhone = daoCrmUserPhone.selectByPrimaryKey(userId);
						userPhone.setId(user.getId());
						daoCrmUserPhone.insert(userPhone);
					} else if ("crm_user_adsl".equals(relTable)) {
						CrmUserAdsl userAdsl = daoCrmUserAdsl.selectByPrimaryKey(userId);
						userAdsl.setId(user.getId());
						daoCrmUserAdsl.insert(userAdsl);
					} else if ("crm_user_broad".equals(relTable)) {
						CrmUserBroad userBroad = daoCrmUserBroad.selectByPrimaryKey(userId);
						userBroad.setId(user.getId());
						daoCrmUserBroad.insert(userBroad);
					} else if ("crm_user_pl".equals(relTable)) {
						CrmUserPl userPl = daoCrmUserPl.selectByPrimaryKey(userId);
						userPl.setId(user.getId());
						daoCrmUserPl.insert(userPl);
					}
					// 复制订单信息
					CrmOrder order = daoCrmOrder.selectByPrimaryKey(userId);
					order.setId(user.getId());
					order.setCustomerId(user.getCustomerId());
					order.setCreator(user.getCreator());
					order.setCreateTime(now);
					daoCrmOrder.insert(order);
					List<CrmOrderItem> items = daoCrmOrderItem.selectByOrderId(userId);
					for (CrmOrderItem item : items) {
						if (item.getItemType() == 3) {
							continue;
						}
						if (item.getStatus() >= 9) {
							continue;
						}
						// 到期原订单
						item.setExpiryTime(now);
						daoCrmOrderItem.updateByPrimaryKey(item);
						// 转移订单
						item.setId(UUID.get());
						item.setOrderId(order.getId());
						if (item.getEffectiveTime() != null) {
							item.setEffectiveTime(now);
						}
						daoCrmOrderItem.insert(item);
					}
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
