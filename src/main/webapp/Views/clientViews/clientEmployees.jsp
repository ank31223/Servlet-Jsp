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
	<h1>All Employees working Under
		${cer.getClientList().get(0).getCompanyName()}</h1>

	<div>
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
				<th>remove Employee</th>
			</tr>
			<c:forEach var="employee" items="${cer.getEmployeeList()}">
				<tr>
					<td>${employee.getId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getGender()}</td>
					<td>${employee.getAge()}</td>
					<td>${employee.getContactNo()}</td>
					<td>${employee.getEmail()}</td>
					<td>${employee.getDesignation()}</td>
					<td>${employee.getSalary()}</td>
					<td><a
						href="/servletProject/removeClientEmployee?clientId=${cer.getClientList().get(0).getId()}&employeeId=${employee.getId()}&clientName=${cer.getClientList().get(0).getCompanyName()}">
							remove Employee</a></td>
				</tr>
			</c:forEach>


		</table>

	</div>
	<h1>Assignable Employees to
		${cer1.getClientList().get(0).getCompanyName()}</h1>

	<div>
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
				<th>Add</th>
			</tr>
			<c:forEach var="employee" items="${cer1.getEmployeeList()}">
				<tr>
					<td>${employee.getId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getGender()}</td>
					<td>${employee.getAge()}</td>
					<td>${employee.getContactNo()}</td>
					<td>${employee.getEmail()}</td>
					<td>${employee.getDesignation()}</td>
					<td>${employee.getSalary()}</td>
					<td><a
						href="/servletProject/addEmployeeToClient?clientId=${cer1.getClientList().get(0).getId()}&employeeId=${employee.getId()}&clientName=${cer1.getClientList().get(0).getCompanyName()}">
							Add</a></td>
				</tr>
			</c:forEach>




		</table>

	</div>



</body>
</html>