/**
 * 
 */
package com.tstar.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.service.CrmOrderItemService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class CrmOrderItemServiceImpl implements CrmOrderItemService {

	@Resource
	private CrmOrderItemMapper dao;
	
	public String[] insert(CrmOrderItem orderItem) {
		orderItem.setId(UUID.get());
		orderItem.setStatus(1);
		int res = dao.insert(orderItem);
		if (res > 0) {
			return new String[]{"0", "订购单已缓存，将在保存业务变更之后生效"};
		} else {
			return new String[]{"1", "无法保存该次订购信息"};
		}
	}

	public String[] cancel(CrmOrderItem orderItem) {
		CrmOrderItem item = dao.selectByPrimaryKey(orderItem.getId());
		if (item == null) {
			return new String[]{"1", "改订购单已被删除，无法重复撤销"};
		}
		int status = item.getStatus();
		if (status == 90) {
			return new String[]{"2", "该订购单已失效，无法撤销"};
		} else if (status == 1) {
			orderItem.setStatus(21);
			dao.updateByPrimaryKeySelective(orderItem);
		} else {
			dao.deleteByPrimaryKey(orderItem.getId());
		}
		return new String[]{"0", "成功撤销订购单"};
	}

}
