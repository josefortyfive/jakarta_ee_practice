<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String[] cities = {"Mumbai" ," Singapore", "Philadelphia", "Manila"};

	pageContext.setAttribute("myCities", cities);

%>

	<c:forEach var="tempCity" items="${myCities}">
		${tempCity } <br/>
 
	</c:forEach>

</body>
</html>