/**
 * 产品订购
*/
var table_view_product_list;
var table_view_product_cart;
var currProductTr;
var currProductRow;
var currProductCartTr;
var currProductCartRow;
var cart;

// 初始化产品列表
function initProductList() {
	table_view_product_list = $('#table_view_product_list').DataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "sidProduct!selectChildrenByPage.do",
            	"data": { "obj.parentId": parentProductId },
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
            		"data": "price",
            		"width": "*"
            	}
        	],
            "bAutoWidth": false,
			"bLengthChange": false,//
			"iDisplayLength" : 8,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

// 初始化购物车
function initProductCart(userId) {
	var parm  = { "obj.id": userId };
	if (table_view_product_cart != undefined) {
		table_view_product_cart.ajax.reload();
		return;
	}
	//alert("初始化购物车");
	table_view_product_cart = $('#table_view_product_cart').DataTable({
			"ajax": {
            	"type": "post",
            	"url": "order!findProductInOrder.do",
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
            		"data": "productPayChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "name",
            		"width": "150px",
            	},
            	{ 
            		"data": "productOrderCount",
            		"width": "80px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "productOrderPrice",
            		"width": "120px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": null,
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.productPayChoosed == "1") {
                    		html = '<i class="icon-money orange bigger-110"></i>';
                    	}
                        return html;
                    }
				},
				{
                    targets: 5,
                    render: function (a, b, c, d) {
                    	var funcs = [];
                    	if (c.status == "0") {
                    		funcs.push({"fn": "btnCancelProductClicked(4)", "color": "red", "icon": "warning-sign", "tooltip": "立即拆除"});
                    	} else if (c.status == "2") {
                    		funcs.push({"fn": "btnCancelProductClicked(5)", "color": "purple", "icon": "minus-sign", "tooltip": "到期拆除"});
                    		funcs.push({"fn": "btnCancelProductClicked(4)", "color": "red", "icon": "warning-sign", "tooltip": "立即拆除"});
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

function openProductEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_product_list.row( tr );
    currProductTr = tr;
    currProductRow = row;
 
    if ( row.child.isShown() ) {
    	// This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
    	// Open this row
        row.child(getOpenProductEditor(row.data())).show();
        tr.addClass('shown');
	}
}

function getOpenProductEditor(d) {
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>订购数量:</td>' +
            		'<td><input type="text" class="form-control" id="productOrderCount" value="0" style="width: 150px"></td>' +
            	'</tr><tr>'+
            		'<td>订购单价:</td>' +
            		'<td><input type="text" class="form-control" id="productOrderPrice" value="' + d.price + '" style="width: 150px"></td>' +
            	'</tr><tr>'+
            		'<td>是否收费:</td>' +
            		'<td><label><input id="productPayChoosed" class="ace ace-switch ace-switch-7" type="checkbox" /><span class="lbl"></span></label></td>' +
            	'</tr><tr>'+
            		'<td>备注:</td>' +
            		'<td><input type="text" class="form-control" id="productChoosedRemark" style="width: 300px"></td>' +
            	'</tr><tr>'+
            		'<td><button class="btn btn-sm btn-success" id="btnPurchaseProduct" onclick="btnPurchaseProductClicked()">' +
						'<i class="icon-shopping-cart bigger-110"></i>' +
							'订购' +
						'</button> &nbsp;' +
					'</td>' +
        		'</tr>' +
    		'</table>';
}

function openProductCartEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_product_cart.row( tr );
    currProductCartTr = tr;
    currProductCartRow = row;
 
    if ( row.child.isShown() ) {
    	// This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
    	// Open this row
        row.child(getOpenProductCartEditor(row.data())).show();
        tr.addClass('shown');
	}
}

function getOpenProductCartEditor(d) {
	var status = "";
	if (d.status == "0") {
		if (d.tempStatus == undefined || d.tempStatus == 1) {
			status = "未执行，可直接拆除";
		} else {
			status = "已选择了拆除";
		}
	} else if (d.status == "2") {
		if (d.tempStatus == undefined) {
			status = "正在执行，可选择到期拆除或立即拆除";
		} else {
			status = "已选择了拆除";
		}
	} else if (d.status == "4" || d.status == "5" || d.status == "9") {
		status = "已执行或撤销，无法撤销";
	}
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>状态:</td>' +
            		'<td>' + status + '</td>' +
            	'</tr><tr>'+
            		'<td>生效时间:</td>' +
            		'<td>' + (d.effectiveTime == undefined || d.effectiveTime == null ? "" : d.effectiveTime) + '</td>' +
            	'</tr><tr>'+
            		'<td>备注:</td>' +
            		'<td>' + (d.productOrderRemark == null || d.productOrderRemark == undefined ? "" : d.productOrderRemark) + '</td>' +
        		'</tr>' +
    		'</table>';
}

function btnPurchaseProductClicked() {
	var remark = $("#productChoosedRemark").val();
	var orderCount = $("#productOrderCount").val();
	var orderPrice = $("#productOrderPrice").val();
	var productPayChoosed = $("#productPayChoosed").get(0).checked ? "1" : "0";
	var data = currProductRow.data();
	var parm = {
		"orderId": $("#userId").val(),
		"id": data.id,
		"name": data.name,
		"price": data.price,
		"unit": data.term,
		"productOrderCount": orderCount,
		"productOrderPrice": orderPrice,
		"productOrderRemark": remark,
		"status": 0,
		"orderItemId": "",
		"itemType": 2,
		"saleType": data.saleType,
		"ossKey": data.ossOpenKey,
		"tempStatus": 1,
		"productPayChoosed": productPayChoosed,
	};
	table_view_product_cart.row.add(parm).draw();
	currProductRow.child.hide();
	currProductTr.removeClass('shown');
	calcCartAmountDue();
}
			    
function btnCancelProductClicked(nextStatus) {
	var row = table_view_product_cart.row('.selected');
	var data = row.data();
	if (data.tempStatus == 1) {
		table_view_product_cart.row('.selected').remove().draw( false );
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
		
function onProductRowSelected() {
	//if ( $(this).hasClass('selected') ) {
    //	$(this).removeClass('selected');
    //}
    //else {
    	table_view_product_cart.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    //}
}
