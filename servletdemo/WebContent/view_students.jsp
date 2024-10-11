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

	<table border="1">
		<tr>
		<th>Student's Name</th> 
			<c:forEach var="tempStudent" items="${student_list }">
				<tr>
					<td>${tempStudent}</td> 
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>