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
		<!-- page specific plugin styles -->
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- inline styles related to this page -->

		<script src="assets/js/ace-extra.min.js">
</script>
	</head>

	<body>


		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">系统管理</a>
				</li>
				<li class="active">
					用户管理
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<!--  
						<div class="table-header">
							员工查询
						</div>
					-->
			<div class="table-responsive">
				<div class="table-search">
<!--					<div class="col-sm-12 no-padding-left tablesearch">-->
						<div class="col-sm-12" style="padding-bottom: 5px;">

							<div class="col-sm-6">
								<label class="control-label no-padding-right">
									用户名:
								</label>
								<input type="text" class="input-small" name="userName" id="seuserName">
							</div>

							<div class="col-sm-6">
								<label class="control-label no-padding-right" for="form-field-1">
									用户角色:
								</label>
								<select name="ship" calss="input-sm" id="sereoleId">
									<option role="option" value="-1">
										&nbsp;&nbsp;&nbsp;
									</option>
									
								</select>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="col-sm-6">
								<button type="submit" id="search"
									class="btn btn-sm btn-primary pull-right">
									查询
								</button>
							</div>
							<div class="col-sm-6" style="display:none;">
								<button type="submit" id="addbutton"
									class="btn btn-sm btn-primary pull-left">
									添加
								</button>
							</div>
						</div>

<!--					</div>-->

				</div>
				<br>

				<table id="userTable"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>
								用户名
							</th>
							<th>
								用户角色
							</th>
							<th>
								创建时间
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
		<!-- /.table-responsive -->


		<!-- 模态框（Modal） -->
		<div class="modal fade" id="userModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							
						</h4>
					</div>
						<input type="hidden" id="modleuserId" >
						<input type="hidden" id="flag">
						<div class="modal-body">
							<table class="modal-table" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr rowpos="1" class="FormData" id="">
										<td class="CaptionTD">
											用户名
										</td>
										<td class="DataTD">
											<input type="text" id="modleuserName" name="" class="">
										</td>
										<td class="CaptionTD" style="display:none;">
											密码
										</td>
										<td class="DataTD" style="display:none;">
											<input type="password" id="modlepassword" name=""
												class="">
										</td>
									</tr>

									<tr rowpos="2" class="FormData" id="">
										<td class="CaptionTD">
											用户角色
										</td>
										<td colspan="3" class="DataTD">
											<select name="" calss="input-sm" id="modleroleId" style="position:relative;left:-3px;">
												
											</select>
										</td>

									</tr>
									<tr rowpos="3" class="FormData" id="tr_note">
										<td class="CaptionTD">
											备注
										</td>
										<td colspan="3" class="DataTD">
											<textarea rows="4" cols="20" id="modleremark" name=""
												multiline="true" class="" style="position:relative;left:-3px;"></textarea>
										</td>

									</tr>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-sm btn-primary " id="save">
								提交
							</button>
							<button type="button" class="btn btn-sm btn-default"
								data-dismiss="modal">
								关闭
							</button>
						</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- basic scripts -->
		<script src='assets/js/jquery-2.0.3.min.js'></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.dataTables.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>

		<script id="tpl" type="text/x-handlebars-template">
		<div class="action-buttons">
    	{{#each func}}
    	<a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a>
    	{{/each}}
		</div>
		</script>

		<script type="text/javascript">
			var userName = "${sessionScope.userInfo.userName}";
			var userId = "${sessionScope.userInfo.userId}";
			
	        $(document).ready(function(){
				buildRole();
			});
	
			function  buildRole(){
				var resData = ajaxCRUD("user!roleSelectList.do",{},false);//url，参数，是否弹出alert
				var roleSelect = resData.roleSelect;
				var html = "";
				$(roleSelect).each(function(index) {
					var role = roleSelect[index];
					
					//如果是admin帐号，全部加载，否则，不加载管理员跟新增用户两个角色
					if (userName != "admin")
					{
                        if (role.role_name == "管理员" || role.role_name == "新增用户")
                        {
                            return true;
                        }
					}
					html += "<option role=\"option\" value=\""+role.role_id+"\">"+role.role_name+"</option>";
				});
				$('#sereoleId').append(html);
				$('#modleroleId').append(html);
	
			}

			var param = {
				"userInfo.roleId":-1,
				"userInfo.userId":userId
			};
	        var oTable1;
	        
	        jQuery(function($){
				var tpl = $("#tpl").html();
		        //预编译模板
		        var template = Handlebars.compile(tpl);
		
	            oTable1 = $('#userTable').dataTable({
					"serverSide": true,//服务器模式，分页用
					"ajax":{
			           	"type": "post",
			           	"url": "user!userList.do",
			           	"data":param,
			           	"dataSrc":"userList"
			           },
			           "aoColumns": [ 
			   			{"mDataProp":"user_name"},
			   			{"mDataProp":"role_name"},
			   			{"mDataProp":"create_time"},
						{"mDataProp":""}
			   		],
					columnDefs: [
                        {
                            targets: 3,
                            render: function (a, b, c, d) {
	                            var context =
	                            {
	                                func: [
										{"fn": "detailWindow(" + JSON.stringify(c) + ")", "color": "blue","icon": "zoom-in"},
										{"fn": "updateWindow(" + JSON.stringify(c)+ ")", "color": "red","icon": "pencil"},
										//{"fn": "del(" + c.user_id + ",'"+c.user_name + "')", "color": "red","icon": "trash"}
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
					"language": {//国际化
						"url": "assets/js/Chinese.json"
					}
	           });	
		
				$("#save").click(function(){//模态框 save
					var flag = $("#flag").val();
					var modleuserName = $("#modleuserName").val();
					var modlepassword = $("#modlepassword").val();
					var modleroleId = $("#modleroleId").val();
					var modleroleName = $("#modleroleId").find("option:selected").text();
				             
					//用户名不能为空
					if(modleuserName == ""){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请输入用户名！"
					    });
					    $("#modleuserName").focus();
					    return false;
					}
					/*
					//密码不能为空
					if(modlepassword == ""){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请输入用户密码！"
					    });
					    $("#modlepassword").focus();
					    return false;
					}
					*/
					/*
					alert("modleroleId:" + modleroleId + ";");
					if(modleroleId == null){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请选择用户角色！"
					    });
					    $("#modleroleId").focus();
					    return false;
					}
					*/
				             
					if(flag=="add"){
						fromSubmin("user!userInsert.do");
					}else if(flag=="update"){
                        window.parent.agent_manage_tier_add(modleroleName, modleuserName);
						fromSubmin("user!userUpdate.do");
					}
					$("#userModal").modal("hide");
				});
				
				
				$("#addbutton").click(function(){//添加 弹出模态框
					$("#myModalLabel").text("添加");
					clearWindow();
					$("#flag").val("add");
					$("#save").show();
					$("#userModal").modal("show");
		 		});
				
				$("#search").click(function(){//查询
					var name = $("#seuserName").val();
					var roleId = $("#sereoleId").val();
		       		param = {
		           		"userInfo.userName":name,
		           		"userInfo.roleId":roleId
					 };
		       		oTable1.fnSettings().ajax.data=param;
					oTable1.api().ajax.reload();
		 		});
		    })

			function updateWindow(userList) {//弹出修改模态框
			
				//超级管理员帐号禁止删除
	            if(userList.user_name=="admin"){
	                bootbox.alert({
	                    locale : "zh_CN",
	                    size : 'small',
	                    title : "提示",
	                    message : "admin帐号禁止修改！"
	                });
	                return false;
	            }
	            
				$("#myModalLabel").text("修改");
				clearWindow();
				$("#flag").val("update");
				$("#modleuserId").val(userList.user_id);
	  			$("#modleuserName").val(userList.user_name);
	  			$("#modleroleId").val(userList.role_id);
	  			$("#modleremark").val(userList.remark);
	  			$("#save").show();
	  			$("#userModal").modal("show");
			}
	   				
			function detailWindow(userList) {//弹出查看详细信息模态框
				$("#myModalLabel").text("详细信息");
				clearWindow();
				$("#modleuserId").val(userList.user_id);
	 			$("#modleuserName").val(userList.user_name);
	 			$("#modleroleId").val(userList.role_id);
	 			$("#modleremark").val(userList.remark);
	 			$("#save").hide()
	 			$("#userModal").modal("show");
			}
			
			function clearWindow() {
				$("#modleuserId").val("");
				$("#modleuserName").val("");
				$("#modlepassword").val("");
				$("#modleroleId").val("");
				$("#modleremark").val("");
			}
			
	        //添加or修改
			function fromSubmin(url) {
				var rid = $("#modleuserId").val();
	        	var rname = $("#modleuserName").val();
	        	var rpw = $("#modlepassword").val();
	        	var rroleid = $("#modleroleId").val();
	        	var rremark = $("#modleremark").val();
				var params = {
					"userInfo.userId":rid,
					"userInfo.userName":rname,
					//"userInfo.password":rpw,
					"userInfo.roleId":rroleid,
					"userInfo.remark":rremark
				};
				var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
				
				if(resData.resNum!=0){
					oTable1.fnSettings().ajax.data = {"userInfo.roleId":-1};// 定义dataTable初始参数
					oTable1.api().ajax.reload();
				}
			}
			
			//删除
			function del(id,dName) {
			
	            //超级管理员帐号禁止删除
	            if(userName=="admin"){
	                bootbox.alert({
	                    locale : "zh_CN",
	                    size : 'small',
	                    title : "提示",
	                    message : "admin帐号禁止删除！"
	                });
	                return false;
	            }
	            
				if(userName==dName){
					bootbox.alert({
						locale : "zh_CN",
						size : 'small',
						title : "提示",
						message : "该帐号正在使用中，不能删除！"
					});
					return false;
				}
	   			bootbox.confirm({
	   				locale: "zh_CN",
					size: 'small',
					title:"提示",
					message: "确认要删除？", 
					callback: function(result){
	   					if(result){
							var params = {
								"userId":id
							};
					        var resData = ajaxCRUD("user!userDelete.do",params,true);//url，参数，是否弹出alert
					        
							if(resData.resNum!=0){
								oTable1.fnSettings().ajax.data = {"userInfo.roleId":-1};// 定义dataTable初始参数
								oTable1.api().ajax.reload();
							}
	                    }
	                }
	            });
			}
        </script>
	</body>
</html>
