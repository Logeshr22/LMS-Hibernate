<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>

<body>
	<div class="navContainer">
		<img src="Logo.png" id="logo"> 
		<div class="topnav">
			<a class="navLink" href="Welcome.html">HOME</a> <a class="active"
				class="navLink" href="AdminLogin.html">ADMIN</a> <a class="navLink"
				href="UserLogin.html">USER</a> <a class="navLink"
				href="Register.html">REGISTER</a>
		</div>
	</div>
	<h1 class="header">Admin Home</h1>
	<div class="formContainer">
		<form id="form" class="inputForm">
			<div class="list">
				<table>
					<tr>
						<td class="td"><a class="LinkButton" href="viewPurchase.jsp">Purchase
								History</a></td>
						<td class="td"><a class="LinkButton"
							href="viewAllSubscription.jsp">View Subscriptions</a></td>
						<td class="td"><a class="LinkButton"
							href="authorisebooks.jsp">Authorize New Book</a></td>
					</tr>
					<tr>
						<td class="td"><a class="LinkButton"
							href="authoriseusers.jsp">Authorize New Users</a></td>
						<td class="td"><a class="LinkButton" href="removeusers.jsp">Remove
								Users</a></td>
						<td class="td"><a class="LinkButton" href="AddBook.html">Add
								Books</a></td>
					</tr>
					<tr class="singleElement">
						<td class="td"><a class="LinkButton" href="RemoveBooks.jsp">Remove
								Books</a></td>
					</tr>
				</table>
				<div class="buttonHolder">
					<a id="LoginButton" href="logout">Logout</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>
