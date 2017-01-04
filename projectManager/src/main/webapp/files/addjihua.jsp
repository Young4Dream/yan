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
      <th class="tablestyle_title" >项目计划添加页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr>
			<td align="left">
				<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　			
				<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>			</td>
		</tr>
		<tr align="center">
			<td class="TablePanel"><select name="select5">
              <option>XXX项目</option>
              <option>XXX项目</option>
              <option>XXX项目</option>
              <option>XXX项目</option>
              <option>XXX项目</option>
            </select></td>
		</tr>
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>添加计划</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">计划标题:</td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">前置任务计划:</td>
					    <td width="34%"><input class="text" name='datevalue217' style="width:154px" value=""/></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">计划开始时间:</td>
					    <td><input class="text" name='datevalue21' style="width:154px" value=""/></td>
					    <td align="right">计划结束时间:</td>
					    <td><input class="text" name='datevalue22' style="width:154px" value="" /></td>
					  </tr>
					  <tr>
					    <td align="right">任务执行人:</td>
					    <td>
							<select name="select3" >
							  <option  selected="selected">==请选择==</option>
							  <option>程序员</option>
							  <option>项目经理</option>
							  <option>经理</option>
							</select>
						</td>
					    <td align="right">优先级:</td>
					    <td>
							<select name="select3" >
							  <option  selected="selected">==请选择==</option>
							  <option>程序员</option>
							  <option>项目经理</option>
							  <option>经理</option>
							</select>
						</td>
					  </tr>
					  <tr>
					    <td align="right">任务类型:</td>
						<td>
							<select name="select" >
								<option  selected="selected">==请选择==</option>
								<option>实习</option>
								<option>试用</option>
								<option>正式员工</option>
							</select>
						</td>
					    <td align="right">状态:</td>
					    <td>
								<select name="select2" >
								  <option  selected="selected">==请选择==</option>
								  <option>程序员</option>
								  <option>项目经理</option>
								  <option>经理</option>
								</select>
						</td>
					  </tr>
					  <tr>
                        <td align="right">项目模块:</td>
					    <td><select name="select4" >
                          <option  selected="selected">==请选择==</option>
                          <option>实习</option>
                          <option>试用</option>
                          <option>正式员工</option>
                        </select></td>
					    <td align="right">项目功能:</td>
					    <td><select name="select6" >
                          <option  selected="selected">==请选择==</option>
                          <option>实习</option>
                          <option>试用</option>
                          <option>正式员工</option>
                        </select></td>
					    </tr>
					  <tr>
					    <td align="right">计划备注:</td>
					    <td colspan="3"><textarea name="textarea" cols="100" rows="8"></textarea></td>
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
