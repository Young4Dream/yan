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
		<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css"
			type="text/css">
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/datepicker/bootstrap-datetimepicker.min.css" />
		
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
		<script src="assets/js/datepicker/bootstrap-datetimepicker.min.js"></script>
		 
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">话单分拣</a>
				</li>
				<li class="active">
					话单监控
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
                            			<i class="icon-warning-sign green bigger-110"></i>
                            			话单查询
                            		</h4>
                            		<div class="widget-toolbar">
                            			<span class="badge badge-danger"></span>
                            		</div>
                            	</div>
                            	<div class="widget-body">
                            		<div class="widget-toolbox" id="widget-toolbox-1">
                            			<div class="btn-toolbar">
                            				<div class="col-md-12 column"><div class="row clearfix">
                            					<div class="col-md-2 column">
                            						<input class="form-control" id="crCaller" type="text" placeholder="主叫号码"/>
                            					</div>
                            					<div class="col-md-3 column">
                            						<div class="input-group">
                            							<input id="crStartTime" type="text" class="form-control date-timepicker" placeholder="话始开始时间"/>
                            							<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                            						</div>
                            					</div>
                            					<div class="col-md-3 column">
                            						<div class="input-group">
                            							<input id="crEndTime" type="text" class="form-control date-timepicker" placeholder="话始截止时间"/>
                            							<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                            						</div>
                            					</div>
                            					<div class="col-md-4 column">
                            						<button class="btn btn-success btn-white btn-round" id="btnInquiry">
                            							<i class="icon-search green"></i>
                            							查询
                            						</button>
                            					</div>
                            				</div></div>
                            			</div>
                            		</div>
                            		<div class="widget-main padding-8">
							<table id="table_view" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>主叫号码</th>
										<th>被叫号码</th>
										<th>呼叫类型</th>
										<th>呼始时间</th>
										<th>呼止时间</th>
										<th>通话时长(S)</th>
										<th>基本费(￥)</th>
										<th>附加费(￥)</th>
										<th>折扣(￥)</th>
										<th>总费用(￥)</th>
										<th>异常描述</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
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
					<input type="hidden" id="id" name="cdrSource.id" value="">
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									主叫号码：
								</label>
								<div class="col-xs-4">
									<input type="text" id="caller" name="obj.caller" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">被叫号码：</label>
								<div class="col-xs-4">
									<input type="text" id="callee" name="obj.callee" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									入中继：
								</label>
								<div class="col-xs-4">
									<input type="text" id="trunkGroupIn" name="obj.trunkGroupIn" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">出中继：</label>
								<div class="col-xs-4">
									<input type="text" id="trunkGroupOut" name="obj.trunkGroupOut" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">话始时间：</label>
								<div class="col-xs-4">
									<input type="text" id="startTime" name="obj.startTime" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">话至时间：</label>
								<div class="col-xs-4">
									<input type="text" id="endTime" name="obj.endTime" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">通话时长：</label>
								<div class="col-xs-4">
									<input type="text" id="duration" name="obj.duration" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">计费量：</label>
								<div class="col-xs-4">
									<input type="text" id="usageCount" name="obj.usageCount" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									免费量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="freeUsage" name="obj.freeUsage" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">
									实际计费量：
								</label>
								<div class="col-xs-4">
									<input type="text" id="chargingUsage" name="obj.chargingUsage" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									单价：
								</label>
								<div class="col-xs-4">
									<input type="text" id="price" name="obj.price" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">费用：</label>
								<div class="col-xs-4">
									<input type="text" id="fee" name="obj.fee" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									折扣：
								</label>
								<div class="col-xs-4">
									<input type="text" id="discount" name="obj.discount" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">账单号：</label>
								<div class="col-xs-4">
									<input type="text" id="billId" name="obj.billId" class="" style="width:93%;"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label no-padding">
									异常标识：
								</label>
								<div class="col-xs-4">
									<input type="text" id="abnormalCode" name="obj.abnormalCode" class="" style="width:93%;"/>
								</div>
								<label class="col-xs-2 control-label no-padding">异常描述：</label>
								<div class="col-xs-4">
									<input type="text" id="abnormalDesc" name="objabnormalDesc" class="" style="width:93%;"/>
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
		$(document).ready(function(){
			$(".date-timepicker").datetimepicker();
		});
		
        var table_view;
        var parm = {};
		table_view = $('#table_view').dataTable({
			"serverSide": true, //服务器模式，分页用
			"ajax": {
            	"type": "post",
            	"url": "cdr!selectByPage.do",
            	"data": parm,
            	"dataSrc": "lst"
            },
            "aoColumns": [ 
            	{"mDataProp": "caller"},
    			{"mDataProp": "callee"},
    			{"mDataProp": "callType"},
    			{"mDataProp": "startTime"},
    			{"mDataProp": "endTime"},
    			{"mDataProp": "duration"},
    			{"mDataProp": "fee"},
    			{"mDataProp": "attachFee"},
    			{"mDataProp": "discount"},
    			{"mDataProp": "totalFee"},
    			{"mDataProp": "abnormalDesc"},
				{"mDataProp": ""}
    		],
			 columnDefs: [
                {
                    targets: 10,
                    render: function (a, b, c, d) {
                    	if (c.abnormalCode == 0) {
                    		return "";
                    	} else {
                    		return '<span class="label label-warning arrowed-in">' + c.abnormalDesc + '</span>';
                    	}
                        var html = template(context);
                        return html;
                    }
                },
                {
                    targets: 11,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"fn": "showDetailDlg(" + JSON.stringify(c) + ")", "color": "blue", "icon": "zoom-in"}
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
			"language": { //国际化
				"url": "assets/js/Chinese.json"
			}
		});
		
		$("#btnInquiry").click(function() {
			parm["obj.caller"] = $("#crCaller").val() == "" ? "" : $("#crCaller").val();
			parm["crStartTime"] = $("#crStartTime").val() == "" ? "" : $("#crStartTime").val();
			parm["crEndTime"] = $("#crEndTime").val() == "" ? "" : $("#crEndTime").val();
			table_view.fnSettings().ajax.data = parm; 
			table_view.api().ajax.reload();
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////
		// 辅助函数
		/////////////////////////////////////////////////////////////////////////////////
        function showDetailDlg(obj) {
            $("#dlg_title").text("详情");
        	detail(obj);
            $("#flag").val("");
            $("#save").hide();
            $("#dlg").modal("show");
        }
        
        function detail(obj) {
    		$("#id").val(obj.id);
        	$("#caller").val(obj.caller);
        	$("#callee").val(obj.callee);
        	$("#trunkGroupIn").val(obj.trunkGroupIn);
        	$("#trunkGroupOut").val(obj.trunkGroupOut);
        	$("#startTime").val(obj.startTime);
        	$("#endTime").val(obj.endTime);
        	$("#duration").val(obj.duration);
        	$("#usageCount").val(obj.usageCount);
        	$("#freeUsage").val(obj.freeUsage);
        	$("#chargingUsage").val(obj.chargingUsage);
        	$("#price").val(obj.price);
        	$("#fee").val(obj.fee);
        	$("#discount").val(obj.discount);
        	$("#billId").val(obj.billId);
        	$("#abnormalCode").val(obj.abnormalCode);
        	$("#abnormalDesc").val(obj.abnormalDesc);
        }

    	function clear() {
    		$("#id").val("");
        	$("#caller").val("");
        	$("#callee").val("");
        	$("#trunkGroupIn").val("");
        	$("#trunkGroupOut").val("");
        	$("#startTime").val("");
        	$("#endTime").val("");
        	$("#duration").val("");
        	$("#usageCount").val("");
        	$("#freeUsage").val("");
        	$("#chargingUsage").val("");
        	$("#price").val("");
        	$("#fee").val("");
        	$("#discount").val("");
        	$("#billId").val("");
        	$("#abnormalCode").val("");
        	$("#abnormalDesc").val("");
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
