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
					<a href="#">资费管理</a>
				</li>
				<li class="active">
					网间结算费率
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">

			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                            	<div class="col-sm-11" style="padding-top:5px;padding-bottom:5px;">
									<label class="col-xs-1 control-label no-padding">
										运营商：
									</label>
									<div class="col-xs-2" style="z-index:10;">
										<select name="obj.operatorId" calss="input-sm" id="operatorId" style="width:100%;" onchange="service_change()">
										</select>
									</div>
	                                <div class="col-sm-1" style="padding-top:5px;padding-bottom:5px;">
    	                                <input type="button" class="btn btn-sm btn-primary pull-right" style="z-index:10;" id="btn_add_op" value="添加" />
        	                        </div>
	                                <div class="col-sm-1" style="padding-top:5px;padding-bottom:5px;">
    	                                <input type="button" class="btn btn-sm btn-primary pull-left" style="z-index:10;" id="btn_del_op" value="删除" />
        	                        </div>
                            	</div>
                            </div>
					
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#trunk"> 
								<i class="green icon-long-arrow-right bigger-120"></i> 中继定义 </a>
						</li>

						<li>
							<a data-toggle="tab" href="#rate"> 
								<i class="green icon-stackexchange bigger-120"></i> 网间结算费率 </a>
						</li>

					</ul>

					<div class="tab-content no-border padding-10">
						<!-- #trunk -->
						<div id="trunk" class="tab-pane in active">

                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add_trunk" value="添加" />
                                </div>
                            </div>
							<table id="table_view_trunk"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											网元
										</th>
										<th>
											中继号
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
						<!-- #trunk -->

						<!-- #rate -->
						<div id="rate" class="tab-pane">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add_rate" value="添加" />
                                </div>
                            </div>
							<table id="table_view_rate"
									class="table table-striped table-bordered table-hover">
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
						<!-- #rate -->
					</div>
				</div>
			</div>
		</div>

		<!-- 模态框（运营商） -->
		<div class="modal fade" id="dlg_op" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:30%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title_op">
						</h4>
					</div>

					<input type="hidden" id="flag_op" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									<font color="green"><b>运营商名称：</b></font>
								</label>
								<div class="col-xs-9">
									<input type="text" id="name" name="obj.name" class="" style="width:93%;"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="btn_save_op">
							提交
						</button>
						<button type="button" class="btn btn-sm btn-default"
							data-dismiss="modal">
							关闭
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 模态框（中继） -->
		<div class="modal fade" id="dlg_trunk" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:50%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title_trunk">
						</h4>
					</div>

					<input type="hidden" id="flag_trunk" value="">
					<input type="hidden" id="id_trunk" value="">
					
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									网元：
								</label>
								<div class="col-xs-4">
									<select class="form-control" id="sourceName">
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									中继号：
								</label>
								<div class="col-xs-4">
									<input type="text" id="trunkNo" name="obj.trunkNo" class="form-control" placeholder="请输入中继号"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-10">
									<input type="text" id="trunkRemark" name="obj.trunkRemark" class="form-control"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="btn_save_trunk">
							提交
						</button>
						<button type="button" class="btn btn-sm btn-default"
							data-dismiss="modal">
							关闭
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 模态框（网间结算费率） -->
		<div class="modal fade" id="dlg_rate" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:50%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title_rate">
						</h4>
					</div>

					<input type="hidden" id="flag_rate" value="">
					<input type="hidden" id="id_rate" value="">
					
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>费率：</b></font>
								</label>
								<div class="col-xs-4">
									<select name="obj.rateId" calss="input-sm" id="rateId" style="width:97.5%;">
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-4">
									<input type="text" id="rateRemark" name="obj.rateRemark" class="" style="width:97.5%;"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="btn_save_rate">
							提交
						</button>
						<button type="button" class="btn btn-sm btn-default"
							data-dismiss="modal">
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
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
        var table_view_trunk;
        var table_view_rate;
        var ajaxParm = {"fk": ""};
        
		table_view_trunk = $('#table_view_trunk').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidOperatorTrunk!findByFk.do",
            	"data": ajaxParm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "sourceName"},
            	{"mDataProp": "trunkNo"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 3,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailTrunkDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateTrunkDlg(" + JSON.stringify(c) + ")", "color": "red", "icon": "pencil"},
								{"fn": "delTrunk('" + c.id + "')", "color": "red", "icon": "trash"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
			"bLengthChange": false,//
			"iDisplayLength" :20,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});

		table_view_rate = $('#table_view_rate').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidOperatorRate!findByFk.do",
            	"data": ajaxParm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "rateName"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 2,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailRateDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateRateDlg(" + JSON.stringify(c) + ")", "color": "red", "icon": "pencil"},
								{"fn": "delRate('" + c.id + "')", "color": "red", "icon": "trash"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
			"bLengthChange": false,//
			"iDisplayLength" :20,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});

	    $(document).ready(function(){
			loadOp();
			loadRate();
			loadCdrSource();
			service_change();
		});
		
		function loadOp() {
			// 载入运营商
			var obj = {};
			var res = ajaxCRUD("sidOperator!findAll.do", obj, false);
			var lst = res.lst;
			var html = "";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#operatorId").empty();
			$("#operatorId").append(html);
		}
	
		function loadRate() {
			// 载入费率
			var obj = {"start": 0, "length": 999};
			var res = ajaxCRUD("sidRate!findAll.do", obj, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#rateId").empty();
			$("#rateId").append(html);
		}
		
		function loadCdrSource() {
			// 载入话单网元
			var res = ajaxCRUD("cdrSource!findAll.do", {}, false);
			var lst = res.lst;
			var html = "<option role='option' value=''>--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role='option' value='" + item.name + "'>" + item.name + "</option>";
			});
			$("#sourceName").empty();
			$("#sourceName").append(html);
		}
	
        function service_change() { 
        	var opId = $("#operatorId").val();
        	ajaxParm = {"fk": opId};
			table_view_trunk.fnSettings().ajax.data = ajaxParm; 
			table_view_trunk.api().ajax.reload();
			table_view_rate.fnSettings().ajax.data = ajaxParm; 
			table_view_rate.api().ajax.reload();
        }
        
		/////////////////////////////////////////////////////////////////////////////////
		// 运营商模态窗
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_add_op").click(function() { 
        	showNewDlg();
        });
        
        $("#btn_save_op").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入运营商名称");
        		return;
        	}
        	
        	var obj = {
    			"obj.name": $("#name").val()
        	};
        	var flag = $("#flag_op").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidOperator!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidOperator!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
        		loadOp()
				$("#dlg_op").modal("hide");
        	}
        });
        
        $("#btn_del_op").click(function() {
        	var id = $("#operatorId").val();
        	if (id == undefined || id == "") {
        		alert("请选择要删除的运营商");
        		return;
        	}
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var obj = {"id":id };
					    var resData = ajaxCRUD("sidOperator!delete.do", obj, true);
						if(resData.resNum == "0"){
							loadOp();
						}
	            	}
	            }
	    	});
        });
        
        function showNewDlg() {
            $("#dlg_title_op").text("添加");
            clearOp();
            $("#flag_op").val("add");
            $("#btn_save_op").show();
            $("#dlg_op").modal("show");
        }
        
    	function clearOp() {
        	$("#name").val("");
    	}
		
		/////////////////////////////////////////////////////////////////////////////////
		// 中继模态窗
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_add_trunk").click(function() { 
        	showNewTrunkDlg();
        });
        
        $("#btn_save_trunk").click(function() {
        	if ($("#sourceName").val() == "") {
        		alert("请选择网元");
        		return;
        	}
        	
        	if ($("#trunkNo").val() == "") {
        		alert("请输入中继号");
        		return;
        	}
        	
        	var obj = {
    			"obj.id": $("#id_trunk").val(),
    			"obj.opId": $("#operatorId").val(),
    			"obj.trunkNo": $("#trunkNo").val(),
    			"obj.remark": $("#trunkRemark").val(),
    			"obj.sourceName": $("#sourceName").val()
        	};
        	var flag = $("#flag_trunk").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidOperatorTrunk!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidOperatorTrunk!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
				table_view_trunk.fnSettings().ajax.data = ajaxParm; 
				table_view_trunk.api().ajax.reload();
				$("#dlg_trunk").modal("hide");
        	}
        });

        function delTrunk(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var obj = {"id":id };
					    var resData = ajaxCRUD("sidOperatorTrunk!delete.do", obj, true);
						if(resData.resNum == "0"){
							table_view_trunk.fnSettings().ajax.data = ajaxParm; 
							table_view_trunk.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        function showNewTrunkDlg() {
            $("#dlg_title_trunk").text("添加");
            clearTrunk();
            $("#flag_trunk").val("add");
            $("#btn_save_trunk").show();
            $("#dlg_trunk").modal("show");
        }
        
        function showUpdateTrunkDlg(obj) {
            $("#dlg_title_trunk").text("修改");
        	detailTrunk(obj);
            $("#flag_trunk").val("edit");
            $("#btn_save_trunk").show();
            $("#dlg_trunk").modal("show");
        }
        
        function showDetailTrunkDlg(obj) {
            $("#dlg_title_trunk").text("详情");
        	detailTrunk(obj);
            $("#flag_trunk").val("");
            $("#btn_save_trunk").hide();
            $("#dlg_trunk").modal("show");
        }
        
        function detailTrunk(obj) {
    		$("#id_trunk").val(obj.id);
        	$("#trunkNo").val(obj.trunkNo);
        	$("#trunkRemark").val(obj.remark);
        	$("#sourceName").val(obj.sourceName);
        }

    	function clearTrunk() {
    		$("#id_trunk").val("");
        	$("#trunkNo").val("");
        	$("#trunkRemark").val("");
        	$("#sourceName").val("");
    	}
		
		/////////////////////////////////////////////////////////////////////////////////
		// 费率模态窗
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_add_rate").click(function() { 
        	showNewRateDlg();
        });
        
        $("#btn_save_rate").click(function() {
        	if ($("#rateId").val() == "") {
        		alert("请选择费率");
        		return;
        	}
        	
        	var obj = {
    			"obj.id": $("#id_rate").val(),
    			"obj.opId": $("#operatorId").val(),
    			"obj.rateId": $("#rateId").val(),
    			"obj.remark": $("#rateRemark").val()
        	};
        	var flag = $("#flag_rate").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidOperatorRate!insert.do", obj, true);
        	} else {
        		resData = ajaxCRUD("sidOperatorRate!update.do", obj, true);
        	}
        	if (resData.resNum == "0") {
				table_view_rate.fnSettings().ajax.data = ajaxParm; 
				table_view_rate.api().ajax.reload();
				$("#dlg_rate").modal("hide");
        	}
        });

        function delRate(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var obj = {"id":id };
					    var resData = ajaxCRUD("sidOperatorRate!delete.do", obj, true);
						if(resData.resNum == "0"){
							table_view_rate.fnSettings().ajax.data = ajaxParm; 
							table_view_rate.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        function showNewRateDlg() {
            $("#dlg_title_rate").text("添加");
            clearRate();
            $("#flag_rate").val("add");
            $("#btn_save_rate").show();
            $("#dlg_rate").modal("show");
        }
        
        function showUpdateRateDlg(obj) {
            $("#dlg_title_rate").text("修改");
        	detailRate(obj);
            $("#flag_rate").val("edit");
            $("#btn_save_rate").show();
            $("#dlg_rate").modal("show");
        }
        
        function showDetailRateDlg(obj) {
            $("#dlg_title_rate").text("详情");
        	detailRate(obj);
            $("#flag_rate").val("");
            $("#btn_save_rate").hide();
            $("#dlg_rate").modal("show");
        }
        
        function detailRate(obj) {
    		$("#id_rate").val(obj.id);
        	$("#rateId").val(obj.rateId);
        	$("#rateRemark").val(obj.remark);
        }

    	function clearRate() {
    		$("#id_rate").val("");
        	$("#rateId").val("");
        	$("#rateRemark").val("");
    	}
		
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
        </script>
	</body>
</html>
