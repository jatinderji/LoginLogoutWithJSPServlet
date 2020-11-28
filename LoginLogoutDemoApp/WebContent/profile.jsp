<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

<%
if(session==null || session.getAttribute("un")==null ) {
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.include(request, response);
	out.append("<b>You need to Login First</b>");
}
else{
	%>
		<%@include file="my_menu.html" %>
	<h1>User Profile</h1>

	<hr/>

	<h2>Below is your profile</h2>
	<%
}
%>


	

</body>
</html>