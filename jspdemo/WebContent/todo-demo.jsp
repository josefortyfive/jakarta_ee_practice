<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Demo Example</title>
</head>
<body>

<!-- Step 1: Create HTML Form -->
<form action="todo-demo.jsp">
	Add new item <input type="text" name="theItem"/>
	
	<input type="submit" value="Submit"/>

</form>

<!-- Step 2: Add new item "To Do" List -->

<%
	// get the TO DO items from session

	List<String> items = (List<String>) session.getAttribute("myToDoList");

	// if the TO DO items doesn't exist, then create a new one
	if(items == null){
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}

	String theItem = request.getParameter("theItem");
	
	boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
	boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
	
	
	if(isItemNotEmpty && isItemNotDuplicate){
		items.add(theItem.trim());
	}
%>


<!-- Step 3: Display all "To do" item from session -->


<hr>
<b>To Do List Items: </b> <br/>


<ol>
	<%
	
		for(String temp : items) {
			out.println("<li>" + temp+ "</li>");
		}
	%>

</ol>
</body>
</html>