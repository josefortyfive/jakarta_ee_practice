<html>
<head><title>Confirmation</title></head>

<%
	String favLang = request.getParameter("favoriteLanguage");
	
	Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);

	theCookie.setMaxAge(60*60*24*365);
	
	response.addCookie(theCookie);

%>

<body>
	Thanks! We set your favorite language to: ${param.favoriteLanguage}
	
	<br/><br/>
	
	<a href="cookies-homepage.jsp">Return to homePage</a>
</body>

</html>