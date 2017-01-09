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

		<script src="assets/js/ace-extra.min.js"></script>
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">系统管理</a>
				</li>
				<li class="active">
					参数设置
				</li>
			</ul>
		</div>

		<div class="page-content">
			<div class="table-responsive">
				<div class="table-search">
                    <div class="col-sm-12" style="padding-bottom: 5px;">

                        <div class="col-sm-6">
                            <label class="control-label no-padding-right">
                                参数名称
                            </label>
                            <input type="text" class="input-small" name="" id="paramName">
                        </div>
                    </div>

                    <div class="col-sm-12">
                        <div class="col-sm-6">
                            <button type="submit" id="search"
                                class="btn btn-sm btn-primary pull-right">
                                查询
                            </button>
                        </div>
                        <div class="col-sm-6">
                            <button type="submit" id="addbutton"
                                class="btn btn-sm btn-primary pull-left">
                                添加
                            </button>
                        </div>
                    </div>
				</div>
				<br>

				<table id="paramTable"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>
								参数名称
							</th>
							<th>
								起始时间
							</th>
							<th>
								截至时间
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
		<div class="modal fade" id="paramModal" tabindex="-1" role="dialog"
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
						<input type="hidden" id="mParamId" >
						<input type="hidden" id="flag">
						<div class="modal-body">
							<table class="modal-table" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr rowpos="1" class="FormData" id="">
										<td class="CaptionTD">
                                                参数名称
										</td>
										<td class="DataTD">
											<input type="text" id="mParamName" name="" class="">
										</td>
									</tr>

									<tr rowpos="2" class="FormData" id="">
                                        <td class="CaptionTD">
                                                起始时间
                                        </td>
                                        <td class="DataTD">
                                            <input type="text" id="mBegin" name="" class="">
                                        </td>
                                    </tr>
                                    
                                    <tr rowpos="3" class="FormData" id="tr_note">
                                        <td class="CaptionTD">
                                                截至时间
                                        </td>
                                        <td class="DataTD">
                                            <input type="text" id="mEnd" name="" class="">
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
            var oTable1;
            var param = {
			};
			
	        $(document).ready(function(){

			});
	        
	        jQuery(function($){
				var tpl = $("#tpl").html();
		        //预编译模板
		        var template = Handlebars.compile(tpl);
		
	            oTable1 = $('#paramTable').dataTable({
					"serverSide": true,//服务器模式，分页用
					"ajax":{
			           	"type": "post",
			           	"url": "param!selectParamsList.do",
			           	"data":param,
			           	"dataSrc":"paramsList"
			           },
			           "aoColumns": [ 
			   			{"mDataProp":"vcparamname"},
			   			{"mDataProp":"vcvalue1"},
			   			{"mDataProp":"vcvalue2"},
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
										{"fn": "del(" + c.nid + ",'"+c.vcparamname + "')", "color": "red","icon": "trash"}
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
					var mParamName = $("#mParamName").val();
					var mBegin = $("#mBegin").val();
					var mEnd = $("#mEnd").val();
				             
					//参数名不能为空
					if(mParamName == ""){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请输入参数名称！"
					    });
					    $("#mParamName").focus();
					    return false;
					}
					
					if(mBegin == ""){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请输入开始时间！"
					    });
					    $("#mBegin").focus();
					    return false;
					}

					if(mEnd == ""){
					    bootbox.alert({
					        locale : "zh_CN",
					        size : 'small',
					        title : "提示",
					        message : "请选择截至时间！"
					    });
					    $("#mEnd").focus();
					    return false;
					}
				             
					if(flag=="add"){
						fromSubmin("param!paramsInsert.do");
					}else if(flag=="update"){
						fromSubmin("param!paramsUpdate.do");
					}
					$("#paramModal").modal("hide");
				});
				
				
				$("#addbutton").click(function(){//添加 弹出模态框
					$("#myModalLabel").text("添加");
					clearWindow();
					$("#flag").val("add");
					$("#save").show();
					$("#paramModal").modal("show");
		 		});
				
				$("#search").click(function(){//查询
					var name = $("#paramName").val();
		       		param = {
		           		"params.paramName":name
					 };
		       		oTable1.fnSettings().ajax.data=param;
					oTable1.api().ajax.reload();
		 		});
		    })

			function updateWindow(paramList) {//弹出修改模态框	            
				$("#myModalLabel").text("修改");
				clearWindow();
				$("#flag").val("update");
				$("#mParamId").val(paramList.nid);
	  			$("#mParamName").val(paramList.vcparamname);
	  			$("#mBegin").val(paramList.vcvalue1);
	  			$("#mEnd").val(paramList.vcvalue2);
	  			$("#save").show();
	  			$("#paramModal").modal("show");
			}
	   				
			function detailWindow(paramList) {//弹出查看详细信息模态框
				$("#myModalLabel").text("详细信息");
				clearWindow();
				$("#mParamId").val(paramList.nid);
	  			$("#mParamName").val(paramList.vcparamname);
	  			$("#mBegin").val(paramList.vcvalue1);
	  			$("#mEnd").val(paramList.vcvalue2);
	 			$("#save").hide()
	 			$("#paramModal").modal("show");
			}
			
			function clearWindow() {
				$("#mParamId").val("");
				$("#mParamName").val("");
				$("#mBegin").val("");
				$("#mEnd").val("");
			}
			
	        //添加or修改
			function fromSubmin(url) {
				var mParamId = $("#mParamId").val();
	        	var mParamName = $("#mParamName").val();
	        	var mBegin = $("#mBegin").val();
	        	var mEnd = $("#mEnd").val();
				var params = {
					"params.id":mParamId,
					"params.paramName":mParamName,
					"params.value1":mBegin,
					"params.value2":mEnd
				};
				var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
				
				if(resData.resNum!=0){
					oTable1.fnSettings().ajax.data = {};// 定义dataTable初始参数
					oTable1.api().ajax.reload();
				}
			}
			
			//删除
			function del(id, name) {	            
	   			bootbox.confirm({
	   				locale: "zh_CN",
					size: 'small',
					title:"提示",
					message: "确认要删除？", 
					callback: function(result){
	   					if(result){
							var params = {
								"params.id":id,
                                "params.paramName":name,
							};
					        var resData = ajaxCRUD("param!paramsDelete.do",params,true);//url，参数，是否弹出alert
					        
							if(resData.resNum!=0){
								oTable1.fnSettings().ajax.data = {};// 定义dataTable初始参数
								oTable1.api().ajax.reload();
							}
	                    }
	                }
	            });
			}
        </script>
	</body>
</html>