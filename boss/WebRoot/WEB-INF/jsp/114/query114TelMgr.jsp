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
		
		<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- inline styles related to this page -->
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">业务受理</a>
				</li>
				<li class="active">114查号</li>
			</ul><!-- .breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="col-sm-12">
				<div class="table-responsive">
					<div class="table-search">
                        <div class="col-sm-12" style="padding-bottom:5px;">
                            <div class='col-sm-3'>
                                <label class="control-label no-padding-right" >用户名称(拼音):</label>
                                <input type="text" class="input-small" name="" id="sespell1" onkeypress="next(event)"
                                   onkeyup="arrow()">
                            </div>								
                                                            
                            <div class='col-sm-3'>
                                <label class="control-label no-padding-right" for="form-field-1">用户单位(拼音):</label>
                                <input type="text" class="input-small" name="" id="sespell2" onkeypress="next(event)"
                                    onkeyup="arrow()">
                            </div>
                            
                            <div class='col-sm-3'>
                                <label class="control-label no-padding-right" for="form-field-1">用户地址(拼音):</label>
                                <input type="text" class="input-small" name="" id="sespell3" onkeypress="next(event)"
                                   onkeyup="arrow()">
                            </div>

                            <div class='col-sm-3'>                                  
                                <label class="control-label no-padding-right" for="form-field-1">号码:</label>
                                <input type="text" class="input-small" name="" id="setel" onkeypress="next(event)"
                                   onkeyup="arrow()">
                            </div>  
                        </div>
                        
                        <div class="col-sm-12">
                            <div class="col-sm-6">
                                <button type="submit" id="addbutton"
                                    class="btn btn-sm btn-primary pull-right">
                                        添加
                                </button>
                            </div>
                        </div>
					</div>
					<br>
					
					<table id="sample-table-2" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>号码</th>
								<th>简拼</th>
								<th>名称</th>
								<th>单位</th>
								<th>地址</th>
								<th>操作</th>
							</tr>	
						</thead>
						<tbody></tbody>
					</table>					
                </div><!-- /.table-responsive -->
			</div>									
		</div>
        
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
                    
                    <input type="hidden" id="modleId" >
                    <input type="hidden" id="flag">
                    
                    <div class="modal-body">
                        <table class="modal-table" cellspacing="0" cellpadding="0"
                            border="0">
                            <tbody>
                                <tr rowpos="1" class="FormData" id="">
                                    <td class="CaptionTD">
                                        电话
                                    </td>
                                    <td class="DataTD">
                                        <input type="text" id="modleTel" name="" class="">
                                    </td>
                                </tr>

                                <tr rowpos="2" class="FormData" id="">
                                    <td class="CaptionTD">
                                        名称
                                    </td>
                                    <td class="DataTD">
                                        <input type="text" id="modleName" name="" class="">
                                    </td>
                                </tr>
                                
                                <tr rowpos="3" class="FormData" id="tr_note">
                                    <td class="CaptionTD">
                                        部门
                                    </td>
                                    <td class="DataTD">
                                        <input type="text" id="modleDept" name="" class="">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-sm btn-primary" id="save">
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

		<!-- page specific plugin scripts -->
		
		<script src="assets/js/jquery.dataTables.js"></script>
		<!-- 
		
		<script src="assets/js/jquery.dataTables.min.js"></script>
		 -->
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/handlebars-v3.0.1.js"></script>

		<!-- ace scripts -->
		<!-- inline scripts related to this page -->
		<script type="text/javascript" src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript" src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		
		<script id="tpl" type="text/x-handlebars-template">
            <div class="action-buttons">
                {{#each func}}
                <a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a>
                {{/each}}
            </div>
		</script>
		
		<script type="text/javascript"> 
            var userName="${sessionScope.userInfo.userName}";//session
            var oTable1;
			var param;
            
            $(document).ready(function(){
	
			})
            
			//firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
			if(/msie/i.test(navigator.userAgent)){    //ie浏览器 
				document.getElementById('sespell1').onpropertychange=search
				document.getElementById('sespell2').onpropertychange=search
				document.getElementById('sespell3').onpropertychange=search
				document.getElementById('setel').onpropertychange=search
			} 
			else 
			{//非ie浏览器，比如Firefox 
				document.getElementById('sespell1').addEventListener("input",search,false);
				document.getElementById('sespell2').addEventListener("input",search,false); 
				document.getElementById('sespell3').addEventListener("input",search,false); 
				document.getElementById('setel').addEventListener("input",search,false); 
			}  

			jQuery(function($) {		
				var tpl = $("#tpl").html();
		        //预编译模板
		        var template = Handlebars.compile(tpl);
				
				oTable1 = $('#sample-table-2').dataTable({
					"serverSide": true,//服务器模式，分页用
					"ajax":{
		            	"type": "post",
		            	"url": "querynum!query114List.do",
		            	"data":param,
		            	"dataSrc": "list114"
		            },
		            "aoColumns": [ 
		            	{"mDataProp":"tel"},
		    			{"mDataProp":"spell1"},
		    			{"mDataProp":"name"},
		    			{"mDataProp":"dept"},
		    			{"mDataProp":"addr"},
						{"mDataProp":""}
		    		],
					 columnDefs: [
		                {
		                    targets: 5,
		                    render: function (a, b, c, d) {
		                        var context =
		                        {
		                            func: [
		                                {"fn": "detailWindow(" + JSON.stringify(c) + ")", "color": "blue","icon": "zoom-in"},
										{"fn": "updateWindow(" + JSON.stringify(c)+ ")", "color": "red","icon": "pencil"},
										{"fn": "del(" + c.id + ",'"+c.tel + "')", "color": "red","icon": "trash"}
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
	        })
	        
			function search(){
				var sespell1 = $("#sespell1").val();
				var sespell2 = $("#sespell2").val();
				var sespell3 = $("#sespell3").val();
				var setel = $("#setel").val();
	        	param = {
	            	"query114List.spell1":sespell1,
	            	"query114List.spell2":sespell2,
	            	"query114List.spell3":sespell3,
	            	"query114List.tel":setel
				};
	        	oTable1.fnSettings().ajax.data=param;
				oTable1.api().ajax.reload();
			}
            
			function next(e){
			    var e = e || event;
                currKey=e.keyCode||e.which||e.charCode;     
                var x;
                
                x = e.currentTarget || e.target || e.srcElement;  
                if(currKey == 13) //回车
                { 
                    if (x.id == "sespell1")
                    {
                        $("#sespell2").focus(); 
                    }
                    else if (x.id == "sespell2")
                    {
                        $("#sespell3").focus();
                    }
                    else if (x.id == "sespell3")
                    {
                        $("#setel").focus();
                    }
                    else if (x.id == "setel")
                    {
                        $("#sespell1").focus();
                    }
                }
                else if (currKey == 32)     //空格
                {
                    //event.returnValue = false;    
                    e.preventDefault();
                    if (x.id == "sespell1")
                    {
                        $("#sespell2").focus();               
                    }
                    else if (x.id == "sespell2")
                    {
                        $("#sespell3").focus();                     
                    }
                    else if (x.id == "sespell3")
                    {
                        $("#setel").focus();
                    }
                    else if (x.id == "setel")
                    {
                        $("#sespell1").focus();
                    }
                }
            }
            
            function arrow(){
            /*
                var x;

                x = event.currentTarget;
                
                //始终将输入焦点放在文本末尾
                if (x.createTextRange) {
                    var rtextRange = x.createTextRange();
                    rtextRange.moveStart('character', x.value.length);
                    rtextRange.collapse(true);
                    rtextRange.select();
                }
                else if (x.selectionStart) 
                {
                    x.selectionStart = x.value.length;
                }
                
                switch(event.keyCode){
                    //<---
                    case 37:
	                    if (x.id == "sespell1")
	                    {
	                        $("#sespell1").focus(); 
	                    }
	                    else if (x.id == "sespell2")
	                    {
	                        $("#sespell1").focus();                     
	                    }
	                    else if (x.id == "sespell3")
	                    {
	                        $("#sespell2").focus();
	                    }
	                    else if (x.id == "setel")
	                    {
	                        $("#sespell3").focus();
	                    }
	                    break;
                    //--->
                    case 39:
                        if (x.id == "sespell1")
                        {
                            $("#sespell2").focus();               
                        }
                        else if (x.id == "sespell2")
                        {
                            $("#sespell3").focus();                     
                        }
                        else if (x.id == "sespell3")
                        {
                            $("#setel").focus();
                        }
                        else if (x.id == "setel")
                        {
                            $("#setel").focus();
                        }
                        break;
                }
            */
            }
            
            $("#addbutton").click(function(){//添加 弹出模态框
                $("#myModalLabel").text("添加");
                clearWindow();
                $("#flag").val("add");
                $("#modleTel").removeAttr("disabled");
                $("#save").show();
                $("#userModal").modal("show");
            }); 
            
            $("#save").click(function(){//模态框 save
                var flag = $("#flag").val();
                var tel = $("#modleTel").val();
                var name = $("#modleName").val();
                var dept = $("#modleDept").val();
                         
                //用户名不能为空
                if(tel == ""){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入电话号码！"
                    });
                    $("#modleTel").focus();
                    return false;
                }
                
                //名称不能为空
                if(name == ""){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入名称！"
                    });
                    $("#modleName").focus();
                    return false;
                }

                if(flag == "add"){
                    fromSubmin("querynum!queryNumInsert.do");
                }else if(flag=="update"){
                    fromSubmin("querynum!queryNumUpdate.do");
                }
                $("#userModal").modal("hide");
            });
            
            //添加or修改
            function fromSubmin(url) {
                var id = $("#modleId").val();
                var tel = $("#modleTel").val();
                var name = $("#modleName").val();
                var dept = $("#modleDept").val();
                var params = {
                    "queryNum.tel":tel,
                    "queryNum.name":name,
                    "queryNum.dept":dept
                };
                var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
                
                if(resData.resNum!=0){
                    oTable1.fnSettings().ajax.data = {};// 定义dataTable初始参数
                    oTable1.api().ajax.reload();
                }
            }
            
            function updateWindow(list114) {//弹出修改模态框
                $("#myModalLabel").text("修改");
                clearWindow();
                $("#modleTel").attr("disabled","disabled");
                $("#flag").val("update");
                $("#modleId").val(list114.id);
                $("#modleTel").val(list114.tel);
                $("#modleName").val(list114.name);
                $("#modleDept").val(list114.dept);
                $("#save").show();
                $("#userModal").modal("show");
            }
                    
            function detailWindow(list114) {//弹出查看详细信息模态框
                $("#myModalLabel").text("详细信息");
                clearWindow();
                $("#modleTel").val(list114.tel);
                $("#modleName").val(list114.name);
                $("#modleDept").val(list114.dept);
                $("#save").hide()
                $("#userModal").modal("show");
            }
            
            function clearWindow() {
                $("#modleTel").val("");
                $("#modleName").val("");
                $("#modleDept").val("");
            }
            
            //删除
            function del(id, tel) {
                bootbox.confirm({
                    locale: "zh_CN",
                    size: 'small',
                    title:"提示",
                    message: "确认要删除？", 
                    callback: function(result){
                        if(result){
                            var params = {
                                "queryNum.id":id,
                                "queryNum.tel":tel
                            };
                            var resData = ajaxCRUD("querynum!queryNumDelete.do",params,true);//url，参数，是否弹出alert
                            
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