/**
 * 
 */
package com.tstar.crm.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.model.AcAction;
import com.tstar.crm.dao.CrmAccountMapper;
import com.tstar.crm.dao.CrmOrderItemMapper;
import com.tstar.crm.dao.CrmOrderMapper;
import com.tstar.crm.dao.CrmUserAdslMapper;
import com.tstar.crm.dao.CrmUserBroadMapper;
import com.tstar.crm.dao.CrmUserMapper;
import com.tstar.crm.dao.CrmUserPhoneMapper;
import com.tstar.crm.dao.CrmUserPlMapper;
import com.tstar.crm.dao.CustomerMapper;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.dao.OcsAccountLogMapper;
import com.tstar.crm.dao.OcsBillItemMapper;
import com.tstar.crm.dao.OcsBillMapper;
import com.tstar.crm.dao.OcsInvoiceItemMapper;
import com.tstar.crm.dao.OcsInvoiceMapper;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.model.CrmOrder;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.crm.model.CrmUserPl;
import com.tstar.crm.model.Customer;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.crm.model.OcsAccountLog;
import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.crm.model.OcsInvoice;
import com.tstar.crm.model.OcsInvoiceItem;
import com.tstar.crm.service.CrmOrderService;
import com.tstar.crm.service.OcsBillService;
import com.tstar.ocs.dao.SidOpMapper;
import com.tstar.ocs.dao.SidProductMapper;
import com.tstar.ocs.model.SidOp;
import com.tstar.ocs.model.SidProduct;
import com.tstar.portal.dao.ProfileMapper;
import com.tstar.portal.dao.SysSequencePoolMapper;
import com.tstar.portal.model.Profile;
import com.tstar.portal.model.SysAccountItem;
import com.tstar.portal.service.SysSequenceService;
import com.tstar.res.dao.ResAccMapper;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.res.model.ResAcc;
import com.tstar.res.model.ResPhoneNumber;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class CrmOrderServiceImpl implements CrmOrderService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private CrmOrderMapper dao;
	@Resource
	private CrmOrderItemMapper daoOrderItem;
	@Resource
	private CustomerMapper daoCustomer;
	@Resource
	private SysSequencePoolMapper daoSysSequencePool;
	@Resource
	private CrmAccountMapper daoAccount;
	@Resource
	private CrmUserMapper daoUser;
	@Resource
	private CrmUserPhoneMapper daoUserPhone;
	@Resource
	private CrmUserBroadMapper daoUserBroad;
	@Resource
	private CrmUserAdslMapper daoUserAdsl;
	@Resource
	private CrmUserPlMapper daoUserPl;
	@Resource
	private ResPhoneNumberMapper daoPhoneNumber;
	@Resource
	private ResAccMapper daoAcc;
	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	@Resource
	private SidOpMapper daoSidOp;
	@Resource
	private AcActionMapper daoAcAction;
	@Resource
	private OcsBillMapper daoOcsBill;
	@Resource
	private OcsBillItemMapper daoOcsBillItem;
	@Resource
	private OcsInvoiceMapper daoOcsInvoice;
	@Resource
	private OcsInvoiceItemMapper daoOcsInvoiceItem;
	@Resource
	private OcsAccountLogMapper daoOcsAccountLog;
	@Resource
	private SysSequenceService sysSequence;
	@Resource
	private OcsBillService billService;
	@Resource
	private SidProductMapper daoSidProduct;
	@Resource
	private ProfileMapper daoProfile;

	@Resource
    RepositoryService repositoryService;
	@Resource
	RuntimeService runtimeService;
	@Resource
	IdentityService identityService;
	
	@Transactional
	public String[] insert(CrmOrder obj) throws Exception {
		Date now = new Date();
		
		CrmUser user = obj.getUser();
		
		try {
			// 检查用户标识是否已被占用
			int len = daoUser.countEffectiveByKey(user.getBusinessType(), user.getBusinessKey());
			if (len > 0) {
				return new String[]{"1", "开户失败: 号码" + user.getBusinessKey() + "已被占用"};
			}
			if ("p".equals(user.getBusinessType())) {
				// 电话业务，检查号码的有效性
				ResPhoneNumber phoneNumber = daoPhoneNumber.selectByNumber(user.getBusinessKey());
				if (phoneNumber == null || 0 != phoneNumber.getStatus() || 0 != phoneNumber.getReserved()) {
					return new String[]{"2", "无效的号码：" + user.getBusinessKey()};
				}
			} else if ("a".equals(user.getBusinessType()) || "b".equals(user.getBusinessType())) {
				// 宽带业务，检查账号的有效性
				ResAcc acc = daoAcc.selectByAcc(user.getBusinessKey());
				if (acc == null || 0 != acc.getStatus()) {
					return new String[]{"2", "无效的账号:" + user.getBusinessKey()};
				}
			}
			
			// 保存客户信息和账户信息
			Customer customer = obj.getCustomer();
			CrmAccount account = obj.getAccount();
			if (StringUtil.isEmpty(customer.getId())) {
				Map<String, Object> criteria = new HashMap<String, Object>();
				criteria.put("customerNo", customer.getCustomerNo());
				int count = daoCustomer.countByCriteria(criteria);
				if (count > 0) {
					return new String[]{"1", "开户失败: 客户号" + customer.getCustomerNo() + "已被占用"};
				}
				customer.setId(UUID.get());
				customer.setStatus(0);
				customer.setCreateTime(now);
				daoCustomer.insert(customer);
				daoSysSequencePool.deleteByPolicyKeyAndValue("CUSTOMER_NO", customer.getCustomerNo());
				account.setCustomerId(customer.getId());
				account.setAccNo(customer.getCustomerNo());
				account.setId(UUID.get());
				account.setCreateTime(now);
				daoAccount.insert(account);
			}
			
			// 用户信息
			user.setId(UUID.get());
			user.setCustomerId(customer.getId());
			user.setStatus(0);
			user.setCreateTime(now);
			daoUser.insert(user);
			
			// 扩展用户信息
			String businessType = user.getBusinessType();
			String macFlag = "000";		// 宽带MAC地址验证标志
			String vlanFlag = "000";	// 宽带VLAN验证标志
			if ("p".equals(businessType)) {
				CrmUserPhone userPhone = (CrmUserPhone)obj.getExtendedUser();
				userPhone.setId(user.getId());
				userPhone.setPhoneNo(user.getBusinessKey());
				daoUserPhone.insert(userPhone);
				// 设置号码为占用
				daoPhoneNumber.updateStatus(userPhone.getPhoneNo(), 9, user.getName());
			} else if ("b".equals(businessType)) {
				CrmUserBroad userBroad = (CrmUserBroad)obj.getExtendedUser();
				userBroad.setId(user.getId());
				userBroad.setAcc(user.getBusinessKey());
				daoUserBroad.insert(userBroad);
				// 设置账号为占用
				daoAcc.updateStatus(user.getBusinessKey(), 9, user.getName());
				if (!StringUtil.isEmpty(userBroad.getMacAddress())) {
					macFlag = "001";
				}
				if (!StringUtil.isEmpty(userBroad.getOuterVlan())) {
					vlanFlag = "001";
				}
			} else if ("a".equals(businessType)) {
				CrmUserAdsl userAdsl = (CrmUserAdsl)obj.getExtendedUser();
				userAdsl.setId(user.getId());
				userAdsl.setAcc(user.getBusinessKey());
				daoUserAdsl.insert(userAdsl);
				// 设置账号为占用
				daoAcc.updateStatus(user.getBusinessKey(), 9, user.getName());
				if (!StringUtil.isEmpty(userAdsl.getMacAddress())) {
					macFlag = "001";
				}
				if (!StringUtil.isEmpty(userAdsl.getOuterVlan())) {
					vlanFlag = "001";
				}
			} else if ("l".equals(businessType)) {
				CrmUserPl userPl = (CrmUserPl)obj.getExtendedUser();
				userPl.setId(user.getId());
				userPl.setPlNo(user.getBusinessKey());
				daoUserPl.insert(userPl);
			} else {
				log.warn("新业务类型：" + businessType);
			}
			
			// 订单信息
			obj.setId(user.getId());
			obj.setBusinessType(user.getBusinessType());
			obj.setBusinessKey(user.getBusinessKey());
			obj.setStatus(0);
			obj.setCustomerId(customer.getId());
			obj.setCreateTime(new Date());
			dao.insert(obj);
			
			// 套餐、增值服务、业务受理费
			List<CrmOrderItem> orderItems = obj.getOrderItems();
			if (orderItems != null && orderItems.size() > 0) {
				for (CrmOrderItem item : orderItems) {
					item.setId(UUID.get());
					item.setOrderId(obj.getId());
					item.setStatus(0);
					daoOrderItem.insert(item);
				}
			}
			
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 如果定义了流程，用于保存businessKey
			String instanceId = "";
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					String deploymentId = processDefinition.getDeploymentId();
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							daoJobOpInstance.insert(instance);
							instanceId = businessKey;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}
			// 业务发放
			// 如果有流程，状态设置为0(等待)，等到流程中确认之后状态才转化为1(开始发放)
			int actionStatus = ("".equals(instanceId) ? 1 : 0);
			AcAction action = new AcAction();
			action.setId(UUID.get());
			action.setUserId(user.getId());
			action.setBusinessKey(user.getBusinessKey());
			action.setBusinessType(user.getBusinessType());
			action.setJobId(instanceId);
			action.setOssKey(obj.getOpType());
			action.setStatus(actionStatus);
			action.setRetry(0);
			action.setCreateTime(now);
			if ("a".equals(businessType) || "b".equals(businessType)) {
				action.setParms("macFlag:" + macFlag + ",vlanFlag:" + vlanFlag);
			}
			daoAcAction.insert(action);
			action.setParms("");
			if ("p".equals(businessType)) {
				// 电话业务，设置电话级别
				action.setId(UUID.get());
				action.setOssKey(((CrmUserPhone)obj.getExtendedUser()).getPhoneLevel());
				now = new Date(now.getTime() + 1000);
				action.setCreateTime(now);
				daoAcAction.insert(action);
			}
			// 扫描订单项以探测业务发放
			if (orderItems != null && orderItems.size() > 0) {
				for (CrmOrderItem item : orderItems) {
					if (2 == item.getItemType() && !StringUtil.isEmpty(item.getOssKey())) {
						// 增值服务业务发放
						action.setId(UUID.get());
						action.setOssKey(item.getOssKey());
						now = new Date(now.getTime() + 1000);
						action.setCreateTime(now);
						daoAcAction.insert(action);
					} else if (1 == item.getItemType()) {
						if ("a".equals(businessType) || "b".equals(businessType)) {
							// 设置宽带带宽和到期时间
							// 设置账期日
							Profile profile = daoProfile.selectByUk("ocs", user.getBusinessType() + "BillingDay");
							int billingDay = Integer.parseInt(profile.getProfileValue());
							if (billingDay == 0 || billingDay > 31) {
								//user.setBillingDay(DateUtil.getDay(now));
								user.setBillingDay(0);
							} else {
								user.setBillingDay(billingDay);
							}
							action.setId(UUID.get());
							action.setOssKey("set_band_expiry");
							int itemCount = item.getItemCount() == 0 ? 1 : item.getItemCount();
							Date[] term = DateUtil.getBillingTerm(now, item.getTerm(), itemCount, user.getBillingDay());
							String parms = "expiry:" + DateUtil.format(term[1]);
							action.setParms(parms);
							now = new Date(now.getTime() + 1000);
							action.setCreateTime(now);
							daoAcAction.insert(action);
							action.setParms("");
						}
					}
				}
			}
			// 生成账单和收据
			String invoiceId = GenerateBillAndInvoice(obj);
			return new String[]{"0", invoiceId};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}
	
	private String GenerateBillAndInvoice(CrmOrder obj) {
		if (obj.getAmountProceed().doubleValue() <= 0) {
			return null;
		}
		Date now = new Date();
		CrmUser user = obj.getUser();
		String[] as = billService.findRootCreditor(user.getCustomerId());
		Date[] ds = DateUtil.getBillingTerm(now, 0);
		OcsBill bill = daoOcsBill.selectByUserIdAndDate(user.getId(), now);
		if (bill == null) {
			// 账单不存在，新建账单
			bill = new OcsBill();
			bill.setId(UUID.get());
			bill.setUserId(user.getId());
			bill.setCustomerId(user.getCustomerId());
			bill.setAccountId(as[0]);
			bill.setCreditorId(as[1]);
			bill.setStartDate(ds[0]);
			bill.setEndDate(ds[1]);
			bill.setBillNo(sysSequence.currVal("BILL_NO", ds[0]));
			bill.setAmountDue(new BigDecimal("0"));
			bill.setAmountProceed(new BigDecimal("0"));
			bill.setPayPolicy(user.getPayPolicy());
			bill.setStatus(9);	// 账单状态设置为完成
			bill.setCreateTime(now);
			daoOcsBill.insert(bill);
		}
		List<CrmOrderItem> orderItems = obj.getOrderItems();
		Map<String, OcsBillItem> billItems = new HashMap<String, OcsBillItem>();
		double total = 0;
		for (CrmOrderItem item : orderItems) {
			if (0 == item.getPayFlag() || 0 == item.getItemCount() || 0 != item.getStatus()) {
				// 未支付或者订购数为零的忽略
				continue;
			}
			// 保存新账单项目
			SysAccountItem sysAccountItem = billService.findAccountItem(item.getItemId(), item.getItemType());
			String itemKey = bill.getId() + sysAccountItem.getId();
			OcsBillItem billItem = billItems.get(itemKey);
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
				billItem.setAmountProceed(new BigDecimal(amount));
				billItem.setCreateTime(now);
				daoOcsBillItem.insert(billItem);
				billItems.put(itemKey, billItem);
			} else {
				billItem.setAmount(new BigDecimal(billItem.getAmount().doubleValue() + amount));
				// 标注为已支付
				billItem.setAmountProceed(billItem.getAmount());
				daoOcsBillItem.updateByPrimaryKeySelective(billItem);
			}
			// 更新订单项的账务到期日
			item.setDueTime(dueTime);
			daoOrderItem.updateByPrimaryKey(item);
		}
		// 更新账单主表金额
		bill.setAmountDue(new BigDecimal(total));
		bill.setAmountProceed(new BigDecimal(total));
		daoOcsBill.updateByPrimaryKey(bill);
		
		// 保存票据主表
		OcsInvoice invoice = new OcsInvoice();
		invoice.setId(obj.getId());
		invoice.setInvoiceNo(sysSequence.currVal("INVOICE_NO", ds[0]));
		invoice.setCustomerId(user.getCustomerId());
		invoice.setCustomerNo(obj.getCustomer().getCustomerNo());
		invoice.setAccountId(as[1]);
		invoice.setUserName(user.getName());
		invoice.setUserKey(user.getBusinessKey());
		invoice.setCustomerName(obj.getCustomer().getName());
		invoice.setLinker(obj.getCustomer().getLinker());
		invoice.setLinkPhone(obj.getCustomer().getLinkPhone());
		invoice.setAmount(obj.getAmountProceed());
		invoice.setStatus(1); // 收取了现金，设置为已核销
		invoice.setPrintFlag(obj.getPrintFlag());
		invoice.setCreator(obj.getCreator());
		invoice.setChecker(obj.getCreator());
		invoice.setCreateTime(now);
		invoice.setInvoiceType(OcsInvoice.INVOICE_TYPE_RECEIPT);
		if (1 == invoice.getPrintFlag()) {
			invoice.setPrintTime(now);
		}
		invoice.setCheckTime(now);
		daoOcsInvoice.insert(invoice);
		// 保存票据明细
		double balance = invoice.getAmount().doubleValue();
		for (Map.Entry<String, OcsBillItem> entry : billItems.entrySet()) {
			OcsBillItem billItem = entry.getValue();
			OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
			invoiceItem.setId(billItem.getId());
			invoiceItem.setInvoiceId(invoice.getId());
			invoiceItem.setBillId(bill.getId());
			invoiceItem.setBillItemId(billItem.getId());
			invoiceItem.setBillItemCode(billItem.getAccountItemCode());
			invoiceItem.setBillItemName(billItem.getAccountItemName());
			invoiceItem.setAmount(billItem.getAmount());
			daoOcsInvoiceItem.insert(invoiceItem);
			balance = balance - billItem.getAmount().doubleValue();
		}
		if (balance > 0) {
			OcsInvoiceItem invoiceItem = new OcsInvoiceItem();
			invoiceItem.setId(UUID.get());
			invoiceItem.setInvoiceId(invoice.getId());
			invoiceItem.setBillItemName("结余");
			invoiceItem.setAmount(new BigDecimal(balance));
			daoOcsInvoiceItem.insert(invoiceItem);
		}
		// 更新账户余额
		CrmAccount acc = daoAccount.selectByPrimaryKey(invoice.getAccountId());
		acc.setAmount(new BigDecimal(acc.getAmount().doubleValue() + balance));
		daoAccount.updateByPrimaryKeySelective(acc);
		// 更新流水账
		// 收入流水
		OcsAccountLog accLog = new OcsAccountLog();
		accLog.setId(UUID.get());
		accLog.setCustomerId(user.getCustomerId());
		accLog.setAccountId(acc.getId());
		accLog.setLogNo(sysSequence.currVal("ACCOUNT_LOG_NO", now));
		accLog.setOpType("0");
		accLog.setAmount(obj.getAmountProceed());
		accLog.setOper(obj.getCreator());
		accLog.setOpTime(now);
		accLog.setVoucherNo(invoice.getInvoiceNo());
		daoOcsAccountLog.insert(accLog);
		// 支付流水
		accLog = new OcsAccountLog();
		accLog.setId(UUID.get());
		accLog.setCustomerId(user.getCustomerId());
		accLog.setAccountId(acc.getId());
		accLog.setLogNo(sysSequence.currVal("ACCOUNT_LOG_NO", now));
		accLog.setOpType("10");
		accLog.setAmount(new BigDecimal(-bill.getAmountDue().doubleValue()));
		accLog.setOper(obj.getCreator());
		accLog.setOpTime(now);
		accLog.setVoucherNo(bill.getBillNo());
		daoOcsAccountLog.insert(accLog);
		
		return invoice.getId();
	}
	
	/**
	 * 拆除用户
	 */
	@Transactional
	public String[] deleteUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		
		try {
			Customer customer = daoCustomer.selectByPrimaryKey(obj.getCustomerId());
			CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
			obj.setUser(user);
			obj.setCustomer(customer);
			if (user.getStatus() == 90) {
				return new String[]{"1", "用户正在拆除，无法重复执行！"};
			}
			if (user.getStatus() == 91) {
				return new String[]{"2", "用户已被拆除，无法重复执行！"};
			}
			if (user.getStatus() < 2) {
				return new String[]{"3", "用户正在装机中，无法执行拆除！"};
			}
			
			// 更新用户状态
			user.setStatus(90);
			user.setUpdateTime(now);
			daoUser.updateByPrimaryKeySelective(user);
			
			// 保存拆机费用
			if (obj.getOrderItems() != null && obj.getOrderItems().size() > 0) {
				for (CrmOrderItem item : obj.getOrderItems()) {
					item.setId(UUID.get());
					item.setOrderId(obj.getId());
					item.setStatus(0);
					daoOrderItem.insert(item);
					System.out.println("insert delete fee...");
				}
			}
			
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			System.out.println(businessOpKey);
			// 如果定义了流程，用于保存实例ID
			String instanceId = "";
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			System.out.println("processKey=" + sysBusinessOp.getModelKey());
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				System.out.println("finding processDefinition...");
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					System.out.println("finding process deployment...");
					String deploymentId = processDefinition.getDeploymentId();
					System.out.println("deploymentId=" + deploymentId);
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							System.out.println("originator=" + obj.getCreator());
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instanceId = instance.getId();
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							daoJobOpInstance.insert(instance);
							System.out.println("job op instance saved.");
						} catch (Exception e1) {
							System.out.println(ExceptionUtil.getStackTrace(e1));
							throw e1;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}	
			// 生成账单和收据
			String invoiceId = GenerateBillAndInvoice(obj);
			obj.setUser(null);
			obj.setCustomer(null);
			// 生成OSS指令
			int actionStatus = ("".equals(instanceId) ? 1 : 0);
			AcAction action = new AcAction();
			action.setId(UUID.get());
			action.setUserId(user.getId());
			action.setBusinessKey(user.getBusinessKey());
			action.setBusinessType(user.getBusinessType());
			action.setJobId(instanceId);
			action.setOssKey(obj.getOpType());
			action.setStatus(actionStatus);
			action.setRetry(0);
			action.setCreateTime(now);
			daoAcAction.insert(action);
			return new String[]{"0", invoiceId};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

	/**
	 * 立即拆除用户
	 */
	public String[] deleteUserImmediately(String userId) {
		CrmUser user = daoUser.selectByPrimaryKey(userId);
		if (user == null) {
			return new String[]{"1", "用户已被删除！"};
		}
		// 删除订单信息
		daoOrderItem.deleteByOrderId(userId);
		dao.deleteByPrimaryKey(userId);
		if ("p".equals(user.getBusinessKey())) {
			daoUserPhone.deleteByPrimaryKey(userId);
			// 解锁电话号码
			daoPhoneNumber.unlockPhoneNumber(user.getBusinessKey());
		} else if ("a".equals(user.getBusinessKey())) {
			daoUserAdsl.deleteByPrimaryKey(userId);
		} else if ("b".equals(user.getBusinessKey())) {
			daoUserBroad.deleteByPrimaryKey(userId);
		} else if ("l".equals(user.getBusinessKey())) {
			daoUserPl.deleteByPrimaryKey(userId);
		}
		// 删除用户信息
		daoUser.deleteByPrimaryKey(userId);
		return new String[]{"0", "删除成功！"};
	}
	
	public String[] editUser(CrmOrder obj) {
		Date now = new Date();
		CrmUser user = obj.getUser();
		user.setUpdateTime(now);
		daoUser.updateByPrimaryKeySelective(user);
		String businessType = user.getBusinessType();
		if ("p".equals(businessType)) {
			// 查看密码是否修改
			CrmUserPhone oldPhone = daoUserPhone.selectByPrimaryKey(user.getId());
			CrmUserPhone userPhone = (CrmUserPhone)obj.getExtendedUser();
			daoUserPhone.updateByPrimaryKeySelective(userPhone);
			if (!StringUtil.isEmpty(userPhone.getPwd()) && !userPhone.getPwd().equals(oldPhone.getPwd())) {
				// 新密码不为空，且与原密码不符，发送修改密码指令
				AcAction action = new AcAction();
				action.setId(UUID.get());
				action.setUserId(user.getId());
				action.setBusinessKey(oldPhone.getPhoneNo());
				action.setBusinessType(businessType);
				action.setOssKey("ch_pwd");
				action.setStatus(1);
				action.setRetry(0);
				action.setCreateTime(now);
				daoAcAction.insert(action);
			}
		} else if ("b".equals(businessType)) {
			CrmUserBroad userBroad = (CrmUserBroad)obj.getExtendedUser();
			// 查看是否调整了VLAN和MAC
			CrmUserBroad oldBroad = daoUserBroad.selectByPrimaryKey(user.getId());
			daoUserBroad.updateByPrimaryKeySelective(userBroad);
			//if (!userBroad.getMacAddress().equals(oldBroad.getMacAddress()) || !userBroad.getOuterVlan().equals(oldBroad.getOuterVlan())) {
				// MAC和VLAN调整，发送修改指令
				AcAction action = new AcAction();
				action.setId(UUID.get());
				action.setUserId(user.getId());
				action.setBusinessKey(oldBroad.getAcc());
				action.setBusinessType(businessType);
				action.setOssKey("mod_bind");
				String macFlag = StringUtil.isEmpty(userBroad.getMacAddress()) ? "000" : "001";
				String vlanFlag = StringUtil.isEmpty(userBroad.getOuterVlan()) ? "000" : "001";
				action.setParms("macFlag:" + macFlag + ",vlanFlag:" + vlanFlag);
				action.setStatus(1);
				action.setRetry(0);
				action.setCreateTime(now);
				daoAcAction.insert(action);
			//}
		} else if ("a".equals(businessType)) {
			CrmUserAdsl userAdsl = (CrmUserAdsl)obj.getExtendedUser();
			// 查看是否调整了VLAN和MAC
			CrmUserAdsl oldAdsl = daoUserAdsl.selectByPrimaryKey(user.getId());
			daoUserAdsl.updateByPrimaryKeySelective(userAdsl);
			//if (!userAdsl.getMacAddress().equals(oldAdsl.getMacAddress()) || !userAdsl.getOuterVlan().equals(oldAdsl.getOuterVlan())) {
				// MAC和VLAN调整，发送修改指令
				AcAction action = new AcAction();
				action.setId(UUID.get());
				action.setUserId(user.getId());
				action.setBusinessKey(oldAdsl.getAcc());
				action.setBusinessType(businessType);
				action.setOssKey("mod_bind");
				String macFlag = StringUtil.isEmpty(userAdsl.getMacAddress()) ? "000" : "001";
				String vlanFlag = StringUtil.isEmpty(userAdsl.getOuterVlan()) ? "000" : "001";
				action.setParms("macFlag:" + macFlag + ",vlanFlag:" + vlanFlag);
				action.setStatus(1);
				action.setRetry(0);
				action.setCreateTime(now);
				daoAcAction.insert(action);
			//}
		} else if ("l".equals(businessType)) {
			CrmUserPl userPl = (CrmUserPl)obj.getExtendedUser();
			daoUserPl.updateByPrimaryKeySelective(userPl);
		} else {
			log.warn("新业务类型：" + businessType);
		}
		return new String[]{"0", "修改已保存！"};
	}
	
	@Transactional
	public String[] changeUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		Customer customer = daoCustomer.selectByPrimaryKey(obj.getCustomerId());
		CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
		obj.setUser(user);
		obj.setCustomer(customer);
		
		// 启动流程
		String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
		// 预先生成流程快照ID
		String businessKey = UUID.get();
		// 如果定义了流程，用于保存businessKey
		String instanceId = "";
		// 根据业务操作标识查询流程模型KEY
		SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
		if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
			ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
			if (processDefinition != null) {
				String deploymentId = processDefinition.getDeploymentId();
				// 只有部署的流程才能启动
				if (deploymentId != null && !"".equals(deploymentId)) {
					try {
						// 设置业务发起人
						identityService.setAuthenticatedUserId(obj.getCreator());
						Map<String, Object> variables = new HashMap<String, Object>();
						// 将业务发起人存入流程变量
						variables.put("originator", obj.getCreator());
						// 启动流程
						ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
						// 保存业务流程快照
						JobOpInstance instance = new JobOpInstance();
						instance.setId(businessKey);
						instance.setBusinessOpKey(obj.getOpType());
						instance.setBusinessOpName(sysBusinessOp.getName());
						instance.setCustomerId(customer.getId());
						instance.setCustomerName(customer.getName());
						instance.setUserId(user.getId());
						instance.setUserKey(user.getBusinessKey());
						instance.setOrderId(obj.getId());
						instance.setOriginator(obj.getCreator());
						instance.setOriginateTime(now);
						instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
						instance.setProcessDefinitionName(processDefinition.getName());
						instance.setProcessInstanceId(processInstance.getId());
						instance.setStatus(1);
						daoJobOpInstance.insert(instance);
						instanceId = businessKey;
					} finally {
						identityService.setAuthenticatedUserId(null);
					}
				}
			}
		}
		
		// 更新套餐、增值服务、业务受理费
		List<CrmOrderItem> orderItems = obj.getOrderItems();
		if (orderItems != null && orderItems.size() > 0) {
			int actionStatus = 1; //("".equals(instanceId) ? 1 : 0);
			AcAction action = new AcAction();
			action.setId(UUID.get());
			action.setUserId(user.getId());
			action.setBusinessKey(user.getBusinessKey());
			action.setBusinessType(user.getBusinessType());
			action.setJobId(instanceId);
			action.setStatus(actionStatus);
			action.setRetry(0);
			for (CrmOrderItem item : orderItems) {
				if (StringUtil.isEmpty(item.getId())) {
					item.setId(UUID.get());
					item.setOrderId(obj.getId());
					item.setStatus(2);
					daoOrderItem.insert(item);
					if (2 == item.getItemType() && !StringUtil.isEmpty(item.getOssKey())) {
						// 增值服务开通指令
						action.setId(UUID.get());
						action.setOssKey(item.getOssKey());
						now = new Date(now.getTime() + 1000);
						action.setCreateTime(now);
						daoAcAction.insert(action);
					} else if (1 == item.getItemType() && ("a".equals(user.getBusinessType()) || "b".equals(user.getBusinessType()))) {
						// 宽带业务开通
						if (item.getEffectiveTime().getTime() <= now.getTime()) {
							// 设置宽带带宽和到期时间
							action.setId(UUID.get());
							action.setOssKey("set_band_expiry");
							int itemCount = item.getItemCount() == 0 ? 1 : item.getItemCount();
							Date[] term = DateUtil.getBillingTerm(item.getEffectiveTime(), item.getTerm(), itemCount, 0);
							String parms = "expiry:" + DateUtil.format(term[1]);
							action.setParms(parms);
							now = new Date(now.getTime() + 1000);
							action.setCreateTime(now);
							daoAcAction.insert(action);
							action.setParms("");
						}
					}
				} else {
					CrmOrderItem newItem = new CrmOrderItem();
					newItem.setId(item.getId());
					newItem.setStatus(item.getStatus());
					// 生成拆除指令
					if (2 == item.getItemType() && 4 == item.getStatus()) {
						newItem.setStatus(9);
						SidProduct sidProduct = daoSidProduct.selectByPrimaryKey(item.getItemId());
						if (!StringUtil.isEmpty(sidProduct.getOssCloseKey())) {
							action.setId(UUID.get());
							action.setOssKey(sidProduct.getOssCloseKey());
							now = new Date(now.getTime() + 1000);
							action.setCreateTime(now);
							daoAcAction.insert(action);
						}
					}
					daoOrderItem.updateByPrimaryKeySelective(newItem);
				}
			}
		}
		
		// 生成账单和收据
		String invoiceId = GenerateBillAndInvoice(obj);
		obj.setUser(null);
		obj.setCustomer(null);
		return new String[]{"0", invoiceId};
	}

	@Transactional
	public String[] moveUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		try {
			CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
			Customer customer = daoCustomer.selectByPrimaryKey(user.getCustomerId());
			// 保存移机费用
			if (obj.getOrderItems() != null && obj.getOrderItems().size() > 0) {
				for (CrmOrderItem item : obj.getOrderItems()) {
					item.setId(UUID.get());
					item.setOrderId(obj.getId());
					item.setStatus(0);
					daoOrderItem.insert(item);
				}
			}
			// 保存移机信息
			CrmOrder order = new CrmOrder();
			order.setId(obj.getId());
			order.setRemark(obj.getOpType() + ":" + obj.getRemark());
			dao.updateByPrimaryKeySelective(order);
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					String deploymentId = processDefinition.getDeploymentId();
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							// 新安装地址存入流程变量
							//variables.put("newUserAddress", obj.getRemark());
							variables.put("newUserAddress", obj.getUser().getAddress());
							variables.put("newBusinessKey", obj.getUser().getBusinessKey());
							variables.put("newOuterVlan", obj.getUser().getRemark());
							variables.put("newBusienssArea", obj.getUser().getBusinessArea());
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							instance.setRemark(obj.getRemark());
							daoJobOpInstance.insert(instance);
						} catch (Exception e1) {
							System.out.println(ExceptionUtil.getStackTrace(e1));
							throw e1;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}	
			// 生成账单和收据
			obj.setUser(user);
			obj.setCustomer(customer);
			String invoiceId = GenerateBillAndInvoice(obj);
			obj.setUser(null);
			obj.setCustomer(null);
			return new String[]{"0", invoiceId};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

	@Transactional
	public String[] transferUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		
		try {
			CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
			Customer customer = daoCustomer.selectByPrimaryKey(user.getCustomerId());
			obj.setUser(user);
			obj.setCustomer(customer);
			// 保存拆机费用
			if (obj.getOrderItems() != null && obj.getOrderItems().size() > 0) {
				for (CrmOrderItem item : obj.getOrderItems()) {
					item.setId(UUID.get());
					item.setOrderId(obj.getId());
					item.setStatus(0);
					daoOrderItem.insert(item);
					System.out.println("insert delete fee...");
				}
			}
			// 保存过户信息
			CrmOrder order = new CrmOrder();
			order.setId(obj.getId());
			order.setRemark(obj.getRemark());
			dao.updateByPrimaryKeySelective(order);
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			System.out.println("businessOpKey=" + businessOpKey);
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				System.out.println("modelKey=" + sysBusinessOp.getModelKey());
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					System.out.println("processDefinitionId=" + processDefinition.getId());
					String deploymentId = processDefinition.getDeploymentId();
					System.out.println("deploymentId=" + deploymentId);
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							// 目标客户ID、新用户名和联系电话存入流程变量
							String[] infos = obj.getRemark().split(",");
							for (String info : infos) {
								String[] ps = info.split(":");
								variables.put(ps[0], ps[1]);
							}
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							instance.setRemark(obj.getRemark());
							daoJobOpInstance.insert(instance);
						} catch (Exception e1) {
							System.out.println(ExceptionUtil.getStackTrace(e1));
							throw e1;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}	
			// 生成账单和收据
			String invoiceId = GenerateBillAndInvoice(obj);
			obj.setUser(null);
			obj.setCustomer(null);
			return new String[]{"0", invoiceId};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

	@Transactional
	public String[] adjustUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		
		try {
			CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
			Customer customer = daoCustomer.selectByPrimaryKey(user.getCustomerId());
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			System.out.println("businessOpKey=" + businessOpKey);
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				System.out.println("modelKey=" + sysBusinessOp.getModelKey());
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					System.out.println("processDefinitionId=" + processDefinition.getId());
					String deploymentId = processDefinition.getDeploymentId();
					System.out.println("deploymentId=" + deploymentId);
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							// 将原级别和新级别存入流程变量
							String[] infos = obj.getRemark().split(",");
							for (String info : infos) {
								String[] ps = info.split(":");
								variables.put(ps[0], ps[1]);
							}
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setBusinessOpParms((String)variables.get("newPhoneLevel"));
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							instance.setRemark(obj.getRemark());
							daoJobOpInstance.insert(instance);
							// 添加OSS指令
							AcAction action = new AcAction();
							action.setId(UUID.get());
							action.setUserId(user.getId());
							action.setBusinessKey(user.getBusinessKey());
							action.setBusinessType(user.getBusinessType());
							action.setJobId(instance.getId());
							action.setOssKey((String)variables.get("ossKey"));
							action.setOssKeyName((String)variables.get("ossKeyName"));
							action.setStatus(1);
							action.setRetry(0);
							action.setCreateTime(now);
							daoAcAction.insert(action);
						} catch (Exception e1) {
							System.out.println(ExceptionUtil.getStackTrace(e1));
							throw e1;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}	
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
		return new String[]{"0", "调级操作已提交！"};
	}

	@Transactional
	public String[] resetUser(CrmOrder obj) throws Exception {
		Date now = new Date();
		
		try {
			CrmUser user = daoUser.selectByPrimaryKey(obj.getId());
			Customer customer = daoCustomer.selectByPrimaryKey(user.getCustomerId());
			// 启动流程
			String businessOpKey = obj.getBusinessType().toLowerCase() + "_" + obj.getOpType();
			// 预先生成流程快照ID
			String businessKey = UUID.get();
			// 根据业务操作标识查询流程模型KEY
			SidOp sysBusinessOp = daoSidOp.selectByName(businessOpKey); 
			System.out.println("businessOpKey=" + businessOpKey);
			if (sysBusinessOp != null && !StringUtil.isEmpty(sysBusinessOp.getModelKey())) {
				System.out.println("modelKey=" + sysBusinessOp.getModelKey());
				ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(sysBusinessOp.getModelKey()).singleResult();
				if (processDefinition != null) {
					System.out.println("processDefinitionId=" + processDefinition.getId());
					String deploymentId = processDefinition.getDeploymentId();
					System.out.println("deploymentId=" + deploymentId);
					// 只有部署的流程才能启动
					if (deploymentId != null && !"".equals(deploymentId)) {
						try {
							// 设置业务发起人
							identityService.setAuthenticatedUserId(obj.getCreator());
							Map<String, Object> variables = new HashMap<String, Object>();
							// 将业务发起人存入流程变量
							variables.put("originator", obj.getCreator());
							// 将原级别和新级别存入流程变量
							System.out.println(obj.getRemark());
							String[] infos = obj.getRemark().split(",");
							for (String info : infos) {
								String[] ps = info.split(":");
								variables.put(ps[0], ps[1]);
							}
							// 启动流程
							ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(sysBusinessOp.getModelKey(), businessKey, variables);
							// 保存业务流程快照
							JobOpInstance instance = new JobOpInstance();
							instance.setId(businessKey);
							instance.setBusinessOpKey(obj.getOpType());
							instance.setBusinessOpName(sysBusinessOp.getName());
							instance.setBusinessOpParms((String)variables.get("nextStatus"));
							instance.setCustomerId(customer.getId());
							instance.setCustomerName(customer.getName());
							instance.setUserId(user.getId());
							instance.setUserKey(user.getBusinessKey());
							instance.setOrderId(obj.getId());
							instance.setOriginator(obj.getCreator());
							instance.setOriginateTime(now);
							instance.setProcessDefinitionKey(sysBusinessOp.getModelKey());
							instance.setProcessDefinitionName(processDefinition.getName());
							instance.setProcessInstanceId(processInstance.getId());
							instance.setStatus(1);
							instance.setRemark(obj.getRemark());
							daoJobOpInstance.insert(instance);
							// 添加OSS指令
							AcAction action = new AcAction();
							action.setId(UUID.get());
							action.setUserId(user.getId());
							action.setBusinessKey(user.getBusinessKey());
							action.setBusinessType(user.getBusinessType());
							action.setJobId(instance.getId());
							action.setOssKey((String)variables.get("ossKey"));
							action.setOssKeyName((String)variables.get("ossKeyName"));
							action.setStatus(1);
							action.setRetry(0);
							action.setCreateTime(now);
							daoAcAction.insert(action);
						} catch (Exception e1) {
							System.out.println(ExceptionUtil.getStackTrace(e1));
							throw e1;
						} finally {
							identityService.setAuthenticatedUserId(null);
						}
					}
				}
			}	
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
		return new String[]{"0", "停复机操作已提交！"};
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public List<CrmOrder> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public String[] update(CrmOrder obj) {
		obj.setUpdateTime(new Date());
		int res = dao.updateByPrimaryKey(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}
	
	public String[] delete(String id) {
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

	public List<Map<String, Object>> selectPlanInOrder(String customerId, String businessKey) {
		return dao.selectPlanInOrder(customerId, businessKey);
	}

	public List<Map<String, Object>> selectProductInOrder(String customerId, String businessKey) {
		return dao.selectProductInOrder(customerId, businessKey);
	}

	public List<Map<String, Object>> selectFeeInOrder(String customerId, String businessKey) {
		return dao.selectFeeInOrder(customerId, businessKey);
	}

	public List<Map<String, Object>> selectPlanInOrderByUser(String userId) {
		return dao.selectPlanInOrderByUser(userId);
	}

	public List<Map<String, Object>> selectProductInOrderByUser(String userId) {
		return dao.selectProductInOrderByUser(userId);
	}

	public List<Map<String, Object>> selectFeeInOrderByUser(String userId) {
		return dao.selectFeeInOrderByUser(userId);
	}

}
