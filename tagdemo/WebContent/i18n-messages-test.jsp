<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>

<c:set var="theLocale" 
value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
scope="session"/>

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.practice.code.jsp.tagdemo.i18n.resources.mylabels" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="i18n-messages-test.jsp?theLocale=en_US" >English (US)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES" >Spanish (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE" >German (DE)</a>

<hr>

<fmt:message key="label.greeting" /> <br/><br/>

<fmt:message key="label.firstname" /> <i>John</i> <br/>

<fmt:message key="label.lastname" /> <i>Doe</i> <br/>

<fmt:message key="label.welcome" /> <i></i> <br/>

<hr>

Selected Locale: ${theLocale}

</body>
</html>