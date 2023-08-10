<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.training.hibernateservlet.beans.Book"%>
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
			<a class="navLink" href="Welcome.html">Home</a> <a class="navLink"
				href="AdminLogin.html">Admin</a> <a class="navLink" class="active"
				href="UserLogin.html">User</a> <a class="navLink"
				href="Register.html">Register</a>
		</div>
	</div>
	<h1 class="header">Purchase Books</h1>

	<%
    ArrayList<Book> allBook = Book.getAllBook();
    %>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Book ID</th>
					<th class="displayTableData">Book Name</th>
					<th class="displayTableData">Author</th>
					<th class="displayTableData">Cost</th>
					<th class="displayTableData">Category</th>
					<th class="displayTableData">Status</th>
				</tr>
				<%
					for (Book curBook : allBook) {
					%>
				<tr>


					<td class="displayTableData"><%=curBook.getBid()%></td>
					<td class="displayTableData"><%=curBook.getBname()%></td>
					<td class="displayTableData"><%=curBook.getAuthor()%></td>
					<td class="displayTableData"><%=curBook.getCost()%></td>
					<td class="displayTableData"><%=curBook.getCategory()%></td>
					<td class="displayTableData"><%=curBook.getStatus()%></td>

				</tr>
				<%
					}
					%>
			</table>
			<div id="inputForm">
				<form action="AddPurchase" method="post">
					<table>
						<tr>
							<td><label class="label">Book ID</label></td>
							<td><input class="input" type="text" name="bid"></td>
						</tr>
						<tr>
							<td><label class="label">Book Name</label></td>
							<td><input class="input" type="text" name="bname"></td>
						</tr>
						<tr>
							<td><label class="label">Amount</label></td>
							<td><input class="input" type="text" name="amount"></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" type="submit" value="Purchase Book">
						<a id="LoginButton" href="UserHomePage.jsp">Back</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>