<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete task</title>
</head>
<body>
<h2>Delete task</h2>
<p>Give the name of the user and their task you wish to Delete</p>
<form id="DeleteTask" action="DeleteTask" method="post">
	<label>User assigned: </label>
    <input type="text" name="userName">
    <br/>
    <label>User Password to verify task: </label>
    <input type="text" name="password">
    <br/>
    <label>Task Name: </label>
    <input type="text" name="name">
    <br/>
    <button>Submit</button>
</form>
</body>
</html>