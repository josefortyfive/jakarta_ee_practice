<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page import="java.util.*,com.practice.code.jsp.tagdemo.Student" %> 

<% 

	List<Student> data = new ArrayList<>();
	data.add(new Student("John", "Doe", false));
	data.add(new Student("Anne", "Marie", true));
	data.add(new Student("Danica", "Jones", false));
	
	pageContext.setAttribute("myStudent", data);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gold Customer</th>
		<c:forEach var="tempStudent" items="${myStudent}">
			<tr>
				<td>${tempStudent.firstName}</td> 
				<td>${tempStudent.lastName}</td> 
				<td>${tempStudent.goldCustomer}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>