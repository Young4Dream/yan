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
					<a href="#">后台管理</a>
				</li>
				<li class="active">
					技能管理
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">

				<div id="user-profile-2" class="user-profile">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-18">
							<li class="active">
								<a data-toggle="tab" href="#skill"> 
									<i class="green icon-user bigger-120"></i> 
									技能列表 
								</a>
							</li>

							<li>
								<a data-toggle="tab" href="#skillGroup"> 
									<i class="green icon-group bigger-120"></i> 
									技能组列表 
								</a>
							</li>

						</ul>

						<div class="tab-content no-border padding-24">
							<div id="skill" class="tab-pane in active">
								<div class="col-sm-10">
								
								
							<div class="padding-10" style="border:1px solid #ddd;">
							<div class=" no-padding-left">
								<div class='col-sm-6'>
									<label class="control-label no-padding-right" >技能编号:</label>
										<input type="text" class="input-small" name="employeeInfo.employeeNo" id="eseemplNo">
								</div>
								
								<div class='col-sm-6'>
									<label class="control-label no-padding-right" >技能名称:</label>
										<input type="text" class="input-small" name="employeeInfo.name" id="eseemplName">
								</div>
								
							</div>
							
							<div class="">
								<button type="submit" id="ssearch" class="btn btn-sm btn-primary pull-center">查询</button>

								<button type="submit" id="saddbutton" class="btn btn-sm btn-primary pull-center">添加</button>
							</div>
						</div>
									
									<table id="emplTable" class="table table-striped table-bordered table-hover">
									<thead>
									<tr>
										<th>技能编号</th>
										<th>技能名称</th>
										<th>技能类型</th>
										<th>技能URL</th>
										<th>所属技能组</th>
										<th>操作</th>
									</tr>	
									</thead>
									<tbody></tbody>
									</table>
								</div>
							
								<div class="col-sm-2">
									<div class="zTreeDemoBackground ">
										<ul id="treeDemo" class="ztree"></ul>
									</div>
								</div>
							</div>
							<!-- #home -->


							<div id="skillGroup" class="tab-pane">
								<div class="col-sm-12">
								
								
							<div class="padding-10" style="border:1px solid #ddd;padding:20px 20px 10px 20px">
								<div class='col-sm-6'>
									<label class="control-label no-padding-right" >技能组名称:</label>
										<input type="text" class="input-small" name="deptInfo.deptName" id="dseName">
								</div>
								
								<div class='col-sm-6'>
									<label class="control-label no-padding-right" for="form-field-1">上级技能组:</label>
									<select name="deptInfo.parentId" calss="input-sm" id="dseParentId">
										<option role="option" value="-1">&nbsp;&nbsp;</option>
										
									</select>
								</div>
							
							<div class="col-sm-6">
								<button type="submit" id="gsearch" class="btn btn-sm btn-primary pull-center">查询</button>

								<button type="submit" id="gaddbutton" class="btn btn-sm btn-primary pull-center">添加</button>
							</div>
						</div>
								
									<table id="deptTable" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
										<th>技能组名称</th>
										<th>父技能组</th>
										<th>操作</th>
										</tr>	
									</thead>
									<tbody></tbody>
									</table>
								</div>
							</div>
							<!-- /#feed -->
						</div>
					</div>
				</div>
		</div>


<!-- 模态框（emplModal） -->
<div class="modal fade" id="skillModal" tabindex="-1" role="dialog" aria-labelledby="eModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="sModalLabel">
               	
            </h4>
         </div>

  		 <input type="hidden" id="sflag" value="">
  		 <input type="hidden" id="smodalSkillId" name="" value="">
         <div class="modal-body">
         <table class="modal-table" cellspacing="0" cellpadding="0" border="0">
		 <tbody>
			<tr rowpos="1" class="FormData" id="">
				<td class="CaptionTD">工号</td>
				<td class="DataTD"><input type="text" id="emodalEmplNo" name="" class=""></td>
				<td class="CaptionTD">姓名</td>
				<td class="DataTD"><input type="text" id="emodalName" name="" class=""></td>
			</tr>
			
			<tr rowpos="2" class="FormData" id="">
				<td class="CaptionTD">密码</td>
				<td class="DataTD"><input type="text" id="emodalPw" name="" class=""></td>
				<td class="CaptionTD">员工类型</td>
				<td class="DataTD"><input type="text" id="emodalType" name="" class=""></td>
			</tr>
			
			<tr rowpos="3" class="FormData" id="">
				<td class="CaptionTD">所属部门</td>
				<td class="DataTD">
				<select name="employeeInfo.deptId" calss="input-sm" id="emodalDeptId">		
				</select>
				</td>
				<td class="CaptionTD">员工性别</td>
				<td class="DataTD">
					<select name="employeeInfo.gender" calss="input-sm" id="emodalGender">
						<option role="option" value="1">男</option>		
						<option role="option" value="0">女</option>		
					</select>
				</td>
			</tr>
			
			<tr rowpos="4" class="FormData" id="">
				<td class="CaptionTD">年龄</td>
				<td class="DataTD"><input type="text" id="emodalAge" name="employeeInfo.age" class=""></td>
				<td class="CaptionTD">生日</td>
				<td class="DataTD"><input type="text" id="emodalBirthday" name="employeeInfo.birthday" class="date-picker" data-date-format="yyyy-mm-dd"></td>
			</tr>
			
			<tr rowpos="5" class="FormData" id="">
				<td class="CaptionTD">联系电话</td>
				<td class="DataTD"><input type="text" id="emodalTel" name="employeeInfo.tel" class=""></td>
				<td class="CaptionTD">手机</td>
				<td class="DataTD"><input type="text" id="emodalMobile" name="employeeInfo.mobile" class=""></td>
			</tr>
			
			<tr rowpos="6" class="FormData" id="">
				<td class="CaptionTD">Email</td>
				<td class="DataTD"><input type="text" id="emodalEmail" name="employeeInfo.email" class=""></td>
				<td class="CaptionTD">证件号</td>
				<td class="DataTD"><input type="text" id="emodalCertificateId" name="employeeInfo.certificateId" class=""></td>
			</tr>
			
			<tr rowpos="7" class="FormData" id="">
				<td class="CaptionTD">是否是座席</td>
				<td class="DataTD">
					<select name="employeeInfo.isAgent" calss="input-sm" id="emodalIsAgent">
						<option role="option" value="1">是</option>		
						<option role="option" value="0">否</option>		
					</select>
				</td>
				
				<td class="CaptionTD">管辖部门</td>
				<td class="DataTD"><input type="text" id="emodalMonitorDept" name="employeeInfo.monitorDept" class=""></td>
			</tr>

			<tr rowpos="8" class="FormData" id="">
				<td class="CaptionTD">入职日期</td>
				<td colspan="3" class="DataTD">
					<input type="text" id="emodalJoinDate" name="employeeInfo.joinDate" value="" class="date-picker" data-date-format="yyyy-mm-dd">
					
				</td>
			</tr>
			
		 </tbody>
		 </table>
         </div>
         <div class="modal-footer">
         	<button type="button"  class="btn btn-sm btn-primary " id="esave">
              	 提交
    		</button>
            <button type="button" class="btn btn-sm btn-default" 
               data-dismiss="modal">关闭
            </button>
         </div>

         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>

<div class="modal fade" id="groupsModal" tabindex="-1" role="dialog" aria-labelledby="eModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="dModalLabel">
            </h4>
         </div>

  		 <input type="hidden" id="gflag" value="">
  		 <input type="hidden" id="gmodalgroupId" name="" value="">
         <div class="modal-body">
         <table class="modal-table" cellspacing="0" cellpadding="0" border="0">
		 <tbody>
			<tr rowpos="1" class="FormData" id="">
				<td class="CaptionTD">技能组名称</td>
				<td class="DataTD"><input type="text" id="gmodalName" name="" class=""></td>
				<td class="CaptionTD">上级技能组</td>
				<td class="DataTD">
					<select name="" calss="input-sm" id="gmodalparent">
						<option role="option" value="0">&nbsp;&nbsp;</option>		
					</select>
				</td>
			</tr>
		 </tbody>
		 </table>
         </div>
         <div class="modal-footer">
         	<button type="button"  class="btn btn-sm btn-primary " id="gsave">
              	 提交
    		</button>
            <button type="button" class="btn btn-sm btn-default" 
               data-dismiss="modal">关闭
            </button>
         </div>

         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
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
		<script src="webjs/admin/deptEmployeeConf.js"></script>
		
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
		</script>
	</body>
</html>
