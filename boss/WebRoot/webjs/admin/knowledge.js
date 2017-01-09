// 点击事件 知识种类添加 弹出模态框		
$("#kcaddbutton").click(function(){
				$("#kcModalLabel").text("添加");
				kCclearWindow();
				$("#kcflag").val("add");
				$("#kcsave").show();
				$("#knowledgeClassModel").modal("show");
});

$(document).ready(function(){
	buildKnowClass();
	$("#knowList").trigger("click");
});
//清除知识种类对话框中  input文字
function kCclearWindow() {
	$("#kcmodalName").val("");
	$("#klcOrder").val("");
	$("#kcmodalparent").val("");
	$("#kcflag").val("");
}
//添加或修改知识种类
$("#kcsave").click(function(){
	var kcId = $("#kcmodalId").val();
	var kcName = $("#kcmodalName").val();
	var kcparent = $("#kcmodalparent").val();
	var klcOrder=$("#klcOrder").val();
	//种类名称不能为空
    if(kcName == ""){
        bootbox.alert({
            locale : "zh_CN",
            size : 'small',
            title : "提示",
            message : "请输入知识所属种类！"
        });
        $("#kcmodalName").focus();
        return false;
    }
    
	var flag = $("#kcflag").val();
	if(flag=="add"){
		kcfromSubmin("knowledge!insertKnowledgeClass.do");
	}else if(flag=="update"){
		kcfromSubmin("knowledge!updateKnowledgeClass.do");
	}
	$("#knowClassModal").modal("hide");
});
//////////////////////////////////为知识种类绑定Table开始/////////////////////////////////////////////////
var knowClassParam;
var knowClassTable;
$(function(){
	knowClassTable = $('#knowClassTable').dataTable({
		"serverSide": true,//服务器模式，分页用
		"ajax":{
	    	"type": "post",
	    	"url": "knowledge!getKnowClassListByPage.do",
	    	"data":knowClassParam,
	    	"dataSrc": "tableKnowledgeClass"
	    },
	    "aoColumns": [ 
	    	{"mDataProp":"klc_name"},
			{"mDataProp":"klc_parent_name"},
			{"mDataProp":"klc_order"},
			{"mDataProp":""}
		],
		 columnDefs: [
	        {
	            targets: 3,
	            render: function (a, b, c, d) {
	                var context =
	                {
	                    func: [
	                        {"fn": "kcupdateWindow("+ JSON.stringify(c) +")", "color": "red","icon": "pencil"},
							{"fn": "kcdel(" + c.klc_id + ")", "color": "red","icon": "trash"}
							
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
});

////////////////////////////////////////////为知识种类绑定Table结束//////////////////////////////////////////////
//添加or修改 知识种类
function kcfromSubmin(url) {
	var kcId = $("#kcmodalId").val();
	var kcName = $("#kcmodalName").val();
	var kcparent = $("#kcmodalparent").val();
	var klcOrder=$("#klcOrder").val();
	//发送参数
	var params = {
			"knowledgeClass.klcId" : kcId,
			"knowledgeClass.klcName" : kcName,
    		"knowledgeClass.klcParentid" : kcparent,
    		"knowledgeClass.klcOrder":klcOrder
				};
	var resData = ajaxCRUD(url,params,true);//url，参数，是否弹出alert
	if(resData.resNum!=0){
		
		buildKnowClass();
		
		knowClassTable.fnSettings().ajax.data = knowClassParam;// 定义dataTable初始参数
		knowClassTable.api().ajax.reload();
	}
}
//为知识种类下拉菜单绑定内容
function  buildKnowClass(){
	var resData = ajaxCRUD("knowledge!selectAllKnowClass.do",{},false);//url，参数，是否弹出alert
	var knowClassSelect = resData.selectKnowledgeClass;
	$("#kcmodalparent").empty(); 
	$("#knowOfClass").empty();
	$("#quKnowClassByKnow").empty();
	var html = "<option role=\"option\" value=\"\">"+"</option>";
	$(knowClassSelect).each(function(index) {
		var knowClass = knowClassSelect[index];
		
		html += "<option role=\"option\" value=\""+knowClass.klc_id+"\">"+knowClass.klc_name+"</option>";
	});
	$("#quKnowClassByKnow").append(html);
	$("#knowOfClass").append(html);
	$('#kcmodalparent').append(html);

}

//打开知识种类编辑模态框
function kcupdateWindow(knowClass){
	$("#kcModalLabel").text("修改");
	kCclearWindow();
	$("#kcflag").val("update");
	$("#kcmodalId").val(knowClass.klc_id);
	$("#kcmodalName").val(knowClass.klc_name);
	$("#kcmodalparent").val(knowClass.klc_parentid);
	$("#klcOrder").val(knowClass.klc_order);
	$("#kcsave").show();
	$("#knowledgeClassModel").modal("show");
}
//删除某条知识种类
function kcdel(id){
	bootbox.confirm({
	locale: "zh_CN",
	size: 'small',
	title:"提示",
	message: "确认要删除？", 
	callback: function(result){
			if(result){
			var params = {
				"knowledgeClass.klcId":id
			};
            var resData = ajaxCRUD("knowledge!deleteknowledgeClass.do",params,true);//url，参数，是否弹出alert
            if(resData.resNum!=0){
            	knowClassTable.fnSettings().ajax.data = knowClassParam;// 定义dataTable初始参数
            	knowClassTable.api().ajax.reload();
        	}
			}
        }
    
});
}
//////////////////////////////////为知识绑定Table开始/////////////////////////////////////////////////
var knowParam;
var knowTable;

	knowTable = $('#knowTable').dataTable({
		"serverSide": true,//服务器模式，分页用
		"ajax":{
	    	"type": "post",
	    	"url": "knowledge!getKnowListByPage.do",
	    	"data":knowParam,
	    	"dataSrc": "tableKnowledge"
	    },
	    "aoColumns": [ 
	    	{"mDataProp":"kl_title"},
			{"mDataProp":"klc_name"},
			//{"mDataProp":"kl_file_url"},
			{"mDataProp":""}
		],
		 columnDefs: [
	        {
	            targets: 2,
	            render: function (a, b, c, d) {
	                var context =
	                {
	                    func: [
	                        {"fn": "kdetailWindow(" + c.kl_id + ","+JSON.stringify(c)+")", "color": "blue","icon": "zoom-in"},
	                        {"fn": "kupdateWindow(" + c.kl_id + ","+JSON.stringify(c)+")", "color": "red","icon": "pencil"},
							{"fn": "kdel(" + c.kl_id + ")", "color": "red","icon": "trash"}
							
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
////////////////////////////////////////////为知识绑定Table结束//////////////////////////////////////////////
//打开更新知识窗口
function kupdateWindow(kid,knowledge){
	$("#knowEdit").trigger("click");
	var params = {"knowledge.klId" : kid};
	var resData = ajaxCRUD("knowledge!selectKnowledgeById.do",params,false);
	$("#knowId").val(kid);
	$("#knowName").val(knowledge.kl_title);
	$("#knowOfClass").val(resData.knowledge.klcId);
	ue.setContent(resData.knowledge.klContent, false);
}
//打开知识详情页面，并向服务器请求，得到知识对象
function kdetailWindow(kid,jsonKnowledge){
	$("#kmodalName").val("");
	$("#kmodalClass").val("");
	$("#klContent").val("");
	var params = {"knowledge.klId" : kid};
	var resData = ajaxCRUD("knowledge!selectKnowledgeById.do",params,false);
	$("#kmodalName").val(jsonKnowledge.kl_title);
	$("#kmodalClass").val(jsonKnowledge.klc_name);
	
	document.getElementById("klContent").innerHTML=resData.knowledge.klContent;
	$("#kTitleModalLabel").text("详情");
	$("#kflag").val("detail");
	$("#knowledgeDetailModel").modal("show");
}
function kdel(id){
		bootbox.confirm({
				locale: "zh_CN",
			size: 'small',
			title:"提示",
			message: "确认要删除？", 
			callback: function(result){
					if(result){
					var params = {
						"knowledge.klId":id
					};
					
	                var resData = ajaxCRUD("knowledge!deleteknowledge.do",params,true);//url，参数，是否弹出alert
	                if(resData.resNum!=0){
	            		knowTable.fnSettings().ajax.data = knowParam;// 定义dataTable初始参数
	            		knowTable.api().ajax.reload();
	            	}
					}
                }
            
        });
}

var ue = UE.getEditor('container');
//点击事件 点击添加知识按钮时触发		
$("#knowEdit").click(function(){
				$("#knowId").val("");
				$("#knowName").val("");
				ue.setContent('', false);
});
//在添加知识页面点击提交按钮后，将数据以json格式提交到服务器
$("#kaddbutton").click(function(){
	var knowId=$("#knowId").val();
	var knowName = $("#knowName").val();
	var knowOfClass = $("#knowOfClass").val();
	var kContent=ue.getContent();
	
	//发送参数
	var params = {
			"knowledge.klId" : knowId,
			"knowledge.klTitle" : knowName,
			"knowledge.klcId" : knowOfClass,
    		"knowledge.klContent" : kContent
				};
	var resData;
	if(knowId==""){
		resData = ajaxCRUD("knowledge!insertKnowledge.do",params,true);//url，参数，是否弹出alert
	}else{
		resData = ajaxCRUD("knowledge!updateKnowledge.do",params,true);//url，参数，是否弹出alert
	}
	
	
	if(resData.resNum!=0){
		buildKnowClass();
		$("#knowName").val("");
		$("#knowOfClass").val("");
		ue.setContent('', false);
		knowTable.fnSettings().ajax.data = knowParam;// 定义dataTable初始参数
		knowTable.api().ajax.reload();
	}
});
//根据条件查询知识
$("#knowSearch").click(function(){
	var quTitle=$("#quTitle").val();
	var quKnowClassByKnow= $("#quKnowClassByKnow").val();
	knowParam={
			"knowledge.klTitle" : quTitle,
			"knowledge.klcId" : quKnowClassByKnow
	};
	knowTable.fnSettings().ajax.data = knowParam;// 定义dataTable初始参数
	knowTable.api().ajax.reload();
});
//点击事件 提交问题 弹出模态框		
$("#submitKnowBtn").click(function(){
				$("#questionModalLabel").text("提交问题");
				$("#questionText").val("");
				$("#questionSave").show();
				$("#questionModel").modal("show");
});

//为查看问题列表绑定table
var queData;
var QuestionTable;
QuestionTable = $('#QuestionTable').dataTable({
		"serverSide": true,//服务器模式，分页用
		"ajax":{
	    	"type": "post",
	    	"url": "knowledge!getQuestionListByPage.do",
	    	"data":queData,
	    	"dataSrc": "tableQuestion"
	    },
	    "aoColumns": [ 
	    	{"mDataProp":"content"},
			{"mDataProp":"sub_user"},
			{"mDataProp":""}
		],
		 columnDefs: [
	        {
	            targets: 2,
	            render: function (a, b, c, d) {
	                var context =
	                {
	                    func: [
	                        {"fn": "deQueWindow("+JSON.stringify(c)+")", "color": "blue","icon": "zoom-in"},
							{"fn": "Quedel(" + c.id + ")", "color": "red","icon": "trash"}
							
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
//提交问题
$("#questionSave").click(function(){
	var question=$("#questionText").val();
	var subUser=$("#subUser").val();
	if(question==""){
		alert("请输入问题内容！");
		return;
	}
	var params={"knowledgeQuestion.content":question,"knowledgeQuestion.subUser":subUser};
	var resData = ajaxCRUD("knowledge!insertQuestionKnowledge.do",params,true);//url，参数，是否弹出alert
	if(resData.resNum!=0){
		
		QuestionTable.api().ajax.reload();
	}
});
//查看问题详情
function deQueWindow(question){
	$("#quDeModalLabel").text("问题详情");
	$("#quDeUser").val(question.sub_user);
	$("#quContent").text(question.content);
	$("#quDeModel").modal("show");
}
//删除提交的问题
function Quedel(id){
	bootbox.confirm({
		locale: "zh_CN",
	size: 'small',
	title:"提示",
	message: "确认要删除？", 
	callback: function(result){
			if(result){
			var params={"knowledgeQuestion.id":id};
			var resData = ajaxCRUD("knowledge!delQuestionKnowledge.do",params,true);//url，参数，是否弹出alert
			if(resData.resNum!=0){
				//QuestionTable.fnSettings().ajax.data = knowQueParam;// 定义dataTable初始参数
				QuestionTable.api().ajax.reload();
			}
			}
			
			
        }
});
}


