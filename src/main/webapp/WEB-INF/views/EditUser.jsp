<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Edit User</h2>
	<form action="updateuser" method="post">
	FirstName : <input type="Text" name="firstName" value="${user.firstName}"/><br><br>
	LastName :  <input type="Text" name="lastName" value="${user.lastName}"/><br><br>
	<input type="hidden" value="${user.userId}" name="userId"/>
	<input type="submit" value="Update User"/> 
	</form>
</body>
</html>