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
		<link rel="stylesheet" href="assets/css/bootstrap-select.min.css" />
		<!-- zTree -->
		<link rel="stylesheet" href="assets/css/zTreeStyle/metro.css">
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资费管理</a>
				</li>
				<li class="active">
					套餐
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<!-- 套餐 -->
				<div class="tabbable">
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#ne"> <i
								class="green icon-suitcase bigger-120"></i> 套餐列表 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                            	<div class="col-sm-11" style="padding-top:5px;padding-bottom:5px;">
									<label class="col-xs-1 control-label no-padding">
										套餐名称：
									</label>
									<div class="col-xs-2">
										<input type="text" id="nameCond" name="obj.nameCond" class="" style="width:100%;"/>
									</div>
									<label class="col-xs-1 control-label no-padding">
										套餐类型：
									</label>
									<div class="col-xs-2">
										<select name="obj.planTypeCond" calss="input-sm" id="planTypeCond" style="width:100%;">
											<option role="option" value=-1>--请选择--</option>
											<option role="option" value=0>兜底套餐</option>
											<option role="option" value=1>公共套餐</option>
											<option role="option" value=2>私有套餐</option>
										</select>
									</div>
									<label class="col-xs-1 control-label no-padding">
										套餐状态：
									</label>
									<div class="col-xs-2">
										<select name="obj.statusCond" calss="input-sm" id="statusCond" style="width:100%;">
											<option role="option" value=-1>--请选择--</option>
											<option role="option" value=0>创建</option>
											<option role="option" value=1>发布</option>
											<option role="option" value=2>下线</option>
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
											名称
										</th>
										<th>
											类型
										</th>
										<th>
											周期
										</th>
										<th>
											套餐费(￥)
										</th>
										<th>
											账目
										</th>
										<th>
											状态
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
			
				<!-- 费率表 -->
				<div class="tabbable">
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#ne"> <i
								class="green icon-suitcase bigger-120"></i> 费率列表 </a>
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
											费率名称
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
			</div>
		</div>


		<!-- 套餐模态框（Modal） -->
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
									<font color="green"><b>名称：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="name" name="obj.name" class="form-control"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>套餐类型：</b></font>
								</label>
								<div class="col-xs-4">
									<select name="obj.planType" class="form-control" id="planType">
										<option role="option" value=0>兜底套餐</option>
										<option role="option" value=1>公共套餐</option>
										<option role="option" value=2>私有套餐</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>套餐周期：</b></font>
								</label>
								<div class="col-xs-4">
									<select name="obj.term" class="form-control" id="term">
										<option role="option" value="DAY">天</option>
										<option role="option" value="WEEK">周</option>
										<option role="option" value="MONTH">月</option>
										<option role="option" value="SEASON">季</option>
										<option role="option" value="HALFOFYEAR">半年</option>
										<option role="option" value="YEAR">年</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>套餐费：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="planFee" name="obj.planFee" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">业务：</label>
								<div class="col-xs-4">
									<select id="bearable" class="form-control selectpicker show-tick form-control" 
										multiple data-live-search="false">
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									记账科目：
								</label>
								<div class="col-xs-4">
									<input id="accountItemId" type="hidden"/>
									<input class="form-control" id="accountItemName" type="text" placeholder="选择账目"/>
								</div>
							</div>
							<div class="form-group" id="divAccountItem" style="display:none;">
								<div class="col-xs-6">
								</div>
								<div class="col-xs-2">
								</div>
								<div class="col-xs-4">
									<ul id="treeAccountItem" class="ztree" style="overflow:auto;" onmouseleave="hideAccountItem()"></ul>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									免费时长：
								</label>
								<div class="col-xs-4">
									<input type="text" id="durationFree" name="obj.durationFree" class="form-control"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									时长限量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="durationLimit" name="obj.durationLimit" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									免费流量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="trafficFree" name="obj.trafficFree" class="form-control"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									流量限量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="trafficLimit" name="obj.trafficLimit" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									免费次数：
								</label>
								<div class="col-xs-4">
									<input type="text" id="occuranceFree" name="obj.occuranceFree" class="form-control"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									次数限量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="occuranceLimit" name="obj.occuranceLimit" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									套餐描述：
								</label>
								<div class="col-xs-10">
									<input type="text" id="planDesc" name="obj.planDesc" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									状态：
								</label>
								<div class="col-xs-4">
									<select name="obj.status" class="form-control" id="status">
										<option role="option" value=0>创建</option>
										<option role="option" value=1>发布</option>
										<option role="option" value=2>下线</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-4">
									<input type="text" id="remark" name="obj.remark" class="form-control"/>
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

		<!-- 字冠模态框（Modal） -->
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
					<input type="hidden" id="planId" name="obj.planId" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>费率：</b></font>
								</label>
								<div class="col-xs-4">
									<select name="obj.rateId" calss="input-sm" id="rateId" style="width:93%;">
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-4">
									<input type="text" id="sub_remark" name="obj.sub_remark" class="" style="width:93%;"/>
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
		<script src="assets/js/bootstrap-select.min.js"></script>
		<script src="assets/js/defaults-zh_CN.js"></script>
		<!-- zTree -->
		<script src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		<!-- Customize -->
		<script src="js/accountItemDlg.js"></script>
		 
		<script type="text/javascript">
		
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
	    $(document).ready(function(){
			loadDictData();
			loadRef("ref_business_type", "bearable");
		});
		
		function loadDictData() {
			// 载入费率
			var obj = {"start":0,"length":999};
			var res = ajaxCRUD("sidRate!findAll.do", obj, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#rateId").append(html);
		}
	
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidPricePlan!selectByCriteria.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "planTypeDesc"},
    			{"mDataProp": "termDesc"},
    			{"mDataProp": "planFee"},
    			{"mDataProp": "accountItemName"},
    			{"mDataProp": "statusDesc"},
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
			"iDisplayLength" :10,
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
	            	"url": "sidPlanRate!findByFk.do",
    	        	"data": parmSub,
        	    	"dataSrc": "lst"
            	},
	            "aoColumns": [ 
    	        	{"mDataProp": "rateName"},
    				{"mDataProp": "remark"},
					{"mDataProp": ""}
	    		],
				columnDefs: [{
                    targets: 2,
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
				"scrollY": "150px",
				"scrollCollapse": true,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": false,//开启分页功能
				"bSort" : false,//关闭排序
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
        	var planType = $("#planTypeCond").val();
        	var status = $("#statusCond").val();
        	parm = {"criteria.name": name, "criteria.planType": planType, "criteria.status": status};
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
        		alert("请输入套餐名称");
        		return;
        	}
        	if ($("#planFee").val() == "") {
        		alert("请输入套餐费用");
        		return;
        	}
        	
        	var business = $("#bearable").val().join("");
        	var obj = {
    			"obj.id": $("#id").val(),
    			"obj.name": $("#name").val(),
    			"obj.planType": $("#planType").val(),
    			"obj.term": $("#term").val(),
    			"obj.planFee": $("#planFee").val(),
    			"obj.durationFree": $("#durationFree").val(),
    			"obj.durationLimit": $("#durationLimit").val(),
    			"obj.trafficFree": $("#trafficFree").val(),
    			"obj.trafficLimit": $("#trafficLimit").val(),
    			"obj.occuranceFree": $("#occuranceFree").val(),
    			"obj.occuranceLimit": $("#occuranceLimit").val(),
    			"obj.planDesc": $("#planDesc").val(),
    			"obj.status": $("#status").val(),
    			"obj.remark": $("#remark").val(),
    			"obj.bearable": business,
    			"obj.accountItemId": $("#accountItemId").val(),
    			"obj.accountItemName": $("#accountItemName").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidPricePlan!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidPricePlan!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
				table_view.fnSettings().ajax.data = parm; 
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
					    var resData = ajaxCRUD("sidPricePlan!delete.do", obj, true);
						if(resData.resNum == "0"){
							table_view.fnSettings().ajax.data = parm; 
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        $("#btn_add_sub").click(function() { 
        	showNewSubDlg();
        });
        
        $("#save_sub").click(function() {
        	if ($("#rateId").val() == "") {
        		alert("请选择费率");
        		return;
        	}
        	var obj = {
    			"obj.id": $("#sub_id").val(),
    			"obj.planId": $("#planId").val(),
    			"obj.rateId": $("#rateId").val(),
    			"obj.remark": $("#sub_remark").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidPlanRate!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidPlanRate!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
				table_view_sub.fnSettings().ajax.data = parmSub; 
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
					    var resData = ajaxCRUD("sidPlanRate!delete.do", obj, true);
						if(resData.resNum == "0"){
							table_view_sub.fnSettings().ajax.data = parmSub; 
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
        	$("#planType").val(obj.planType);
        	$("#term").val(obj.term);
        	$("#planFee").val(obj.planFee);
        	$("#durationFree").val(obj.durationFree);
        	$("#durationLimit").val(obj.durationLimit);
        	$("#trafficFree").val(obj.trafficFree);
        	$("#trafficLimit").val(obj.trafficLimit);
        	$("#occuranceFree").val(obj.occuranceFree);
        	$("#occuranceLimit").val(obj.occuranceLimit);
        	$("#planDesc").val(obj.planDesc);
        	$("#status").val(obj.status);
        	$("#remark").val(obj.remark);
        	var arr = [];
        	var str = obj.bearable;
        	if (str != undefined && str != "") {
	        	for (var i = 0; i < str.length; i++) {
	        		var ch = str.substring(i, i + 1);
	        		arr.push(ch);
	        	}
        	} 
        	$("#bearable").selectpicker("val", arr);
        	$("#accountItemId").val(obj.accountItemId);
        	$("#accountItemName").val(obj.accountItemName);
        }

    	function clear() {
    		$("#id").val("");
        	$("#name").val("");
        	$("#planType").val(1);
        	$("#term").val("MONTH");
        	$("#planFee").val("0");
        	$("#durationFree").val("0");
        	$("#durationLimit").val("0");
        	$("#trafficFree").val("0");
        	$("#trafficLimit").val("0");
        	$("#occuranceFree").val("0");
        	$("#occuranceLimit").val("0");
        	$("#planDesc").val("");
        	$("#status").val(0);
        	$("#remark").val("");
        	$("#bearable").selectpicker("val", []);
        	$("#accountItemId").val("");
        	$("#accountItemName").val("");
    	}

        function showNewSubDlg() {
        	if (parmSub.fk == "") {
        		alert("请选择套餐");
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
    		$("#planId").val(obj.planId);
        	$("#rateId").val(obj.rateId);
        	$("#sub_remark").val(obj.remark);
        }

    	function clearSub() {
    		$("#sub_id").val("");
    		$("#planId").val(parmSub.fk);
        	$("#rateId").val("");
        	$("#sub_remark").val("");
    	}
    	
    	function hideAccountItem() {
    		$("#divAccountItem").css("display", "none");
    	}
    	
    	$("#accountItemName").focus(function() {
    		initAccountItemTree();
    		$("#divAccountItem").css("display", "block");
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
