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
      <th class="tablestyle_title" >项目修改页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<tr align="center">
          <td class="TablePanel">XXX项目</td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">项目名称:</td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目金额:</td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />				        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<select id="select1" name="select1">
									<option>项目经理一</option>
									<option>项目经理二</option>
									<option>项目经理三</option>
									<option>项目经理四</option>
								</select>							</td>
							<td nowrap align="right" width="18%">完成状态:</td>
							<td width="35%">
							<select id="select1" name="select1">
								<option>完成状态一</option>
								<option>完成状态二</option>
								<option>完成状态三</option>
								<option>完成状态四</option>
							</select>							</td>
				        </tr>
						<tr>
						  <td nowrap="nowrap" align="right">实际总成本:</td>
						  <td><input name='txt3' type="text" class="text" style="width:154px" value="" />                          </td>	
							<td nowrap="nowrap" align="right">实际开发日期:</td>
							<td><input name='txt3' type="text" class="text" style="width:154px" value="" />                            </td>
						</tr>
						<tr>
						  <td nowrap="nowrap" align="right">实际完成日期:</td>
						  <td><input name='txt3' type="text" class="text" style="width:154px" value="" /></td>
						  <td  align="right" >优先级:</td>
						  <td ><select name="select7" >
                              <option  selected="selected">==请选择==</option>
                              <option>暂不</option>
                              <option>一般</option>
                              <option>需要</option>
                              <option>急</option>
                              <option>很急</option>
                          </select></td>
						</tr>
					  <tr>
					    <td  width="15%" nowrap align="right">备注:</td>
					    <td colspan="3"><textarea name="textarea2" cols="100" rows="10"></textarea></td>
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
