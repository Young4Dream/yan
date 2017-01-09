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
					新建票据
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
								<i class="icon-hand-right orange"></i>
								客户账单
							</h3>
							<div class="widget-toolbar no-border invoice-info">
								<span class="invoice-info-label">客户编号:</span>
								<span class="red" id="tipCustomerNo"></span>
								<br />
								<span class="invoice-info-label">客户名称:</span>
								<span class="blue" id="tipCustomerName"></span>
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
									title="确认并打印票据" 
									href="javascript:print()">
									<i class="icon-print bigger-130"></i>
								</a>
								<input type="hidden" id="customerId" />
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-toolbox" id="widget-toolbox-1">
								<div class="btn-toolbar">
									<input id="crBillNo" type="text" placeholder="账期，如201609" style="width:120px"/>
									<input id="billNo" type="hidden" />
                            		<select id="crBusinessType">
                            		</select>
                            		<input id="businessType" type="hidden" />
                            		<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            			<i class="icon-search blue"></i>
                            			查询
                            		</button>
								</div>
							</div>
							<div class="widget-main padding-24">
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
											<span class="red" id="totalAmount"></span>
										</h4>
									</div>
									<div class="col-sm-7 pull-left"> </div>
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
								<label class="col-xs-3 control-label no-padding">发票号：</label>
								<div class="col-xs-9">
									<div class="input-group">
										<div class="input-group-addon">
											<span><i class="icon-key"></i></span>
										</div>
										<input type="text" id="invoiceNo" class="form-control" placeholder="请输入票据号"/>	
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
		
		var userName = "${sessionScope.userInfo.userName}";
        var table_view;

		$(document).ready(function() {
			loadRef("ref_business_type", "crBusinessType", "--选择业务--");
		});
		
		function initTableView() {
			var parm = { 
				"obj.customerId": $("#customerId").val(),
				"obj.billNo": $("#crBillNo").val() 
			};
			if ($("#crBusinessType").val() != "") {
				parm["obj.businessType"] = $("#crBusinessType").val();
			}
			if (table_view != undefined) {
				table_view.fnSettings().ajax.data = parm; 
				table_view.api().ajax.reload();
				return;
			}
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ocsBill!findItemsByCustomer.do",
            		"data": parm,
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
		
		function print() {
			$("#dlg").modal("show");
		}
		
		var fnBtnClickedCustomer;
		function chooseCustomer() {
			fnBtnClickedCustomer = function(customerId, customerNo, customerName) {
				$("#customerId").val(customerId);
				$("#tipCustomerNo").text(customerNo);
				$("#tipCustomerName").text(customerName);
			};
			$("#btnGenerateCustomerNo").hide();
			$("#dlgCustomer").modal("show");
		}
		
		$("#btnInquiry").click(function() {
			if ($("#customerId").val() == "") {
				bbAlert("请先选择客户");
				return;
			}
			var crBillNo = $("#crBillNo").val();
			if (crBillNo == "" || crBillNo.length != 6 || isNaN(crBillNo)) {
				bbAlert("请输入正确的账期，如201609");
				return;
			}
			$("#billNo").val(crBillNo);
			$("#businessType").val($("#crBusinessType").val());
			initTableView();
		});
		
		$('#table_view').on('draw.dt', function(){
			// 计算合计金额
			var tableData = table_view.api().rows().data();
			var size = tableData.length;
			var totalAmount = 0;
			for (var i = 0; i < size; i++) {
				var data = tableData[i];
				totalAmount += data.amount - data.amountProceed;
			}
			$("#amountDue").val(totalAmount);
			$("#totalAmount").text("￥" + totalAmount);
        });
		
		$("#save").click(function() {
			if ($("#customerId").val() == "") {
				bbAlert("请选择要开票据的客户");
				return;
			}
			if ($("#invoiceNo").val() == "") {
				bbAlert("请输入票据号");
				return;
			}
			var amountProceed = parseFloat($("#amountProceed").val());
			if (isNaN(amountProceed) || amountProceed <= 0) {
				bbAlert("票据金额必须是大于零的数字");
				return;
			}
			var op = "${sessionScope.userInfo.userName}";
			alert($("#billNo").val());
			alert($("#businessType").val());
			var parm = {
				"obj.customerId": $("#customerId").val(),
				"obj.billNo": $("#billNo").val(),
				"obj.businessType": $("#businessType").val(),
				"obj.amountProceed": amountProceed,
				"obj.invoiceNo": $("#invoiceNo").val(),
				"obj.creator": op,
				"obj.printFlag": ($("#printFlag").get(0).checked ? 1 : 0)
			};
			// 保存
			var res = ajaxCRUD("ocsBill!createInvoice.do", parm, true);
        	if (res.resNum == "0") {
        		if ($("#printFlag").get(0).checked) {
					// 打印票据
        			var uri = "<%=request.getContextPath()%>" + "/ReportServer?reportlet=invoice.cpt&invoiceId=" + res.id;
        			window.open(uri);
        		}
				$("#dlgCustomer").modal("hide");
				self.location = "ocsInvoice!goToNewPage.do";
        	}
		});
		
		</script>

		<jsp:include page="../pub/customerDlg.jsp" flush="true"/>
		
	</body>
</html>
