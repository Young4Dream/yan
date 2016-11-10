<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
 %> 
<jsp:useBean id="spitte"  class="com.spring.mvc.pojo.Spitter" scope="request" ></jsp:useBean>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Register</h1>

    <sf:form method="POST" modelAttribute="spitte" enctype="multipart/form-data">
      First Name: <sf:input type="text" path="firstName" /><sf:errors path="firstName" cssClass="errors"/><br/>
      Last Name: <sf:input type="text" path="lastName" /><sf:errors path="lastName" cssClass="errors"/><br/>
      Email: <sf:input type="email" path="email" /><sf:errors path="email" cssClass="errors"/><br/>
      Username: <sf:input type="text" path="username" /><sf:errors path="username" cssClass="errors"/><br/>
      Password: <sf:input type="password" path="password" /><sf:errors path="password" cssClass="errors"/><br/>
      <input type="file" path="loc_img" accept="image/jpeg,image/jpg,image/png,image/gif"/><br/>
      <input type="submit" value="Register" />
    </sf:form>
  </body>
</html>
