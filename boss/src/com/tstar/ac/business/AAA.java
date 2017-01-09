/**
 * 
 */
package com.tstar.ac.business;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tstar.sms.BroadMapper;
import com.tstar.util.MyBatisSessionFactory;

/**
 * @author zhumengfeng
 *
 */
public class AAA implements INorth {

	private String url = "";
	private static SqlSessionFactory sessionFactory = null;
	
	private SqlSession getSession() {
		if (sessionFactory == null) {
			synchronized (MyBatisSessionFactory.class) {
				InputStream is = MyBatisSessionFactory.class.getClassLoader().getResourceAsStream(url);
				sessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
		}
		return sessionFactory.openSession();
	}
	
	public void open(String url) throws Exception { 
		this.url = url;
	}

	public void close() throws Exception { }

	public boolean connected() { return true; }

	public RetMsg execute(String cmd) throws Exception {
		SqlSession session = getSession();
		try {
			BroadMapper dao = session.getMapper(BroadMapper.class);
			String prefix = cmd.substring(0, 6).toLowerCase();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sql", cmd);
			if ("select".equals(prefix)) {
				dao.select(map);
			} else {
				dao.execute(map);
			}
			return new RetMsg("0", "执行成功");
		} catch (Exception e) {
			return new RetMsg("1", e.getMessage().length() >= 500 ? e.getMessage().substring(0, 499) : e.getMessage());
		} finally {
			session.close();
		}
	}

	public RetMsg execute(String cmd, String prompt) throws Exception {
		return execute(cmd);
	}

}
