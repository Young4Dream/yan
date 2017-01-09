/**
 * 
 */
package com.tstar.ac.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.dao.AcCommandMapper;
import com.tstar.ac.model.AcAction;
import com.tstar.ac.model.AcCommand;
import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserBroadMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CrmUserPhoneMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.portal.dao.SysWarnLogMapper;
import com.tstar.portal.model.SysWarnLog;
import com.tstar.res.dao.ResDeviceMapper;
import com.tstar.res.dao.ResUserPortMapper;
import com.tstar.res.model.ResDevice;
import com.tstar.res.model.ResUserPort;
import com.tstar.util.BeanHelper;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
public class AcBus {

	public AcAction getTopAction(int status) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcActionMapper dao = session.getMapper(AcActionMapper.class);
			return dao.selectTopByStatus(status);
		} finally {
			session.close();
		}
	}
	
	public AcAction getTopRunnableAction() {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcActionMapper dao = session.getMapper(AcActionMapper.class);
			return dao.selectTopRunnable();
		} finally {
			session.close();
		}
	}
	
	public void exeAction(AcAction action) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcActionMapper dao = session.getMapper(AcActionMapper.class);
			AcCommandMapper daoAcCommand = session.getMapper(AcCommandMapper.class);
			ResUserPortMapper daoResUserPort = session.getMapper(ResUserPortMapper.class);
			ResDeviceMapper daoResDevice = session.getMapper(ResDeviceMapper.class);
			CrmUserMapper daoCrmUser = session.getMapper(CrmUserMapper.class);
			CrmUserAdslMapper daoAdsl = session.getMapper(CrmUserAdslMapper.class);
			CrmUserBroadMapper daoBroad = session.getMapper(CrmUserBroadMapper.class);
			CrmUserPhoneMapper daoPhone = session.getMapper(CrmUserPhoneMapper.class);
			String userId = action.getUserId();
			CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
			CrmUserAdsl adsl = null;
			CrmUserBroad broad = null;
			CrmUserPhone phone = null;
			if ("a".equals(user.getBusinessType())) {
				adsl = daoAdsl.selectByPrimaryKey(userId);
			} else if ("b".equals(user.getBusinessType())) {
				broad = daoBroad.selectByPrimaryKey(userId);
			} else if ("p".equals(user.getBusinessType())) {
				phone = daoPhone.selectByPrimaryKey(userId);
			}
			// 清除原命令
			daoAcCommand.deleteByActionId(action.getId());
			int cmdCount = 0;
			// 查找端口路由
			List<ResUserPort> ports = daoResUserPort.selectByUserId(userId);
			for (ResUserPort port : ports) {
				if (StringUtil.isEmpty(port.getCtrlSetName())) {
					continue;
				}
				ResDevice device = daoResDevice.selectByCode(port.getDeviceCode());
				Map<String, Object> variables = new HashMap<String, Object>();
				variables.put("businessKey", action.getBusinessKey());
				variables.put("name", user.getName());
				variables.put("user", device.getCtrlUserName());
				variables.put("password", device.getCtrlPwd());
				String parms = action.getParms();
				if (!StringUtil.isEmpty(parms)) {
					String[] ps = parms.split(",");
					for (String p : ps) {
						//String[] vs = p.split(":");
						int pos = p.indexOf(":");
						variables.put(p.substring(0, pos), p.substring(pos + 1));
					}
				}
				if (adsl != null) {
					try { BeanHelper.bean2map(adsl, variables); } catch (Exception e) {}
				}
				if (broad != null) {
					try { BeanHelper.bean2map(broad, variables); } catch (Exception e) {}
				}
				if (phone != null) {
					try { BeanHelper.bean2map(phone, variables); } catch (Exception e) {}
					//Log.getLogger().info("ch_pwd.phoneNo=" + phone.getPhoneNo() + ", ch")
				}
				if (user != null) {
					try { BeanHelper.bean2map(user, variables); } catch (Exception e) {}
				}
				List<AcCommand> cmds = CmdProfile.getCmds(port.getCtrlSetName(), action.getOssKey(), variables);
				if (cmds != null && cmds.size() > 0) {
					cmdCount += cmds.size();
					for (AcCommand cmd : cmds) {
						cmd.setId(UUID.get());
						cmd.setActionId(action.getId());
						cmd.setDeviceCode(port.getDeviceCode());
						cmd.setCtrlSetName(port.getCtrlSetName());
						daoAcCommand.insert(cmd);
					}
				}
			}
			if (cmdCount > 0) {
				action.setStatus(AcAction.STATUS_EXE);
			} else {
				action.setStatus(AcAction.STATUS_NO_COMMANDS);
			}
			action.setUpdateTime(new Date());
			dao.updateByPrimaryKey(action);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void updateAction(AcAction action) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcActionMapper dao = session.getMapper(AcActionMapper.class);
			dao.updateByPrimaryKey(action);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public List<AcCommand> getCmdsByAct(String actionId) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcCommandMapper dao = session.getMapper(AcCommandMapper.class);
			return dao.selectByActionId(actionId);
		} finally {
			session.close();
		}
	}
	
	public void saveCmds(AcAction action, List<AcCommand> cmds) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			AcActionMapper daoAcAction = session.getMapper(AcActionMapper.class);
			action.setUpdateTime(new Date());
			daoAcAction.updateByPrimaryKey(action);
			if (cmds != null && cmds.size() > 0) {
				AcCommandMapper dao = session.getMapper(AcCommandMapper.class);
				for (AcCommand cmd : cmds) {
					if (cmd.getRetCode() != null) {
						dao.updateByPrimaryKey(cmd);
					}
				}
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void saveWarnLog(SysWarnLog log) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			SysWarnLogMapper dao = session.getMapper(SysWarnLogMapper.class);
			dao.insert(log);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	// 设备缓存
	private static Map<String, ResDevice> devices = new HashMap<String, ResDevice>();
	
	public ResDevice getDeviceByCode(String deviceCode) {
		ResDevice device = devices.get(deviceCode);
		if (device == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				ResDeviceMapper dao = session.getMapper(ResDeviceMapper.class);
				device = dao.selectByCode(deviceCode);
				devices.put(deviceCode, device);
			} finally {
				session.close();
			}
		}
		return device;
	}
	
}
