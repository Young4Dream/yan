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
					<a href="#">工具</a>
				</li>
				<li class="active">
					短信
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
                            			<i class="icon-mobile-phone blue bigger-110"></i>
                            			短信发件箱
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<input type="text" id="crRecipient" style="width:200px" placeholder="手机号码"/>
                            				<select id="crStatus">
                            					<option value="">--选择状态--</option>
                            					<option value="0">草稿</option>
                            					<option value="9">已发送</option>
                            					<option value="99">发送失败</option>
                            				</select>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round pull-right" id="btnAdd">
                            					<i class="icon-file green"></i>
                            					写短信
                            				</button>
                            				<select id="crSmsTemplate" class="pull-right">
                            					<option value="">--选择模板--</option>
                            				</select>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>手机号码</th>
													<th>发送地址</th>
													<th>业务名称</th>
													<th>短信内容</th>
													<th>发送时间</th>
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
									发件人单位：
								</label>
								<div class="col-xs-9">
									<input type="text" id="departmentName" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									手机号码：
								</label>
								<div class="col-xs-9">
									<input type="text" id="recipient" class="form-control" placeholder="请输入手机号码，多个手机以分号分隔"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									业务名称：
								</label>
								<div class="col-xs-9">
									<input type="text" id="title" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									短信内容：
								</label>
								<div class="col-xs-9">
									<textarea id="content" class="form-control"></textarea>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							保存草稿
						</button>
						<button type="button" class="btn btn-sm btn-primary " id="send">
							发送
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
			loadSmsTemplate(op);
		});
		
		function loadSmsTemplate(op) {
			var res = ajaxCRUD("smsTemplate!findAll.do", { "obj.sender": op }, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--选择模板--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#crSmsTemplate").empty();
			$("#crSmsTemplate").append(html);
		}
		
        var table_view;
        var parm = { "obj.sender": op };
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sms!findByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
    			{"mDataProp": "recipient"},
    			{"mDataProp": "departmentName"},
    			{"mDataProp": "title"},
    			{"mDataProp": "content"},
    			{"mDataProp": "sendTime"},
    			{"mDataProp": "status"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                    	var funcs = [];
                    	funcs.push({"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in", "tooltip": "查看"});
                    	if (c.status == 0 || c.status == 99) {
                    		funcs.push({"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil", "tooltip": "编辑"});
	                    	funcs.push({"fn": "send('" + c.id + "')", "color": "orange", "icon": "share-alt", "tooltip": "发送"});
                    	}
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
			parm["obj.recipient"] = $("#crRecipient").val() == "" ? "" : $("#crRecipient").val();
			parm["obj.status"] = $("#crStatus").val() == "" ? "" : $("#crStatus").val();
			table_view.fnSettings().ajax.data = parm; 
			table_view.api().ajax.reload();
        });

        $("#btnAdd").click(function() { 
        	showNewDlg($("#crSmsTemplate").val());
        });
        
        function getParm() {
        	if ($("#recipient").val() == "") {
        		alert("请输入手机号码");
        		return;
        	}
        	if ($("#departmentName").val() == "") {
        		alert("请输入发送地址");
        		return;
        	}
        	if ($("#title").val() == "") {
        		alert("请输入业务名称");
        		return;
        	}
        	if ($("#content").val() == "") {
        		alert("请输入短信内容");
        		return;
        	}
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.sender": op,
    			"obj.departmentName": $("#departmentName").val(),
    			"obj.recipient": $("#recipient").val(),
    			"obj.title": $("#title").val(),
    			"obj.content": $("#content").val()
        	};
        	return parm
        }
        
        $("#save").click(function() {
        	var parm = getParm();
        	if (parm == undefined) { return; }
        	
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sms!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("sms!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
        $("#send").click(function() {
        	var parm = getParm();
        	if (parm == undefined) { return; }
        	var res = ajaxCRUD("sms!send.do", parm, true);
        	if (res.resNum == "0") {
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
        function send(id) {
        	var parm = { "id": id };
        	var res = ajaxCRUD("sms!send.do", parm, true);
        	if (res.resNum == "0") {
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
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
					    var resData = ajaxCRUD("sms!delete.do", parm, true);
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
            if (templateId == undefined || templateId == "") {
            	clear();
            } else {
            	loadFromTemplate(templateId);
            }
            $("#flag").val("add");
            $("#save").show();
            $("#send").show();
            $("#dlg").modal("show");
        }
        
        function showUpdateDlg(obj) {
            $("#dlg_title").text("修改");
        	detail(obj);
            $("#flag").val("edit");
            $("#save").show();
            $("#send").show();
            $("#dlg").modal("show");
        }
        
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#send").hide();
            $("#dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#departmentName").val(obj.departmentName);
        	$("#recipient").val(obj.recipient);
        	$("#title").val(obj.title);
        	$("#content").val(obj.content);
        }

    	function clear() {
    		$("#id").val("");
        	$("#departmentName").val("");
        	$("#recipient").val("");
        	$("#title").val("");
        	$("#content").val("");
    	}
    	
    	function loadFromTemplate(templateId) {
    		var res = ajaxCRUD("smsTemplate!findById.do", {"id": templateId}, false);
    		if (res.obj != undefined && res.obj != null) {
    			var obj = res.obj;
	    		$("#id").val("");
    	    	$("#departmentName").val(obj.departmentName);
        		$("#recipient").val(obj.recipient);
        		$("#title").val(obj.title);
        		$("#content").val(obj.content);
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
