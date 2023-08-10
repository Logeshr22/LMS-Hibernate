<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>User HomePage</title>
</head>
<body>
	<div class="navContainer">
		<img src="Logo.png" id="logo">
		<div class="topnav">
			<a class="navLink" href="Welcome.html">Home</a> <a class="active"
				class="navLink" href="AdminLogin.html">Admin</a> <a class="navLink"
				href="UserLogin.html">User</a> <a class="navLink"
				href="Register.html">Register</a>
		</div>
	</div>
	<h1 class="header">User Home</h1>
	<div class="formContainer">
		<div class="list">
			<table>
				<tr>
					<td><a class="LinkButton" href="Purchase.jsp">Purchase</a></td>
				</tr>
				<tr>
					<td><a class="LinkButton" href="Subscription.html">Subscription</a></td>
				</tr>
				<tr>
					<td><a class="LinkButton" href="logout"> Logout</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>