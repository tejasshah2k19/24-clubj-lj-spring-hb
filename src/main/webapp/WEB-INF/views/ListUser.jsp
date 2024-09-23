<%@page import="com.entity.UserEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2>List User</h2>
	<!-- JSTL -->

	<%-- 	<%
	List<UserEntity> users = (List<UserEntity>) request.getAttribute("users");
	%>

	<%
	for (UserEntity u : users) {
		out.print(u.getFirstName() + "<Br>");
	}
	%> --%>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${users}" var="u">

			<tr><td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td> <a href="deleteuser?userId=${u.userId}">Delete</a>  |
				 <a href="viewuser?userId=${u.userId}">view</a> |
				 
				 <a href="edituser?userId=${u.userId}">Edit</a>  				 
			</tr>

		</c:forEach>

	</table>

</body>
</html>