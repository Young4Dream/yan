package com.tstar.ocs.model;

import java.math.BigDecimal;

public class SidFee {
    private String id;

    private String name;

    private BigDecimal price;

    private String remark;

    private String accountItemId;

    public String getAccountItemId() {
		return accountItemId;
	}

	public void setAccountItemId(String accountItemId) {
		this.accountItemId = accountItemId;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    private String accountItemName;

	public String getAccountItemName() {
		return accountItemName;
	}

	public void setAccountItemName(String accountItemName) {
		this.accountItemName = accountItemName;
	}
}