<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>项目管理系统 by www.mianfeimoban.com</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.jsp","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="xuqiumingxi.jsp";
   document.getElementById("fom").submit();
}
</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;</td>
			  </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
         
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 员工工资详细信息</td>
                    </tr>
                                      <tr>
                                        <td height="20" align="right" bgcolor="#FFFFFF">基本工资:</td>
                                        <td colspan="2" bgcolor="#FFFFFF">1000</td>
                                      </tr>
                      <tr>
				    <td width="16%" height="20" align="right" bgcolor="#FFFFFF">奖金:</td>
                    <td width="84%" colspan="2" bgcolor="#FFFFFF">120</td>
                    </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">其它奖金:</td>
				    <td colspan="2" bgcolor="#FFFFFF">120</td>
                    </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">总工资:</td>
				    <td colspan="2" bgcolor="#FFFFFF">2000</td>
                    </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">处罚扣除金额:</td>
                    <td colspan="2" bgcolor="#FFFFFF">20</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">应实发总工资:</td>
                    <td colspan="2" bgcolor="#FFFFFF">1500</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">工资发放时间:</td>
                    <td colspan="2" bgcolor="#FFFFFF">2001-1-1</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">工资发放人:</td>
                    <td colspan="2" bgcolor="#FFFFFF">信息</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">工资领取人:</td>
                    <td colspan="2" bgcolor="#FFFFFF">系</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">发放类型:</td>
                    <td colspan="2" bgcolor="#FFFFFF">打卡</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">年份:</td>
                    <td colspan="2" bgcolor="#FFFFFF">2008</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">月份:</td>
                    <td colspan="2" bgcolor="#FFFFFF">9</td>
                  </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">记录创建时间:</td>
                    <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                  </tr>
                  <tr>
				    <td height="65" align="right" bgcolor="#FFFFFF">描述:</td>
				    <td colspan="2" bgcolor="#FFFFFF">aaaa</td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
