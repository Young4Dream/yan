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
		<script src="js/resDeptDlg.js"></script>
		<script src="js/customer.js"></script>
		<script src="js/broad.js"></script>
		<script src="js/pricePlan.js"></script>
		<script src="js/product.js"></script>
		<script src="js/fee.js"></script>
			
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">宽带业务受理</a>
				</li>
				<li class="active">
					装机
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
								宽带装机
							</h3>
						</div>
					
						<div class="panel-body">
							<!-- <form class="form-horizontal" role="form">  -->
								<div class="tabbable" id="tabtable1">
									<ul class="nav nav-tabs">
										<li id="firstPage" class="active">
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
										<li>
							 				<a href="#panel-4" data-toggle="tab">
							 					<i class="dark icon-dollar bigger-110"></i>
							 					资费
							 				</a>
										</li>
										<li>
							 				<a href="#panel-5" data-toggle="tab">
							 					<i class="orange icon-tags bigger-110"></i>
							 					增值服务
							 				</a>
										</li>
										<li>
							 				<a href="#panel-6" data-toggle="tab">
							 					<i class="purple icon-credit-card bigger-110"></i>
							 					业务受理费
							 				</a>
										</li>
									</ul>
									<div class="tab-content">
										<!-- 客户信息 -->
										<div class="tab-pane active" id="panel-1">
											<div class="row form-group">
					 							<label for="customerNo" class="col-sm-1 control-label">客户号</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="customerId" type="hidden"/>
													<input class="form-control" id="customerNo" type="text" placeholder="输入或生成客户号"/>
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnPickCustomerNo">
															<i class="ace-icon fa fa-calendar bigger-110"></i> 选择
														</button> </span>
													</div>
												</div>
					 							<label for="customerType" class="col-sm-1 control-label">客户类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="customerType">
														<option value="1">个人</option>
														<option value="2">公司</option>
														<option value="3">酒店</option>
													</select>
												</div>
					 							<label for="name" class="col-sm-1 control-label">名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="name" type="text" placeholder="请输入个人姓名或公司名称"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="departmentName" class="col-sm-1 control-label">部门</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="departmentId" type="hidden"/>
													<input class="form-control" id="departmentName" type="text" placeholder="选择部门"/>
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnChooseCustomerDept">
															<i class="ace-icon fa fa-calendar bigger-110"></i>
															选择
														</button>
													</span>
													</div>
												</div>
					 							<label for="address" class="col-sm-1 control-label">地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="address" type="text" placeholder="请输入地址"/>
												</div>
					 							<label for="certId" class="col-sm-1 control-label">证件号码</label>
												<div class="col-sm-3">
													<input class="form-control" id="certId" type="text" placeholder="请输入证件号码"/>
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
														<option value="0">非VIP用户</option>
														<option value="1">普通</option>
														<option value="2">重要</option>
														<option value="3">非常重要</option>
													</select>
												</div>
					 							<label for="loyalty" class="col-sm-1 control-label">忠诚度</label>
												<div class="col-sm-3">
													<select class="form-control" id="loyalty">
														<option value="1">普通</option>
														<option value="2">中</option>
														<option value="3">高</option>
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
														<option value="1">现金支付</option>
														<option value="2">银行托收</option>
													</select>
												</div>
					 							<label for="creditor" class="col-sm-1 control-label">代缴客户</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input type="hidden" id="creditor" />
													<input class="form-control" id="creditorName" type="text"/>
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnChooseCreditor">
															<i class="ace-icon fa fa-calendar bigger-110"></i>
															选择
														</button>
													</span>
													</div>
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
					 							<label for="acc" class="col-sm-1 control-label">上网账号</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="userId" type="hidden"/>
													<input class="form-control" id="acc" type="text" placeholder="请输入宽带登录用户名"/>
													<span class="input-group-addon">
															<i class="icon-key bigger-110"></i>
													</span>
													</div>
												</div>
					 							<label for="userPwd" class="col-sm-1 control-label">登录口令</label>
												<div class="col-sm-3">
													<input class="form-control" id="userPwd" type="password" placeholder="请输入登录口令" value="888888"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="deviceCode" class="col-sm-1 control-label">宽带类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="deviceCode">
														<option value="1" selected="selected">以太网</option>
													</select>
												</div>
					 							<label for="userName" class="col-sm-1 control-label">用户名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="userName" type="text" placeholder="请输入个人姓名或公司名称"/>
												</div>
					 							<label for="userDepartmentId" class="col-sm-1 control-label">用户部门</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="userDepartmentId" type="hidden" />
													<input class="form-control" id="userDepartmentName" type="text" />
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnChooseUserDept">
															选择
														</button>
													</span>
													</div>
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
													<input class="form-control" id="userAddress" type="text" placeholder="点击选择安装地址"/>
												</div>
					 							<label for="postAddress" class="col-sm-1 control-label">邮政地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="postAddress" type="text" placeholder="市政标准地址"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="userLinkPhone" class="col-sm-1 control-label">联系电话</label>
												<div class="col-sm-3">
													<input class="form-control" id="userLinkPhone" type="text" placeholder="请输入联系电话"/>
												</div>
					 							<label for="speed" class="col-sm-1 control-label">带宽</label>
												<div class="col-sm-3">
													<select class="form-control" id="speed">
													</select>
												</div>
					 							<label class="col-sm-1 control-label">绑定MAC</label>
												<div class="col-sm-3">
													<input class="form-control" id="macAddress" type="text"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="outerVlan" class="col-sm-1 control-label">VLAN</label>
												<div class="col-sm-3">
													<input class="form-control" id="outerVlan" type="text"/>
												</div>
					 							<label for="notifyPolicy" class="col-sm-1 control-label">提醒策略</label>
												<div class="col-sm-3">
													<select class="form-control" id="notifyPolicy">
													</select>
												</div>
					 							<label for="userArea" class="col-sm-1 control-label">用户区域</label>
												<div class="col-sm-3">
													<select class="form-control" id="userArea">
													</select>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="businessArea" class="col-sm-1 control-label">业务区域</label>
												<div class="col-sm-3">
													<select class="form-control" id="businessArea">
													</select>
												</div>
					 							<label for="userRemark" class="col-sm-1 control-label">备注</label>
												<div class="col-sm-7">
													<input class="form-control" id="userRemark" type="text" />
												</div>
											</div>
										</div>
										
										<!-- 资费 -->
										<div class="tab-pane" id="panel-4">
											<table id="table_view_plan" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th><i class="icon-edit purple bigger-110"></i></th>
														<th><i class="icon-flag red bigger-110"></i></th>
														<th><i class="icon-money orange bigger-110"></i></th>
														<th >名称</th>
														<th >周期</th>
														<th >套餐费</th>
														<th >描述</th>
														<th>订购数</th>
														<th>订购备注</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>										
										</div>
										
										<!-- 增值服务 -->
										<div class="tab-pane" id="panel-5">
											<table id="table_view_product" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th><i class="icon-edit purple bigger-110"></i></th>
														<th><i class="icon-flag red bigger-110"></i></th>
														<th><i class="icon-money orange bigger-110"></i></th>
														<th>产品名称</th>
														<th>单价（￥）</th>
														<th>单位</th>
														<th>订购数量</th>
														<th>订购单价（￥）</th>
														<th>备注</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>										
										</div>
										
										<!-- 业务受理费 -->
										<div class="tab-pane" id="panel-6">
											<div class="row clearfix">
												<div class="col-md-12 column">
													<div class="row clearfix">
														<div class="col-md-7 column">
															<table id="table_view_fee" class="table table-striped table-bordered table-hover">
																<thead>
																	<tr>
																		<th><i class="icon-edit purple bigger-110"></i></th>
																		<th><i class="icon-flag red bigger-110"></i></th>
																		<th><i class="icon-money orange bigger-110"></i></th>
																		<th>费用名称</th>
																		<th>预收费用（￥）</th>
																		<th>实收费用（￥）</th>
																		<th>备注</th>
																	</tr>
																</thead>
																<tbody></tbody>
															</table>										
														</div>
														<div class="col-md-5 column">
															<div class="widget-box widget-color-blue">
																<div class="widget-header">
																	<h5 class="widget-title bigger lighter">
																		<i class="icon-shopping-cart orange bigger-110"></i>
																		费用合计
																	</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main padding-24">
																		<div class="row form-group">
																			<label class="col-sm-3 control-label">应收费：</label>
																			<div class="col-sm-9">
																				<div class="input-group">
																					<div class="input-group-addon">
																						<span>￥</span>
																					</div>
																					<input class="form-control" id="amountDue" type="text" value="0" readonly />
																				</div>
																			</div>
																		</div>
																		<div class="row form-group">
																			<label class="col-sm-3 control-label">实收费：</label>
																			<div class="col-sm-9">
																				<div class="input-group">
																					<div class="input-group-addon">
																						<span>￥</span>
																					</div>
																					<input class="form-control" id="amountProceed" type="text" value="0" />
																				</div>
																			</div>
																		</div>
																		<div class="row form-group">
																			<label class="col-sm-3 control-label">票据打印：</label>
																			<div class="col-sm-9">
																				<label>
																					<input id="printFlag" class="ace ace-switch ace-switch-7" type="checkbox" />
																					<span class="lbl"></span>
																				</label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
									</div>
								</div>					
							<!-- </form> -->
						</div>
						
						<div class="panel-footer">
							<button type="button" id="save" class="btn btn-sm btn-primary">开户</button>
							<button type="button" id="reset" class="btn btn-sm btn-primary">重置</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>

		<script type="text/javascript">
		
		var parentProductId = "b"; // Used by product.js
		var businessType = "b";
		var opType = "setup";
		var busiType = (businessType + "_" + opType).toLowerCase(); // Used by fee.js
		
        // 初始化页面控件
        $(document).ready(function () {
        	// 初始化选择框
        	loadRefs();
            // 初始化客户经理
            loadCustomerManager();
            // 初始化部门树
			initResDeptTree();
			// 显示套餐选择清单
			initEditablePlanList(businessType);
       		$('#table_view_plan tbody').on('click', 'td.details-control', openPlanEditor);  
       		// 显示产品和增值服务选择清单
       		initEditableProductList();
       		$('#table_view_product tbody').on('click', 'td.details-control', openProductEditor);  
       		// 显示产品和增值服务选择清单
       		initEditableFeeList();
       		$('#table_view_fee tbody').on('click', 'td.details-control', openFeeEditor);  
       		// 设置客户名称、地址、联系电话值变化事件
       		initChanged();
       	});
       	
		// 选择客户
		var fnBtnClickedCustomer;
		$("#btnPickCustomerNo").click(function() {
			fnBtnClickedCustomer = function(customerId, customerNo, customerName) {
				if (customerId == undefined || customerId == "") {
					var parm = {"policyKey": "CUSTOMER_NO"};
					var res = ajaxCRUD("seq!currVal.do", parm, false);
					$("#customerNo").val(res.seqVal);
					$("#customerNo1").val(res.seqVal);
					$("#customerNo2").val(res.seqVal);
				} else {
					// 载入客户和账户信息
					loadCustomer(customerId);
					loadAccount(customerId);
				}
			};
			$("#btnGenerateCustomerNo").show();
			$("#dlgCustomer").modal("show");
		});
		
		// 选择代缴客户
		$("#btnChooseCreditor").click(function() {
			fnBtnClickedCustomer = function(customerId, customerNo, customerName) {
				$("#creditor").val(customerId);
				$("#creditorName").val(customerNo + " " + customerName);
			};
			$("#btnGenerateCustomerNo").hide();
			$("#dlgCustomer").modal("show");
		});
		
		$("#customerNo").change(function() {
			$("#customerNo1").val($("#customerNo").val());
			$("#customerNo2").val($("#customerNo").val());
		});
		
		
        var fnDeptChoosed;
        $("#btnChooseCustomerDept").click(function() { 
        	fnDeptChoosed = function(id, name) {
        		$("#departmentId").val(id);
        		$("#departmentName").val(name);
        	}; 
        	$("#dlgResDept").modal("show");
        });
       
        $("#btnChooseUserDept").click(function() {
        	fnDeptChoosed = function(id, name) {
        		$("#userDepartmentId").val(id);
        		$("#userDepartmentName").val(name);
        	}; 
        	$("#dlgResDept").modal("show");
        });
        
        var fnAddressChoosed;
        $("#userAddress").focus(function() {
        	fnAddressChoosed = function(address, vlan, accPrefix, businessArea){
        		$("#userAddress").val(address);
        		$("#outerVlan").val(vlan);
        		$("#businessArea").val(businessArea);
        		var parm = {
        			"obj.acc": accPrefix,
        			"obj.bearable": businessType
        		};
        		if (accPrefix != undefined && accPrefix != "") {
        			var res = ajaxCRUD("resAcc!findTopUsable.do", parm, false);
	        		$("#acc").val(res.id);
        		}
        	};
        	$("#dlgAddress").modal("show");
        });
        
        function validate() {
        	var flag = validateCustomer();
        	if (!flag) return false;
        	flag = validateAccount();
        	if (!flag) return false;
        	flag = validateUser();
        	if (!flag) return false;
        	flag = validateAmount();
        	if (!flag) return false;
        	return true;
        }
        
        $("#save").click(function() {
        	var v = validate();
        	if (!v) return;
        	
        	var op = "${sessionScope.userInfo.userName}";
        	var parm = {
        		"obj.creator": op,
        		"obj.opType": opType,
        		"obj.amountDue": $("#amountDue").val(),
        		"obj.amountProceed": $("#amountProceed").val(),
        		"obj.printFlag": ($("#printFlag").get(0).checked ? 1 : 0),
        		
        		"obj.customer.id": $("#customerId").val(),
    			"obj.customer.name": $("#name").val(),
        		"obj.customer.customerNo": $("#customerNo").val(),
        		"obj.customer.customerType": $("#customerType").val(),
        		"obj.customer.departmentId": $("#departmentId").val(),
        		"obj.customer.address": $("#address").val(),
        		"obj.customer.certType": "1",
        		"obj.customer.certId": $("#certId").val(),
        		"obj.customer.linker": $("#linker").val(),
        		"obj.customer.linkPhone": $("#linkPhone").val(),
        		"obj.customer.email": $("#email").val(),
        		"obj.customer.linkAddress": $("#linkAddress").val(),
        		"obj.customer.vip": $("#vip").val(),
        		"obj.customer.loyalty": $("#loyalty").val(),
        		"obj.customer.customerManager": $("#customerManager").val(),
        		"obj.customer.status": 0,
        		"obj.customer.creator": op,
        		"obj.customer.remark": $("#remark").val(),
        		
        		"obj.account.id": $("#accountId").val(),
        		"obj.account.payMethod": $("#payMethod").val(),
        		"obj.account.creditor": $("#creditor").val(),
        		"obj.account.bankName": $("#bankName").val(),
        		"obj.account.bankAcc": $("#bankAcc").val(),
        		"obj.account.bankAccOwner": $("#bankAccOwner").val(),
        		"obj.account.remark": $("#accRemark").val(),
        		
        		"user.businessType" : businessType,
        		"user.businessKey" : $("#acc").val(),
        		"user.pwd": $("#userPwd").val(),
        		"user.name" : $("#userName").val(),
        		"user.departmentId" : $("#userDepartmentId").val(),
        		"user.payPolicy": $("#payPolicy").val(),
        		"user.address": $("#userAddress").val(),
        		"user.linkPhone": $("#userLinkPhone").val(),
        		"user.speed": $("#speed").val(),
        		"user.ipAddress": $("#ipAddress").val(),
        		"user.macAddress": $("#macAddress").val(),
        		"user.notifyPolicy": $("#notifyPolicy").val(),
        		"user.serviceOper": $("#serviceOper").val(),
        		"user.creator": op,
        		"user.remark": $("#userRemark").val(),
        		"user.outerVlan": $("#outerVlan").val(),
        		"user.businessArea": $("#businessArea").val(),
        		"user.userArea": $("#userArea").val(),
        		"user.postAddress": $("#postAddress").val(),
        		
        	};
        	
        	var index = 0;
        	
        	var tableData = table_view_plan.rows().data();
        	var planCount = tableData.length;
        	for (var i = 0; i < planCount; i++) {
        		var data = tableData[i];
        		if (data.planChoosed == "1") {
		        	parm["orderItems[" + index + "].itemId"] = data.id;
    		    	parm["orderItems[" + index + "].itemName"] = data.name;
    		    	parm["orderItems[" + index + "].itemType"] = 1;
    		    	parm["orderItems[" + index + "].saleType"] = 2;
    	 		   	parm["orderItems[" + index + "].term"] = data.term;
    	   		 	parm["orderItems[" + index + "].itemCount"] = 1;
    	    		parm["orderItems[" + index + "].itemPrice"] = data.planFee;
    	    		parm["orderItems[" + index + "].remark"] = data.planChoosedRemark;
    	    		parm["orderItems[" + index + "].payFlag"] = data.planPayChoosed;
    	    		index++;
    	    	}
        	}
        	
        	if (index != 1) {
        		bbAlert("必须选择资费且只能选择一个资费");
        		return;
        	}
        	
        	tableData = table_view_product.rows().data();
        	var productCount = tableData.length;
        	for (var i = 0; i < productCount; i++) {
        		var data = tableData[i];
        		if (data.productChoosed == "1") {
		        	parm["orderItems[" + index + "].itemId"] = data.id;
    		    	parm["orderItems[" + index + "].itemName"] = data.name;
    		    	parm["orderItems[" + index + "].itemType"] = 2;
    		    	parm["orderItems[" + index + "].saleType"] = data.saleType;
    		    	if (data.saleType == 1) {
    	 		   		parm["orderItems[" + index + "].term"] = "次";
    		    	} else {
    	 		   		parm["orderItems[" + index + "].term"] = data.term;
    	 		   	}
    	   		 	parm["orderItems[" + index + "].itemCount"] = data.productOrderCount;
    	    		parm["orderItems[" + index + "].itemPrice"] = data.productOrderPrice;
    	    		parm["orderItems[" + index + "].remark"] = data.productChoosedRemark;
    	    		parm["orderItems[" + index + "].payFlag"] = data.productPayChoosed;
    	    		index++;
    	    	}
        	}
        	
        	tableData = table_view_fee.rows().data();
        	var feeCount = tableData.length;
        	for (var i = 0; i < feeCount; i++) {
        		var data = tableData[i];
        		if (data.feeChoosed == "1") {
		        	parm["orderItems[" + index + "].itemId"] = data.id;
    		    	parm["orderItems[" + index + "].itemName"] = data.name;
    		    	parm["orderItems[" + index + "].itemType"] = 3;
    		    	parm["orderItems[" + index + "].saleType"] = 1;
   	 		   		parm["orderItems[" + index + "].term"] = "次";
    	   		 	parm["orderItems[" + index + "].itemCount"] = 1;
    	    		parm["orderItems[" + index + "].itemPrice"] = data.feeOrderPrice;
    	    		parm["orderItems[" + index + "].remark"] = data.feeChoosedRemark;
    	    		parm["orderItems[" + index + "].payFlag"] = data.feePayChoosed;
    	    		index++;
    	    	}
        	}
        	
        	var res = ajaxCRUD("order!insert.do", parm, true);
        	if (res.resNum == "0") {
        		if ($("#printFlag").get(0).checked && parseFloat($("#amountProceed").val()) > 0) {
        			var uri = "<%=request.getContextPath()%>" + "/ReportServer?reportlet=invoice.cpt&invoiceId=" + res.id;
        			window.open(uri);
        		}
        		reset();
        	}
        });
        
        function reset() {
			$('#tabtable1 a:first').tab('show');        	
			resetCustomer();
        	resetAccount();
        	resetUser();
        	resetAmountDue();
        	table_view_plan.ajax.reload();
        	table_view_product.ajax.reload();
        	table_view_fee.ajax.reload();
        }
        
        $("#reset").click(function() {
        	reset();
        });
        
        </script>
        
		<jsp:include page="../pub/addressDlg.jsp" flush="true"/>
		<jsp:include page="../pub/resDeptDlg.jsp" flush="true"/>
		<jsp:include page="../pub/customerDlg.jsp" flush="true"/>
        
	</body>
</html>