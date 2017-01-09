/**
	订购套餐
	用于：
		电话装机页面 - phone_create.jsp
**/

var table_view_plan;
var currPlanTr;
var currPlanRow;

function initPlanList(customerId, businessKey) {
	var parm  = { 
		"obj.customerId": customerId, 
		"obj.businessKey": businessKey 
	};
	if (table_view_plan != undefined) {
			table_view_plan.fnSettings().ajax.data = parm; 
			table_view_plan.api().ajax.reload();
		return;
	}
	table_view_plan = $('#table_view_plan').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "order!selectPlanInOrder.do",
            	"data": parm,
            	"dataSrc": "maps"
            },
        	"columns": [
            	{
            		"data": "planChoosed",
            		"width": "30px",
            		"defaultContent": "1"
            	},
            	{ 
            		"data": "name",
            		"width": "250px",
            	},
            	{ 
            		"data": "termDesc",
            		"width": "40px"
            	},
            	{ 
            		"data": "planFee",
            		"width": "50px"
            	},
            	{ 
            		"data": "planDesc",
            		"width": "300px"
            	},
            	{ 
            		"data": "planChoosedRemark",
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 0,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	html = '<i class="icon-shopping-cart green bigger-110"></i>';
                        return html;
                    }
				}
            ],
            "bAutoWidth": false,
        	"bLengthChange": false,//
			"iDisplayLength" : 8,
			"searching":true,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

function initEditablePlanList(busi) {
	var parm = {
		"obj.bearable": busi.toLowerCase()
	};
	table_view_plan = $('#table_view_plan').DataTable({
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
            		"data": "planChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{
            		"data": "planPayChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "name",
            		"width": "280px",
            	},
            	{ 
            		"data": "termDesc",
            		"width": "40px"
            	},
            	{ 
            		"data": "planFee",
            		"width": "50px"
            	},
            	{ 
            		"data": "planDesc",
            		"width": "300px"
            	},
            	{ 
            		"data": "planOrderCount",
            		"width": "100px",
            		"defaultContent": "<未订购>"
            	},
            	{ 
            		"data": "planChoosedRemark",
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.planChoosed == "1") {
                    		html = '<i class="icon-shopping-cart red bigger-110"></i>';
                    	}
                        return html;
                    }
				},
				{
                    targets: 2,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.planPayChoosed == "1") {
                    		html = '<i class="icon-money orange bigger-110"></i>';
                    	}
                        return html;
                    }
				}
            ],
            "bAutoWidth": false,
        	"bLengthChange": false,//
			"iDisplayLength" : 8,
			"searching":true,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

var openPlanEditor = (function() {
	var tr = $(this).closest('tr');
    var row = table_view_plan.row( tr );
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
});

function getOpenPlanEditor(d) {
	var orderCount = (d.planOrderCount == undefined || d.planOrderCount == "")  ? 0 : d.planOrderCount;
	var planPayChoosed = (d.planPayChoosed == "1") ? "checked" : ""; 
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>数量:</td>' +
            		'<td><input type="text" class="form-control" id="planOrderCount" value="' + orderCount + '" style="width: 150px"/></td>' +
            		'<td>是否收费:</td>' +
            		'<td><label><input id="planPayChoosed" class="ace ace-switch ace-switch-7" type="checkbox" ' + planPayChoosed + ' /><span class="lbl"></span></label></td>' +
            		'<td>备注:</td>' +
            		'<td><input type="text" class="form-control" id="planChoosedRemark" style="width: 150px"/></td>' +
            		'<td><button class="btn btn-sm btn-success" id="btnChoosePlan" onclick="btnChoosePlanClicked()">' +
						'<i class="icon-shopping-cart bigger-110"></i>' +
							'订购' +
						'</button>' +
					'</td>' +
            		'<td><button class="btn btn-sm btn-fail" id="btnCancelPlan" onclick="btnCancelPlanClicked()">' +
						'<i class="icon-trash bigger-110"></i>' +
							'撤销' +
						'</button>' +
					'</td>' +
        		'</tr>' +
    		'</table>';
}

function btnChoosePlanClicked() {
	var remark = $("#planChoosedRemark").val();
	var orderCount = parseInt($("#planOrderCount").val());
	if (isNaN(orderCount) || orderCount < 0) {
		bbAlert("订购数必须是数字且必须大等于零");
		return;
	}
	table_view_plan.cell(currPlanRow.index(), 7).data(orderCount);
	table_view_plan.cell(currPlanRow.index(), 8).data(remark);
	table_view_plan.cell(currPlanRow.index(), 1).data("1");
	if ($("#planPayChoosed").get(0).checked) {
		table_view_plan.cell(currPlanRow.index(), 2).data("1");
	} else {
		table_view_plan.cell(currPlanRow.index(), 2).data("0");
	}
	currPlanRow.child.hide();
	currPlanTr.removeClass('shown');
	calcAmountDue();
}
			    
function btnCancelPlanClicked() {
	table_view_plan.cell(currPlanRow.index(), 7).data("<未订购>");
	table_view_plan.cell(currPlanRow.index(), 8).data("");
	table_view_plan.cell(currPlanRow.index(), 1).data("0");
	table_view_plan.cell(currPlanRow.index(), 2).data("0");
	currPlanRow.child.hide();
	currPlanTr.removeClass('shown');
}
		
