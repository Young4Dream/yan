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
		<link rel="stylesheet" href="assets/css/datepicker/datetimepicker.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-select.min.css" />
		
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
		<script src="assets/js/datepicker/bootstrap-datetimepicker.js"></script>
		<script src="assets/js/datepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		<script src="assets/js/bootstrap-select.min.js"></script>
		<script src="assets/js/defaults-zh_CN.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资源管理</a>
				</li>
				<li class="active">
					设备端口
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
								class="green icon-magnet bigger-120"></i> 端口列表 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
								<label class="col-xs-1 control-label no-padding">
									设备编码：
								</label>
                                <div class="col-sm-2">
                                    <input type="text" id="crDeviceCode" />
                                </div>
								<label class="col-xs-1 control-label no-padding">
									端口编码：
								</label>
                                <div class="col-sm-2">
                                    <input type="text" id="crName" />
                                </div>
								<label class="col-xs-1 control-label no-padding">
									端口状态：
								</label>
                                <div class="col-sm-2">
									<select id="cdStatus" class="form-control">
										<option role="option" value="">全部</option>
										<option role="option" value="1">正常</option>
										<option role="option" value="2">损坏</option>
										<option role="option" value="3">保留</option>
									</select>
                                </div>
                                <div class="col-sm-2">
                                    <input type="button" class="btn btn-sm btn-primary pull-left" style="" id="btn_inquiry" value="查询" />
                                </div>
                            </div>
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											设备编码
										</th>
										<th>
											端口编码
										</th>
										<th>
											状态
										</th>
										<th>
											入线设备
										</th>
										<th>
											入线端口
										</th>
										<th>
											业务
										</th>
										<th>
											业务号
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


		<!-- 模态框 -->
		<div class="modal fade" id="dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:70%;">
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
									设备编码：
								</label>
								<div class="col-xs-4">
									<input type="text" id="deviceCode" class="form-control" readonly/>
								</div>
								<label class="col-xs-2 control-label no-padding">端口编码：</label>
								<div class="col-xs-4">
									<input type="text" id="portCode" class="form-control" readonly/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">状态：</label>
								<div class="col-xs-4">
									<select id="status" class="form-control">
										<option role="option" value="1">正常</option>
										<option role="option" value="2">损坏</option>
										<option role="option" value="3">保留</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">承载业务：</label>
								<div class="col-xs-4">
									<input type="text" id="bearing" class="form-control" readonly/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">入线设备：</label>
								<div class="col-xs-4">
									<input type="text" id="parentDeviceCode" class="form-control" readonly/>
								</div>
								<label class="col-xs-2 control-label no-padding">入线端口：</label>
								<div class="col-xs-4">
									<input type="text" id="parentPortCode" class="form-control" readonly/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">业务号：</label>
								<div class="col-xs-4">
									<input type="text" id="businessKey" class="form-control" readonly/>
								</div>
								<label class="col-xs-2 control-label no-padding">备注：</label>
								<div class="col-xs-4">
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
		
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		
        // 初始化页面控件
        $(function () {
       	});
       	
        var table_view;
        var criteria = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "resDevicePort!findByPage.do",
            	"data": criteria,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "deviceCode"},
    			{"mDataProp": "portCode"},
    			{"mDataProp": "statusDesc"},
    			{"mDataProp": "parentDeviceCode"},
    			{"mDataProp": "parentPortCode"},
    			{"mDataProp": "bearingDesc"},
    			{"mDataProp": "businessKey"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 7,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "green", "icon": "pencil"}
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
        $("#btn_inquiry").click(function() { 
        	criteria = {
        		"obj.deviceCode": $("#crDeviceCode").val(),
        		"obj.portCode": $("#crPortCode").val(),
        		"obj.status": $("#crStatus").val()
        	};
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
        });
        
        $("#save").click(function() {
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.status": $("#status").val(),
    			"obj.remark": $("#remark").val()
        	};
        	var resData = ajaxCRUD("resDevicePort!update.do", parm, true);
        	if (resData.resNum == "0") {
				//table_view.fnSettings().ajax.data = {}; 
				table_view.api().ajax.reload();
				$("#dlg").modal("hide");
        	}
        });
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
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
        	$("#deviceCode").val(obj.deviceCode);
        	$("#portCode").val(obj.portCode);
        	$("#status").val(obj.status);
        	$("#bearBusiness").val(obj.bearingDesc);
        	$("#parentDeviceCode").val(obj.parentDeviceCode);
        	$("#parentPortCode").val(obj.parentPortCode);
        	$("#businessKey").val(obj.businessKey);
        	$("#remark").val(obj.remark);
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
			// alert(userName);
        </script>
	</body>
</html>
