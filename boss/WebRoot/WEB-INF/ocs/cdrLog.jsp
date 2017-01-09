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
					分拣日志
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
								class="green icon-bookmark-empty bigger-120"></i> 日志列表 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                    <br/>
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											主机
										</th>
										<th>
											文件名
										</th>
										<th>
											状态
										</th>
										<th>
											话单数
										</th>
										<th>
											异常话单数
										</th>
										<th>
											采集时间
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
									主机：
								</label>
								<div class="col-xs-4">
									<input type="text" id="host" name="obj.host" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">文件名：</label>
								<div class="col-xs-4">
									<input type="text" id="filename" name="obj.filename" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">源目录：</label>
								<div class="col-xs-4">
									<input type="text" id="sourceDirectory" name="obj.sourceDirectory" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">缓存文件：</label>
								<div class="col-xs-4">
									<input type="text" id="cachedDirectory" name="obj.cachedDirectory" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">存档文件：</label>
								<div class="col-xs-4">
									<input type="text" id="archiveDirectory" name="obj.archiveDirectory" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">解码器：</label>
								<div class="col-xs-4">
									<input type="text" id="decoderName" name="obj.decoderName" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									状态：
								</label>
								<div class="col-xs-4">
									<input type="text" id="flag" name="obj.flag" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									话单数：
								</label>
								<div class="col-xs-4">
									<input type="text" id="recordCount" name="obj.recordCount" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									异常话单数：
								</label>
								<div class="col-xs-4">
									<input type="text" id="abnormalCount" name="obj.abnormalCount" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">采集时间：</label>
								<div class="col-xs-4">
									<input type="text" id="createTime" name="obj.createTime" class="" style="width:93%;"/>
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
            	"url": "cdrLog!selectByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "host"},
    			{"mDataProp": "filename"},
    			{"mDataProp": "flagDesc"},
    			{"mDataProp": "recordCount"},
    			{"mDataProp": "abnormalCount"},
    			{"mDataProp": "createTime"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
			"bLengthChange": false,//
			"iDisplayLength" :12,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#host").val(obj.host);
        	$("#filename").val(obj.filename);
        	$("#sourceDirectory").val(obj.sourceDirectory);
        	$("#cachedDirectory").val(obj.cachedDirectory);
        	$("#archiveDirectory").val(obj.archiveDirectory);
        	$("#decoderName").val(obj.decoderName);
        	$("#flag").val(obj.flagDesc);
        	$("#recordCount").val(obj.recordCount);
        	$("#abnormalCount").val(obj.abnormalCount);
        	$("#createTime").val(obj.createTime);
        }

    	function clear() {
    		$("#id").val("");
        	$("#host").val("");
        	$("#filename").val("");
        	$("#sourceDirectory").val("");
        	$("#cachedDirectory").val("");
        	$("#archiveDirectory").val("");
        	$("#decoderName").val("");
        	$("#flag").val("");
        	$("#recordCount").val("");
        	$("#abnormalCount").val("");
        	$("#createTime").val("");
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
