/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.service.OcsBillService;

/**
 * @author zhumengfeng
 * 定时累账作业，每日00:10:00启动
 */
@Component
public class BillTaskJob {
	
	@Resource
	private CrmOrderItemMapper daoCrmOrderItem;
	@Resource
	private OcsBillService ocsBillService;
	
	@Scheduled(cron = "0 10 0 * * ?")
	public void billing() {
		Date now = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dt", now);
		System.out.println("Billing task job scheduled...");
		while (true) {
			System.out.println("Try to fetch top 50 user...");
			List<String> lst = daoCrmOrderItem.selectTopBillingItem(map);
			if (lst == null || lst.size() == 0) {
				System.out.println("No any user need to be billed.");
				break;
			}
			System.out.println("Billing " + lst.size() + " users...");
			for (String userId : lst) {
				ocsBillService.generateOrderBill(userId);
			}
		}
	}
	
}
