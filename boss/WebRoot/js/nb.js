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
	$("#userName").val(user.name);    
	$("#userDepartmentId").val(user.departmentId);    
	$("#userDepartmentName").val(user.departmentName);    
	$("#payPolicy").val(user.payPolicy);    
	$("#userAddress").val(user.address);    
	$("#userLinkPhone").val(user.linkPhone);    
	$("#userRemark").val(user.remark);    
	$("#businessArea").val(user.businessArea);
}

function validateUser() {
	if ($("#businessKey").val() == "") {
    	bbAlert("请输入业务编号");
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
	$("#businessKey").val("");    
	$("#userName").val("");    
	$("#userDepartmentId").val("");    
	$("#userDepartmentName").val("");    
	$("#payPolicy").val("1");    
	$("#userAddress").val("");    
	$("#userLinkPhone").val("");    
	$("#userRemark").val("");    
	$("#businessArea").val("");
}
