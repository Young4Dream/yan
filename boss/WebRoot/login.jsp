<%@ page language="java" pageEncoding="UTF-8"%>  
<%@taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<script src="js/jquery.min.js"></script>
		<script type="text/javascript">
			if (window != top){
				top.location.href = "";
			}
			
			var userName="${sessionScope.userInfo.userName}";
			if(userName!=""){
				var isAdmin="${sessionScope.userInfo.isAdmin}";
				if(isAdmin==1){
					window.location.href='sysIndex!goToAdminPage.do';	
				}else{
					window.location.href='sysIndex!goToIndexPage.do';
				}
				
			}			
		</script>
	</head>
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							
							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border" 
								style="margin-top: 100px;padding:0px;box-shadow: 5px 5px 5px;">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-phone green"></i>
												电信业务运营支撑系统(Ver13.0)
											</h4>

											<div class="space-6"></div>

											<form id="loginForm" action="login!login.do" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="name" name="userName" class="form-control" placeholder="用户名" 
															onblur="loadPassFormCookie();"/>
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="pw" name="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>
													
													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input id="remberMe" type="checkbox" class="ace" />
															<span class="lbl">记住我</span>
														</label>

														<button type="button" id="login" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
														
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								
								<div class="toolbar clearfix center" >
									<h5 class="white">&copy;北京泰思达网络通信技术有限公司</h5>
								</div>	
									
								</div><!-- /login-box -->
								
								
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!-- inline scripts related to this page -->
		<script src="assets/js/jquery-1.10.2.min.js"></script>
		<script src="assets/js/jquery.cookie.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/crud/crud.js"></script>
		<script type="text/javascript">
            var loginAlertFlag;
            var gwIp;
            
            loginAlertFlag = "0";
            
            function setFlag(){
                loginAlertFlag = "0";
            }
            
			$(function(){
				var name = $.cookie("userName");
				var password = $.cookie(name);
				if(name != null){
					$("#name").val(name);
				}
				if(password != null){
					$("#pw").val(password);
				}
			});	
			
			//填写用户名时，从coolie获取密码
			function loadPassFormCookie(){
				if($("#name").val() != ""){
					var pass=$.cookie($("#name").val());
	   				$("#pw").val(pass);
				}
			}			
			
			$("#login").click(function(){
				var name=$("#name").val();
				var password=$("#pw").val();
				
				if(name == ""){
					bootbox.alert({  
	            		 message: "用户名不能为空！",   
	            		 title: "提示",
	            		 locale: "zh_CN",
	    				 size: 'small',
	    				 callback: function(){ loginAlertFlag = "0"; }
	    			});
	    			
	    			loginAlertFlag = "1";
					return false;
				}
				
				if(password==""){
					bootbox.alert({  
	            		 message: "密码不能为空！",   
	            		 title: "提示",
	            		 locale: "zh_CN",
	    				 size: 'small'
	    			});
					return false;
				}
				
				if($("#remberMe").is(":checked")){
					$.cookie("userName",name,{expires:30});
					$.cookie(name,password,{expires:30});
				}
				
				var param = {
					"userName":name,
					"password":password,
				};
				var resData = ajaxCRUD("login!login.do", param, false);
				
				if(resData.resNum != "1"){
					bootbox.alert({  
	            		 message: resData.res,   
	            		 title: "失败",
	            		 locale: "zh_CN",
	    				 size: 'small'
	   				}); 
				} else {
					window.location.href='sysIndex!gotoPortal.do';
				}
				
				
		 	});
		 	
			$(document).keydown(function(e){
				if(e.keyCode == 13) {	
				    if (loginAlertFlag == 1)
				    {
				        //loginAlertFlag == 0;
				        return;
				    }
				                
					$("#login").click();
				}
			});
			
			$("#isAdmin").change();
		</script>
</body>
</html>
