<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Student Tracker App</title>
</head>
<%
	List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>	
				</tr>
				
				<%for (Student student : theStudents){%>
						<tr>
							<td> <%=student.getFirstName() %> </td>
							<td> <%=student.getLastName() %> </td>
							<td> <%=student.getEmail() %> </td>
						</tr>
				<%} %>
				
				
			</table>
		</div>
	</div>

</body>
</html>