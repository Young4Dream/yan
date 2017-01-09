/**
 * 
 */
package com.tstar.res.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResDeviceMapper;
import com.tstar.res.dao.ResDevicePortMapper;
import com.tstar.res.dao.ResDeviceTypeMapper;
import com.tstar.res.dao.ResUserPortMapper;
import com.tstar.res.model.ResDevice;
import com.tstar.res.model.ResDevicePort;
import com.tstar.res.model.ResDeviceType;
import com.tstar.res.model.ResUserPort;
import com.tstar.res.service.ResUserPortService;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResUserPortServiceImpl implements ResUserPortService {

	@Resource
	private ResUserPortMapper dao;
	
	@Resource
	private ResDeviceMapper daoDevice;
	
	@Resource
	private ResDevicePortMapper daoDevicePort;
	
	@Resource
	private ResDeviceTypeMapper daoDeviceType;
	
	public List<ResUserPort> selectByUserId(String userId) {
		return dao.selectByUserId(userId);
	}

	public String[] insert(ResUserPort obj) {
		ResDevicePort devicePort = daoDevicePort.selectByCode(obj.getDeviceCode(), obj.getPortCode());
		// 验证端口是否有效
		if (devicePort == null || !"1".equals(devicePort.getStatus())) {
			return new String[]{"1", "端口不存在或端口已损坏或端口被保留！"};
		}
		if (!StringUtil.isEmpty(devicePort.getBearable()) && devicePort.getBearable().indexOf(obj.getBusinessType()) == -1) {
			return new String[]{"1", "端口无法承载该业务！"};
		}
		if (!StringUtil.isEmpty(devicePort.getBearing()) && devicePort.getBearing().indexOf(obj.getBusinessType()) >= 0) {
			return new String[]{"1", "端口已被占用！"};
		}
		// 查找最大PORT_INDEX
		Integer lastIndex = dao.selectMaxPortIndex(obj.getUserId());
		if (lastIndex == null) {
			obj.setPortIndex(10);
		} else {
			obj.setPortIndex(lastIndex + 10);
		}
		
		ResDevice device = daoDevice.selectByCode(obj.getDeviceCode());
		ResDeviceType deviceType = daoDeviceType.selectByPrimaryKey(device.getDeviceTypeId());
		obj.setCtrlSetName(deviceType.getCtrlSetName());
		
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		
		// 更新端口信息
		devicePort.setBearing(obj.getBusinessType() + devicePort.getBearing());
		if (StringUtil.isEmpty(devicePort.getBusinessKey())) {
			devicePort.setBusinessKey(obj.getUserKey());
		} else {
			devicePort.setBusinessKey(obj.getUserKey() + " " + devicePort.getBusinessKey());
		}
		daoDevicePort.updateByPrimaryKey(devicePort);
		
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResUserPort obj) {
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		ResUserPort userPort = dao.selectByPrimaryKey(id);
		if (userPort == null) {
			return  new String[]{"1", "删除失败：用户端口已被移除"};
		}
		ResDevicePort devicePort = daoDevicePort.selectByCode(userPort.getDeviceCode(), userPort.getPortCode());
		if (devicePort == null) {
			return  new String[]{"1", "删除失败：无法找到对应的端口"};
		}
		// 去除端口的承载业务
		devicePort.setBearing(devicePort.getBearing().replace(userPort.getBusinessType(), ""));
		// 去除端口的承载业务显示
		devicePort.setBusinessKey(devicePort.getBusinessKey().replace(userPort.getUserKey(), "").trim());
		daoDevicePort.updateByPrimaryKey(devicePort);
		
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
