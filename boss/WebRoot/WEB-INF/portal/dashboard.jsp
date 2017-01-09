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
		<!-- zTree -->
		<link rel="stylesheet" href="assets/css/zTreeStyle/metro.css">
		<!-- <link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" type="text/css">
		 -->
		 
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
		<!-- zTree -->
		<script src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">控制台</a>
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-12">
							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>

								<i class="icon-ok green"></i>

								欢迎使用
								<strong class="green">
									电信业务运营支撑系统
									<small> (v13.0)</small>
								</strong>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="widget-box transparent" id="notice-box">
								<div class="widget-header">
									<h4 class="widget-title lighter smaller">
										<i class="icon-rss orange"></i>系统公告
									</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-4">
										<ul id="notices" class="item-list">
											<!-- put content here -->
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="widget-box transparent" id="tasks-box">
								<div class="widget-header">
									<h4 class="widget-title lighter smaller">
										<i class="icon-tasks green"></i>待办事项
									</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-4">
										<ul id="tasks" class="item-list">
											<!-- put content here -->
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>

		<script type="text/javascript">
		
		var op = "${sessionScope.userInfo.userName}";
		
		$(document).ready(function() {
			showNotices();
			showTasks();
		});
		
		function showNotices() {
			var res = ajaxCRUD("notice!findTop10.do", {}, false);
			var lst = res.lst;
			var notices = [];
			var colors = ["orange", "green", "blue", "dark", "red"];
			for (var i = 0; i < lst.length; i++) {
				var colorIndex = i % 5;
				var obj = lst[i];
				var notice = {
					"color": colors[colorIndex],
					"id": obj.id,
					"subject": obj.subject,
					"icon": (obj.level == "critical" ? "key red" : "info-sign blue"),
					"content": obj.content,
					"createTime": obj.createTime
				};
				notices.push(notice);
			}
			if (notices.length > 0) {
				var html = template({ns: notices});
				$("#notices").empty();
				$("#notices").append(html);
			}
			$("[data-toggle='tooltip']").tooltip();
		}
		
		function showTasks() {
			var res = ajaxCRUD("task!findByPage.do", {"id": op}, false);
			var lst = res.lst;
			var tasks = [];
			var colors = ["orange", "green", "blue", "dark", "red"];
			for (var i = 0; i < lst.length; i++) {
				var colorIndex = i % 5;
				var obj = lst[i];
				var task = {
					"color": colors[colorIndex],
					"id": obj.id,
					"taskName": obj.name,
					"businessOpName": obj.businessOpName,
					"userKey": obj.userKey,
					"createTime": obj.createTime
				};
				tasks.push(task);
			}
			if (tasks.length > 0) {
				var html = template2({ts: tasks});
				$("#tasks").empty();
				$("#tasks").append(html);
			}
		}
		
		</script>
		
		<script id="tpl" type="text/x-handlebars-template">
		{{#each ns}}
		<li class="item-{{this.color}} clearfix">
			<label class="inline">
				<span class="lbl" data-toggle="tooltip" data-placement="bottom" title="{{this.content}}" >
					<i class="icon-{{this.icon}}"></i>&nbsp;{{this.subject}}
				</span>
			</label>
			<div class="pull-right easy-pie-chart percentage" data-size="30" data-color="#ECCB71" data-percent="42">
				<span class="percent">{{this.createTime}}</span>
			</div>
		</li>
		{{/each}}
		</script>

		<script id="tp2" type="text/x-handlebars-template">
		{{#each ts}}
		<li class="item-{{this.color}} clearfix">
			<label class="inline">
				<a href="task!goToPage.do">
					<span class="lbl">
						{{this.taskName}}({{this.businessOpName}} {{this.userKey}})
					</span>
				</a>
			</label>
			<div class="pull-right easy-pie-chart percentage" data-size="30" data-color="#ECCB71" data-percent="42">
				<span class="percent">{{this.createTime}}</span>
			</div>
		</li>
		{{/each}}
		</script>

		<script type="text/javascript">
            var tpl = $("#tpl").html();
            var tp2 = $("#tp2").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
            var template2 = Handlebars.compile(tp2);
        </script>
        
	</body>
</html>
