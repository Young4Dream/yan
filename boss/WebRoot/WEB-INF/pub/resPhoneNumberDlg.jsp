<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>

	<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="dlgPhoneNumber" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						选择号码
					</h4>
				</div>
				<div class="modal-body">
                    <div class="widget-box widget-color-blue2">
                    	<div class="widget-header">
                           	<h4 class="widget-title lighter smaller">号码列表</h4>
                           	<div class="widget-toolbar">
                           		<span id="selectedPhoneNumber" class="badge badge-danger">请选择号码</span>
                           	</div>
                        </div>
                        <div class="widget-body">
                           	<div class="widget-main padding-8">
                           		<form class="form-search">
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-8">
                           					<div class="input-group">
                           						<span class="input-group-addon">
                           							<i class="icon-ok"></i>
                           						</span>
                           						<input type="text" id="crPN" class="form-control search-query" placeholder="输入要查找的号码" />
                           						<span class="input-group-btn">
                           							<button type="button" class="btn btn-purple btn-sm" id="btnSearchPN">
                           								<span class="icon-search icon-on-right bigger-110"></span>
                           								查找
                           							</button>
                           						</span>
                           					</div>
                           				</div>
                           			</div>
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-12">
                           				<table id="table_view_pn" class="table table-striped table-bordered table-hover">
                           					<thead>
                           						<tr>
                           							<th>号码</th>
                           							<th>所属设备</th>
                           						</tr>
                           					</thead>
                           					<tbody></tbody>
                           				</table>
                           				</div>
                           			</div>
                           		</form>
                           	</div>
                        </div>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnChoosePhoneNumber">
						确认
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
	<script type="text/javascript">
        var table_view_pn;
        var criteria = {
        	"obj.status": 0,
        	"obj.reserved": 0
        };
		table_view_pn = $('#table_view_pn').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "resPhoneNumber!findByPage.do",
            	"data": criteria,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "phoneNumber"},
    			{"mDataProp": "rootDeviceCode"},
    		],
			 columnDefs: [
            ],
			"bLengthChange": false,//
			"iDisplayLength" :5,
			"searching":false,//关闭dataTable自带搜索
			"bPaginate": true,//开启分页功能
			"bSort" : false,//关闭排序
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		$("#btnSearchPN").click(function() {
			criteria = {
				"obj.phoneNumber": $("#crPN").val(),
    	    	"obj.status": 0,
        		"obj.reserved": 0
	        };
			table_view_pn.fnSettings().ajax.data = criteria; 
			table_view_pn.api().ajax.reload();
		});
		
		$("#table_view_pn tbody").on("click", "tr", function(event) {
			var aData = table_view_pn.fnGetData(event.target.parentNode);
			$("#selectedPhoneNumber").text(aData.phoneNumber);
		});
		
		$("#btnChoosePhoneNumber").click(function() {
			var phoneNumber = $("#selectedPhoneNumber").text();
			if ("请选择号码" == phoneNumber) {
				alert("请选择号码");
				return;
			}
			fnPhoneNumberChoosed(phoneNumber);
			$("#dlgPhoneNumber").modal("hide");
		});
	</script>
	</body>
</html>
