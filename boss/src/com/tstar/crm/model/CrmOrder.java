package com.tstar.crm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CrmOrder {
    private String id;

    private String orderNo;

    private String customerId;

    private String businessType;

    private String businessKey;

    private Integer status;

    private String processDefinitionId;

    private String processInstanceId;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private Date effectiveTime;

    private Date expiryTime;

    private String remark;
    
    private String opType;

    public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId == null ? null : processDefinitionId.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    ////////////////////////////////////////////////////////
    private Customer customer;
    private CrmAccount account;
    private CrmUser user;
    private Object extendedUser;
    private List<CrmOrderItem> orderItems;

	public List<CrmOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CrmOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public CrmUser getUser() {
		return user;
	}

	public void setUser(CrmUser user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CrmAccount getAccount() {
		return account;
	}

	public void setAccount(CrmAccount account) {
		this.account = account;
	}

	public Object getExtendedUser() {
		return extendedUser;
	}

	public void setExtendedUser(Object extendedUser) {
		this.extendedUser = extendedUser;
	}
    
	private BigDecimal amountDue;
	private BigDecimal amountProceed;
	private Integer printFlag;

	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}

	public BigDecimal getAmountProceed() {
		return amountProceed;
	}

	public void setAmountProceed(BigDecimal amountProceed) {
		this.amountProceed = amountProceed;
	}

	public Integer getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}
}