<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
	<h3>index page</h3>
	
	<p><a href="/grizzly-app/create">cerate new user</a></p>
	
	<form action="/grizzly-app/login" method="post">
		<label for="name">Name:</label>
		<input id="name" name="name" type="text"/><br/>
		<input type="submit" value="get player"/>
	</form>
</body>
</html>