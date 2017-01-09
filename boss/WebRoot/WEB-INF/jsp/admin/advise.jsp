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
</head>

<body>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">业务受理</a>
            </li>
            <li class="active">
                投诉建议
            </li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    <div class="page-content">
        <div id="user-profile-2" class="user-profile">
            <div class="tabbable">
                <ul class="nav nav-tabs padding-18">
                    <li class="active">
                        <a data-toggle="tab" href="#adviseInsert">
                            <i class="green icon-comment bigger-120"></i>投诉建议</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#adviseSelect"> <i class="green icon-list bigger-120"></i> 受理列表 </a>
                    </li>
                </ul>
                <div class="tab-content no-border padding-10">
                    <div id="adviseInsert" class="tab-pane in active">
                        <div class="table-search">
                            <div class="col-sm-12 no-padding-left" style="padding-bottom:10px;">
                                <div class="col-sm-6 no-padding-right">
                                    <label class="control-label no-padding-right">反馈类型：</label>
                                    <select name="jobtype" calss="" id="jobtype" style="width:270px;margin-left:0px;">
                                        <option role="option" value="-1">&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                        <option role="option" value="112fault">服务态度差</option>
                                        <option role="option" value="radfault">处理速度满</option>
                                        <option role="option" value="tvfault">其他</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 no-padding-right">
                                    <label class="control-label no-padding-right">投诉站点：</label>
                                    <select name="jobtype" calss="" id="advisesite" style="width:270px;margin-left:0px;">
                                        <option role="option" value="-1">&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                        <option role="option" value="112fault">通讯管理处</option>
                                        <option role="option" value="radfault">普光通信站</option>
                                        <option role="option" value="tvfault">其他</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 no-padding-left" style="padding-bottom:10px;">
                                <div class="col-sm-6 no-padding-right">
                                    <label class="control-label no-padding-right" for="form-field-1">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label>
                                    <input type="text" class="input-xlarge" id="linkman">
                                </div>
                                <div class="col-sm-6 no-padding-right">
                                    <label class="control-label no-padding-right" for="form-field-1">联系电话：</label>
                                    <input type="text" class="input-xlarge" name="" id="linkphone">
                                </div>
                            </div>
                            <div class="col-sm-12 no-padding-left" style="padding-bottom:10px;">
                                <div class="col-sm-6 no-padding-right">
                                    <label class="control-label no-padding-right" for="form-field-1">投诉内容：</label>
                                    <textarea class="form-control" rows="3"></textarea>
                                </div>
                                <div class="col-sm-6 no-padding-right" style="">
                                    <label class="control-label no-padding-right" for="form-field-1">回复内容：</label>
                                    <textarea class="form-control" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="col-sm-12 center" style="padding-bottom:5px;">
                                <div>
                                    <input type="button" class="btn btn-sm btn-primary pull-center" style="" id="saveFault" value="受理" onclick="saveFault();" />
                                    <input type="button" class="btn btn-sm btn-primary pull-center" id="reset" value="重置" onclick="reset();" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="adviseSelect" class="tab-pane">
                        <div class="col-sm-12">
                            <div class="table-search">
                                <div class="col-sm-12 no-padding-left tablesearch">
                                    <div class='col-sm-4'>
                                        <label class="control-label no-padding-right">
                                            联系人:
                                        </label>
                                        <input type="text" class="input-small" name="deptInfo.deptName" id="linkman">
                                    </div>
                                    <div class='col-sm-4'>
                                        <label class="control-label no-padding-right" for="form-field-1">
                                            联系电话:
                                        </label>
                                        <input type="text" class="input-small" name="deptInfo.deptName" id="linktel">
                                    </div>
                                    <div class='col-sm-4'>
                                        <label class="control-label no-padding-right" for="form-field-1">
                                            受理时间:
                                        </label>
                                        <input type="text" class="input-small" name="deptInfo.deptName" id="time">
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="col-sm-6">
                                        <button type="submit" id="dsearch" class="btn btn-sm btn-primary pull-right">
                                            查询
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <table id="adviseTable" class="table table-striped table-bordered table-hover">
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
    </script>
</body>

</html>
