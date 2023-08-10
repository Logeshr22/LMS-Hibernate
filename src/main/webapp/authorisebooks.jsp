<%@page import="com.training.hibernateservlet.beans.Book"%>
<%@page import="com.training.hibernateservlet.model.HibernateManager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1 class="header">Authorize Books</h1>
	<%
	HibernateManager hm = new HibernateManager();
	ArrayList<Book> allBooks = HibernateManager.readAllBook();
	%>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Book ID</th>
					<th class="displayTableData">Book Name</th>
					<th class="displayTableData">Author</th>
					<th class="displayTableData">Book Cost</th>
					<th class="displayTableData">Category</th>
					<th class="displayTableData">Book Status</th>
				</tr>
				<%
					for (Book curSub : allBooks) {
					%>
				<tr>
					<td class="displayTableData"><%=curSub.getBid()%></td>
					<td class="displayTableData"><%=curSub.getBname()%></td>
					<td class="displayTableData"><%=curSub.getAuthor()%></td>
					<td class="displayTableData"><%=curSub.getCost()%></td>
					<td class="displayTableData"><%=curSub.getCategory()%></td>
					<td class="displayTableData"><%=curSub.getStatus()%></td>

				</tr>
				<%
					}
					%>
			</table>
			<div id="inputForm">
				<form action="authorizebooks" method="post">
					<table>
						<tr>
							<td><label class="label">Book ID</label></td>
							<td><input class="input" type="text" name="bid"></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" type="submit" value="Authorize Book">
						<a id="LoginButton" href="AdminHomePage.jsp">Back</a>
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>