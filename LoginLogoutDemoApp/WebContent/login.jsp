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
	<%@include file="my_menu.html"%>
	<h1>User Login</h1>

	<hr />

	<div class="container">
		<form action="Login" method="post">
			<table>
				<tr>
					<td><label for="username">Username</label></td>
					<td><input type="text" name="username"></td>
				</tr>

				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" name="userpassword"></td>
				</tr>

				<tr>
					<td></td>
					<td><input class="btn btn-outline-primary" type="submit"
						value="Login"> <input class="btn btn-outline-success"
						type="reset" value="Clear"></td>
				</tr>

			</table>
		</form>
	</div>



</body>
</html>