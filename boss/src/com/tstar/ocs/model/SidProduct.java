package com.tstar.ocs.model;

import java.math.BigDecimal;
import java.util.Date;

public class SidProduct {
    private String id;

    private String name;

    private String parentId;

    private String category;

    private Integer saleType;

    private BigDecimal price;

    private String term;

    private String productDesc;

    private Integer status;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    private String ossOpenKey;
    
    private String ossCloseKey;

    public String getOssOpenKey() {
		return ossOpenKey;
	}

	public void setOssOpenKey(String ossOpenKey) {
		this.ossOpenKey = ossOpenKey;
	}

	public String getOssCloseKey() {
		return ossCloseKey;
	}

	public void setOssCloseKey(String ossCloseKey) {
		this.ossCloseKey = ossCloseKey;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    private String parentName;
    public String getParentName() { return parentName; }
    public void setParentName(String parentName) { this.parentName = parentName; }
    
    private String accountItemId;

    public String getAccountItemId() {
		return accountItemId;
	}

	public void setAccountItemId(String accountItemId) {
		this.accountItemId = accountItemId;
	}

    private String accountItemName;

	public String getAccountItemName() {
		return accountItemName;
	}

	public void setAccountItemName(String accountItemName) {
		this.accountItemName = accountItemName;
	}
    
    public String getCategoryDesc() {
    	if ("p".equals(category)) {
    		return "电话";
    	} else if ("b".equals(category)) {
    		return "宽带";
    	} else if ("a".equals(category)) {
    		return "ADSL";
    	} else if ("l".equals(category)) {
    		return "专线";
    	} else {
    		return "其他";
    	}
    }
    
    public String getSaleTypeDesc() {
    	if (saleType == null || saleType == 1) {
    		return "一次性费用";
    	} else {
    		return "周期性费用";
    	}
    }
    
    public String getTermDesc() {
    	if ("DAY".equals(term)) {
    		return "天";
    	} else if ("MONTH".equals(term)) {
    		return "月";
    	} else if ("SEASON".equals(term)) {
    		return "季度";
    	} else if ("HALFOFYEAR".equals(term)) {
    		return "半年";
    	} else if ("YEAR".equals(term)) {
    		return "年";
    	} else {
    		return "";
    	}
    }
    
    public String getUnit() {
    	if (saleType == null || saleType == 1) {
    		return "次";
    	} else {
    		return getTermDesc();
    	}
    }
    
    public String getStatusDesc() {
    	if (status == null || status == 1) {
    		return "创建";
    	} else if (status == 2) {
    		return "上架";
    	} else {
    		return "下架";
    	}
    }
    
}