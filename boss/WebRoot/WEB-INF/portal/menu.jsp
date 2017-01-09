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
		<link rel="stylesheet" href="assets/css/smartMenu.css" type="text/css" />
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">系统管理</a>
				</li>
				<li class="active">菜单管理</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div class="col-sm-4">
			<div class="col-sm-9" style="padding-right:0px;">
				<div class="dd" id="nestable">
	
				</div>
			</div>
			<div class="col-sm-3">
			
			</div>
			
			<div class="col-sm-12">
			<button type="button"  class="btn btn-sm btn-primary pull-left" id="updateTree">
				更新
    		</button>
			</div>
			
			</div>
			
			<div class="col-sm-8">
				<div class="widget-box">
					<div class="widget-header widget-header-small">
							<i class="icon-tint"></i>
							菜单配置
					</div>

					<div class="widget-body">
						<div class="widget-main">
						
  		 <input type="hidden" id="modalId" name="menuInfo.menuId" value="">
  		 
		 <input type="hidden" id="modalCreateTime" name="menuInfo.createTime" value="">
			<table class="modal-table" cellspacing="0" cellpadding="0" border="0">
			<tbody>
			<tr rowpos="1" class="FormData" id="">
				<td class="CaptionTD">菜单名称</td>
				<td class="DataTD">&nbsp;<input type="text" id="modalName" name="menuInfo.menuName" class=""></td>
				<td class="CaptionTD">菜单描述</td>
				<td class="DataTD">&nbsp;<input type="text" id="modalDesc" name="menuInfo.menuDesc"  class=""></td>
			</tr>

			<tr rowpos="2" class="FormData" id="">
				<td class="CaptionTD">菜单图标</td>
				<td colspan="3" class="DataTD">
				&nbsp;<input type="text" id="modalIco" name="menuInfo.menuIco"  class=""></td>
				
			</tr>
			
			<tr rowpos="3" class="FormData" id="tr_note">
				<td class="CaptionTD">菜单地址</td>
				<td class="DataTD">&nbsp;<input type="text" id="modalUrl" name="menuInfo.menuUrl" class=""></td>
				<td class="CaptionTD">菜单父级</td>
				<td class="DataTD">&nbsp;
					<select name="menuInfo.parentId" calss="input-sm" id="modalParent" style="position:relative;left:-6px;">
					</select>
				</td>
			</tr>
			
			<tr rowpos="4" class="FormData" id="">
			<td class="CaptionTD">菜单排序</td>
				<td colspan="3" class="DataTD">
				&nbsp;<input type="text" id="modalSort" name="menuInfo.menuSort" class="">
				</td>
			</tr>
			
			<tr rowpos="5" class="FormData" id="tr_note">
				<td class="CaptionTD">备注</td>
				<td colspan="3" class="DataTD">
					<textarea rows="4" cols="20" id="modalRemark" name="menuInfo.remark"  multiline="true" class=""></textarea>
				</td>
				
			</tr>
		 </tbody>
		 </table>
         </div>		
         
         <div class="widget-toolbox padding-4 clearfix">
         	<button type="button" class="btn btn-sm btn-default pull-right">
            	关闭
            </button>
            <div class="col-sm-1 pull-right"></div>
         	<button type="button"  class="btn btn-sm btn-primary pull-right" id="modalSubmit">
    		</button>
		</div>	
						</div>
					</div>
				</div>
				
				<!-- 
				<input id="inputid" type="text" value=""/>
				<div id="xx">123</div>
				 -->
	
			</div>

		<!-- scripts -->
		<script src="assets/js/jquery-1.10.2.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.nestable.min.js"></script>
		<script src="assets/js/jquery-smartMenu.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		<script type="text/javascript">
		var menuId="";
		var parentId="";
		var flag;//添加or更新flag,1 or 2
		var html = "<ol class=\"dd-list\">";
		//进页面加载menu
		$(document).ready(function(){
			var params = {
                "roleId": ""
            };
			var resData = ajaxCRUD("menu!menuTree.do", params, false);
			buildMenu(resData);
			buildSelectMenu(resData);
			$("#modalSubmit").text("添加");
			$("#modalSubmit").attr("disabled","disabled");
		});
		
		function  buildSelectMenu(resData){
			var menuSelect = resData.menuList;
			var menuHtml = "<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>";
			$(menuSelect).each(function(index) {
				var menu = menuSelect[index];
				menuHtml += "<option role=\"option\" value=\"" + menu.id + "\">" + menu.menuName + "</option>";
			});
			$("#modalParent").append(menuHtml);

		}
		
		//菜单右键text
		var imageMenuData = [
    		[{
        		text: "添加平级菜单",
        		func: function() {
    				flag=1;
    				clearWindow();
    				$("#modalSubmit").text("添加");
        			$("#modalParent").val(parentId);
        			$("#modalSubmit").removeAttr("disabled");	
        		}
    		}, {
        		text: "添加子菜单",
        		func: function() {
    				clearWindow();
    				$("#modalSubmit").text("添加");
    				flag=1;
       				$("#modalParent").val(id);
       				$("#modalSubmit").removeAttr("disabled");  
      		  	}
    		}, {
        		text: "编辑当前菜单",
        		func: function() {
    				updateWindow(id);
    				$("#modalSubmit").removeAttr("disabled"); 
        		}
    		}, {
        		text: "删除当前菜单",
        		func: function() {
    				del(id);
        		}
    		}]
		];
		
		//菜单初始
        var data = ""
		//移动菜单后
		var dataChange="";
		//可移动菜单代码
		jQuery(function($){
			$('.dd').nestable();
			$('.dd-handle a').on('mousedown', function(e){
				e.stopPropagation();
			});
			$('[data-rel="tooltip"]').tooltip();
			var ra = $('.dd').nestable('serialize'); 
			data = JSON.stringify(ra).replace(/\"/g,"'");
        	
			$('#nestable').nestable().on('change', function(){ 
            	var r = $('.dd').nestable('serialize'); 
            	dataChange = JSON.stringify(r).replace(/\"/g,"'");
        	});
        	$('.dd').nestable('collapseAll');
		});


		
		//update数据加载
		function updateWindow(menuId) {
			var params = {
				"menuId": menuId
			};
			var resData = ajaxCRUD("menu!selectMenuById.do",params,false);
			var menu= resData.menu;
			clearWindow();
			$("#modalSubmit").text("更新");
			$("#modalId").val(menu.id);
        	$("#modalName").val(menu.menuName);
        	$("#modalDesc").val(menu.menuDesc);
        	$("#modalIco").val(menu.menuIcon);
        	$("#modalUrl").val(menu.menuUrl);
        	$("#modalParent").val(menu.parentId);
        	$("#modalSort").val(menu.disOrder);
        	$("#modalRemark").val(menu.remark);
        	$("#modalCreateTime").val(menu.createTime);
        	flag = 2; //更新flag
    	}
		
		//按钮提交
		$("#modalSubmit").click(function(){//save
			if ($("#modalName").val() == "") {
				return bbAlert("请输入菜单名称");
				return;
			}
			if ($("#modalSort").val() == "" || isNaN($("#modalSort").val())) {
				$("#modalSort").val("0");
			}
				if(flag==2){
					fromSubmin("menu!updateMenu.do",flag);
				}else if(flag==1){
					fromSubmin("menu!insertMenu.do",flag);
				}
				$("#modalSubmit").attr("disabled","disabled");
	 	});
		
		////更新拖动树
		$("#updateTree").click(function(){//save
			if(dataChange==""){
				bootbox.alert({
					locale : "zh_CN",
					size : 'small',
					title : "提示",
					message : "没有修改记录"
				});
				return false;
			}
			var params = {
				"dataChange":dataChange,
				"data":data
			};
			var resData = ajaxCRUD("menu!updateTree.do",params,true);
			//重建nestable
			rebuildMenu(resData);
	 	});
		
		
		//添加or修改
		function fromSubmin(url,flag) {
        	var rid = $("#modalId").val();
        	var rname = $("#modalName").val();
        	var rdesc = $("#modalDesc").val();
        	var rico = $("#modalIco").val();
        	var rurl = $("#modalUrl").val();
        	var rParent = $("#modalParent").val();
        	var rSort = $("#modalSort").val();
        	var rremark = $("#modalRemark").val();
        	var params;
        	if(flag==1){
        		params = {
        					"menu.parentId":rParent,
							"menu.menuName":rname,
        					"menu.menuDesc":rdesc,
        					"menu.menuIcon":rico,
        					"menu.menuUrl":rurl,
        					"menu.disOrder":rSort,
        					"menu.remark":rremark
						};
        	}else{
				params = {
							"menu.id":rid,
        					"menu.parentId":rParent,
							"menu.menuName":rname,
        					"menu.menuDesc":rdesc,
        					"menu.menuIcon":rico,
        					"menu.menuUrl":rurl,
        					"menu.disOrder":rSort,
        					"menu.remark":rremark
						};
        	}
			var resData = ajaxCRUD(url, params, true); //url，参数，是否弹出alert
			$("#modalParent").text("");
  			buildSelectMenu(resData);
			rebuildMenu(resData);
			var ra = $('.dd').nestable('serialize'); 
        	clearWindow();
			data = JSON.stringify(ra).replace(/\"/g,"'");
		}
		
		function del(menuId){
        	bootbox.confirm({
        		locale: "zh_CN",
    			size: 'small',
    			title:"提示",
   				message: "确认要删除？", 
    			callback: function(result){
        			if(result){
						var params = {
							"menuId":menuId
						};
						var resData = ajaxCRUD("menu!deleteMenu.do", params, true);
						if (resData.resNum == "1") {
							$("#modalParent").text("");
  							buildSelectMenu(resData);
							rebuildMenu(resData);
							var ra = $('.dd').nestable('serialize'); 
							data = JSON.stringify(ra).replace(/\"/g,"'");
						}
					}
				}	
			});
		}
		
		//清空 添加/修改 区域
		function clearWindow() {
			$("#modalId").val("");
	        $("#modalName").val("");
	        $("#modalDesc").val("");
	        $("#modalIco").val("");
	        $("#modalUrl").val("");
	        $("#modalParent").val("");
	        $("#modalSort").val("");
	        $("#modalRemark").val("");
	        $("#modalSubmit").text("添加");
    	}
		
		
		///////////////////////////nestable 创建Menu方法///////////////////////////////
		//创建Menu
		function buildMenu(resData){
			var menuList = resData.menuList;
			$(menuList).each(function(index) {
				var menu = menuList[index];
				if(menu.parentId == undefined || menu.parentId == ""){
					buildMenuChild(menu.id, menu.menuName ,menu.parentId, menuList);
				}
          	});
			html += "</ol>";
			$('#nestable').append(html);
			//菜单右键事件方法
			$("#nestable li").smartMenu(imageMenuData,{
				afterShow:function() {
					id = $(this).attr('data-id');
					parentId = $(this).attr('id').split("-")[1].split(":")[1];
            	}
			});
		}
		
		//创建menu子节点
		function buildMenuChild(id, menuName, parentId, menuList){
			html += "<li id=\"menuId:" + id + "-parentId:" + parentId + "\"class=\"dd-item\" data-id=" + id + " >" +
					"<div class=\"dd-handle\">" + menuName + "</div>" ;
			if(hasChild(id, menuList)>0){
            		html += "<ol class=\"dd-list\">";
            		$(menuList).each(function(index) {
            			var menu = menuList[index];
            			if(id == menu.parentId){
            				buildMenuChild(menu.id, menu.menuName, menu.parentId, menuList);
            			}
            		});	
            		html += "</ol>";
			}
			html += "</li>";
		}
		
		//重建nestable
		function rebuildMenu(resData){
			html = "<ol class=\"dd-list\">";
			$('#nestable').text("");
			buildMenu(resData);
			//重新定义新的data，与上次更新data相同
			data = resData.dataChange;
			//$("#xx").html(data);
			//为nestable添加button
			$('#nestable li').each(function(){
				var li = $(this);
      			var le = li.children("ol").length;
      			if (le) {
                li.prepend('<button data-action="expand" type="button">Expand</button>');
                li.prepend('<button data-action="collapse" type="button">Collapse</button>');
            	}
            	li.children('[data-action="expand"]').hide();
    		});
    		$('.dd').nestable('collapseAll');
		} 
		/////////////////////////////////////////////////////////////////////////////////

</script>
	</body>
</html>
