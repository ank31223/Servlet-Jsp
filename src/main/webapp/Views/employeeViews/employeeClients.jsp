<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
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

	<h1>Clients of ${ecr.getListEmployee().get(0).getName()}</h1>

	<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Client Name</th>
				<th>Client Address</th>
				<th>Remove Client</th>
			</tr>
			<c:forEach var="client" items="${ecr.getListClient()}">
				<tr>
					<td>${client.getId()}</td>
					<td>${client.getCompanyName()}</td>
					<td>${client.getCompanyAddress()}</td>
					<td><a href="/servletProject/removeEmployeeClient?employeeId=${ecr.getListEmployee().get(0).getId()}&clientId=${client.getId()}&employeeName=${ecr.getListEmployee().get(0).getName()}">remove Client</a> </td>
				</tr>
			</c:forEach>


		</table>

	</div>
		<h1>Assignable clients to ${ecr.getListEmployee().get(0).getName()}</h1>
		
		<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Client Name</th>
				<th>Client Address</th>
				<th>Action</th>
			</tr>
			<c:forEach var="client" items="${ecr1.getListClient()}">
				<tr>
					<td>${client.getId()}</td>
					<td>${client.getCompanyName()}</td>
					<td>${client.getCompanyAddress()}</td>
					<td><a href="/servletProject/addClientToEmployee?employeeId=${ecr.getListEmployee().get(0).getId()}&clientId=${client.getId()}&employeeName=${ecr.getListEmployee().get(0).getName()}">Add</a> </td>
				</tr>
			</c:forEach>


		</table>

	</div>
		
	

</body>
</html>