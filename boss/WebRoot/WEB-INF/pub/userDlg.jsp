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
	<div class="modal fade" id="dlgUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						选择用户
					</h4>
				</div>
				<div class="modal-body">
                    <div class="widget-box widget-color-blue2">
                    	<div class="widget-header">
                           	<h4 class="widget-title lighter smaller">用户列表</h4>
                           	<div class="widget-toolbar">
                           		<span id="selectedBusinessKey" class="badge badge-danger">请选择用户</span>
                           	</div>
                        </div>
                        <div class="widget-body">
                           	<div class="widget-main padding-8">
                           		<form class="form-search">
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-12">
                           					<div class="input-group">
                           						<span class="input-group-addon">
                           							<i class="icon-ok"></i>
                           						</span>
                           						<input type="text" id="crUser" class="form-control search-query" placeholder="号码、账号、用户名、地址、联系电话" />
                           						<input type="hidden" id="selectedUserId" />
                           						<input type="hidden" id="userBusinessType" />
                           						<input type="hidden" id="userStatus" value=""/>
                           						<input type="hidden" id="beginStatus" value=""/>
                           						<input type="hidden" id="endStatus" value="89"/>
                           						<span class="input-group-btn">
                           							<button type="button" class="btn btn-purple btn-sm" id="btnSearchUser">
                           								<span class="icon-search icon-on-right bigger-110"></span>
                           								查找
                           							</button>
                           						</span>
                           					</div>
                           				</div>
                           			</div>
                           			<div class="row">
                           				<div class="col-xs-12 col-sm-12">
                           				<table id="table_view_user" class="table table-striped table-bordered table-hover">
                           					<thead>
                           						<tr>
                           							<th>号码（账号）</th>
                           							<th>名称</th>
                           							<th>安装地址</th>
                           							<th>联系电话</th>
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
					<button type="button" class="btn btn-sm btn-primary" id="btnUserChoosed">
						确认
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
	<script type="text/javascript">
        var table_view_user;
        //var businessType = $("#userBusinessType").val();
        var criteria = {
        	"obj.beginStatus": $("#beginStatus").val(),
			"obj.endStatus": $("#endStatus").val(),	
        	"obj.businessType": businessType,
        };
        if ($("#userStatus").val() != "") {
        	criteria["obj.status"] = $("#userStatus").val();
        }
		table_view_user = $('#table_view_user').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "crmUser!findByPage.do",
            	"data": criteria,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "businessKey"},
    			{"mDataProp": "name"},
            	{"mDataProp": "address"},
    			{"mDataProp": "linkPhone"}
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
		
		$("#btnSearchUser").click(doSearch);
		
		function doSearch() {
			criteria = {
        		"obj.beginStatus": $("#beginStatus").val(),
				"obj.endStatus": $("#endStatus").val(),	
				"obj.fullText": $("#crUser").val()
	        };
       	 	if ($("#userStatus").val() != "") {
        		criteria["obj.status"] = $("#userStatus").val();
        	}
	        if (businessType != undefined && businessType != "") {
	        	criteria["obj.businessType"] = businessType;
	        }
			table_view_user.fnSettings().ajax.data = criteria; 
			table_view_user.api().ajax.reload();
		}
		
		$("#table_view_user tbody").on("click", "tr", function(event) {
			var aData = table_view_user.fnGetData(event.target.parentNode);
			$("#selectedUserId").val(aData.id);
			$("#selectedBusinessKey").text(aData.businessKey);
		});
		
		$("#btnUserChoosed").click(function() {
			var userId = $("#selectedUserId").val();
			var businessKey = $("#selectedBusinessKey").text();
			if ("请选择用户" == businessKey) {
				alert("请查询并选择用户");
				return;
			}
			fnUserChoosed(userId, businessKey);
			$("#dlgUser").modal("hide");
		});
		
	</script>
	</body>
</html>
