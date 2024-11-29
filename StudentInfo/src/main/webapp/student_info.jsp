<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h1>Hello!</h1>
	
	<div align="center">
		<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name </th>
			<th>Email</th>
		</tr>
		<tr>
			<c:forEach var="student" items="${listStudent}" varStatus="status">
				
				<tr>
					<td>${student.firstName} </td>
					<td>${student.lastName} </td>
					<td>${student.email} </td>
				</tr>
			</c:forEach>
		</tr>
		</table>
	</div>
</body>
</html>