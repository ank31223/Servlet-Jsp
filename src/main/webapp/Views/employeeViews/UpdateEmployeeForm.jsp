<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
  <form action="/servletProject/updateEmployee" method="post">
  
    <input type="hidden"  name="uname" value="${name}" placeholder="Enter Name of Employee">
     
    <label for="Name">Name of Employee</label>
    <input type="text" name="Name"  placeholder="Enter Name of Employee">

    <label for="Gender">Gender</label>
    <input type="text" name="Gender"  placeholder="Enter Gender">

    <label for="Age">Age</label>
    <input type="text" id="fname" name="Age"  placeholder="Enter Name of Employee">
    
    <label for="Contact No">Contact No</label>
    <input type="text" name="ContactNo" placeholder="Enter Name of Employee">
    
    <label for="Email">Email</label>
    <input type="text" name="Email"  placeholder="Enter Name of Employee">
    
    <label for="Designation">Designation</label>
    <input type="text" name="Designation"   placeholder="Enter Name of Employee">
    
    <label for="Salary">Salary</label>
    <input type="text" name="Salary"  placeholder="Enter Name of Employee">
    
  
    <input type="submit" value="Submit">
  </form>
</div>


</body>
</html>