<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script src="js/pricePlan.js"></script>
		<script src="js/product.js"></script>
		<script src="js/fee.js"></script>
	</head>

	<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="dlgJobOpForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog"  style="width: 80%">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						派工单
					</h4>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
					<div class="col-md-12 column">
					<div class="panel panel-default">
					<div class="panel-body">
					<div class="tabbable" id="tabtable2">
						<ul class="nav nav-tabs">
							<li class="active">
								<a href="#panel-11" data-toggle="tab">
									<i class="green icon-user-md bigger-110"></i>
						 			用户信息
						 		</a>
							</li>
							<li>
						 		<a href="#panel-12" data-toggle="tab">
						 			<i class="red icon-money bigger-110"></i>
						 			用户反馈
						 		</a>
							</li>
							<li>
							 	<a href="#panel-13" data-toggle="tab">
							 		<i class="blue icon-phone bigger-110"></i>
							 		耗材管理
							 	</a>
							</li>
							<li>
							 	<a href="#panel-14" data-toggle="tab">
							 		<i class="dark icon-dollar bigger-110"></i>
							 		回访和工作量登记
							 	</a>
							</li>
						</ul>
						<div class="tab-content">
							<!-- 派工单用户信息 -->
							<div class="tab-pane active" id="panel-11">
								<table id="table_view_customer" class="table table-striped table-bordered table-hover">
									<tbody>
										<tr>
											<td>工单号</td><td class="jinfo" name="jobNo"></td>
											<td>项目</td><td colspan="3" class="jinfo" name="businessOpName"></td>
										</tr>
										<tr>
											<td>户名</td><td class="jinfo" name="userName"></td>
											<td>号码</td><td colspan="3" class="jinfo" name="businessKey"></td>
										</tr>
										<tr>
											<td width="10%">单位</td><td class="jinfo" name="departmentName" width="23%"></td>
											<td width="10%">联系人</td><td width="23%" class="jinfo" name="linker"></td>
											<td width="10%">等级</td><td width="24%" class="jinfo" name="vip"></td>
										</tr>
										<tr>
											<td>地址</td><td class="jinfo" name="address"></td>
											<td>联系电话</td><td colspan="3" class="jinfo" name="linkPhone"></td>
										</tr>
										<tr>
											<td>信息点</td><td>&nbsp;</td>
											<td>派单日期</td><td class="jinfo" name="dispatchTime"></td>
											<td colspan="2" class="jinfo" name="printTime"></td>
										</tr>
										<tr>
											<td>端口路由</td><td colspan="5" class="jinfo" name="routeInfo"></td>
										</tr>
									</tbody>
								</table>
								<div class="row form-group">
					 				<label class="col-sm-1 control-label">备注</label>
									<div class="col-sm-11">
										<input type="hidden" id="formId"></input>
										<input type="text" class="form-control" id="remark"></input>
									</div>
								</div>
							</div>
							<!-- 用户反馈 -->
							<div class="tab-pane" id="panel-12">
								<div class="row form-group">
					 				<label class="col-sm-2 control-label">服务质量满意度</label>
									<div class="col-sm-10">
										<select class="form-control" id="feedbackResult">
											<option value="非常满意">非常满意</option>
											<option value="满意" selected="selected">满意</option>
											<option value="不满意">不满意</option>
										</select>
									</div>
								</div>
								<div class="row form-group">
					 				<label class="col-sm-2 control-label">用户建议</label>
									<div class="col-sm-10">
										<textarea class="form-control" id="proposal"></textarea>
									</div>
								</div>
								<div class="row form-group">
					 				<label class="col-sm-2 control-label">整改内容</label>
									<div class="col-sm-10">
										<textarea class="form-control" id="rectification"></textarea>
									</div>
								</div>
							</div>
							<!-- 耗材管理 -->
							<div class="tab-pane" id="panel-13">
								<div class="row form-group">
					 				<label class="col-sm-1 control-label">耗材</label>
									<div class="col-sm-5">
										<select class="form-control" id="material">
										</select>
									</div>
					 				<label class="col-sm-1 control-label">数量</label>
									<div class="col-sm-5">
										<div class="input-group">
											<input class="form-control" id="materialAmount" type="text" placeholder="输入耗材数量" />
											<span class="input-group-btn">
												<button class="btn btn-sm btn-default" id="btnAddMaterialAmount">
													<i class="icon-plus-sign-alt bigger-110"></i>添加
												</button> 
											</span>
										</div>
									</div>
								</div>
								<table id="table_view_material" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>耗材名称</th>
											<th>单位</th>
											<th>消耗量</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>										
							</div>
							<!-- 回访和工作量登记 -->
							<div class="tab-pane" id="panel-14">
								<div class="row form-group">
					 				<label class="col-sm-2 control-label">电话回访</label>
									<div class="col-sm-10">
										<select class="form-control" id="visitResult">
											<option value="非常满意">非常满意</option>
											<option value="满意" selected="selected">满意</option>
											<option value="不满意">不满意</option>
										</select>
									</div>
								</div>
								<div class="row form-group">
					 				<label class="col-sm-2 control-label">代理人</label>
									<div class="col-sm-4">
										<select class="form-control" id="assignee">
										</select>
									</div>
					 				<label class="col-sm-2 control-label">工作量（人天）</label>
									<div class="col-sm-4">
										<div class="input-group">
											<input class="form-control" id="workloadAmount" type="text" placeholder="输入工作量" />
											<span class="input-group-btn">
												<button class="btn btn-sm btn-default" id="btnAddWorkloadAmount">
													<i class="icon-plus-sign-alt bigger-110"></i>添加
												</button> 
											</span>
										</div>
									</div>
								</div>
								<table id="table_view_workload" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>登录名</th>
											<th>姓名</th>
											<th>工作量（人天）</th>
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
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-primary " id="save">
						保存
					</button>
					<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
						关闭
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
	<script type="text/javascript">
		
		var table_view_material;
		var table_view_workload;
		var criteria =  {};
	
		function loadJobOpForm(id) {
			var res = ajaxCRUD("jobOpForm!generate.do", { "id": id }, false);
			var obj = res.obj;
			loadObjInfo(obj, "td.jinfo");
			$("#formId").val(obj.id);
			$("#remark").val(obj.remark);
			$("#feedbackResult").val(obj.feedbackResult);
			$("#proposal").val(obj.proposal);
			$("#rectification").val(obj.rectification);
			$("#visitResult").val(obj.visitResult);
			// 载入耗材
			loadMaterial();
			// 载入代理人
			loadAssignee();
			// 初始化已有耗材和工作量
			initMaterialTableView(obj.id);
			initWorkloadTableView(obj.id);
		}
		
		function initMaterialTableView(formId) {
			var parm  = { "obj.formId": formId };
			if (table_view_material != undefined) {
				table_view_material.api().ajax.reload();
				return;
			}
			table_view_material = $('#table_view_material').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "jobOpMaterial!findByFormId.do",
            		"data": parm,
            		"dataSrc": "lst"
            	},
            	"aoColumns": [ 
            		{"mDataProp": "materialName"},
    				{"mDataProp": "unitName"},
    				{"mDataProp": "amount"},
					{"mDataProp": ""}
    			],
				columnDefs: [
					{
                    targets: 3,
                    render: function (a, b, c, d) {
                    	var func = [];
                    	func.push({"fn": "delMaterial('" + c.id + "')", "color": "red", "icon": "trash", "tooltip": "删除"});
                        return template({"func": func });
                    }
					}
            	],
            	"bAutoWidth": false,
				"bLengthChange": false,//
				"iDisplayLength" : 8,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": false,//开启分页功能
				"bSort" : false,//关闭排序
				"bInfo" : false,
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
		}
		
		function initWorkloadTableView(formId) {
			var parm  = { "obj.formId": formId };
			if (table_view_workload != undefined) {
				table_view_workload.api().ajax.reload();
				return;
			}
			table_view_workload = $('#table_view_workload').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "jobOpWorkload!findByFormId.do",
            		"data": parm,
            		"dataSrc": "lst"
            	},
            	"aoColumns": [ 
            		{"mDataProp": "assignee"},
    				{"mDataProp": "assigneeName"},
    				{"mDataProp": "amount"},
					{"mDataProp": ""}
    			],
				columnDefs: [
					{
                    targets: 3,
                    render: function (a, b, c, d) {
                    	var func = [];
                    	func.push({"fn": "delWorkload('" + c.id + "')", "color": "red", "icon": "trash", "tooltip": "删除"});
                        return template({"func": func });
                    }
					}
            	],
            	"bAutoWidth": false,
				"bLengthChange": false,//
				"iDisplayLength" : 8,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": false,//开启分页功能
				"bSort" : false,//关闭排序
				"bInfo" : false,
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
		}
		
		function loadMaterial() {
			if ($("#material")[0].options.length > 0) { return; }
			var res = ajaxCRUD("sidMaterial!findAll.do", { }, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择耗材--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + " " + item.unitName + "</option>";
			});
			$("#material").empty();
			$("#material").append(html);
		}

		function loadAssignee() {
			if ($("#assignee")[0].options.length > 0) { return; }
			var res = ajaxCRUD("user!findByRoleName.do", { "obj.roleId": "外线班" }, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择人员--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.userName + "'>" + item.userAlias + "</option>";
			});
			$("#assignee").empty();
			$("#assignee").append(html);
		}

		$("#btnAddMaterialAmount").click(function() {
			if ($("#material").val() == "") {
				bbAlert("请选择耗材");
				return;
			}
			if ($("#materialAmount").val() == "" || isNaN($("#materialAmount").val())) {
				bbAlert("请输入耗材数量，耗材数量必须是数字");
				return;
			}
			var parm = {
				"obj.formId": $("#formId").val(),
				"obj.materialId": $("#material").val(),
				"obj.amount": $("#materialAmount").val(),
				"obj.creator": "${sessionScope.userInfo.userName}"
			};
			var res = ajaxCRUD("jobOpMaterial!insert.do", parm, false);
			if (res.resNum == "0") {
				table_view_material.api().ajax.reload();
			}
		});
		
		function delMaterial(id) {
			var parm = { "id": id };
			var res = ajaxCRUD("jobOpMaterial!delete.do", parm, true);
			if (res.resNum == "0") {
				table_view_material.api().ajax.reload();
			}
		}
		
		function delWorkload(id) {
			var res = ajaxCRUD("jobOpWorkload!delete.do", { "id": id }, true);
			table_view_workload.api().ajax.reload();
		}
		
		$("#btnAddWorkloadAmount").click(function() {
			if ($("#assignee").val() == "") {
				bbAlert("请选择代理人");
				return;
			}
			if ($("#workloadAmount").val() == "" || isNaN($("#workloadAmount").val())) {
				bbAlert("请输入工作量，工作量必须是数字");
				return;
			}
			var parm = {
				"obj.formId": $("#formId").val(),
				"obj.assignee": $("#assignee").val(),
				"obj.assigneeName": $("#assignee option:selected").text(),
				"obj.amount": $("#workloadAmount").val(),
				"obj.creator": "${sessionScope.userInfo.userName}"
			};
			var res = ajaxCRUD("jobOpWorkload!insert.do", parm, false);
			if (res.resNum == "0") {
				table_view_workload.api().ajax.reload();
			}
		});
		
		$("#save").click(function() {
			var parm = {
				"obj.id": $("#formId").val(),
				"obj.remark": $("#remark").val(),
				"obj.proposal": $("#proposal").val(),
				"obj.rectification": $("#rectification").val(),
				"obj.feedbackResult": $("#feedbackResult").val(),
				"obj.visitResult": $("#visitResult").val()
			};
			var res = ajaxCRUD("jobOpForm!update.do", parm, true);
			if (res.resNum == "0") {
				$("#dlgJobOpForm").modal("hide");
			}
		});
		
	</script>
	</body>
</html>
