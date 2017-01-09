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

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.model.AcAction;
import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserBroadMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Component
public class BroadMoveAcServiceTask implements JavaDelegate {

	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	@Resource
	private CrmUserMapper daoCrmUser;
	@Resource
	private CrmUserAdslMapper daoCrmUserAdsl;
	@Resource
	private CrmUserBroadMapper daoCrmUserBroad;
	@Resource
	private AcActionMapper daoAcAction;
	
	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		String newOuterVlan = (String)execution.getVariable("newOuterVlan");
		String newBusinessKey = (String)execution.getVariable("newBusinessKey");
		String newUserAddress = (String)execution.getVariable("newUserAddress");
		
		try {
			JobOpInstance instance = daoJobOpInstance.selectByPrimaryKey(instanceId);
			if (instance != null) {
				Date now = new Date();
				// 更新用户信息，启动自控
				String userId = instance.getUserId();
				CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
				String parms = "";
				if ("a".equals(user.getBusinessType())) {
					CrmUserAdsl oldAdsl = daoCrmUserAdsl.selectByPrimaryKey(userId);
					CrmUserAdsl adsl = new CrmUserAdsl();
					adsl.setId(userId);
					adsl.setOuterVlan(newOuterVlan);
					if (!StringUtil.isEmpty(newBusinessKey)) {
						adsl.setAcc(newBusinessKey);
						CrmUser newUser = new CrmUser();
						newUser.setId(userId);
						newUser.setBusinessKey(newBusinessKey);
						newUser.setUpdateTime(now);
						daoCrmUser.updateByPrimaryKeySelective(newUser);
					}
					daoCrmUserAdsl.updateByPrimaryKeySelective(adsl);
					parms = "newBusinessKey:" + (StringUtil.isEmpty(newBusinessKey) ? oldAdsl.getAcc() : newBusinessKey) +
								   ",newUserAddress:" + newUserAddress +
								   ",oldBusinessKey:" + oldAdsl.getAcc() +
								   ",vlanFlag:" + (StringUtil.isEmpty(newOuterVlan) ? "000" : "001");
				} else if ("b".equals(user.getBusinessType())) {
					CrmUserBroad oldBroad = daoCrmUserBroad.selectByPrimaryKey(userId);
					CrmUserBroad broad = new CrmUserBroad();
					broad.setId(userId);
					broad.setOuterVlan(newOuterVlan);
					if (!StringUtil.isEmpty(newBusinessKey)) {
						broad.setAcc(newBusinessKey);
						CrmUser newUser = new CrmUser();
						newUser.setId(userId);
						newUser.setBusinessKey(newBusinessKey);
						newUser.setUpdateTime(now);
						daoCrmUser.updateByPrimaryKeySelective(newUser);
					}
					daoCrmUserBroad.updateByPrimaryKeySelective(broad);
					parms = "newBusinessKey:" + (StringUtil.isEmpty(newBusinessKey) ? oldBroad.getAcc() : newBusinessKey) +
					   			   ",newUserAddress:" + newUserAddress +
								   ",oldBusinessKey:" + oldBroad.getAcc() +
								   ",vlanFlag:" + (StringUtil.isEmpty(newOuterVlan) ? "000" : "001");
				}
				AcAction action = new AcAction();
				action.setId(UUID.get());
				action.setUserId(userId);
				action.setBusinessKey(user.getBusinessKey());
				action.setBusinessType(user.getBusinessType());
				action.setJobId(instanceId);
				action.setOssKey("move");
				action.setParms(parms);
				action.setStatus(1);
				action.setRetry(0);
				action.setCreateTime(now);
				daoAcAction.insert(action);
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

}
