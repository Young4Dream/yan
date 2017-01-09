/**
 * 
 */
package com.tstar.res.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResDeviceMapper;
import com.tstar.res.dao.ResDevicePortMapper;
import com.tstar.res.dao.ResDeviceTypeMapper;
import com.tstar.res.model.ResDevice;
import com.tstar.res.model.ResDevicePort;
import com.tstar.res.model.ResDeviceType;
import com.tstar.res.service.ResDeviceService;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResDeviceServiceImpl implements ResDeviceService {

	@Resource
	private ResDeviceMapper dao;
	
	@Resource
	private ResDeviceTypeMapper daoDeviceType;
	
	@Resource
	private ResDevicePortMapper daoPort;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public List<ResDevice> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public String[] insert(ResDevice obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResDevice obj) {
		int res = dao.updateByPrimaryKey(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
	public String[] generatePort(String id) {
		System.out.println("begin generating ports...");
		ResDevice device = dao.selectByPrimaryKey(id);
		ResDeviceType deviceType = daoDeviceType.selectByPrimaryKey(device.getDeviceTypeId());
		int portCount = daoPort.countByDevice(device.getDeviceCode());
		if (portCount > 0) {
			return new String[]{"1", "无法生成端口：不能重复生成端口！"};
		}
		
		String startPort = device.getStartPortCode();
		String endPort = device.getEndPortCode();
		if (startPort == null || "".equals(startPort) || endPort == null || "".equals(endPort)) {
			System.out.println("port range: " + startPort + " " + endPort);
			return new String[]{"1", "无法生成端口：起始端口编码和截止端口编码不能为空！"};
		}
		
		String splitter = StringUtil.getSplitter(startPort);
		String[] startPartInfos = startPort.split(splitter);
		String[] endPartInfos = endPort.split(splitter);
		if (startPartInfos.length != startPartInfos.length) {
			return new String[]{"1", "无法生成端口：起始端口编码和截止端口编码格式不一致！"};
		}
		
		int len = startPartInfos.length;
		int[] startParts = new int[len];
		int[] endParts = new int[len];
		DecimalFormat[] dfs = new DecimalFormat[len];
		int[] cs = new int[len];
		int total = 1;
		for (int i = 0; i < len; i++) {
			try {
				startParts[i] = Integer.parseInt(startPartInfos[i]);
				endParts[i] = Integer.parseInt(endPartInfos[i]);
			} catch (NumberFormatException e) {
				return new String[]{"1", "无法生成端口：编码必须为数字！"};
			}
			cs[i] = endParts[i] - startParts[i] + 1;
			total = total * cs[i];
			if (cs[i] <= 0) {
				return new String[]{"1", "无法生成端口：每节的起始端口编码都必须小于截止端口编码！"};
			}
			int bits = (startPartInfos[i].length() > endPartInfos[i].length() 
							? startPartInfos[i].length() 
							: endPartInfos[i].length());
			String pattern = "";
			for (int j = 0; j < bits; j++) {
				pattern += "0";
			}
			dfs[i] = new DecimalFormat(pattern);
		}
		int[] is = new int[len];
		for (int i = 0; i < len; i++) {
			is[i] = 0;
		}
		for (int i = 0; i < total; i++) {
			String pc = "";
			for (int j = 0; j < len; j++) {
				if (j > 0) { pc = pc + splitter; }
				pc = pc + dfs[j].format(startParts[j] + is[j]);
			}
			is[len - 1] += 1;
			for (int j = len - 1; j > 0; j--) {
				if (is[j] == cs[j]) {
					is[j] = 0;
					is[j - 1] += 1;
				}
			}
			// save new port
			ResDevicePort port = new ResDevicePort();
			port.setId(UUID.get());
			port.setDeviceCode(device.getDeviceCode());
			port.setBearable(deviceType.getBearBusiness());
			port.setBearing("");
			port.setPortCode(pc);
			port.setStatus("1");
			daoPort.insert(port);
		}
		
		device.setPortTotal(total);
		dao.updateByPrimaryKey(device);
		
		return new String[]{"0", "成功生成端口！"};
	}

}
