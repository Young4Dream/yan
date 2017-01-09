/**
	专线用户属性
	用于：
		专线装机页面 - pl_create.jsp
		专线装机页面 - pl_delete.jsp
**/

function loadUser(id) {
	var parm = { "id": id };
	var res = ajaxCRUD("crmUser!findFullInfoById.do", parm, false);
	var user = res.userFullInfo;
	$("#customerId").val(user.customerId);
	$("#plNo").val(user.plNo);    
	$("#plType").val(user.plType);    
	$("#plModel").val(user.plModel);    
	$("#startEp").val(user.startEp);    
	$("#endEp").val(user.endEp);    
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
	if ($("#plNo").val() == "") {
    	bbAlert("请输入专线号");
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
	$("#plNo").val("");    
	$("#plType").val("1");    
	$("#plModel").val("");    
	$("#startEp").val("");    
	$("#endEp").val("");    
	$("#userName").val("");    
	$("#userDepartmentId").val("");    
	$("#userDepartmentName").val("");    
	$("#payPolicy").val("1");    
	$("#userAddress").val("");    
	$("#userLinkPhone").val("");    
	$("#userRemark").val("");    
	$("#businessArea").val("");
}
