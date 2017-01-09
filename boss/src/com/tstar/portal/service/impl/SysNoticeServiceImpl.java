/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysNoticeMapper;
import com.tstar.portal.model.SysNotice;
import com.tstar.portal.service.SysNoticeService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysNoticeServiceImpl implements SysNoticeService {

	@Resource
	private SysNoticeMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<SysNotice> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}
	
	public List<SysNotice> findTop10() {
		return dao.selectTop10();
	}

	public String[] insert(SysNotice obj) {
		obj.setId(UUID.get());
		obj.setStatus(0);
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SysNotice obj) {
		int res = dao.updateByPrimaryKeySelective(obj);
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

}
