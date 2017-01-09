<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>

	<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="dlgCustomer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						选择客户
					</h4>
				</div>
				<div class="modal-body">
                    <div class="widget-box widget-color-blue2">
                    	<div class="widget-header">
                           	<h4 class="widget-title lighter smaller">客户列表</h4>
                           	<div class="widget-toolbar">
                           		<span id="selectedCustomerNo" class="badge badge-danger">请选择客户</span>
                           	</div>
                        </div>
                        <div class="widget-body">
                           	<div class="widget-main padding-8">
                           		<form class="form-search">
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-12">
                           					<div class="input-group">
                           						<span class="input-group-addon">
                           							<i class="icon-ok"></i>
                           						</span>
                           						<input type="text" id="crCustomer" class="form-control search-query" placeholder="客户号、客户名、证件号码、联系电话" />
                           						<input type="hidden" id="selectedCustomerId" />
                           						<input type="hidden" id="selectedCustomerName" />
                           						<span class="input-group-btn">
                           							<button type="button" class="btn btn-purple btn-sm" id="btnSearchCustomer">
                           								<span class="icon-search icon-on-right bigger-110"></span>
                           								查找
                           							</button>
                           						</span>
                           					</div>
                           				</div>
                           			</div>
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-12">
                           				<table id="table_view_customer" class="table table-striped table-bordered table-hover">
                           					<thead>
                           						<tr>
                           							<th>客户号</th>
                           							<th>名称</th>
                           							<th>证件号码</th>
                           							<th>联系电话</th>
                           						</tr>
                           					</thead>
                           					<tbody></tbody>
                           				</table>
                           				</div>
                           			</div>
                           		</form>
                           	</div>
                        </div>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnGenerateCustomerNo">
						生成
					</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnChooseCustomer">
						确认
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
	<script type="text/javascript">
        var table_view_customer;
        var criteria = {
        };
		table_view_customer = $('#table_view_customer').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "customer!findByPage.do",
            	"data": criteria,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "customerNo"},
    			{"mDataProp": "name"},
            	{"mDataProp": "certId"},
    			{"mDataProp": "linkPhone"},
    		],
			 columnDefs: [
            ],
			"bLengthChange": false,//
			"iDisplayLength" :5,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		$("#btnSearchCustomer").click(function() {
			criteria = {
				"obj.fullText": $("#crCustomer").val()
	        };
			table_view_customer.fnSettings().ajax.data = criteria; 
			table_view_customer.api().ajax.reload();
		});
		
		$("#table_view_customer tbody").on("click", "tr", function(event) {
			var aData = table_view_customer.fnGetData(event.target.parentNode);
			$("#selectedCustomerNo").text(aData.customerNo);
			$("#selectedCustomerId").val(aData.id);
			$("#selectedCustomerName").val(aData.name);
		});
		
		$("#btnChooseCustomer").click(function() {
			var customerId = $("#selectedCustomerId").val();
			var customerNo = $("#selectedCustomerNo").text();
			var customerName = $("#selectedCustomerName").val();
			if ("请选择客户" == customerNo) {
				alert("请查询并选择客户");
				return;
			}
			fnBtnClickedCustomer(customerId, customerNo, customerName);
			$("#dlgCustomer").modal("hide");
		});
		
		$("#btnGenerateCustomerNo").click(function() {
			fnBtnClickedCustomer();
			$("#dlgCustomer").modal("hide");
		});
		
	</script>
	</body>
</html>
