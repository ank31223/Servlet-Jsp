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
		<h1>Welcome to Employee Management System</h1>
		<a href="default.asp" target="_blank">Add Employee</a>
	</div>


	<div >

		<table>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Contact No</th>
				<th>Email</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>Show Clients</th>
				<th>Add Clients</th>
				<th>Delete Clients</th>

			</tr>
			<c:forEach var="emp" items="${employeeList}">
				<tr>
					<td>${emp.getId()}</td>
					<td>${emp.getName()}</td>
					<td>${emp.getGender()}</td>
					<td>${emp.getAge()}</td>
					<td>${emp.getContactNo()}</td>
					<td>${emp.getEmail()}</td>
					<td>${emp.getDesignation()}</td>
					<td>${emp.getSalary()}</td>
					<td><a href="#">Edit</a></td>
					<td><a href="#">Delete</a></td>
					<td><a href="#">ShowClients</a></td>
					<td><a href="#">AddClient</a></td>
					<td><a href="#">DeleteClient</a></td>


				</tr>
			</c:forEach>


		</table>


	</div>






</body>
</html>