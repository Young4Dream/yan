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
					<a href="#">流程管理</a>
				</li>
				<li class="active">
					外线工单
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
                            			<i class="icon-ambulance blue bigger-110"></i>
                            			外线工单
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crStatus">
                            				</select>
                            				<select id="crFormType">
                            				</select>
                            				<input class="" id="cbJobNo" type="text" placeholder="工单号" style="width:80px"/>
                            				<input class="" id="cbAssignee" type="text" placeholder="接单人" style="width:80px"/>
                            				<input class="" id="crFullText" type="text" placeholder="电话、账号、业务号、用户名称" style="width:240px"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnNew">
                            					<i class="icon-file green"></i>
                            					新建
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>工单号</th>
													<th>工单分类</th>
													<th>业务号</th>
													<th>用户名</th>
													<th>号码</th>
													<th>业务类型</th>
													<th>派单时间</th>
													<th>代理人</th>
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
			loadRef("ref_op_form_status", "crStatus", "--状态--");
			loadRef("ref_op_form_type", "crFormType", "--类型--");
			initTableView();
			$('#table_view tbody').on('click', 'td.details-control', openDetail);
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "jobOpForm!findByPage.do",
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
            			"data": "jobNo",
            			"width": "120px",
            		},
            		{ 
            			"data": "formTypeDesc",
            			"width": "120px",
            		},
            		{ 
            			"data": "businessKey",
            			"width": "120px",
            		},
            		{ 
            			"data": "userName",
            			"width": "*",
            		},
            		{ 
            			"data": "phoneNo",
            			"width": "100px",
            		},
            		{ 
            			"data": "businessOpName",
            			"width": "100px",
            		},
            		{ 
            			"data": "dispatchTime",
            			"width": "100px",
            		},
            		{ 
            			"data": "assignee",
            			"width": "80px",
            		},
            		{ 
            			"data": "statusDesc",
            			"width": "100",
            		},
            		{ 
            			"data": "null",
            			"width": "100",
                		"defaultContent": ''
            		},
            	],
				columnDefs: [{
                    targets: 10,
                    render: function (a, b, c, d) {
                    	var fs = [];
                    	fs.push({"fn": "print('" + c.id + "')", "color": "blue", "icon": "print", "tooltip": "打印"});
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
		
		var openDetail = (function() {
			var tr = $(this).closest('tr');
    		var row = table_view.api().row( tr );
 
    		if ( row.child.isShown() ) {
    			// This row is already open - close it
        		row.child.hide();
        		tr.removeClass('shown');
    		} else {
    			// Open this row
        		row.child(getOpFormDetail(row.data())).show();
        		tr.addClass('shown');
			}
		});
		
		function getOpFormDetail(d) {
			var content = '<table cellpadding="0" cellspacing="0" border="0" >'
						+ '</table>';
			return content;
		}
		
		function print(id) {
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
		
		$("#btnNew").click(function() {
			self.location = "jobOpForm!edit.do?";
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
