/**
	选择业务受理费
	用于：
		电话装机页面 - phone_create.jsp
**/

var table_view_fee;
var currFeeTr;
var currFeeRow;

function initFeeList(customerId, businessKey) {
	var parm  = { "obj.customerId": customerId, "obj.businessKey": businessKey };
	if (table_view_fee != undefined) {
			table_view_fee.fnSettings().ajax.data = parm; 
			table_view_fee.api().ajax.reload();
		return;
	}
	table_view_fee = $('#table_view_fee').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "order!selectFeeInOrder.do",
            	"data": parm,
            	"dataSrc": "maps"
            },
        	"columns": [
            	{
            		"data": "feeChoosed",
            		"width": "30px",
            		"defaultContent": "1"
            	},
            	{ 
            		"data": "name",
            		"width": "280px",
            	},
            	{ 
            		"data": "price",
            		"width": "80px"
            	},
            	{ 
            		"data": "feeOrderPrice",
            		"width": "120",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "feeOrderRemark",
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
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

function initEditableFeeList() {
	table_view_fee = $('#table_view_fee').DataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidFee!selectOpFeeByName.do",
            	"data": { "obj.name": busiType },
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
            		"data": "feeChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{
            		"data": "feePayChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "name",
            		"width": "140px",
            	},
            	{ 
            		"data": "price",
            		"width": "110px"
            	},
            	{ 
            		"data": "feeOrderPrice",
            		"width": "110px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "feeOrderRemark",
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.feeChoosed == "1") {
                    		html = '<i class="icon-shopping-cart red bigger-110"></i>';
                    	}
                        return html;
                    }
				},
				{
                    targets: 2,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.feePayChoosed == "1") {
                    		html = '<i class="icon-ok-sign orange bigger-110"></i>';
                    	}
                        return html;
                    }
				}
            ],
            "bAutoWidth": false,
			"bLengthChange": false,//
			"iDisplayLength" :10,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": false,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

function openFeeEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_fee.row( tr );
    currFeeTr = tr;
    currFeeRow = row;
 
    if ( row.child.isShown() ) {
    	// This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
    	// Open this row
        row.child(getOpenFeeEditor(row.data())).show();
        tr.addClass('shown');
	}
}

function getOpenFeeEditor(d) {
	var price = (d.feeOrderPrice == undefined || d.feeOrderPrice == "")  ? d.price : d.feeOrderPrice;
	var feePayChoosed = (d.feePayChoosed == "1") ? "checked" : ""; 
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>' +
            		'<td>实收费用:</td>' +
            		'<td><input type="text" class="form-control" id="feeOrderPrice" value="' + price + '" style="width: 200px"/></td>' +
        		'<tr>' +
            		'<td>是否收费:</td>' +
            		'<td><label><input id="feePayChoosed" class="ace ace-switch ace-switch-7" type="checkbox" ' + feePayChoosed + ' /><span class="lbl"></span></label></td>' +
            	'</tr><tr>' +
            		'<td>备注:</td>' +
            		'<td><input type="text" class="form-control" id="feeChoosedRemark" style="width: 200px"/></td>' +
            	'</tr><tr>' +
            		'<td colspan="2"><button class="btn btn-sm btn-success" id="btnChooseFee" onclick="btnChooseFeeClicked()">' +
						'<i class="icon-shopping-cart bigger-110"></i>' +
							'订购' +
						'</button> &nbsp;' +
            			'<button class="btn btn-sm btn-fail" id="btnCancelFee" onclick="btnCancelFeeClicked()">' +
						'<i class="icon-trash bigger-110"></i>' +
							'撤销' +
						'</button>' +
					'</td>' +
        		'</tr>' +
    		'</table>';
}

function btnChooseFeeClicked() {
	var remark = $("#feeChoosedRemark").val();
	var orderPrice = parseFloat($("#feeOrderPrice").val());
	if (isNaN(orderPrice) || orderPrice < 0) {
		bbAlert("请输入数字且必须大等于零");
		return;
	}
	table_view_fee.cell(currFeeRow.index(), 5).data(orderPrice);
	table_view_fee.cell(currFeeRow.index(), 6).data(remark);
	table_view_fee.cell(currFeeRow.index(), 1).data("1");
	if ($("#feePayChoosed").get(0).checked) {
		table_view_fee.cell(currFeeRow.index(), 2).data("1");
	} else {
		table_view_fee.cell(currFeeRow.index(), 2).data("0");
	}
	currFeeRow.child.hide();
	currFeeTr.removeClass('shown');
	calcAmountDue();
}
			    
function btnCancelFeeClicked() {
	table_view_fee.cell(currFeeRow.index(), 5).data("<未订购>");
	table_view_fee.cell(currFeeRow.index(), 6).data("");
	table_view_fee.cell(currFeeRow.index(), 1).data("0");
	table_view_fee.cell(currFeeRow.index(), 2).data("0");
	currFeeRow.child.hide();
	currFeeTr.removeClass('shown');
	calcAmountDue();
}

function calcAmountDue() {
	var amountDue = 0;
	amountDue += calcFeeAmountDue() + calcProductAmountDue() + calcPlanAmountDue();
    $("#amountDue").val(amountDue); 	
}

function calcCartAmountDue() {
	var amountDue = 0;
	amountDue += calcFeeAmountDue() + calcProductCartAmountDue() + calcPlanCartAmountDue();
    $("#amountDue").val(amountDue); 	
}

// 计算业务受理费
function calcFeeAmountDue() {
	var amountDue = 0;
	if (table_view_fee == undefined || table_view_fee.rows() == undefined) {
		return 0;
	}
	var tableData = table_view_fee.rows().data();
	var feeCount = tableData.length;
    for (var i = 0; i < feeCount; i++) {
        var data = tableData[i];
        if (data.feeChoosed == "1" && data.feePayChoosed == "1") {
    	    amountDue += parseFloat(data.feeOrderPrice);
    	}
    }
	return amountDue;    
}

// 计算产品费用
function calcProductAmountDue() {
	var amountDue = 0;
	if (table_view_product == undefined || table_view_product.rows() == undefined) {
		return 0;
	}
	// 计算业务受理费
	var tableData = table_view_product.rows().data();
	var feeCount = tableData.length;
    for (var i = 0; i < feeCount; i++) {
        var data = tableData[i];
        if (data.productChoosed == "1" && data.productPayChoosed == "1") {
    	    amountDue += parseFloat(data.productOrderPrice) * parseInt(data.productOrderCount);
    	}
    }
    return amountDue;
}

// 计算产品费用
function calcProductCartAmountDue() {
	var amountDue = 0;
	if (table_view_product_cart == undefined || table_view_product_cart.rows() == undefined) {
		return 0;
	}
	// 计算业务受理费
	var tableData = table_view_product_cart.rows().data();
	var feeCount = tableData.length;
    for (var i = 0; i < feeCount; i++) {
        var data = tableData[i];
        if (data.productPayChoosed == "1") {
    	    amountDue += parseFloat(data.productOrderPrice) * parseInt(data.productOrderCount);
    	}
    }
    return amountDue;
}

function calcPlanAmountDue() {
	var amountDue = 0;
	if (table_view_plan == undefined || table_view_plan.rows() == undefined) {
		return 0;
	}
	var tableData = table_view_plan.rows().data();
	var feeCount = tableData.length;
    for (var i = 0; i < feeCount; i++) {
        var data = tableData[i];
        if (data.planChoosed == "1" && data.planPayChoosed == "1") {
    	    amountDue += parseFloat(data.planFee) * parseInt(data.planOrderCount);
    	}
    }
    return amountDue;
}

function calcPlanCartAmountDue() {
	var amountDue = 0;
	if (table_view_plan_cart == undefined || table_view_plan_cart.rows() == undefined) {
		return 0;
	}
	var tableData = table_view_plan_cart.rows().data();
	var feeCount = tableData.length;
    for (var i = 0; i < feeCount; i++) {
        var data = tableData[i];
        if (data.planPayChoosed == "1") {
    	    amountDue += parseFloat(data.planFee) * parseInt(data.planOrderCount);
    	}
    }
    return amountDue;
}

function validateAmount() {
	var amountProceed = parseFloat($("#amountProceed").val());
    var amountDue = parseFloat($("#amountDue").val());
    if (isNaN(amountProceed) || amountProceed < amountDue) {
        bbAlert("实收费必须是数字且大等于应收费");
    	return false;
    }
    return true;
}

function resetAmountDue() {
	$("#amountDue").val("0");
	$("#amountProceed").val("0");
	$("#printFlag").get(0).checked = false;
}
		
