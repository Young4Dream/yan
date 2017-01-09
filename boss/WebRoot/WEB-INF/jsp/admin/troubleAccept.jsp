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
    <style type="">
    select {
	    margin-left: 0px;
	}
	
	.form-group {
        margin-bottom: 5px;
    }
    </style>
</head>

<body>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width:70%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                    
                </h4>
                </div>
                <input type="hidden" id="modleId">
                <input type="hidden" id="flag">
                <div class="modal-body">
                    <div class="table-responsive">
                        <div class="table-search">
                            <div class="col-sm-12" style="padding-bottom: 5px;">
                                <div class="col-sm-6">
                                    <label class="control-label no-padding-left">
                                        查询参数
                                    </label>
                                    <input type="text" class="input-big" name="" id="paramName" onkeypress="getBroadUserInfo2();">
                                </div>
                                <div class="col-sm-6">
                                    <button type="submit" id="search" class="btn btn-sm btn-primary pull-right" onclick="getBroadUserInfo3();">
                                        查询
                                    </button>
                                </div>
                            </div>
                        </div>
                        <br>
                        <table id="kdUserTable" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>
                                        帐号
                                    </th>
                                    <th>
                                        名称
                                    </th>
                                    <th>
                                        用户地址
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-primary" id="save" style="display:none;">
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
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
    
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">业务受理</a>
            </li>
            <li class="active">
                故障受理
            </li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    
    <div class="page-content">
        <div id="user-profile-2" class="user-profile">
            <div class="tabbable">
                <div class="tab-content no-border padding-10">
                    <div id="telephone" class="tab-pane in active">
                        <div class="table-search">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-xs-1 control-label no-padding">故障类型：</label>
<!--                                    <select name="jobtype" calss="" id="jobtype" style="width:270px;margin-left:0px;" onchange="reset();">-->
                                    <div class="col-xs-3">
	                                    <select name="jobtype" calss="" style="width:100%" id="jobtype" onchange="reset();">
	                                        <option role="option" value="-1">&nbsp;&nbsp;&nbsp;&nbsp;</option>
	                                        <option role="option" value="112fault" selected="selected">电话故障</option>
	                                        <option role="option" value="radfault">宽带故障</option>
	                                        <option role="option" value="tvfault">电视故障</option>
	                                    </select>
                                    </div>
                                    <label class="col-xs-1 control-label no-padding">故障号码：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" name="thiskey" id="thiskey" onkeypress="getUserList(event);">
                                    </div>
                                    <input type="button" class="btn btn-sm btn-primary" id="searchPhoneInfo" style="margin-bottom:5px;" value="查询" onclick="selectUserList();" />
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">用户名称：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="username">
                                    </div>
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">用户地址：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="address">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">用户类型：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="usertype">
                                    </div>
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">主叫号码：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="callerid">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-xs-1 control-label no-padding-right">故障现象：</label>
                                    <div class="col-xs-3">
	                                    <select name="ship" calss="" style="width:100%" id="gzxx">
	                                    </select>
                                    </div>
                                    <label class="col-xs-1 control-label no-padding-right">故障备注：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="bz">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">联系人：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" id="linkman">
                                    </div>
                                    <label class="col-xs-1 control-label no-padding-right" for="form-field-1">联系电话：</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="" style="width:100%" name="" id="linkphone">
                                    </div>
                                </div>
                            </form>

                            <!-- 隐藏域 -->
                            <div class="col-sm-12 no-padding-left" style="padding-bottom:5px;">
                                <input type="hidden" id="sslbm">
                                <!-- 受理部门编号 -->
                                <input type="hidden" id="jlry">
                                <!-- 接入人员 -->
                                <input type="hidden" id="ywarea">
                                <!-- 业务区域 -->
                                <input type="hidden" id="usertype">
                                <!-- 用户类型 -->
                                <input type="hidden" id="userid">
                                <!-- 操作员工号 -->
                                <input type="hidden" id="datatype">
                                <!--  资料类型-->
                            </div>
                            
                            <div class="col-sm-12" style="padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-center" style="" id="saveFault" value="保存" onclick="saveFault();" />
                                    <input type="button" class="btn btn-sm btn-primary pull-center" id="reset" value="重置" onclick="reset();" />
                                </div>
                            </div>
                            
                            <div>
                                <table id="troubleTable" class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>工单编号</th>
                                            <th>故障号码</th>
                                            <th>故障内容</th>
                                            <th>联系人</th>
                                            <th>联系电话</th>
                                            <th>用户名称</th>
                                            <th>用户地址</th>
                                            <th>是否完工</th>
                                            <th>受理工号</th>
                                            <th>受理日期</th>
                                            <th>完工工号</th>
                                            <th>完工日期</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- #home -->
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
    var troubleTable;
    var thparam = {};
    var workFlowTable;
    var wfparam = {
        "orderType": "fault",
        "v_jobid": 0
    };
    var userTable;

    var userName = "${sessionScope.userInfo.bossuser}"; //工号
    var bmid = "${sessionScope.userInfo.bmid}"; //工号
    var userarea = "${sessionScope.userInfo.userarea}"; //工号
    var paramCallId = getQueryString("paramCallId");

    function getQueryString(name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }

    $(document).ready(function() {
        var tpl = $("#tpl").html();

        //预编译模板
        var template = Handlebars.compile(tpl);

        $("#sslbm").val(bmid); //受理部门编号
        $("#jlry").val(userName); //接入人员
        $("#ywarea").val(userarea); //业务区域
        $("#userid").val(userName); //操作员工号 与接入人员一样
        $("#callerid").val(paramCallId); //操作员工号 与接入人员一样

        troubleTable = $("#troubleTable").dataTable({
            "serverSide": false, //服务器模式，分页用
            "ajax": {
                "type": "post",
                "url": "trou!trouHistList.do",
                "data": thparam,
                "dataSrc": "trouHist"
            },
            "aoColumns": [{
                "mDataProp": "id",
                "hidden": true
            }, {
                "mDataProp": "account"
            }, {
                "mDataProp": "faultinfo"
            }, {
                "mDataProp": "linkman"
            }, {
                "mDataProp": "linkphone"
            }, {
                "mDataProp": "username"
            }, {
                "mDataProp": "address"
            }, {
                "mDataProp": "iscomplete"
            }, {
                "mDataProp": "userid"
            }, {
                "mDataProp": "operdate"
            }, {
                "mDataProp": "completeuserid"
            }, {
                "mDataProp": "completedate"
            }, {
                "mDataProp": ""
            }],
            columnDefs: [{
                    "targets": [0],
                    "visible": false
                }, {
                    "targets": [3, 5, 7, 8, 10],
                    "width": "70px"
                },

                {
                    targets: 12,
                    render: function(a, b, c, d) {
                        var context = {
                            func: [{
                                "fn": "workFlow('fault', " + c.id + ")",
                                "color": "red",
                                "icon": "list"
                            }/*, {
                                "fn": "window.parent.makecall2('" + c.linkphone + "');",
                                "color": "red",
                                "icon": "phone"
                            }*/]
                        };
                        var html = template(context);
                        return html;
                    }
                }
            ],
            "bLengthChange": false, //
            "iDisplayLength": 10,
            "searching": false, //关闭dataTable自带搜索
            "bPaginate": true, //开启分页功能
            "bSort": false, //关闭排序
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });

        workFlowTable = $("#workFlowTable").dataTable({
            "serverSide": false, //服务器模式，分页用
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
            "scrollCollapse": true,
            "bLengthChange": false, //
            "searching": false, //关闭dataTable自带搜索
            "nPaging": false,
            "bPaginate": false, //开启分页功能
            "bSort": false, //关闭排序
            "bAutoWidth": false,
            "bInfo": false, //页脚条数信息
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });

        userTable = $('#kdUserTable').dataTable({
            "serverSide": true, //服务器模式，分页用
            "bAutoWidth": false,
            "ajax": {
                "type": "post",
                "url": "trou!userInfoList.do",
                "data": {
                    "jobtype": "112fault",
                    "thiskey": "",
                    "queryType": "1",
                    "moreField": "0",
                    "exact": "0"
                },
                "dataSrc": "userInfo"
            },
            "aoColumns": [{
                "mDataProp": "account"
            }, {
                "mDataProp": "username"
            }, {
                "mDataProp": "address"
            }, {
                "mDataProp": ""
            }],
            columnDefs: [{
                targets: 0,
                "width": "6%"
            }, {
                targets: 1,
                "width": "6%"
            }, {
                targets: 3,
                render: function(a, b, c, d) {
                    var context = {
                        func: [{
                            "fn": "select('" + c.account + "')",
                            "color": "red",
                            "icon": "pencil"
                        }]
                    };
                    var html = template(context);
                    return html;
                }
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
        
        //获取用户modal框中的table增加双击事件
        $('#kdUserTable tbody').on( 'dblclick', 'tr', function () {
            //self.Editor.edit( this );
            $(this).addClass('row_selected');
            //alert(this.cells[0].innerHTML);
            var start = this.cells[3].innerHTML.indexOf("javascript:");
            var end = this.cells[3].innerHTML.indexOf(')">');
            //alert(this.cells[0].innerHTML.indexOf("javascript:"));
            //alert(this.cells[0].innerHTML.indexOf(')">'));
            //alert(this.cells[3].innerHTML.substring(start, end + 1));
            var js = this.cells[3].innerHTML.substring(start, end + 1);
            //showWorkFlow("tel", this.cells[1].innerText);
            eval(js);
            $(this).removeClass('row_selected');
        });
    });

    //获取故障类型的下拉列表
    function buildTrouHist(jobtype) {
        var resData = ajaxCRUD("trou!trouTypeList.do", {
            "jobtype": jobtype
        }, false); //url，参数，是否弹出alert
        var typesList = resData.trouType;
        var type_html = "<option role=\"option\" value=\"-1\">&nbsp;&nbsp;&nbsp;</option>";
        $(typesList).each(function(index) {
            var types = typesList[index];
            type_html += "<option  value=\"" + types.faultname + "\">" + types.id + "." + types.faultname + " " + types.faultdesc + "</option>";

        });
        $("#gzxx").html("");
        $("#gzxx").append(type_html);
    }

    //查询故障历史工单
    function queryTrouList(jobtype, thiskey) {
        thparam = {
            "jobtype": jobtype,
            "thiskey": thiskey
        };
        troubleTable.fnSettings().ajax.data = thparam;
        troubleTable.api().ajax.reload();
    }

    //获取障碍用户的用户信息
    function selectUserList() {
        var jobtype = $("#jobtype").val();
        var thiskey = $("#thiskey").val();

        var params;

        if (jobtype == "-1") {
            bootbox.alert({
                locale: "zh_CN",
                size: 'small',
                title: "提示",
                message: "请选择故障类型"
            });
            //$("#emodalEmplNo").focus();
            return false;
        }

        if (thiskey == "") {
            bootbox.alert({
                locale: "zh_CN",
                size: 'small',
                title: "提示",
                message: "请输入故障号码"
            });
            $("#thiskey").focus();
            return false;
        }

        params = {
            "jobtype": jobtype,
            "thiskey": thiskey,
            "queryType": "1",
            "moreField": "0",
            "exact": "0"
        };

        //获取故障类型的下拉列表
        buildTrouHist(jobtype);

        //查询用户信息，模糊查询，弹出选择特定用户的窗口，请用户进一步选择准确的用户信息
        userTable.fnSettings().ajax.data = params;
        userTable.api().ajax.reload();

        $("#myModalLabel").text("查询");
        $("#paramName").val("");
        $("#userModal").modal("show");
    }

    function select(thiskey) {
        var jobtype = $("#jobtype").val();
        var resData;
        var res;
        var html = "";
        var params;

        //alert(jobtype);
        $("#userModal").modal("hide");
        $("#thiskey").val(thiskey);

        //电话故障
        if (jobtype == "112fault") {
            var params = {
                "dh": thiskey
            };

            resData = ajaxCRUD("trou!checkDh.do", params, false); //url，参数，是否弹出alert
            res = resData.resultMap.f;
            html = "";
            //alert(res);

            if (res == 1) //号码不存在
            {
                alert("该号码不存在!");
                reset("phone");
                $("#dh").focus();
                queryTrouList("", "");
                return;
            } else if (res == 2) //有故障还未处理
            {
                alert("该号码故障已受理，请不要重复受理!");
                reset("phone");
                $("#dh").focus();
                queryTrouList("", "");
                return;
            } else if (res == 0) //返回值等于0，表示通过验证
            {
                //通过验证后再获取用户资料
                params = {
                    "jobtype": jobtype,
                    "thiskey": thiskey,
                    "queryType": "1",
                    "moreField": "0",
                    "exact": "1"
                };

                var trouuser = ajaxCRUD("trou!userInfoList.do", params, false); //url，参数，是否弹出alert
                var users = trouuser.userInfo;
                var user = users[0];
                //alert(users);
                $("#username").val(user.username); //用户名称
                $("#address").val(user.address); //用户地址
                //$("#usertype").val(s2);//用户类型
                $("#datatype").val(user.uflag); //资料类型
                queryTrouList(jobtype, thiskey);    
            }
        } else if (jobtype == "radfault") {
            params = {
                "account": thiskey
            };

            //检查该电话号码是否存在档案或者有未完工的障碍
            resData = ajaxCRUD("trou!checkBroad.do", params, false); //url，参数，是否弹出alert
            res = resData.resultMap.f;
            html = "";
            //alert(res);

            if (res == 1) //宽带帐号不存在
            {
                alert("该帐号不存在!");
                reset("rad");
                $("#account").focus();
                queryTrouList("", "");
                return;
            } else if (res == 2) //有故障还未处理
            {
                alert("该帐号故障已受理，请不要重复受理!");
                reset("rad");
                $("#account").focus();
                queryTrouList("", "");
                return;
            } else if (res == 0) //返回值等于0，表示通过验证
            {
                //通过验证后再获取用户资料
                params = {
                    "jobtype": jobtype,
                    "thiskey": thiskey,
                    "queryType": "1",
                    "moreField": "0",
                    "exact": "1"
                };

                var trouuser = ajaxCRUD("trou!userInfoList.do", params, false); //url，参数，是否弹出alert
                var users = trouuser.userInfo;
                var user = users[0];
                //alert(users);
                $("#username").val(user.username); //用户名称
                $("#address").val(user.address); //用户地址
                //$("#usertype").val(s2);//用户类型
                $("#datatype").val(user.uflag); //资料类型    
                queryTrouList(jobtype, thiskey);
            }
        }
    }

    function workFlow(orderType, v_jobid) {
        wfparam = {
            "orderType": orderType,
            "v_jobid": v_jobid
        };
        workFlowTable.fnSettings().ajax.data = wfparam;
        workFlowTable.api().ajax.reload();
        $("#workFlowModal").modal("show");

    }

    function saveFault() {
    
        //检查故障现象是否选择
        if($("#gzxx").val() == "-1"){
            bootbox.alert({
                locale : "zh_CN",
                size : 'small',
                title : "提示",
                message : "请选择故障现象！"
            });
            $("#gzxx").focus();
            return false;
        }
        
        //检查联系电话是否填写
        if($("#linkphone").val() == ""){
            bootbox.alert({
                locale : "zh_CN",
                size : 'small',
                title : "提示",
                message : "请填写联系电话！"
            });
            $("#linkphone").focus();
            return false;
        }
        
        var jobtype = $("#jobtype").val();
        var thiskey = $("#thiskey").val();
        var gzxx = $("#gzxx").val();
        var linkphone = $("#linkphone").val();
        var linkman = $("#linkman").val();
        var sslbm = $("#sslbm").val();
        var jlry = $("#jlry").val();
        var ywarea = $("#ywarea").val();
        var username = $("#username").val();
        var address = $("#address").val();
        var thiskey = $("#thiskey").val();
        var usertype = $("#usertype").val();
        var callerid = $("#callerid").val();
        var userid = $("#userid").val();
        var bz = $("#bz").val();
        var datatype = $("#datatype").val();

        var params = {
            "insertTrouble.jobtype": jobtype,
            "insertTrouble.thiskey": thiskey,
            "insertTrouble.gzxx": gzxx,
            "insertTrouble.linkphone": linkphone,
            "insertTrouble.linkman": linkman,
            "insertTrouble.sslbm": sslbm,
            "insertTrouble.jlry": jlry,
            "insertTrouble.ywarea": ywarea,
            "insertTrouble.username": username,
            "insertTrouble.address": address,
            "insertTrouble.usertype": usertype,
            "insertTrouble.callerid": callerid,
            "insertTrouble.bz": bz,
            "insertTrouble.userid": userid,
            "insertTrouble.datatype": datatype
        };

        ajaxCRUD("trou!insertTrouble.do", params, true); //url，参数，是否弹出alert

        /* jobtype
        thiskey
        gzxx
        linkphone
        linkman
        sSlbm
        jlry
        ywarea
        username
        address
        usertype
        callerid
        bz
        userid
        datatype */
        
        reset();
    }

    function reset() {
        //$("#jobtype").val("");
        $("#thiskey").val("");
        $("#gzxx").val("");
        $("#linkphone").val("");
        $("#linkman").val("");
        $("#username").val("");
        $("#bz").val("");
        $("#address").val("");
        $("#usertype").val("");
        
        queryTrouList("", "");
    }
    
    function getUserList(e){
        var e = e || event;
        currKey=e.keyCode||e.which||e.charCode;     
        var x;
        
        x = e.currentTarget || e.target || e.srcElement;  
        if(currKey == 13) //回车
        {
            selectUserList();
        }
    }
    </script>
</body>

</html>
