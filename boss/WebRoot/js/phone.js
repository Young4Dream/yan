/**
	电话用户属性
	用于：
		电话装机页面 - phone_create.jsp
**/

function loadUser(id) {
	var parm = { "id": id };
	var res = ajaxCRUD("crmUser!findFullInfoById.do", parm, false);
	var user = res.userFullInfo;
	$("#customerId").val(user.customerId);
	$("#phoneNo").val(user.phoneNo);    
	$("#phoneAlias").val(user.phoneAlias);    
	$("#deviceCode").val(user.deviceCode);    
	$("#userName").val(user.name);    
	$("#userDepartmentId").val(user.departmentId);    
	$("#userDepartmentName").val(user.departmentName);    
	$("#payPolicy").val(user.payPolicy);    
	$("#userAddress").val(user.address);    
	$("#userLinkPhone").val(user.linkPhone);    
	$("#phoneLevel").val(user.phoneLevel);    
	$("#callPolicy").val(user.callPolicy);    
	$("#adjustPolicy").val(user.adjustPolicy);    
	$("#security").val(user.secretLevel);    
	$("#userPwd").val(user.pwd);    
	$("#userRemark").val(user.remark);    
	$("#oldUserStatus").val(user.status);
	$("#businessArea").val(user.businessArea);
}

function validateUser() {
	if ($("#phoneNo").val() == "") {
    	bbAlert("请输入或选择电话号码");
        return false;
	}
    if ($("#userName").val() == "") {
    	bbAlert("请输入用户名称");
        return false;
	}
    if ($("#userAddress").val() == "") {
    	bbAlert("请输入用户安装地址");
        return false;
	}
    if ($("#userLinkePhone").val() == "") {
    	bbAlert("请输入用户联系电话");
        return false;
	}
    return true;
}

function resetUser() {
	$("#userId").val("");
	$("#phoneNo").val("");    
	$("#phoneAlias").val("");    
	$("#deviceCode").val("1");    
	$("#userName").val("");    
	$("#userDepartmentId").val("");    
	$("#userDepartmentName").val("");    
	$("#payPolicy").val("1");    
	$("#userAddress").val("");    
	$("#userLinkPhone").val("");    
	$("#phoneLevel").val("J2");    
	$("#callPolicy").val("0");    
	$("#adjustPolicy").val("0");    
	$("#security").val("0");    
	$("#userPwd").val("");    
	$("#userRemark").val("");    
	$("#businessArea").val("");
}
