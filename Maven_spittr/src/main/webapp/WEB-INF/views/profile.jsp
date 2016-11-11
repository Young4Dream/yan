<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    <script type="text/javascript" src="WEB-INF/js/jQuery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(
    	function(){
    		var loc_img='${session.getAttribute("img")}';
    		if(loc_img.equals('') || loc_img == null){
    		$("#form").hide();
    		$("#img").show();
    		}else{
     		$("#form").show();
    		$("#img").hide();   		
    		}});
    </script>
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${session.getAttribute('user').username}" /><br/>
    <c:out value="${session.getAttribute('user').firstName}" /> <c:out value="${session.getAttribute('user').lastName}" /><br/>
    <c:out value="${session.getAttribute('user').email}" />
    <sf:form enctype="multipart/form-data" action="/Maven_spittr/file/upload" id="form" method="POST">
    	<input type="file" accept="image/jpeg,image/jpg,image/png,image/gif" name="file"/><br/>
    	<input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="重置">
    </sf:form>
    <img id="img" src='${session.getAttribute("user").loc_img}'>
  </body>
</html>
