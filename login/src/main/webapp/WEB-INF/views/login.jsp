<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form method="post" modelAttribute="user">

	
	Username:&nbsp&nbsp&nbsp&nbsp  <form:input path="username" id="username" /> </br></br></br>
	
	Password:&nbsp&nbsp&nbsp&nbsp  <form:input path="password" id="password" /> </br>
	
	<input type="submit" value="login"/>
	
	<c:choose>
                        <c:when test="${failure}">
                            <label> invalid username and password</label>
                        </c:when>
                        <c:otherwise>
                            
                        </c:otherwise>
                    </c:choose>
	
</form:form>

</br>
</br>
enter username: xxx, password: yyy for successfulm login
</body>
</html>