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
		<!-- 
		<link rel="stylesheet" href="assets/css/datepicker/bootstrap-datetimepicker.min.css">
		 -->
		<link rel="stylesheet" href="assets/css/datepicker/datetimepicker.css">
		<!-- inline styles related to this page -->

		<script src="assets/js/ace-extra.min.js">
		</script>	
		<!-- inline styles related to this page -->
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">系统管理</a>
				</li>
				<li class="active">系统设置</li>
			</ul><!-- .breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="col-sm-12">
				<div class="table-responsive">
					<div class="table-search">
					
					<div class="col-sm-12" style="padding-top: 20px;">
					<div class="col-sm-2"></div>
					<div class="col-sm-6">
						<div class="profile-user-info profile-user-info-striped" style="margin-right: 0px;margin-left: 0px;">
                			<div class="profile-info-row" >
                				<div class="profile-info-name">CTI后台IP</div>
								<div class="profile-info-value">
									<input type="text" class="input-medium" name="" id="system_ip">
								</div>
                			</div>
                			<div class="profile-info-row" >
                                <div class="profile-info-name">外呼网关IP</div>
                                <div class="profile-info-value">
                                    <input type="text" class="input-medium" name="" id="gw_ip">
                                </div>
                            </div>
                			<div class="profile-info-row">
                				<div class="profile-info-name">录音保存时间</div>
								<div class="profile-info-value">
									<input type="text" class="input-medium" name="" id="save_time">&nbsp;&nbsp;天
								</div>
                			</div>
                		</div>
                	</div>
                	</div>	
                		
                		<div class="col-sm-12" style="padding-bottom: 5px;padding-top: 5px;">
                            <div class="col-sm-6">
                                <button type="submit" id="save" class="btn btn-sm btn-primary pull-right">
                            	保存
                            </button>
                            </div>
                        </div>
					</div>									
                </div><!-- /.table-responsive -->
			</div>									
		</div>


		<!-- basic scripts -->
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		
		<script src='assets/js/jquery-2.0.3.min.js'></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script type="text/javascript">
            var userName="${sessionScope.userInfo.userName}";//session

            $(document).ready(function () {
            	$.ajax({     
					url:'system!selectSysConf.do',
					data:{},
					type:'post',     
					dataType:'json',
					async : false, // 异步     
					error:function(){     
   						alert('error');     
					},     
					success:function(data){
						var systemConf = data.systemConf;
						$(systemConf).each(function(index) {
            				var conf = systemConf[index];
            				$("#save_time").val(conf.record_save_time);
            				$("#system_ip").val(conf.system_ip);
            				$("#gw_ip").val(conf.gw_ip);
            			});
					}
            	});	
            	
            });
            
            $("#save").click(function(){
            	var url = "system!updateSysConf.do";
            	var system_ip = $("#system_ip").val();
				var save_time = $("#save_time").val();
				var gw_ip = $("#gw_ip").val();
				
	        	param = {
	            	"saveTime":save_time,
	            	"systemIp":system_ip,
	            	"gwIp":gw_ip
				};
	        	ajaxCRUD(url,param,true);//url，参数，是否弹出alert
            });          
		</script>
    </body>
</html>