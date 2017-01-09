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
    <link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="assets/css/datepicker.css" />
    
    <style>
	.row_selected td {
	    background-color: red !important;
	}
	</style>
</head>
  
<body>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">业务受理</a>
            </li>
            <li class="active">
                工单回访
            </li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="workFlowModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width:70%;">
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                    流程
                </h4>
                </div>
                
                <div class="modal-body">
                    <table id="workFlowTable" class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>发送部门</th>
                                <th>发送人员</th>
                                <th>发送时间</th>
                                <th>接收部门</th>
                                <th>接收人员</th>
                                <th>接收时间</th>
                                <th>备注</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
                        关闭
                    </button>
                </div>
            </div>
        </div>
    </div>
    
    <div class="page-content">
        <div id="user-profile-2" class="user-profile">
            <div class="tabbable">
                <ul class="nav nav-tabs padding-18">
                    <li class="active">
                        <a data-toggle="tab" href="#tel">
                            <i class="green icon-comment bigger-120"></i>电话工单</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#rad"> <i class="green icon-list bigger-120"></i>宽带工单</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#fault"> <i class="green icon-list bigger-120"></i>故障工单</a>
                    </li>
                </ul>
                
                <div class="tab-content no-border padding-10">
                    <div id="tel" class="tab-pane in active">
                        <div class="row col-xs-12">
                            <label style="width: 56px; text-align:right;"> 电话号码 </label>
                            <input type="text" id="telnum" placeholder="" class="">
                            <label style="width: 56px; text-align:right;"> 地址 </label>
                            <input type="text" id="addr" placeholder="" class="">
                        </div>
                        <div class="row col-xs-12">
                            <label style="width: 56px; text-align:right;"> 联系人 </label>
                            <input type="text" id="linkman" placeholder="" class="">
                            <label style="width: 56px; text-align:right;"> 联系电话 </label>
                            <input type="text" id="linktel" placeholder="" class="">
                            <input type="button" class="btn btn-sm btn-primary pull-center" style="" id="saveFault" value="查询" onclick="test();">
                        </div>
                        
						<table id="telTable" class="table table-striped table-bordered table-hover">
						    <thead>
						        <tr>
						            <th>操作</th>
						            <th>流水号</th>
						            <th>电话号码</th>
						            <th>营业点</th>
						            <th>业务所在区域</th>
						            <th>合同号</th>
						            <th>业务类型</th>
						            <th>受理日期</th>
						            <th>受理人员</th>
						            <th>用户名称</th>
						            <th>用户地址</th>
						            <th>联系人</th>
                                    <th>联系电话</th>
						        </tr>
						    </thead>
						    <tbody></tbody>
						</table>
                    </div>
                    
                    <div id="rad" class="tab-pane">
                        <table id="radTable" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>受理类型</th>
                                    <th>描述</th>
                                    <th>状态</th>
                                    <th>联系人</th>
                                    <th>联系电话</th>
                                    <th>受理时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    
                    <div id="fault" class="tab-pane">
                        <table id="faultTable" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>操作</th>
                                    <th>流水号</th>
                                    <th>电话</th>
                                    <th>受理日期</th>
                                    <th>受理人员</th>
                                    <th>故障类型</th>
                                    <th>故障信息</th>
                                    <th>联系人</th>
                                    <th>联系电话</th>
                                    <th>是否完工</th>
                                    <th>完工日期</th>
                                    <th>备注</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
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
    <script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script id="tpl" type="text/x-handlebars-template">
        <div class="action-buttons">
            {{#each func}}
            <a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a> {{/each}}
        </div>
    </script>
    <script type="text/javascript">
    var telTable;
    var faultTable;
    var workFlowTable;
    var wfparam = {
        "orderType": "tel",
        "v_jobid": 0
    };
    
    $(document).ready(function() {
        var tpl = $("#tpl").html();

        //预编译模板
        var template = Handlebars.compile(tpl);
        
        //电话工单表
        telTable = $('#telTable').dataTable({
            "serverSide": true, //服务器模式，分页用
            "bAutoWidth": false,
            "ajax": {
                "type": "post",
                "url": "review!getTelJobList.do",
                "data": {
                    "jobtype": "tel",
                    "thiskey": ""
                },
                "dataSrc": "telJob"
            },
            "aoColumns": [{
                "mDataProp": ""
            }, {
                "mDataProp": "lsh"
            }, {
                "mDataProp": "xdh"
            }, {
                "mDataProp": "area"
            }, {
                "mDataProp": "ywarea"
            }, {
                "mDataProp": "hth"
            }, {
                "mDataProp": "sgnr"
            }, {
                "mDataProp": "sgrq"
            }, {
                "mDataProp": "jlry"
            }, {
                "mDataProp": "xm"
            }, {
                "mDataProp": "xdz"
            }, {
                "mDataProp": "linkman"
            }, {
                "mDataProp": "lxdh"
            }, {
                "mDataProp": "id",
                "hidden": true
            }],
            columnDefs: [{
                targets: 0,
                //"width": "6%",
                render: function (a, b, c, d) {
	                var context =
	                {
	                    func: [
	                        {"fn": "showWorkFlow('tel', " + c.id + ")", "color": "blue","icon": "phone"}
	                        //{"fn": "window.top.broadcast('"+ userName +"','" + c.tel + "');", "color": "blue","icon": "phone"}
	                        //{"fn": "window.parent.broadcast('" + c.lxdh + "');", "color": "blue","icon": "phone"}
	                    ]
	                };
	                var html = template(context);
	                return html;
	            }
            }, {
                    "targets": [13],
                    "visible": false
            }],
            "bLengthChange": false, //
            "iDisplayLength": 10,
            "searching": false, //关闭dataTable自带搜索
            "bPaginate": true, //开启分页功能
            "bSort": false, //关闭排序
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });
        
        //宽带工单表
        
        //故障工单表
        faultTable = $('#faultTable').dataTable({
            "serverSide": true, //服务器模式，分页用
            "bAutoWidth": false,
            "ajax": {
                "type": "post",
                "url": "review!getFaultJobList.do",
                "data": {
                    "jobtype": "fault",
                    "thiskey": ""
                },
                "dataSrc": "faultJob"
            },
            "aoColumns": [{
                "mDataProp": ""
            }, {
                "mDataProp": "lsh"
            }, {
                "mDataProp": "dh"
            }, {
                "mDataProp": "sgrq"
            }, {
                "mDataProp": "jlry"
            }, {
                "mDataProp": "sgnr"
            }, {
                "mDataProp": "gzxx"
            }, {
                "mDataProp": "linkman"
            }, {
                "mDataProp": "lxdh"
            }, {
                "mDataProp": "iscomplete"
            }, {
                "mDataProp": "wgrq"
            }, {
                "mDataProp": "bz"
            }, {
                "mDataProp": "id",
                "hidden": true
            }],
            columnDefs: [{
                targets: 0,
                //"width": "6%",
                render: function (a, b, c, d) {
                    var context =
                    {
                        func: [
                            {"fn": "showWorkFlow('fault', " + c.id + ")", "color": "blue","icon": "phone"}
                            //{"fn": "window.top.broadcast('"+ userName +"','" + c.tel + "');", "color": "blue","icon": "phone"}
                            //{"fn": "window.parent.broadcast('" + c.lxdh + "');", "color": "blue","icon": "phone"}
                        ]
                    };
                    var html = template(context);
                    return html;
                }
            }, {
                    "targets": [12],
                    "visible": false
            }],
            "bLengthChange": false, //
            "iDisplayLength": 10,
            "searching": false, //关闭dataTable自带搜索
            "bPaginate": true, //开启分页功能
            "bSort": false, //关闭排序
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });
        
        //工单流程表
        workFlowTable = $("#workFlowTable").dataTable({
            //"serverSide": false, //服务器模式，分页用
            "serverSide": true, //服务器分页
            "ajax": {
                "type": "post",
                "url": "trou!workFlowList.do",
                "data": wfparam,
                "dataSrc": "workFlow"
            },
            "aoColumns": [{
                "mDataProp": "fsbm"
            }, {
                "mDataProp": "fsry"
            }, {
                "mDataProp": "fsrq"
            }, {
                "mDataProp": "bm"
            }, {
                "mDataProp": "ry"
            }, {
                "mDataProp": "opertime"
            }, {
                "mDataProp": "bz"
            }],
            //"scrollCollapse": true,
            "bLengthChange": false, //
            "iDisplayLength": 10,
            "searching": false, //关闭dataTable自带搜索
            //"nPaging": false,
            //"bPaginate": false, //关闭分页功能
            "bPaginate": true, //开启分页功能
            "bSort": false, //关闭排序
            //"bAutoWidth": false,
            //"bInfo": false, //页脚条数信息
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });
        
        //telTable.api().ajax.reload();
        $('#telTable tbody').on( 'dblclick', 'tr', function () {
			//self.Editor.edit( this );
			$(this).addClass('row_selected');
			//alert(this.cells[0].innerHTML);
			var start = this.cells[0].innerHTML.indexOf("javascript:");
			var end = this.cells[0].innerHTML.indexOf(')">');
			//alert(this.cells[0].innerHTML.indexOf("javascript:"));
			//alert(this.cells[0].innerHTML.indexOf(')">'));
			//alert(this.cells[0].innerHTML.substring(start, end + 1));
			var js = this.cells[0].innerHTML.substring(start, end + 1);
			//showWorkFlow("tel", this.cells[1].innerText);
			eval(js);
			$(this).removeClass('row_selected');
	    });
    });
    
    function test() {
        var s = $("#lbl1")[0].getBoundingClientRect().width;
        //var s = document.getElementById("lbl1").getBoundingClientRect().width;
        //var s = getWidthOfText("电话电话", "Microsoft YaHei", 14);
        alert(s);
        $("#makeCallRecord").modal("show");
    }
    
    function getWidthOfText(txt, fontname, fontsize){
		// Create a dummy canvas (render invisible with css)
		var c=document.createElement('canvas');
		// Get the context of the dummy canvas
		var ctx=c.getContext('2d');
		// Set the context.font to the font that you are using
		ctx.font = fontsize + 'px' + fontname;
		// Measure the string 
		// !!! <CRUCIAL>  !!!
		var length = ctx.measureText(txt).width;
		// !!! </CRUCIAL> !!!
		// Return width
		return length;
    }
    
    function showWorkFlow(orderType, v_jobid) {
        wfparam = {
            "orderType": orderType,
            "v_jobid": v_jobid
        };
        workFlowTable.fnSettings().ajax.data = wfparam;
        workFlowTable.api().ajax.reload();
        $("#workFlowModal").modal("show");

    }
    
    </script>
</body>
</html>
