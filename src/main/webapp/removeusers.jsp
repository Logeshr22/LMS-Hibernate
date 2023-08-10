<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.training.hibernateservlet.beans.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Remove Users</title>
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
	<h1 class="header">Remove Users</h1>
	<%
	ArrayList<User> allusers = User.getAllUsers();
	%>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">User ID</th>
					<th class="displayTableData">User Name</th>
					<th class="displayTableData">Password</th>
					<th class="displayTableData">Address</th>
					<th class="displayTableData">Phone</th>
					<th class="displayTableData">Email</th>
					<th class="displayTableData">Status</th>
				</tr>
				
					<%
					for (User curuser : allusers) {
					%>
					<tr>
					<td class="displayTableData"><%=curuser.getUid()%></td>
					<td class="displayTableData"><%=curuser.getUname()%></td>
					<td class="displayTableData"><%=curuser.getPwd()%></td>
					<td class="displayTableData"><%=curuser.getAddress()%></td>
					<td class="displayTableData"><%=curuser.getPhone()%></td>
					<td class="displayTableData"><%=curuser.getEmail()%></td>
					<td class="displayTableData"><%=curuser.getStatus()%></td>
					</tr>
					<%
					}
					%>
				
			</table>
			<div id="inputForm">
				<form action="RemoveUser" method="post">
					<table>
						<tr>
							<td><label class="label">User ID</label></td>
							<td><input class="input" type="text" name="uid"></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" type="submit" value="Remove User">
						<a id="LoginButton" href="AdminHomePage.jsp">Back</a>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>