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
		<link rel="stylesheet" href="assets/css/main.css" />
		
		<!-- scripts -->
		<script src="assets/js/jquery-1.10.2.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		<script src="assets/js/jquery.dataTables.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">系统管理</a>
				</li>
				<li class="active">
					用户管理
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
                            <div class="widget-box widget-color-blue2">
                            	<div class="widget-header">
                            		<h4 class="widget-title lighter smaller">
                            			<i class="icon-user blue bigger-110"></i>
                            			用户列表
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<input type="text" id="crUserName" style="width:200px" placeholder="登录名"/>
                            				<input type="text" id="crUserAlias" style="width:200px" placeholder="用户姓名"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round pull-right" id="btnAdd">
                            					<i class="icon-file green"></i>
                            					添加
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>登录名</th>
													<th>姓名</th>
													<th>部门</th>
													<th>权限组</th>
													<th>创建时间</th>
													<th>备注</th>
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

		<!-- 模态框（emplModal） -->
		<div class="modal fade" id="dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:50%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title">
						</h4>
					</div>

					<input type="hidden" id="flag" value="">
					<input type="hidden" id="id" name="cdrSource.id" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									登录名：
								</label>
								<div class="col-xs-9">
									<input type="text" id="userName" class="form-control" placeholder="请输入登录名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									密码：
								</label>
								<div class="col-xs-9">
									<input type="password" id="password" class="form-control" placeholder="请输入密码"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									用户姓名：
								</label>
								<div class="col-xs-9">
									<input type="text" id="userAlias" class="form-control" placeholder="请输入用户真实姓名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									部门：
								</label>
								<div class="col-xs-9">
									<select id="deptId" class="form-control">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									权限组：
								</label>
								<div class="col-xs-9">
									<select id="roleId" class="form-control">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-9">
									<input type="text" id="remark" class="form-control"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							确定
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
		
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		var op = "${sessionScope.userInfo.userName}";
		
		$(document).ready(function() {
			$("[data-toggle='tooltip']").tooltip();
			loadRole();
			loadDept();
		});
		
		function loadRole() {
			var res = ajaxCRUD("role!allRole.do", { }, false);
			var lst = res.aaData;
			var html = "<option role='option' value=''>--选择权限--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.roleid + "'>" + item.rolename + "</option>";
			});
			$("#roleId").empty();
			$("#roleId").append(html);
		}
		
		function loadDept() {
			var res = ajaxCRUD("dept!findAll.do", { }, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--选择部门--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.deptname + "</option>";
			});
			$("#deptId").empty();
			$("#deptId").append(html);
		}
		
        var table_view;
        var parm = { };
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "user!findByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
    			{"mDataProp": "userName"},
    			{"mDataProp": "userAlias"},
    			{"mDataProp": "deptName"},
    			{"mDataProp": "roleName"},
    			{"mDataProp": "createTime"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                    	var funcs = [];
                    	funcs.push({"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in", "tooltip": "查看"});
                    	if (c.userName != "admin") {
                    		funcs.push({"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil", "tooltip": "编辑"});
	                    	funcs.push({"fn": "del('" + c.id + "')", "color": "red", "icon": "trash", "tooltip": "删除"});
                    	}
                        return template({ func: funcs });
                    }
                }

            ],
			"bLengthChange": false,//
			"iDisplayLength" :10,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
        $("#btnInquiry").click(function() { 
			parm["obj.userName"] = $("#crUserName").val() == "" ? "" : $("#crUserName").val();
			parm["obj.userAlias"] = $("#crUserAlias").val() == "" ? "" : $("#crUserAlias").val();
			table_view.fnSettings().ajax.data = parm; 
			table_view.api().ajax.reload();
        });

        $("#btnAdd").click(function() { 
        	showNewDlg();
        });
        
        function getParm() {
        	if ($("#userName").val() == "") {
        		alert("请输入登录名");
        		return;
        	}
        	if ($("#userAlias").val() == "") {
        		alert("请输入用户姓名");
        		return;
        	}
        	if ($("#password").val() == "") {
        		alert("请输入密码");
        		return;
        	}
        	if ($("#deptId").val() == "") {
        		alert("请选择所在部门");
        		return;
        	}
        	if ($("#roleId").val() == "") {
        		alert("请选择权限");
        		return;
        	}
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.userName": $("#userName").val(),
    			"obj.userAlias": $("#userAlias").val(),
    			"obj.password": $("#password").val(),
    			"obj.deptId": $("#deptId").val(),
    			"obj.roleId": $("#roleId").val(),
    			"obj.remark": $("#remark").val(),
    			"obj.status": "0"
        	};
        	return parm
        }
        
        $("#save").click(function() {
        	var parm = getParm();
        	if (parm == undefined) { return; }
        	
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("user!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("user!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
        function del(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var parm = {"id":id };
					    var resData = ajaxCRUD("user!delete.do", parm, true);
						if(resData.resNum == "0"){
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showNewDlg(templateId) {
            $("#dlg_title").text("添加");
           	clear();
            $("#flag").val("add");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showUpdateDlg(obj) {
            $("#dlg_title").text("修改");
        	detail(obj);
            $("#flag").val("edit");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#userName").val(obj.userName);
        	$("#userAlias").val(obj.userAlias);
        	$("#password").val(obj.password);
        	$("#deptId").val(obj.deptId);
        	$("#roleId").val(obj.roleId);
        	$("#remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#userName").val("");
        	$("#userAlias").val("");
        	$("#password").val("");
        	$("#deptId").val("");
        	$("#roleId").val("");
        	$("#remark").val("");
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
