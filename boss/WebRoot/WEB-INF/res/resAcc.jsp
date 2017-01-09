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
		<link rel="stylesheet" href="assets/css/ace.skins.css" />
			
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		
		<link rel="stylesheet" href="css/datatable.css">
		 
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
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资源管理</a>
				</li>
				<li class="active">
					宽带账号
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
                            <!-- treeview -->
                            <div class="widget-box widget-color-blue2">
                            	<div class="widget-header">
                            		<h4 class="widget-title lighter smaller">
                            			<i class="icon-key blue bigger-110"></i>
                            			宽带账号
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<select id="crStatus">
                            					<option value="">--状态--</option>
                            					<option value="0">空闲</option>
                            					<option value="1">临时锁定</option>
                            					<option value="2">锁定</option>
                            					<option value="9">占用</option>
                            				</select>
                            				<select id="crBearable">
                            					<option value="">--业务--</option>
                            					<option value="a">ADSL</option>
                            					<option value="b">宽带</option>
                            				</select>
                            				<input class="" id="crAcc" type="text" placeholder="账号" style="width:100px"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search blue"></i>
                            					查询
                            				</button>
                            				<button class="btn btn-sm btn-success btn-white btn-round pull-right" id="btnNew">
                            					<i class="icon-file green"></i>
                            					新建
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>账号</th>
													<th>业务</th>
													<th>状态</th>
													<th>解锁时间</th>
													<th>客户</th>
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
								<label class="col-xs-2 control-label no-padding">
									账号：
								</label>
								<div class="col-xs-10">
									<div class="input-group">
										<input type="text" class="input-sm form-control" id="prefix" placeholder="账号前缀" />
										<span class="input-group-addon">
											<i class="icon-plus "></i>
										</span>
										<input type="text" class="input-sm form-control" id="startAcc" placeholder="起始编号" />
										<span class="input-group-addon">
											<i class="icon-forward "></i>
										</span>
										<input type="text" class="input-sm form-control" id="endAcc" placeholder="截止编号"/>
										<span class="input-group-addon">
											<i class="icon-plus "></i>
										</span>
										<input type="text" class="input-sm form-control" id="suffix" placeholder="账号后缀"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									业务：
								</label>
								<div class="col-xs-4">
									<select id="bearable" class="form-control">
										<option value="a">ADSL</option>
										<option value="b">宽带</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">
									状态：
								</label>
								<div class="col-xs-4">
									<select id="status" class="form-control">
										<option value="0">空闲</option>
										<option value="1">临时锁定</option>
										<option value="2">锁定</option>
										<option value="9">占用</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									备注：
								</label>
								<div class="col-xs-10">
									<input type="text" id="remark" class="form-control"/>
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

		<script type="text/javascript">
		
        var table_view;
        var criteria = {};
        var op = "${sessionScope.userInfo.userName}";

    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(document).ready(function() {
			initTableView();
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "resAcc!findByPage.do",
            		"data": criteria,
            		"dataSrc": "lst"
            	},
            	"aoColumns": [ 
            		{"mDataProp": "acc"},
            		{"mDataProp": "bearable"},
    				{"mDataProp": "status"},
	    			{"mDataProp": "unlockTime"},
    				{"mDataProp": "customerName"},
    				{"mDataProp": "remark"},
					{"mDataProp": ""}
    			],
				columnDefs: [{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	if (c.bearable == "a") {
                    		return 'ADSL';
                    	} else if (c.bearable == "b") {
                    		return '宽带';
                    	} else {
                    		return 'ADSL，宽带';
                    	}
                    }
                },{
                    targets: 2,
                    render: function (a, b, c, d) {
                    	if (c.status == 0) {
                    		return '空闲';
                    	} else if (c.status == 1) {
                    		return '临时锁定';
                    	} else if (c.status == 2) {
                    		return '锁定';
                    	} else {
                    		return '占用';
                    	}
                    }
                },{
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in", "tooltip": "查看"},
                                {"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil", "tooltip": "编辑"},
								{"fn": "del('" + c.id + "')", "color": "red", "icon": "trash", "tooltip": "删除"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }],
				"bLengthChange": false,//
				"iDisplayLength" :10,
				"searching":false,//关闭dataTable自带搜索
				"bPaginate": true,//开启分页功能
				"bSort" : false,//关闭排序
				"language": { //国际化
					"url": "assets/js/Chinese.json"
				}
			});
		}
		
		$("#btnInquiry").click(function() {
			criteria = {};
			if ($("#crAcc").val() != "") {
				criteria["obj.acc"] = $("#crAcc").val();
			}
			if ($("#crBearable").val() != "") {
				criteria["obj.bearable"] = $("#crBearable").val();
			}
			if ($("#crStatus").val() != "") {
				criteria["obj.status"] = $("#crStatus").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
		});
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
        $("#btnNew").click(function() { 
        	showNewDlg();
        });
        
        $("#save").click(function() {
        	if ($("#prefix").val() + $("#startAcc").val() + $("#suffix").val()  == "") {
        		alert("账号前缀、起始编号和账户后缀不能同时为空");
        		return;
        	}
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		var parm = {
    				"obj.id": $("#id").val(),
    				"obj.prefix": $("#prefix").val(),
    				"obj.suffix": $("#suffix").val(),
    				"obj.startAcc": $("#startAcc").val(),
    				"obj.endAcc": $("#endAcc").val(),
    				"obj.remark": $("#remark").val(),
    				"obj.status": $("#status").val(),
    				"obj.bearable": $("#bearable").val(),
        		};
        		resData = ajaxCRUD("resAcc!insert.do", parm, true);
        	} else {
        		var parm = {
    				"obj.id": $("#id").val(),
    				"obj.remark": $("#remark").val(),
    				"obj.status": $("#status").val(),
    				"obj.bearable": $("#bearable").val(),
        		};
        		resData = ajaxCRUD("resAcc!update.do", parm, true);
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
					    var resData = ajaxCRUD("resAcc!delete.do", parm, true);
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
        	$("#prefix").val(obj.acc);
        	$("#startAcc").val("");
        	$("#endAcc").val("");
        	$("#suffix").val("");
        	$("#bearable").val(obj.bearable);
        	$("#status").val("0");
        	$("#remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#prefix").val("");
        	$("#startAcc").val("");
        	$("#endAcc").val("");
        	$("#bearable").val("a");
        	$("#status").val("0");
        	$("#suffix").val("");
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
