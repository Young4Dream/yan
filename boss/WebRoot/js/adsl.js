/**
	ADSL用户属性
	用于：
		ADSL装机页面 - adsl_create.jsp
		ADSL装机页面 - adsl_delete.jsp
**/

function loadUser(id) {
	var parm = { "id": id };
	var res = ajaxCRUD("crmUser!findFullInfoById.do", parm, false);
	var user = res.userFullInfo;
	$("#customerId").val(user.customerId);
	$("#acc").val(user.acc);    
	$("#userPwd").val(user.pwd);    
	$("#phoneNo").val(user.phoneNo);    
	$("#userName").val(user.name);    
	$("#userDepartmentId").val(user.departmentId);    
	$("#userDepartmentName").val(user.departmentName);    
	$("#payPolicy").val(user.payPolicy);    
	$("#userAddress").val(user.address);    
	$("#userLinkPhone").val(user.linkPhone);    
	$("#speed").val(user.speed);    
	//$("#ipAddress").val(user.ipAddress);    
	$("#macAddress").val(user.macAddress);    
	$("#notifyPolicy").val(user.notifyPolicy);    
	$("#serviceOper").val(user.serviceOper);    
	$("#userRemark").val(user.remark);    
	$("#outerVlan").val(user.outerVlan);
	$("#businessArea").val(user.businessArea);
	$("#userArea").val(user.userArea);
	$("#postAddress").val(user.postAddress);
}

function validateUser() {
	if ($("#acc").val() == "") {
    	bbAlert("请输入上网账号");
        return false;
	}
    if ($("#userPwd").val() == "") {
    	bbAlert("请输入登录密码");
        return false;
	}
    if ($("#userName").val() == "") {
    	bbAlert("请输入用户名称");
        return false;
	}
    if ($("#phoneNo").val() == "") {
    	bbAlert("请输入绑定电话");
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
	$("#acc").val("");    
	$("#userPwd").val("");    
	$("#phoneNo").val("");    
	$("#userName").val("");    
	$("#userDepartmentId").val("");    
	$("#userDepartmentName").val("");    
	$("#payPolicy").val("1");    
	$("#userAddress").val("");    
	$("#userLinkPhone").val("");    
	$("#speed").val("");    
	//$("#ipAddress").val("");    
	$("#macAddress").val("");    
	$("#notifyPolicy").val("0");    
	$("#serviceOper").val("LOCAL");    
	$("#userRemark").val("");   
	$("#outerVlan").val(""); 
	$("#businessArea").val("");
	$("#userArea").val("");
	$("#postAddress").val("");
}
