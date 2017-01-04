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
      <th class="tablestyle_title" >员工工资发放</th>
    </tr>
    <tr>
      <td class="CPanel"><table border="0" cellpadding="0" cellspacing="0" style="width:100%">
          <tr>
            <td align="left"><label style="font-size:16px">&nbsp;&nbsp;张三工资</label></td>
          </tr>
          <tr>
            <td width="100%"><fieldset style="height:100%;">
              <legend>工资信息</legend>
              <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                <tr>
                  <td nowrap align="right" width="15%">奖金:</td>
                  <td width="35%"><input name='txt3' type="password" class="text" style="width:154px" value="" /></td>
                  <td align="right" width="16%">其他奖金:</td>
                  <td width="34%"><input name='txt32' type="password" class="text" style="width:154px" value="" />
                      <span class="red">*</span></td>
                </tr>
                <tr>
                  <td width="15%" nowrap align="right">处罚扣除金额:</td>
                  <td width="35%"><input class="text" name='datevalue2' style="width:154px" value=""  /></td>
                  <td align="right">发放类型:</td>
                  <td><select name="select" >
                      <option  selected="selected">==请选择==</option>
                      <option>现金</option>
                      <option>打卡</option>
                  </select></td>
                </tr>
                <tr>
                  <td align="right">年份:</td>
                  <td><select name="year">
                      <option>2007</option>
                      <option selected="selected">2008</option>
                  </select></td>
                  <td align="right">月份:</td>
                  <td><select name="month">
                      <option >1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                      <option>6</option>
                      <option>7</option>
                      <option>8</option>
                      <option>9</option>
                      <option>10</option>
                      <option>11</option>
                      <option>12</option>
                  </select></td>
                </tr>
                <tr>
                 <td align="right">描述:</td>
					 <td colspan="3">&nbsp;</td>
                </tr>
              </table>
              <br />
            </fieldset></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td colspan="2" align="center" height="50px"><input type="button" name="Submit2" value="保存" class="button" onclick="alert('保存成功！');"/>
        　
        <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
        <textarea name="textarea" cols="100" rows="8"></textarea></td>
    </tr>
  </table>
  </td>
  </tr>
  </table>
</div>
</form>
</body>
</html>
