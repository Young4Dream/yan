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
		<script src="js/nb.js"></script>
		<script src="js/pricePlanCart.js"></script>
		<script src="js/productCart.js"></script>
		<script src="js/fee.js"></script>
			
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">新业务业务受理</a>
				</li>
				<li class="active">
					业务变更
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
								<i class="icon-retweet blue"></i>
								业务变更 - 调整资费和增值服务
							</h3>
						</div>
					
						<div class="panel-body">
							<!-- <form class="form-horizontal" role="form">  -->
								<div class="tabbable" id="tabtable1">
									<ul class="nav nav-tabs">
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
										<li id="firstPage" class="active">
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
										<div class="tab-pane active" id="panel-3">
											<div class="row form-group">
					 							<label class="col-sm-1 control-label">客户号</label>
												<div class="col-sm-3">
													<input class="form-control" id="customerNo2" type="text" readonly />
												</div>
					 							<label for="acc" class="col-sm-1 control-label">业务编号</label>
												<div class="col-sm-3">
													<div class="input-group">
													<input id="userId" type="hidden"/>
													<input id="userBusinessType" type="hidden" value="A"/>
													<input class="form-control" id="businessKey" type="text" placeholder="（输入业务编号）查询"/>
													<span class="input-group-btn">
														<button class="btn btn-sm btn-default" id="btnChooseUser">
															<i class="ace-icon fa fa-calendar bigger-110"></i>
															查询
														</button>
													</span>
													</div>
												</div>
					 							<label for="userName" class="col-sm-1 control-label">用户名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="userName" type="text" placeholder="请输入个人姓名或公司名称"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="userDepartmentId" class="col-sm-1 control-label">用户部门</label>
												<div class="col-sm-3">
													<input id="userDepartmentId" type="hidden" />
													<input class="form-control" id="userDepartmentName" type="text" />
												</div>
					 							<label for="payPolicy" class="col-sm-1 control-label">付费类型</label>
												<div class="col-sm-3">
													<select class="form-control" id="payPolicy">
													</select>
												</div>
					 							<label for="userAddress" class="col-sm-1 control-label">安装地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="userAddress" type="text" placeholder="请输入安装地址"/>
												</div>
											</div>
											<div class="row form-group">
					 							<label for="userLinkPhone" class="col-sm-1 control-label">联系电话</label>
												<div class="col-sm-3">
													<input class="form-control" id="userLinkPhone" type="text" placeholder="请输入联系电话"/>
												</div>
					 							<label for="businessArea" class="col-sm-1 control-label">业务区域</label>
												<div class="col-sm-3">
													<select class="form-control" id="businessArea">
													</select>
												</div>
					 							<label for="userRemark" class="col-sm-1 control-label">备注</label>
												<div class="col-sm-3">
													<input class="form-control" id="userRemark" type="text" />
												</div>
											</div>
										</div>
										
										<!-- 资费 -->
										<div class="tab-pane" id="panel-4">
											<div class="row clearfix">
												<div class="col-md-12 column">
													<div class="row clearfix">
														<div class="col-md-4 column">
															<div class="widget-box widget-color-blue">
																<div class="widget-header">
																	<h5 class="widget-title bigger lighter">
																		<i class="icon-list bigger-110"></i>
																		可订购套餐
																	</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main no-padding">
																		<table id="table_view_plan_list" class="table table-striped table-bordered table-hover">
																			<thead>
																				<tr>
																					<th>#</th>
																					<th>套餐名称</th>
																					<th>套餐费（￥）</th>
																				</tr>
																			</thead>
																			<tbody></tbody>
																		</table>										
																	</div>
																</div>
															</div>
														</div>
														<div class="col-md-8 column">
															<div class="widget-box widget-color-blue">
																<div class="widget-header">
																	<h5 class="widget-title bigger lighter">
																		<i class="icon-shopping-cart green bigger-110"></i>
																		已订购套餐
																	</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main no-padding">
																		<table id="table_view_plan_cart" class="table table-striped table-bordered table-hover">
																			<thead>
																				<tr>
																					<th>#</th>
																					<th><i class="icon-money orange bigger-110"></i></th>
																					<th>套餐名称</th>
																					<th>生效时间</th>
																					<th>订购数量</th>
																					<th>操作</th>
																				</tr>
																			</thead>
																			<tbody></tbody>
																		</table>										
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										<!-- 增值服务 -->
										<div class="tab-pane" id="panel-5">
											<div class="row clearfix">
												<div class="col-md-12 column">
													<div class="row clearfix">
														<div class="col-md-6 column">
															<div class="widget-box widget-color-blue">
																<div class="widget-header">
																	<h5 class="widget-title bigger lighter">
																		<i class="icon-list bigger-110"></i>
																		可订购服务
																	</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main no-padding">
																		<table id="table_view_product_list" class="table table-striped table-bordered table-hover">
																			<thead>
																				<tr>
																					<th>#</th>
																					<th>产品名称</th>
																					<th>单价（￥）</th>
																				</tr>
																			</thead>
																			<tbody></tbody>
																		</table>										
																	</div>
																</div>
															</div>
														</div>
														<div class="col-md-6 column">
															<div class="widget-box widget-color-blue">
																<div class="widget-header">
																	<h5 class="widget-title bigger lighter">
																		<i class="icon-shopping-cart green bigger-110"></i>
																		已订购服务
																	</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main no-padding">
																		<table id="table_view_product_cart" class="table table-striped table-bordered table-hover">
																			<thead>
																				<tr>
																					<th>#</th>
																					<th><i class="icon-money orange bigger-110"></i></th>
																					<th>产品名称</th>
																					<th>订购数量</th>
																					<th>订购单价（￥）</th>
																					<th>备注</th>
																				</tr>
																			</thead>
																			<tbody></tbody>
																		</table>										
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
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
							<button type="button" id="save" class="btn btn-sm btn-primary">保存</button>
							<button type="button" id="reset" class="btn btn-sm btn-primary">重置</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>

		<script type="text/javascript">
		
		var parentProductId = "n"; // Used by product.js
		var businessType = "n";
		var opType = "change";
		var busiType = (businessType + "_" + opType).toLowerCase(); // Used by fee.js
		
        // 初始化页面控件
        $(document).ready(function () {
            // 初始化客户经理
            loadCustomerManager();
            // 初始化下拉框
            loadRefs();
       		// 显示产品和增值服务选择清单
       		initEditableFeeList();
       		$('#table_view_fee tbody').on('click', 'td.details-control', openFeeEditor);
       		
       		initPlanList(businessType);
       		$('#table_view_plan_list tbody').on('click', 'td.details-control', openPlanEditor);
       		initProductList();  
       		$('#table_view_product_list tbody').on('click', 'td.details-control', openProductEditor);
       		
       	});
       	
        // 选择号码
        var fnUserChoosed;
        $("#btnChooseUser").click(function() { 
        	$("#userStatus").val("2");
        	var phoneNo = $("#businessKey").val();
        	fnUserChoosed = function(userId, businessKey) {
       			$("#userId").val(userId);
       			$("#businessKey").val(businessKey);
       			loadUser(userId);
       			var customerId = $("#customerId").val();
       			loadCustomer(customerId);
       			loadAccount(customerId);
       			initPlanCart(userId);
       			$('#table_view_plan_cart tbody').on('click', 'td.details-control', openPlanCartEditor);
       			$('#table_view_plan_cart tbody').on( 'click', 'tr', onPlanRowSelected);
       			initProductCart(userId);
       			$('#table_view_product_cart tbody').on('click', 'td.details-control', openProductCartEditor);
       			$('#table_view_product_cart tbody').on( 'click', 'tr', onProductRowSelected);
        	};
        	doSearch();
        	$("#dlgUser").modal("show");
        });
        
        function validate() {
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
        		"obj.id": $("#userId").val(),
        		"obj.amountDue": $("#amountDue").val(),
        		"obj.amountProceed": $("#amountProceed").val(),
        		"obj.printFlag": ($("#printFlag").get(0).checked ? 1 : 0),
        		"obj.customerId": $("#customerId").val(),
        		"obj.opType": opType,
        		"obj.businessType": businessType,
        	};
        	
        	var index = 0;
        	
        	// 提交业务受理费
        	var tableData = table_view_fee.rows().data();
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
        	// 提交套餐变更
        	tableData = table_view_plan_cart.rows().data();
        	var planCount = tableData.length;
        	for (var i = 0; i < planCount; i++) {
        		var data = tableData[i];
        		if (data.tempStatus != undefined && data.tempStatus != null && data.tempStatus != "") {
        			parm["orderItems[" + index + "].id"] = data.orderItemId;
        			parm["orderItems[" + index + "].orderId"] = $("#userId").val();
		        	parm["orderItems[" + index + "].itemId"] = data.id;
    		    	parm["orderItems[" + index + "].itemName"] = data.name;
    		    	parm["orderItems[" + index + "].itemType"] = 1;
    		    	parm["orderItems[" + index + "].saleType"] = data.saleType;
   	 		   		parm["orderItems[" + index + "].term"] = data.term;
    	   		 	parm["orderItems[" + index + "].itemCount"] = data.planOrderCount;
    	    		parm["orderItems[" + index + "].itemPrice"] = data.planOrderPrice;
    	    		parm["orderItems[" + index + "].remark"] = data.planOrderRemark;
    	    		if (data.tempStatus == 1) {
    	    			parm["orderItems[" + index + "].status"] = 0;
    	    		} else if (data.tempStatus == 2) {
    	    			parm["orderItems[" + index + "].status"] = 4;
    	    		} else if (data.tempStatus == 4 || data.tempStatus == 5) {
    	    			parm["orderItems[" + index + "].status"] = data.tempStatus;
    	    		}
    	    		parm["orderItems[" + index + "].payFlag"] = data.planPayChoosed;
    	    		
    	    		index++;
    	    	}
        	}
        	// 提交服务变更
        	tableData = table_view_product_cart.rows().data();
        	var productCount = tableData.length;
        	for (var i = 0; i < productCount; i++) {
        		var data = tableData[i];
        		if (data.tempStatus != undefined && data.tempStatus != null && data.tempStatus != "") {
        			parm["orderItems[" + index + "].id"] = data.orderItemId;
        			parm["orderItems[" + index + "].orderId"] = $("#userId").val();
		        	parm["orderItems[" + index + "].itemId"] = data.id;
    		    	parm["orderItems[" + index + "].itemName"] = data.name;
    		    	parm["orderItems[" + index + "].itemType"] = 2;
    		    	parm["orderItems[" + index + "].saleType"] = data.saleType;
   	 		   		parm["orderItems[" + index + "].term"] = data.unit;
    	   		 	parm["orderItems[" + index + "].itemCount"] = data.productOrderCount;
    	    		parm["orderItems[" + index + "].itemPrice"] = data.productOrderPrice;
    	    		parm["orderItems[" + index + "].remark"] = data.productOrderRemark;
    	    		if (data.tempStatus == 1) {
    	    			parm["orderItems[" + index + "].status"] = 0;
    	    		} else if (data.tempStatus == 2) {
    	    			parm["orderItems[" + index + "].status"] = 4;
    	    		} else if (data.tempStatus == 4 || data.tempStatus == 5) {
    	    			parm["orderItems[" + index + "].status"] = data.tempStatus;
    	    		}
    	    		parm["orderItems[" + index + "].ossKey"] = data.ossOpenKey;
    	    		parm["orderItems[" + index + "].payFlag"] = data.productPayChoosed;
    	    		
    	    		index++;
    	    	}
        	}
        	
        	var res = ajaxCRUD("order!changeUser.do", parm, true);
        	if (res.resNum == "0") {
        		if ($("#printFlag").get(0).checked && parseFloat($("#amountProceed").val()) > 0) {
        			var uri = "<%=request.getContextPath()%>" + "/ReportServer?reportlet=invoice.cpt&invoiceId=" + res.id;
        			window.open(uri);
        		}
        		reset();
        	}
        });
        
        function reset() {
			$("#tabtable1 li:eq(2) a").tab("show");        	
			resetCustomer();
        	resetAccount();
        	resetUser();
        	resetAmountDue();
        	if (table_view_plan_cart != undefined) { table_view_plan_cart.clear(); }
        	if (table_view_product_cart != undefined) { table_view_product_cart.clear(); }
        	table_view_fee.ajax.reload();
        }
        
        $("#reset").click(function() {
        	reset();
        });
        
        </script>
        
		<!-- 按钮组的Handlebars模板 -->
		<jsp:include page="../pub/tpl.jsp" flush="true"/>

		<script type="text/javascript">
            var tpl = $("#tpl").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
			var userName = "${sessionScope.userInfo.userName}";
			// alert(userName);
        </script>
        
		<jsp:include page="../pub/userDlg.jsp" flush="true"/>
        
	</body>
</html>
		