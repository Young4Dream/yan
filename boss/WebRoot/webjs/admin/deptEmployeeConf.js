		//树的配置
		var setting = {
			view : {
				showIcon : false,
				showLine : false
			//是否显示节点间的连线   
			},
			check : {
				enable : true
			},
			data : {
				simpleData : {
				enable : true
				}
			}
		};

		//页面初始状态加载树
		var zTree;
		var treeNodes;
		
		$(document).ready(function(){
			buildDept();
			//econf(0);
		});
		
		
		
		function  buildDept(){
			var resData = ajaxCRUD("empl!deptSelectList.do",{},false);//url，参数，是否弹出alert
			var deptSelect = resData.deptSelect;
			var html = "";
			$(deptSelect).each(function(index) {
				var dept = deptSelect[index];
				html += "<option role=\"option\" value=\""+dept.dept_id+"\">"+dept.dept_name+"</option>";
			});
			$('#eseemplDept').append(html);
			$('#emodalDeptId').append(html);
			$('#dseParentId').append(html);
			$('#dmodalparent').append(html);

		}
		
//		//角色配置菜单权限
//		function econf(id) {
//		//$("#roleId").val(id);
//			var params = {
//				"employeeId" : id
//			};
//			var resData = ajaxCRUD("empl!skillTree.do", params, false);//url，参数，是否弹出alert
//			if (resData.resNum != 0) {
//				treeNodes = resData.skillTree;
//				//重新构造树
//				$.fn.zTree.init($("#treeDemo"), setting, treeNodes);
//			}
//		}
		
		
		
		
		
        var emplTable;
		var eparam;
        var deptTable;
        var dparam = {
            "deptInfo.parentId" : -1
		};
		
		jQuery(function($) {
		emplTable = $('#emplTable').dataTable({
			"serverSide": true,//服务器模式，分页用
			"ajax":{
            	"type": "post",
            	"url": "empl!selectEmplList.do",
            	"data":eparam,
            	"dataSrc": "emplList"
            },
            "aoColumns": [ 
            	{"mDataProp":"employeeno"},
    			{"mDataProp":"name"},
    			{"mDataProp":"type"},
    			{"mDataProp":"deptname"},
    			{"mDataProp":"tel"},
    			{"mDataProp":"joindate"},
				{"mDataProp":""}
    		],
			 columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "edetailWindow(" + JSON.stringify(c) + ")", "color": "blue","icon": "zoom-in"},
                                {"fn": "eupdateWindow("+ JSON.stringify(c) +")", "color": "red","icon": "pencil"},
								{"fn": "edel(" + c.employeeid + ",'" + c.memo1 + "','" + (!c.employeeno ? "" : c.employeeno) +"')", "color": "red","icon": "trash"}
								
								//{"fn": "econf(" + c.employeeid + ",\'" + c.memo1 + ",\'" + c.employeeno +")", "color": "green","icon": "cog"}
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
		
		$("#esearch").click(function(){//dept查询
				var eseemplNo = $("#eseemplNo").val();
				var eseemplName = $("#eseemplName").val();
				var eseemplDept = $("#eseemplDept").val();
				var eseemplType = $("#eseemplType").val();
        		param = {
            		"employeeInfo.employeeNo" : eseemplNo,
            		"employeeInfo.name" : eseemplName,
            		"employeeInfo.deptId" : eseemplDept,
            		"employeeInfo.type" : eseemplType
				 };
        		emplTable.fnSettings().ajax.data=param;
				emplTable.api().ajax.reload();
	 	});
		
		$("#esave").click(function(){//模态框 save
				var flag = $("#eflag").val();
				var psw = $("#emodalPw").val();
				var emodalEmplNo = $("#emodalEmplNo").val();
				var emodalDeptId = $("#emodalDeptId").val();
				var bossUserId = $("#emodalType").val();
				var bossPwd=$("#emodalBossPwd").val();
				//工号不能为空
                if(emodalEmplNo == ""){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入工号！"
                    });
                    $("#emodalEmplNo").focus();
                    return false;
                }
                
                //密码不能为空
                if(psw == ""){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入密码！"
                    });
                    $("#emodalPw").focus();
                    return false;
                }
                
                //BOSS系统工号不能为空
                if(bossUserId == ""){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入BOSS系统工号！"
                    });
                    $("#emodalType").focus();
                    return false;
                }                 
                //BOSS系统密码不能为空
                if(bossPwd==""){
                	bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请输入BOSS系统密码！"
                    });
                    $("#emodalBossPwd").focus();
                    return false;
                }
                //alert("emodalDeptId:" + emodalDeptId + ";");
                if(emodalDeptId == null){
                    bootbox.alert({
                        locale : "zh_CN",
                        size : 'small',
                        title : "提示",
                        message : "请选择所属部门！"
                    });
                    $("#emodalDeptId").focus();
                    return false;
                }
                				
				if(flag=="add"){
				    window.parent.agent_manage_add(emodalEmplNo);
					efromSubmin("empl!insertEmpl.do");
				}else if(flag=="update"){
					efromSubmin("empl!updataEmpl.do");
				}
				$("#empModal").modal("hide");
	 	});
		
		$("#eaddbutton").click(function(){//添加 弹出模态框
				$("#eModalLabel").text("添加");
				eclearWindow();
				$("#eflag").val("add");
				$("#esave").show();
				$("#empModal").modal("show");		
	 	});
		
		
		///////////////////////////////////////////////////////////////////////////////////
		deptTable = $('#deptTable').dataTable({
			"serverSide": true,//服务器模式，分页用
			"ajax":{
            	"type": "post",
            	"url": "empl!selectDeptList.do",
            	"data":dparam,
            	"dataSrc": "deptList"
            },
            "aoColumns": [ 
            	{"mDataProp":"dept_name"},
    			{"mDataProp":"parent_name"},
				{"mDataProp":""}
    		],
			 columnDefs: [
                {
                    targets: 2,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "ddetailWindow(" + JSON.stringify(c) + ")", "color": "blue","icon": "zoom-in"},
                                {"fn": "dupdateWindow("+ JSON.stringify(c) +")", "color": "red","icon": "pencil"},
								{"fn": "ddel(" + c.dept_id + ")", "color": "red","icon": "trash"}
								
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
		//////////////////////////////////////////////////////////////////////////////////////////
		
			
			
			$("#daddbutton").click(function(){//  dept 添加 弹出模态框
				$("#dModalLabel").text("添加");
				dclearWindow();
				$("#dflag").val("add");
				$("#dsave").show();
				$("#deptModal").modal("show");
	 		});
	 		

			$("#dsave").click(function(){//模态框 save
				var flag = $("#dflag").val();
				if(flag=="add"){
					dfromSubmin("empl!insertDept.do");
				}else if(flag=="update"){
					dfromSubmin("empl!updataDept.do");
				}
				$("#deptModal").modal("hide");
	 		});
			
			
			$("#dsearch").click(function(){//dept查询
				var name = $("#dseName").val();
				var parent = $("#dseParentId").val();
        		param = {
            		"deptInfo.deptName" : name,
            		"deptInfo.parentId" : parent
				 };
        		deptTable.fnSettings().ajax.data=param;
				deptTable.api().ajax.reload();
	 		});
		//////////////////////////////////////////////////////////////////////////////////////////////////
	 		
//	 		//保存菜单配置
//			$("#saveMenu").click(function(){
//				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//				var nodes = treeObj.getChangeCheckedNodes();
//				var menuChange = "";
//				for (var i=0, l=nodes.length; i<l; i++) {
//					if(i==l-1){
//						menuChange+=nodes[i].id+"-"+nodes[i].checked;
//					}else{
//						menuChange+=nodes[i].id+"-"+nodes[i].checked+","
//					}
//				}
//				var roleId =$("#roleId").val();					
//				var params = {
//						"menuChange":menuChange,
//						"roleId":roleId
//					};
//				var resData = ajaxCRUD("role!menuChange.do", params,true);
//				if(resData.resNum!=0){
//					treeNodes = resData.jsArray;
//      				//重新构造树
//      				$.fn.zTree.init($("#treeDemo"), setting, treeNodes);
//				}
//				
//	 		});
	 		
	 		
		
		
			$('.date-picker').datepicker({autoclose:true}).next().on("click", function(){
					$(this).prev().focus();
			});
		
		})
		
		
		function edetailWindow(emplList){//employee弹出查看详细信息模态框
					$("#eModalLabel").text("详细信息");
					eclearWindow();
					$("#emodalEmplNo").attr("readonly","readonly");//将元素设置为readonly
  					$("#emodalEmplId").val(emplList.employeeid);
  					$("#emodalEmplNo").val(emplList.employeeno);
  					$("#emodalJoinDate").val(emplList.joindate);
					$("#emodalName").val(emplList.name);
        			$("#emodalPw").val(emplList.password);
        			$("#emodalType").val(emplList.type);
        			$("#emodalBossPwd").val(emplList.boss_pwd);
        			$("#emodalDeptId").val(emplList.deptid);
        			$("#emodalGender").val(emplList.gender);
        			$("#emodalAge").val(emplList.age);
        			$("#emodalBirthday").val(emplList.birthday);
        			$("#emodalTel").val(emplList.tel);
        			$("#emodalMobile").val(emplList.mobile);
        			$("#emodalEmail").val(emplList.email);
        			$("#emodalCertificateId").val(emplList.certificateid);
        			$("#emodalIsAgent").val(emplList.isagent);
        			$("#emodalMonitorDept").val(emplList.monitordept);
        			$("#emodalmemo1").val(emplList.memo1);
        			$("#esave").hide()
        			$("#empModal").modal("show");
   		}
		function eupdateWindow(emplList) {//弹出修改模态框
					$("#eModalLabel").text("修改");
					eclearWindow();
					$("#emodalEmplNo").attr("readonly","readonly");//将元素设置为readonly
					$("#eflag").val("update");
					$("#emodalEmplId").val(emplList.employeeid);
  					$("#emodalJoinDate").val(emplList.joindate);
  					$("#emodalEmplNo").val(emplList.employeeno);
					$("#emodalName").val(emplList.name);
        			$("#emodalPw").val(emplList.password);
        			$("#emodalType").val(emplList.type);
        			$("#emodalBossPwd").val(emplList.boss_pwd);
        			$("#emodalDeptId").val(emplList.deptid);
        			$("#emodalGender").val(emplList.gender);
        			$("#emodalAge").val(emplList.age);
        			$("#emodalBirthday").val(emplList.birthday);
        			$("#emodalTel").val(emplList.tel);
        			$("#emodalMobile").val(emplList.mobile);
        			$("#emodalEmail").val(emplList.email);
        			$("#emodalCertificateId").val(emplList.certificateid);
        			$("#emodalIsAgent").val(emplList.isagent);
        			$("#emodalMonitorDept").val(emplList.monitordept);
        			$("#emodalmemo1").val(emplList.memo1);
        			$("#esave").show()
        			$("#empModal").modal("show");
   				}
		function eclearWindow() {
					$("#emodalEmplId").val(0);
  					$("#emodalJoinDate").val("");
					$("#emodalEmplNo").val("");
					$("#emodalName").val("");
        			$("#emodalPw").val("");
        			$("#emodalType").val("");
        			$("#emodalBossPwd").val("");
        			$("#emodalDeptId").val("");
        			$("#emodalGender").val("");
        			$("#emodalAge").val("");
        			$("#emodalBirthday").val("");
        			$("#emodalTel").val("");
        			$("#emodalMobile").val("");
        			$("#emodalEmail").val("");
        			$("#emodalCertificateId").val("");
        			$("#emodalIsAgent").val("");
        			$("#emodalMonitorDept").val("");
        			$("#emodalmemo1").val("");
        			$("#eflag").val("");
        			$("#emodalEmplNo").removeAttr("readonly");//去除元素的readonly属性
    	}
		
		//添加or修改
		function efromSubmin(url) {
			var empId = $("#emodalEmplId").val();
  			var emplJoinDate = $("#emodalJoinDate").val();
			var empNo = $("#emodalEmplNo").val();
			var empName = $("#emodalName").val();
        	var empPw = $("#emodalPw").val();
        	var empType = $("#emodalType").val();
        	var empBossPwd=$("#emodalBossPwd").val();
        	var empDeptId = $("#emodalDeptId").val();
        	var empGender = $("#emodalGender").val();
        	var empAge = $("#emodalAge").val();
        	var empBirthday = $("#emodalBirthday").val();
        	var empTel = $("#emodalTel").val();
        	var empMobile = $("#emodalMobile").val();
        	var empEmail = $("#emodalEmail").val();
        	var empCert = $("#emodalCertificateId").val();
        	var empIsAgent = $("#emodalIsAgent").val();
        	var empMon = $("#emodalMonitorDept").val();
        	var memo1 = $("#emodalmemo1").val();
			
			var params = {
					"employeeInfo.employeeId" : empId,
					"employeeInfo.employeeNo" : empNo,
            		"employeeInfo.name" : empName,
            		"employeeInfo.deptId" : empDeptId,
            		"employeeInfo.type" : empType,
            		"employeeInfo.bossPwd":empBossPwd,
            		"employeeInfo.password" : empPw,
            		"employeeInfo.gender" : empGender,
            		"employeeInfo.age" : empAge,
            		"employeeInfo.birthday" : empBirthday,
            		"employeeInfo.joinDate" : emplJoinDate,
            		"employeeInfo.tel" : empTel,
            		"employeeInfo.mobile" : empMobile,
            		"employeeInfo.email" : empEmail,
            		"employeeInfo.certificateId" : empCert,
            		"employeeInfo.isAgent" : empIsAgent,
            		"employeeInfo.monitorDept" : empMon,
            		"employeeInfo.memo1" : memo1
						};
			var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
			if(resData.resNum!=0){
				emplTable.fnSettings().ajax.data = {};// 定义dataTable初始参数
				emplTable.api().ajax.reload();
			}
		}
		
		//删除
		function edel(empid,memo1,empNo) {
			if(userName==empNo){
				bootbox.alert({
					locale : "zh_CN",
					size : 'small',
					title : "提示",
					message : "正在使用中，不能删除！"
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
							"employeeId":empid,
							"userId":memo1							
						};
						//向后台CTI服务器发送删除座席指令
						window.parent.agent_manage_del(empNo);
						
						var resData = ajaxCRUD("empl!deleteEmpl.do",params,true);//url，参数，是否弹出alert
						if(resData.resNum!=0){
							emplTable.fnSettings().ajax.data = {};// 定义dataTable初始参数
							emplTable.api().ajax.reload();
	                    }
	                }
                }
            });
		}
		
		function ddetailWindow(deptList){//employee弹出查看详细信息模态框
			$("#dModalLabel").text("详细信息");
			dclearWindow();
			$("#dmodaldeptId").val(deptList.dept_id);
			$("#dmodalName").val(deptList.dept_name);
			$("#dmodalparent").val(deptList.parent_id);
			$("#dsave").hide()
			$("#deptModal").modal("show");
   		}
   		
		function dupdateWindow(deptList) {//弹出修改模态框
			$("#dModalLabel").text("修改");
			dclearWindow();
			$("#dflag").val("update");
			$("#dmodaldeptId").val(deptList.dept_id);
			$("#dmodalName").val(deptList.dept_name);
			$("#dmodalparent").val(deptList.parent_id);
			$("#dsave").show()
			$("#deptModal").modal("show");
        }
        
		function dclearWindow() {
			$("#dmodaldeptId").val("");
            $("#dmodalName").val("");
			$("#dmodalparent").val("");
			$("#dflag").val("");
    	}
		
		//添加or修改
		function dfromSubmin(url) {
			var deptId = $("#dmodaldeptId").val();
  			var deptName = $("#dmodalName").val();
			var deptParent = $("#dmodalparent").val();

			
			var params = {
					"deptInfo.deptId" : deptId,
					"deptInfo.deptName" : deptName,
            		"deptInfo.parentId" : deptParent
						};
			var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
			if(resData.resNum!=0){
				$('#eseemplDept').text("");
				$('#emodalDeptId').text("");
				$('#dseParentId').text("");
				$('#dmodalparent').text("");
				
				$('#eseemplDept').append("<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>");
				$('#dmodalparent').append("<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>");
				$('#dseParentId').append("<option role=\"option\" value=\"-1\">&nbsp;&nbsp;</option>");

				//"<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>"
				buildDept();
				deptTable.fnSettings().ajax.data = dparam;// 定义dataTable初始参数
				deptTable.api().ajax.reload();
			}
		}
		
			//删除
		function ddel(id) {
   			bootbox.confirm({
   				locale: "zh_CN",
				size: 'small',
				title:"提示",
				message: "确认要删除？", 
				callback: function(result){
   					if(result){
						var params = {
							"deptId":id
						};
		                var resData = ajaxCRUD("empl!deleteDept.do",params,true);//url，参数，是否弹出alert
						if(resData.resNum!=0){
							$('#eseemplDept').text("");
							$('#emodalDeptId').text("");
							$('#dseParentId').text("");
							$('#dmodalparent').text("");
			
							$('#eseemplDept').append("<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>");
							$('#dmodalparent').append("<option role=\"option\" value=\"0\">&nbsp;&nbsp;</option>");
							$('#dseParentId').append("<option role=\"option\" value=\"-1\">&nbsp;&nbsp;</option>");
			
							buildDept();
							deptTable.fnSettings().ajax.data = dparam;// 定义dataTable初始参数
							deptTable.api().ajax.reload();
						}
                    }
                }
            });
        }
		
		
		
		
		
		
		
		
		
		
		
		

