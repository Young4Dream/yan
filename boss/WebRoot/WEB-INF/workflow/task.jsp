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
		<!-- BootstrapDialog -->
		<link rel="stylesheet" href="assets/css/bootstrap-dialog.min.css" />
		
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		
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
		<script src="assets/js/bootstrap-dialog.min.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon green"></i>
					<a href="#">流程管理</a>
				</li>
				<li class="active">
					待办事项
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
								class="green icon-legal bigger-120"></i> 代办事项 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											任务名称
										</th>
										<th>
											业务流程
										</th>
										<th>
											客户名
										</th>
										<th>
											用户标识
										</th>
										<th>
											发起人
										</th>
										<th>
											发起时间
										</th>
										<th>
											任务流转时间
										</th>
										<th>
											任务到期时间
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

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="dlgDiagram" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:90%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title">
							流程图
						</h4>
					</div>

					<div class="modal-body">
						<img id="diagram" ></img>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
							关闭
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="dlgDispatch" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:50%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title">
							任务派发
						</h4>
					</div>

					<div class="modal-body">
						<img id="diagram" ></img>
					</div>
					<div class="modal-footer">
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
		$(function() {
			$("[data-toggle='tooltip']").tooltip();
		});
		
        var table_view;
        var op = "${sessionScope.userInfo.userName}";
        var parm = {"id": op};
        var subProcess = "";
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "task!findByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "businessOpName"},
    			{"mDataProp": "customerName"},
    			{"mDataProp": "userKey"},
    			{"mDataProp": "originator"},
    			{"mDataProp": "originateTime"},
    			{"mDataProp": "createTime"},
    			{"mDataProp": "dueDate"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 8,
                    render: function (a, b, c, d) {
                    	var func = [];
                    	func.push({"fn": "viewDiagram(" + c.processInstanceId + ")", "color": "dark", "icon": "sitemap", "tooltip": "查看流程图"});
                        if (c.userId != undefined && c.userId != "") {
                        	func.push({"fn": "viewUserInfo(" + JSON.stringify(c) + ")", "color": "blue", "icon": "user-md", "tooltip": "查看用户信息"});
                    	}
                        if (c.assignee == undefined || c.assignee == "") {
                        	func.push({"fn": "claim('" + c.id + "')", "color": "red", "icon": "download-alt", "tooltip": "签收任务"});
                        } else {
                        	if (c.formKey != undefined && c.formKey != null && c.formKey != "") {
                        		var infos = c.formKey.split(",");
                        		for (var i = 0; i < infos.length; i++) {
                        			if (infos[i] == "route") {
                        				func.push({"fn": "goToPortRoute('" + c.userId + "')", "color": "purple", "icon": "road", "tooltip": "配线"});
                        			} else if (infos[i] == "delete") {
                        				func.push({"fn": "deleteUserImmediately('" + c.userId + "')", "color": "red", "icon": "cut", "tooltip": "删除用户信息"});
                        			} else if (infos[i] == "opform") {
                        				func.push({"fn": "newOpForm('" + c.businessKey + "')", "color": "orange", "icon": "ambulance", "tooltip": "派工单"});
                        			} else if (infos[i] == "opform-feedback") {
                        				func.push({"fn": "feedback('" + c.businessKey + "')", "color": "orange", "icon": "ambulance", "tooltip": "派工单"});
                        			}
                        		}
                        	}
                        	func.push({"fn": "handle('" + c.id + "')", "color": "green", "icon": "share-alt", "tooltip": "提交任务"});
                        }
                        var context =
                        {
                            "func": func 
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
		
		// 签收任务
        function claim(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要签收该任务吗？ 签收之后其他人再不能看到该任务。", 
				callback: function(result){
	   				if(result){
	   					var op = "${sessionScope.userInfo.userName}";
						var parm = {"obj.taskId":id, "obj.userId": op };
					    var resData = ajaxCRUD("task!claim.do", parm, true);
						if(resData.resNum == "0"){
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        // 查看流程图
        function viewDiagram(processInstanceId) {
        	$("#diagram").attr("src", "piDiagram!readDiagram.do?id=" + processInstanceId);
        	$("#dlgDiagram").modal("show");
        }
        
		// 查看用户信息
		function viewUserInfo(obj) {
			loadCustomerInfo(obj.customerId);
			loadAccountInfo(obj.customerId);
			loadUserInfo(obj.userId);
			loadOrderInfo(obj);
			$("#dlgUserInfo").modal("show");
		}
		
		// 生成派工单
		function newOpForm(instanceId) {
			loadJobOpForm(instanceId);
			$("#dlgJobOpForm").modal("show");
		}
		
		// 配线
		function goToPortRoute(userId) {
			self.location = "resPortRoute!goToPage.do?id=" + userId;
		}
		
		// 立即删除用户
		function deleteUserImmediately(userId) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要用户信息吗？注：客户信息将被保留。", 
				callback: function(result){
	   				if(result){
						var parm = {"id": userId };
					    ajaxCRUD("order!deleteUserImmediately.do", parm, true);
	            	}
	            }
	    	});
		}
		
		// 任务办理
        function handle(id) {
			BootstrapDialog.show({
				title: "任务办理",
				//size: BootstrapDialog.SIZE_LARGE,
				message: function(dialog) {
					var content = 
						'<input type="hidden" id="taskId" value="' + id + '"/>' +
						'<div class="tab-content">' +
							'<div class="row clearfix">' +
								'<div class="col-md-12 column">' +
									'<form class="form-horizontal" role="form">';
					var res = ajaxCRUD("task!findTaskFormProperties.do", { "id": id }, false);
					var lst = res.lst;
					var formContent = "";
					$(lst).each(function(index) {
						var property = lst[index];
						if (!property.isReadable) {
							return;
						}
						var propertyValue = (property.value == undefined || property.value == "undefined" ? "" : property.value); 
						var readonlyFlag = (property.isWritable ? "" : ' disabled="disabled" ');
						formContent += 
										'<div class="form-group">' +
											'<label class="col-sm-3 control-label">' + property.name + '</label>' +
											'<div class="col-sm-9">';
						if (property.type.name == "boolean") {
							formContent += 
												'<select class="form-control process-variable" id="' + property.id + '"' + readonlyFlag + '> '+
													'<option value="true">同意</option>' +
													'<option value="false">不同意</option>' +
												'</select>';
						} else if (property.type.name == "enum") {
							formContent +=
												'<select class="form-control process-variable" id="' + property.id + '"' + readonlyFlag + '>' ;
							var information = property.information;
							for (var prop in information) {
								var infos = information[prop].split(" ");
								formContent +=
													'<option value="' + infos[1] + '">' + infos[0] + '</option>';
							}
							formContent +=
												'</select>';
						} else {
							formContent +=
												'<input class="form-control process-variable" id="' + property.id + '" value="' + propertyValue + '" type="text"' + readonlyFlag + '/>';
						} 
						formContent +=
											'</div>' +
										'</div>';
					});
					
					// 未定义表单属性，显示confirm
					if (formContent == "") {
						formContent += 
										'<div class="form-group">' +
											'<span>&nbsp;&nbsp;确实要提交任务吗？</span>' +
										'</div>';
					}		
										
					content += formContent +
									'</form>' +
								'</div>' +
							'</div>' +
						'</div>';
					return $(content);
				},
				buttons: [{
					label: "办理",
					cssClass: "btn btn-sm btn-success",
					action: function(dialog) {
						var parm = {
							"id": $("#taskId").val()
						};
						$(".process-variable").each(function() {
							parm["obj." + $(this).attr("id")] = $(this).val();
						});
						var res = ajaxCRUD("task!handle.do", parm, false);
						if (res.resNum == "0") {
							table_view.api().ajax.reload();
							dialog.close();
							bbAlert(res.res);
						} else {
							dialog.close();
							bbAlert(res.res);
						}
						
					}
				}, {
					label: "取消",
					cssClass: "btn btn-sm btn-default",
					action: function(dialog) {
						dialog.close();
					}
				}]
			});
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
        
		<jsp:include page="../pub/userInfo.jsp" flush="true"/>
		<jsp:include page="../pub/jobOpForm.jsp" flush="true"/>
		
	</body>
</html>
