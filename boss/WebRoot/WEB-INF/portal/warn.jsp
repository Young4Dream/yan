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
					<a href="#">系统</a>
				</li>
				<li class="active">
					告警管理
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
                            			<i class="icon-bell red bigger-110"></i>
                            			系统告警
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crWarnModule">
                            					<option value="">--模块--</option>
                            					<option value="话单分拣">话单分拣</option>
                            					<option value="自动控制">自动控制</option>
                            					<option value="PORTAL">WEB</option>
                            				</select>
                            				<select id="crWarnLevel">
                            					<option value="">--级别--</option>
                            					<option value="INFO">提醒</option>
                            					<option value="WARN">预警</option>
                            					<option value="ERROR">告警</option>
                            				</select>
                            				<select id="crStatus">
                            					<option value="">--状态--</option>
                            					<option value="0">未接收</option>
                            					<option value="1">未处理</option>
                            					<option value="2">关闭</option>
                            				</select>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>模块</th>
													<th>信息</th>
													<th>告警时间</th>
													<th>处理人</th>
													<th>处理时间</th>
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
        var op = "${sessionScope.userInfo.userName}";

    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(document).ready(function() {
			initTableView();
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "warn!findByPage.do",
            		"data": criteria,
            		"dataSrc": "lst"
            	},
        		"columns": [
            		{
                		"data": "null",
                		"width": "30px",
                		"defaultContent": ''
            		},
            		{ 
            			"data": "warnModule",
            			"width": "100px",
            		},
            		{ 
            			"data": "warnMsg",
            			"width": "250px",
            		},
            		{ 
            			"data": "warnTime",
            			"width": "200px",
            		},
            		{ 
            			"data": "handler",
            			"width": "100px",
            		},
            		{ 
            			"data": "handleTime",
            			"width": "200px",
            		},
            		{ 
            			"data": "null",
            			"width": "100px",
                		"defaultContent": ''
            		},
            		{ 
            			"data": "null",
            			"width": "*",
                		"defaultContent": ''
            		},
            	],
				columnDefs: [{
                    targets: 0,
                    render: function (a, b, c, d) {
                    	if (c.warnLevel == "INFO") {
                    		return '<span><i class="icon-info-sign blue"></i></span>';
                    	} else if (c.warnLevel == "WARN") {
                    		return '<span><i class="icon-warning-sign orange"></i></span>';
                    	} else {
                    		return '<span><i class="icon-bolt red"></i></span>';
                    	}
                    }
                },{
                    targets: 6,
                    render: function (a, b, c, d) {
                    	if (c.status == "0") {
                    		return "未读";
                    	} else if (c.status == "1") {
                    		return "未处理";
                    	} else {
                    		return "关闭";
                    	}
                    }
                },{
                    targets: 7,
                    render: function (a, b, c, d) {
                    	var fs = [];
                    	if (c.status == "0") {
                    		fs.push({"fn": "read('" + c.id + "')", "color": "blue", "icon": "eye-open", "tooltip": "标记为已读"});
                    		fs.push({"fn": "handle('" + c.id + "')", "color": "green", "icon": "wrench", "tooltip": "标记为已处理"});
                    	} else if (c.status == "1") {
                    		fs.push({"fn": "handle('" + c.id + "')", "color": "green", "icon": "wrench", "tooltip": "标记为已处理"});
                    	}
                    	if (fs.length > 0) {
                    		return template({func: fs});
                    	} else {
                    		return "";
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
			if ($("#crWarnLevel").val() != "") {
				criteria["obj.warnLevel"] = $("#crWarnLevel").val();
			}
			if ($("#crStatus").val() != "") {
				criteria["obj.status"] = $("#crStatus").val();
			}
			if ($("#crWarnModule").val() != "") {
				criteria["obj.warnModule"] = $("#crWarnModule").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
		});
		
		function handle(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要关闭该告警吗？", 
				callback: function(result){
	   				if(result){
			        	var parm = {
        					"obj.id": id,
			        		"obj.status": 2,
			        		"obj.handler": op
        				};
					    var resData = ajaxCRUD("warn!update.do", parm, true);
						if(resData.resNum == "0"){
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
		}
		
        function read(id) {
        	var parm = {
        		"obj.id": id,
        		"obj.status": 1
        	};
        	var res = ajaxCRUD("warn!update.do", parm, false);
        	if (res.resNum == "0") {
        		table_view.api().ajax.reload();
        	} else {
        		bbAlert(res.res);
        	}
        }
        
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
