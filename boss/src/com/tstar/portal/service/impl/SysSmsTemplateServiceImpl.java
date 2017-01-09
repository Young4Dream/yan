/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysSmsTemplateMapper;
import com.tstar.portal.model.SysSmsTemplate;
import com.tstar.portal.service.SysSmsTemplateService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysSmsTemplateServiceImpl implements SysSmsTemplateService {

	@Resource
	private SysSmsTemplateMapper dao;
	
	public List<SysSmsTemplate> findByUser(String userName) {
		return dao.selectByUser(userName);
	}
	
	public SysSmsTemplate findById(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public String[] insert(SysSmsTemplate obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SysSmsTemplate obj) {
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


}
