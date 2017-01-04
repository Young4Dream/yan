<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>项目管理系统 by www.mianfeimoban.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css "
	type="text/css" media="all" />
<script type="text/javascript" src="../js/typem.js"></script>
<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.jsp",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}

	function addtype() {
		var gztype = document.getElementById("gztype").value;
		var jinge = document.getElementById("jinge").value;
		document.getElementById("typelist");
	}
</script>
<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
</head>
<body class="ContentBody">
	<form action="" method="post" enctype="multipart/form-data" name="form"
		target="sypost">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">员工工资信息录入</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<tr>
								<td align="left"><input type="button" name="Submit"
									value="保存" class="button" onclick="alert('保存成功！');" /> <input
									type="button" name="Submit2" value="返回" class="button"
									onclick="window.history.go(-1);" />
								</td>
							</tr>

							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>工资信息</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">

											<tr>
												<td nowrap align="right" width="7%">员工姓名:</td>
												<td width="19%"><span class="red"> <select
														name="select8">
															<option selected="selected">==请选择==</option>
															<option>住宅</option>
															<option>仓库</option>
													</select> *</span></td>
												<td align="right" width="26%">&nbsp;</td>
												<td width="9%" align="right">* 年份</td>
												<td width="39%"><span class="red"> <input
														name='txt3422222' type="text" class="text"
														style="width:60px" value="" /> * 月份:<input
														name='txt3422222' type="text" class="text"
														style="width:60px" value="" /> </span></td>
											</tr>
											<tr>
												<td nowrap align="right" width="7%">状态:</td>
												<td width="19%"><span class="red"> <select
														name="select2">
															<option selected="selected">==请选择==</option>
															<option>住宅</option>
															<option>仓库</option>
													</select> * </span></td>
												<td align="right" width="26%">&nbsp;</td>
												<td width="9%" align="right">发款人:</td>
												<td><span class="red"> <input name='txt342222'
														type="text" class="text" style="width:154px" value="" />
														* </span></td>
											</tr>
											<tr>
												<td align="right" nowrap bgcolor="#CCCCCC">工资类型:</td>
												<td bgcolor="#CCCCCC"><span class="red"> <select
														name="select" id="gztype">
															<option selected="selected">==请选择==</option>
															<option value="加班">加班</option>
															<option value="请假">请假</option>
													</select> *</span></td>
												<td bgcolor="#CCCCCC"><input type="button" value="添加"
													onclick="T('tm');" /></td>
												<td align="right" bgcolor="#CCCCCC">&nbsp;</td>
												<td bgcolor="#CCCCCC">&nbsp;</td>
											</tr>
											<tr>
												<td nowrap align="right"></td>
												<td colspan="4">
													<table id="t3" name="t3">
														<tr>
															<td width="290">类型</td>
															<td width="293">金额</td>
															<td width="20">X</td>
														</tr>
														<tr>
															<td>养老</td>
															<td>100</td>
															<td>X</td>
														</tr>
														<tr>
															<td>保险</td>
															<td>300</td>
															<td>X</td>
														</tr>
														<tr>
															<td>受伤</td>
															<td>500</td>
															<td>X</td>
														</tr>
													</table>
												</td>
											</tr>

											<tr>
												<td width="7%" nowrap align="right">备注:</td>
												<td colspan="4"><textarea name="textarea2" cols="120"
														rows="20"></textarea></td>
											</tr>
										</table>
										<br />
									</fieldset>
								</TD>

							</TR>



						</TABLE>
					</td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="button" name="Submit" value="保存" class="button"
						onclick="alert('保存成功！');" /> <input type="button" name="Submit2"
						value="返回" class="button" onclick="window.history.go(-1);" /></TD>
				</TR>
			</TABLE>
			</td>
			</tr>
			</table>

		</div>
		<div id="tm"
			style="display:none; LEFT: 0px; BORDER-LEFT: #a6b4cf 1px solid; WIDTH: 600px; POSITION: absolute; TOP: 0px;">
			<table id="t4" name="t4" width="100%">
				<tr>
					<td>类型</td>
					<td>金额</td>
				</tr>
				<tr>
					<td>默认</td>
					<td>500</td>
				</tr>
			</table>

		</div>
	</form>
</body>
</html>
