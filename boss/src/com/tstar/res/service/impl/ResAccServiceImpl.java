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

import com.tstar.res.dao.ResAccMapper;
import com.tstar.res.model.ResAcc;
import com.tstar.res.service.ResAccService;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResAccServiceImpl implements ResAccService {

	@Resource
	private ResAccMapper dao;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public List<ResAcc> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public String[] insert(ResAcc obj) {
		String startAcc = obj.getStartAcc();
		String endAcc = obj.getEndAcc();
		if (StringUtil.isEmpty(obj.getPrefix() + obj.getStartAcc() + obj.getSuffix())) {
			return new String[]{"1", "无效的参数：空账号"};
		}
		if (StringUtil.isEmpty(startAcc)) {
			obj.setId(UUID.get());
			obj.setAcc(obj.getPrefix() + obj.getSuffix());
			int count = dao.insert(obj);
			if (count > 0) {
				return new String[]{"0", "成功添加了一个账号"};
			} else {
				return new String[]{"1", "添加账号失败"};
			}
		}
		
		if (StringUtil.isEmpty(endAcc)) { 
			endAcc = startAcc; 
		}
		int start;
		int end;
		try {
			start = Integer.parseInt(startAcc);
			end = Integer.parseInt(endAcc);
		} catch (Exception e) {
			return new String[]{"1", "添加失败：起始和截止账号必须都是数字"};
		}
		if (start > end) {
			return new String[]{"1", "添加失败：起始账号必须小于截止号码"};
		}
		int size = startAcc.length() > endAcc.length() 
			? startAcc.length()
			: endAcc.length();
		String pattern = "";
		for (int i = 0; i < size; i++) { pattern += "0"; }
		DecimalFormat df = new DecimalFormat(pattern);
		int count = 0;
		String tip = "";
		for (int i = start; i <= end; i++) {
			obj.setId(UUID.get());
			obj.setAcc(obj.getPrefix() + df.format(i) + obj.getSuffix());
			try {
				int res = dao.insert(obj);
				if (res > 0) {
					count++;
				} else {
					tip += obj.getAcc() + " ";
				}
			} catch (Exception e) {
				tip += obj.getAcc() + " ";
			}
		}
		if (count < end - start + 1) {
			return new String[]{"0", "成功添加了" + count + "个账号，无法添加以下账号：" + tip};
		} else {
			return new String[]{"0", "成功添加了" + count + "个账号"};
		}
	}

	public String[] update(ResAcc obj) {
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

	public String[] lockAcc(String acc, Date unlockTime) {
		int res = dao.lockAcc(acc, unlockTime);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
	public String findTopUsable(String patterns, String businessType) {
		if (StringUtil.isEmpty(patterns)) return "";
		String[] ps = patterns.split(",");
		for (String p : ps) {
			String acc = dao.selectTopUsable(p, businessType);
			if (!StringUtil.isEmpty(acc)) {
				return acc;
			}
		}
		return "";
	}

}
