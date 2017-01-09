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
		<link rel="stylesheet" href="assets/css/ace.skins.css" />
			
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		<!-- zTree -->
		<link rel="stylesheet" href="assets/css/zTreeStyle/metro.css">
		<!-- <link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" type="text/css">
		 -->
		 
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
		<!-- zTree -->
		<script src="assets/js/jquery.ztree.core-3.5.js"></script>
		<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">资源管理</a>
				</li>
				<li class="active">
					用户地址
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>


		<div class="page-content">
			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">
					<div id="ne" class="tab-pane">
						<div class="col-sm-12">
                            <div class="row">
                            <!-- treeview -->
                            <div class="widget-box widget-color-blue2">
                            	<div class="widget-header">
                            		<h4 class="widget-title lighter smaller">
                            			<i class="icon-building blue bigger-110"></i>
                            			地址
                            		</h4>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<div class="btn-group">
                            					<button class="btn btn-sm btn-success btn-white btn-round" id="newBrother">
                            						<i class="icon-plus green"></i>
                            						添加同级
                            					</button>
                            					<button class="btn btn-sm btn-success btn-white btn-round" id="newChild">
                            						<i class="icon-cloud-download bigger-110 green"></i>
                            						添加下级
                            					</button>
                            					<button class="btn btn-sm btn-success btn-white btn-round" id="edit">
                            						<i class="icon-pencil bigger-110 blue"></i>
                            						修改
                            					</button>
                            					<button class="btn btn-sm btn-success btn-white btn-round" id="del">
                            						<i class="icon-trash bigger-110 red"></i>
                            						删除
                            					</button>
                            				</div>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
                            			<ul id="tree" class="ztree" style="overflow:auto;"></ul>
                            		</div>
                            	</div>
                            </div>
                            </div>
                            
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="dlg" tabindex="-1" role="dialog"
			aria-labelledby="eModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:50%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="dlg_title">
						</h4>
					</div>

					<input type="hidden" id="flag" value="">
					<input type="hidden" id="id" value="">
					<input type="hidden" id="parentId" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									地址
								</label>
								<div class="col-xs-9">
									<input type="text" id="name" class="form-control" placeholder="请输入地址"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									VLAN
								</label>
								<div class="col-xs-9">
									<input type="text" id="vlan" class="form-control" placeholder="请输入VLAN"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									宽带账号前缀
								</label>
								<div class="col-xs-9">
									<input type="text" id="accPrefix" class="form-control" placeholder="请输入宽带账号前缀，多个以逗号分隔"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									业务区域
								</label>
								<div class="col-xs-9">
									<select class="form-control" id="businessArea"/>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label no-padding">
									用户区域
								</label>
								<div class="col-xs-9">
									<select class="form-control" id="userArea"/>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary " id="save">
							提交
						</button>
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
							关闭
						</button>
					</div>


				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<script type="text/javascript">
		

    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		$(function () {
			loadRef("ref_business_area", "businessArea", "--业务区域--");
			loadRef("ref_user_area", "userArea", "--用户区域--");
			initTree();
		});
		
    	/////////////////////////////////////////////////////////////////////////////////
		// 装载数据
		/////////////////////////////////////////////////////////////////////////////////
		var zTreeObj;
    	//树的配置
    	var setting = {
	        data: {
            	simpleData: {
                	enable: true
            	}
        	}
    	};
		
		function initTree(){
			var res = ajaxCRUD("resAddress!findAll2Tree.do", {}, false);
			zTreeObj = $.fn.zTree.init($("#tree"), setting, res.ztree);																	
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		// 事件处理
		/////////////////////////////////////////////////////////////////////////////////
		function getSelectedNode(prompt) {
			var nodes = zTreeObj.getSelectedNodes();
			if (nodes == undefined || nodes.length == 0) {
				if (prompt) {
					bbAlert("请选择节点");
				}
				return undefined;
			} else {
				return nodes[0];
			}
		}
		
		$("#del").click(function() {
			var node = getSelectedNode(true);
			if (node == undefined) return;
			if (node.children != undefined && node.children != null && node.children.length > 0) {
				bbAlert("无法删除： 请先删除子节点");
				return;
			}
	   		bootbox.confirm({
	   			locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除该节点吗？", 
				callback: function(result){
	   				if(result){
						var parm = {"id": node.id };
					    var resData = ajaxCRUD("resAddress!delete.do", parm, true);
						if(resData.resNum == "0"){
							zTreeObj.removeNode(node);
						}
	            	}
	            }
	    	});
		});
		
		$("#edit").click(function() {
			var node = getSelectedNode(true);
			if (node == undefined) return;
			showUpdateDlg(node);
		});
		
        $("#newBrother").click(function() { 
			var node = getSelectedNode(false);
			var parm = {id: "", name: "", vlan: "", accPrefix: "", pId: "", businessArea: "" };
			if (node != undefined) {
				if (node.pId != undefined && node.pId != "") {
					var parent = zTreeObj.getNodeByParam("id", node.pId);
					if (parent != null) {
						parm = parent;
					}
				}
			}
        	showNewDlg(parm);
        });
        
        $("#newChild").click(function() {
			var node = getSelectedNode(true);
			if (node == undefined) return;
			showNewDlg(node);
        });
        
        $("#save").click(function() {
        	if ($("#name").val() == "") {
        		alert("请输入地址");
        		return;
        	}
        	var flag = $("#flag").val();
        	var url;
        	if (flag == "add") {
        		url = "resAddress!insert.do";
        	} else {
        		url = "resAddress!update.do";
        	}
        	var parm = {
    			"obj.id": $("#id").val(),
     			"obj.parentId": $("#parentId").val(),
    			"obj.name": $("#name").val(),
    			"obj.vlan": $("#vlan").val(),
    			"obj.accPrefix": $("#accPrefix").val(),
    			"obj.businessArea": $("#businessArea").val(),
    			"obj.userArea": $("#userArea").val(),
        	};
        	
        	var resData = ajaxCRUD(url, parm, true);
        	if (resData.resNum == "0") {
        		// refresh treeview
        		var obj = resData.obj;
        		if (flag == "add") {
        			// 添加节点
        			var newNode = {
        				id: obj.id,
        				name: obj.name,
        				pId: obj.parentId,
        				vlan: obj.vlan,
        				accPrefix: obj.accPrefix,
        				businessArea: obj.businessArea,
        				userArea: obj.userArea
        			};
        			if (newNode.pId == undefined || newNode.pId == null || newNode.pId == "") {
        				// 添加根节点
        				var nodes = [];
        				nodes.push(newNode);
        				zTreeObj.addNodes(null, nodes);
        			} else {
        				var parent = zTreeObj.getNodeByParam("id", newNode.pId);
        				if (parent == null) {
							bootbox.alert({
								locale : "zh_CN",
								size : 'small',
								title : "提示",
								message : "未知错误： 无法找到上级节点"
							});
        				} else {
        					// 直接添加下级节点
        					var nodes = [];
        					nodes.push(newNode);
        					zTreeObj.addNodes(parent, nodes);
        				}
        			}
        		} else {
        			var node = getSelectedNode(false);
        			node.name = $("#name").val();
        			node.vlan = $("#vlan").val();
        			node.accPrefix = $("#accPrefix").val();
        			node.businessArea = $("#businessArea").val();
        			node.userArea = $("#userArea").val();
        			zTreeObj.updateNode(node, false);
        		}
				$("#dlg").modal("hide");
        	}
        });
        
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showNewDlg(obj) {
            $("#dlg_title").text("添加");
            clear(obj);
            $("#flag").val("add");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showUpdateDlg(obj) {
            $("#dlg_title").text("修改");
        	detail(obj);
            $("#flag").val("edit");
            $("#save").show();
            $("#dlg").modal("show");
        }
        
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#name").val(obj.name);
        	$("#parentId").val(obj.pId);
        	$("#vlan").val(obj.vlan);
        	$("#accPrefix").val(obj.accPrefix);
        	$("#businessArea").val(obj.businessArea);
        	$("#userArea").val(obj.userArea);
        }

    	function clear(obj) {
    		$("#id").val("");
        	$("#name").val("");
        	$("#parentId").val(obj.id);
        	$("#vlan").val(obj.vlan);
        	$("#accPrefix").val(obj.accPrefix);
        	$("#businessArea").val(obj.businessArea);
        	$("#userArea").val(obj.userArea);
    	}

		</script>

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
