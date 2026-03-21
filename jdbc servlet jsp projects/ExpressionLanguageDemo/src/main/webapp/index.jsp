<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("request_name","ash");
	
	    session.setAttribute("session_name","cat");
	%>
	
	${requestScope.request_name}
	
	${session_name}
	
	<form action = "output.jsp">
		<input type = "text" name = "name1" placeholder = "Enter Name"/>
		<input type = "submit" value = "click me"/>
	</form>
	
</body>
</html>