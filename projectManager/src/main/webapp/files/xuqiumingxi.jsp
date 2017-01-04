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
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.jsp","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >需求明细信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>

		
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目需求明细</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">执行人:</td>
					    <td width="35%"><span class="red">
					      <select name="select2" >
                            <option  selected="selected">==请选择==</option>
                            <option>住宅</option>
                            <option>仓库</option>
                          </select>
					    </span></td>
					    <td align="right" width="15%">开始时间</td>
					    <td width="35%"><input type="text" name="textfield" /></td>
					    </tr>
					  
					  
					  <tr>
					    <td width="15%" align="right">计划完成时间:</td>
					    <td width="35%"><input type="text" name="textfield2" /></td>
					    <td width="15%" align="right">实际完成时间:</td>
					    <td width="35%"><input type="text" name="textfield3" /></td>
					    </tr>
					  <tr>
					    <td align="right">编辑状态:</td>
					    <td><span class="red">
					      <select name="select" >
                            <option  selected="selected">==请选择==</option>
                            <option>住宅</option>
                            <option>仓库</option>
                          </select>
					    </span></td>
					    <td align="right">&nbsp;</td>
					    <td>&nbsp;</td>
					    </tr>
					  <tr>
					    <td align="right">需求内容:</td>
					    <td colspan="3"><textarea name="textarea" cols="100" rows="20"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  

		
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
