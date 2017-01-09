/**
 * 
 */
package com.tstar.portal.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysSmsOutboxMapper;
import com.tstar.portal.model.SysSmsOutbox;
import com.tstar.portal.service.SysSmsOutboxService;
import com.tstar.sms.SmsMapper;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysSmsOutboxServiceImpl implements SysSmsOutboxService {

	@Resource
	private SysSmsOutboxMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<SysSmsOutbox> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	public String[] insert(SysSmsOutbox obj) {
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

	public String[] update(SysSmsOutbox obj) {
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

	public String[] send(String id) {
		SysSmsOutbox obj = dao.selectByPrimaryKey(id);
		if (obj == null) {
			return new String[]{"1", "短信已不存在"};
		}
		int res = sendit(obj);
		if (res > 0) {
			obj.setSendTime(new Date());
			obj.setStatus(9);
			dao.updateByPrimaryKeySelective(obj);
			return new String[]{"0", "发送成功"};
		} else {
			obj.setStatus(99);
			dao.updateByPrimaryKeySelective(obj);
			return new String[]{"1", "发送失败"};
		}
	}

	public String[] send(SysSmsOutbox obj) {
		if (StringUtil.isEmpty(obj.getId())) {
			obj.setId(UUID.get());
			obj.setStatus(0);
			obj.setCreateTime(new Date());
			dao.insert(obj);
		} else {
			dao.updateByPrimaryKeySelective(obj);
		}
		int res = sendit(obj);
		if (res > 0) {
			obj.setSendTime(new Date());
			obj.setStatus(9);
			dao.updateByPrimaryKeySelective(obj);
			return new String[]{"0", "发送成功"};
		} else {
			obj.setStatus(99);
			dao.updateByPrimaryKeySelective(obj);
			return new String[]{"1", "发送失败"};
		}
	}
	
	private int sendit(SysSmsOutbox obj) {
		String sendTime = DateUtil.format(new Date());
		String[] mobiles = obj.getRecipient().split(";");
		int count = 0;
		for (int i = 0; i < mobiles.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("departmentName", obj.getDepartmentName());
			map.put("recipient", mobiles[i]);
			map.put("content", obj.getContent());
			map.put("sendTime", sendTime);
			map.put("title", obj.getTitle());
			// 调用接口发送短信
			try {
				SqlSession session = getSmsSession();
				SmsMapper daoSms = session.getMapper(SmsMapper.class);
				daoSms.send(map);
				session.commit();
				session.close();
				count++;
			} catch (Exception e) {
				System.out.println(ExceptionUtil.getStackTrace(e));
			}
		}
		return count;
	}
	
	private static SqlSessionFactory sessionFactory = null;
	private static SqlSession getSmsSession() {
		String resource = "sqlmap/smsMapConfig.xml";
		if (sessionFactory == null) {
			synchronized (SysSmsOutboxServiceImpl.class) {
				InputStream is = SysSmsOutboxServiceImpl.class.getClassLoader().getResourceAsStream(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
		}
		return sessionFactory.openSession();
	}

}
