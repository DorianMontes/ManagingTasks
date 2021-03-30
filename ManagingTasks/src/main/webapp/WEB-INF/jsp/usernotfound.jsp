<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Not Found</title>
</head>
<body>
<h2 align="left">User and/or Task Name assigned not available. No change was made</h2>
<p>Please make a new selection of what operation you wish to do</p>
<form action ="choice" method="post">
<select name="action">
	<option value="add">add task</option>
	<option value="delete">delete task</option>
	<option value="update">update task</option>
</select>
<input type="submit" value="Submit" />
</form>
<a href="/">Logout</a><br>
</body>
</html>