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
					<a href="#">报表</a>
				</li>
				<li class="active">
					报表管理
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
                            			<i class="icon-bar-chart blue bigger-110"></i>
                            			报表列表
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<input type="text" id="crReportKey" style="width:200px" placeholder="报表标识"/>
                            				<input type="text" id="crReportName" style="width:200px" placeholder="报表名称"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round pull-right" id="btnAdd">
                            					<i class="icon-file green"></i>
                            					新建
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>报表标识</th>
													<th>报表名称</th>
													<th>报表文件</th>
													<th>创建人</th>
													<th>创建时间</th>
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
						<form class="form-horizontal" id="frm" action="report.upload" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									报表标识：
								</label>
								<div class="col-xs-10">
									<input type="text" id="reportKey" name="reportKey" class="form-control" placeholder="请输入报表标识，作为菜单键值"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									报表名称：
								</label>
								<div class="col-xs-10">
									<input type="text" id="reportName" name="reportName" class="form-control" placeholder="请输入手机名称，作为菜单显示名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									报表文件：
								</label>
								<div class="col-xs-10">
									<input type="file" id="reportFile" name="reportFile"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-10">
									<input type="text" id="remark" name="remark" class="form-control" />
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							保存
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
		});
		
        var table_view;
        var parm = { };
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "reportManager!findByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
    			{"mDataProp": "reportKey"},
    			{"mDataProp": "reportName"},
    			{"mDataProp": "fileName"},
    			{"mDataProp": "creator"},
    			{"mDataProp": "createTime"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 5,
                    render: function (a, b, c, d) {
                    	var funcs = [];
                    	funcs.push({"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in", "tooltip": "查看"});
                   		funcs.push({"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil", "tooltip": "编辑"});
                    	funcs.push({"fn": "del('" + c.id + "')", "color": "red", "icon": "trash", "tooltip": "删除"});
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
			parm["obj.reportKey"] = $("#crReportKey").val() == "" ? "" : $("#crReportKey").val();
			parm["obj.reportName"] = $("#crReportName").val() == "" ? "" : $("#crReportName").val();
			table_view.fnSettings().ajax.data = parm; 
			table_view.api().ajax.reload();
        });

        $("#btnAdd").click(function() { 
        	showNewDlg();
        });
        
        function getParm() {
        	if ($("#reportKey").val() == "") {
        		alert("请输入报表标识");
        		return;
        	}
        	if ($("#reportName").val() == "") {
        		alert("请输入报表名称");
        		return;
        	}
        	if ($("#reportFile").val() == "") {
        		alert("请选择报表文件");
        		return;
        	}
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.reportKey": $("#reportKey").val(),
    			"obj.reportName": $("#reportName").val(),
    			"obj.fileName": $("#reportFile").val(),
    			"obj.remark": $("#remark").val()
        	};
        	return parm
        }
        
        $("#save").click(function() {
        	if (!uploadFile()) return;
        	
        	var parm = getParm();
        	if (parm == undefined) { return; }
        	
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("reportManager!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("reportManager!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
        function uploadFile() {
        	var fileValue = $("#reportFile").val();
        	if(fileValue == null || fileValue == "") {
        		bbAlert("请选择报表文件");
        		return false;
        	}
        	var obj = $("#reportFile");
        	var photoExt=obj.val().substr(obj.val().lastIndexOf(".")).toLowerCase();
        	if(photoExt!=".cpt"){
        		bbAlert("不支持除*.cpt之外的文件格式");
        		return false;
        	}
        	var fileObj = $("#reportFile").get(0).files[0];
        	var FileController = "report.upload";
        	var form = new FormData();
        	form.append("reportFile", fileObj);
        	var xhr = new XMLHttpRequest(); 
        	xhr.open("post", FileController, true); 
        	xhr.send(form); 
        	return true;
        }
        
        function del(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var parm = {"id":id };
					    var resData = ajaxCRUD("reportManager!delete.do", parm, true);
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
        function showNewDlg() {
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
        	$("#reportKey").val(obj.reportKey);
        	$("#reportName").val(obj.reportName);
        	$("#remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#reportKey").val("");
        	$("#reportName").val("");
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
