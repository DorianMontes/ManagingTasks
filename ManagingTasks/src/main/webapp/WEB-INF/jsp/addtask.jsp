<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.Date" %>

<html>
<body>
<h2>Adding task</h2>
<p>Please give details of new task assignment</p>
<form id="AddTask" action="AddTask" method="post">
	<label>User assigned: </label>
    <input type="text" name="userName">
    <br/>
    <label>User Password to verify task: </label>
    <input type="text" name="password">
    <br/>
    
    <label>Task Name: </label>
    <input type="text" name="name">
    <br/>
    <label>Task Description: </label>
    <input type="text" name="description">
    <br/>
    <label>email: </label>
    <input type="text" name="email">
    <br/>
    <label>Severity: </label>
    <select name="severity">
		<option value="High">High</option>
		<option value="Medium">Medium</option>
		<option value="Low">Low</option>
	</select>
	<br/>
	<label>Start Date: </label>
    <input type="date" name="sdate">
    <br/>
    <label>End Date: </label>
    <input type="date" name="edate">
    <br/>
    <button>Submit</button>
</form>
</body>
</html>