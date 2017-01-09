package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.SystemConfService;

@Service
public class SystemConfServiceImpl implements SystemConfService{

	@Resource
	private AdminConfMapper adminConfMapper;
	
	
	public List<ResultMap> selectSystemConf() {
		
		return adminConfMapper.selectSysConf();
	}

	public String[] updateSystemConf(int saveTime, String systemIp, String gwIp) {
		String[] res = {"",""};
		ResultMap map = new ResultMap();
		map.put("record_save_time", saveTime);
		map.put("system_ip", systemIp);
		map.put("gw_ip", gwIp);
		int result = adminConfMapper.updateSysConf(map);
		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;
	}
	
	
	public List<ResultMap> selectSystemIp() {
		return adminConfMapper.selectSystemIp();
	}

}
