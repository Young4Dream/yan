/**
 * 
 */
package com.tstar.billing.business;

import org.apache.ibatis.session.SqlSession;

import com.tstar.portal.dao.SysWarnLogMapper;
import com.tstar.portal.model.SysWarnLog;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
public class SysWarnLogBus {

	public static void save(SysWarnLog log) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			SysWarnLogMapper dao = session.getMapper(SysWarnLogMapper.class);
			if (log.getId() == null) {
				log.setId(UUID.get());
				dao.insert(log);
			} else {
				dao.updateByPrimaryKey(log);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	
}
