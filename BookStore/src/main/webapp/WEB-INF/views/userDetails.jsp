<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
<table>
<c:forEach items="${userDetails}" var="loggedInCustomer">
	
	
	<tr>
	<form action="/updateFirstName" method="post">
		<td>First Name: </td>
		<input type="hidden" name="id" value="${loggedInCustomer.id}"/>
		<td><input type="text" name="firstName" value="${loggedInCustomer.firstName}"/></td>
		<td><input type="submit" value="Update"/></td>
	</form>
	</tr>	
	
	
	<tr>
	<form action="/updateLastName" method="post">
		<td>Last Name: </td>
		<input type="hidden" name="id" value="${loggedInCustomer.id}"/>
		<td><input type="text" name="lastName" value="${loggedInCustomer.lastName}"/></td>
		<td><input type="submit" value="Update"/></td>
	</form>
	</tr>
	
	<tr>
	<form action="/updateEmail" method="post">
		<td>Email: </td>
		<input type="hidden" name="id" value="${loggedInCustomer.id}"/>
		<td><input type="text" name="email" value="${loggedInCustomer.email}"/></td>
		<td><input type="submit" value="Update"/></td>
	</form>
	</tr>
	
	<tr>
	<form action="/updatePassword" method="post">
		<td>Password: </td>
		<input type="hidden" name="id" value="${loggedInCustomer.id}"/>
		<td><input type="text" name="password" value="${loggedInCustomer.password}"/></td>
		<td><input type="submit" value="Update"/></td>
		
	</form>
	</tr>


		<tr>
		<input type="hidden" name="id" value="${loggedInCustomer.id}"/>
			
			
			
			
					
			
			
		</tr>
	</c:forEach>
</table>
</body>
</html>