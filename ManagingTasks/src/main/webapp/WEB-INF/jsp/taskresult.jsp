<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h2 align="left">Task Procedure Successful</h2>
<p>Please make a new selection of what operation you wish to do</p>
<form action ="choice" method="post">
<select name="action">
	<option value="add">add task</option>
	<option value="delete">delete task</option>
	<option value="update">update task</option>
	<option value="view">view tasks</option>
</select>
<input type="submit" value="Submit" />
</form>
<a href="/">Logout</a><br>
</body>
</html>