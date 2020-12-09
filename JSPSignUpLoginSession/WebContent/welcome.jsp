<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<%
		if(session==null || session.getAttribute("email")==null){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			out.append("<b>You need to Login First</b>");
		}
		else
		{
			%>
			
	<%@include file="my_menu.html" %>
	<h1>User Welcome Page</h1>
	<hr>
		<h2>This is a welcome page</h2>
			<%}	%>
</body>
</html>