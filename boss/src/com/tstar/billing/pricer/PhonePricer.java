package com.tstar.billing.pricer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.tstar.billing.business.CrmUserService;
import com.tstar.billing.business.ProfileBus;
import com.tstar.billing.business.SidDiscountBus;
import com.tstar.billing.business.SidRateBus;
import com.tstar.billing.business.SidServiceBus;
import com.tstar.billing.business.SysWarnLogBus;
import com.tstar.crm.model.CrmUser;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.model.SidDiscount;
import com.tstar.ocs.model.SidOperatorTrunk;
import com.tstar.ocs.model.SidRate;
import com.tstar.ocs.model.SidService;
import com.tstar.ocs.model.SidServiceCategory;
import com.tstar.ocs.model.SidVoiceConfigItem;
import com.tstar.portal.model.SysWarnLog;
import com.tstar.util.DateUtil;

public class PhonePricer implements IPricer {

	public static final int ABNORMAL_CODE_CALLER_MISSED = 1001;
	public static final String ABNORMAL_DESC_CALLER_MISSED = "缺少主叫号码";
	public static final int ABNORMAL_CODE_CALLEE_MISSED = 1002;
	public static final String ABNORMAL_DESC_CALLEE_MISSED = "缺少被叫号码";
	public static final int ABNORMAL_CODE_START_TIME_MISSED = 1003;
	public static final String ABNORMAL_DESC_START_TIME_MISSED = "缺少呼始时间";
	public static final int ABNORMAL_CODE_END_TIME_MISSED = 1004;
	public static final String ABNORMAL_DESC_END_TIME_MISSED = "缺少呼止时间";
	public static final int ABNORMAL_CODE_DURATION_MISSED = 1005;
	public static final String ABNORMAL_DESC_DURATION_MISSED = "缺少通话时长";
	public static final int ABNORMAL_CODE_SERVICE_ABBR_MISSED = 1010;
	public static final String ABNORMAL_DESC_SERVICE_ABBR_MISSED = "缺少业务类别";
	public static final int ABNORMAL_CODE_CATEGORY_MISSED = 1011;
	public static final String ABNORMAL_DESC_CATEGORY_MISSED = "无法匹配业务类别";
	public static final int ABNORMAL_CODE_CALL_TYPE_MISSED = 1012;
	public static final String ABNORMAL_DESC_CALL_TYPE_MISSED = "无法匹配呼叫类型";
	public static final int ABNORMAL_CODE_SERVICE_MISSED = 1013;
	public static final String ABNORMAL_DESC_SERVICE_MISSED = "无法匹配业务";
	public static final int ABNORMAL_CODE_USER_MISSED = -1;
	public static final String ABNORMAL_DESC_USER_MISSED = "无主话单";
	
	public static final int ABNORMAL_CODE_RATE_MISSED = 2001;
	public static final String ABNORMAL_DESC_RATE_MISSED = "未配置费率";
	
	public static final int ABNORMAL_CODE_TOO_LONG = 3001;
	public static final String ABNORMAL_DESC_TOO_LONG = "超长话单";
	
	public static final int warnDuration = ProfileBus.getWarnDuration();
	
	public void format(CdrLog log, List<Cdr> cdrs) {
		int abnormal = (log.getAbnormalCount() == null ? 0 : log.getAbnormalCount());
		for (Cdr cdr : cdrs) {
			cdr.setLogId(log.getId());
			cdr.setSourceName(log.getSourceName());
			cdr.setStatus(Cdr.STATUS_PRICING);
			cdr.setAbnormalCode(0);

			if (cdr.getCaller() == null || "".equals(cdr.getCaller()) || "unknown".equals(cdr.getCaller().toLowerCase())) {
				cdr.setAbnormalCode(ABNORMAL_CODE_CALLER_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_CALLER_MISSED);
				abnormal++;
				continue;
			}
			
			if (cdr.getCallee() == null || "".equals(cdr.getCallee()) || "unknown".equals(cdr.getCallee().toLowerCase())) {
				cdr.setAbnormalCode(ABNORMAL_CODE_CALLEE_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_CALLEE_MISSED);
				abnormal++;
				continue;
			}
			
			if (cdr.getStartTime() == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_START_TIME_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_START_TIME_MISSED);
				abnormal++;
				continue;
			}
			if (cdr.getEndTime() == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_END_TIME_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_END_TIME_MISSED);
				abnormal++;
				continue;
			}
			
			if (cdr.getDuration() == null || cdr.getDuration() == 0) {
				cdr.setAbnormalCode(ABNORMAL_CODE_DURATION_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_DURATION_MISSED);
				abnormal++;
				continue;
			}
			
			if (cdr.getServiceAbbr() == null || "".equals(cdr.getServiceAbbr())) {
				cdr.setAbnormalCode(ABNORMAL_CODE_SERVICE_ABBR_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_SERVICE_ABBR_MISSED);
				abnormal++;
				continue;
			}
			
			// 根据业务类别别名查找业务类别
			SidServiceCategory category = SidServiceBus.findCategory(cdr.getServiceAbbr());
			if (category == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_CATEGORY_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_CATEGORY_MISSED);
				abnormal++;
				continue;
			}
			
			// 根据主被叫号码查找呼叫类型
			SidVoiceConfigItem item = SidServiceBus.findCallTypeItem(cdr.getCallee());
			if (item == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_CALL_TYPE_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_CALL_TYPE_MISSED);
				abnormal++;
				continue;
			} 
			cdr.setCalleeLocation(item.getCalleeLocation());
			cdr.setCallType(SidServiceBus.findCallTypeName(item.getConfigId()));
			
			// 根据业务类别和呼叫类型查找业务
			SidService service = SidServiceBus.findService(category.getId(), item.getConfigId(), null);
			if (service == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_SERVICE_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_SERVICE_MISSED);
				abnormal++;
				continue;
			}
			
			// 根据号码和呼叫起始时间查找用户
			CrmUser user = CrmUserService.findUserByTime("p", cdr.getCaller(), cdr.getStartTime());
			if (user == null) {
				// 无主话单将按照兜底费率批价
				cdr.setAbnormalCode(ABNORMAL_CODE_USER_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_USER_MISSED);
				abnormal++;
			} else {
				cdr.setUserId(user.getId());
				cdr.setUserName(user.getName());
				cdr.setCustomerId(user.getCustomerId());
			}
			
			// 判断是否超长话单
			if (warnDuration < cdr.getDuration()) {
				cdr.setAbnormalCode(ABNORMAL_CODE_TOO_LONG);
				cdr.setAbnormalDesc(ABNORMAL_DESC_TOO_LONG);
				SysWarnLog warn = new SysWarnLog();
				warn.setWarnLevel("WARN");
				warn.setWarnModule("话单分拣");
				warn.setWarnTime(new Date());
				warn.setWarnMsg("超长话单，主叫：" + cdr.getCaller() + 
						"，被叫：" + cdr.getCallee() + 
						"，话始时间：" + DateUtil.formatTime(cdr.getStartTime()) + 
						"，通话时长：" + cdr.getDuration());
				warn.setStatus(0);
				SysWarnLogBus.save(warn);
				abnormal++;
				continue;
			}
			
			cdr.setDuration(1 + cdr.getDuration());
			int usageCount = (int)Math.ceil((double)cdr.getDuration() / service.getMeterCount());
			cdr.setUsageCount(usageCount);
			cdr.setServiceId(service.getId());
			
			cdr.setHashCode(cdr.hashCode());
		}
		log.setAbnormalCount(abnormal);
	}

	public void pricing(CdrLog log, List<Cdr> cdrs) {
		int abnormal = log.getAbnormalCount();
		for (Cdr cdr : cdrs) {
			if (cdr.getAbnormalCode() > 0) continue;
			SidRate rate = SidRateBus.findDefaultRate(cdr.getServiceId());
			if (rate == null) {
				cdr.setAbnormalCode(ABNORMAL_CODE_RATE_MISSED);
				cdr.setAbnormalDesc(ABNORMAL_DESC_RATE_MISSED);
				abnormal++;
				continue;
			}
			cdr.setPricePlanId(rate.getPlanId());
			cdr.setRateId(rate.getId());
			cdr.setPrice(rate.getPrice());
			cdr.setFreeUsage(0);
			cdr.setChargingUsage(cdr.getUsageCount());
			
			int usage = cdr.getChargingUsage();
			double fee = 0;
			double attachFee = 0;
			double discount = 0;
			double debitFee = 0;
			if (cdr.getDuration() >= rate.getBaseDuration()) {
				// 计算基本费
				if (usage <= rate.getBaseUsage()) {
					fee = rate.getBaseFee().doubleValue();
				} else {
					fee = rate.getBaseFee().doubleValue() + rate.getPrice().doubleValue() * (usage - rate.getBaseUsage());
				}
				
				// 计算附加费
				int attachUsage = (int)Math.ceil((double)cdr.getDuration() / rate.getAttachUnitCount());
				//System.out.println("============attachPrice=" + rate.getAttachPrice().doubleValue());
				//System.out.println("attachUsage=" + attachUsage);
				attachFee = rate.getAttachPrice().doubleValue() * attachUsage;
				
				// TODO: 计算折扣
				SidDiscount dis = SidDiscountBus.getDiscount(rate.getId(), cdr.getStartTime());
				if (dis != null) {
					discount = dis.getUnitValue().doubleValue() * usage;
				}
				
				// 计算网间结算费用
				if (cdr.getTrunkGroupOut() != null && !"".equals(cdr.getTrunkGroupOut())) {
					SidOperatorTrunk trunk = SidServiceBus.findOp(cdr.getSourceName(), cdr.getTrunkGroupOut());
					if (trunk != null) {
						cdr.setDebitor(trunk.getOpName());
						//System.out.println("cdr.trunkGroupOut=" + cdr.getTrunkGroupOut());
						//System.out.println("trunk.opId=" + trunk.getOpId());
						//System.out.println("serviceId=" + cdr.getServiceId());
						SidRate opRate = SidRateBus.findOpRate(trunk.getOpId(), cdr.getServiceId());
						if (opRate != null) {
							// 计算基本费
							attachUsage = (int)Math.ceil((double)cdr.getDuration() / opRate.getAttachUnitCount());
							double attachBaseFee = 0;
							if (usage < opRate.getBaseUsage()) {
								attachBaseFee = opRate.getBaseFee().doubleValue();
							} else {
								attachBaseFee = opRate.getBaseFee().doubleValue() + opRate.getPrice().doubleValue() * (usage - opRate.getBaseUsage());
							}
							// 计算附加费
							attachUsage = (int)Math.ceil((double)cdr.getDuration() / opRate.getAttachUnitCount());
							double debitAttachFee = opRate.getAttachPrice().doubleValue() * attachUsage;
							// 计算折扣
							SidDiscount debitAttachDis = SidDiscountBus.getDiscount(opRate.getId(), cdr.getStartTime());
							double debitAttachDiscount = 0;
							if (debitAttachDis != null) {
								debitAttachDiscount = debitAttachDis.getUnitValue().doubleValue() * attachUsage;
							}
							// 结算费
							debitFee = attachBaseFee + debitAttachFee - debitAttachDiscount;
						}
					}
				}
			}
			cdr.setFee(new BigDecimal(fee));
			cdr.setAttachFee(new BigDecimal(attachFee));
			cdr.setDiscount(new BigDecimal(discount));
			cdr.setTotalFee(new BigDecimal(fee + attachFee - discount));
			cdr.setDebitPrice(new BigDecimal(debitFee));
		}
		log.setAbnormalCount(abnormal);
	}

}
