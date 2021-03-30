<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View task</title>
</head>
<body>
<h2>View tasks your tasks</h2>
<form id="ViewTask" action="ViewTask" method="post">
	<label>User assigned: </label>
    <input type="text" name="userName">
    <br/>
    <label>User Password to verify task: </label>
    <input type="text" name="password">
    <br/>
    <button>Submit</button>
</form>
</body>
</html>