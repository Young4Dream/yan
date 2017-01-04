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
.STYLE1 {color: #000066}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
	<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  		<tr><th class="tablestyle_title" >项目信息明细列表</th>
  		</tr>
  		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>项目基本信息</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  			<tr>
					    			<td nowrap align="right" width="15%">项目名称:</td>
					    			<td width="35%">种子公司OA办公软件</td>			        	
					    			<td nowrap align="right" width="15%">所属单位:</td>
					    			<td width="35%">广西南宁种子软件有限公司</td>
					    		</tr>
								<tr>
					    			<td nowrap align="right" width="15%">项目金额:</td>
					    			<td width="35%">500万</td>
				         			<td nowrap align="right" width="15%">开发人数:</td>
					    			<td width="35%">3</td>	
								</tr>
								<tr>	
									<td nowrap align="right" width="15%">项目经理:</td>
									<td width="35%">刘宝善</td>
									<td nowrap align="right" width="15%">完成状态:</td>
									<td width="35%">未完成</td>
				        		</tr>
								<tr>	
									<td nowrap align="right" width="15%">预算总成本:</td>
									<td width="35%">50</td>
									<td nowrap align="right" width="15%">实际总成本:</td>
									<td width="35%">50</td>
				        		</tr>
					
								<tr> 	
									<td nowrap align="right" width="15%">立项时间:</td>
								  <td width="35%">2008年9月</td>
									<td nowrap align="right" width="15%">更新时间:</td>
									<td width="35%">2008年9月</td>
								</tr>
					 		</table>
			  				<br />
							</fieldset>			
						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		<!--  
			第二块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		
		
		
		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>项目操作</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  		  <!--DWLayoutTable-->
							  <tr align="center">
								<td width="135" height="20" valign="top" nowrap></td>
					    			<td width="446" valign="top" nowrap></td>
					    			<td width="308" valign="top" nowrap></td>
							  </tr>
					  			<tr align="center">
								<td height="20" valign="top" nowrap>
								  <div align="right"><a href="xiangmujihua.jsp" onclick="">创建项目计划</a></div></td>
					    			<td valign="top"><div align="right"><a href="xiangmuxuqiu.jsp">创建项目需求</a></div></td>
					    			<td valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
					  			</tr>
								<tr align="center">
					    			<td height="20" valign="top" nowrap><div align="right"><a href="xiangmumokuai.jsp" onclick="">创建项目模块</a></div></td>
					    			<td valign="top"><div align="right"><a href="xiangmugongnen.jsp">创建项目功能</a></div></td>
					    			<td valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
								</tr>
								<tr align="center">
					    			<td height="20" valign="top" nowrap>
										<div align="right">
										<a href="xiangmuwenjian.jsp">上传项目文件</a></div></td>
					    			<td valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
					    			<td valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
								</tr>
								<tr align="center">
								  <td height="20">&nbsp;</td>
								  <td>&nbsp;</td>
								  <td>&nbsp;</td>
							  </tr>
					 		</table>
			  				<br />
							</fieldset>			
						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		
		
		<!--  
			第三块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		<!--  
			第三块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		
		
		
		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>项目需求</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                              <tr>
                                <td width="80%"></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="26"><table width="100%" border="0" cellpadding="2" cellspacing="1" class="CContent" >
                                    <tr class="CTitle" height="20" align="center">
                                      <td colspan="3" align="center">需求明细列表</td>
                                    </tr>
                                    <tr align="center" class="TablePanel">
                                      <td width="35%" nowrap>版本号</td>
                                      <td width="35%">产生时间</td>
                                      <td width="10%">操作</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>1.1x</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td width="80%"><table width="100%" border="0" align="center" cellpadding="0" 
		  								cellspacing="0" class="right-font08">
                                    <tr>
                                      <td width="50%"> 共<span class="right-text09">5</span>页| 
                                        第<span class="right-text09">1</span>页 </td>
                                      <td width="49%" align="right"> [<a href="#" class="right-font08">首页</a>| <a href="#" class="right-font08">上一页</a>| <a href="#" class="right-font08">下一页</a>| <a href="#" class="right-font08">末页</a>]转至 </td>
                                      <td width="1%"><table width="96" border="0" cellspacing="0" cellpadding="0" >
                                          <tr>
                                            <td width="1%"><input name="textfield34" type="text" class="right-textfield03" size="1" />                                            </td>
                                            <td width="87%"><input name="Submit232224" type="submit" class="right-button06" value=" " />                                            </td>
                                          </tr>
                                      </table></td>
                                    </tr>
                                </table></td>
                                <td></td>
                              </tr>
                            </table>
					  		<br />
						</fieldset>						
						
						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		
		
		<!--  
			第四块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		<!--  
			第四块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		
		
		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>项目模块</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">				
								 <tr>
								 	<td width="80%"></td>
								 </tr>
								 <tr>
								 	<td>&nbsp;</td>	
								 </tr>
								<tr>
					  			  <td height="26">	
								  		<table width="100%" border="0" cellpadding="2"
										 cellspacing="1" class="CContent" >
											<tr class="CTitle" height="20">
								 				<td colspan="5" align="center">模块明细列表</td>
											</tr>	
											<tr align="center" class="TablePanel" >
												<td width="20%" >模块名称</td>
												<td width="25%" >模块标识</td>
					    						<td width="25%">创建时间</td>	
												<td width="10%" >优先级</td>		        	
					    						<td width="10%">操作</td>
										  </tr>
											<tr align="center">
												<td>登陆模块</td>
												<td>login</td>
					    						<td>2008年9月</td>	
												<td>一般</td>		        	
					    						<td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
											</tr>
											<tr align="center">
												<td>登陆模块</td>
												<td>login</td>
					    						<td>2008年9月</td>	
												<td>一般</td>		        	
					    						<td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
											</tr>
											<tr align="center">
												<td>登陆模块</td>
												<td>login</td>
					    						<td>2008年9月</td>	
												<td>一般</td>		        	
					    						<td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
											</tr>
											<tr align="center">
												<td>登陆模块</td>
												<td>login</td>
					    						<td>2008年9月</td>	
												<td>一般</td>		        	
					    						<td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
											</tr>
											<tr align="center">
												<td>登陆模块</td>
												<td>login</td>
					    						<td>2008年9月</td>	
												<td>一般</td>		        	
					    						<td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
											</tr>
							  		</table>								  
								</td>									
					  			</tr>
								<tr>
								 	<TD width="80%">
										<table width="100%" border="0" align="center" cellpadding="0" 
		  								cellspacing="0" class="right-font08">
											  <tr>
												<td width="50%">
													共<span class="right-text09">5</span>页| 
													第<span class="right-text09">1</span>页		
												</td>
												<td width="49%" align="right">
													[<a href="#" class="right-font08">首页</a>|
													<a href="#" class="right-font08">上一页</a>| 
													<a href="#" class="right-font08">下一页</a>|
													<a href="#" class="right-font08">末页</a>]转至
												</td>
												<td width="1%">
													<table width="96" border="0" cellspacing="0" cellpadding="0" >
													<tr>
													  <td width="1%">
														<input name="textfield3" type="text" class="right-textfield03" size="1" />
													  </td>
													  <td width="87%">
														<input name="Submit23222" type="submit" class="right-button06" value=" " />
													  </td>
													</tr>
												</table>
												</td>
											  </tr>
									  </table>
									</TD>
									<td></td>
							  </tr>
					 		</table>
			  				<br />
						</fieldset>						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		
		
		<!--  
			第五块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		<!--  
			第五块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		
		
		
		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>项目功能</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                              <tr>
                                <td width="80%"></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="26">
								<table width="100%" border="0" cellpadding="2"
										 cellspacing="1" class="CContent" >
                                    <tr class="CTitle">
                                      <td colspan="4"  align="center">功能明细列表</td>
                                    </tr>
                                    <tr align="center" class="TablePanel">
                                      <td width="25%" height="20" nowrap>功能名称</td>
                                      <td width="25%">创建时间</td>
                                      <td width="25%">优先级</td>
                                      <td width="10%">操作</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>上传文件</td>
                                      <td>2008年9月</td>
                                      <td>中级</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td width="80%">
								<table width="100%" border="0" align="center" cellpadding="0" 
		  								cellspacing="0" class="right-font08">
                                    <tr>
                                      <td width="50%"> 共<span class="right-text09">5</span>页| 
                                        第<span class="right-text09">1</span>页 </td>
                                      <td width="49%" align="right"> [<a href="#" class="right-font08">首页</a>| <a href="#" class="right-font08">上一页</a>| <a href="#" class="right-font08">下一页</a>| <a href="#" class="right-font08">末页</a>]转至 </td>
                                      <td width="1%"><table width="96" border="0" cellspacing="0" cellpadding="0" >
                                          <tr>
                                            <td width="1%"><input name="textfield32" type="text" class="right-textfield03" size="1" />                                            </td>
                                            <td width="87%"><input name="Submit232222" type="submit" class="right-button06" value=" " />                                            </td>
                                          </tr>
                                      </table></td>
                                    </tr>
                                </table></td>
                                <td></td>
                              </tr>
                            </table>
					  		<br />
						</fieldset>						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		
		
		<!--  
			第五块模板 结束
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		<!--  
			第六块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
		
		
		
		
		<tr>
    		<td class="CPanel">
				<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
					<TR>
						<TD width="100%"><fieldset style="height:100%;">
							<legend>文件信息</legend>
					  		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                              <tr>
                                <td width="80%"></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="26"><table width="100%" border="0" cellpadding="2"
										 cellspacing="1" class="CContent" >
                                    <tr class="CTitle">
                                      <td colspan="4"  align="center">文件明细列表</td>
                                    </tr>
                                    <tr align="center" class="TablePanel">
                                      <td width="25%" height="20" nowrap>文件名称</td>
                                      <td width="25%">上传人</td>
                                      <td width="25%">上传时间</td>
                                      <td width="10%">操作</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>index.jsp</td>
                                      <td>雷勇</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                    <tr align="center">
                                      <td nowrap>index.jsp</td>
                                      <td>雷勇</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>index.jsp</td>
                                      <td>雷勇</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>index.jsp</td>
                                      <td>雷勇</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
									<tr align="center">
                                      <td nowrap>index.jsp</td>
                                      <td>雷勇</td>
                                      <td>2008年9月</td>
                                      <td>|<a href="#">编辑</a>|<a href="#">查看</a>|</td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td width="80%"><table width="100%" border="0" align="center" cellpadding="0" 
		  								cellspacing="0" class="right-font08">
                                    <tr>
                                      <td width="50%"> 共<span class="right-text09">5</span>页| 
                                        第<span class="right-text09">1</span>页 </td>
                                      <td width="49%" align="right"> [<a href="#" class="right-font08">首页</a>| <a href="#" class="right-font08">上一页</a>| <a href="#" class="right-font08">下一页</a>| <a href="#" class="right-font08">末页</a>]转至 </td>
                                      <td width="1%"><table width="96" border="0" cellspacing="0" cellpadding="0" >
                                          <tr>
                                            <td width="1%"><input name="textfield33" type="text" class="right-textfield03" size="1" />                                            </td>
                                            <td width="87%"><input name="Submit232223" type="submit" class="right-button06" value=" " />                                            </td>
                                          </tr>
                                      </table></td>
                                    </tr>
                                </table></td>
                                <td></td>
                              </tr>
                            </table>
					  		<br />
						</fieldset>						</TD>
					</TR>	
				</TABLE>
		  </td>
  		</tr>
		
		
		
		<!--  
			第六块模板 开始
		    **********************************************************************************
			***********************************************************************************
		-->
		
  	</TABLE>
	</td>
  </tr>
  </table>
</div>
</form>
</body>
</html>
