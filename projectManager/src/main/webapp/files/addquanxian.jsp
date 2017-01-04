<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理系统 by www.mianfeimoban.com</title>
<style type="text/css">
<!--
body {
	margin-left: 6px;
	margin-top: 6px;
	margin-right: 6px;
	margin-bottom: 6px;
	background-image: url();
}
html { overflow-x: ; overflow-y: ; border:0;} 
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />

<script language="JavaScript" type="text/javascript">

//提交方式
function check()
{
	if(!Validator.Validate(document.getElementById('fom'),1))
	{
		return false;
	}
	
	var sfz = document.getElementById("gwmc").value;
	if (sfz == null || sfz.value == ""){
		alert("请填写名称");
		return false;
	}
	
	document.getElementById("fom").submit();
}
/**
function checkqx(){
	<#if (model.gangweiquanxianTables?exists) && (model.gangweiquanxianTables?size > 0)>
		<#list model.gangweiquanxianTables as list>
			var obj_${list_index} = document.getElementById('${list.qx?if_exists}');
			if (obj_${list_index} != null){
				obj_${list_index}.checked = true;
			}
		</#list>
	</#if>
}
*/
function doDisplayTable(num){
	var obj = document.getElementById('table'+num);
	if (obj != null){
		if (obj.style.display=="none"){
			obj.style.display="";
		}else{
			obj.style.display="none";
		}
	}
	for (var i=1;i<7;i++){
		if (i != num){
			obj = document.getElementById("table"+i);
			if (obj != null){
				obj.style.display="none";
			}
		}
	}
}

function checkSq(obj,num){
	if (obj != null){
		if (num == 1){
			checkTable1(obj.checked);
		}else if (num == 2){
			checkTable2(obj.checked);
		}else if (num == 3){
			checkTable3(obj.checked);
		}else if (num == 4){
			checkTable4(obj.checked);
		}else if (num == 5){
			checkTable5(obj.checked);
		}else if (num == 6){
			checkTable6(obj.checked);
		}
	}
}

function checkTable1(torf){
	for (var i=17;i<33;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
	for (var j=1;j<6;j++){
		var obj = document.getElementById(81+"-"+j);
		if (obj != null){
			obj.checked = torf;
		}
	}
	for (var j=1;j<6;j++){
		var obj = document.getElementById(102+"-"+j);
		if (obj != null){
			obj.checked = torf;
		}
	}
	for (var j=1;j<6;j++){
		var obj = document.getElementById(103+"-"+j);
		if (obj != null){
			obj.checked = torf;
		}
	}
	
}

function checkTable2(torf){
	for (var i=15;i<17;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
	for (var i=33;i<47;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
}


function checkTable3(torf){
	for (var i=48;i<59;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
	
	for (var j=1;j<6;j++){
			var obj = document.getElementById(100+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
}

function checkTable4(torf){
	for (var i=59;i<66;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
}

function checkTable5(torf){
	for (var i=68;i<75;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
	for (var j=1;j<6;j++){
			var obj = document.getElementById(101+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
}

function checkTable6(torf){
	for (var i=76;i<81;i++){
		for (var j=1;j<6;j++){
			var obj = document.getElementById(i+"-"+j);
			if (obj != null){
				obj.checked = torf;
			}
		}
	}
}

</script>
</head>

<body >

<table width="100%">
<tr>
	<td align="center">
		<font size="4"><b>权限设置列表</b></font>
	</td>
</tr>
</table>


<form name="fom" id="fom" method="post" action="savequanxian.action" onsubmit="">

<table width="778" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#A36107" class="mxfont01">

<input type="hidden" name="gwId" id="gwId" value="${model.gwId?if_exists}"/>

  <tr>
    <td height="40" align="center" bgcolor="#FFFFFF">岗位名称</td>
    <td bgcolor="#FFFFFF"><input type="text" name="gwmc" id="gwmc" value=""/></td>
  </tr>
  
  <tr>
    <td height="40" align="center" valign="top" bgcolor="#FFFFFF">权限</td>
    <td bgcolor="#FFFFFF">
    	<table>
    		<tr height="30">
    			<td width="250">
    				基础信息子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="10-1" value="10-1">增</input>
    				<input type="checkbox" name="getQx" id="10-2" value="10-2">删</input>
    				<input type="checkbox" name="getQx" id="10-3" value="10-3">改</input>
    				<input type="checkbox" name="getQx" id="10-4" value="10-4">查</input>
    				<input type="checkbox" name="getQx" id="10-5" value="10-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
<!-- 第一个街道 南宁市青秀区中山街道办事处 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('1');" class="leftfo05"><li>南宁市青秀区中山街道办事处</li></a><input type="checkbox" name="click1" onclick="checkSq(this,'1');">全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="14-1" value="14-1">增</input>
    				<input type="checkbox" name="getQx" id="14-2" value="14-2">删</input>
    				<input type="checkbox" name="getQx" id="14-3" value="14-3">改</input>
    				<input type="checkbox" name="getQx" id="14-4" value="14-4">查</input>
    				<input type="checkbox" name="getQx" id="14-5" value="14-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table1" id="table1" style="display:none">
    				
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）东方园社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="17-1" value="17-1">增</input>
			    				<input type="checkbox" name="getQx" id="17-2" value="17-2">删</input>
			    				<input type="checkbox" name="getQx" id="17-3" value="17-3">改</input>
			    				<input type="checkbox" name="getQx" id="17-4" value="17-4">查</input>
			    				<input type="checkbox" name="getQx" id="17-5" value="17-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）商业大院社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="18-1" value="18-1">增</input>
			    				<input type="checkbox" name="getQx" id="18-2" value="18-2">删</input>
			    				<input type="checkbox" name="getQx" id="18-3" value="18-3">改</input>
			    				<input type="checkbox" name="getQx" id="18-4" value="18-4">查</input>
			    				<input type="checkbox" name="getQx" id="18-5" value="18-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）河堤新社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="19-1" value="19-1">增</input>
			    				<input type="checkbox" name="getQx" id="19-2" value="19-2">删</input>
			    				<input type="checkbox" name="getQx" id="19-3" value="19-3">改</input>
			    				<input type="checkbox" name="getQx" id="19-4" value="19-4">查</input>
			    				<input type="checkbox" name="getQx" id="19-5" value="19-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）南国社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="20-1" value="20-1">增</input>
			    				<input type="checkbox" name="getQx" id="20-2" value="20-2">删</input>
			    				<input type="checkbox" name="getQx" id="20-3" value="20-3">改</input>
			    				<input type="checkbox" name="getQx" id="20-4" value="20-4">查</input>
			    				<input type="checkbox" name="getQx" id="20-5" value="20-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）中山社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="21-1" value="21-1">增</input>
			    				<input type="checkbox" name="getQx" id="21-2" value="21-2">删</input>
			    				<input type="checkbox" name="getQx" id="21-3" value="21-3">改</input>
			    				<input type="checkbox" name="getQx" id="21-4" value="21-4">查</input>
			    				<input type="checkbox" name="getQx" id="21-5" value="21-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（6）新兴苑社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="22-1" value="22-1">增</input>
			    				<input type="checkbox" name="getQx" id="22-2" value="22-2">删</input>
			    				<input type="checkbox" name="getQx" id="22-3" value="22-3">改</input>
			    				<input type="checkbox" name="getQx" id="22-4" value="22-4">查</input>
			    				<input type="checkbox" name="getQx" id="22-5" value="22-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（7）桃源南社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="23-1" value="23-1">增</input>
			    				<input type="checkbox" name="getQx" id="23-2" value="23-2">删</input>
			    				<input type="checkbox" name="getQx" id="23-3" value="23-3">改</input>
			    				<input type="checkbox" name="getQx" id="23-4" value="23-4">查</input>
			    				<input type="checkbox" name="getQx" id="23-5" value="23-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（8）津头社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="24-1" value="24-1">增</input>
			    				<input type="checkbox" name="getQx" id="24-2" value="24-2">删</input>
			    				<input type="checkbox" name="getQx" id="24-3" value="24-3">改</input>
			    				<input type="checkbox" name="getQx" id="24-4" value="24-4">查</input>
			    				<input type="checkbox" name="getQx" id="24-5" value="24-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（9）天桃社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="25-1" value="25-1">增</input>
			    				<input type="checkbox" name="getQx" id="25-2" value="25-2">删</input>
			    				<input type="checkbox" name="getQx" id="25-3" value="25-3">改</input>
			    				<input type="checkbox" name="getQx" id="25-4" value="25-4">查</input>
			    				<input type="checkbox" name="getQx" id="25-5" value="25-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（10）河堤社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="26-1" value="26-1">增</input>
			    				<input type="checkbox" name="getQx" id="26-2" value="26-2">删</input>
			    				<input type="checkbox" name="getQx" id="26-3" value="26-3">改</input>
			    				<input type="checkbox" name="getQx" id="26-4" value="26-4">查</input>
			    				<input type="checkbox" name="getQx" id="26-5" value="26-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（11）桃源北社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="27-1" value="27-1">增</input>
			    				<input type="checkbox" name="getQx" id="27-2" value="27-2">删</input>
			    				<input type="checkbox" name="getQx" id="27-3" value="27-3">改</input>
			    				<input type="checkbox" name="getQx" id="27-4" value="27-4">查</input>
			    				<input type="checkbox" name="getQx" id="27-5" value="27-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（12）八一社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="28-1" value="28-1">增</input>
			    				<input type="checkbox" name="getQx" id="28-2" value="28-2">删</input>
			    				<input type="checkbox" name="getQx" id="28-3" value="28-3">改</input>
			    				<input type="checkbox" name="getQx" id="28-4" value="28-4">查</input>
			    				<input type="checkbox" name="getQx" id="28-5" value="28-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（13）医科大社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="29-1" value="29-1">增</input>
			    				<input type="checkbox" name="getQx" id="29-2" value="29-2">删</input>
			    				<input type="checkbox" name="getQx" id="29-3" value="29-3">改</input>
			    				<input type="checkbox" name="getQx" id="29-4" value="29-4">查</input>
			    				<input type="checkbox" name="getQx" id="29-5" value="29-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（14）七星社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="30-1" value="30-1">增</input>
			    				<input type="checkbox" name="getQx" id="30-2" value="30-2">删</input>
			    				<input type="checkbox" name="getQx" id="30-3" value="30-3">改</input>
			    				<input type="checkbox" name="getQx" id="30-4" value="30-4">查</input>
			    				<input type="checkbox" name="getQx" id="30-5" value="30-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（15）新兴村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="31-1" value="31-1">增</input>
			    				<input type="checkbox" name="getQx" id="31-2" value="31-2">删</input>
			    				<input type="checkbox" name="getQx" id="31-3" value="31-3">改</input>
			    				<input type="checkbox" name="getQx" id="31-4" value="31-4">查</input>
			    				<input type="checkbox" name="getQx" id="31-5" value="31-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（16）津头村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="32-1" value="32-1">增</input>
			    				<input type="checkbox" name="getQx" id="32-2" value="32-2">删</input>
			    				<input type="checkbox" name="getQx" id="32-3" value="32-3">改</input>
			    				<input type="checkbox" name="getQx" id="32-4" value="32-4">查</input>
			    				<input type="checkbox" name="getQx" id="32-5" value="32-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（17）柳沙
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="81-1" value="81-1">增</input>
			    				<input type="checkbox" name="getQx" id="81-2" value="81-2">删</input>
			    				<input type="checkbox" name="getQx" id="81-3" value="81-3">改</input>
			    				<input type="checkbox" name="getQx" id="81-4" value="81-4">查</input>
			    				<input type="checkbox" name="getQx" id="81-5" value="81-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（18）柳沙北社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="102-1" value="102-1">增</input>
			    				<input type="checkbox" name="getQx" id="102-2" value="102-2">删</input>
			    				<input type="checkbox" name="getQx" id="102-3" value="102-3">改</input>
			    				<input type="checkbox" name="getQx" id="102-4" value="102-4">查</input>
			    				<input type="checkbox" name="getQx" id="102-5" value="102-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（19）柳沙南社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="103-1" value="103-1">增</input>
			    				<input type="checkbox" name="getQx" id="103-2" value="103-2">删</input>
			    				<input type="checkbox" name="getQx" id="103-3" value="103-3">改</input>
			    				<input type="checkbox" name="getQx" id="103-4" value="103-4">查</input>
			    				<input type="checkbox" name="getQx" id="103-5" value="103-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		
    				</table>
    			</td>
    		</tr>   		

<!-- 第二个街道 南宁市青秀区新竹街道办事处 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('2');" class="leftfo05"><li>南宁市青秀区新竹街道办事处</li></a><input type="checkbox" name="check2" onclick="checkSq(this,'2');" >全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
 					<input type="checkbox" name="getQx" id="13-1" value="13-1">增</input>
    				<input type="checkbox" name="getQx" id="13-2" value="13-2">删</input>
    				<input type="checkbox" name="getQx" id="13-3" value="13-3">改</input>
    				<input type="checkbox" name="getQx" id="13-4" value="13-4">查</input>
    				<input type="checkbox" name="getQx" id="13-5" value="13-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table2" id="table2" style="display:none">
    				
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）大板二社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="15-1" value="15-1">增</input>
			    				<input type="checkbox" name="getQx" id="15-2" value="15-2">删</input>
			    				<input type="checkbox" name="getQx" id="15-3" value="15-3">改</input>
			    				<input type="checkbox" name="getQx" id="15-4" value="15-4">查</input>
			    				<input type="checkbox" name="getQx" id="15-5" value="15-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）思贤社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="33-1" value="33-1">增</input>
			    				<input type="checkbox" name="getQx" id="33-2" value="33-2">删</input>
			    				<input type="checkbox" name="getQx" id="33-3" value="33-3">改</input>
			    				<input type="checkbox" name="getQx" id="33-4" value="33-4">查</input>
			    				<input type="checkbox" name="getQx" id="33-5" value="33-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）农林社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="34-1" value="34-1">增</input>
			    				<input type="checkbox" name="getQx" id="34-2" value="34-2">删</input>
			    				<input type="checkbox" name="getQx" id="34-3" value="34-3">改</input>
			    				<input type="checkbox" name="getQx" id="34-4" value="34-4">查</input>
			    				<input type="checkbox" name="getQx" id="34-5" value="34-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）新竹社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="35-1" value="35-1">增</input>
			    				<input type="checkbox" name="getQx" id="35-2" value="35-2">删</input>
			    				<input type="checkbox" name="getQx" id="35-3" value="35-3">改</input>
			    				<input type="checkbox" name="getQx" id="35-4" value="35-4">查</input>
			    				<input type="checkbox" name="getQx" id="35-5" value="35-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）民族中
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="36-1" value="36-1">增</input>
			    				<input type="checkbox" name="getQx" id="36-2" value="36-2">删</input>
			    				<input type="checkbox" name="getQx" id="36-3" value="36-3">改</input>
			    				<input type="checkbox" name="getQx" id="36-4" value="36-4">查</input>
			    				<input type="checkbox" name="getQx" id="36-5" value="36-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（6）东葛社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="37-1" value="37-1">增</input>
			    				<input type="checkbox" name="getQx" id="37-2" value="37-2">删</input>
			    				<input type="checkbox" name="getQx" id="37-3" value="37-3">改</input>
			    				<input type="checkbox" name="getQx" id="37-4" value="37-4">查</input>
			    				<input type="checkbox" name="getQx" id="37-5" value="37-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（7）鲤湾社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="38-1" value="38-1">增</input>
			    				<input type="checkbox" name="getQx" id="38-2" value="38-2">删</input>
			    				<input type="checkbox" name="getQx" id="38-3" value="38-3">改</input>
			    				<input type="checkbox" name="getQx" id="38-4" value="38-4">查</input>
			    				<input type="checkbox" name="getQx" id="38-5" value="38-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（8）大板一社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="16-1" value="16-1">增</input>
			    				<input type="checkbox" name="getQx" id="16-2" value="16-2">删</input>
			    				<input type="checkbox" name="getQx" id="16-3" value="16-3">改</input>
			    				<input type="checkbox" name="getQx" id="16-4" value="16-4">查</input>
			    				<input type="checkbox" name="getQx" id="16-5" value="16-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（9）民生东社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="39-1" value="39-1">增</input>
			    				<input type="checkbox" name="getQx" id="39-2" value="39-2">删</input>
			    				<input type="checkbox" name="getQx" id="39-3" value="39-3">改</input>
			    				<input type="checkbox" name="getQx" id="39-4" value="39-4">查</input>
			    				<input type="checkbox" name="getQx" id="39-5" value="39-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（10）民族宫社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="40-1" value="40-1">增</input>
			    				<input type="checkbox" name="getQx" id="40-2" value="40-2">删</input>
			    				<input type="checkbox" name="getQx" id="40-3" value="40-3">改</input>
			    				<input type="checkbox" name="getQx" id="40-4" value="40-4">查</input>
			    				<input type="checkbox" name="getQx" id="40-5" value="40-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（11）纬武社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="41-1" value="41-1">增</input>
			    				<input type="checkbox" name="getQx" id="41-2" value="41-2">删</input>
			    				<input type="checkbox" name="getQx" id="41-3" value="41-3">改</input>
			    				<input type="checkbox" name="getQx" id="41-4" value="41-4">查</input>
			    				<input type="checkbox" name="getQx" id="41-5" value="41-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（12）民主路社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="42-1" value="42-1">增</input>
			    				<input type="checkbox" name="getQx" id="42-2" value="42-2">删</input>
			    				<input type="checkbox" name="getQx" id="42-3" value="42-3">改</input>
			    				<input type="checkbox" name="getQx" id="42-4" value="42-4">查</input>
			    				<input type="checkbox" name="getQx" id="42-5" value="42-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（13）民主东社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="43-1" value="43-1">增</input>
			    				<input type="checkbox" name="getQx" id="43-2" value="43-2">删</input>
			    				<input type="checkbox" name="getQx" id="43-3" value="43-3">改</input>
			    				<input type="checkbox" name="getQx" id="43-4" value="43-4">查</input>
			    				<input type="checkbox" name="getQx" id="43-5" value="43-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（14）建政社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="44-1" value="44-1">增</input>
			    				<input type="checkbox" name="getQx" id="44-2" value="44-2">删</input>
			    				<input type="checkbox" name="getQx" id="44-3" value="44-3">改</input>
			    				<input type="checkbox" name="getQx" id="44-4" value="44-4">查</input>
			    				<input type="checkbox" name="getQx" id="44-5" value="44-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（15）建园社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="45-1" value="45-1">增</input>
			    				<input type="checkbox" name="getQx" id="45-2" value="45-2">删</input>
			    				<input type="checkbox" name="getQx" id="45-3" value="45-3">改</input>
			    				<input type="checkbox" name="getQx" id="45-4" value="45-4">查</input>
			    				<input type="checkbox" name="getQx" id="45-5" value="45-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（16）葛麻村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="46-1" value="46-1">增</input>
			    				<input type="checkbox" name="getQx" id="46-2" value="46-2">删</input>
			    				<input type="checkbox" name="getQx" id="46-3" value="46-3">改</input>
			    				<input type="checkbox" name="getQx" id="46-4" value="46-4">查</input>
			    				<input type="checkbox" name="getQx" id="46-5" value="46-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
    				</table>
    			</td>
    		</tr> 
    		
    		
<!-- 第三个街道 南宁市青秀区津头街道办事处 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('3');" class="leftfo05"><li>南宁市青秀区津头街道办事处</li></a><input type="checkbox" name="check3"  onclick="checkSq(this,'3');">全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
 					<input type="checkbox" name="getQx" id="47-1" value="47-1">增</input>
    				<input type="checkbox" name="getQx" id="47-2" value="47-2">删</input>
    				<input type="checkbox" name="getQx" id="47-3" value="47-3">改</input>
    				<input type="checkbox" name="getQx" id="47-4" value="47-4">查</input>
    				<input type="checkbox" name="getQx" id="47-5" value="47-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table3" id="table3" style="display:none">
    				
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）金洲社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="48-1" value="48-1">增</input>
			    				<input type="checkbox" name="getQx" id="48-2" value="48-2">删</input>
			    				<input type="checkbox" name="getQx" id="48-3" value="48-3">改</input>
			    				<input type="checkbox" name="getQx" id="48-4" value="48-4">查</input>
			    				<input type="checkbox" name="getQx" id="48-5" value="48-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）金浦社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="49-1" value="49-1">增</input>
			    				<input type="checkbox" name="getQx" id="49-2" value="49-2">删</input>
			    				<input type="checkbox" name="getQx" id="49-3" value="49-3">改</input>
			    				<input type="checkbox" name="getQx" id="49-4" value="49-4">查</input>
			    				<input type="checkbox" name="getQx" id="49-5" value="49-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）埌西社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="50-1" value="50-1">增</input>
			    				<input type="checkbox" name="getQx" id="50-2" value="50-2">删</input>
			    				<input type="checkbox" name="getQx" id="50-3" value="50-3">改</input>
			    				<input type="checkbox" name="getQx" id="50-4" value="50-4">查</input>
			    				<input type="checkbox" name="getQx" id="50-5" value="50-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）南湖小区社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="51-1" value="51-1">增</input>
			    				<input type="checkbox" name="getQx" id="51-2" value="51-2">删</input>
			    				<input type="checkbox" name="getQx" id="51-3" value="51-3">改</input>
			    				<input type="checkbox" name="getQx" id="51-4" value="51-4">查</input>
			    				<input type="checkbox" name="getQx" id="51-5" value="51-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）大板三社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="52-1" value="52-1">增</input>
			    				<input type="checkbox" name="getQx" id="52-2" value="52-2">删</input>
			    				<input type="checkbox" name="getQx" id="52-3" value="52-3">改</input>
			    				<input type="checkbox" name="getQx" id="52-4" value="52-4">查</input>
			    				<input type="checkbox" name="getQx" id="52-5" value="52-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（6）滨湖社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="53-1" value="53-1">增</input>
			    				<input type="checkbox" name="getQx" id="53-2" value="53-2">删</input>
			    				<input type="checkbox" name="getQx" id="53-3" value="53-3">改</input>
			    				<input type="checkbox" name="getQx" id="53-4" value="53-4">查</input>
			    				<input type="checkbox" name="getQx" id="53-5" value="53-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（7）埌西村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="54-1" value="54-1">增</input>
			    				<input type="checkbox" name="getQx" id="54-2" value="54-2">删</input>
			    				<input type="checkbox" name="getQx" id="54-3" value="54-3">改</input>
			    				<input type="checkbox" name="getQx" id="54-4" value="54-4">查</input>
			    				<input type="checkbox" name="getQx" id="54-5" value="54-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（8）南湖村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="55-1" value="55-1">增</input>
			    				<input type="checkbox" name="getQx" id="55-2" value="55-2">删</input>
			    				<input type="checkbox" name="getQx" id="55-3" value="55-3">改</input>
			    				<input type="checkbox" name="getQx" id="55-4" value="55-4">查</input>
			    				<input type="checkbox" name="getQx" id="55-5" value="55-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（9）麻村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="56-1" value="56-1">增</input>
			    				<input type="checkbox" name="getQx" id="56-2" value="56-2">删</input>
			    				<input type="checkbox" name="getQx" id="56-3" value="56-3">改</input>
			    				<input type="checkbox" name="getQx" id="56-4" value="56-4">查</input>
			    				<input type="checkbox" name="getQx" id="56-5" value="56-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（10）秀山社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="57-1" value="57-1">增</input>
			    				<input type="checkbox" name="getQx" id="57-2" value="57-2">删</input>
			    				<input type="checkbox" name="getQx" id="57-3" value="57-3">改</input>
			    				<input type="checkbox" name="getQx" id="57-4" value="57-4">查</input>
			    				<input type="checkbox" name="getQx" id="57-5" value="57-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（11）凤岭南社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="58-1" value="58-1">增</input>
			    				<input type="checkbox" name="getQx" id="58-2" value="58-2">删</input>
			    				<input type="checkbox" name="getQx" id="58-3" value="58-3">改</input>
			    				<input type="checkbox" name="getQx" id="58-4" value="58-4">查</input>
			    				<input type="checkbox" name="getQx" id="58-5" value="58-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（12）翡翠园社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="100-1" value="100-1">增</input>
			    				<input type="checkbox" name="getQx" id="100-2" value="100-2">删</input>
			    				<input type="checkbox" name="getQx" id="100-3" value="100-3">改</input>
			    				<input type="checkbox" name="getQx" id="100-4" value="100-4">查</input>
			    				<input type="checkbox" name="getQx" id="100-5" value="100-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
    				</table>
    			</td>
    		</tr> 
    		
<!-- 第四个街道 南宁市青秀区建政街道办事处 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('4');" class="leftfo05"><li>南宁市青秀区建政街道办事处</li></a><input type="checkbox" name="check4"  onclick="checkSq(this,'4');">全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
 					<input type="checkbox" name="getQx" id="66-1" value="66-1">增</input>
    				<input type="checkbox" name="getQx" id="66-2" value="66-2">删</input>
    				<input type="checkbox" name="getQx" id="66-3" value="66-3">改</input>
    				<input type="checkbox" name="getQx" id="66-4" value="66-4">查</input>
    				<input type="checkbox" name="getQx" id="66-5" value="66-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table4" id="table4" style="display:none">
    				
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）金花茶社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="59-1" value="59-1">增</input>
			    				<input type="checkbox" name="getQx" id="59-2" value="59-2">删</input>
			    				<input type="checkbox" name="getQx" id="59-3" value="59-3">改</input>
			    				<input type="checkbox" name="getQx" id="59-4" value="59-4">查</input>
			    				<input type="checkbox" name="getQx" id="59-5" value="59-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）方园社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="60-1" value="60-1">增</input>
			    				<input type="checkbox" name="getQx" id="60-2" value="60-2">删</input>
			    				<input type="checkbox" name="getQx" id="60-3" value="60-3">改</input>
			    				<input type="checkbox" name="getQx" id="60-4" value="60-4">查</input>
			    				<input type="checkbox" name="getQx" id="60-5" value="60-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）广园社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="61-1" value="61-1">增</input>
			    				<input type="checkbox" name="getQx" id="61-2" value="61-2">删</input>
			    				<input type="checkbox" name="getQx" id="61-3" value="61-3">改</input>
			    				<input type="checkbox" name="getQx" id="61-4" value="61-4">查</input>
			    				<input type="checkbox" name="getQx" id="61-5" value="61-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）茅桥社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="62-1" value="62-1">增</input>
			    				<input type="checkbox" name="getQx" id="62-2" value="62-2">删</input>
			    				<input type="checkbox" name="getQx" id="62-3" value="62-3">改</input>
			    				<input type="checkbox" name="getQx" id="62-4" value="62-4">查</input>
			    				<input type="checkbox" name="getQx" id="62-5" value="62-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）长堽路社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="63-1" value="63-1">增</input>
			    				<input type="checkbox" name="getQx" id="63-2" value="63-2">删</input>
			    				<input type="checkbox" name="getQx" id="63-3" value="63-3">改</input>
			    				<input type="checkbox" name="getQx" id="63-4" value="63-4">查</input>
			    				<input type="checkbox" name="getQx" id="63-5" value="63-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（6）二塘社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="64-1" value="64-1">增</input>
			    				<input type="checkbox" name="getQx" id="64-2" value="64-2">删</input>
			    				<input type="checkbox" name="getQx" id="64-3" value="64-3">改</input>
			    				<input type="checkbox" name="getQx" id="64-4" value="64-4">查</input>
			    				<input type="checkbox" name="getQx" id="64-5" value="64-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（7）长堽村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="65-1" value="65-1">增</input>
			    				<input type="checkbox" name="getQx" id="65-2" value="65-2">删</input>
			    				<input type="checkbox" name="getQx" id="65-3" value="65-3">改</input>
			    				<input type="checkbox" name="getQx" id="65-4" value="65-4">查</input>
			    				<input type="checkbox" name="getQx" id="65-5" value="65-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>			    		
    				</table>
    			</td>
    		</tr> 
    		
<!-- 第五个街道 南宁市青秀区南湖街道办事处 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('5');" class="leftfo05"><li>南宁市青秀区南湖街道办事处</li></a><input type="checkbox" name="check5"  onclick="checkSq(this,'5');">全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
 					<input type="checkbox" name="getQx" id="67-1" value="67-1">增</input>
    				<input type="checkbox" name="getQx" id="67-2" value="67-2">删</input>
    				<input type="checkbox" name="getQx" id="67-3" value="67-3">改</input>
    				<input type="checkbox" name="getQx" id="67-4" value="67-4">查</input>
    				<input type="checkbox" name="getQx" id="67-5" value="67-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table5" id="table5" style="display:none">
    				
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）金湖社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="68-1" value="68-1">增</input>
			    				<input type="checkbox" name="getQx" id="68-2" value="68-2">删</input>
			    				<input type="checkbox" name="getQx" id="68-3" value="68-3">改</input>
			    				<input type="checkbox" name="getQx" id="68-4" value="68-4">查</input>
			    				<input type="checkbox" name="getQx" id="68-5" value="68-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）屯里社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="69-1" value="69-1">增</input>
			    				<input type="checkbox" name="getQx" id="69-2" value="69-2">删</input>
			    				<input type="checkbox" name="getQx" id="69-3" value="69-3">改</input>
			    				<input type="checkbox" name="getQx" id="69-4" value="69-4">查</input>
			    				<input type="checkbox" name="getQx" id="69-5" value="69-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）凤岭北社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="70-1" value="70-1">增</input>
			    				<input type="checkbox" name="getQx" id="70-2" value="70-2">删</input>
			    				<input type="checkbox" name="getQx" id="70-3" value="70-3">改</input>
			    				<input type="checkbox" name="getQx" id="70-4" value="70-4">查</input>
			    				<input type="checkbox" name="getQx" id="70-5" value="70-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）凤翔社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="101-1" value="101-1">增</input>
			    				<input type="checkbox" name="getQx" id="101-2" value="101-2">删</input>
			    				<input type="checkbox" name="getQx" id="101-3" value="101-3">改</input>
			    				<input type="checkbox" name="getQx" id="101-4" value="101-4">查</input>
			    				<input type="checkbox" name="getQx" id="101-5" value="101-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）嘉宾社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="71-1" value="71-1">增</input>
			    				<input type="checkbox" name="getQx" id="71-2" value="71-2">删</input>
			    				<input type="checkbox" name="getQx" id="71-3" value="71-3">改</input>
			    				<input type="checkbox" name="getQx" id="71-4" value="71-4">查</input>
			    				<input type="checkbox" name="getQx" id="71-5" value="71-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（6）埌东村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="72-1" value="72-1">增</input>
			    				<input type="checkbox" name="getQx" id="72-2" value="72-2">删</input>
			    				<input type="checkbox" name="getQx" id="72-3" value="72-3">改</input>
			    				<input type="checkbox" name="getQx" id="72-4" value="72-4">查</input>
			    				<input type="checkbox" name="getQx" id="72-5" value="72-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（7）那廖村
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="73-1" value="73-1">增</input>
			    				<input type="checkbox" name="getQx" id="73-2" value="73-2">删</input>
			    				<input type="checkbox" name="getQx" id="73-3" value="73-3">改</input>
			    				<input type="checkbox" name="getQx" id="73-4" value="73-4">查</input>
			    				<input type="checkbox" name="getQx" id="73-5" value="73-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（8）南湖派出所
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="74-1" value="74-1">增</input>
			    				<input type="checkbox" name="getQx" id="74-2" value="74-2">删</input>
			    				<input type="checkbox" name="getQx" id="74-3" value="74-3">改</input>
			    				<input type="checkbox" name="getQx" id="74-4" value="74-4">查</input>
			    				<input type="checkbox" name="getQx" id="74-5" value="74-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>			    		
    				</table>
    			</td>
    		</tr> 

<!-- 第六个街道 南宁市仙葫经济开发管理委员会 -->
    		<tr>
    			<td>
    				<a href="#" onclick="javascript:doDisplayTable('6');" class="leftfo05"><li>南宁市仙葫经济开发管理委员会</li></a><input type="checkbox" name="check6"  onclick="checkSq(this,'6');">全选社区</input>
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
 					<input type="checkbox" name="getQx" id="75-1" value="75-1">增</input>
    				<input type="checkbox" name="getQx" id="75-2" value="75-2">删</input>
    				<input type="checkbox" name="getQx" id="75-3" value="75-3">改</input>
    				<input type="checkbox" name="getQx" id="75-4" value="75-4">查</input>
    				<input type="checkbox" name="getQx" id="75-5" value="75-5">统</input>
    			</td>
    		</tr>
    		
	   		<tr height="1px">
	   			<td colspan="3" bgcolor="black">
	   			</td>
	   		</tr>
    		
    		<tr>
    			<td colspan="3">
    				<table name="table6" id="table6" style="display:none">
			    		<tr height="30">
			    			<td width="250">
			    				&nbsp;&nbsp;&nbsp;&nbsp;（1）莫村社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="76-1" value="76-1">增</input>
			    				<input type="checkbox" name="getQx" id="76-2" value="76-2">删</input>
			    				<input type="checkbox" name="getQx" id="76-3" value="76-3">改</input>
			    				<input type="checkbox" name="getQx" id="76-4" value="76-4">查</input>
			    				<input type="checkbox" name="getQx" id="76-5" value="76-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（2）金葫社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="77-1" value="77-1">增</input>
			    				<input type="checkbox" name="getQx" id="77-2" value="77-2">删</input>
			    				<input type="checkbox" name="getQx" id="77-3" value="77-3">改</input>
			    				<input type="checkbox" name="getQx" id="77-4" value="77-4">查</input>
			    				<input type="checkbox" name="getQx" id="77-5" value="77-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（3）那舅社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="78-1" value="78-1">增</input>
			    				<input type="checkbox" name="getQx" id="78-2" value="78-2">删</input>
			    				<input type="checkbox" name="getQx" id="78-3" value="78-3">改</input>
			    				<input type="checkbox" name="getQx" id="78-4" value="78-4">查</input>
			    				<input type="checkbox" name="getQx" id="78-5" value="78-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（4）五合社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="79-1" value="79-1">增</input>
			    				<input type="checkbox" name="getQx" id="79-2" value="79-2">删</input>
			    				<input type="checkbox" name="getQx" id="79-3" value="79-3">改</input>
			    				<input type="checkbox" name="getQx" id="79-4" value="79-4">查</input>
			    				<input type="checkbox" name="getQx" id="79-5" value="79-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>
			    		
			    		<tr height="30">
			    			<td>
			    				&nbsp;&nbsp;&nbsp;&nbsp;（5）蓉茉社区
			    			</td>
			    			<td>&nbsp;
			    				
			    			</td>
			    			<td>
			    				<input type="checkbox" name="getQx" id="80-1" value="80-1">增</input>
			    				<input type="checkbox" name="getQx" id="80-2" value="80-2">删</input>
			    				<input type="checkbox" name="getQx" id="80-3" value="80-3">改</input>
			    				<input type="checkbox" name="getQx" id="80-4" value="80-4">查</input>
			    				<input type="checkbox" name="getQx" id="80-5" value="80-5">统</input>
			    			</td>
			    		</tr>
			    		
			    		<tr height="1px">
			    			<td colspan="3" bgcolor="black">
			    			</td>
			    		</tr>	    		
    				</table>
    			</td>
    		</tr> 

<!-- 尾巴 -->
    		<tr height="30">
    			<td>
    				公安局子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="11-1" value="11-1">增</input>
    				<input type="checkbox" name="getQx" id="11-2" value="11-2">删</input>
    				<input type="checkbox" name="getQx" id="11-3" value="11-3">改</input>
    				<input type="checkbox" name="getQx" id="11-4" value="11-4">查</input>
    				<input type="checkbox" name="getQx" id="11-5" value="11-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				人口和计划生育子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="7-1" value="7-1">增</input>
    				<input type="checkbox" name="getQx" id="7-2" value="7-2">删</input>
    				<input type="checkbox" name="getQx" id="7-3" value="7-3">改</input>
    				<input type="checkbox" name="getQx" id="7-4" value="7-4">查</input>
    				<input type="checkbox" name="getQx" id="7-5" value="7-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				教育子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="2-1" value="2-1">增</input>
    				<input type="checkbox" name="getQx" id="2-2" value="2-2">删</input>
    				<input type="checkbox" name="getQx" id="2-3" value="2-3">改</input>
    				<input type="checkbox" name="getQx" id="2-4" value="2-4">查</input>
    				<input type="checkbox" name="getQx" id="2-5" value="2-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				劳动保障子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="4-1" value="4-1">增</input>
    				<input type="checkbox" name="getQx" id="4-2" value="4-2">删</input>
    				<input type="checkbox" name="getQx" id="4-3" value="4-3">改</input>
    				<input type="checkbox" name="getQx" id="4-4" value="4-4">查</input>
    				<input type="checkbox" name="getQx" id="4-5" value="4-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				建设子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="5-1" value="5-1">增</input>
    				<input type="checkbox" name="getQx" id="5-2" value="5-2">删</input>
    				<input type="checkbox" name="getQx" id="5-3" value="5-3">改</input>
    				<input type="checkbox" name="getQx" id="5-4" value="5-4">查</input>
    				<input type="checkbox" name="getQx" id="5-5" value="5-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				卫生子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="8-1" value="8-1">增</input>
    				<input type="checkbox" name="getQx" id="8-2" value="8-2">删</input>
    				<input type="checkbox" name="getQx" id="8-3" value="8-3">改</input>
    				<input type="checkbox" name="getQx" id="8-4" value="8-4">查</input>
    				<input type="checkbox" name="getQx" id="8-5" value="8-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				工商子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="12-1" value="12-1">增</input>
    				<input type="checkbox" name="getQx" id="12-2" value="12-2">删</input>
    				<input type="checkbox" name="getQx" id="12-3" value="12-3">改</input>
    				<input type="checkbox" name="getQx" id="12-4" value="12-4">查</input>
    				<input type="checkbox" name="getQx" id="12-5" value="12-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr  height="30">
    			<td>
    				司法系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="1-1" value="1-1">增</input>
    				<input type="checkbox" name="getQx" id="1-2" value="1-2">删</input>
    				<input type="checkbox" name="getQx" id="1-3" value="1-3">改</input>
    				<input type="checkbox" name="getQx" id="1-4" value="1-4">查</input>
    				<input type="checkbox" name="getQx" id="1-5" value="1-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr  height="30">
    			<td>
    				文化体育子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="9-1" value="9-1">增</input>
    				<input type="checkbox" name="getQx" id="9-2" value="9-2">删</input>
    				<input type="checkbox" name="getQx" id="9-3" value="9-3">改</input>
    				<input type="checkbox" name="getQx" id="9-4" value="9-4">查</input>
    				<input type="checkbox" name="getQx" id="9-5" value="9-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr  height="30">
    			<td>
    				城管环卫子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="6-1" value="6-1">增</input>
    				<input type="checkbox" name="getQx" id="6-2" value="6-2">删</input>
    				<input type="checkbox" name="getQx" id="6-3" value="6-3">改</input>
    				<input type="checkbox" name="getQx" id="6-4" value="6-4">查</input>
    				<input type="checkbox" name="getQx" id="6-5" value="6-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr  height="30">
    			<td>
    				民政子系统
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="3-1" value="3-1">增</input>
    				<input type="checkbox" name="getQx" id="3-2" value="3-2">删</input>
    				<input type="checkbox" name="getQx" id="3-3" value="3-3">改</input>
    				<input type="checkbox" name="getQx" id="3-4" value="3-4">查</input>
    				<input type="checkbox" name="getQx" id="3-5" value="3-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr  height="30">
    			<td>
    				用户管理
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="9999-1" value="9999-1">增</input>
    				<input type="checkbox" name="getQx" id="9999-2" value="9999-2">删</input>
    				<input type="checkbox" name="getQx" id="9999-3" value="9999-3">改</input>
    				<input type="checkbox" name="getQx" id="9999-4" value="9999-4">查</input>
    				<input type="checkbox" name="getQx" id="9999-5" value="9999-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				权限管理
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="10000-1" value="10000-1">增</input>
    				<input type="checkbox" name="getQx" id="10000-2" value="10000-2">删</input>
    				<input type="checkbox" name="getQx" id="10000-3" value="10000-3">改</input>
    				<input type="checkbox" name="getQx" id="10000-4" value="10000-4">查</input>
    				<input type="checkbox" name="getQx" id="10000-5" value="10000-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    		<tr height="30">
    			<td>
    				所有统计
    			</td>
    			<td>&nbsp;
    				
    			</td>
    			<td>
    				<input type="checkbox" name="getQx" id="9990-1" value="9990-1">增</input>
    				<input type="checkbox" name="getQx" id="9990-2" value="9990-2">删</input>
    				<input type="checkbox" name="getQx" id="9990-3" value="9990-3">改</input>
    				<input type="checkbox" name="getQx" id="9990-4" value="9990-4">查</input>
    				<input type="checkbox" name="getQx" id="9990-5" value="9990-5">统</input>
    			</td>
    		</tr>
    		
    		<tr height="1px">
    			<td colspan="3" bgcolor="black">
    			</td>
    		</tr>
    		
    	</table>
    </td>
  </tr>
  
  <tr>
    <td colspan="5" align="center" bgcolor="#FFFFFF">
    	<input type="button" name="Submit" onclick="javascript:check();" value="保 存" />
        <input type="button" onclick="javascript:history.go(-1);" name="Submit2" value="取 消" /></td>
  </tr>
</table>
</form>
</body>
</html>
