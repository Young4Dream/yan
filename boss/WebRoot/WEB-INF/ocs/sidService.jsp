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
					业务
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
								class="green icon-beer bigger-120"></i> 业务列表 </a>
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
											名称
										</th>
										<th>
											业务类型
										</th>
										<th>
											呼叫类型
										</th>
										<th>
											带宽
										</th>
										<th>
											单位
										</th>
										<th>
											计次数量
										</th>
										<th>
											成本价
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
									<font color="green"><b>名称：</b></font>
								</label>
								<div class="col-xs-4">
									<input type="text" id="name" name="obj.name" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									<font color="green"><b>业务类型：</b></font>
								</label>
								<div class="col-xs-4">
									<select name="obj.categoryId" calss="input-sm" id="categoryId" style="width:93%;">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">呼叫类型：</label>
								<div class="col-xs-4">
									<select name="obj.voiceId" calss="input-sm" id="voiceId" style="width:93%;">
									</select>
								</div>
								<label class="col-xs-2 control-label no-padding">带宽：</label>
								<div class="col-xs-4">
									<select name="obj.dataId" calss="input-sm" id="dataId" style="width:93%;">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">计量单位：</label>
								<div class="col-xs-4">
									<input type="text" id="meterName" name="obj.meterName" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">计次数量：</label>
								<div class="col-xs-4">
									<input type="text" id="meterCount" name="obj.meterCount" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">成本价：</label>
								<div class="col-xs-4">
									<input type="text" id="debitPrice" name="obj.debitPrice" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">备注：</label>
								<div class="col-xs-4">
									<input type="text" id="remark" name="obj.remark" class="" style="width:93%;"/>
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
	    $(document).ready(function(){
			loadDictData();
		});
		
		function loadDictData() {
			// 载入业务类别
			var res = ajaxCRUD("sidServiceCategory!findAll.do", {}, false);
			var lst = res.lst;
			var html = "<option role=\"option\" value=\"\">--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role=\"option\" value=\"" + item.id + "\">" + item.name + "</option>";
			});
			$("#categoryId").append(html);
			// 载入呼叫类型
			res = ajaxCRUD("sidVoiceConfig!findAll.do", {}, false);
			lst = res.lst;
			var html = "<option role=\"option\" value=\"\">--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role=\"option\" value=\"" + item.id + "\">" + item.name + "</option>";
			});
			$("#voiceId").append(html);
			// 载入宽带
			res = ajaxCRUD("sidDataConfig!findAll.do", {}, false);
			lst = res.lst;
			var html = "<option role=\"option\" value=\"\">--请选择--</option>";
			$(lst).each(function(index) {
				var item = lst[index];
				html += "<option role=\"option\" value=\"" + item.id + "\">" + item.name + "</option>";
			});
			$("#dataId").append(html);
		}
	
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidService!selectByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "name"},
    			{"mDataProp": "categoryName"},
    			{"mDataProp": "voiceName"},
    			{"mDataProp": "dataName"},
    			{"mDataProp": "meterName"},
    			{"mDataProp": "meterCount"},
    			{"mDataProp": "debitPrice"},
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
        
        $("#save").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入业务名称");
        		return;
        	}
        	if ($("#categoryId").val() == "") {
        		alert("请选择业务分类");
        		return;
        	}
        	
        	var parm = {
    			"obj.id": $("#id").val(),
    			"obj.name": $("#name").val(),
    			"obj.categoryId": $("#categoryId").val(),
    			"obj.voiceId": $("#voiceId").val(),
    			"obj.dataId": $("#dataId").val(),
    			"obj.meterName": $("#meterName").val(),
    			"obj.meterCount": $("#meterCount").val(),
    			"obj.debitPrice": $("#debitPrice").val(),
    			"obj.remark": $("#remark").val()
        	};
        	var flag = $("#flag").val();
        	
        	var resData;
        	if (flag == "add") {
        		resData = ajaxCRUD("sidService!insert.do", parm, true);
        	} else {
        		resData = ajaxCRUD("sidService!update.do", parm, true);
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
					    var resData = ajaxCRUD("sidService!delete.do", parm, true);
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
        	$("#categoryId").val(obj.categoryId);
        	$("#voiceId").val(obj.voiceId);
        	$("#dataId").val(obj.dataId);
        	$("#meterName").val(obj.meterName);
        	$("#meterCount").val(obj.meterCount);
        	$("#debitPrice").val(obj.debitPrice);
        	$("#remark").val(obj.remark);
        }

    	function clear() {
    		$("#id").val("");
        	$("#name").val("");
        	$("#categoryId").val("");
        	$("#voiceId").val("");
        	$("#dataId").val("");
        	$("#meterName").val("");
        	$("#meterCount").val("1");
        	$("#debitPrice").val("0");
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
