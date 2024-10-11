<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>

	<h1>Student's Information </h1>
	<table border="1">
		<tr>
		<th>First Name</th> 
		<th>Last Name</th> 
		<th>Email</th> 
			<c:forEach var="tempStudent" items="${student_list_two}">
				<tr>
					<td>${tempStudent.firstName}</td> 
					<td>${tempStudent.lastName}</td> 
					<td>${tempStudent.email}</td> 
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>