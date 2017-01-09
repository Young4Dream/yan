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
		<link rel="stylesheet" href="assets/css/datepicker/bootstrap-datetimepicker.min.css" />
		
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
		<script src="assets/js/datepicker/bootstrap-datetimepicker.min.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">账务管理</a>
				</li>
				<li class="active">
					营收流水
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
                            			营收记录
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crOpType">
                            					<option value="">--类型--</option>
                            					<option value="0">营业厅充值</option>
                            					<option value="1">自助充值</option>
                            					<option value="2">银行转账</option>
                            					<option value="3">微信充值</option>
                            					<option value="10">冲减账单</option>
                            				</select>
                            				<input class="" id="crOper" type="text" placeholder="操作员" style="width:120px"/>
                            				<input class="" id="crFullText" type="text" placeholder="客户号、客户名称" style="width:150px"/>
                            				<input id="crStartTime" type="text" class="date-timepicker" placeholder="开始时间"/>
                            				<input id="crEndTime" type="text" class="date-timepicker" placeholder="截止时间"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search green"></i>
                            					查询
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>操作员</th>
													<th>操作时间</th>
													<th>操作类型</th>
													<th>票据号</th>
													<th>客户号</th>
													<th>客户名称</th>
													<th>金额(￥)</th>
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
			$(".date-timepicker").datetimepicker();
			initTableView();
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ocsAccountLog!findByPage.do",
            		"data": criteria,
            		"dataSrc": "lst"
            	},
            	"aoColumns": [ 
            		{"mDataProp": "oper"},
    				{"mDataProp": "opTime"},
    				{"mDataProp": ""},
    				{"mDataProp": "voucherNo"},
    				{"mDataProp": "customerNo"},
    				{"mDataProp": "customerName"},
    				{"mDataProp": ""}
    			],
			 	columnDefs: [{
                    targets: 2,
                    render: function (a, b, c, d) {
                    	if (c.opType == "0") {
                    		return "营业厅充值";
                    	} else if (c.opType == "1") {
                    		return "营业厅充值";
                    	} else if (c.opType == "2") {
                    		return "银行转账";
                    	} else if (c.opType == "3") {
                    		return "微信充值";
                    	} else {
                    		return "冲减账单";
                    	}
                    }
                }, {
                    targets: 6,
                    render: function (a, b, c, d) {
                    	if (c.opType == "10") {
                    		return '<span><i class="icon-minus-sign"></i>&nbsp;' + c.amount + '</span>';
                    	} else {
                    		return '<span><i class="icon-plus-sign green"></i>&nbsp;' + c.amount + '</span>';
                    	}
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
		
		$("#btnInquiry").click(function() {
			criteria = {};
			if ($("#crOpType").val() != "") {
				criteria["obj.opType"] = $("#crOpType").val();
			}
			if ($("#crFullText").val() != "") {
				criteria["obj.fullText"] = $("#crFullText").val();
			}
			if ($("#crOper").val() != "") {
				criteria["obj.oper"] = $("#crOper").val();
			}
			if ($("#crStartTime").val() != "") {
				criteria["obj.startTime"] = $("#crStartTime").val();
			}
			if ($("#crEndTime").val() != "") {
				criteria["obj.endTime"] = $("#crEndTime").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
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
	</body>
</html>
