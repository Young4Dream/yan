<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!-- page specific plugin styles -->
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker/datetimepicker.css" />
		<link rel="stylesheet" href="assets/css/chosen.css" />
		<!-- zTree -->
		<link rel="stylesheet" href="assets/css/zTreeStyle/metro.css">
		<!-- inline styles related to this page -->
		<link rel="stylesheet" href="css/datatable.css">

		<script src="assets/js/ace-extra.min.js"></script>	
		<!-- inline styles related to this page -->
		
		<!-- basic scripts -->
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		
		<script src='assets/js/jquery-2.0.3.min.js'></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/chosen.jquery.min.js"></script>
		<script src="assets/js/jquery.dataTables.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/crud/crud.js"></script>
		<script src="assets/js/datepicker/bootstrap-datetimepicker.js"></script>
		<script src="assets/js/datepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		<script src="assets/js/jquery.tabledit.min.js"></script>
		<!-- zTree -->
		<script src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		<!-- Customize -->
		<script src="js/customer.js"></script>
		<script src="js/phone.js"></script>
			
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">电话业务受理</a>
				</li>
				<li class="active">
					电话停复
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<i class="icon-adjust blue"></i>
								电话停复
							</h3>
						</div>
					
						<div class="panel-body">
							<!-- <form class="form-horizontal" role="form">  -->
								<div class="tabbable" id="tabtable1">
									<ul class="nav nav-tabs">
										<li class="active">
							 				<a href="#panel-7" data-toggle="tab">
							 					<i class="blue icon-adjust bigger-110"></i>
							 					电话停复
							 				</a>
										</li>
										<li>
											<a href="#panel-1" data-toggle="tab">
												<i class="green icon-user-md bigger-110"></i>
						 						客户信息
						 					</a>
										</li>
										<li>
						 					<a href="#panel-2" data-toggle="tab">
						 						<i class="red icon-money bigger-110"></i>
						 						账户信息
						 					</a>
										</li>
										<li>
							 				<a href="#panel-3" data-toggle="tab">
							 					<i class="blue icon-phone bigger-110"></i>
							 					用户信息
							 				</a>
										</li>
									</ul>
									<div class="tab-content">
										<!-- 调级 -->
										<div class="tab-pane active" id="panel-7">
											<div class="row form-group">
					 							<label for="phoneNo" class="col-sm-1 control-label">电话号码</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="userId" type="hidden"/>
													<input class="form-control" id="businessKey1" type="text" placeholder="（输入号码）查询"/>
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnChooseUser">
															<i class="ace-icon fa fa-calendar bigger-110"></i>
															查询
														</button>
													</span>
													</div>
												</div>
					 							<label for="userName1" class="col-sm-1 control-label">用户名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="userName1" type="text" readonly/>
												</div>
											</div>
											<div class="hr hr-18 dotted hr-double"></div>
											<div class="row form-group">
					 							<label for="oldPhoneLevel" class="col-sm-1 control-label">现状态</label>
												<div class="col-sm-3">
													<input id="oldUserStatus" type="hidden" />
					 								<input type="text" class="form-control" id="oldStatus" readonly />
												</div>
					 							<label for="newPhoneLevel" class="col-sm-1 control-label">新状态</label>
												<div class="col-sm-3">
													<select class="form-control" id="newStatus" role="option">
													</select>
												</div>
											</div>
										</div>
										
										<!-- 客户信息 -->
										<div class="tab-pane" id="panel-1">
											<div class="row form-group">
					 							<label for="customerNo" class="col-sm-1 control-label">客户号</label>
												<div class="col-sm-3">
													<input id="customerId" type="hidden"/>
													<input class="form-control" id="customerNo" type="text"/>
												</div>
					 							<label for="customerType" class="col-sm-1 control-label">客户类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="customerType">
													</select>
												</div>
					 							<label for="name" class="col-sm-1 control-label">名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="name" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="departmentName" class="col-sm-1 control-label">部门</label>
												<div class="col-sm-3">
													<input id="departmentId" type="hidden"/>
													<input class="form-control" id="departmentName" type="text"/>
												</div>
					 							<label for="address" class="col-sm-1 control-label">地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="address" type="text"/>
												</div>
					 							<label for="certId" class="col-sm-1 control-label">证件号码</label>
												<div class="col-sm-3">
													<input class="form-control" id="certId" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="linker" class="col-sm-1 control-label">联系人</label>
												<div class="col-sm-3">
													<input class="form-control" id="linker" type="text" />
												</div>
					 							<label for="linkPhone" class="col-sm-1 control-label">联系电话</label>
												<div class="col-sm-3">
													<input class="form-control" id="linkPhone" type="text"/>
												</div>
					 							<label for="email" class="col-sm-1 control-label">电子邮件</label>
												<div class="col-sm-3">
													<input class="form-control" id="email" type="email" />
												</div>
											</div>
											<div class="row form-group">
					 							<label for="linkAddress" class="col-sm-1 control-label">联系地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="linkAddress" type="text"/>
												</div>
					 							<label for="vip" class="col-sm-1 control-label">VIP等级</label>
												<div class="col-sm-3">
													<select class="form-control" id="vip">
													</select>
												</div>
					 							<label for="loyalty" class="col-sm-1 control-label">忠诚度</label>
												<div class="col-sm-3">
													<select class="form-control" id="loyalty">
													</select>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="customerManager" class="col-sm-1 control-label">客户经理</label>
												<div class="col-sm-3">
													<select class="form-control" id="customerManager">
													</select>
												</div>
					 							<label for="remark" class="col-sm-1 control-label">备注</label>
												<div class="col-sm-7">
													<input class="form-control" id="remark" type="text"/>
												</div>
											</div>
										</div>
										
										<!-- 账户信息 -->
										<div class="tab-pane" id="panel-2">
											<div class="row form-group">
					 							<label class="col-sm-1 control-label">客户号</label>
												<div class="col-sm-3">
													<input id="accountId" type="hidden" />
													<input class="form-control" id="customerNo1" type="text" readonly />
												</div>
					 							<label for="payMethod" class="col-sm-1 control-label">支付方法</label>
												<div class="col-sm-3">
													<select class="form-control" id="payMethod">
													</select>
												</div>
					 							<label for="creditor" class="col-sm-1 control-label">代缴客户</label>
												<div class="col-sm-3">
													<input type="hidden" id="creditor" />
													<input class="form-control" id="creditorName" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="bankName" class="col-sm-1 control-label">银行名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="bankName" type="text" />
												</div>
					 							<label for="bankAccOwner" class="col-sm-1 control-label">户主姓名</label>
												<div class="col-sm-3">
													<input class="form-control" id="bankAccOwner" type="text"/>
												</div>
					 							<label for="bankAcc" class="col-sm-1 control-label">银行账户</label>
												<div class="col-sm-3">
													<input class="form-control" id="bankAcc" type="text" />
												</div>
											</div>
											<div class="row form-group">
					 							<label for="amount" class="col-sm-1 control-label">账户余额</label>
												<div class="col-sm-3">
													<div class="input-group">
														<div class="input-group-addon">
															<span>￥</span>
														</div>
														<input class="form-control" id="amount" type="text" value="0"/>
													</div>
												</div>
					 							<label for="accRemark" class="col-sm-1 control-label">备注</label>
												<div class="col-sm-7">
													<input class="form-control" id="accRemark" type="text" />
												</div>
											</div>
										</div>
										
										<!-- 用户信息 -->
										<div class="tab-pane" id="panel-3">
											<div class="row form-group">
					 							<label class="col-sm-1 control-label">客户号</label>
												<div class="col-sm-3">
													<input class="form-control" id="customerNo2" type="text" readonly />
												</div>
					 							<label for="businessKey" class="col-sm-1 control-label">电话号码</label>
												<div class="col-sm-3">
													<input class="form-control" id="businessKey" type="text"/>
												</div>
					 							<label for="phoneAlias" class="col-sm-1 control-label">号码别名</label>
												<div class="col-sm-3">
													<input class="form-control" id="phoneAlias" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="deviceCode" class="col-sm-1 control-label">电话类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="deviceCode">
														<option value="1">CC08</option>
														<option value="2">IMS</option>
													</select>
												</div>
					 							<label for="userName" class="col-sm-1 control-label">用户名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="userName" type="text"/>
												</div>
					 							<label for="userDepartmentId" class="col-sm-1 control-label">用户部门</label>
												<div class="col-sm-3">
													<input id="userDepartmentId" type="hidden" />
													<input class="form-control" id="userDepartmentName" type="text" />
												</div>
											</div>
											<div class="row form-group">
					 							<label for="payPolicy" class="col-sm-1 control-label">付费类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="payPolicy">
													</select>
												</div>
					 							<label for="userAddress" class="col-sm-1 control-label">安装地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="userAddress" type="text"/>
												</div>
					 							<label for="userLinkPhone" class="col-sm-1 control-label">联系电话</label>
												<div class="col-sm-3">
													<input class="form-control" id="userLinkPhone" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="phoneLevel" class="col-sm-1 control-label">电话级别</label>
												<div class="col-sm-3">
													<select class="form-control" id="phoneLevel">
													</select>
												</div>
					 							<label for="callPolicy" class="col-sm-1 control-label">催缴策略</label>
												<div class="col-sm-3">
													<select class="form-control" id="callPolicy">
													</select>
												</div>
					 							<label for="adjustPolicy" class="col-sm-1 control-label">调级策略</label>
												<div class="col-sm-3">
													<select class="form-control" id="adjustPolicy">
													</select>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="security" class="col-sm-1 control-label">保密级别</label>
												<div class="col-sm-3">
													<select class="form-control" id="security">
													</select>
												</div>
					 							<label for="userPwd" class="col-sm-1 control-label">查询密码</label>
												<div class="col-sm-3">
													<input class="form-control" id="userPwd" type="password"/>
												</div>
					 							<label for="userPwd" class="col-sm-1 control-label">业务区域</label>
												<div class="col-sm-3">
													<select class="form-control" id="businessArea">
													</select>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="userRemark" class="col-sm-1 control-label">备注</label>
												<div class="col-sm-11">
													<input class="form-control" id="userRemark" type="text" />
												</div>
											</div>
										</div>
										
									</div>
								</div>					
							<!-- </form> -->
						</div>
						
						<div class="panel-footer">
							<button type="button" id="save" class="btn btn-sm btn-primary">提交</button>
							<button type="button" id="reset" class="btn btn-sm btn-primary">重置</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>

		<script type="text/javascript">
		
		var parentProductId = "p";
		var businessType = "p";
		var opType = "reset";
		var busiType = (businessType + "_" + opType).toLowerCase(); // Used by fee.js
		
        // 初始化页面控件
        $(document).ready(function () {
            // 初始化客户经理
            loadCustomerManager();
            // 初始化下拉框
            loadRefs();
       	});
       	
        // 选择号码
        var fnUserChoosed;
        $("#btnChooseUser").click(function() { 
        	$("#beginStatus").val("2");
        	$("#endStatus").val("4");
        	var phoneNo = $("#businessKey1").val();
        	fnUserChoosed = function(userId, businessKey) {
       			$("#userId").val(userId);
       			$("#businessKey").val(businessKey);
       			loadUser(userId);
       			var customerId = $("#customerId").val();
       			loadCustomer(customerId);
       			loadAccount(customerId);
       			$("#businessKey1").val(businessKey);
       			$("#userName1").val($("#userName").val());
       			/*
            	if ($("#oldUserStatus").val() == 2) {
            		$("#newUserStatus").attr("checked", "checked");
            	} else if ($("#oldUserStatus").val() == 3) {
            		$("#newUserStatus").removeAttr("checked");
            	} else {
            		bbAlert("非正常（未正式开通或已拆除）用户不能停复");
            	}
            	*/
            	var oldStatus = $("#oldUserStatus").val();
            	var html = "";
            	if (oldStatus == 2) {
            		$("#oldStatus").val("正常");
            		html = '<option value="3" selected="selected">欠费停机</option><option value="4">双向停机</option>';
            	} else if (oldStatus == 3) {
            		$("#oldStatus").val("欠费停机(单向停机)");
            		html = '<option value="2" selected="selected">单向复机</option>';
            	} else if (oldStatus == 4) {
            		$("#oldStatus").val("双向停机");
            		html = '<option value="2" selected="selected">双向复机</option>';
            	} else {
            		bbAlert("非正常（未正式开通或已拆除）用户不能停复");
            	}
            	$("#newStatus").empty();
            	$("#newStatus").append(html);
        	};
        	doSearch();
        	$("#dlgUser").modal("show");
        });
        
        function validate() {
        	if ($("#userId").val() == "") {
        		bbAlert("请选择要调级的电话");
        		return false;
        	}
        	var status = $("#oldUserStatus").val();
        	if (status != 2 && status != 3 && status != 4) {
        		bbAlert("非正常用户，无法停复");
        		return false;
        	}
        	return true;
        }
        
        $("#save").click(function() {
        	var v = validate();
        	if (!v) return;
        	
        	var op = "${sessionScope.userInfo.userName}";
        	var opParams = "";
        	var oldStatus = $("#oldUserStatus").val();
        	var newStatus = $("#newStatus").val();
        	if (oldStatus == 2 && newStatus == 3) {
        		opParams = "ossKey:stop_1,ossKeyName:欠费停机,nextStatus:3";
        	} else if (oldStatus == 2 && newStatus == 4) {
        		opParams = "ossKey:stop,ossKeyName:停机,nextStatus:4";
        	} else if (oldStatus == 3) {
        		opParams = "ossKey:res_1,ossKeyName:单停复机,nextStatus:2";
        	} else if (oldStatus == 4) {
        		opParams = "ossKey:res,ossKeyName:复机,nextStatus:2";
        	}
        	/*
        	if ($("#newUserStatus").get(0).checked) {
        		opParams = "status:2,desc:复机";
        	} else {
        		opParams = "status:3,desc:停机";
        	}
        	*/
        	var parm = {
        		"obj.id": $("#userId").val(),
        		"obj.creator": op,
        		"obj.opType": opType,
        		"obj.businessType": businessType,
        		"obj.remark": opParams
        	};
        	
        	var res = ajaxCRUD("order!resetUser.do", parm, true);
        	if (res.resNum == "0") {
        		reset();
        	}
        });
        
        function reset() {
			$("#tabtable1 li:eq(0) a").tab("show");
			$("#businessKey1").val("");
			$("#userName1").val("");
			$("#oldUserStatus").val("");
			$("#oldStatus").val("");
			$("#newStatus").empty();
			resetCustomer();
        	resetAccount();
        	resetUser();
        }
        
        $("#reset").click(function() {
        	reset();
        });
        
        </script>
        
		<jsp:include page="../pub/userDlg.jsp" flush="true"/>
        
	</body>
</html>
