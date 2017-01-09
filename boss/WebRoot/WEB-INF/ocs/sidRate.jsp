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
		<!-- zTree -->
		<link rel="stylesheet" href="assets/css/zTreeStyle/metro.css">
		
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
		<!-- zTree -->
		<script src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		<!-- Customize -->
		<script src="js/accountItemDlg.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资费管理</a>
				</li>
				<li class="active">
					费率
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
								class="green icon-ticket bigger-120"></i> 费率列表 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                            	<div class="col-sm-11" style="padding-top:5px;padding-bottom:5px;">
									<label class="col-xs-1 control-label no-padding">
										费率名称：
									</label>
									<div class="col-xs-2">
										<input type="text" id="nameCond" name="obj.nameCond" class="" style="width:100%;"/>
									</div>
									<label class="col-xs-1 control-label no-padding">
										业务：
									</label>
									<div class="col-xs-2">
										<select name="obj.serviceIdCond" calss="input-sm" id="serviceIdCond" style="width:100%;">
										</select>
									</div>
									<label class="col-xs-1 control-label no-padding">
										费率类型：
									</label>
									<div class="col-xs-2">
										<select name="obj.rateTypeCond" calss="input-sm" id="rateTypeCond" style="width:100%;">
											<option role="option" value=-1>--请选择--</option>
											<option role="option" value=0>标准费率</option>
											<option role="option" value=1>固定费率</option>
											<option role="option" value=2>T+1费率</option>
											<option role="option" value=3>阶梯费率</option>
										</select>
									</div>
	                                <div class="col-sm-1" style="padding-top:5px;padding-bottom:5px;">
    	                                <input type="button" class="btn btn-sm btn-primary pull-left" style="" id="btn_inquiry" value="查询" />
        	                        </div>
                            	</div>
                                <div class="col-sm-1" style="padding-top:5px;padding-bottom:5px;">
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add" value="添加" />
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											费率名称
										</th>
										<th>
											业务
										</th>
										<th>
											费率类型
										</th>
										<th>
											账目
										</th>
										<th>
											附加费账目
										</th>
										<th>
											备注
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
			
				<!-- 费率明细 -->
				<div class="tabbable">
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#ne"> <i
								class="green icon-ticket bigger-120"></i> 费率明细列表 </a>
						</li>
					</ul>

					<div id="div_sub" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add_sub" value="添加费率" />
                                </div>
                            </div>
							<table id="table_view_sub" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											单价
										</th>
										<th>
											起计数
										</th>
										<th>
											固定费
										</th>
										<th>
											基础计次
										</th>
										<th>
											附加费价格
										</th>
										<th>
											附加费单位计次
										</th>
										<th>
											阀值
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


		<!-- 费率模态框（Modal） -->
		<div class="modal fade" id="dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:60%;">
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
								<label class="col-xs-2 control-label no-padding">
									名称：
								</label>
								<div class="col-xs-4">
									<input type="text" id="name" class="form-control"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									业务：
								</label>
								<div class="col-xs-4">
									<select name="obj.serviceId" class="form-control" id="serviceId">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									费率类型：
								</label>
								<div class="col-xs-4">
									<select name="obj.rateType" class="form-control" id="rateType">
										<option role="option" value=-1>--请选择--</option>
										<option role="option" value=0>标准费率</option>
										<option role="option" value=1>固定费率</option>
										<option role="option" value=2>T+1费率</option>
										<option role="option" value=3>阶梯费率</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-4">
									<input type="text" id="remark" class="form-control"/>
								</div>
							</div>
							<div class="form-group" id="p_std" style="display:none;">
								<label class="col-xs-2 control-label no-padding">
									单价：
								</label>
								<div class="col-xs-4">
									<input type="text" id="std_price" name="obj.std_price" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group" id="p_fix" style="display:none;">
								<label class="col-xs-2 control-label no-padding">
									固定费：
								</label>
								<div class="col-xs-4">
									<input type="text" id="fix_fee" name="obj.fix_fee" class="" style="width:93%;"/>
								</div>
							</div>
							<div id="p_plus" style="display:none;">
								<div class="form-group" >
								<label class="col-xs-2 control-label no-padding">
									固定费：
								</label>
								<div class="col-xs-4">
									<input type="text" id="plus_fee" name="obj.plus_fee" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									免费量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="plus_usage" name="obj.plus_usage" class="" style="width:93%;"/>
								</div>
								</div>
								<div class="form-group" >
								<label class="col-xs-2 control-label no-padding">
									单价：
								</label>
								<div class="col-xs-4">
									<input type="text" id="plus_price" name="obj.plus_price" class="" style="width:93%;"/>
								</div>
								</div>
							</div>
							<div class="form-group" id="p_tier" style="display:none;">
								<label class="col-xs-2 control-label no-padding">
									阶梯数：
								</label>
								<div class="col-xs-4">
									<input type="text" id="tier_threshold" name="obj.tier_threshold" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label for="accountItemId" class="col-sm-2 control-label">账目：</label>
								<div class="col-sm-10">
									<input id="accountItemId" type="hidden"/>
									<input id="accountItemName" type="text" class="form-control" placeholder="选择账目"/>
								</div>
							</div>
							<div class="form-group" id="divAccountItem" style="display:none;">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<div class="panel panel-default">
										<div class="panel-body">
											<ul id="treeAccountItem" class="ztree" style="overflow:auto;" onmouseleave="hideAccountItem()"></ul>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="attachItemId" class="col-sm-2 control-label">附加费账目：</label>
								<div class="col-sm-10">
									<input id="attachItemId" type="hidden"/>
									<input id="attachItemName" type="text" class="form-control" placeholder="选择附加费账目"/>
								</div>
							</div>
							<div class="form-group" id="divAttachItem" style="display:none;">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<div class="panel panel-default">
										<div class="panel-body">
											<ul id="treeAttachItem" class="ztree" style="overflow:auto;" onmouseleave="hideAttachItem()"></ul>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							提交
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

		<!-- 费率明细模态框（Modal） -->
		<div class="modal fade" id="dlg_sub" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:70%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title_sub">
						</h4>
					</div>

					<input type="hidden" id="sub_id" name="obj.sub_id" value="">
					<input type="hidden" id="rateId" name="obj.rateId" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>单价：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="price" name="obj.price" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									强计数：
								</label>
								<div class="col-xs-4">
									<input type="text" id="baseDuration" name="obj.baseDuration" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									固定费：
								</label>
								<div class="col-xs-4">
									<input type="text" id="baseFee" name="obj.baseFee" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									基础计次：
								</label>
								<div class="col-xs-4">
									<input type="text" id="baseUsage" name="obj.baseUsage" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									附加费价格：
								</label>
								<div class="col-xs-4">
									<input type="text" id="attachPrice" name="obj.attachPrice" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									附加费单元计次：
								</label>
								<div class="col-xs-4">
									<input type="text" id="attachUnitCount" name="obj.attachUnitCount" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									阀值：
								</label>
								<div class="col-xs-4">
									<input type="text" id="threshold" name="obj.threshold" class="" style="width:93%;"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save_sub">
							提交
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
	    $(document).ready(function(){
			loadDictData();
			initAccountItemTree();
			initAttachItemTree();
		});
		
		function loadDictData() {
			// 载入业务
			var obj = {"start":0,"length":999};
			var res = ajaxCRUD("sidService!selectByPage.do", obj, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#serviceIdCond").append(html);
			$("#serviceId").append(html);
		}
	
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidRate!selectByCriteria.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "serviceName"},
    			{"mDataProp": "rateTypeDesc"},
    			{"mDataProp": "accountItemName"},
    			{"mDataProp": "attachItemName"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                            	{"fn": "showSubList('" + c.id + "')", "color": "blue", "icon": "bars"},
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateDlg(" + JSON.stringify(c) + ")", "color": "red", "icon": "pencil"},
								{"fn": "del('" + c.id + "')", "color": "red", "icon": "trash"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

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
		
        var table_view_sub;
        var parmSub;
        function initSubTable(fk) {
        	parmSub = {"fk": fk};
			table_view_sub = $('#table_view_sub').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
	            	"url": "sidRateItem!findByFk.do",
    	        	"data": parmSub,
        	    	"dataSrc": "lst"
            	},
	            "aoColumns": [ 
    	        	{"mDataProp": "price"},
    				{"mDataProp": "baseDuration"},
    				{"mDataProp": "baseFee"},
    				{"mDataProp": "baseUsage"},
    				{"mDataProp": "attachPrice"},
    				{"mDataProp": "attachUnitCount"},
    				{"mDataProp": "threshold"},
					{"mDataProp": ""}
	    		],
				columnDefs: [{
                    targets: 7,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailSubDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateSubDlg(" + JSON.stringify(c) + ")", "color": "red", "icon": "pencil"},
								{"fn": "delSub('" + c.id + "')", "color": "red", "icon": "trash"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }],
				"bLengthChange": false,//
				"iDisplayLength" :10,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": false,//开启分页功能
				"bSort" : false,//关闭排序
				"bInfo" : false,
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
        }
        
		initSubTable("");
		
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_inquiry").click(function() { 
        	var name = $("#nameCond").val();
        	var rateType = $("#rateTypeCond").val();
        	var serviceId = $("#serviceIdCond").val();
        	parm = {"criteria.name": name, "criteria.rateType": rateType, "criteria.serviceId": serviceId};
			table_view.fnSettings().ajax.data = parm; 
			table_view.api().ajax.reload();
        });
        
		$("#table_view tbody").on("click", "tr", function(event) {
			var aData = table_view.fnGetData(event.target.parentNode);
			showSubList(aData.id);
		});
		
        $("#btn_add").click(function() { 
        	showNewDlg();
        });
        
        $("#save").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入费率名称");
        		return;
        	}
        	if ($("#serviceId").val() == "") {
        		alert("请选择业务");
        		return;
        	}
        	if ($("#rateType").val() == "-1") {
        		alert("请选择费率类型");
        		return;
        	}
        	
        	var obj = {
    			"obj.id": $("#id").val(),
    			"obj.name": $("#name").val(),
    			"obj.rateType": $("#rateType").val(),
    			"obj.serviceId": $("#serviceId").val(),
    			"obj.accountItemId": $("#accountItemId").val(),
    			"obj.attachItemId": $("#attachItemId").val(),
    			"obj.remark": $("#remark").val()
        	};
        	var rateType = $("#rateType").val();
        	if (rateType == 0) {
        		obj["obj.price"] = $("#std_price").val();
        	} else if (rateType == 1) {
        		obj["obj.baseFee"] = $("#fix_fee").val();
        	} else if (rateType == 2) {
        		obj["obj.price"] = $("#plus_price").val();
        		obj["obj.baseFee"] = $("#plus_fee").val();
        		obj["obj.baseUsage"] = $("#plus_usage").val();
        	} else if (rateType == 3) {
        		obj["obj.threshold"] = $("#tier_threshold").val();
        	}
        	
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidRate!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidRate!update.do", obj, true);
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
						var obj = {"id":id };
					    var resData = ajaxCRUD("sidRate!delete.do", obj, true);
						if(resData.resNum == "0"){
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        $("#rateType").change(function() {
        	var rateType = $("#rateType").val();
        	showPanel(rateType);
        });
        
        function showPanel(rateType) {
        	$("#p_std").css("display", "none");
        	$("#p_fix").css("display", "none");
        	$("#p_plus").css("display", "none");
        	$("#p_tier").css("display", "none");
        	if (rateType == 0) {
        		$("#p_std").css("display", "block");
        		$("#std_price").val("0");
        	} else if (rateType == 1) {
        		$("#p_fix").css("display", "block");
        		$("#fix_fee").val("0");
        	} else if (rateType == 2) {
        		$("#p_plus").css("display", "block");
        		$("#plus_price").val("0");
        		$("#plus_fee").val("0");
        		$("#plus_usage").val("0");
        	} else if (rateType == 3) {
        		$("#p_tier").css("display", "block");
        		$("#tier_threshold").val("1");
        	}
        }
        
        $("#btn_add_sub").click(function() { 
        	showNewSubDlg();
        });
        
        $("#save_sub").click(function() {
        	if ($("#rateId").val() == "") {
        		alert("请选择费率");
        		return;
        	}
        	if ($("#price").val() == "" || $("#baseDuration").val() == "" || 
        		$("#baseFee").val() == "" || $("#baseUsage").val() == "" || $("#threshold").val() == "" ||
        		$("#attachPrice").val() == "" || $("#attachUnitCount").val == "") {
        		alert("请输入单价，强计数，固定费，基础计次，附加费单价，附加费单元计次，阀值");
        		return;
        	}
        	
        	var obj = {
    			"obj.id": $("#sub_id").val(),
    			"obj.rateId": $("#rateId").val(),
    			"obj.price": $("#price").val(),
    			"obj.baseDuration": $("#baseDuration").val(),
    			"obj.baseFee": $("#baseFee").val(),
    			"obj.baseUsage": $("#baseUsage").val(),
    			"obj.threshold": $("#threshold").val(),
    			"obj.attachPrice": $("#attachPrice").val(),
    			"obj.attachUnitCount": $("#attachUnitCount").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidRateItem!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidRateItem!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
				//table_view_sub.fnSettings().ajax.data = parmSub; 
				table_view_sub.api().ajax.reload();
				$("#dlg_sub").modal("hide");
        	}
        });
        
        function delSub(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var obj = {"id":id };
					    var resData = ajaxCRUD("sidRateItem!delete.do", obj, true);
						if(resData.resNum == "0"){
							//table_view_sub.fnSettings().ajax.data = parmSub; 
							table_view_sub.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showSubList(fk) {
        	parmSub = {"fk": fk};
			table_view_sub.fnSettings().ajax.data = parmSub; 
			table_view_sub.api().ajax.reload();
        }
        
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
        	$("#name").val(obj.name);
        	$("#rateType").val(obj.rateType);
        	$("#serviceId").val(obj.serviceId);
        	$("#accountItemId").val(obj.accountItemId);
        	$("#accountItemName").val(obj.accountItemName);
        	$("#attachItemId").val(obj.attachItemId);
        	$("#attachItemName").val(obj.attachItemName);
        	$("#remark").val(obj.remark);
        	showPanel(obj.rateType);
        }

    	function clear() {
    		$("#id").val("");
        	$("#name").val("");
        	$("#rateType").val(-1);
        	$("#serviceId").val("");
        	$("#accountItemId").val("");
        	$("#accountItemName").val("");
        	$("#attachItemName").val("");
        	$("#attachItemId").val("");
        	$("#remark").val("");
        	showPanel("-1");
    	}

        function showNewSubDlg() {
        	if (parmSub.fk == "") {
        		alert("请选择费率");
        		return;
        	}
            $("#dlg_title_sub").text("添加");
            clearSub();
            $("#flag").val("add");
            $("#save_sub").show();
            $("#dlg_sub").modal("show");
        }
        
        function showUpdateSubDlg(obj) {
            $("#dlg_title_sub").text("修改");
        	detailSub(obj);
            $("#flag").val("edit");
            $("#save_sub").show();
            $("#dlg_sub").modal("show");
        }
        
        function showDetailSubDlg(obj) {
            $("#dlg_title_sub").text("详情");
        	detailSub(obj);
            $("#flag").val("");
            $("#save_sub").hide();
            $("#dlg_sub").modal("show");
        }
        
        function detailSub(obj) {
    		$("#sub_id").val(obj.id);
        	$("#rateId").val(obj.rateId);
        	$("#price").val(obj.price);
        	$("#baseDuration").val(obj.baseDuration);
        	$("#baseFee").val(obj.baseFee);
        	$("#baseUsage").val(obj.baseUsage);
        	$("#threshold").val(obj.threshold);
        	$("#attachPrice").val(obj.attachPrice);
        	$("#attachUnitCount").val(obj.attachUnitCount);
        }

    	function clearSub() {
    		$("#sub_id").val("");
        	$("#rateId").val(parmSub.fk);
        	$("#price").val("0");
        	$("#baseDuration").val("0");
        	$("#baseFee").val("0");
        	$("#baseUsage").val("0");
        	$("#threshold").val("0");
        	$("#attachPrice").val("0");
        	$("#attachUnitCount").val("1");
    	}

    	function hideAccountItem() {
    		$("#divAccountItem").css("display", "none");
    	}
    	
    	$("#accountItemName").focus(function() {
    		initAccountItemTree();
    		$("#divAccountItem").css("display", "block");
    	});

    	function hideAttachItem() {
    		$("#divAttachItem").css("display", "none");
    	}
    	
    	$("#attachItemName").focus(function() {
    		initAttachItemTree();
    		$("#divAttachItem").css("display", "block");
    	});

		</script>

		<script id="tpl" type="text/x-handlebars-template">
        <div class="action-buttons">
    	{{#each func}}
    	<a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a>
    	{{/each}}
		</div>
		</script>

		<script type="text/javascript">
            var tpl = $("#tpl").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
			var userName = "${sessionScope.userInfo.userName}";
			// alert(userName);
        </script>
	</body>
</html>
