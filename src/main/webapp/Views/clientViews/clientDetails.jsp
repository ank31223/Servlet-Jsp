<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.header {
	padding: 40px;
	text-align: center;
	background: #1abc9c;
	color: white;
	font-size: 20px;
}

a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 25px;
}

a:hover, a:active {
	background-color: red;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: green;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
}
</style>
</head>
<body>

	<div class="header">
		<h1>Welcome to Client Management System</h1>
		<a href="/servletProject/Views/clientViews/newClientForm.jsp">Add
			Client</a>
	</div>


	<div>

		<table>
			<tr>
				<th>Id</th>
				<th>Client Name</th>
				<th>Client Address</th>
				<th>Edit Client</th>
				<th>Delete Client</th>
				<th>Show Employees</th>
				


			</tr>
			<c:forEach var="client" items="${clientList}">
				<tr>
					<td>${client.getId()}</td>
					<td>${client.getCompanyName()}</td>
					<td>${client.getCompanyAddress()}</td>
					
					<td><a href="/servletProject/editClient?clientName=${client.getCompanyName()}">Edit</a></td>
					<td><a
						href="/servletProject/deleteClient?clientName=${client.getCompanyName()}">Delete</a></td>
					<td><a
						href="/servletProject/viewEmployeesUnderClient?clientName=${client.getCompanyName()}">ShowEmployees</a></td>



				</tr>
			</c:forEach>


		</table>


	</div>





</body>
</html>