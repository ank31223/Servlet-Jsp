<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="i" value="23" scope="application"></c:set>

	<div id="container">
		<h1>
			<c:out value="${i}"></c:out>
		</h1>
		<div id="ems">Client Management System</div>
		<div id="cms">Employee Management System</div>

	</div>


</body>
</html>