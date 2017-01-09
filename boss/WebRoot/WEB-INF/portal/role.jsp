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
    <!-- page specific plugin styles -->
    <!-- fonts -->
    <link rel="stylesheet" href="assets/font/fonts.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="assets/css/main.css" />
    <!-- inline styles related to this page -->
</head>

<body>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">系统管理</a>
            </li>
            <li class="active">
                角色管理
            </li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    
    <div class="page-content">
        <div class="col-sm-10" style="border-right: 1px solid #e5e5e5;">
            <div class="table-responsive">
                <div class="table-search">
                    <div class="col-sm-12 no-padding-left tablesearch">
                        <div class="col-sm-12" style="padding-bottom: 5px;">
                            <div class='col-sm-6'>
                                <label class="control-label no-padding-right">
                                    角色名:
                                </label>
                                <input type="text" class="input-small" name="roleInfo.roleName" id="seName">
                                <button type="submit" id="search" class="btn btn-sm btn-primary">
                                    查询
                                </button>
                            </div>
                            <div class='col-sm-6'>
                                <button type="submit" id="addbutton" class="btn btn-sm btn-primary pull-right">
                                    添加
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>
                                角色名称
                            </th>
                            <th>
                           	角色说明
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <!-- /.table-responsive -->
        </div>
        
        <div class="col-sm-2">
            <div class="">
                <h4>
                <i class="icon-cog">菜单配置</i>
            </h4>
            </div>
            <input type="hidden" id="roleId">
            
            <div class="zTreeDemoBackground ">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
            
            <div class="col-sm-12">
                <button type="button" class="btn btn-sm btn-primary  pull-left" id="saveMenu">
                    保存
                </button>
                <button type="button" class="btn btn-sm btn-primary  pull-right" id="reset">
                    重置
                </button>
            </div>
        </div>
    </div>
    
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 350px;">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">

                </h4>
                </div>
                <input type="hidden" id="flag" value="">
                <input type="hidden" id="modalId" name="roleInfo.roleId" value="">
                <input type="hidden" id="modalCreateTime" name="roleInfo.createTime" value="">
                
                <div class="modal-body">
                    <table class="modal-table" cellspacing="0" cellpadding="0" border="0">
                        <tbody>
                            <tr rowpos="1" class="FormData" id="">
                                <td class="CaptionTD">
                                    角色名
                                </td>
                                <td class="DataTD">
                                    <input type="text" id="modalName" name="roleInfo.roleName" class="">
                                </td>
                            </tr>
                            <tr rowpos="2" class="FormData" id="">
                                <td class="CaptionTD">
                                  	角色描述
                                </td>
                                <td class="DataTD">
                                	<input type="text" id="modalDesc" name="roleInfo.roleName" class="">
                                </td>
                            </tr>
                            <tr rowpos="3" class="FormData" id="tr_note">
                                <td class="CaptionTD">
                                    备注
                                </td>
                                <td class="DataTD">
                                    <textarea rows="4" cols="20" id="modalRemark" name="roleInfo.remark" multiline="true" class="" style="position:relative;left:-3px;"></textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>
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
    
    <!-- basic scripts -->
    <script src='assets/js/jquery-2.0.3.min.js'>
    </script>
    <script src="assets/js/bootstrap.min.js">
    </script>
    <script src="assets/js/bootbox.js">
    </script>
    <!-- page specific plugin scripts -->
    <script src="assets/js/jquery.dataTables.js">
    </script>
    <!-- 

<script src="assets/js/jquery.dataTables.min.js"></script>
 -->
    <script src="assets/js/jquery.dataTables.bootstrap.js">
    </script>
    <script src="assets/js/handlebars-v3.0.1.js">
    </script>
    <!-- ace scripts -->
    <!-- inline scripts related to this page -->
    <script type="text/javascript" src="assets/js/jquery.ztree.core-3.5.js">
    </script>
    <script type="text/javascript" src="assets/js/jquery.ztree.excheck-3.5.js">
    </script>
    <script type="text/javascript" src="assets/js/crud/crud.js">
    </script>
    <script type="text/javascript">
    //var userName = "${userName}";//session
    var userName = "${sessionScope.userInfo.userName}";

    //树的配置
    var setting = {
        view: {
            showIcon: false,
            showLine: false
            //是否显示节点间的连线
        },
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    //页面初始状态加载树
    var zTree;
    var treeNodes;
    $(document).ready(function() {

        //增加第二个参数，用于判断是否是在onReady方法时调用的，1是，其它不是
        conf(0, 1);

        //界面ready时，要把保存按钮初始化为禁止状态，防止误操作
        $("#saveMenu").attr("disabled", "disabled");
    });

    var oTable1;
    var param;
    
    jQuery(function($) {

        var tpl = $("#tpl").html();
        //预编译模板
        var template = Handlebars.compile(tpl);

        oTable1 = $('#sample-table-2').dataTable({
            "serverSide": true, //服务器模式，分页用
            "ajax": {
                "type": "post",
                "url": "role!allRole.do",
                "data": param
            },
            "aoColumns": [{
                "mDataProp": "rolename"
            }, {
                "mDataProp": "roledesc"
            }, {
                "mDataProp": "createtime"
            }, {
                "mDataProp": ""
            }],
            columnDefs: [{
                    targets: 3,
                    render: function(a, b, c, d) {
                        var context = {
                            func: [{
                                "fn": "detailWindow('" + c.roleid + "',\'" + c.rolename + "\','" + c.roledesc + "',\'" + c.remark + "\',\'" + c.createtime + "\')",
                                "color": "blue",
                                "icon": "zoom-in",
                                "tooltip": "查看"
                            }, {
                                "fn": "updateWindow('" + c.roleid + "',\'" + c.rolename + "\','" + c.roledesc + "',\'" + c.remark + "\',\'" + c.createtime + "\')",
                                "color": "green",
                                "icon": "pencil",
                                "tooltip": "编辑"
                            }, {
                                "fn": "del('" + c.roleid + "')",
                                "color": "red",
                                "icon": "trash",
                                "tooltip": "删除"
                            }, {
                                "fn": "conf('" + c.roleid + "', 0)",
                                "color": "green",
                                "icon": "cog",
                                "tooltip": "配置权限"
                            }]
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

        $("#save").click(function() { //模态框 save
            var flag = $("#flag").val();
            if (flag == "add") {
                fromSubmin("role!insert.do");
            } else if (flag == "update") {
                fromSubmin("role!update.do");
            }
            $("#modal").modal("hide");
        });

        $("#addbutton").click(function() { //添加 弹出模态框
            $("#myModalLabel").text("添加");
            clearWindow();
            $("#flag").val("add");
            $("#save").show();
            $("#modal").modal("show");
        });

        $("#search").click(function() { //查询
            var name = $("#seName").val();
            param = {
                "role.roleName": name
            };
            oTable1.fnSettings().ajax.data = param;
            oTable1.api().ajax.reload();
        });

        //保存菜单配置
        $("#saveMenu").click(function() {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getChangeCheckedNodes();
            var menuChange = "";
            for (var i = 0, l = nodes.length; i < l; i++) {
                if (i == l - 1) {
                    menuChange += nodes[i].id + "-" + nodes[i].checked;
                } else {
                    menuChange += nodes[i].id + "-" + nodes[i].checked + ","
                }
            }
            var roleId = $("#roleId").val();
            var params = {
                "menuChange": menuChange,
                "roleId": roleId
            };
            var resData = ajaxCRUD("role!menuChange.do", params, true);
            if (resData.resNum != 0) {
                treeNodes = resData.jsArray;
                //重新构造树
                $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
                $.fn.zTree.getZTreeObj("treeDemo").expandAll(false);
            }

            //一次保存操作完成后，还要把保存按钮设置为禁止状态，防止误操作
            $("#saveMenu").attr("disabled", "disabled");

            //$("#reset").click();
        });

        //取消所有选中
        $("#reset").click(function() {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");

            var nodes = treeObj.getNodes();
            treeObj.checkAllNodes(false);
        });

    })

    function updateWindow(id, name, roleDesc, remark, createTime) { //弹出修改模态框
        //管理员角色禁止修改
        if (id == 1) {
            bootbox.alert({
                message: "此数据禁止修改！",
                title: "提示",
                locale: "zh_CN",
                size: 'small'
            });
            return false;
        }

        $("#myModalLabel").text("修改");
        clearWindow();
        $("#flag").val("update");
        $("#modalId").val(id);
        $("#modalCreateTime").val(createTime);
        $("#modalName").val(name);
        $("#modalDesc").val(roleDesc);
        $("#modalRemark").val(remark);
        $("#save").show();
        $("#modal").modal("show");
    }

    function detailWindow(id, name, roleDesc, remark, createTime) { //弹出查看详细信息模态框
        $("#myModalLabel").text("详细信息");
        clearWindow();
        $("#modalId").val(id);
        $("#modalCreateTime").val(createTime);
        $("#modalName").val(name);
        $("#modalDesc").val(roleDesc);
        $("#modalRemark").val(remark);
        $("#save").hide()
        $("#modal").modal("show");
    }

    function clearWindow() {
        $("#modalCreateTime").val("");
        $("#modalId").val("");
        $("#modalName").val("");
        $("#modalDesc").val("");
        $("#modalRemark").val("");
    }

    //角色配置菜单权限
    //增加第二个参数，用于判断是否是在onReady方法时调用的，1是，其它不是
    function conf(id, onReady) {
        $("#roleId").val(id);
        var params = {
            "id": id
        };
        var resData = ajaxCRUD("role!check.do", params, false); 

        if (resData.resNum != 0) {
            treeNodes = resData.jsArray;
            //重新构造树
            $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
            $.fn.zTree.getZTreeObj("treeDemo").expandAll(false);
        }

        //新增用户角色禁止修改
        if (id == 0 && onReady == 0) {
            bootbox.alert({
                message: "此数据禁止修改！",
                title: "提示",
                locale: "zh_CN",
                size: 'small'
            });

            //禁止修改数据后，要把保存按钮禁止，防止误操作
            $("#saveMenu").attr("disabled", "disabled");
            return false;
        }

        var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); //获取zTree对象

        //返回某一个node对象，三个参数（node的属性名称， 属性值， 父节点对象）
        var sysMgrRootNode = treeObj.getNodeByParam("id", 1, null);

        //如果是管理员角色，禁止去掉系统管理下的勾选
        /*
        if (id == 1) {
            for (var i = 0, l = sysMgrRootNode.children.length; i < l; i++) {

                //sysMgrRootNode和它下面的所有子Node禁止check操作
                //children是子node的array
                //三个参数：
                //1、children node array
                //2、是否禁止check操作（true禁止、false允许）
                //3、是否该父节点也和所有子节点一样（true一样））
                treeObj.setChkDisabled(sysMgrRootNode.children[i], true, true);
            }
        } else {
            for (var i = 0, l = sysMgrRootNode.children.length; i < l; i++) {
                treeObj.setChkDisabled(sysMgrRootNode.children[i], false, true);
            }
        } 
        */

        $("#saveMenu").removeAttr("disabled");
    }

    //添加or修改
    function fromSubmin(url) {
        var rct = $("#modalCreateTime").val();
        var rid = $("#modalId").val();
        var rname = $("#modalName").val();
        var radmin = $("#modalisAdmin").val();
        var rremark = $("#modalRemark").val();
        var params = {
            "role.id": rid,
            "role.roleName": rname,
            "role.roleDesc": $("#modalDesc").val(),
            "role.remark": rremark,
        };
        var resData = ajaxCRUD(url, params, true); //url，参数，是否弹出alert
        if (resData.resNum != 0) {
            //window.parent.updateRole();
            //oTable1.fnSettings().ajax.data = {}; 
            oTable1.api().ajax.reload();
        }
    }

    //删除
    function del(id) {
        if (id == 0 || id == 1) {
            bootbox.alert({
                message: "此数据不能删除！",
                title: "提示",
                locale: "zh_CN",
                size: 'small'
            });
            //return false;
        } else {
            bootbox.confirm({
                locale: "zh_CN",
                size: 'small',
                title: "提示",
                message: "确认要删除？",
                callback: function(result) {
                    if (result) {
                        var params = {
                            "id": id
                        };
                        var resData = ajaxCRUD("role!delete.do", params, true); 
                        if (resData.resNum != 0) {
                            //window.parent.updateRole();
                            //oTable1.fnSettings().ajax.data = {}; 
                            oTable1.api().ajax.reload();
                        }
                    }
                }
            });
        }
    }
    </script>
    
	<!-- 按钮组的Handlebars模板 -->
	<jsp:include page="../pub/tpl.jsp" flush="true"/>
	
</body>

</html>
