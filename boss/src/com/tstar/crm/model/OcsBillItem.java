package com.tstar.crm.model;

import java.math.BigDecimal;
import java.util.Date;

public class OcsBillItem {
    private String id;

    private String billId;

    private String accountItemId;

    private String accountItemCode;

    private String accountItemName;

    private String accountItemDesc;

    private BigDecimal amount;
    
    private BigDecimal amountProceed;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getAccountItemId() {
        return accountItemId;
    }

    public void setAccountItemId(String accountItemId) {
        this.accountItemId = accountItemId == null ? null : accountItemId.trim();
    }

    public String getAccountItemCode() {
        return accountItemCode;
    }

    public void setAccountItemCode(String accountItemCode) {
        this.accountItemCode = accountItemCode == null ? null : accountItemCode.trim();
    }

    public String getAccountItemName() {
        return accountItemName;
    }

    public void setAccountItemName(String accountItemName) {
        this.accountItemName = accountItemName == null ? null : accountItemName.trim();
    }

    public String getAccountItemDesc() {
        return accountItemDesc;
    }

    public void setAccountItemDesc(String accountItemDesc) {
        this.accountItemDesc = accountItemDesc == null ? null : accountItemDesc.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

	public BigDecimal getAmountProceed() {
		return amountProceed;
	}

	public void setAmountProceed(BigDecimal amountProceed) {
		this.amountProceed = amountProceed;
	}
}