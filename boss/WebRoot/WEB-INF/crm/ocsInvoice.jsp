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
					票据管理
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="row">
                            <!-- treeview -->
                            <div class="widget-box widget-color-blue2">
                            	<div class="widget-header">
                            		<h4 class="widget-title lighter smaller">
                            			<i class="icon-credit-card blue bigger-110"></i>
                            			票据
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crInvoiceType">
                            					<option value="">--类型--</option>
                            					<option value="发票">发票</option>
                            					<option value="收据">收据</option>
                            				</select>
                            				<select id="crStatus">
                            					<option value="">--状态--</option>
                            					<option value="0">未核销</option>
                            					<option value="1">完成</option>
                            					<option value="9">取消</option>
                            				</select>
                            				<input class="" id="crInvoiceNo" type="text" placeholder="票据号" style="width:120px"/>
                            				<input class="" id="crCustomerNo" type="text" placeholder="客户号" style="width:120px"/>
                            				<input class="" id="crFullText" type="text" placeholder="客户名、用户名、业务号" style="width:300px"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round pull-right" id="btnCreateInvoice">
                            					<i class="icon-file green"></i>
                            					新建发票
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>发票号</th>
													<th>客户号</th>
													<th>客户名</th>
													<th>联系电话</th>
													<th>金额(￥)</th>
													<th>开票人</th>
													<th>核销人</th>
													<th>开票时间</th>
													<th>状态</th>
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
		</div>

		<script type="text/javascript">
		
        var table_view;
        var criteria = {};

    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(document).ready(function() {
			initTableView();
			$('#table_view tbody').on('click', 'td.details-control', openInvoiceItem);
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ocsInvoice!findByPage.do",
            		"data": criteria,
            		"dataSrc": "lst"
            	},
        		"columns": [
            		{
                		"className":      'details-control',
                		"orderable":      false,
                		"data":           null,
                		"width": "30px",
                		"defaultContent": ''
            		},
            		{ 
            			"data": "invoiceNo",
            			"width": "120px",
            		},
            		{ 
            			"data": "customerNo",
            			"width": "120px",
            		},
            		{ 
            			"data": "customerName",
            			"width": "120px",
            		},
            		{ 
            			"data": "linkPhone",
            			"width": "*",
            		},
            		{ 
            			"data": "amount",
            			"width": "100px",
            		},
            		{ 
            			"data": "creator",
            			"width": "100px",
            		},
            		{ 
            			"data": "checker",
            			"width": "100px",
            		},
            		{ 
            			"data": "createTime",
            			"width": "100px",
            		},
            		{ 
            			"data": "status",
            			"width": "80px",
            		},
            		{ 
            			"data": "null",
            			"width": "120",
                		"defaultContent": ''
            		},
            	],
				columnDefs: [{
                    targets: 9,
                    render: function (a, b, c, d) {
                    	if (c.status == 0) {
                    		return '<span class="label label-info arrowed-in">未核销</span>';
                    	} else if (c.status == 1) {
                    		return '<span class="label label-success arrowed-in">完成</span>';
                    	} else if (c.status == 9) {
                    		return '<span class="label label-danger arrowed-in-right">取消</span>';
                    	}
                    }
                },{
                    targets: 10,
                    render: function (a, b, c, d) {
                    	var fs = [];
                    	fs.push({"fn": "print('" + c.id + "')", "color": "red", "icon": "print", "tooltip": "打印"});
                    	if (c.status == 0) {
                    		fs.push({"fn": "checkInvoice('" + c.id + "')", "color": "green", "icon": "check", "tooltip": "核销"});
                    		fs.push({"fn": "cancelInvoice('" + c.id + "')", "color": "dark", "icon": "remove", "tooltip": "取消"});
                    	}
                        var context = {func: fs};
                        var html = template(context);
                        return html;
                    }
                }],
				"bLengthChange": false,//
				"iDisplayLength" :10,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": true,//开启分页功能
				"bSort" : false,//关闭排序
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
		}
		
		var openInvoiceItem = (function() {
			var tr = $(this).closest('tr');
    		var row = table_view.api().row( tr );
 
    		if ( row.child.isShown() ) {
    			// This row is already open - close it
        		row.child.hide();
        		tr.removeClass('shown');
    		} else {
    			// Open this row
        		row.child(getInvoiceItem(row.data())).show();
        		tr.addClass('shown');
			}
		});
		
		function getInvoiceItem(d) {
			var res = ajaxCRUD("ocsInvoice!findItemsByInvoiceId.do", {"id": d.id}, false);
			var lst = res.lst;
			var content = '<table cellpadding="0" cellspacing="0" border="0" >';
			var odd = 0;
			for (var i = 0; i < lst.length; i++) {
				var row = lst[i];
				var td = '<td>' + row.billItemName + '(￥):</td>' +
						 '<td>' + row.amount + '</td><td>&nbsp;</td>';
				if (odd == 0) {
					content +=  '<tr>' + td;
				} else if (odd == 3) {
					content += td + '</tr>';
				} else {
					content += td;
				}
				odd = odd + 1;
				if (odd > 3) {
					odd = 0;
				}
			}
			if (odd == 0) {
				content += '</tr>';
			}
			content += '</table>';
			return content;
		}
		
		$("#btnInquiry").click(function() {
			criteria = {};
			if ($("#crInvoiceNo").val() != "") {
				criteria["obj.invoiceNo"] = $("#crInvoiceNo").val();
			}
			if ($("#crCustomerNo").val() != "") {
				criteria["obj.customerNo"] = $("#crCustomerNo").val();
			}
			if ($("#crFullText").val() != "") {
				criteria["obj.fullText"] = $("#crFullText").val();
			}
			if ($("#crStatus").val() != "") {
				criteria["obj.status"] = $("#crStatus").val();
			}
			if ($("#crInvoiceType").val() != "") {
				criteria["obj.invoiceType"] = $("#crInvoiceType").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
		});
		
		$("#btnCreateInvoice").click(function() {
			self.location = "ocsInvoice!goToNewPage.do";
		});
		
		function cancelInvoice(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要取消该票据吗？", 
				callback: function(result){
	   				if(result){
						var res = ajaxCRUD("ocsInvoice!cancel.do", {"id": id}, true);
						if (res.resNum == "0") {
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
		}
		
		function checkInvoice(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要核销该票据吗？", 
				callback: function(result){
	   				if(result){
						var parm = {};
						var res = ajaxCRUD("ocsInvoice!check.do", parm, true);
						if (res.resNum == "0") {
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
		}
		
		function print(id) {
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
		
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
	</body>
</html>
