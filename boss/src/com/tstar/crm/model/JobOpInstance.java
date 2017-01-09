package com.tstar.crm.model;

import java.util.Date;

public class JobOpInstance {
    private String id;

    private String parentId;

    private String businessOpKey;

    private String businessOpName;

    private String businessOpParms;

    private String customerId;

    private String customerName;

    private String userId;

    private String userKey;

    private String orderId;

    private String originator;

    private Date originateTime;

    private String processDefinitionKey;

    private String processDefinitionName;

    private String processInstanceId;

    private Integer status;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getBusinessOpKey() {
        return businessOpKey;
    }

    public void setBusinessOpKey(String businessOpKey) {
        this.businessOpKey = businessOpKey == null ? null : businessOpKey.trim();
    }

    public String getBusinessOpName() {
        return businessOpName;
    }

    public void setBusinessOpName(String businessOpName) {
        this.businessOpName = businessOpName == null ? null : businessOpName.trim();
    }

    public String getBusinessOpParms() {
        return businessOpParms;
    }

    public void setBusinessOpParms(String businessOpParms) {
        this.businessOpParms = businessOpParms == null ? null : businessOpParms.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey == null ? null : userKey.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator == null ? null : originator.trim();
    }

    public Date getOriginateTime() {
        return originateTime;
    }

    public void setOriginateTime(Date originateTime) {
        this.originateTime = originateTime;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey == null ? null : processDefinitionKey.trim();
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName == null ? null : processDefinitionName.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}