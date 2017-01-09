/**
 * 
 */
package com.tstar.billing.business;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.model.CrmUser;
import com.tstar.util.MyBatisSessionFactory;

/**
 * @author zhumengfeng
 *
 */
public class CrmUserService {

	public static CrmUser findUserByTime(String businessType, String businessKey, Date dt) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CrmUserMapper dao = session.getMapper(CrmUserMapper.class);
			return dao.selectByTime(businessType, businessKey, dt);
		} finally {
			session.close();
		}
	}
}
