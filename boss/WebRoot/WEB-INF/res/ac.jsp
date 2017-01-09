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
					自控日志
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
                            			<i class="icon-indent-right blue bigger-110"></i>
                            			自控日志
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
                            					<option value="0">确认</option>
                            					<option value="1">生成指令</option>
                            					<option value="2">执行</option>
                            					<option value="9">完成</option>
                            					<option value="91">空指令</option>
                            					<option value="98">失败重试</option>
                            					<option value="99">失败</option>
                            				</select>
                            				<select id="crBusinessType">
                            				</select>
                            				<select id="crOssKey">
                            				</select>
                            				<input class="" id="crBusinessKey" type="text" placeholder="电话、账号、业务号" style="width:200px"/>
                            				<button class="btn btn-sm btn-success btn-white btn-round" id="btnInquiry">
                            					<i class="icon-search green"></i>
                            					查询
                            				</button>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
										<table id="table_view" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>业务号</th>
													<th>指令</th>
													<th>指令名称</th>
													<th>生成时间</th>
													<th>执行时间</th>
													<th>状态</th>
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

		<script type="text/javascript">
		
        var table_view;
        var criteria = {};

    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(document).ready(function() {
			loadRef("ref_business_type", "crBusinessType", "--业务类型--");
			loadRef("ref_oss_key", "crOssKey", "--指令--");
			initTableView();
			$('#table_view tbody').on('click', 'td.details-control', openAcCommand);
		});
		
		function initTableView() {
			table_view = $('#table_view').dataTable({
				"serverSide": true, //服务器模式，分页用
				"ajax": {
            		"type": "post",
            		"url": "ac!findByPage.do",
            		"data": criteria,
            		"dataSrc": "lst"
            	},
        		"columns": [
            		{
                		"className":      'details-control',
                		"orderable":      false,
                		"data":           null,
                		"width": "30px",
                		"defaultContent": ''
            		},
            		{ 
            			"data": "businessKey",
            			"width": "120px",
            		},
            		{ 
            			"data": "ossKey",
            			"width": "120px",
            		},
            		{ 
            			"data": "ossKeyName",
            			"width": "120px",
            		},
            		{ 
            			"data": "createTime",
            			"width": "200px",
            		},
            		{ 
            			"data": "updateTime",
            			"width": "200px",
            		},
            		{ 
            			"data": "statusDesc",
            			"width": "100px",
            		},
            		{ 
            			"data": "null",
            			"width": "*",
                		"defaultContent": ''
            		},
            	],
				columnDefs: [{
                    targets: 7,
                    render: function (a, b, c, d) {
                    	var fs = [];
                    	if (c.status > 1) {
                    		fs.push({"fn": "reset('" + c.id + "')", "color": "red", "icon": "refresh", "tooltip": "重置执行"});
                    	}
                        var context = {func: fs};
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
		
		var openAcCommand = (function() {
			var tr = $(this).closest('tr');
    		var row = table_view.api().row( tr );
 
    		if ( row.child.isShown() ) {
    			// This row is already open - close it
        		row.child.hide();
        		tr.removeClass('shown');
    		} else {
    			// Open this row
        		row.child(getAcCommand(row.data())).show();
        		tr.addClass('shown');
			}
		});
		
		function getAcCommand(d) {
			var res = ajaxCRUD("ac!findCmdsByActId.do", {"id": d.id}, false);
			var lst = res.lst;
			var content = '<table cellpadding="0" cellspacing="0" border="0" >'
						+ '<tr><td>#</td><td>设备</td><td>指令</td><td>结果码</td><td>结果描述</td></tr>';
			for (var i = 0; i < lst.length; i++) {
				var item = lst[i];
				//alert(item.cmd.substr(0, 50));
				var cmd = "";
				if (item.cmd.length < 50) {
					cmd = item.cmd;
				} else {
					cmd = '<a href="#" onclick="showCmd(\'' + item.cmd + '\')">' + item.cmd.substr(0, 50) + '</a>';
				}
				content += '<tr>' +
						   		'<td>' + (i + 1) + '</td>' +
						   		'<td>' + item.deviceCode + '</td>' +
						   		'<td>' + cmd + '</td>' +
						   		'<td>' + (item.retCode == null ? "" : item.retCode) + '</td>' +
						   		'<td>' + (item.retDesc == null ? "" : item.retDesc.substr(0, 50)) + '</td>' +
						   '</tr>'
			}
			content += '</table>';
			return content;
		}
		
		function showCmd(cmd) {
			// 将TAB键转为换行
			var newCmd = cmd.replace(/\t+/g, "\n");
			// 两个以上的空格也转为换行
			newCmd = newCmd.replace(/\s{2,}/g, "\n");
			alert(newCmd);
		}
		
		function reset(id) {
			var res = ajaxCRUD("ac!reset.do", {"id": id}, true);
			if (res.resNum == "0") {
				table_view.api().ajax.reload();
			}
		}
		
		$("#btnInquiry").click(function() {
			criteria = {};
			if ($("#crOssKey").val() != "") {
				criteria["obj.ossKey"] = $("#crOssKey").val();
			}
			if ($("#crBusinessKey").val() != "") {
				criteria["obj.businessKey"] = $("#crBusinessKey").val();
			}
			if ($("#crStatus").val() != "") {
				criteria["obj.status"] = $("#crStatus").val();
			}
			if ($("#crBusinessType").val() != "") {
				criteria["obj.businessType"] = $("#crBusinessType").val();
			}
			table_view.fnSettings().ajax.data = criteria; 
			table_view.api().ajax.reload();
		});
		
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
