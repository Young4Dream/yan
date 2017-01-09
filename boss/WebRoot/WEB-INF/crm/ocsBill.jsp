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
					实时账单
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
                            			<i class="icon-film blue bigger-110"></i>
                            			实时账单
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crStatus">
                            					<option value="">--账单状态--</option>
                            					<option value="0">累账</option>
                            					<option value="2">发布</option>
                            					<option value="9">完成</option>
                            					<option value="91">坏账</option>
                            				</select>
                            				<select id="crBusinessType">
                            				</select>
                            				<input class="" id="crBillNo" type="text" placeholder="账期" style="width:120px"/>
                            				<input class="" id="crFullText" type="text" placeholder="电话、账号、业务号、客户名称、用户名称" style="width:300px"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search green"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnRelease" 
                            					data-toggle="tooltip" data-placement="bottom" title="发布账期下的所有正在累账的账单" >
                            					<i class="icon-bullhorn blue"></i>
                            					发布
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th >账单号</th>
													<th >业务号</th>
													<th >业务类别</th>
													<th >用户名</th>
													<th>账户余额(￥)</th>
													<th>应收款(￥)</th>
													<th>实收款(￥)</th>
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
			loadRef("ref_business_type", "crBusinessType", "--业务类型--");
			initTableView();
			$('#table_view tbody').on('click', 'td.details-control', openBillItem);
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ocsBill!findByPage.do",
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
            			"data": "billNo",
            			"width": "120px",
            		},
            		{ 
            			"data": "businessKey",
            			"width": "120px",
            		},
            		{ 
            			"data": "businessType",
            			"width": "120px",
            		},
            		{ 
            			"data": "userName",
            			"width": "*",
            		},
            		{ 
            			"data": "balance",
            			"width": "100px",
            		},
            		{ 
            			"data": "amountDue",
            			"width": "100px",
            		},
            		{ 
            			"data": "amountProceed",
            			"width": "100px",
            		},
            		{ 
            			"data": "status",
            			"width": "80px",
            		},
            		{ 
            			"data": "null",
            			"width": "100",
                		"defaultContent": ''
            		},
            	],
				columnDefs: [{
                    targets: 8,
                    render: function (a, b, c, d) {
                    	if (c.status == 0) {
                    		return '<span class="label label-info arrowed-in">累账</span>';
                    	} else if (c.status == 1) {
                    		return '<span class="label label-info arrowed-in">核账</span>';
                    	} else if (c.status == 2) {
                    		return '<span class="label label-inverse arrowed">执行</span>';
                    	} else if (c.status == 9) {
                    		return '<span class="label label-success arrowed-in-right">完成</span>';
                    	} else {
                    		return '<span class="label label-warning">呆坏账</span>';
                    	}
                    }
                },{
                    targets: 9,
                    render: function (a, b, c, d) {
                    	var fs = [];
                    	if (c.status < 2) {
                    		fs.push({"fn": "releaseBill('" + c.id + "')", "color": "dark", "icon": "bullhorn", "tooltip": "发布账单"});
                    	} else if (c.status == 2) {
                    		fs.push({"fn": "payBill('" + c.id + "','" + c.userId + "')", "color": "green", "icon": "money", "tooltip": "缴费"});
                    		fs.push({"fn": "badBill('" + c.id + "')", "color": "red", "icon": "h-sign", "tooltip": "标注为坏账"});
                    	} else if (c.status == 91) {
                    		fs.push({"fn": "normalBill('" + c.id + "')", "color": "green", "icon": "reply", "tooltip": "转为正常账单"});
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
		
		var openBillItem = (function() {
			var tr = $(this).closest('tr');
    		var row = table_view.api().row( tr );
 
    		if ( row.child.isShown() ) {
    			// This row is already open - close it
        		row.child.hide();
        		tr.removeClass('shown');
    		} else {
    			// Open this row
        		row.child(getBillItem(row.data())).show();
        		tr.addClass('shown');
			}
		});
		
		function getBillItem(d) {
			var res = ajaxCRUD("ocsBill!findItemsByBillId.do", {"id": d.id}, false);
			var lst = res.lst;
			var content = '<table cellpadding="0" cellspacing="0" border="0" >';
			var odd = 0;
			for (var i = 0; i < lst.length; i++) {
				var row = lst[i];
				var td = '<td>' + row.accountItemName + '(￥):</td>' +
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
		
		function releaseBill(id) {
			var res = ajaxCRUD("ocsBill!releaseBill.do", {"id": id}, true);
			if (res.resNum == "0") {
				table_view.api().ajax.reload();
			}
		}
		
		function badBill(id) {
			var res = ajaxCRUD("ocsBill!badBill.do", {"id": id}, true);
			if (res.resNum == "0") {
				table_view.api().ajax.reload();
			}
		}
		
		function normalBill(id) {
			var res = ajaxCRUD("ocsBill!normalBill.do", {"id": id}, true);
			if (res.resNum == "0") {
				table_view.api().ajax.reload();
			}
		}
		
		function payBill(id, userId) {
			self.location = "ocsBill!goToPayPage.do?id=" + id;
		}
		
		$("#btnInquiry").click(function() {
			criteria = {};
			if ($("#crBillNo").val() != "") {
				criteria["obj.billNo"] = $("#crBillNo").val();
			}
			if ($("#crFullText").val() != "") {
				criteria["obj.fullText"] = $("#crFullText").val();
			}
			if ($("#crStatus").val() != "") {
				criteria["obj.status"] = $("#crStatus").val();
			}
			if ($("#crBusinessType").val() != "") {
				criteria["obj.businessType"] = $("#crBusinessType").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
		});
		
		$("#btnRelease").click(function() {
			criteria = {};
			if ($("#crBillNo").val() != "") {
				criteria["obj.billNo"] = $("#crBillNo").val();
			} else {
				bbAlert("请输入账期");
				return;
			}
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要发布所有符合条件的账单吗？", 
				callback: function(result){
	   				if(result){
						var res = ajaxCRUD("ocsBill!releaseBills.do", criteria, true);
						if (res.resNum == "0") {
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
		});
		
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
