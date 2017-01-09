/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tstar.crm.dao.CrmAccountMapper;
import com.tstar.crm.dao.OcsAccountLogMapper;
import com.tstar.crm.dao.OcsBillItemMapper;
import com.tstar.crm.dao.OcsBillMapper;
import com.tstar.crm.model.OcsAccountLog;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 * 预付费用户扣费作业，每十分钟一次
 *
 */
@Component
public class PrepaidTaskJob {

	@Resource
	private OcsBillMapper daoOcsBill;
	@Resource
	private OcsBillItemMapper daoOcsBillItem;
	@Resource
	private OcsAccountLogMapper daoOcsAccountLog;
	@Resource
	private CrmAccountMapper daoCrmAccount;
	
	@Scheduled(cron = "0 0/10 * * * ?")
	public void prepaid() {
		System.out.println("Starting job for prepaid user...");
		List<Map<String, Object>> lst = daoOcsBillItem.selectPrepaid();
		if (lst == null || lst.size() == 0) return;
		for (int i = 0; i < lst.size(); i++) {
			Map<String, Object> map = lst.get(i);
			double balance = ((BigDecimal)map.get("amount")).doubleValue();
			double amountDue = ((BigDecimal)map.get("amountDue")).doubleValue();
			double amountProceed = ((BigDecimal)map.get("amountProceed")).doubleValue();
			double amount = (amountDue - amountProceed > balance ? balance : amountDue - amountProceed);
			if (amount <= 0) continue;
			daoOcsBillItem.addAmountProceed((String)map.get("billItemId"), new BigDecimal(amount));
			daoOcsBill.addAmountProceed((String)map.get("billId"), new BigDecimal(amount));
			OcsAccountLog log = new OcsAccountLog();
			log.setId(UUID.get());
			log.setCustomerId((String)map.get("customerId"));
			log.setAccountId((String)map.get("accountId"));
			log.setLogNo("1");
			log.setOpType("10");
			log.setAmount(new BigDecimal(amount));
			log.setOper("system");
			log.setOpTime(new Date());
			log.setOpInfo("");
			log.setVoucherNo((String)map.get("billNo"));
			daoOcsAccountLog.insert(log);
			daoCrmAccount.addAmount(log.getAccountId(), new BigDecimal(-amount));
		}
	}
}
