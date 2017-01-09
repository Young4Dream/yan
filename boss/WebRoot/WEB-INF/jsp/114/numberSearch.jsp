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
    <style>
    .num-search {
        font-size: 40px !important;
    }
    </style>
</head>

<body>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <!-- 
            <a href="#">业务受理</a>
             -->
                业务受理
            </li>
            <li class="active">114查号</li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    <div class="page-content">
        <div class="col-sm-12">
            <div class="table-responsive">
                <div class="table-search">
                    <!--                        <div class="col-sm-12 no-padding-left tablesearch">-->
                    <div class="col-sm-12" style="padding-bottom:5px;">
                        <div style="">
                            <label class="control-label no-padding-right num-search" style="margin-top: -30px">用户名称:</label>
                            <input type="text" class="input-medium num-search" name="" id="index1" onkeypress="next(event)" onkeyup="arrow()" style="width: 200px;">
                            <input type="text" class="input-medium num-search" name="" id="index2" onkeypress="next(event)" onkeyup="arrow()" style="width: 200px;">
                            <input type="text" class="input-medium num-search" name="" id="index3" onkeypress="next(event)" onkeyup="arrow()" style="width: 200px;">
                        </div>
                        <div class='col-sm-3'>
                            <label class="control-label no-padding-right" for="form-field-1" style="display:none;">用户地址(简拼):</label>
                        </div>
                        <div class='col-sm-3'>
                            <label class="control-label no-padding-right" style="display:none;">一级部门(简拼):</label>
                        </div>
                        <div class='col-sm-3' style="padding-left:48px;">
                            <label class="control-label no-padding-right" style="display:none;">查询简码:</label>
                            <input type="text" class="input-small" name="" id="code" onkeypress="next(event)" onkeyup="arrow()" style="display:none;">
                        </div>
                        <div class='col-sm-3' style="padding-left:40px;">
                            <label class="control-label no-padding-right" for="form-field-1" style="display:none;">号码:</label>
                            <input type="text" class="input-small" name="" id="phone" onkeypress="next(event)" onkeyup="arrow()" style="display:none;">
                        </div>
                    </div>
                    <div class="col-sm-12" style="padding-bottom:5px;">
                        <div class='col-sm-3'>
                            <label class="control-label no-padding-right" style="display:none;">二级部门(简拼):</label>
                            <input type="text" class="input-small" name="" id="index4" onkeypress="next(event)" onkeyup="arrow()" style="display:none;">
                        </div>
                        <div class='col-sm-3'>
                            <label class="control-label no-padding-right" for="form-field-1" style="display:none;">三级部门(简拼):</label>
                            <input type="text" class="input-small" name="" id="index5" onkeypress="next(event)" onkeyup="arrow()" style="display:none;">
                        </div>
                        <div class='col-sm-3'>
                            <label class="control-label no-padding-right" for="form-field-1" style="display:none;">四级部门:</label>
                            <input type="text" class="input-small" name="" id="index6" onkeypress="next(event)" onkeyup="arrow()" style="display:none;">
                        </div>
                    </div>
                    <!--                        </div>-->
                </div>
                
                <table id="sample-table-2" class="table table-striped table-bordered table-hover num-search" style="white-space: nowrap;">
                    <thead>
                        <tr>
                            <!-- 
                        <th>查询简码</th>
                        <th>电话号码</th>
                        <th>用户名称</th>
                        <th>用户地址</th>
                        <th>一级部门</th>
                        <th>二级部门</th>
                        <th>三级部门</th>
                        <th>四级部门</th>
                        <th>操作</th>
                        -->
                            <th>操作</th>
                            <th>电话号码</th>
                            <th>用户名称</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <!-- /.table-responsive -->
        </div>
    </div>
    
    <!-- basic scripts -->
    <script src='assets/js/jquery-2.0.3.min.js'></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootbox.js"></script>
    <!-- page specific plugin scripts -->
    <script src="assets/js/jquery.dataTables.js"></script>
    <!-- 

<script src="assets/js/jquery.dataTables.min.js"></script>
 -->
    <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/js/handlebars-v3.0.1.js"></script>
    <!-- ace scripts -->
    <!-- inline scripts related to this page -->
    <script type="text/javascript" src="assets/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="assets/js/jquery.ztree.excheck-3.5.js"></script>
    <script type="text/javascript" src="assets/js/crud/crud.js"></script>
    <script id="tpl" type="text/x-handlebars-template">
        <div class="action-buttons">
            {{#each func}}
            <a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a> {{/each}}
        </div>
    </script>
    <script type="text/javascript">
    $(document).ready(function() {

    });

    //firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
    if (/msie/i.test(navigator.userAgent)) { //ie浏览器 
        document.getElementById('code').onpropertychange = search
        document.getElementById('phone').onpropertychange = search
        document.getElementById('index1').onpropertychange = search
        document.getElementById('index2').onpropertychange = search
        document.getElementById('index3').onpropertychange = search
        document.getElementById('index4').onpropertychange = search
        document.getElementById('index5').onpropertychange = search
        document.getElementById('index6').onpropertychange = search
    } else { //非ie浏览器，比如Firefox 
        document.getElementById('code').addEventListener("input", search, false);
        document.getElementById('phone').addEventListener("input", search, false);
        document.getElementById('index1').addEventListener("input", search, false);
        document.getElementById('index2').addEventListener("input", search, false);
        document.getElementById('index3').addEventListener("input", search, false);
        document.getElementById('index4').addEventListener("input", search, false);
        document.getElementById('index5').addEventListener("input", search, false);
        document.getElementById('index6').addEventListener("input", search, false);
    }

    var userName = "${sessionScope.userInfo.userName}"; //session
    $(document).ready(function() {
        $("#index1").focus();
    })

    var oTable1;
    var param;
    jQuery(function($) {
        var tpl = $("#tpl").html();
        //预编译模板
        var template = Handlebars.compile(tpl);

        oTable1 = $('#sample-table-2').dataTable({
            "scrollX": true,
            "scrollY": '50vh',
            "serverSide": true, //服务器模式，分页用
            "ajax": {
                "type": "post",
                "url": "querynum!query114List.do",
                "data": param,
                "dataSrc": "list114"
            },
            "aoColumns": [{
                    "mDataProp": ""
                },
                //{"mDataProp":"code"},
                {
                    "mDataProp": "phone"
                }, {
                    "mDataProp": "username"
                }
                //{"mDataProp":"address"},
                //{"mDataProp":"bm1"},
                //{"mDataProp":"bm2"},
                //{"mDataProp":"bm3"},
                //{"mDataProp":"bm4"},
            ],
            columnDefs: [{
                    //targets: 8,
                    targets: 0,
                    render: function(a, b, c, d) {
                        var context = {
                            func: [
                                //{"fn": "broadcast(" + c.tel + "\)", "color": "blue","icon": "phone"}
                                //{"fn": "window.top.broadcast('"+ userName +"','" + c.tel + "');", "color": "blue","icon": "phone"}
                                {
                                    "fn": "broadcast('" + c.phone + "');",
                                    "color": "blue",
                                    "icon": "phone"
                                }
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
            "bLengthChange": false, //
            "iDisplayLength": 100,
            "searching": false, //关闭dataTable自带搜索
            "bPaginate": true, //开启分页功能
            "bSort": false, //关闭排序
            "language": { //国际化
                "url": "assets/js/Chinese.json"
            }
        });
        
        //双击报号
        $('#sample-table-2 tbody').on( 'dblclick', 'tr', function () {
            //self.Editor.edit( this );
            $(this).addClass('row_selected');
            //alert(this.cells[0].innerHTML);
            var start = this.cells[0].innerHTML.indexOf("javascript:");
            var end = this.cells[0].innerHTML.indexOf(');">');
            //alert(this.cells[0].innerHTML.indexOf("javascript:"));
            //alert(this.cells[0].innerHTML.indexOf(')">'));
            //alert(this.cells[3].innerHTML.substring(start, end + 1));
            var js = this.cells[0].innerHTML.substring(start, end + 1);
            //showWorkFlow("tel", this.cells[1].innerText);
            eval(js);
            $(this).removeClass('row_selected');
        });
    })

    function search() { //phone code index
        var phone = $("#phone").val().toLowerCase();
        var code = $("#code").val().toLowerCase();
        var index1 = $("#index1").val().toLowerCase();
        var index2 = $("#index2").val().toLowerCase();
        var index3 = $("#index3").val().toLowerCase();
        var index4 = $("#index4").val().toLowerCase();
        var index5 = $("#index5").val().toLowerCase();
        var index6 = $("#index6").val().toLowerCase();
        param = {
            "query114User.phone": phone,
            "query114User.code": code,
            "query114User.index1": index1,
            "query114User.index2": index2,
            "query114User.index3": index3,
            "query114User.index4": index4,
            "query114User.index5": index5,
            "query114User.index6": index6
        };
        oTable1.fnSettings().ajax.data = param;
        oTable1.api().ajax.reload();
    }

    function next(e) { //
        var e = e || event;
        currKey = e.keyCode || e.which || e.charCode;
        var x;

        x = e.currentTarget || e.target || e.srcElement;
        if (currKey == 13) //回车
        {
            /*
            if (x.id == "code")
            {
                $("#index1").focus(); 
            }
            else if (x.id == "index1")
            {
                $("#index2").focus();
            }
            else if (x.id == "index2")
            {
                $("#phone").focus();
            }
            else if (x.id == "phone")
            {
                $("#index3").focus();
            }
            else if (x.id == "index3")
            {
                $("#index4").focus();
            }
            else if (x.id == "index4")
            {
                $("#index5").focus();
            }
            else if (x.id == "index5")
            {
                $("#index6").focus();
            }
            */

            if (x.id == "index1") {
                $("#index2").focus();
            } else if (x.id == "index2") {
                $("#index3").focus();
            } else if (x.id == "index3") {
                $("#index1").focus();
            }
        } else if (currKey == 32) //空格
        {
            //event.returnValue = false;    
            e.preventDefault();
            /*
            if (x.id == "code")
            {
                $("#index1").focus(); 
            }
            else if (x.id == "index1")
            {
                $("#index2").focus();
            }
            else if (x.id == "index2")
            {
                $("#phone").focus();
            }
            else if (x.id == "phone")
            {
                $("#index3").focus();
            }
            else if (x.id == "index3")
            {
                $("#index4").focus();
            }
            else if (x.id == "index4")
            {
                $("#index5").focus();
            }
            else if (x.id == "index5")
            {
                $("#index6").focus();
            }
            */

            if (x.id == "index1") {
                $("#index2").focus();
            } else if (x.id == "index2") {
                $("#index3").focus();
            } else if (x.id == "index3") {
                $("#index1").focus();
            }
        }
    }

    function arrow() {
        /*
        var x;

        x = event.currentTarget;
        
        //始终将输入焦点放在文本末尾
        if (x.createTextRange) {
            var rtextRange = x.createTextRange();
            rtextRange.moveStart('character', x.value.length);
            rtextRange.collapse(true);
            rtextRange.select();
        }
        else if (x.selectionStart) 
        {
            x.selectionStart = x.value.length;
        }
        
        switch(event.keyCode){
            //<---
            case 37:
                if (x.id == "sespell1")
                {
                    $("#sespell1").focus(); 
                }
                else if (x.id == "sespell2")
                {
                    $("#sespell1").focus();                     
                }
                else if (x.id == "sespell3")
                {
                    $("#sespell2").focus();
                }
                else if (x.id == "setel")
                {
                    $("#sespell3").focus();
                }
                break;
            //--->
            case 39:
                if (x.id == "sespell1")
                {
                    $("#sespell2").focus();               
                }
                else if (x.id == "sespell2")
                {
                    $("#sespell3").focus();                     
                }
                else if (x.id == "sespell3")
                {
                    $("#setel").focus();
                }
                else if (x.id == "setel")
                {
                    $("#setel").focus();
                }
                break;
        }
        */
    }
    
    function broadcast(num) {
        window.parent.broadcast(num);
        bootbox.alert({
            locale: "zh_CN",
            size: 'small',
            title: "提示",
            message: "号码已播报！"
        });
    }
    </script>
</body>

</html>
