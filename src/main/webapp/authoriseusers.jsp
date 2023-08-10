<%@page import="com.training.hibernateservlet.beans.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.training.hibernateservlet.model.HibernateManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Authorize User</title>
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
	<h1 class="header">Authorize Users</h1>
	<%
	HibernateManager hm = new HibernateManager();
	ArrayList<User> allUser = HibernateManager.readAllUser();
	%>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">User ID</th>
					<th class="displayTableData">User Name</th>
					<th class="displayTableData">Address</th>
					<th class="displayTableData">Phone</th>
					<th class="displayTableData">Email</th>
					<th class="displayTableData">Status</th>
				</tr>
				<tr>
					<%
					for (User curSub : allUser) {
					%>
					<td class="displayTableData"><%=curSub.getUid()%></td>
					<td class="displayTableData"><%=curSub.getUname()%></td>
					<td class="displayTableData"><%=curSub.getAddress()%></td>
					<td class="displayTableData"><%=curSub.getPhone()%></td>
					<td class="displayTableData"><%=curSub.getEmail()%></td>
					<td class="displayTableData"><%=curSub.getStatus()%></td>
					<%
					}
					%>
				</tr>
			</table>
			<div id="inputForm">
				<form action="authorizeuser" method="post">
					<table>
						<tr>
							<td><label class="label">User ID</label></td>
							<td><input class="input" type="text" name="uid"></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" type="submit" value="Authorize User">
						<a id="LoginButton" href="AdminHomePage.jsp">Back</a>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>