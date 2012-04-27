<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
	<h3>create user page</h3>
	<c:if test="${error != null}">
		<p>${error}</p>
	</c:if>	
	<p></p>
	<form action="/grizzly-app/create" method="post">
		<label for="name">Name:</label>
		<input id="name" name="name" type="text"/><br/>
		<input type="submit" value="create"/>
	</form>
</body>
</html>