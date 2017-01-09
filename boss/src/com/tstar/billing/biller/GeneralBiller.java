package com.tstar.billing.biller;

import java.math.BigDecimal;
import java.util.List;

import com.tstar.billing.business.CdrBus;
import com.tstar.billing.business.OcsBillBus;
import com.tstar.billing.business.SidRateBus;
import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.SidRate;
import com.tstar.portal.model.SysAccountItem;
import com.tstar.util.Log;
import com.tstar.util.StringUtil;

public class GeneralBiller implements IBiller {

	public void billing(List<Cdr> cdrs) {
		for (Cdr cdr : cdrs) {
			// 获取重复话单
			Cdr obj = CdrBus.getDuplicatedCdr(cdr);
			double lastAmount = 0;	
			double lastAttachAmount = 0;
			if (obj != null) {
				// 获取话单的总金额
				lastAmount = obj.getFee().doubleValue() - obj.getDiscount().doubleValue();//obj.getTotalFee().doubleValue();
				lastAttachAmount = obj.getAttachFee().doubleValue();
				// 删除重复话单
				Log.getLogger().info("Delete duplicated cdr, id=" + obj.getId());
				CdrBus.deleteByPrimaryKey(obj.getId());
			}
			// 跳过异常话单
			if (0 != cdr.getAbnormalCode()) {
				continue;
			}
			// 应累账的金额
			double currAmount = cdr.getFee().doubleValue() - cdr.getDiscount().doubleValue() - lastAmount; //cdr.getTotalFee().doubleValue() - lastAmount;
			double currAttachAmount = cdr.getAttachFee().doubleValue() - lastAttachAmount;
			if (currAmount == 0 && currAttachAmount == 0) {
				// 没有应累金额
				cdr.setBillId(obj.getBillId());
				cdr.setBillAccNo(obj.getBillAccNo());
				cdr.setStatus(Cdr.STATUS_FINISHED);
				continue;
			}
			// 根据费率获取目标账目ID
			if (StringUtil.isEmpty(cdr.getRateId())) { continue; }
			SidRate  sidRate = SidRateBus.findRateById(cdr.getRateId());
			if (sidRate == null) { continue; }
			// 获取账单ID
			OcsBill bill = OcsBillBus.findBill(cdr.getUserId(), cdr.getStartTime());
			// 正常费用累账
			if (currAmount != 0) {
				String accountItemId = sidRate.getAccountItemId();
				if (StringUtil.isEmpty(accountItemId)) { accountItemId = SysAccountItem.DEFAULT_ITEM_ID; }
				// 获取账单项ID
				OcsBillItem billItem = OcsBillBus.findBillItem(bill.getId(), accountItemId);
				// 累账
				OcsBillBus.addAmount(bill.getId(), billItem.getId(), new BigDecimal(currAmount));
				cdr.setBillAccNo(billItem.getAccountItemCode());
			}
			// 附加费用累账
			if (currAttachAmount != 0) {
				String attachItemId = sidRate.getAttachItemId();
				if (StringUtil.isEmpty(attachItemId)) { attachItemId = SysAccountItem.DEFAULT_ITEM_ID; }
				// 获取账单项ID
				OcsBillItem billItem = OcsBillBus.findBillItem(bill.getId(), attachItemId);
				// 累账
				OcsBillBus.addAmount(bill.getId(), billItem.getId(), new BigDecimal(currAttachAmount));
			}
			cdr.setBillId(bill.getId());
			cdr.setStatus(Cdr.STATUS_FINISHED);
		}
		CdrBus.update(cdrs);
	}
	
	public static IBiller biller = new GeneralBiller();
	public static IBiller getDefaultBiller() {
		return biller;
	}

}
