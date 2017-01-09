/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysAccountItemMapper;
import com.tstar.portal.model.SysAccountItem;
import com.tstar.portal.service.SysAccountItemService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysAccountItemServiceImpl implements SysAccountItemService {

	@Resource
	private SysAccountItemMapper dao;
	
	public List<SysAccountItem> selectAll() {
		return dao.selectAll();
	}

	public String[] insert(SysAccountItem obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SysAccountItem obj) {
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

	public String[] deleteByCode(String code) {
		int res = dao.deleteByCode(code);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
