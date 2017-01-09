/**
 * 
 */
package com.tstar.res.service.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.res.model.ResPhoneNumber;
import com.tstar.res.service.ResPhoneNumberService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResPhoneNumberServiceImpl implements ResPhoneNumberService {

	@Resource
	private ResPhoneNumberMapper dao;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public List<ResPhoneNumber> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public String[] insert(ResPhoneNumber obj) {
		String startPhoneNumber = obj.getPhoneNumber();
		String endPhoneNumber = obj.getEndPhoneNumber();
		if (endPhoneNumber == null || "".equals(endPhoneNumber)) { 
			endPhoneNumber = startPhoneNumber; 
		}
		int start;
		int end;
		try {
			start = Integer.parseInt(startPhoneNumber);
			end = Integer.parseInt(endPhoneNumber);
		} catch (Exception e) {
			return new String[]{"1", "添加失败：起始和截止号码必须都是数字"};
		}
		if (start > end) {
			return new String[]{"1", "添加失败：起始号码必须小于截止号码"};
		}
		int size = startPhoneNumber.length() > endPhoneNumber.length() 
			? startPhoneNumber.length()
			: endPhoneNumber.length();
		String pattern = "";
		for (int i = 0; i < size; i++) { pattern += "0"; }
		DecimalFormat df = new DecimalFormat(pattern);
		int count = 0;
		String tip = "";
		for (int i = start; i <= end; i++) {
			obj.setId(UUID.get());
			obj.setPhoneNumber(df.format(i));
			try {
				int res = dao.insert(obj);
				if (res > 0) {
					count++;
				} else {
					tip += obj.getPhoneNumber() + " ";
				}
			} catch (Exception e) {
				tip += obj.getPhoneNumber() + " ";
			}
		}
		if (count < end - start + 1) {
			return new String[]{"0", "成功添加了" + count + "个号码，无法添加以下号码：" + tip};
		} else {
			return new String[]{"0", "成功添加了" + count + "个号码"};
		}
	}

	public String[] update(ResPhoneNumber obj) {
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
	
	public String[] lockPhoneNumber(String phoneNo, Date unlockTime) {
		int res = dao.lockPhoneNumber(phoneNo, unlockTime);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
}
