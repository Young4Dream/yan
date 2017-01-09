<%@ page language="java" pageEncoding="UTF-8"%>  
<%@taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<!-- basic styles -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		
		<link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.custom.min.css" />
		
		
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<!-- 
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/main.css" />
		 -->
		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>
		
		<script src="assets/js/sha256.js"></script>
	</head>

	<body class="no-skin">
	
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
			
			<div class="navbar-container" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							电信业务运营支撑系统(Ver13.0)
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks bigger-110"></i>
								<span class="badge badge-grey" id="newTaskCount">0</span>
							</a>
							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<a href="#" onclick="goToRight('task!goToPage.do')">
										<i class="icon-check"></i>
										<span id="newTaskTip">0个待办任务</span>
									</a>
									<audio id="audio" src="images/sound.WAV"></audio>  
								</li>
							</ul>
						</li>
						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell bigger-110"></i>
								<span class="badge badge-important" id="newWarnCount">0</span>
							</a>
							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<a href="#" onclick="goToRight('warn!goToPage.do')">
										<i class="icon-check"></i>
										<span id="newWarnTip">0个告警信息</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope bigger-110"></i>
								<span class="badge badge-important" id="newNoticeCount">0</span>
							</a>
							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<a href="#" onclick="goToRight('sysIndex!goToDashboardPage.do')"> 
										<i class="icon-check"></i>
										<span id="newNoticeTip">0条系统公告</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="assets/avatars/user.jpg" />
								<span class="user-info">
									<small>欢迎,</small>
									<s:property value="#session.userInfo.userName" />
								</span>
								<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a id="modifypsw_admin" data-toggle="modal" data-target="#password"href="#">
										<i class="icon-cog"></i>
										更改密码
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a id="logout" href="#">
										<i class="icon-signout"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /navbar-container -->
		</div>

		<div class="main-container" id="main-container">
			<div class="main-container-inner">
				<div class="sidebar" id="sidebar">
					<div class="nav nav-list-div">
					<ul class="nav nav-list" id="textTree">
					</ul><!-- /.nav-list -->
					
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>
					</div>
				</div>

				<div class="main-content">
					<iframe id="rightFarme" name="right" width="100%" height="100%" src="" frameborder="no" scrolling="yes" allowtransparency="true" >
					</iframe>
					
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="password" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							更改密码
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
											原始密码：
										</td>
										<td class="DataTD">
											<input type="password" id="oldPw" class="">
										</td>
									</tr>

									<tr rowpos="2" class="FormData" id="">
										<td class="CaptionTD">
											新密码：
										</td>
										<td  class="DataTD">
											<input type="password" id="newPw1" class="">
										</td>

									</tr>
									<tr rowpos="3" class="FormData" id="tr_note">
										<td class="CaptionTD">
											确认新密码：
										</td>
										<td  class="DataTD">
											<input type="password" id="newPw2" class="">
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

		<script src="assets/js/jquery-1.10.2.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.slimscroll.min.js"></script>
		<script src="assets/js/crud/crud.js"></script>
		<!-- inline scripts related to this page -->
		
		<script type="text/javascript">		
		var userId = ${sessionScope.userInfo.id};
		var roleId = ${sessionScope.userInfo.roleId};
		var userName = "${sessionScope.userInfo.userName}";
		var html = "";
		var playCounter = 0;
		$(document).ready(function(){
			$("#rightFarme").attr('src','sysIndex!goToDashboardPage.do');
			$("#rightFarme").height(document.documentElement.clientHeight-110);
			
			var ft = function(){
				// 查找待办事项
				var res = ajaxCRUD("task!findNewTaskCount.do", {"id": userName}, false);
				var newTaskCount = parseInt(res.recordsTotal);
				if (newTaskCount == undefined || isNaN(newTaskCount)) { 
					newTaskCount = 0;
				}
				$("#newTaskCount").text(newTaskCount);
				$("#newTaskTip").text(newTaskCount + "个待办任务");
				// 播放新工单提醒音频
				if (newTaskCount > 0) {
					if (playCounter == 0) {
						$("#audio")[0].play();
					}
					playCounter += 1;
					if (playCounter == 10) {
						playCounter = 0;
					}
				} else {
					$("#newTaskNotify").html("");
				}
				// 查询系统公告
				res = ajaxCRUD("notice!countNewNotice.do", {}, false);
				var newNoticeCount = parseInt(res.recordsTotal);
				if (newNoticeCount == undefined || isNaN(newNoticeCount)) { 
					newNoticeCount = 0;
				}
				$("#newNoticeCount").text(newNoticeCount);
				$("#newNoticeTip").text(newNoticeCount + "条系统公告");
				// 查询告警
				res = ajaxCRUD("warn!countNewWarnLog.do", {}, false);
				var newWarnCount = parseInt(res.recordsTotal);
				if (newWarnCount == undefined || isNaN(newWarnCount)) { 
					newWarnCount = 0;
				}
				$("#newWarnCount").text(newWarnCount);
				$("#newWarnTip").text(newWarnCount + "个告警信息");
				
				setTimeout(ft, 60000);
			};
			
			ft();
			
			$.ajax({     
    			url:'menu!menuTree.do',
				data:{"roleId":roleId },
    			type:'post',     
    			dataType:'json',
    			async : false, // 异步     
    			error:function(){ alert('错误'); },     
    			success:function(data){
					var menuList = data.menuList;
					$(menuList).each(function(index) {
                		var menu = menuList[index];
                		//从根节点开始构建树
                		if (menu.parentId == undefined) {
							html += 
								"<li>" +
								"<a href=\"#\" class=\"dropdown-toggle\">" +
								"<i class=\"" + menu.menuIcon + "\"></i>" +
								"<span class=\"menu-text\">" + menu.menuName + "</span><b class=\"arrow icon-angle-down\"></b>" +
								"</a>";
							html += "<ul class=\"submenu\">";
							count = 1;
							//构建根节点的子节点
                			buildMenu(menu.id, menu.menuName, menuList);
                			html += "</ul>";
                			html += "</li>";
                		}
            		});
					$('#textTree').append(html);
        		}
			});
			
			//展开所有一级菜单
            //$("#textTree > li").addClass("open");
            //$("#textTree > li > ul").css("display", "block");
            
		});
		
		//构造树，出去根节点
		function buildMenu(menuId, menuName, menuList){
			$(menuList).each(function(index) {
            	var menu = menuList[index];
            	if(menuId == menu.parentId){
            		if (hasChild(menu.id, menuList) > 0) { // 如果有子节点 构造<ul>
            			count++;
            			html += 
            				"<li>" +
            					"<a href=\"" + menu.menuUrl + "\" class=\"dropdown-toggle\">";
            					
            			if(count <= 2){
            				html += "<i class=\"icon-double-angle-right\"></i>";
            			}
            			html +=     "<i class=\"" + menu.menuIcon + "\"></i>" +
            						"<span class=\"menu-text\">  " + menu.menuName + "</span>";
            			html += 	"<b class=\"arrow icon-angle-down\"></b>" +
            					"</a>";
            			//构造子节点		
            			html += "<ul class=\"submenu\">";
                		buildMenu(menu.id, menu.menuName, menuList);
                		html += "</ul>";	
            		} else {
            			html += 
            				"<li id=\"act" + menu.id + "\">" +
            					"<a href=\"javascript:goToRight('" + menu.menuUrl + "'," + menu.id + ")\">";
            			if (count <= 2) {
            				html += "<i class=\"icon-double-angle-right\"></i>";
            			}
            			html += 	"<i class=\"" + menu.menuIcon + "\"></i>" +
            						"<span class=\"menu-text\">  " + menu.menuName + "</span>"+
            					"</a>" +
            				"</li>";
            		}
            		html += "</li>";
            	}
            	
            });	
		}
		
			var lastid = 0;
			function goToRight(url,id,pid){
				if(lastid != 0){
					$("#act"+lastid).removeClass("active");
				}
				if (id != undefined) {
					$("#act"+id).addClass("active");
					lastid = id;
				}
				
				$("#rightFarme").attr('src',url);
				setHeight();
			}
			
			function setHeight(){
				$("#rightFarme").height(document.documentElement.clientHeight-110);
				setTimeout(setHeight, 500);
			}
			
			$("#logout").click(function(){
				bootbox.confirm({
        			locale: "zh_CN",
    				size: 'small',
    				title:"提示",
   					message: "确认要退出？", 
    				callback: function(result){
        				if(result){
						   window.location.href='login!logout.do';
						}
    				}
				});
			});	

			$("#save").click(function(){
				var oldPw = $("#oldPw").val();
				var newPw1 = $("#newPw1").val();
				var newPw2 = $("#newPw2").val();
				//alert(CryptoJS.SHA256(newPw1));
				if(newPw1!=newPw2){
					bootbox.alert({  
            			message: "两次输入的密码不一致，请重新输入",   
            		 	title: "提示",
            		 	locale: "zh_CN",
    				 	size: 'small'
    				});
					return false;
				} else {
					$.ajax({     
    					url:'user!modifPw.do',
						data:{
							"oldPw":oldPw,
							"newPw1":newPw1,
							"newPw2":newPw2,
							"userId":userId
						},
    					type:'post',     
    					dataType:'json',
    					async : false, // 异步     
    					error:function(){     
       						alert('错误');     
    					},     
    					success:function(data){
							if(data.resNum==1){
								bootbox.dialog({
  									message: "密码修改成功,需要重新登录",
  									title: "提示", 
  									// 退出dialog时的回调函数，包括用户使用ESC键及点击关闭
  									onEscape: function() {
										window.location.href='login!logout.do';
 							 		},
  									// 是否显示关false闭按钮，默认true
  									closeButton: false,
 									 buttons: {
   										 success: {   
      										label: "确认",
      										className: "btn btn-sm btn-primary",
      										callback: function() {
	  											window.location.href='login!logout.do';
      										}
    									}
  									}
								});
							}else if(data.resNum==0){
								bootbox.alert({  
            					message: data.res,   
            		 			title: "提示",
            		 			locale: "zh_CN",
    				 			size: 'small'
    						});
							}
        				}
					});
				}
				
			});	
			
			
		</script>
		
</body>
</html>

