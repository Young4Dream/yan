/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CustomerMapper;
import com.tstar.crm.dao.JobOpFormMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.Customer;
import com.tstar.crm.model.JobOpForm;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.crm.service.JobOpFormService;
import com.tstar.ocs.dao.SidOpMapper;
import com.tstar.ocs.model.SidOp;
import com.tstar.portal.service.SysSequenceService;
import com.tstar.res.dao.ResUserPortMapper;
import com.tstar.res.model.ResUserPort;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class JobOpFormServiceImpl implements JobOpFormService {

	@Resource
	private JobOpFormMapper dao;
	@Resource
	private JobOpInstanceMapper daoInstance;
	@Resource
	private SysSequenceService sysSequence;
	@Resource
	private CrmUserMapper daoCrmUser;
	@Resource
	private CustomerMapper daoCustomer;
	@Resource
	private CrmUserAdslMapper daoCrmUserAdsl;
	@Resource
	private SidOpMapper daoSidOp;
	@Resource
	private ResUserPortMapper daoRoute;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<JobOpForm> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}
	
	public JobOpForm generate(String instanceId) {
		JobOpForm form = dao.selectByInstanceId(instanceId);
		if (form != null) {
			return form;
		}
		JobOpInstance instance = daoInstance.selectByPrimaryKey(instanceId);
		form = new JobOpForm();
		form.setId(UUID.get());
		form.setProcessInstanceId(instance.getId());
		form.setJobNo(sysSequence.currVal("JOB_NO"));
		String[] opInfos = instance.getBusinessOpName().split("_");
		form.setFormType(opInfos[0]);
		form.setUserId(instance.getUserId());
		form.setBusinessKey(instance.getUserKey());
		CrmUser user = daoCrmUser.selectByPrimaryKey(instance.getUserId());
		Customer customer = daoCustomer.selectByPrimaryKey(instance.getCustomerId());
		form.setUserName(user.getName());
		if ("a".equals(opInfos[0].toLowerCase())) {
			CrmUserAdsl adsl = daoCrmUserAdsl.selectByPrimaryKey(instance.getUserId());
			form.setPhoneNo(adsl.getPhoneNo());
		}
		form.setDepartmentName(user.getDepartmentName());
		form.setLinker(customer.getLinker());
		form.setLinkPhone(user.getLinkPhone());
		form.setVip(customer.getVipDesc());
		form.setAddress(user.getAddress());
		SidOp sidOp = daoSidOp.selectByName(instance.getBusinessOpName());
		if (sidOp != null) {
			form.setBusinessOpName(sidOp.getAlias());
		}
		form.setDispatchTime(new Date());
		form.setPrintTime(new Date());
		List<ResUserPort> ports = daoRoute.selectByUserId(instance.getUserId());
		if (ports != null && ports.size() > 0) {
			String routeInfo = "";
			for (ResUserPort port : ports) {
				if (!"".equals(routeInfo)) {
					routeInfo += "<==>";
				}
				routeInfo += port.getDeviceName() + ":" + port.getPortCode();
			}
			form.setRouteInfo(routeInfo);
		}
		form.setStatus("0");
		int r = dao.insert(form);
		if (r > 0) {
			return form;
		} else {
			return null;
		}
	}

	public String[] insert(JobOpForm obj) {
		int r = dao.insert(obj);
		if (r > 0) {
			return new String[]{"0", "保存成功"};
		} else {
			return new String[]{"1", "保存失败"};
		}
	}

	public String[] update(JobOpForm obj) {
		int r = dao.updateByPrimaryKeySelective(obj);
		if (r > 0) {
			return new String[]{"0", "保存成功"};
		} else {
			return new String[]{"1", "保存失败"};
		}
	}

}
