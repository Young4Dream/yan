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


function link(){
alert('保存成功！');
    document.getElementById("fom").action="xuqiumingxi.jsp";
   document.getElementById("fom").submit();
}



</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="fom" id="fom" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目模块修改页面</th>
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
				<legend>项目模块信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">模块名字:</td>
					    <td width="46%"><input name="text" class="text" style="width:300px" type="text" size="40" />
				        <span class="red"> *</span></td>
					    <td nowrap="nowrap" align="right">模块标识:</td>
					    <td><input name="" id="" class="text" style="width:154px" /></td>
					  </tr>
					  <tr>
					    <td align="right">所属项目:</td>
					    <td><select id="xxx" name="xxx">
                            <option id="xxx">AAAAAAA</option>
                            <option id="xxx">BBBBBBB</option>
                            <option id="xxx">CCCCCCC</option>
                            <option id="xxx">DDDDDDD</option>
                          </select>                        </td>
					    <td nowrap="nowrap" align="right">所属需求:</td>
					    <td><select id="xxx" name="xxx">
                            <option id="xxx">AAAAAAA</option>
                            <option id="xxx">BBBBBBB</option>
                            <option id="xxx">CCCCCCC</option>
                            <option id="xxx">DDDDDDD</option>
                          </select>                        </td>
					  </tr>
					   <tr>
					     <td align="right">优先级:</td>
					     <td><select id="xxx" name="xxx">
                             <option id="xxx">AAAAAAA</option>
                             <option id="xxx">BBBBBBB</option>
                             <option id="xxx">CCCCCCC</option>
                             <option id="xxx">DDDDDDD</option>
                           </select>                         </td>
					    <td align="right">&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr>
					  <tr align="top">
					    <td nowrap align="right" height="120px">模块描述:</td>
					    <td colspan="3">
							<textarea id="" name="" rows="10" cols="80"></textarea>						</td>
					    </tr>
						<tr align="top">
					    <td nowrap align="right" height="120px">需求描述:</td>
					    <td colspan="3">
							<textarea id="" name="" rows="10" cols="80"></textarea>						</td>
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
			<input type="button" name="Submit" value="保存" class="button" onclick="link();"/>　
			
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
