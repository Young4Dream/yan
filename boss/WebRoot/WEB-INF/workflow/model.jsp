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
		<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css"
			type="text/css">
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">模型管理</a>
				</li>
				<li class="active">
					模型工作区
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#ne"> <i
								class="green icon-github bigger-120"></i> 模型 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add" value="创建" />
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											编号
										</th>
										<th>
											关键字
										</th>
										<th>
											名称
										</th>
										<th>
											版本
										</th>
										<th>
											创建时间
										</th>
										<th>
											最后更新时间
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
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
					<input type="hidden" id="id" name="model.id" value="">
					<div class="modal-body">
						<form id="modelForm" class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									名称：
								</label>
								<div class="col-xs-9">
									<input type="text" id="name" name="obj.name" class="form-control" placeholder="请输入流程名称"
										data-toggle="tooltip" data-placement="bottom" title="模型显示名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									关键字：
								</label>
								<div class="col-xs-9">
									<input type="text" id="key" name="obj.key" class="form-control" placeholder="请输入关键字"
										data-toggle="tooltip" data-placement="bottom" title="模型标识，用于关联业务"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">描述：</label>
								<div class="col-xs-9">
									<input type="text" id="description" name="obj.description" class="form-control"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							创建
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
		 
		<script type="text/javascript">
		
		$(document).ready(function() {
			$("[data-toggle='tooltip']").tooltip();
		});
		
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "model!findAll.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "id"},
            	{"mDataProp": "key"},
    			{"mDataProp": "name"},
    			{"mDataProp": "version"},
    			{"mDataProp": "createTime"},
    			{"mDataProp": "lastUpdateTime"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "editModel("+ c.id +")", "color": "blue", "icon": "pencil", "tooltip": "编辑模型"},
                                {"fn": "deploy("+ c.id +")", "color": "green", "icon": "move", "tooltip": "部署流程"},
                                {"fn": "exportModel("+ c.id +")", "color": "purple", "icon": "download", "tooltip": "导出模型"},
								{"fn": "del('" + c.id + "')", "color": "red", "icon": "trash", "tooltip":"删除模型"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
			"bLengthChange": false,//
			"iDisplayLength" :10,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_add").click(function() { 
        	showNewDlg();
        });
        
        $("#save").click(function() {
        	if ($("#key").val() == "") {
        		alert("请输入关键字");
        		return;
        	}
        	if ($("#name").val() == "") {
        		alert("请输入名称");
        		return;
        	}
        	var parm = {
    			"description": $("#description").val(),
    			"name": $("#name").val(),
    			"key": $("#key").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("model!create.do", parm, false);
        	} else {
        		resData = ajaxCRUD("model!update.do", parm, false);
        	}
        	if (resData.resNum == "0") {
				table_view.fnSettings().ajax.data = {}; 
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
				// open modeler
				window.open("modeler.html?modelId=" + resData.id);
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
					    var resData = ajaxCRUD("model!delete.do", parm, true);
						if(resData.resNum == "0"){
							table_view.fnSettings().ajax.data = {}; 
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        function deploy(id) {
			var parm = {"id": id };
			ajaxCRUD("model!deploy.do", parm, true);
        }
        
        function exportModel(id) {
        	window.open("modelExport!export.do?id=" + id);
        	/*
			var parm = {"id": id };
			$.ajax({
				url : "modelExport!export.do",
				data : parm,
				type : 'post',
				dataType : 'json',
				async : false // 同步false
			}); */
        }
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showNewDlg() {
            $("#dlg_title").text("创建");
            clear();
            $("#flag").val("add");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function editModel(modelId) {
			window.open("modeler.html?modelId=" + modelId);
        }
        
    	function clear() {
    		$("#description").val("");
        	$("#name").val("");
        	$("#key").val("");
    	}

		</script>

		<jsp:include page="../pub/tpl.jsp" flush="true"/>
		
		<script type="text/javascript">
            var tpl = $("#tpl").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
			var userName = "${sessionScope.userInfo.userName}";
        </script>
	</body>
</html>
