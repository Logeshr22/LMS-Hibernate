
<%@page import="com.training.hibernateservlet.model.HibernateManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.training.hibernateservlet.beans.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<h1 class="header">Subscriptions</h1>
	<div class="formContainer">
		<div class="list">

			<table class="displayTable">
				<tr>
					<th class="displayTableData">Subscription ID</th>
					<th class="displayTableData">Amount</th>

				</tr>
				<%
				ArrayList<Subscription> allSubscriptions = HibernateManager.readAll();
				%>
				<%
				for (Subscription curSub : allSubscriptions) {
				%>
				<tr>
					<td class="displayTableData"><%=curSub.getSub_id()%></td>
					<td class="displayTableData"><%=curSub.getAmount()%></td>
				</tr>
				<%
				}
				%>
			</table>

			<div class="buttonHolder">
				<a id="LoginButton" href="AdminHomePage.jsp">Back</a>
			</div>
		</div>
	</div>


</body>
</html>