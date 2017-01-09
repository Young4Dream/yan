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
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>
	</head>

	<body>
	
		<div class="navbar navbar-default" id="navbar">
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="ace-nav">
						<li>
						    <span class="white"><label id="admin_wsi_status">&nbsp;</label></span>
							<span class="white">欢迎光临，<s:property value="#session.userInfo.userName" /></span>
							<a id="modifypsw_admin" data-toggle="modal" 
  										 data-target="#password"  href="">	
								更改密码
							</a>
							<a id="logout" href="#">
								退出
							</a>
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
											原始密码
										</td>
										<td class="DataTD">
											<input type="password" id="oldPw" class="">
										</td>
									</tr>

									<tr rowpos="2" class="FormData" id="">
										<td class="CaptionTD">
											新密码
										</td>
										<td  class="DataTD">
											<input type="password" id="newPw1" class="">
										</td>

									</tr>
									<tr rowpos="3" class="FormData" id="tr_note">
										<td class="CaptionTD">
											确认新密码
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

		<script src="assets/js/ace.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.slimscroll.min.js"></script>
		<script src="assets/js/crud/crud.js"></script>
		<!-- inline scripts related to this page -->
		
		<script type="text/javascript">
		    var ip = "${sessionScope.userInfo.ip}";
		    var socket_di;
		       
			function connect() {                            
			    if (typeof MozWebSocket != "undefined") {
			        socket_di = new MozWebSocket("ws://" + ip +":7681/xxx",
			                   "dumb-increment-protocol");
			    } else {
			        socket_di = new WebSocket("ws://" + ip +":7681/xxx",
			                   "dumb-increment-protocol");
			    }                       
			
			    try {
			        socket_di.onopen = function() {
			            //document.getElementById("admin_wsi_status").style.backgroundColor = "#40ff40";
			            //document.getElementById("admin_wsi_status").style.width = "25px";
			            //document.getElementById("admin_wsi_status").textContent = "&nbsp;";
			        } 
			
			        socket_di.onmessage =function() {
			            
			        } 
			
			        socket_di.onclose = function(){
			            //document.getElementById("admin_wsi_status").style.backgroundColor = "#ff4040";
			            //document.getElementById("admin_wsi_status").style.width = "25px";
			            //document.getElementById("admin_wsi_status").textContent = "&nbsp;";
			        }
			    } catch(exception) {
			        alert('<p>Error' + exception);  
			    }
			};
			
			//增加座席
            function agent_manage_add(agent) {
                //alert("test!");
                socket_di.send('{"RequestId":700,"RequestData":{"SubRequest":"ADD","AgentId":"' + agent
                    + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
            };
            
            //删除座席
            function agent_manage_del(agent) {
                //alert("test!");
                socket_di.send('{"RequestId":701,"RequestData":{"SubRequest":"DEL","AgentId":"' + agent
                    + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
            };
            
            //绑定座席跟队列的关系
            function agent_manage_tier_add(queues, agent) {
                //alert("test!");
                socket_di.send('{"RequestId":702,"RequestData":{"SubRequest":"TIER","AgentId":"' + agent
                    + '","ExtNo":"","ExtNoType":"","Queues":"' + queues + '"}}');
            };
            
          //更新角色
            function updateRole(){
            	socket_di.send('{"RequestId":704}');
            }
            
        </script> 
        
		<script type="text/javascript">		
		var userId = ${sessionScope.userInfo.userId};
		var roleId = ${sessionScope.userInfo.roleId};
		var userName = "${sessionScope.userInfo.userName}";
		var html = "";
		var count;
		$(document).ready(function(){
			$.ajax({     
    					url:'menu!menuTree.do',
						data:{
							"roleId":roleId,
						},
    					type:'post',     
    					dataType:'json',
    					async : false, // 异步     
    					error:function(){     
       						alert('error');     
    					},     
    					success:function(data){
							var menuList = data.menuList;
							$(menuList).each(function(index) {
                				var menu = menuList[index];
                				//从根节点开始构建树
                				if(menu.parentId==0){
									html += 
										"<li>" +
											"<a href=\"#\" class=\"dropdown-toggle\">" +
												"<i class=\""+menu.menuIco+"\"></i>" +
												"<span class=\"menu-text\">"+menu.menuName+"</span><b class=\"arrow icon-angle-down\"></b>" +
											"</a>";
									html += "<ul class=\"submenu\">";
									count = 1;
									//构建根节点的子节点
                					buildMenu(menu.menuId,menu.menuName,menuList);
                					html += "</ul>";
                					html += "</li>";
                				}
            				});
							//console.log(html);
							$('#textTree').append(html);
        				}
			});
			
			//展开所有一级菜单
            $("#textTree > li").addClass("open");
            $("#textTree > li > ul").css("display", "block");
            
            //websocket开始连接
            connect();
		});
		
		//构造树，出去根节点
		function buildMenu(menuId,menuName,menuList){
				$(menuList).each(function(index) {
            	var menu = menuList[index];
            	if(menuId==menu.parentId){
            		if(hasChild(menu.menuId,menuList)>0){//如果有子节点 构造<ul>
            			count++;
            			html += 
            				"<li>" +
            					"<a href=\""+menu.menuUrl+"\" class=\"dropdown-toggle\">";
            					
            			if(count<=2){
            				html += "<i class=\"icon-double-angle-right\"></i>";
            			}
            			html +=     "<i class=\""+menu.menuIco+"\"></i>" +
            						"<span class=\"menu-text\">  "+menu.menuName+"</span>";
            			html += 	"<b class=\"arrow icon-angle-down\"></b>" +
            					"</a>";
            			//构造子节点		
            			html += "<ul class=\"submenu\">";
                		buildMenu(menu.menuId,menu.menuName,menuList);
                		html += "</ul>";	
            		}else{
            			html += 
            				"<li id=\"act"+menu.menuId+"\">" +
            					"<a href=\"javascript:goToRight('"+menu.menuUrl+"',"+menu.menuId+")\">";
            			if(count<=2){
            				html += "<i class=\"icon-double-angle-right\"></i>";
            			}
            						//"<i class=\"icon-double-angle-right\"></i>" +
            			html += 	"<i class=\""+menu.menuIco+"\"></i>" +
            						"<span class=\"menu-text\">  "+menu.menuName+"</span>"+
            					"</a>" +
            				"</li>";
            		}
            		html += "</li>";
            	}
            	
            });	
		}
		
			var lastid = 0;
			function goToRight(url,id,pid){
				if(lastid!=0){
					$("#act"+lastid).removeClass("active");
				}
				$("#act"+id).addClass("active");
				lastid = id;
				
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
        					   //agent_manage_add("aa");
        					   
        					   try
        					   {
        					       scket_di.close();  //先断开websocket连接
        					   }
        					   catch(exception) {
                                   //alert('<p>Error' + exception); 
        					   }
								
							   window.location.href='login!logout.do';
							   
							}
    					}
					});
			});	
			

			$("#save").click(function(){
				var oldPw = $("#oldPw").val();
				var newPw1 = $("#newPw1").val();
				var newPw2 = $("#newPw2").val();
				if(newPw1!=newPw2){
					bootbox.alert({  
            				message: "两次输入的密码不一致，请重新输入",   
            		 		title: "提示",
            		 		locale: "zh_CN",
    				 		size: 'small'
    					});
						return false;
				}else{
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
       						alert('error');     
    					},     
    					success:function(data){
							if(data.resNum==1){
								//$("#modal").modal("hide");
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
<iframe id="rightFarme" name="right" width="0%" height="0%" src="http://10.77.120.135/tsdboss/mainServlet.html?ds=tsdBilling&login=true&logintype=1&sadminname=sf1&spassword=a" frameborder="no" style="display:none" scrolling="yes" allowtransparency="true" >
                    </iframe>
</html>

