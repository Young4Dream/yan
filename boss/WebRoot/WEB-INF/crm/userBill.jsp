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
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace.skins.css" />
			
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		
		<link rel="stylesheet" href="css/datatable.css">
		 
		<!-- scripts -->
		<script src="assets/js/jquery-1.10.2.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script type="text/javascript" src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript" src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		<script src="assets/js/jquery.dataTables.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">账务管理</a>
				</li>
				<li class="active">
					用户账单
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div class="col-xs-12">
				<div class="space-6"></div>
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="widget-header widget-header-large">
							<h3 class="widget-title grey lighter">
								<i class="icon-money orange"></i>
								用户账单
							</h3>
							<div class="widget-toolbar no-border invoice-info">
								<span class="invoice-info-label">账单号:</span>
								<span class="red">${billInfo.bill.billNo}</span>
								<br />
								<span class="invoice-info-label">账期日:</span>
								<span class="blue">${billInfo.endDate}</span>
							</div>
							<div class="widget-toolbar hidden-480">
								<a class="green" 
									data-toggle="tooltip" 
									data-placement="bottom" 
									title="选择客户" 
									href="javascript:chooseCustomer()">
									<i class="icon-user bigger-130"></i>
								</a> &nbsp;
								<a class="red" 
									data-toggle="tooltip" 
									data-placement="bottom" 
									title="缴费并打印票据" 
									href="javascript:print()">
									<i class="icon-print bigger-130"></i>
								</a>
								<input type="hidden" id="customerId" value="${billInfo.customer.id}"/>
								<input type="hidden" id="billId" value="${billInfo.bill.id}"/>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-24">
								<div class="row">
									<div class="col-sm-6">
										<div class="row">
											<div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right">
												<b>客户信息</b>
											</div>
										</div>
										<div>
											<ul class="list-unstyled spaced">
												<li><i class="icon-caret-right blue"></i>客户名称 : ${billInfo.customer.name}</li>
												<li><i class="icon-caret-right blue"></i>客户单位 : ${billInfo.customer.departmentName}</li>
												<li><i class="icon-caret-right blue"></i>联系人 : ${billInfo.customer.linker}</li>
												<li><i class="icon-caret-right blue"></i>联系电话 : ${billInfo.customer.linkPhone}</li>
											</ul>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="row">
											<div class="col-xs-11 label label-lg label-success arrowed-in arrowed-right">
												<b>用户信息</b>
											</div>
										</div>
										<div>
											<ul class="list-unstyled spaced">
												<li><i class="icon-caret-right green"></i>用户名称 : ${billInfo.user.name} </li>
												<li><i class="icon-caret-right green"></i>业务名称 : ${billInfo.user.businessTypeDesc} </li>
												<li><i class="icon-caret-right green"></i>号码 : ${billInfo.user.businessKey} </li>
												<li><i class="icon-caret-right green"></i>联系电话 : ${billInfo.user.linkPhone} </li>
											</ul>
										</div>
									</div>
								</div>
								<div class="space"></div>
								<div>
									<table id="table_view" class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>#</th>
												<th>项目</th>
												<th>项目金额（￥）</th>
												<th>已支付金额（￥）</th>
												<th>应付金额（￥）</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
								</div>
								<div class="hr hr8 hr-double hr-dotted"></div>
								<div class="row">
									<div class="col-sm-5 pull-right">
										<h4 class="pull-right">
											合计金额 :
											<span class="red">￥${billInfo.amount}</span>
										</h4>
									</div>
									<div class="col-sm-7 pull-left"> </div>
								</div>
								
								<div class="space-6"></div>
								<div class="row">
									<div class="col-xs-4 col-sm-3 pricing-span-header">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">还有未支付账单:</h5>
											</div>
											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table-header">
														<li>账期 </li>
														<li>业务 </li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-8 col-sm-9 pricing-span-body" id="bills">
										<!-- Put other bills here -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 模态框 -->
		<div class="modal fade" id="dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:40%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title">
							缴费
						</h4>
					</div>

					<input type="hidden" id="flag" value="">
					<input type="hidden" id="id" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">账户余额：</label>
								<div class="col-xs-9">
									<div class="input-group">
										<div class="input-group-addon">
											<span>￥</span>
										</div>
										<input type="text" id="balance" class="form-control" value="${billInfo.balance}" readonly/>	
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">积分：</label>
								<div class="col-xs-9">
									<div class="input-group">
										<div class="input-group-addon">
											<span>P</span>
										</div>
										<input type="text" id="score" class="form-control" value="${billInfo.score}" readonly/>	
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">应付金额：</label>
								<div class="col-xs-9">
									<div class="input-group">
										<div class="input-group-addon">
											<span>￥</span>
										</div>
										<input type="text" id="amountDue" class="form-control" value="${billInfo.amountDue}" readonly/>	
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">实付金额：</label>
								<div class="col-xs-9">
									<div class="input-group">
										<div class="input-group-addon">
											<span>￥</span>
										</div>
										<input type="text" id="amountProceed" class="form-control" value="0"/>	
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">是否打印：</label>
								<div class="col-xs-9">
									<label>
										<input id="printFlag" class="ace ace-switch ace-switch-7" type="checkbox" />
										<span class="lbl"></span>
									</label>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							提交
						</button>
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
							关闭
						</button>
					</div>


				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<script type="text/javascript">
		
        var table_view;

		$(document).ready(function() {
			//$("[data-toggle='tooltip']").tooltip();
			var billId = "${billInfo.bill.id}";
			if (billId != undefined && billId != null && billId != "") {
				initTableView(billId);
				var customerId = "${billInfo.customer.id}";
				showOtherBills(customerId, billId);
			}
		});
		
		function initTableView(billId) {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ocsBill!findItemsByBillId.do",
            		"data": {"id": billId},
            		"dataSrc": "lst"
            	},
            	"aoColumns": [ 
            		{"mDataProp": ""},
            		{"mDataProp": "accountItemName"},
    				{"mDataProp": "amount"},
    				{"mDataProp": "amountProceed"},
    				{"mDataProp": ""}
    			],
				columnDefs: [{
                    targets: 0,
                    render: function (a, b, c, d) {
                    	return '<i class="icon-ok-sign red bigger-110"></i>';
                    }
                },{
                    targets: 4,
                    render: function (a, b, c, d) {
                    	return c.amount - c.amountProceed;
                    }
                }],
				"bLengthChange": false,//
				"iDisplayLength" :10,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": false,//开启分页功能
				"bInfo": false,
				"bSort" : false,//关闭排序
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
		}
		
		function showOtherBills(customerId, billId) {
			var parm = {
				"obj.customerId": customerId,
				"obj.id": billId
			};
			var res = ajaxCRUD("ocsBill!findAnotherBills.do", parm, false);
			var lst = res.lst;
			var bs = [];
			for (var i = 0; i < lst.length; i++) {
				if (i >= 5) break;
				var obj = lst[i];
				var bill = { 
					"id": obj.id,
					"billNo": obj.billNo,
					"businessTypeDesc": obj.businessTypeDesc,
					"endDate": obj.endDate,
					"amountDue": obj.amountDue
				};
				bs.push(bill);
			}
			if (bs.length > 0) {
				var html = template({bills: bs});
				$("#bills").empty();
				$("#bills").append(html);
			}
		}
		
		function print() {
			$("#dlg").modal("show");
		}
		
		var fnBtnClickedCustomer;
		function chooseCustomer() {
			fnBtnClickedCustomer = function(customerId, customerNo, customerName) {
				self.location = "ocsBill!goToPayPage.do?customerId=" + customerId;
			};
			$("#btnGenerateCustomerNo").hide();
			$("#dlgCustomer").modal("show");
		}
		
		$("#save").click(function() {
			if ($("#customerId").val() == "") {
				bbAlert("请选择要缴费的客户");
				return;
			}
			var amountProceed = parseFloat($("#amountProceed").val());
			if (isNaN(amountProceed) || amountProceed <= 0) {
				bbAlert("实付金额必须是大于零的数字");
				return;
			}
			var op = "${sessionScope.userInfo.userName}";
			var parm = {
				"obj.customerId": $("#customerId").val(),
				"obj.billId": $("#billId").val(),
				"obj.amountProceed": amountProceed,
				"obj.creator": op,
				"obj.printFlag": ($("#printFlag").get(0).checked ? 1 : 0)
			};
			// 保存
			var res = ajaxCRUD("ocsBill!pay.do", parm, true);
        	if (res.resNum == "0") {
        		if ($("#printFlag").get(0).checked) {
					// 打印票据
        			var uri = "<%=request.getContextPath()%>" + "/ReportServer?reportlet=invoice.cpt&invoiceId=" + res.id;
        			window.open(uri);
        		}
				$("#dlgCustomer").modal("hide");
				self.location = "ocsBill!goToPayPage.do";
        	}
		});
		
		</script>

		<script id="tpl" type="text/x-handlebars-template">
		{{#each bills}}
		<div class="pricing-span">
			<div class="widget-box pricing-box-small widget-color-red3">
				<div class="widget-header">
					<h6 class="widget-title bigger lighter">{{this.billNo}}</h6>
				</div>
				<div class="widget-body">
					<div class="widget-main no-padding">
						<ul class="list-unstyled list-striped pricing-table">
							<li> {{this.endDate}} </li>
							<li> {{this.businessTypeDesc}} </li>
						</ul>
						<div class="price">
							<span class="label label-lg label-inverse arrowed-in arrowed-in-right">
								￥{{this.amountDue}}
							</span>
						</div>
					</div>
					<div>
						<a href="ocsBill!goToPayPage.do?id={{this.id}}" class="btn btn-block btn-sm btn-danger">
							<span>缴费</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		{{/each}}
		</script>

		<script type="text/javascript">
            var tpl = $("#tpl").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
			var userName = "${sessionScope.userInfo.userName}";
			// alert(userName);
        </script>
        
		<jsp:include page="../pub/customerDlg.jsp" flush="true"/>
	</body>
</html>
