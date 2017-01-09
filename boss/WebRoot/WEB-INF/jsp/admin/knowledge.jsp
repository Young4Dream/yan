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
<script src="webjs/ueditor1_4_3_3/ueditor.all.min.js"></script>
<script src="webjs/ueditor1_4_3_3/ueditor.config.js"></script>
<script src="webjs/ueditor1_4_3_3/ueditor.parse.min.js"></script>

</head>

<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="#">业务受理</a></li>
			<li class="active">知识库</li>
		</ul>
		<!-- .breadcrumb -->
	</div>
	<div class="page-content">

		<div id="user-profile-2" class="user-profile">
			<div class="tabbable">
				<ul class="nav nav-tabs padding-18">
					<li class="active"><a id="knowList" data-toggle="tab" href="#knowledge">
							<i class="green icon-user bigger-120"></i> 知识列表 </a></li>
					<li><a id="knowEdit" data-toggle="tab" href="#addKnow"> <i
							class="green icon-group bigger-120"></i> 添加知识 </a></li>

					<li><a id="knowClassManager" data-toggle="tab" href="#knowClass"> <i
							class="green icon-group bigger-120"></i> 种类管理 </a></li>
					<li><a data-toggle="tab" href="#showQuestion"> <i
							class="green icon-group bigger-120"></i> 查看问题 </a></li>
				</ul>

				<div class="tab-content no-border padding-10">
<!-- ----------------------------------查看问题列表开始------------------------------------- -->
					<div id="showQuestion" class="tab-pane">
						

						<table id="QuestionTable"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>问题描述</th>
									<th>提交者</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
<!-- ----------------------------------查看问题列表结束------------------------------------- -->
<!-- ----------------------------------知识列表开始------------------------------------- -->
					<div id="knowledge" class="tab-pane in active">
						<div class="table-search">
							<div class="col-sm-12" style="padding-bottom: 5px;">
								<div class='col-sm-6'>
									<label class="control-label no-padding-right"> 关键字: </label> <input
										style="width:300px" type="text" class="input-small" id="quTitle">
								</div>
								<div class='col-sm-6'>
									<label class="control-label no-padding-right"> 所属种类: </label> <select
										calss="input-sm" id="quKnowClassByKnow"
										style="width:200px;position:relative;left:-3px;">
										<option role="option" value="0">&nbsp;&nbsp;</option>
									</select>
								</div>

							</div>

							<div class="col-sm-12">
								<div class="col-sm-6">
									<button type="submit" id="knowSearch"
										class="btn btn-sm btn-primary pull-right">查询</button>
								</div>
								<div class="col-sm-6">
									<button type="submit" id="submitKnowBtn"
										class="btn btn-sm btn-primary pull-left">提交问题</button>
								</div>
							</div>
							
						</div>
						<br>

						<table id="knowTable"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>标题</th>
									<th>所属种类</th>
									
									<th>操作</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
<!-- ----------------------------------知识列表结束------------------------------------- -->

<!-- ----------------------------------添加或更新知识页面开始---------------------------------- -->
<div id="addKnow" class="tab-pane">
	<div class="col-sm-12">
		<div class="table-search">
			<div class="col-sm-12 no-padding-left tablesearch">
				<div class="col-sm-12" style="padding-bottom: 0px;">
					<div class='col-sm-6'>
					<input type="hidden" id="knowId"/>
						<label class="control-label no-padding-right">标题:
						</label> <input style="width:300px" type="text" class="input-small"
							 id="knowName">
					</div>

					<div class='col-sm-6'>
						<label class="control-label no-padding-right"
							for="form-field-1">所属种类: </label> <select style="width:200px" calss="input-sm" id="knowOfClass">
							<option role="option" value="-1">&nbsp;&nbsp;</option>

						</select>
					</div>
				</div>
				<div class="col-sm-12" style="padding:10px 0px 0px 25px;">
				
				<script id="container" name="content" type="text/plain"></script>
					<script type="text/javascript"
						src="${pageContext.request.contextPath}/webjs/ueditor1_4_3_3/ueditor.config.js"></script>
					<script type="text/javascript"
						src="${pageContext.request.contextPath}/webjs/ueditor1_4_3_3/ueditor.all.js"></script>

					
				</div>
				<div class="col-sm-12" style="padding-bottom: 5px;">
					<button type="submit" id="kaddbutton"
					class="btn btn-sm btn-primary pull-right">提交</button>
				</div>
			</div>
		</div>


	</div>
</div>
<!-- ----------------------------------添加或更新知识页面结束------------------------------ -->

<!-- ----------------------------------知识种类首页开始---------------------------------- -->
					<div id="knowClass" class="tab-pane">
						<div class="col-sm-12">
							<div class="table-search">
								<div class="col-sm-12 no-padding-left tablesearch">
									<div class="col-sm-12" style="padding-bottom: 5px;">
										<div class='col-sm-6'>
											<label class="control-label no-padding-right"> 种类名称:
											</label> <input type="text" style="width:300px" class="input-small"
												name="deptInfo.deptName" id="dseName">
										</div>

										<div class='col-sm-6'>
											<label class="control-label no-padding-right"
												for="form-field-1"> 所属种类: </label> <select
												name="deptInfo.parentId" style="width:200px" calss="input-sm" id="dseParentId">
												<option role="option" value="-1">&nbsp;&nbsp;</option>

											</select>
										</div>
									</div>
									<div class="col-sm-12">
										<div class="col-sm-6">
											<button type="submit" id="dsearch"
												class="btn btn-sm btn-primary pull-right">查询</button>
										</div>
										<div class="col-sm-6">
											<button type="submit" id="kcaddbutton"
												class="btn btn-sm btn-primary pull-left">添加</button>
										</div>
									</div>
								</div>
							</div>
							<br> <br>

							<table id="knowClassTable"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>种类名称</th>
										<th>父部门</th>
										<th>排序序号</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
<!-- ----------------------------------知识种类首页结束---------------------------------- -->
				</div>
			</div>
		</div>
	</div>
<!-- ----------------------------------提交问题页面开始---------------------------------- -->
	<div class="modal fade" id="questionModel" tabindex="-1"
		role="dialog" aria-labelledby="eModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="questionModalLabel"></h4>
				</div>
				<div class="modal-body">
					<input type="hidden" id="subUser" value="${sessionScope.userInfo.userName}"/>
					<textarea id="questionText" rows="" cols="100%"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-primary " id="questionSave">
						提交</button>
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">关闭</button>
				</div>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
<!-- ----------------------------------提交问题页面结束------------------------------ -->
	<!-- ----------------------------知识种类模态框开始 ------------------------------>
	<div class="modal fade" id="knowledgeClassModel" tabindex="-1"
		role="dialog" aria-labelledby="eModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="kcModalLabel"></h4>
				</div>

				<input type="hidden" id="kcflag" value=""> <input
					type="hidden" id="kcmodalId" name="knowledgeClass.klcId" value="">
				<div class="modal-body">
					<table class="modal-table" cellspacing="0" cellpadding="0"
						border="0">
						<tbody>
							<tr rowpos="1" class="FormData" id="">
								<td class="CaptionTD">种类名称</td>
								<td class="DataTD"><input type="text" id="kcmodalName"
									name="knowledgeClass.klcName" class=""></td>
								<td class="CaptionTD">上级种类</td>
								<td class="DataTD"><select name="deptInfo.parentId"
									calss="input-sm" id="kcmodalparent">
										<option role="option" value="">&nbsp;&nbsp;</option>

								</select></td>
								<td class="CaptionTD">排序序号</td>
								<td class="DataTD"><input type="text" id="klcOrder"
									name="knowledgeClass.klcOrder" class=""></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-primary " id="kcsave">
						提交</button>
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ----------------------------知识种类模态框结束 ------------------------------>
	
<!-- ----------------------------问题详情模态框开始 ------------------------------>
	<div class="modal fade" id="quDeModel" tabindex="-1"
		role="dialog" aria-labelledby="eModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="quDeModalLabel"></h4>
				</div>
				<div class="modal-body">
				<div class="col-sm-12" style="padding-bottom: 0px;">
					<label>提交者:&nbsp;&nbsp;</label> 
					<input type="text" id="quDeUser" disabled/>
				</div>
				<div id="quContent" style="padding-left: 15px;">
				
				</div>
				</div>
				<br/><br/><br/>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ----------------------------问题详情模态框结束 ------------------------------>
	
	<!-- ----------------------------知识详情模态框开始 --------------------------------->
	<div class="modal fade" id="knowledgeDetailModel" tabindex="-1"
		role="dialog" aria-labelledby="kModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:90%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="kTitleModalLabel"></h4>
				</div>
				
				<input type="hidden" id="kflag" value=""> <input
					type="hidden" id="kmodalId" name="knowledge.klId" value="">
				<div class="modal-body">
				<div class="col-sm-6" style="padding-bottom: 0px;">
					<label>标题：</label> 
					<input type="text" id="kmodalName" name="knowledge.klTitle" disabled class=""/>
				</div>
				<div class="col-sm-6" style="padding-bottom: 0px;">
					<label>所属种类：</label>
					<input type="text" id="kmodalClass" disabled class=""/>
				</div>
				<div id="klContent" style="padding-left: 15px;">
					
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ----------------------------知识详情模态框结束 ------------------------------>
	<!-- scripts -->
	<script src="assets/js/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/bootbox.js"></script>
	<script type="text/javascript" src="assets/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript"
		src="assets/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="assets/js/crud/crud.js"></script>
	<script src="assets/js/jquery.dataTables.js"></script>
	<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="assets/js/handlebars-v3.0.1.js"></script>
	<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="webjs/admin/knowledge.js"></script>

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
