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
		<!-- BootstrapDialog -->
		<link rel="stylesheet" href="assets/css/bootstrap-dialog.min.css" />
		
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		
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
		<script src="assets/js/bootstrap-dialog.min.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon green"></i>
					<a href="#">流程管理</a>
				</li>
				<li class="active">
					流程历史
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
								class="green icon-book bigger-120"></i> 已完成的流程 </a>
						</li>
					</ul>

					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
                                <div>
                                </div>
                            </div>
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>
											流程标识
										</th>
										<th>
											流程名称
										</th>
										<th>
											客户名称
										</th>
										<th>
											号码
										</th>
										<th>
											发起人
										</th>
										<th>
											发起时间
										</th>
										<th>
											结束时间
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

		<script type="text/javascript">
		
		/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(function() {
			$("[data-toggle='tooltip']").tooltip();
		});
		
        var table_view;
        var op = "${sessionScope.userInfo.userName}";
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "task!findFinishedByPage.do",
            	"data": {},
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "processDefinitionKey"},
    			{"mDataProp": "processDefinitionName"},
    			{"mDataProp": "customerName"},
    			{"mDataProp": "userKey"},
    			{"mDataProp": "originator"},
    			{"mDataProp": "originateTime"},
    			{"mDataProp": "instanceEndTime"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 7,
                    render: function (a, b, c, d) {
                    	var func = [];
                    	func.push({"fn": "viewUserInfo(" + JSON.stringify(c) + ")", "color": "blue", "icon": "user-md", "tooltip": "查看用户信息"});
                        var context =
                        {
                            "func": func 
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
		
		// 查看用户信息
		function viewUserInfo(obj) {
			loadCustomerInfo(obj.customerId);
			loadAccountInfo(obj.customerId);
			loadUserInfo(obj.userId);
			loadOrderInfo(obj);
			$("#dlgUserInfo").modal("show");
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
        
		<jsp:include page="../pub/userInfo.jsp" flush="true"/>
		<jsp:include page="../pub/jobOpForm.jsp" flush="true"/>
		
	</body>
</html>
