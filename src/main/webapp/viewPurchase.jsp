<%@page import="java.util.ArrayList"%>
<%@page import="com.training.hibernateservlet.beans.PurchaseHistory"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>View Purchase</title>
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
	<h1 class="header">Purchase History</h1>
	<%
	ArrayList<PurchaseHistory> allpurchases = PurchaseHistory.getAllPurchaseHistroy();
	%>

	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Purchase ID</th>
					<th class="displayTableData">Book ID</th>
					<th class="displayTableData">Book Name</th>
					<th class="displayTableData">User ID</th>
					<th class="displayTableData">Amount</th>
					<th class="displayTableData">Invoice No.</th>
				</tr>
				<%
					for (PurchaseHistory curpurchase : allpurchases) {
					%>
				<tr>

					<td class="displayTableData"><%=curpurchase.getPid()%></td>
					<td class="displayTableData"><%=curpurchase.getBid()%></td>
					<td class="displayTableData"><%=curpurchase.getBname()%></td>
					<td class="displayTableData"><%=curpurchase.getUid()%></td>
					<td class="displayTableData"><%=curpurchase.getAmount()%></td>
					<td class="displayTableData"><%=curpurchase.getInvoice_no()%></td>

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