/**
	订购产品和增值服务
	用于：
		电话装机页面 - phone_create.jsp
**/

var table_view_product;
var currProductTr;
var currProductRow;

function initProductList(customerId, businessKey) {
	var parm  = { "obj.customerId": customerId, "obj.businessKey": businessKey };
	if (table_view_product != undefined) {
			table_view_product.fnSettings().ajax.data = parm; 
			table_view_product.api().ajax.reload();
		return;
	}
	table_view_product = $('#table_view_product').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "order!selectProductInOrder.do",
            	"data": parm,
            	"dataSrc": "maps"
            },
        	"columns": [
            	{
            		"data": "productChoosed",
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
            		"data": "unit",
            		"width": "60px"
            	},
            	{ 
            		"data": "productOrderCount",
            		"width": "80px",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "productOrderPrice",
            		"width": "120",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "productOrderRemark",
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
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
	});
}

function initEditableProductList() {
	table_view_product = $('#table_view_product').DataTable({
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
            		"data": "productChoosed",
            		"width": "30px",
            		"defaultContent": ""
            	},
            	{
            		"data": "productPayChoosed",
            		"width": "30px",
            		"defaultContent": ""
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
            		"data": "unit",
            		"width": "60px"
            	},
            	{ 
            		"data": "productOrderCount",
            		"width": "80px",
            		"defaultContent": "<未订购>"
            	},
            	{ 
            		"data": "productOrderPrice",
            		"width": "120",
            		"defaultContent": ""
            	},
            	{ 
            		"data": "productOrderRemark",
            		"width": "*",
            		"defaultContent": ""
            	}
        	],
			columnDefs: [
				{
                    targets: 1,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.productChoosed == "1") {
                    		html = '<i class="icon-shopping-cart red bigger-110"></i>';
                    	}
                        return html;
                    }
				},
				{
                    targets: 2,
                    render: function (a, b, c, d) {
                    	var html = "";
                    	if (c.productPayChoosed == "1") {
                    		html = '<i class="icon-money orange bigger-110"></i>';
                    	}
                        return html;
                    }
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


function openProductEditor() {
	var tr = $(this).closest('tr');
    var row = table_view_product.row( tr );
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
	var orderCount = (d.productOrderCount == undefined || d.productOrderCount == "")  ? 1 : d.productOrderCount;
	var price = (d.productOrderPrice == undefined || d.productOrderPrice == "") ? d.price : d.productOrderPrice;
	var productPayChoosed = (d.productPayChoosed == "1") ? "checked" : ""; 
	return '<table cellpadding="0" cellspacing="0" border="0" >' +
        		'<tr>'+
            		'<td>订购数量:</td>' +
            		'<td><input type="text" class="form-control" id="productOrderCount" value="' + orderCount + '" style="width: 100px"/></td>' +
            		'<td>订购单价:</td>' +
            		'<td><input type="text" class="form-control" id="productOrderPrice" value="' + price + '" style="width: 100px"/></td>' +
            		'<td>是否收费:</td>' +
            		'<td><label><input id="productPayChoosed" class="ace ace-switch ace-switch-7" type="checkbox" ' + productPayChoosed + ' /><span class="lbl"></span></label></td>' +
            		'<td>备注:</td>' +
            		'<td><input type="text" class="form-control" id="productChoosedRemark" style="width: 100px"></td>' +
            		'<td><button class="btn btn-sm btn-success" id="btnChooseProduct" onclick="btnChooseProductClicked()">' +
						'<i class="icon-shopping-cart bigger-110"></i>' +
							'订购' +
						'</button> &nbsp;' +
            			'<button class="btn btn-sm btn-fail" id="btnCancelProduct" onclick="btnCancelProductClicked()">' +
						'<i class="icon-trash bigger-110"></i>' +
							'撤销' +
						'</button>' +
					'</td>' +
        		'</tr>' +
    		'</table>';
}

function btnChooseProductClicked() {
	var remark = $("#productChoosedRemark").val();
	var orderCount = parseInt($("#productOrderCount").val());
	var orderPrice = parseFloat($("#productOrderPrice").val());
	if (isNaN(orderCount) || isNaN(orderPrice) || orderCount < 0 || orderPrice < 0) {
		bbAlert("订购数和订购价格必须是数字且必须大等于零");
		return;
	}
	table_view_product.cell(currProductRow.index(), 6).data(orderCount);
	table_view_product.cell(currProductRow.index(), 7).data(orderPrice);
	table_view_product.cell(currProductRow.index(), 8).data(remark);
	table_view_product.cell(currProductRow.index(), 1).data("1");
	if ($("#productPayChoosed").get(0).checked) {
		table_view_product.cell(currProductRow.index(), 2).data("1");
	} else {
		table_view_product.cell(currProductRow.index(), 2).data("0");
	}
	currProductRow.child.hide();
	currProductTr.removeClass('shown');
	calcAmountDue();
}
			    
function btnCancelProductClicked() {
	table_view_product.cell(currProductRow.index(), 6).data("<未订购>");
	table_view_product.cell(currProductRow.index(), 7).data("");
	table_view_product.cell(currProductRow.index(), 8).data("");
	table_view_product.cell(currProductRow.index(), 1).data("0");
	table_view_product.cell(currProductRow.index(), 2).data("0");
	currProductRow.child.hide();
	currProductTr.removeClass('shown');
	calcAmountDue();
}
		
