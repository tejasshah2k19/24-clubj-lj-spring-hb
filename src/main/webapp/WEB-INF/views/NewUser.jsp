<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>New User</h2>
	<form action="saveuser" method="post">
	FirstName : <input type="Text" name="firstName"/><br><br>
	LastName :  <input type="Text" name="lastName"/><br><br>
	Email : <input type="Text" name="email"/><br><br>
	Password :  <input type="Text" name="password"/><br><br>
	
	<input type="submit" value="Add User"/> 
	</form>
</body>
</html>