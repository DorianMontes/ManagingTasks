<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Tasks</h2>

<table style="float:left">
   <tr><th>ID</th><th>Name</th><th>Email</th><th>TaskName</th><th>Description</th><th>Severity</th><th>Start Date</th><th>End Date</th></tr>
   <c:forEach items="${users}" var="task" varStatus="count">
    <tr id="${count.index}">
    	<td>${task.id}</td>
        <td>${task.userName}</td>
        <td>${task.email}</td>
        <td>${task.taskName}</td>
        <td>${task.description}</td>
        <td>${task.severity}</td>
        <td>${task.start_date}</td>
        <td>${task.end_date}</td>
    </tr>
  </c:forEach>
</table>


</body>
</html>