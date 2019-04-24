<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="" method="post" name="loginForm">
	<table>
			<tr>
				<td>Username : </td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password" /></td>
				<td><label style="color:red;">${message}</label></td>
			</tr>
			<tr>
				<td></td>
				<td>	<button type="submit" onclick="loginForm.action='/blog/login';loginForm.submit()">Login</button>
						<button type="submit" onclick="loginForm.action='/blog/register';loginForm.submit()">Register</button></td>
			</tr>
		</table>
	</form>
</body>
</html>