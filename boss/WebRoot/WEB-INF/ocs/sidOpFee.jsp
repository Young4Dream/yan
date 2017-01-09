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
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资费管理</a>
				</li>
				<li class="active">
					业务受理费
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">
					<ul class="nav nav-tabs padding-18">
						<li class="active">
							<a data-toggle="tab" href="#ne1"> <i
								class="green icon-euro bigger-120"></i> 费用 </a>
						</li>
						<li>
							<a data-toggle="tab" href="#ne2"> <i
								class="red icon-gear bigger-120"></i> 业务 </a>
						</li>
					</ul>
					
					<div class="tab-content no-border padding-10">
					<!-- 费用 -->
					<div id="ne1" class="tab-pane in active">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add2" value="添加" />
                                </div>
                            </div>
							<table id="table_view2" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											费用名称
										</th>
										<th>
											单价
										</th>
										<th>
											账目
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
					
					<!-- 业务 -->
					<div id="ne2" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-right" style="" id="btn_add" value="添加" />
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											业务标识
										</th>
										<th>
											显示名
										</th>
										<th>
											费用项目
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
		</div>

		<!-- 业务-模态框（Modal） -->
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
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>业务标识：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="name" class="" style="width:93%;" placeholder="请输入业务标识，如p_setup"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>显示名：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="alias" class="" placeholder="请输入显示名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">费用项目：</label>
								<div class="col-xs-10">
									<select id="feeItems" class="selectpicker show-tick form-control" 
										multiple data-live-search="false">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">备注：</label>
								<div class="col-xs-10">
									<input type="text" id="remark" class="form-control">
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

		<!-- 费用-模态框（Modal） -->
		<div class="modal fade" id="fee_dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:60%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="fee_dlg_title">
						</h4>
					</div>

					<input type="hidden" id="fee_flag" value="">
					<input type="hidden" id="fee_id" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									费用名称：
								</label>
								<div class="col-xs-4">
									<input type="text" id="fee_name" class="form-control" placeholder="请输入费用名称"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									单价：
								</label>
								<div class="col-xs-4">
									<div class="input-group">
										<div class="input-group-addon">
											<span>￥</span>
										</div>
										<input type="text" id="fee_price" class="form-control" placeholder="请输入费用"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">备注：</label>
								<div class="col-xs-10">
									<input type="text" id="fee_remark" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="accountItemId" class="col-sm-2 control-label">账目：</label>
								<div class="col-sm-10">
									<input id="accountItemId" type="hidden"/>
									<input id="accountItemName" type="hidden"/>
									<div class="panel panel-default">
										<div class="panel-body">
											<ul id="treeAccountItem" class="ztree" style="overflow:auto;"></ul>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="fee_save">
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
		
		$(document).ready(function() {
			initAccountItemTree();
		});
		
		$('.selectpicker').selectpicker({});
		
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidOp!selectByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "alias"},
    			{"mDataProp": "feeItems"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 4,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil"},
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
		
        var table_view2;
        var parm2 = {};
		table_view2 = $('#table_view2').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidFee!selectByPage.do",
            	"data": parm2,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "price"},
    			{"mDataProp": "accountItemName"},
    			{"mDataProp": "remark"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 4,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg2(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateDlg2("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil"},
								{"fn": "del2('" + c.id + "')", "color": "red", "icon": "trash"}
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
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
        $("#btn_add").click(function() { 
        	showNewDlg();
        });
        
        $("#btn_add2").click(function() { 
        	showNewDlg2();
        });
        
        $("#save").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入业务标识");
        		return;
        	}
        	if ($("#alias").val() == "") {
        		alert("请输入显示名");
        		return;
        	}
        	var feeItems = "";
        	if ($("#feeItems").val() != null) {
        		feeItems = $("#feeItems").val().join(",");
        	}
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.name": $("#name").val(),
    			"obj.alias": $("#alias").val(),
    			"obj.remark": $("#remark").val(),
    			"obj.feeItems": feeItems
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidOp!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("sidOp!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view.fnSettings().ajax.data = {}; 
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
        $("#fee_save").click(function() {
        	if ($("#fee_name").val() == "") {
        		alert("请输入费用名称");
        		return;
        	}
        	if ($("#fee_price").val() == "") {
        		alert("请输入费用");
        		return;
        	}
        	var parm = {
    			"obj.id": $("#fee_id").val(),
    			"obj.name": $("#fee_name").val(),
    			"obj.price": $("#fee_price").val(),
    			"obj.accountItemId": $("#accountItemId").val(),
    			"obj.remark": $("#fee_remark").val()
        	};
        	var flag = $("#fee_flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidFee!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("sidFee!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view2.fnSettings().ajax.data = {}; 
				table_view2.api().ajax.reload();
				$("#fee_dlg").modal("hide");
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
					    var resData = ajaxCRUD("sidOp!delete.do", parm, true);
						if(resData.resNum == "0"){
							table_view.fnSettings().ajax.data = {}; 
							table_view.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
        function del2(id) {
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
	   				if(result){
						var parm = {"id":id };
					    var resData = ajaxCRUD("sidFee!delete.do", parm, true);
						if(resData.resNum == "0"){
							table_view2.fnSettings().ajax.data = {}; 
							table_view2.api().ajax.reload();
						}
	            	}
	            }
	    	});
        }
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
		function loadFee() {
			var res = ajaxCRUD("sidFee!findAll.do", {}, false);
			var lst = res.lst;
			var html = "";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option value='" + item.id + "'>" + item.name + "</option>";
			});
			$("#feeItems").empty();
			$("#feeItems").append(html);
			$("#feeItems").selectpicker('render');
			$("#feeItems").selectpicker('refresh');
		}
		
        function showNewDlg() {
            $("#dlg_title").text("添加");
            loadFee();
            clear();
            $("#flag").val("add");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showNewDlg2() {
            $("#fee_dlg_title").text("添加");
            clear2();
            $("#fee_flag").val("add");
            $("#fee_save").show();
            $("#fee_dlg").modal("show");
        }
        
        function showUpdateDlg(obj) {
            $("#dlg_title").text("修改");
            loadFee();
        	detail(obj);
            $("#flag").val("edit");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showUpdateDlg2(obj) {
            $("#fee_dlg_title").text("修改");
        	detail2(obj);
            $("#fee_flag").val("edit");
            $("#fee_save").show();
            $("#fee_dlg").modal("show");
        }
        
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
            loadFee();
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#dlg").modal("show");
        }
        
        function showDetailDlg2(obj) {
            $("#fee_dlg_title").text("详情");
        	detail2(obj);
            $("#fee_flag").val("");
            $("#fee_save").hide();
            $("#fee_dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#name").val(obj.name);
        	$("#alias").val(obj.alias);
        	$("#remark").val(obj.remark);
        	var res = ajaxCRUD("sidFee!selectOpFee.do", {"id": obj.id}, false);
        	var lst = res.lst;
        	var arr = [];
			$(lst).each(function(index) {
				var item = lst[index];
				arr.push(item.id);
			});
			$("#feeItems").selectpicker("val", arr);
        }

        function detail2(obj) {
    		$("#fee_id").val(obj.id);
        	$("#fee_name").val(obj.name);
        	$("#fee_price").val(obj.price);
        	$("#accountItemId").val(obj.accountItemId);
        	$("#accountItemName").val(obj.accountItemName);
        	$("#fee_remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#name").val("");
        	$("#alias").val("");
        	$("#remark").val("");
    	}

    	function clear2() {
    		$("#fee_id").val("");
        	$("#fee_name").val("");
        	$("#fee_price").val("0");
        	$("#accountItemId").val("");
        	$("#accountItemName").val("");
        	$("#fee_remark").val("");
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
