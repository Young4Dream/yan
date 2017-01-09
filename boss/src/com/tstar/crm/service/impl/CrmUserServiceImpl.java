/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserBroadMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CrmUserPhoneMapper;
import com.tstar.crm.dao.CrmUserPlMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.crm.model.CrmUserPl;
import com.tstar.crm.service.CrmUserService;
import com.tstar.util.BeanHelper;

/**
 * @author zhumengfeng
 *
 */
@Service
public class CrmUserServiceImpl implements CrmUserService {

	@Resource
	private CrmUserMapper dao;
	@Resource
	private CrmUserPhoneMapper daoUserPhone;
	@Resource
	private CrmUserAdslMapper daoUserAdsl;
	@Resource
	private CrmUserBroadMapper daoUserBroad;
	@Resource
	private CrmUserPlMapper daoUserPl;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<CrmUser> selectByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	public CrmUser selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
	
	public Map<String, Object> selectFullInfoById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		CrmUser user = dao.selectByPrimaryKey(id);
		try {
			BeanHelper.bean2map(user, map);
			String tableName = user.getRelTable();
			if ("crm_user_phone".equals(tableName)) {
				CrmUserPhone phone = daoUserPhone.selectByPrimaryKey(id);
				BeanHelper.bean2map(phone, map);
			} else if ("crm_user_adsl".equals(tableName)) {
				CrmUserAdsl adsl = daoUserAdsl.selectByPrimaryKey(id);
				BeanHelper.bean2map(adsl, map);
			} else if ("crm_user_broad".equals(tableName)) {
				CrmUserBroad broad = daoUserBroad.selectByPrimaryKey(id);
				BeanHelper.bean2map(broad, map);
			} else if ("crm_user_pl".equals(tableName)) {
				CrmUserPl pl = daoUserPl.selectByPrimaryKey(id);
				BeanHelper.bean2map(pl, map);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

	public Map<String, Object> selectFullInfoByBusinessKey(String businessKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		//CrmUser user = dao.selectByPrimaryKey(id);
		CrmUser user = dao.selectByBusinessKey(businessKey);
		if (user == null) return null;
		try {
			BeanHelper.bean2map(user, map);
			String tableName = user.getRelTable();
			if ("crm_user_phone".equals(tableName)) {
				CrmUserPhone phone = daoUserPhone.selectByPrimaryKey(user.getId());
				BeanHelper.bean2map(phone, map);
			} else if ("crm_user_adsl".equals(tableName)) {
				CrmUserAdsl adsl = daoUserAdsl.selectByPrimaryKey(user.getId());
				BeanHelper.bean2map(adsl, map);
			} else if ("crm_user_broad".equals(tableName)) {
				CrmUserBroad broad = daoUserBroad.selectByPrimaryKey(user.getId());
				BeanHelper.bean2map(broad, map);
			} else if ("crm_user_pl".equals(tableName)) {
				CrmUserPl pl = daoUserPl.selectByPrimaryKey(user.getId());
				BeanHelper.bean2map(pl, map);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

}
