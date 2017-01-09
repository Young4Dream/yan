/**
	客户、账户信息
	用于：
		电话装机页面 - phone_create.jsp
**/

function loadCustomer(id) {
	var parm = { "id": id };
	var res = ajaxCRUD("customer!findById.do", parm, false);
	var customer = res.obj;
	if (customer == undefined) return;
	$("#customerId").val(customer.id);
	$("#customerNo").val(customer.customerNo);
	$("#name").val(customer.name);
	$("#customerType").val(customer.customerType);
	$("#departmentId").val(customer.departmentId);
	$("#departmentName").val(customer.departmentName);
	$("#address").val(customer.address);
	$("#certId").val(customer.certId);
	$("#linker").val(customer.linker);
	$("#linkPhone").val(customer.linkPhone);
	$("#email").val(customer.email);
	$("#linkAddress").val(customer.linkAddress);
	$("#vip").val(customer.vip);
	$("#loyalty").val(customer.loyalty);
	$("#customerManager").val(customer.customerManager);
	$("#remark").val(customer.remark);
	$("#customerNo1").val(customer.customerNo);
	$("#customerNo2").val(customer.customerNo);
}

function loadAccount(customerId) {
	var parm = { "id": customerId };
	var res = ajaxCRUD("account!findByCustomerId.do", parm, false);
	var acc = res.obj;
	if (acc == undefined) return;
	$("#payMethod").val(acc.payMethod);
	$("#creditor").val(acc.creditor);
	$("#creditorName").val(acc.creditorName);
	$("#bankName").val(acc.bankName);
	$("#bankAcc").val(acc.bankAcc);
	$("#bankAccOwner").val(acc.bankAccOwner);
	$("#amount").val(acc.amount);
	$("#accRemark").val(acc.remark);
}

function validateCustomer() {
	if ($("#customerNo").val() == "") {
		bbAlert("请输入或者选择合同号");
        return false;
    }
    if ($("#name").val() == "") {
    	bbAlert("请输入客户名称");
        return false;
	}
    if ($("#address").val() == "") {
		bbAlert("请输入客户地址");
		return false;
	}
	if ($("#certId").val() == "") {
		bbAlert("请输入客户证件号");
		return false;
	}
	return true;
}

function validateAccount() {
	return true;
}

function resetCustomer() {
	$("#customerId").val("");
	$("#customerNo").val("");
	$("#name").val("");
	$("#customerType").val("1");
	$("#departmentId").val("");
	$("#departmentName").val("");
	$("#address").val("");
	$("#certId").val("");
	$("#linker").val("");
	$("#linkPhone").val("");
	$("#email").val("");
	$("#linkAddress").val("");
	$("#vip").val("0");
	$("#loyalty").val("1");
	$("#customerManager").val("");
	$("#remark").val("");
	$("#customerNo1").val("");
	$("#customerNo2").val("");
}

function resetAccount() {
	$("#payMethod").val("1");
	$("#creditor").val("");
	$("#creditorName").val("");
	$("#bankName").val("");
	$("#bankAcc").val("");
	$("#bankAccOwner").val("");
	$("#amount").val(0);
	$("#accRemark").val("");
}

function setCustomerReadonly(readonly) {
}

function setAccountReadonly(readonly) {
}

function loadCustomerManager() {
	var res = ajaxCRUD("user!findByRoleName.do", { "obj.roleId": "客户经理" }, false);
	var lst = res.lst;
	var html = "<option role='option' value=''>请选择客户经理...</option>";
	$(lst).each(function(index) {
		var item = lst[index];
		html += "<option role='option' value='" + item.id + "'>" + item.userAlias + "</option>";
	});
	$("#customerManager").empty();
	$("#customerManager").append(html);
}

function loadRefs() {
	loadRef("ref_business_area", "businessArea", "--选择业务区域--");
	loadRef("ref_customer_type", "customerType");
	loadRef("ref_vip", "vip");
	loadRef("ref_loyalty", "loyalty");
	loadRef("ref_pay_method", "payMethod");
	loadRef("ref_call_policy", "callPolicy");
	loadRef("ref_adjust_policy", "adjustPolicy");
	loadRef("ref_security", "security");
	loadRef("ref_pay_policy", "payPolicy");
	loadRef("ref_phone_level", "phoneLevel");
	// 宽带、ADSL
	loadRef("ref_notify_policy", "notifyPolicy");
	//loadRef("ref_service_oper", "serviceOper");
	loadRef("ref_user_area", "userArea", "--选择用户区域--");
	loadRef("ref_band_width", "speed");
	// 专线
	loadRef("ref_pl_type", "plType");
}  	

function initChanged() {
	$("#name").change(customerNameChanged);
	$("#address").change(customerAddressChanged);
	$("#linkPhone").change(customerLinkPhoneChanged);
}

function customerNameChanged() {
	if ($("#customerType").val() == "1" && $("#userName").val() == "") {
		$("#userName").val($("#name").val());
	}
}

function customerAddressChanged() {
	if ($("#userAddress").val() == "") {
		$("#userAddress").val($("#address").val());
	}
}

function customerLinkPhoneChanged() {
	if ($("#userLinkPhone").val() == "") {
		$("#userLinkPhone").val($("#linkPhone").val());
	}
}

