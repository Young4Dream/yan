/**
 * 
 */
package com.tstar.crm.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.crm.dao.CrmAccountMapper;
import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CustomerMapper;
import com.tstar.crm.dao.OcsAccountLogMapper;
import com.tstar.crm.dao.OcsBillItemMapper;
import com.tstar.crm.dao.OcsBillMapper;
import com.tstar.crm.dao.OcsInvoiceItemMapper;
import com.tstar.crm.dao.OcsInvoiceMapper;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.Customer;
import com.tstar.crm.model.OcsAccountLog;
import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.crm.model.OcsInvoice;
import com.tstar.crm.model.OcsInvoiceItem;
import com.tstar.crm.service.OcsBillService;
import com.tstar.ocs.dao.SidFeeMapper;
import com.tstar.ocs.dao.SidPricePlanMapper;
import com.tstar.ocs.dao.SidProductMapper;
import com.tstar.ocs.model.SidFee;
import com.tstar.ocs.model.SidPricePlan;
import com.tstar.ocs.model.SidProduct;
import com.tstar.portal.dao.SysAccountItemMapper;
import com.tstar.portal.model.SysAccountItem;
import com.tstar.portal.service.SysSequenceService;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class OcsBillServiceImpl implements OcsBillService {

	@Resource
	private OcsBillMapper daoOcsBill;
	@Resource
	private OcsBillItemMapper daoOcsBillItem;
	@Resource
	private CrmUserMapper daoCrmUser;
	@Resource
	private CrmAccountMapper daoCrmAccount;
	@Resource
	private CrmOrderItemMapper daoCrmOrderItem;
	@Resource
	private SysSequenceService sysSequence;
	@Resource
	private SidPricePlanMapper daoSidPricePlan;
	@Resource
	private SidProductMapper daoSidProduct;
	@Resource
	private SidFeeMapper daoSidFee;
	@Resource
	private SysAccountItemMapper daoSysAccountItem;
	@Resource
	private CustomerMapper daoCustomer;
	@Resource
	private CrmAccountMapper daoAccount;
	@Resource
	private OcsInvoiceMapper daoInvoice;
	@Resource
	private OcsInvoiceItemMapper daoInvoiceItem;
	@Resource
	private OcsAccountLogMapper daoOcsAccountLog;
	
	public OcsBill selectByPrimaryKey(String id) {
		return daoOcsBill.selectByPrimaryKey(id);
	}
	
	public int countByCriteria(Map<String, Object> map) {
		return daoOcsBill.countByCriteria(map);
	}
	
	public List<Map<String, Object>> selectByPage(Map<String, Object> map) {
		return daoOcsBill.selectByPage(map);
	}
	
	public List<OcsBillItem> selectItemsByBillId(String billId) {
		return daoOcsBillItem.selectByBillId(billId);
	}
	
	public List<Map<String, Object>> findAnotherBills(String customerId, String id) {
		return daoOcsBill.selectAnother(customerId, id);
	}
	
	public OcsBill findCustomerTopBill(String customerId) {
		return daoOcsBill.selectCustomerTopBill(customerId);
	}
	
	public List<Map<String, Object>> findItemsByCustomer(Map<String, String> map) {
		return daoOcsBill.selectItemsByCustomer(map);
	}
	
	/**
	 * 查找代缴链的根
	 * @param customerId
	 * @return
	 * 	[0] 当前账户ID
	 *  [1] 根账户ID
	 */
	public String[] findRootCreditor(String customerId) {
		String[] res = new String[2];
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
	 * 查找账目
	 * @param itemId
	 * @param itemType
	 * @return
	 */
	public SysAccountItem findAccountItem(String itemId, int itemType) {
		String accountItemId = "10";
		if (itemType == 1) {
			SidPricePlan pricePlan = daoSidPricePlan.selectByPrimaryKey(itemId);
			accountItemId = pricePlan.getAccountItemId();
		} else if (itemType == 2) {
			SidProduct product = daoSidProduct.selectByPrimaryKey(itemId);
			accountItemId = product.getAccountItemId();
		} else {
			SidFee opFee = daoSidFee.selectByPrimaryKey(itemId);
			accountItemId = opFee.getAccountItemId();
		}
		if (StringUtil.isEmpty(accountItemId)) {
			accountItemId = "10";
		}
		return daoSysAccountItem.selectByPrimaryKey(accountItemId);
	}
	
	/**
	 * 立即对用户订单进行累账并更新订单项状态（账务到期日）
	 */
	public String[] generateOrderBill(String userId) {
		Date now = new Date();
		CrmUser user = daoCrmUser.selectByPrimaryKey(userId);
		if (user == null) {
			return new String[] {"1", "用户不存在"};
		}
		
		// 查找当前有效账单
		String[] as = findRootCreditor(user.getCustomerId());
		OcsBill bill = daoOcsBill.selectByUserIdAndDate(userId, now);
		if (bill == null) {
			// 账单不存在，新建账单
			bill = new OcsBill();
			bill.setId(UUID.get());
			bill.setUserId(userId);
			bill.setCustomerId(user.getCustomerId());
			bill.setAccountId(as[0]);
			bill.setCreditorId(as[1]);
			Date[] ds = DateUtil.getBillingTerm(now, user.getBillingDay());
			bill.setStartDate(ds[0]);
			bill.setEndDate(ds[1]);
			bill.setBillNo(sysSequence.currVal("BILL_NO", ds[0]));
			bill.setAmountDue(new BigDecimal("0"));
			bill.setAmountProceed(new BigDecimal("0"));
			bill.setPayPolicy(user.getPayPolicy());
			bill.setStatus(0);
			bill.setCreateTime(now);
			daoOcsBill.insert(bill);
		}
		
		List<CrmOrderItem> orderItems = daoCrmOrderItem.selectByOrderId(userId);
		Map<String, OcsBillItem> billItems = new HashMap<String, OcsBillItem>();
		double total = 0.0;
		for (CrmOrderItem item : orderItems) {
			if (item.getStatus() != 2 && 
					(item.getDueTime() != null && item.getDueTime().getTime() > now.getTime())) {
				// 忽略不是执行状态或者已经账务到期日大于当前日期的订单项
				continue;
			}
			// 保存新账单项目
			SysAccountItem sysAccountItem = findAccountItem(item.getItemId(), item.getItemType());
			String itemKey = bill.getId() + sysAccountItem.getId();
			// 查找缓存
			OcsBillItem billItem = billItems.get(itemKey);
			if (billItem == null) {
				billItem = daoOcsBillItem.selectByBillIdAndAccountItemId(bill.getId(), sysAccountItem.getId());
			}
			// 周期性费用，固定账期日，订购数为零且为第一个账期，按天收取费用
			double amount = 0;
			Date dueTime = null;
			if (item.getSaleType() == 1) {
				// 非周期性业务
				amount = item.getItemPrice().doubleValue() * item.getItemCount();
				dueTime = DateUtil.endOfWorld();
			} else {
				// 周期性费用
				if (0 == user.getBillingDay()) {
					// 非固定账期，按订购数计算金额和到期日，如果订购数为零，则按一个周期计算
					int itemCount = (item.getItemCount() == null || 0 == item.getItemCount() ? 1 : item.getItemCount());
					amount = item.getItemPrice().doubleValue() * itemCount;
					//System.out.println("effectiveTime=" + item.getEffectiveTime());
					//System.out.println("term=" + item.getTerm());
					//System.out.println("itemCount=" + itemCount);
					dueTime = DateUtil.add(item.getEffectiveTime(), item.getTerm(), itemCount);
				} else {
					// 固定账期日
					if (DateUtil.isFirstMonth(item.getTerm(), user.getBillingDay(), item.getEffectiveTime(), now)) {
						// 如果是第一个周期，按日收取
						if (2 == item.getItemType()) {
							// 增值服务，按周期累账
							amount = item.getItemPrice().doubleValue();
							Date[] term = DateUtil.getBillingTerm(item.getEffectiveTime(), user.getBillingDay());
							dueTime = term[1];
							//DateUtil.add(dt, term, count)
						} else {
							// 套餐，按日累账
							amount = item.getItemPrice().doubleValue() / DateUtil.getTermDays(item.getTerm());
							//Date nextStartDate = (item.getDueTime() == null ? item.getEffectiveTime() : new Date(item.getDueTime().getTime() + 1));
							dueTime = DateUtil.getDayEnd(now);
						}
					} else {
						// 按周期收取
						int itemCount = (item.getItemCount() == null || 0 == item.getItemCount() ? 1 : item.getItemCount());
						amount = item.getItemPrice().doubleValue() * itemCount;
						dueTime = DateUtil.add(bill.getStartDate(), item.getTerm(), itemCount);
					}
				}
			}
			//amount = item.getItemPrice().doubleValue() * item.getItemCount();
			if (billItem == null) {
				billItem = new OcsBillItem();
				billItem.setId(UUID.get());
				billItem.setBillId(bill.getId());
				billItem.setAccountItemId(sysAccountItem.getId());
				billItem.setAccountItemCode(sysAccountItem.getItemCode());
				billItem.setAccountItemName(sysAccountItem.getItemName());
				billItem.setAccountItemDesc("");
				total += amount;
				billItem.setAmount(new BigDecimal(amount));
				billItem.setAmountProceed(new BigDecimal(0));
				billItem.setCreateTime(now);
				daoOcsBillItem.insert(billItem);
				billItems.put(itemKey, billItem);
			} else {
				billItem.setAmount(new BigDecimal(billItem.getAmount().doubleValue() + amount));
				daoOcsBillItem.updateByPrimaryKeySelective(billItem);
			}
			item.setDueTime(dueTime);
			daoCrmOrderItem.updateByPrimaryKey(item);
			System.out.println("item.id=" + item.getId() + ", dueTime=" + item.getDueTime());
		}
		// 更新账单主表金额
		bill.setAmountDue(new BigDecimal(total));
		daoOcsBill.updateByPrimaryKey(bill);
		return new String[]{"0", "用户周期账单项已成功生成。"};
	}

	public String[] releaseBills(Map<String, Object> map) {
		try {
			map.put("newStatus", 2);
			// 更新状态为执行
			int count = daoOcsBill.updateStatusByCriteria(map);
			// 将已执行完（应收款=实收款)标注为完成
			daoOcsBill.finishByAmount((String)map.get("billNo"));
			if (count > 0) {
				return new String[]{"0", "发布成功"};
			} else {
				return new String[]{"2", "没有符合条件的账单可发布"};
			}
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			return new String[]{"1", "发布失败:" + e.getMessage()};
		}
	}
	
	public String[] releaseUserBill(String userId) {
		try {
			daoOcsBill.updateStatusByUserId(userId, 2);
			return new String[]{"0", "发布成功"};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			return new String[]{"1", "发布失败:" + e.getMessage()};
		}
	}

	public String[] updateStatus(String billId, Integer status) {
		try {
			daoOcsBill.updateStatus(billId, status);
			return new String[]{"0", "操作成功"};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			return new String[]{"1", "操作失败:" + e.getMessage()};
		}
	}
	
	/**
	 * 缴费充值
	 */
	@Transactional
	public synchronized String pay(Map<String, String> obj) throws Exception {
		Date now = new Date();
		String customerId = obj.get("customerId");
		Customer customer = daoCustomer.selectByPrimaryKey(customerId);
		CrmUser user = null;
		String accountId = null;
		OcsBill bill = null;
		String invoiceId = UUID.get();
		double total = Double.parseDouble(obj.get("amountProceed"));
		double balance = total;
		double totalProceed = 0;
		double lastAccountBalance = 0;
		// 核销账单
		List<OcsInvoiceItem> invoiceItems = new ArrayList<OcsInvoiceItem>();
		String billId = obj.get("billId");
		if (!StringUtil.isEmpty(billId)) {
			bill = daoOcsBill.selectByPrimaryKey(billId);
			accountId = bill.getCreditorId();
			// 账户余额也可用于核销账单
			CrmAccount account = daoAccount.selectByPrimaryKey(accountId);
			lastAccountBalance = account.getAmount().doubleValue();
			balance += lastAccountBalance;
			user = daoCrmUser.selectByPrimaryKey(bill.getUserId());
			// 核销账单明细
			List<OcsBillItem> billItems = daoOcsBillItem.selectByBillId(billId);
			for (OcsBillItem billItem : billItems) {
				double amountDue = billItem.getAmount().doubleValue() - billItem.getAmountProceed().doubleValue();
				if (amountDue <= 0) continue;
				double amountProceed = (amountDue > balance ? balance : amountDue);
				totalProceed += amountProceed;
				balance -= amountProceed;
				// 核销账单明细项
				daoOcsBillItem.addAmountProceed(billItem.getId(), new BigDecimal(amountProceed));
				// 生成收据明细项
				OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
				invoiceItem.setId(UUID.get());
				invoiceItem.setInvoiceId(invoiceId);
				invoiceItem.setBillId(bill.getId());
				invoiceItem.setBillItemId(billItem.getId());
				invoiceItem.setBillItemCode(billItem.getAccountItemCode());
				invoiceItem.setBillItemName(billItem.getAccountItemName());
				if (totalProceed <= total) {
					// 核销总金额小于本次支付金额
					invoiceItem.setAmount(new BigDecimal(amountProceed));
				} else if (totalProceed - total < amountProceed) {
					// 本次支付金额不足，使用了账户余额核销
					invoiceItem.setAmount(new BigDecimal(totalProceed - total));
					invoiceItem.setRemark("账户余额-" + (amountProceed - totalProceed + total));
				} else {
					invoiceItem.setAmount(new BigDecimal(0.0));
					invoiceItem.setRemark("账户余额-" + amountProceed);
				}
				daoInvoiceItem.insert(invoiceItem);
				invoiceItems.add(invoiceItem);
				// 金额已核销完，退出
				if (balance <= 0) break;
			}
			// 核销账单金额
			daoOcsBill.addAmountProceed(bill.getId(), new BigDecimal(totalProceed));
			// 如果账单金额已全部核销，账单状态转为完成
			if (bill.getAmountDue().doubleValue() <= bill.getAmountProceed().doubleValue() + totalProceed) {
				daoOcsBill.updateStatus(bill.getId(), 9);
			}
		} else {
			CrmAccount account = daoAccount.selectByCustomerId(customerId);
			accountId = account.getId();
			lastAccountBalance = account.getAmount().doubleValue();
			balance += lastAccountBalance;
		}
		// 生成收据
		OcsInvoice invoice = new OcsInvoice();
		invoice.setId(invoiceId);
		invoice.setInvoiceNo(sysSequence.currVal("INVOICE_NO", now));
		invoice.setCustomerId(customerId);
		invoice.setAccountId(accountId);
		if (user != null) {
			invoice.setUserName(user.getName());
			invoice.setUserKey(user.getBusinessKey());
		}
		invoice.setCustomerName(customer.getName());
		invoice.setCustomerNo(customer.getCustomerNo());
		invoice.setLinker(customer.getLinker());
		invoice.setLinkPhone(customer.getLinkPhone());
		invoice.setAmount(new BigDecimal(total));
		invoice.setStatus(1);
		invoice.setPrintFlag(Integer.parseInt("" + obj.get("printFlag")));
		invoice.setCreator(obj.get("creator"));
		invoice.setChecker(invoice.getCreator());
		invoice.setCreateTime(now);
		invoice.setInvoiceType(OcsInvoice.INVOICE_TYPE_RECEIPT);
		if (1 == invoice.getPrintFlag()) {
			invoice.setPrintTime(now);
		}
		invoice.setCheckTime(now);
		daoInvoice.insert(invoice);
		// 本次
		if (balance > lastAccountBalance) {
			// 生成收据明细项
			OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
			invoiceItem.setId(UUID.get());
			invoiceItem.setInvoiceId(invoiceId);
			invoiceItem.setBillItemName("充值");
			invoiceItem.setAmount(new BigDecimal(balance - lastAccountBalance));
			daoInvoiceItem.insert(invoiceItem);
		}
		// 生成流水账
		// 收入流水
		OcsAccountLog accLog = new OcsAccountLog();
		accLog.setId(UUID.get());
		accLog.setCustomerId(customerId);
		accLog.setAccountId(accountId);
		accLog.setLogNo(sysSequence.currVal("ACCOUNT_LOG_NO", now));
		accLog.setOpType("0");
		accLog.setAmount(invoice.getAmount());
		accLog.setOper(invoice.getCreator());
		accLog.setOpTime(now);
		accLog.setVoucherNo(invoice.getInvoiceNo());
		daoOcsAccountLog.insert(accLog);
		// 支付流水
		if (totalProceed > 0) {
			accLog = new OcsAccountLog();
			accLog.setId(UUID.get());
			accLog.setCustomerId(customerId);
			accLog.setAccountId(accountId);
			accLog.setLogNo(sysSequence.currVal("ACCOUNT_LOG_NO", now));
			accLog.setOpType("10");
			accLog.setAmount(new BigDecimal(-totalProceed));
			accLog.setOper(invoice.getCreator());
			accLog.setOpTime(now);
			accLog.setVoucherNo(bill.getBillNo());
			daoOcsAccountLog.insert(accLog);
		}
		// 更新账户
		if (balance != lastAccountBalance ) {
			daoAccount.addAmount(accountId, new BigDecimal(balance - lastAccountBalance));
		}
		return invoiceId;
	}
	
	/**
	 * 缴费充值
	 */
	@Transactional
	public synchronized String createInvoice(Map<String, String> obj) throws Exception {
		String invoiceNo = obj.get("invoiceNo");
		if (StringUtil.isEmpty(invoiceNo)) {
			throw new Exception("缺少参数：票据号");
		}
		int count = daoInvoice.countByInvoiceNo(invoiceNo);
		if (count > 0) throw new Exception("票据号已经存在，无法新建");
		double total = Double.parseDouble(obj.get("amountProceed"));
		
		Date now = new Date();
		String customerId = obj.get("customerId");
		Customer customer = daoCustomer.selectByPrimaryKey(customerId);
		CrmAccount account = daoAccount.selectByCustomerId(customerId);
		// 生成收据
		OcsInvoice invoice = new OcsInvoice();
		invoice.setId(UUID.get());
		invoice.setInvoiceNo(invoiceNo);
		invoice.setCustomerId(customerId);
		invoice.setAccountId(account.getId());
		invoice.setCustomerNo(customer.getCustomerNo());
		invoice.setCustomerName(customer.getName());
		invoice.setLinker(customer.getLinker());
		invoice.setLinkPhone(customer.getLinkPhone());
		invoice.setAmount(new BigDecimal(total));
		invoice.setStatus(0);
		invoice.setPrintFlag(Integer.parseInt("" + obj.get("printFlag")));
		invoice.setCreator(obj.get("creator"));
		invoice.setCreateTime(now);
		invoice.setInvoiceType(OcsInvoice.INVOICE_TYPE_INVOICE);
		if (1 == invoice.getPrintFlag()) {
			invoice.setPrintTime(now);
		}
		daoInvoice.insert(invoice);
		// 明细项
		List<Map<String, Object>> billItems = daoOcsBill.selectItemsByCustomer(obj);
		for (Map<String, Object> billItem : billItems) {
			OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
			invoiceItem.setId(UUID.get());
			invoiceItem.setInvoiceId(invoice.getId());
			invoiceItem.setBillItemCode((String)billItem.get("accountItemCode"));
			invoiceItem.setBillItemName((String)billItem.get("accountItemName"));
			double amount = ((BigDecimal)billItem.get("amount")).doubleValue() - ((BigDecimal)billItem.get("amountProceed")).doubleValue();
			total -= amount;
			if (total < 0) {
				invoiceItem.setAmount(new BigDecimal(total + amount));
			} else {
				invoiceItem.setAmount(new BigDecimal(amount));
			}
			daoInvoiceItem.insert(invoiceItem);
			if (total < 0) break;
		}
		if (total > 0) {
			OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
			invoiceItem.setId(UUID.get());
			invoiceItem.setInvoiceId(invoice.getId());
			invoiceItem.setBillItemName("预存");
			invoiceItem.setAmount(new BigDecimal(total));
			daoInvoiceItem.insert(invoiceItem);
		}
		return invoice.getId();
	}
	
}
