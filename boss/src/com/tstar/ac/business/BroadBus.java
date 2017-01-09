/**
 * 
 */
package com.tstar.ac.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tstar.sms.BroadMapper;
import com.tstar.util.BroadSessionFactory;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class BroadBus {

	public static int getUserCount() {
		SqlSession session = BroadSessionFactory.getSession();
		try {
			BroadMapper dao = session.getMapper(BroadMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			String sql = "insert into t_user(USER_ID,USER_NAME) values('4','4')";
			map.put("sql", sql);
			String prefix = sql.substring(0, 6).toLowerCase();
			if (prefix.equals("select")) {
				return dao.select(map);
			} else {
				try { dao.execute(map); return 1; } catch (Exception e) { return -1; }
			}
		} catch (Exception e) {
			Log.getLogger().info("exception: " + ExceptionUtil.getStackTrace(e));
			return -1;
		} finally {
			session.close();
		}
	}
}
