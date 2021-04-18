
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>

<head>

<style>
#ems {
	background-color: black;
	height: 40px;
	text-align: center;
	font-size: 20px;
	margin-top: 30px;
	padding-top: 1%;
	margin-left: 33%;
	margin-right: 33%;
	border-radius: 70px;
	text-decoration: none;
}

#cms {
	background-color: black;
	height: 40px;
	text-align: center;
	font-size: 20px;
	margin-top: 30px;
	padding-top: 1%;
	margin-left: 33%;
	margin-right: 33%;
	border-radius: 70px;
}

#container {
	margin-top: 15%;
	height: 100%;
}

body {
	background-color: #daedde;
}

a {
	display: block;
	height: 100%;
	width: 100%;
	text-decoration: none;
	color: white;
}


</style>

</head>
<body>

	<c:set var="i" value="ANKIT" scope="application"></c:set>

	<div id="container">
		
		<div id="ems">
			<a href="/servletProject/getAllClients">Client Management System</a>
		</div>
		<div id="cms">
			<a href="/servletProject/getAllEmployees">Employee Management
				System</a>
		</div>
	</div>

</body>
</html>
