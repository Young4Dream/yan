/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysWarnLogMapper;
import com.tstar.portal.model.SysWarnLog;
import com.tstar.portal.service.SysWarnLogService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysWarnLogServiceImpl implements SysWarnLogService {

	@Resource
	private SysWarnLogMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<SysWarnLog> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	public List<SysWarnLog> findTop10() {
		return dao.selectTop10();
	}

	public String[] update(SysWarnLog obj) {
		if (2 == obj.getStatus()) {
			obj.setHandleTime(new Date());
		}
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

}
