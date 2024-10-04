<html>

<body>
	<h3>Training Portal</h3>
	
<!--  read the favorite programming cookie -->

<%

	String favLang ="Java";
	
	Cookie[] theCookies = request.getCookies();
	
	if(theCookies != null){
		for(Cookie tempCookie : theCookies){
			if("myApp.favoriteLanguage".equals(tempCookie.getName())){
				favLang = tempCookie.getValue();
				break;
			}
		}
	}

%>

<!-- now show a personalised page.. use the favLang variable -->

<!--  show new books for this lang -->

<h4>New Books for <%= favLang %></h4>
<ul>

	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>

<h4>Latest News Reports for for <%= favLang %></h4>

<ul>

	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>


<h4>Hot Jobs for <%= favLang %></h4>

<ul>

	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>

<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>