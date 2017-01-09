/**
 * 套餐订购
*/
var table_view_plan_list;
var table_view_plan_cart;
var currPlanTr;
var currPlanRow;
var currPlanCartTr;
var currPlanCartRow;

// 初始化产品列表
function initPlanList(busi) {
	var parm = {
		"obj.bearable": busi.toLowerCase()
	};
	table_view_plan_list = $('#table_view_plan_list').DataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidPricePlan!findOrderableByBusiness.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
        	"columns": [
            	{
                	"className":      'details-control',
                	"orderable":      false,
                	"data":           null,
                	"width": "30px",
                	"defaultContent": ''
            	},
            	{ 
            		"data": "name",
            		"width": "200px",
            	},
            	{ 
            		"data": "planFee",
            		"width": "*"
            	}
        	],
            "bAutoWidth": false,
			"bLengthChange": false,//
			"iDisplayLength" : 8,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

// 初始化购物车
function initPlanCart(userId) {
	var parm  = { "obj.id": userId };
	if (table_view_plan_cart != undefined) {
			table_view_plan_cart.ajax.reload();
		return;
	}
	table_view_plan_cart = $('#table_view_plan_cart').DataTable({
			"ajax": {
            	"type": "post",
            	"url": "order!findPlanInOrder.do",
            	"data": parm,
            	"dataSrc": "maps"
            },
        	"columns": [
            	{
                	"className":      'details-control',
                	"orderable":      false,
                	"data":           null,
                	"width": "30px",
                	"defaultContent": ''
            	},
            	{
            		"data": "planPayChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "name",
            		"width": "200px",
            	},
            	{ 
            		"data": "effectiveTime",
            		"width": "150",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "dueTime",
            		"width": "150",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "planOrderCount",
            		"width": "80px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "",
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.planPayChoosed == "1") {
                    		html = '<i class="icon-money orange bigger-110"></i>';
                    	}
                        return html;
                    }
				},
				{
                    targets: 6,
                    render: function (a, b, c, d) {
                    	var funcs = [];
                    	if (c.status == "0") {
                    		funcs.push({"fn": "btnCancelPlanClicked(4)", "color": "red", "icon": "warning-sign", "tooltip": "立即拆除"});
                    	} else if (c.status == "2") {
                    		funcs.push({"fn": "btnCancelPlanClicked(5)", "color": "purple", "icon": "minus-sign", "tooltip": "到期拆除"});
                    	}
                        return template({func: funcs});
                    }
				}
            ],
            "bAutoWidth": false,
			"bLengthChange": false,//
			"iDisplayLength" : 8,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

function openPlanEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_plan_list.row( tr );
    currPlanTr = tr;
    currPlanRow = row;
 
    if ( row.child.isShown() ) {
    	// This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
    	// Open this row
        row.child(getOpenPlanEditor(row.data())).show();
        tr.addClass('shown');
	}
}

function getOpenPlanEditor(d) {
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>套餐描述:</td>' +
            		'<td>' + d.planDesc + '</td>' +
            	'</tr><tr>'+
            		'<td>订购数量:</td>' +
            		'<td><input type="text" class="form-control" id="planOrderCount" style="width: 150px" value="0"></td>' +
            	'</tr><tr>'+
            		'<td>生效日期:</td>' +
            		'<td><input type="text" class="form-control" id="effectiveDate" style="width: 150px" placeholder="如2016-09-01"></td>' +
            	'</tr><tr>'+
            		'<td>是否收费:</td>' +
            		'<td><label><input id="planPayChoosed" class="ace ace-switch ace-switch-7" type="checkbox" /><span class="lbl"></span></label></td>' +
            	'</tr><tr>'+
            		'<td>备注:</td>' +
            		'<td><input type="text" class="form-control" id="planChoosedRemark" style="width: 150px"></td>' +
            	'</tr><tr>'+
            		'<td><button class="btn btn-sm btn-success" id="btnPurchasePlan" onclick="btnPurchasePlanClicked()">' +
						'<i class="icon-shopping-cart bigger-110"></i>' +
							'订购' +
						'</button> &nbsp;' +
					'</td>' +
        		'</tr>' +
    		'</table>';
}

function openPlanCartEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_plan_cart.row( tr );
    currPlanCartTr = tr;
    currPlanCartRow = row;
 
    if ( row.child.isShown() ) {
    	// This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
    	// Open this row
        row.child(getOpenPlanCartEditor(row.data())).show();
        tr.addClass('shown');
	}
}

function getOpenPlanCartEditor(d) {
	var status = "";
	if (d.status == "0") {
		if (d.tempStatus == undefined || d.tempStatus == 1) {
			status = "未执行，可直接撤销订购";
		} else {
			status = "已选择了撤销";
		}
	} else if (d.status == "2") {
		if (d.tempStatus == undefined) {
			status = "正在执行，可选择到期撤销";
		} else {
			status = "已选择了撤销";
		}
	} else if (d.status == "4" || d.status == "5" || d.status == "9") {
		status = "已执行或撤销，无法撤销";
	}
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>状态:</td>' +
            		'<td>' + status + '</td>' +
            	'</tr><tr>'+
            		'<td>套餐描述:</td>' +
            		'<td>' + d.planDesc + '</td>' +
            	'</tr><tr>'+
            		'<td>备注:</td>' +
            		'<td>' + (d.planOrderRemark == null || d.planOrderRemark == undefined ? "" : d.planOrderRemark) + '</td>' +
        		'</tr>' +
    		'</table>';
}

function btnPurchasePlanClicked() {
	var remark = $("#planChoosedRemark").val();
	var orderCount = parseInt($("#planOrderCount").val());
	if (isNaN(orderCount) || orderCount < 0) {
		bbAlert("订购数必须是数字且必须大等于零");
		return;
	}
	if (table_view_plan_cart.rows().data().length >= 2) {
		bbAlert("无法再订购新套餐");
		return;
	}
	if (!checkDate($("#effectiveDate").val())) {
		bbAlert("请输入有效的生效日期");
		return;
	}
	
	var planPayChoosed = $("#planPayChoosed").get(0).checked ? "1" : "0";
	
	var data = currPlanRow.data();
	var parm = {
		"orderId": $("#userId").val(),
		"id": data.id,
		"name": data.name,
		"price": data.planFee,
		"itemType": 1,
		"saleType": 2,
		"term": data.term,
		"planOrderCount": orderCount,
		"planFee": data.planFee,
		"planOrderRemark": remark,
		"status": 0,
		"orderItemId": "",
		"planDesc": data.planDesc,
		"tempStatus": 1,
		"planPayChoosed": planPayChoosed,
		"effectiveTime": $("#effectiveDate").val(),
	};
	table_view_plan_cart.row.add(parm).draw();
	currPlanRow.child.hide();
	currPlanTr.removeClass('shown');
	calcCartAmountDue();
}
			    
function btnCancelPlanClicked(nextStatus) {
	var row = table_view_plan_cart.row('.selected');
	var data = row.data();
	if (data.tempStatus == 1) {
		table_view_plan_cart.row('.selected').remove().draw( false );
	} else {
		if (data.status == "4" || data.status == "5" || data.status == "9") {
			bbAlert("正在拆除或已经执行完的服务无法再次拆除");
		} else if (data.status == "0") {
			data["tempStatus"] = 4;
		} else {
			data["tempStatus"] = nextStatus;
		}
	}
	calcCartAmountDue();
}
		
function onPlanRowSelected() {
	//if ( $(this).hasClass('selected') ) {
    //	$(this).removeClass('selected');
    //}
    //else {
    	table_view_plan_cart.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    //}
}
