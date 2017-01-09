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
        <link rel="stylesheet" href="assets/css/main.css" />
        <!-- ace settings handler -->
        <script src="assets/js/ace-extra.min.js"></script>
        <!-- 坐席列表样式 -->
        <link rel="stylesheet" href="css/vertical.news.slider.css">
        <style type="text/css"> 
         .abutt {  
            //background:none;
            border:none;
            //background:url(images/button1.png);
            background:#46B55A;
            width:70px;
            height:50px;
            max-width:97px;
        };
        
        </style>
    </head>

    <body>
        <div class="navbar navbar-default" id="navbar">
            <div class="navbar-container" id="navbar-container">
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <i class="icon-leaf"></i>
                            呼叫中心系统
                        </small>
                    </a><!-- /.brand -->
                </div><!-- /.navbar-header -->
                
                <div class="navbar-header pull-center">             
                    <table width="100%" border="0">
                        <tr style="display:none;">
                           <td valign=middle align=center><a href="http://libwebsockets.org"></a></td>
                           <td><section class="browser">Detected Browser: <div id=brow>...</div></section></td>
                        </tr>
                        <tr style="display:none;"><td width=200px align=center><div id=number> </div></td></tr>
                        
                        <tr>
                            <td width="250">
                                <div class="news-holder cf">
                                    <ul style="list-style-type:none;" class="news-headlines"  >
                                        <li class="selected">来电</li>
                                        <li >坐席</li>
                                    </ul>
                                    <div class="news-preview">
                                        <div class="news-content top-content">
                                            <table id="mList"  style="width:170px; text-align:center;" BORDERCOLOR="#FFF"  border="0">
                                                <tr><td>号码</td><td>队列</td></tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            
                            <td valign="bottom">
                                <input type="text" style="display:none;" id=AgentId value="1001" name="AgentId" />
                                <input type="text" style="display:none;" id=ExtNo value="1001" name="ExtNo" />
                                <label id="wsdi_status" >WAITING</label>
                                <label style="color:white">|&nbsp;座席工号：${sessionScope.userInfo.userName}</label>
                                <label style="color:white">|&nbsp;分机号码：${sessionScope.userInfo.phone}</label>
                                <label style="color:white">|&nbsp;状态：</label><label id="status" style="color:white">签出</label>
                                <label id="cid" style="color:white"></label>
                                <br />
                                <input class="abutt" type=button id=login value="签入" onclick="login();" >
                                <input class="abutt" type=button id=logout value="签出" onclick="logout();" style="display:none;" >
                                <input class="abutt" type=button id=ready value="就绪" onclick="ready();" >
                                <input class="abutt" type=button id=not_ready value="置忙" style="display:none;" onclick="not_ready();">
                                <input class="abutt" type=button id=eavesdrop value="监听" style="display:none;" onclick="eavesdrop();"/>
                                <input class="abutt" type=button id=hold value="保持" onclick="hold();" >
                                <input class="abutt" type=button id=unhold value="恢复" style="display:none;" onclick="unhold();">
                                <input class="abutt" type=button id=consult value="咨询" onclick="consult();"/>
                                <input class="abutt" type=button id=consult_cancel value="取消咨询" onclick="consult_cancel();" style="display:none;">
                                <input class="abutt" type=button id=finish_consult value="结束咨询" onclick="finish_consult();" style="display:none;" >
                                <input class="abutt" type=button id=consult_transfer value="咨询转接" onclick="consult_transfer();" style="display:none;" >
                                <input class="abutt" type=button id=conference value="三方会议" onclick="conference();" style="display:none;">
                                <input class="abutt" type=button id=intercept value="拦截" onclick="intercept();" style="display:none;" >
                                <input class="abutt" type=button id=force_conference value="强制三方" onclick="force_conference();" style="display:none;" >
                                <input class="abutt" type=button id=kill value="强制挂机" onclick="kill();" style="display:none;" >
                                <input class="abutt" type=button id=makecall value="外呼" onclick="makecall();"  >
                                <input class="abutt" type=button id=cl value="清空" onclick="cls();cls2();cls3();" >
                                <input style="height:50px;" type="text" id=CallNum name="CallNum" />
                                <input type=button id=answer value="answer" onclick="answer();" style="display:none;" >
                                <input type=button id=hangup value="hangup" onclick="hangup();" style="display:none;">
                                <input type=button id=offset value="connect" onclick="connect();" style="display:none;" />
                                <input type="text" id=fs_ip name="fs_ip" value="" style="display:none;" />
                            </td>
                        </tr>
                    </table>                
                    
                    <textarea style="position: relative;left: 0px;width:32%;display:none;" id=content rows="10" cols="50"></textarea>
                    <textarea style="width:32%;display:none;" id=agent_info rows="10" cols="50"></textarea>
                    <textarea style="position: relative;right: 0px;width:32%;display:none;" id=member_info rows="10" cols="50"></textarea>
                    
                    <script type="text/javascript">
                        //session值
                       	var userName="${sessionScope.userInfo.userName}";
						var phone = "${sessionScope.userInfo.phone}";
						var ip = "${sessionScope.userInfo.ip}";
						var paramCallId;                        
                        var logFlag = 0;//判断签入签出 
                        
                        var BrowserDetect = {
                            init: function () {
                                this.browser = this.searchString(this.dataBrowser) || "An unknown browser";
                                this.version = this.searchVersion(navigator.userAgent)
                                    || this.searchVersion(navigator.appVersion)
                                    || "an unknown version";
                                this.OS = this.searchString(this.dataOS) || "an unknown OS";
                            },
                            searchString: function (data) {
                                for (var i=0;i<data.length;i++) {
                                    var dataString = data[i].string;
                                    var dataProp = data[i].prop;
                                    this.versionSearchString = data[i].versionSearch || data[i].identity;
                                    if (dataString) {
                                        if (dataString.indexOf(data[i].subString) != -1)
                                            return data[i].identity;
                                    }
                                    else if (dataProp)
                                        return data[i].identity;
                                }
                            },
                            searchVersion: function (dataString) {
                                var index = dataString.indexOf(this.versionSearchString);
                                if (index == -1) return;
                                return parseFloat(dataString.substring(index+this.versionSearchString.length+1));
                            },
                            dataBrowser: [
                                {
                                    string: navigator.userAgent,
                                    subString: "Chrome",
                                    identity: "Chrome"
                                },
                                {   string: navigator.userAgent,
                                    subString: "OmniWeb",
                                    versionSearch: "OmniWeb/",
                                    identity: "OmniWeb"
                                },
                                {
                                    string: navigator.vendor,
                                    subString: "Apple",
                                    identity: "Safari",
                                    versionSearch: "Version"
                                },
                                {
                                    prop: window.opera,
                                    identity: "Opera",
                                    versionSearch: "Version"
                                },
                                {
                                    string: navigator.vendor,
                                    subString: "iCab",
                                    identity: "iCab"
                                },
                                {
                                    string: navigator.vendor,
                                    subString: "KDE",
                                    identity: "Konqueror"
                                },
                                {
                                    string: navigator.userAgent,
                                    subString: "Firefox",
                                    identity: "Firefox"
                                },
                                {
                                    string: navigator.vendor,
                                    subString: "Camino",
                                    identity: "Camino"
                                },
                                {       // for newer Netscapes (6+)
                                    string: navigator.userAgent,
                                    subString: "Netscape",
                                    identity: "Netscape"
                                },
                                {
                                    string: navigator.userAgent,
                                    subString: "MSIE",
                                    identity: "Explorer",
                                    versionSearch: "MSIE"
                                },
                                {
                                    string: navigator.userAgent,
                                    subString: "Gecko",
                                    identity: "Mozilla",
                                    versionSearch: "rv"
                                },
                                {       // for older Netscapes (4-)
                                    string: navigator.userAgent,
                                    subString: "Mozilla",
                                    identity: "Netscape",
                                    versionSearch: "Mozilla"
                                }
                            ],
                            dataOS : [
                                {
                                    string: navigator.platform,
                                    subString: "Win",
                                    identity: "Windows"
                                },
                                {
                                    string: navigator.platform,
                                    subString: "Mac",
                                    identity: "Mac"
                                },
                                {
                                       string: navigator.userAgent,
                                       subString: "iPhone",
                                       identity: "iPhone/iPod"
                                },
                                {
                                    string: navigator.platform,
                                    subString: "Linux",
                                    identity: "Linux"
                                }
                            ]
                        
                        };
                        BrowserDetect.init();
                        
                        document.getElementById("brow").textContent = " " + BrowserDetect.browser + " "
                            + BrowserDetect.version +" " + BrowserDetect.OS +" ";
                        
                        var pos = 0;
                        
                        function get_appropriate_ws_url()
                        {
                            var pcol;
                            var u = document.URL;
                        
                            /*
                             * We open the websocket encrypted if this page came on an
                             * https:// url itself, otherwise unencrypted
                             */
                        
                            if (u.substring(0, 5) == "https") {
                                pcol = "wss://";
                                u = u.substr(8);
                            } else {
                                pcol = "ws://";
                                if (u.substring(0, 4) == "http")
                                    u = u.substr(7);
                            }
                        
                            u = u.split('/');
                        
                            /* + "/xxx" bit is for IE10 workaround */
                        
                            return pcol + u[0] + "/xxx";
                        };
                        
                        
                        document.getElementById("number").textContent = get_appropriate_ws_url();
                        
                        var socket_di;
                        /* dumb increment protocol */
                        function disable(id){
                            //$("#"+id).css("color","#848484");
                            //$("#"+id).unbind("click");
                            $("#"+id).attr("disabled","disabled");
                        }
                        
                        function able(id){
                            //$("#"+id).css("color","#000");
                            //$("#"+id).click(function(){
                            //  eval(id+"()");
                            //});
                            $("#"+id).removeAttr("disabled");
                        }
                        
                        function resolveMessage(msg){
                            var json = eval('(' + msg + ')');
                            //签入成功
                            if(json.Event=="LOG"&&json.EventData.SubRequest=="IN"&&json.EventData.Status=="SUCCESS"){
                            
								able("logout");
                                //签出可用并显示
                                $("#logout").show();
                                $("#login").hide();
                                
                                //就绪可用
                                able("ready");
                                $("#ready").show();
                                $("#not_ready").hide();
                                $("#status").text("签入");
                                logFlag = 1;
                                
                                //直接就绪
                                //$("#ready").click();
                            }
                            //签出成功
                            else if(json.Event=="LOG"&&json.EventData.SubRequest=="OUT"&&json.EventData.Status=="SUCCESS"){
                                disable("ready");
                                disable("makecall");
								able("login");
                                $("#ready").show();
                                $("#not_ready").hide();
                                $("#logout").hide();
                                $("#login").show();
                                $("#status").text("签出");
                                logFlag = 0;
                            }
                            //置闲成功
                            else if(json.Event=="UPDATE"&&json.EventData.SubRequest=="IDLE"&&json.EventData.Status=="SUCCESS"){
                                able("makecall");
                                able("not_ready");
                                $("#not_ready").show();
                                $("#ready").hide();
                                $("#status").text("就绪");
                            }
                            //置忙成功
                            else if(json.Event=="UPDATE"&&json.EventData.SubRequest=="BUSY"&&json.EventData.Status=="SUCCESS"){
                                disable("makecall");
                                $("#not_ready").hide();
                                $("#ready").show();
                                $("#status").text("置忙");
                            }
                            //座席振铃
                            else if(json.Event=="CALL"&&json.EventData.Reason=="AGENT_RING"&&json.EventData.Status=="RING"){
                                if (json.EventData.Queue == "114")    //弹出114界面
                                {
                                   goToRight("querynum!goTo114Page.do",18);
                                }
                                else   //弹出112界面
                                {
                                   goToRight("trou!goToTrouPage.do?paramCallId="+paramCallId,16);
                                }
                                
                                disable("hold");
                                disable("eavesdrop");
                                disable("consult");
                                disable("logout");
                                disable("not_ready");
                                disable("makecall");
                                $("#unhold").hide();
                                $("#status").text("座席振铃。。。");
                                $("#cid").text("| 主叫号码：" + json.EventData.CallIdNumber);
                            }
                            //正在通话
                            else if(json.Event=="CALL"&&json.EventData.Reason=="BRIDGE"&&json.EventData.Status=="SUCCESS"){
                                $("#status").text("通话中。。。");
                                able("hold");
                                $("#hold").show();
                                able("consult");
                                $("#unhold").hide();
                            }
                            //主叫、或者座席、两方通话时，有一方挂机
                            else if((json.Event=="CALL" && json.EventData.SubRequest=="HANGUP")
                                || (json.Event=="CALL" && json.EventData.Status=="HANGUP")){
                                
                                //签出、置忙可用
                                able("logout");
                                able("not_ready");
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用
                                able("makecall");
				$("#makecall").show();
     
                                //咨询取消不可用、隐藏 
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
     
                                //结束咨询不可用、隐藏 
                                disable("finish_consult");
                                $("#finish_consult").hide();     
     
                                //咨询转接不可用、隐藏 
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
     
                                //三方不可用、隐藏 
                                disable("conference");
                                $("#conference").hide();
                                
                                //$("#unhold").hide();
                                $("#status").text("就绪");
                                $("#cid").text("");
                            }
                            //呼叫保持
                            else if(json.Event=="HOLD"&&json.EventData.Status=="SUCCESS"&&json.EventData.SubRequest!="OFF"){
                                
                                //取保持可用、显示
                                able("unhold");
                                $("#unhold").show();
                                
                                //保持隐藏、不可用
                                disable("hold");
                                $("#hold").hide();
                                
                                //咨询不可用
                                disable("consult");
                                
                                
                                $("#status").text("呼叫保持。。。");
                            }
                            //取保持
                            else if(json.Event=="HOLD"&&json.EventData.SubRequest=="OFF"&&json.EventData.Status=="SUCCESS"){
                            
                                //取保持隐藏、不可用
                                disable("unhold");
                                $("#unhold").hide();
                                
                                //保持显示、可用
                                able("hold");
                                $("#hold").show();
                                
                                //咨询可用
                                able("consult");
                                $("#status").text("通话中。。。");
                            }
                            //开始外呼
                            else if(json.Event=="MAKECALL"&&json.EventData.Status=="IN PROGRESS"
                                && json.EventData.Reason==""){
                            
                                //保持、咨询、外呼显示、不可用                                
                                disable("makecall");
                                
                                //置忙显示、不可用
                                disable("not_ready");
                                
                                //签出显示、不可用
                                disable("logout");
                                
                                $("#status").text("正在呼叫座席分机，听到振铃请摘机。。。");
                            }
                            //外呼时座席摘机
                            else if(json.Event=="MAKECALL"&&json.EventData.Reason=="AGENT_ANSWER"){
                                $("#status").text("坐席摘机。。。");
                            }
                            //开始外呼客户电话
                            else if(json.Event=="MAKECALL"&&json.EventData.Status=="IN PROGRESS"
                                && json.EventData.Reason=="CALLING_CUSTOMER"){
                            
                                //保持、咨询、外呼显示、不可用                                
                                disable("makecall");
                                
                                //置忙显示、不可用
                                disable("not_ready");
                                
                                //签出显示、不可用
                                disable("logout");
                                
                                $("#status").text("正在呼叫客户，请等待。。。");
                            }
                            //外呼失败
                            else if(json.Event=="MAKECALL"&&json.EventData.Status=="FAIL"){
                                
                                //外呼按钮恢复可用                                
                                able("makecall");
                                
                                //置忙恢复可用
                                able("not_ready");
                                
                                //签出恢复可用
                                able("logout");
                                
                                //状态改成就绪
                                $("#status").text("就绪");
                            }
                            //外呼桥接成功
                            else if(json.Event=="MAKECALL"&&json.EventData.Reason=="BRIDGED"){
                                $("#status").text("通话中。。。");
                                
                                //保持可用
                                able("hold");
                            }
                            //外呼中有一方挂机
                            else if(json.Event=="MAKECALL"
                                && (json.EventData.Reason=="HANGUP" || json.EventData.Reason=="AGENT_SINGLE_HANGUP"
                                || json.EventData.SubRequest=="HANGUP"
                                || (json.EventData.SubRequest=="CANCEL") && json.EventData.Reason=="AGENT_CANCEL")){
                                $("#cid").text("");
                                $("#status").text("就绪");
                                
                                //签出、置忙、外呼恢复可用
                                able("logout");
                                able("not_ready");
                                able("makecall");
                                
                                //保持变成不可用
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用
                                disable("consult");
                                
                                //$("#unhold").hide();
                            }
                            //发起咨询
                            else if(json.Event=="CONSULT"&&json.EventData.Status=="IN PROGRESS"){
                                
                                //咨询不可用、隐藏
                                disable("consult");
                                $("#consult").hide();
                                
                                //保持不可用
                                disable("hold");
                                //$("#hold").hide();
                                
                                //外呼不可用
                                disable("makecall");
                                //$("#makecall").hide();
                                
                                //咨询取消显示、可用
                                able("consult_cancel");
                                $("#consult_cancel").show();
                                
                                $("#status").text("正在呼叫咨询电话，请等待。。。");
                            }
                            //取消咨询
                            else if(json.Event=="CONSULT" && json.EventData.SubRequest == "CANCEL"
                                && json.EventData.Status == "SUCCESS"){
                                
                                //咨询可用、显示
                                able("consult");
                                $("#consult").show();
                                
                                //保持恢复可用
                                able("hold");
                                //$("#hold").hide();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                $("#status").text("通话中。。。");
                            }
                            //咨询成功
                            else if(json.Event=="CONSULT"&&json.EventData.Status=="SUCCESS" 
                                && json.EventData.SubRequest == ""){
                            
                                //外呼不可用、隐藏
                                disable("makecall");
                                $("#makecall").hide();
                                
                                //保持不可用、隐藏
                                disable("hold");
                                $("#hold").hide();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询可用、显示
                                able("finish_consult");
                                $("#finish_consult").show(); 
                                
                                //咨询转接可用、显示   --> jy项目,屏蔽，改为不显示
                                //able("consult_transfer");
                                //$("#consult_transfer").show();
                                
                                //三方可用、显示	--> jy项目,屏蔽，改为不显示
                                //able("conference");
                                //$("#conference").show();
                                
                                $("#status").text("咨询中。。。");
                            }
                            //结束咨询，重新桥接主叫跟座席
                            else if(json.Event=="CONSULT" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "FINISH" && json.EventData.Reason == "REBRIDGE"){
                                
                                //保持可用、显示
                                able("hold");
                                $("#hold").show();
                                
                                //咨询可用、显示
                                able("consult");
                                $("#consult").show();
                                
                                //外呼不可用、显示
                                disable("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("通话中。。。");
                            }
			    //咨询中，（客户挂机后）坐席先挂机 -- add by yu
			    else if(json.Event=="CONSULT" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "FINISH" && json.EventData.Reason == "AGENT_HANGUP") {
								
								//签出、置忙可用
                                able("logout");
                                able("not_ready");
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用
                                able("makecall");
				$("#makecall").show();				
								//咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                //$("#unhold").hide();
                                $("#status").text("就绪");
                                $("#cid").text("");
								
							}
                            //咨询转接，座席在转接后，自己就挂机了，恢复空闲状态
                            else if(json.Event=="CONSULT" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "TRANSFER" && json.EventData.Reason == ""){
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用、显示
                                able("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("就绪");
                            }
                            //进入三方会议
                            else if(json.Event=="CONFERENCE" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "" && json.EventData.Reason == ""){
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼不可用、显示
                                disable("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("会议中。。。");
                            }
                            //三方会议中，第三方挂断
                            else if(json.Event=="CONFERENCE" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "MEMBER_EXIT" && json.EventData.Reason == "THIRDPARTY_HANGUP"){
                                
                                //保持可用、显示
                                able("hold");
                                $("#hold").show();
                                
                                //咨询可用、显示
                                able("consult");
                                $("#consult").show();
                                
                                //外呼不可用、显示
                                disable("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("会议中。。。");
                            }
                            //三方会议，座席挂断自己
                            else if(json.Event=="CONFERENCE" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "MEMBER_EXIT" && json.EventData.Reason == "AGENT_HANGUP"){
                                
                                //签出显示、可用
                                able("logout");
                                $("#logout").show();
                                                                
                                //置忙显示、可用
                                able("not_ready");
                                $("#not_ready").show();
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用、显示
                                able("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("就绪");
                            }
                            //三方会议，剩座席和第三方时，座席挂断自己
                            else if(json.Event=="CONFERENCE" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "FINISH" && json.EventData.Reason == "AGENT_HANGUP"){
                                
                                //签出显示、可用
                                able("logout");
                                $("#logout").show();
                                                                
                                //置忙显示、可用
                                able("not_ready");
                                $("#not_ready").show();
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用、显示
                                able("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("就绪");
                            }
                            //三方会议，客户挂断
                            else if(json.Event=="CONFERENCE" && json.EventData.Status=="SUCCESS"
                                && json.EventData.SubRequest == "MEMBER_EXIT" && json.EventData.Reason == "CUSTOMER_HANGUP"){
                                
                                //签出显示、不可用
                                disable("logout");
                                $("#logout").show();
                                                                
                                //置忙显示、不可用
                                disable("not_ready");
                                $("#not_ready").show();
                                
                                //保持不可用、显示
                                disable("hold");
                                $("#hold").show();
                                
                                //咨询不可用、显示
                                disable("consult");
                                $("#consult").show();
                                
                                //外呼可用、显示
                                disable("makecall");
                                $("#makecall").show();
                                
                                //咨询取消不可用、隐藏
                                disable("consult_cancel");
                                $("#consult_cancel").hide();
                                
                                //结束咨询不可用、隐藏
                                disable("finish_consult");
                                $("#finish_consult").hide();                                
                                
                                //咨询转接不可用、隐藏
                                disable("consult_transfer");
                                $("#consult_transfer").hide();
                                
                                //三方不可用、隐藏
                                disable("conference");
                                $("#conference").hide();
                                
                                $("#status").text("会议中。。。");
                            }
                            
                            //禁止签入、签出、置闲、置忙
                            //disable("login");
                            //disable("logout");
                            //disable("ready");
                            //disable("not_ready");
                        }
                        
                        function connect() {    
                            
                            if (typeof MozWebSocket != "undefined") {
                                socket_di = new MozWebSocket("ws://" + ip +":7681/xxx",
                                           "dumb-increment-protocol");
                            } else {
                                socket_di = new WebSocket("ws://" + ip +":7681/xxx",
                                           "dumb-increment-protocol");
                            }                       
                        
                            try {
                                socket_di.onopen = function() {
                                    document.getElementById("wsdi_status").style.backgroundColor = "#40ff40";
                                    document.getElementById("wsdi_status").textContent = " OPENED ";
                                    
                                    disable("login");
                                    $("#login").click();
                                } 
                        
                                socket_di.onmessage =function got_packet(msg) {
                                    //document.getElementById("number").textContent = msg.data + "\n";
                                    if (msg.data.indexOf("AgentList") >= 0)
                                    {
                                        document.getElementById("agent_info").value = document.getElementById("agent_info").value 
                                            + msg.data + "\n";
                                    }
                                    else if (msg.data.indexOf("MemberList") >= 0)
                                    {
                                        $("#mList").empty();
                                        $("#mList").append("<tr><td>号码</td><td>队列</td></tr>");
                                        var json = eval('(' + msg.data + ')');              
                                        var memberList = json.MemberList;
                                        
                                        if(memberList.length>0){
                                            $(memberList).each(function(index) {
                                            //输出每个root子对象的名称和值   
                                            var member = memberList[index]; 
                                            paramCallId = member.CallerID;//主叫号码，用于传参
                                      
                                            var trHTML = "<tr><td>"+member.CallerID+"</td><td>"+member.QueueName+"</td></tr>";
                                            $("#mList").append(trHTML) ;
                                            })  
                                        }
                                        document.getElementById("member_info").value = document.getElementById("member_info").value
                                            + msg.data + "\n";
                                    }
                                    else
                                    {
                                        document.getElementById("content").value = document.getElementById("content").value
                                            + msg.data + "\n";
                                        resolveMessage(msg.data);
                                    }
                                } 
                        
                                socket_di.onclose = function(){
                                    document.getElementById("wsdi_status").style.backgroundColor = "#ff4040";
                                    document.getElementById("wsdi_status").textContent = " CLOSED ";
                                }
                            } catch(exception) {
                                alert('<p>Error' + exception);  
                            }
                        };                      
                        
                        //114报号
                        function broadcast(num) {
                            //if (document.getElementById("broadcast_no").value == "")
                            if (num == "")
                            {
                                alert("请输入播报号码！");
                                return;
                            }
                            
                            socket_di.send('{"RequestId":600,"RequestData":{"SubRequest":"","AgentId":"' 
                                + userName + '","ExtNo":"","ExtNoType":"","114BroadcastNo":"'
                                + num+ '"}}');
                        };                      
                        
                        function reset() {
                            socket_di.send("reset\n");
                        };
                        
                        //签入
                        function login() {
                            socket_di.send('{"RequestId":100,"RequestData":{"SubRequest":"IN","AgentId":"' + userName
                                + '","ExtNo":"sofia/internal/' + phone + '@' + gwIp + '","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //签出
                        function logout() {
                            socket_di.send('{"RequestId":101,"RequestData":{"SubRequest":"IN","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //就绪
                        function ready() {
                            socket_di.send('{"RequestId":102,"RequestData":{"SubRequest":"IN","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //置忙
                        function not_ready() {
                            socket_di.send('{"RequestId":103,"RequestData":{"SubRequest":"IN","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //挂机
                        function hangup() {
                            socket_di.send('{"RequestId":106,"RequestData":{"SubRequest":"IN","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //外呼
                        function makecall() {
                            if (document.getElementById("CallNum").value == "")
                            {
                                alert("请输入外呼号码！");
                                return;
                            }
                            socket_di.send('{"RequestId":400,"RequestData":{"SubRequest":"outside","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","CalleeNum":"' + document.getElementById("CallNum").value + '"}}');
    
                        };
                        
                        //112回访
                        function makecall2(num) { 
                            socket_di.send('{"RequestId":400,"RequestData":{"SubRequest":"outside","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","CalleeNum":"' + num + '"}}');     
                        };
                        
                        
                        
                        
                        function cls() {
                            //alert("你好！");
                            document.getElementById("content").value = "";
                        };
                        
                        function cls2() {
                            //alert("你好！");
                            document.getElementById("agent_info").value = "";
                        };
                        
                        function cls3() {
                            //alert("你好！");
                            document.getElementById("member_info").value = "";
                        };
                        
                        //保持
                        function hold() {
                            socket_di.send('{"RequestId":200,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //取保持
                        function unhold() {
                            socket_di.send('{"RequestId":202,"RequestData":{"SubRequest":"OFF","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","thisQueues":["","",""]}}');
                        };
                        
                        //咨询
                        function consult() {
                            if (document.getElementById("CallNum").value == "")
                            {
                                alert("请输入咨询号码！");
                                return;
                            }
                            
                            socket_di.send('{"RequestId":300,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","ThirdParty":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //取消咨询（第三方未接听时）
                        function consult_cancel() {
                            socket_di.send('{"RequestId":301,"RequestData":{"SubRequest":"CANCEL","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","ThirdParty":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //结束咨询（与第三方通话中）
                        function finish_consult() {
                            socket_di.send('{"RequestId":303,"RequestData":{"SubRequest":"FINISH","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","ThirdParty":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //咨询转接（转给第三方）
                        function consult_transfer() {
                            socket_di.send('{"RequestId":305,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","ThirdParty":""}}');
                        };
                        
                        //三方通话（会议）
                        function conference() {
                            socket_di.send('{"RequestId":306,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","ThirdParty":""}}');
                        };
                        
                        //监听
                        function eavesdrop() {
                            socket_di.send('{"RequestId":500,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","DestAgentId":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //拦截
                        function intercept() {
                            socket_di.send('{"RequestId":503,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","DestAgentId":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //强制三方
                        function force_conference() {
                            socket_di.send('{"RequestId":504,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","DestAgentId":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //强拆
                        function kill() {
                            socket_di.send('{"RequestId":505,"RequestData":{"SubRequest":"","AgentId":"' + userName
                                + '","ExtNo":"","ExtNoType":"","DestAgentId":"' + document.getElementById("CallNum").value + '"}}');
                        };
                        
                        //断开websocket连接
                        function disconnect() {                
                            socket_di.close();
                        };          
                    </script>
                </div>
                
                <div class="navbar-header pull-right" role="navigation">
                    <ul class="ace-nav">
                        <li>
                            <span class="white">欢迎光临，<s:property value="#session.userInfo.userName" /></span>
                            <a id="modifypsw_admin" data-toggle="modal" 
  										 data-target="#password"  href="">  
                                更改密码
                            </a>
                            <a id="logout_sys" href="#">
                                退出
                            </a>
                        </li>   
                    </ul><!-- /.ace-nav -->
                </div><!-- /.navbar-header -->
            </div><!-- /navbar-container -->
        </div>

        <div class="main-container" id="main-container">
            <div class="main-container-inner">
                <div class="sidebar" id="sidebar">
                    <div class="nav nav-list-div">
	                    <ul class="nav nav-list" id="textTree">
	                    </ul><!-- /.nav-list -->
	                    
	                    <div class="sidebar-collapse" id="sidebar-collapse">
	                        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	                    </div>
                    </div>
                </div>

                <div class="main-content">
                    <iframe id="rightFarme" name="right" width="100%" height="100%" src="" frameborder="no" scrolling="yes" allowtransparency="true" >
                    </iframe>
                </div><!-- /.main-content -->
            </div><!-- /.main-container-inner -->
        </div><!-- /.main-container -->


<!-- 模态框（Modal） -->
		<div class="modal fade" id="password" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							更改密码
						</h4>
					</div>
						<input type="hidden" id="modleuserId" >
						<input type="hidden" id="flag">
						<div class="modal-body">
							<table class="modal-table" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr rowpos="1" class="FormData" id="">
										<td class="CaptionTD">
											原始密码
										</td>
										<td class="DataTD">
											<input type="password" id="oldPw" class="">
										</td>
									</tr>

									<tr rowpos="2" class="FormData" id="">
										<td class="CaptionTD">
											新密码
										</td>
										<td  class="DataTD">
											<input type="password" id="newPw1" class="">
										</td>

									</tr>
									<tr rowpos="3" class="FormData" id="tr_note">
										<td class="CaptionTD">
											确认新密码
										</td>
										<td  class="DataTD">
											<input type="password" id="newPw2" class="">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-sm btn-primary " id="save">
								提交
							</button>
							<button type="button" class="btn btn-sm btn-default"
								data-dismiss="modal">
								关闭
							</button>
						</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>



        <!-- basic scripts -->

        <script src="assets/js/jquery-1.10.2.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/typeahead-bs2.min.js"></script>
        <!-- ace scripts -->

        <script src="assets/js/ace.min.js"></script>
        <script src="assets/js/bootbox.js"></script>
        <script src="assets/js/jquery.slimscroll.min.js"></script>
        <script src="assets/js/crud/crud.js"></script>
        <!-- inline scripts related to this page -->

        <script type="text/javascript">
            var roleId = "${sessionScope.userInfo.roleId}";
			var userId = "${sessionScope.userInfo.userId}";
            var html = "";
            var count;
            var ip2 = "${sessionScope.userInfo.ip}";
            var gwIp = "${sessionScope.userInfo.gwIp}";
            
            $(document).ready(function(){
                disable("ready");
                disable("eavesdrop");
                disable("hold");
                disable("consult");
                disable("makecall");
                $("#fs_ip").val(ip2);
                connect();
                
                $.ajax({     
                            url:'menu!menuTree.do',
                            data:{
                                "roleId":roleId,
                            },
                            type:'post',     
                            dataType:'json',
                            async : false, // 异步     
                            error:function(){     
                                alert('error');     
                            },     
                            success:function(data){
                                var menuList = data.menuList;
                                $(menuList).each(function(index) {
                                    var menu = menuList[index];
                                    //从根节点开始构建树
                                    if(menu.parentId==0){
                                        html += 
                                            "<li>" +
                                                "<a href=\"#\" class=\"dropdown-toggle\">" +
                                                    "<i class=\""+menu.menuIco+"\"></i>" +
                                                    "<span class=\"menu-text\">"+menu.menuName+"</span><b class=\"arrow icon-angle-down\"></b>" +
                                                "</a>";
                                        html += "<ul class=\"submenu\">";
                                        count = 1;
                                        //构建根节点的子节点
                                        buildMenu(menu.menuId,menu.menuName,menuList);
                                        html += "</ul>";
                                        html += "</li>";
                                    }
                                });
                                //console.log(html);
                                $('#textTree').append(html);
                            }
                });
                
                //展开所有一级菜单
	            $("#textTree > li").addClass("open");
	            $("#textTree > li > ul").css("display", "block");
            });
            
            //构造树，出去根节点
            function buildMenu(menuId,menuName,menuList){
                    $(menuList).each(function(index) {
                    var menu = menuList[index];
                    if(menuId==menu.parentId){
                        if(hasChild(menu.menuId,menuList)>0){//如果有子节点 构造<ul>
                            count++;
                            html += 
                                "<li>" +
                                    "<a href=\""+menu.menuUrl+"\" class=\"dropdown-toggle\">";
                                    
                            if(count<=2){
                                html += "<i class=\"icon-double-angle-right\"></i>";
                            }
                            html +=     "<i class=\""+menu.menuIco+"\"></i>" +
                                        "<span class=\"menu-text\">  "+menu.menuName+"</span>";
                            html +=     "<b class=\"arrow icon-angle-down\"></b>" +
                                    "</a>";
                            //构造子节点     
                            html += "<ul class=\"submenu\">";
                            buildMenu(menu.menuId,menu.menuName,menuList);
                            html += "</ul>";    
                        }else{
                            html += 
                                "<li id=\"act"+menu.menuId+"\">" +
                                    "<a href=\"javascript:goToRight('"+menu.menuUrl+"',"+menu.menuId+")\">";
                            if(count<=2){
                                html += "<i class=\"icon-double-angle-right\"></i>";
                            }
                                        //"<i class=\"icon-double-angle-right\"></i>" +
                            html +=     "<i class=\""+menu.menuIco+"\"></i>" +
                                        "<span class=\"menu-text\">  "+menu.menuName+"</span>"+
                                    "</a>" +
                                "</li>";
                        }
                        html += "</li>";
                    }
                    
                }); 
            }           
                
        
            var lastid = 0;
            function goToRight(url,id,pid){
                if(lastid!=0){
                    $("#act"+lastid).removeClass("active");
                }
                $("#act"+id).addClass("active");
                lastid = id;
                
                $("#rightFarme").attr('src',url);
                setHeight();
            }
            function setHeight(){
                $("#rightFarme").height(document.documentElement.clientHeight-110);
                setTimeout(setHeight, 500);
            }
            
            $("#logout_sys").click(function(){
                bootbox.confirm({
                        locale: "zh_CN",
                        size: 'small',
                        title:"提示",
                        message: "确认要退出？", 
                        callback: function(result){
                            if(result){
                                //alert(logFlag);
                                if(logFlag==1){
                                    //not_ready();
                                    //logout();
                                    disconnect();
                                }
                                window.location.href='login!logout.do';
                            }
                        }
                    });
            }); 
            
            window.onload=function(){//刷新
                //not_ready();
                //logout();
                //disconnect();
            }
            
            
            			$("#save").click(function(){
				var oldPw = $("#oldPw").val();
				var newPw1 = $("#newPw1").val();
				var newPw2 = $("#newPw2").val();
				if(newPw1!=newPw2){
					bootbox.alert({  
            				message: "两次输入的密码不一致，请重新输入",   
            		 		title: "提示",
            		 		locale: "zh_CN",
    				 		size: 'small'
    					});
						return false;
				}else{
					$.ajax({     
    					url:'user!modifPw.do',
						data:{
							"oldPw":oldPw,
							"newPw1":newPw1,
							"newPw2":newPw2,
							"userId":userId
						},
    					type:'post',     
    					dataType:'json',
    					async : false, // 异步     
    					error:function(){     
       						alert('error');     
    					},     
    					success:function(data){
							if(data.resNum==1){
								//$("#modal").modal("hide");
								bootbox.dialog({
  									message: "密码修改成功,需要重新登录",
  									title: "提示", 
  									// 退出dialog时的回调函数，包括用户使用ESC键及点击关闭
  									onEscape: function() {
										window.location.href='login!logout.do';
 							 		},
  									// 是否显示关false闭按钮，默认true
  									closeButton: false,
 									 buttons: {
   										 success: {   
      										label: "确认",
      										className: "btn btn-sm btn-primary",
      										callback: function() {
	  											window.location.href='login!logout.do';
      										}
    									}
  									}
								});
							}else if(data.resNum==0){
								bootbox.alert({  
            					message: data.res,   
            		 			title: "提示",
            		 			locale: "zh_CN",
    				 			size: 'small'
    						});
							}
        				}
					});
				}
			});	
        </script>
        <script src="js/vertical.news.slider.js"></script>
        
        <iframe id="rightFarme" name="right" width="0%" height="0%" src="http://10.77.120.135/tsdboss/mainServlet.html?ds=tsdBilling&login=true&logintype=1&sadminname=<s:property value="#session.userInfo.bossuser" />&spassword=<s:property value="#session.userInfo.bossPwd" />" frameborder="no" style="display:none" scrolling="yes" allowtransparency="true" >
                    </iframe>
</body>

</html>

