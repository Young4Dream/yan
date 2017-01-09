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
					<a href="#">话单分拣</a>
				</li>
				<li class="active">
					话单网元
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
								class="green icon-briefcase bigger-120"></i> 网元列表 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
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
											网元名称
										</th>
										<th>
											协议
										</th>
										<th>
											主机
										</th>
										<th>
											端口
										</th>
										<th>
											登录名
										</th>
										<th>
											源目录
										</th>
										<th>
											解码器
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
									<font color="green"><b>网元名称：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="name" name="cdrSource.name" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">连接协议：</label>
								<div class="col-xs-4">
									<select name="cdrSource.protocol" calss="input-sm" id="protocol" style="width:93%" >
										<option role="option" value="local">
											本地
										</option>
										<option role="option" value="ftp">
											ftp
										</option>
										<option role="option" value="sftp">
											sftp
										</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">主机：</label>
								<div class="col-xs-4">
									<input type="text" id="host" name="cdrSource.host" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">端口：</label>
								<div class="col-xs-4">
									<input type="text" id="port" name="cdrSource.port" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">用户名：</label>
								<div class="col-xs-4">
									<input type="text" id="userName" name="cdrSource.userName" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">密码：</label>
								<div class="col-xs-4">
									<input type="text" id="pwd" name="cdrSource.pwd" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>源目录：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="sourceDirectory" name="cdrSource.sourceDirectory" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>缓存目录：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="cachedDirectory" name="cdrSource.cachedDirectory" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>归档目录：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="archiveDirectory" name="cdrSource.archiveDirectory" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">解码器：</label>
								<div class="col-xs-4">
									<select name="cdrSource.decoderName" calss="input-sm" id="decoderName" style="width:93%;">
										<option role="option" value="MGCF">
											MGCF
										</option>
										<option role="option" value="ATS">
											ATS
										</option>
										<option role="option" value="MediaX">
											MediaX
										</option>
										<option role="option" value="CC08">
											CC08
										</option>
										<option role="option" value="CC08_66">
											CC08_66
										</option>
										<option role="option" value="ZTE">
											ZTE
										</option>
										<option role="option" value="EWSD">
											EWSD
										</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">文件过滤：</label>
								<div class="col-xs-4">
									<input type="text" id="filenamePattern" name="cdrSource.filenamePattern" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">集采模式：</label>
								<div class="col-xs-4">
									<select name="cdrSource.collectMode" calss="input-sm" id="collectMode" style="width:93%;">
										<option role="option" value=1>
											删除源文件
										</option>
										<option role="option" value=2>
											保留源文件
										</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">状态：</label>
								<div class="col-xs-4">
									<select name="cdrSource.status" calss="input-sm" id="status" style="width:93%;">
										<option role="option" value=1>
											生效
										</option>
										<option role="option" value=0>
											失效
										</option>
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">备注：</label>
								<div class="col-xs-4">
									<input type="text" id="remark" name="cdrSource.remark" class="" style="width:93%;">
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
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "cdrSource!findAll.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "protocol"},
    			{"mDataProp": "host"},
    			{"mDataProp": "port"},
    			{"mDataProp": "userName"},
    			{"mDataProp": "sourceDirectory"},
    			{"mDataProp": "decoderName"},
    			{"mDataProp": "statusDesc"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 8,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"},
                                {"fn": "showUpdateDlg("+ JSON.stringify(c) +")", "color": "red", "icon": "pencil"},
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
			"bPaginate": false,//开启分页功能
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
        
        $("#save").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入网元名称");
        		return;
        	}
        	if ($("#cachedDirectory").val() == "") {
        		alert("请输入源目录");
        		return;
        	}
        	if ($("#archiveDirectory").val() == "") {
        		alert("请输入缓存目录");
        		return;
        	}
        	if ($("#sourceDirectory").val() == "") {
        		alert("请输入存档目录");
        		return;
        	}
			var op = "${sessionScope.userInfo.userName}";
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.name": $("#name").val(),
    			"obj.protocol": $("#protocol").val(),
    			"obj.host": $("#host").val(),
    			"obj.port": $("#port").val(),
    			"obj.userName": $("#userName").val(),
    			"obj.pwd": $("#pwd").val(),
    			"obj.sourceDirectory": $("#sourceDirectory").val(),
    			"obj.cachedDirectory": $("#cachedDirectory").val(),
    			"obj.archiveDirectory": $("#archiveDirectory").val(),
    			"obj.decoderName": $("#decoderName").val(),
    			"obj.filenamePattern": $("#filenamePattern").val(),
    			"obj.collectMode": $("#collectMode").val(),
    			"obj.status": $("#status").val(),
    			"obj.creator": op,
    			"obj.remark": $("#remark").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("cdrSource!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("cdrSource!update.do", parm, true);
        	}
        	if (resData.resNum == "0") {
				table_view.fnSettings().ajax.data = {}; 
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
					    var resData = ajaxCRUD("cdrSource!delete.do", parm, true);
						if(resData.resNum == "0"){
							table_view.fnSettings().ajax.data = {}; 
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
        	$("#name").val(obj.name);
        	$("#protocol").val(obj.protocol);
        	$("#host").val(obj.host);
        	$("#port").val(obj.port);
        	$("#userName").val(obj.userName);
        	$("#pwd").val(obj.pwd);
        	$("#sourceDirectory").val(obj.sourceDirectory);
        	$("#cachedDirectory").val(obj.cachedDirectory);
        	$("#archiveDirectory").val(obj.archiveDirectory);
        	$("#decoderName").val(obj.decoderName);
        	$("#filenamePattern").val(obj.filenamePattern);
        	$("#collectMode").val(obj.collectMode);
        	$("#status").val(obj.status);
        	$("#remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#name").val("");
        	$("#protocol").val("sftp");
        	$("#host").val("");
        	$("#port").val("");
        	$("#userName").val("");
        	$("#pwd").val("");
        	$("#sourceDirectory").val("");
        	$("#cachedDirectory").val("");
        	$("#archiveDirectory").val("");
        	$("#decoderName").val("ASN.1");
        	$("#filenamePattern").val("");
        	$("#collectMode").val(1);
        	$("#status").val(0);
        	$("#remark").val("");
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
