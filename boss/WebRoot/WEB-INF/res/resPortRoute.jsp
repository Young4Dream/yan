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
			
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资源管理</a>
				</li>
				<li class="active">
					端口路由
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="panel panel-default">
						<div class="panel-body">
							<!-- 用户查询面板 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 widget-container-col">
									<div class="widget-box widget-color-dark">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">
												<i class="icon-user blue bigger-110"></i>
												用户信息
											</h5>
										</div>
									</div>
									<div class="widget-body">
										<div class="widget-main padding-8">
											<div class="row form-group">
												<label for="userKey" class="col-sm-1 control-label">业务标识</label>
												<div class="col-sm-3">
													<div class="input-group">
														<input id="userKey" type="hidden"/>
														<input id="userId" type="hidden"/>
														<input class="form-control" id="crKey" type="text" placeholder="电话号码、上网账号"/>
														<span class="input-group-btn">
															<button class="btn btn-sm btn-default" id="btnChooseUser">
																<i class="icon-search bigger-110"></i>
																查询
															</button>
														</span>
													</div>
												</div>
					 							<label for="deviceCode" class="col-sm-1 control-label">设备</label>
												<div class="col-sm-3">
													<input class="form-control" id="deviceCode" type="text" readonly/>
												</div>
					 							<label for="userName" class="col-sm-1 control-label">用户名称</label>
												<div class="col-sm-3">
													<input class="form-control" id="userName" type="text" readonly/>
												</div>
											</div>
											<div class="row form-group">
					 							<label class="col-sm-1 control-label">业务类型</label>
												<div class="col-sm-3">
													<input id="businessType" type="hidden"/>
													<select id="businessTypeDesc" class="form-control" >
														<option role="option" value="p">电话</option>
														<option role="option" value="b">宽带</option>
														<option role="option" value="a">ADSL</option>
														<option role="option" value="l">专线</option>
														<option role="option" value="n">新业务</option>
													</select>
												</div>
					 							<label for="userLinkPhone" class="col-sm-1 control-label">联系电话</label>
												<div class="col-sm-3">
													<input class="form-control" id="userLinkPhone" type="text" readonly/>
												</div>
					 							<label for="userAddress" class="col-sm-1 control-label">安装地址</label>
												<div class="col-sm-3">
													<input class="form-control" id="userAddress" type="text" readonly/>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<!-- 端口路由表 -->
								<div class="col-xs-12 col-sm-4 widget-container-col">
									<div class="widget-box widget-color-dark">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">
												<i class="icon-road purple bigger-110"></i>
												端口路由
											</h5>
											<div class="widget-toolbar">
												<span class="badge badge-danger" id="removedPortName">未选择端口</span>
												<input type="hidden" id="removedPortId"/>
											</div>
										</div>
									</div>
									<div class="widget-body">
										<div class="widget-toolbox">
											<div class="btn-toolbar">
												<button class="btn btn-sm btn-success btn-white btn-round" id="btnRemovePort">
													<i class="icon-cut red bigger-110"></i>
													删除端口
												</button>
												<!-- 
												<button class="btn btn-sm btn-success btn-white btn-round">
													<i class="icon-chevron-down blue bigger-110"></i>
													上移
												</button>
												<button class="btn btn-sm btn-success btn-white btn-round">
													<i class="icon-chevron-up blue bigger-110"></i>
													下移
												</button>
												 -->
											</div>
										</div>
										<div class="widget-main padding-8">
											<table id="table_view_route" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>序号</th>
														<th>设备号</th>
														<th>设备名称</th>
														<th>端口号</th>
													</tr>
												</thead>
												<tbody></tbody>
											</table>										
										</div>
									</div>
								</div>
								<!-- 可用端口表 -->
								<div class="col-xs-12 col-sm-8 widget-container-col">
									<div class="widget-box widget-color-dark">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">
												<i class="icon-link green bigger-110"></i>
												新增端口
											</h5>
											<div class="widget-toolbar">
												<span class="badge badge-danger" id="newPortName">未选择端口</span>
												<input type="hidden" id="newPortId"/>
											</div>
										</div>
									</div>
									<div class="widget-body">
										<div class="widget-toolbox">
											<div class="btn-toolbar">
												<input class="" id="crDeviceCode" type="text" placeholder="设备号" style="width:120px"/>
												<input class="" id="crPortCode" type="text" placeholder="端口号" style="width:120px"/>
												<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiryPort">
													<i class="icon-search purple bigger-110"></i>
													查询端口
												</button>
												<button class="btn btn-sm btn-success btn-white btn-round" id="btnAddPort">
													<i class="icon-link green bigger-110"></i>
													添加端口
												</button>
											</div>
										</div>
										<div class="widget-main padding-8">
											<table id="table_view_port" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>设备号</th>
														<th>设备名称</th>
														<th>端口号</th>
														<th>已有业务</th>
														<th>业务号</th>
													</tr>
												</thead>
												<tbody></tbody>
											</table>										
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 
						<div class="panel-footer">
							<button type="button" id="save" class="btn btn-sm btn-primary">保存</button>
							<button type="button" id="reset" class="btn btn-sm btn-primary">重置</button>
						</div>
						 -->
					</div>
				</div>
			</div>
			
		</div>

		<script type="text/javascript">
		
		var businessType = "";
		
		var table_view_route;
        var criteria = {};
		table_view_route = $('#table_view_route').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "resPortRoute!findByUserId.do",
            	"data": criteria,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
				{"mDataProp": "portIndex"},
            	{"mDataProp": "deviceCode"},
    			{"mDataProp": "deviceName"},
    			{"mDataProp": "portCode"}
    		],
			"bLengthChange": false,//
			"iDisplayLength" :10,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"bInfo": false,
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		var table_view_port;
        var criteriaPort = {};
		table_view_port = $('#table_view_port').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "resDevicePort!findUsable.do",
            	"data": criteriaPort,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "deviceCode"},
    			{"mDataProp": "deviceName"},
    			{"mDataProp": "portCode"},
    			{"mDataProp": "bearingDesc"},
    			{"mDataProp": "businessKey"}
    		],
			"bLengthChange": false,//
			"iDisplayLength" :6,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
        // 初始化页面控件
        $(document).ready(function () {
        	var userId = "${portRouteUserId}";
        	if (userId != undefined && userId != "") {
        		fnUserChoosed(userId);
        	}
       	});
       	
        // 装载用户信息和端口路由
        var fnUserChoosed = function(userId){
       		$("#userId").val(userId);
       		var parm = { "id": userId };
			var res = ajaxCRUD("crmUser!findFullInfoById.do", parm, false);
			var user = res.userFullInfo;
       		$("#userKey").val(user.businessKey);
       		$("#crKey").val(user.businessKey);
			$("#userName").val(user.name);
			$("#deviceCode").val(user.deviceCode);
			$("#userAddress").val(user.address);    
			$("#userLinkPhone").val(user.linkPhone);
			$("#businessType").val(user.businessType.toLowerCase());  
			$("#businessTypeDesc").val(user.businessType.toLowerCase());  
			 
			criteria = {"id": userId};
			table_view_route.fnSettings().ajax.data = criteria; 
			table_view_route.api().ajax.reload();
        };
        
        $("#btnChooseUser").click(function() { 
        	$("#crUser").val($("#crKey").val());
        	doSearch();
        	$("#dlgUser").modal("show");
        });
        
        $("#btnInquiryPort").click(function() {
        	if ($("#userId").val() == "") {
        		bbAlert("请查询用户");
        		return;
        	}
        	criteriaPort = {
        		"obj.deviceCode": $("#crDeviceCode").val(),
        		"obj.portCode": $("#crPortCode").val(),
        		"obj.bearing": $("#businessType").val()
        	};
			table_view_port.fnSettings().ajax.data = criteriaPort; 
			table_view_port.api().ajax.reload();
        });
        
		$("#table_view_port tbody").on("click", "tr", function(event) {
			var aData = table_view_port.fnGetData(event.target.parentNode);
			$("#newPortId").val(aData.id);
			$("#newPortName").text(aData.deviceCode + ":" + aData.portCode);
		});
		
		$("#btnAddPort").click(function() {
			if ($("#userId").val() == "") {
        		bbAlert("请先查询要进行配置端口路由的用户");
        		return;
			}
			if ($("#newPortId").val() == "") {
        		bbAlert("请先查询可用的设备端口并选择端口");
        		return;
			}
			var infos = $("#newPortName").text().split(":");
			var op = "${sessionScope.userInfo.userName}";
			var parm = {
				"obj.userId": $("#userId").val(),
				"obj.userKey": $("#userKey").val(),
				"obj.businessType": $("#businessType").val(),
				"obj.deviceCode": infos[0],
				"obj.portCode": infos[1],
				"obj.creator": op
			};
			var res = ajaxCRUD("resPortRoute!insert.do", parm, true);
			if (res.resNum == "0") {
				table_view_route.api().ajax.reload();
			}
		});
		
		$("#table_view_route tbody").on("click", "tr", function(event) {
			var aData = table_view_route.fnGetData(event.target.parentNode);
			$("#removedPortId").val(aData.id);
			$("#removedPortName").text(aData.deviceCode + ":" + aData.portCode);
		});
		
		$("#btnRemovePort").click(function() {
			if ($("#userId").val() == "") {
        		bbAlert("请先查询要进行配置端口路由的用户");
        		return;
			}
			if ($("#removedPortId").val() == "") {
        		bbAlert("请选择要从端口路由中去除的端口");
        		return;
			}
			var parm = { "id": $("#removedPortId").val() };
			var res = ajaxCRUD("resPortRoute!delete.do", parm, true);
			if (res.resNum == "0") {
				table_view_route.api().ajax.reload();
			}
		});
		
        </script>
        
		<jsp:include page="../pub/userDlg.jsp" flush="true"/>
        
	</body>
</html>
		