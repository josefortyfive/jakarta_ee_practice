<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 


<html>
<body>

<c:set var="data" value="Singapore,Tokyo,Mumbai,London"/>

<h3>Split Demo</h3>

<c:set var="citiesArray" value="${fn:split(data,',')}"/> 

<c:forEach var="tempCity" items="${citiesArray}" >

	${tempCity} <br/>
</c:forEach>

<h3>Join Demo</h3>

<c:set var="fun" value="${fn:join(citiesArray, '*' )}"/>

result of joining: ${fun}

</body>
</html>