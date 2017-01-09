/**
 * 
 */
package com.tstar.billing.business;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.tstar.crm.dao.CrmAccountMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.OcsBillItemMapper;
import com.tstar.crm.dao.OcsBillMapper;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.portal.dao.SysAccountItemMapper;
import com.tstar.portal.model.SysAccountItem;
import com.tstar.util.DateUtil;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
public class OcsBillBus {

	/**
	 * 查找代缴链的根
	 * @param customerId
	 * @return
	 * 	[0] 当前账户ID
	 *  [1] 根账户ID
	 */
	private static String[] findRootCreditor(SqlSession session, String customerId) {
		String[] res = new String[2];
		CrmAccountMapper daoCrmAccount = session.getMapper(CrmAccountMapper.class);
		CrmAccount account = daoCrmAccount.selectByCustomerId(customerId);
		res[0] = account.getId();
		while (!StringUtil.isEmpty(account.getCreditor())) {
			String parentCustomerId = account.getCreditor();
			account = daoCrmAccount.selectByCustomerId(parentCustomerId);
		}
		res[1] = account.getId();
		return res;
	}
	
	/**
	 * 根据用户ID和日期获取账单
	 * @param userId
	 * @param dt
	 * @return
	 */
	public static OcsBill findBill(String userId, Date dt) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			OcsBillMapper dao = session.getMapper(OcsBillMapper.class);
			OcsBill bill = dao.selectByUserIdAndDate(userId, dt);
			if (bill == null) {
				// 账单不存在，新建账单
				CrmUserMapper daoCrmUser = session.getMapper(CrmUserMapper.class);
				CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
				String[] as = findRootCreditor(session, user.getCustomerId());
				
				bill = new OcsBill();
				bill.setId(UUID.get());
				bill.setUserId(userId);
				bill.setCustomerId(user.getCustomerId());
				bill.setAccountId(as[0]);
				bill.setCreditorId(as[1]);
				Date[] ds = DateUtil.getBillingTerm(dt, user.getBillingDay());
				bill.setStartDate(ds[0]);
				bill.setEndDate(ds[1]);
				bill.setBillNo(SysSequenceBus.currVal(session, "BILL_NO", ds[0]));
				bill.setAmountDue(new BigDecimal("0"));
				bill.setAmountProceed(new BigDecimal("0"));
				bill.setPayPolicy(user.getPayPolicy());
				bill.setStatus(0);
				bill.setCreateTime(new Date());
				dao.insert(bill);
				session.commit();
			}
			return bill;
		} finally {
			session.close();
		}
	}

	public static OcsBillItem findBillItem(String billId, String accountItemId) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			OcsBillItemMapper dao = session.getMapper(OcsBillItemMapper.class);
			OcsBillItem billItem = dao.selectByBillIdAndAccountItemId(billId, accountItemId);
			if (billItem == null) {
				SysAccountItemMapper daoSysAccountItem = session.getMapper(SysAccountItemMapper.class);
				SysAccountItem sysAccountItem = daoSysAccountItem.selectByPrimaryKey(accountItemId);
				billItem = new OcsBillItem();
				billItem.setId(UUID.get());
				billItem.setBillId(billId);
				billItem.setAccountItemId(sysAccountItem.getId());
				billItem.setAccountItemCode(sysAccountItem.getItemCode());
				billItem.setAccountItemName(sysAccountItem.getItemName());
				billItem.setAccountItemDesc("");
				billItem.setAmount(new BigDecimal(0));
				billItem.setCreateTime(new Date());
				dao.insert(billItem);
				session.commit();
			}
			return billItem;
		} finally {
			session.close();
		}
	}
	
	public static void addAmount(String billId, String itemId, BigDecimal amount) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			OcsBillItemMapper dao = session.getMapper(OcsBillItemMapper.class);
			dao.addAmount(itemId, amount);
			OcsBillMapper daoOcsBill = session.getMapper(OcsBillMapper.class);
			daoOcsBill.addAmount(billId, amount);
			session.commit();
		} finally {
			session.close();
		}
	}
}
