<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>

<h1>Katie's Book Store</h1>

<form action="/loginPage">
<input type="submit" value="Login"/>
</form>

<h2>Welcome ${loggedInCustomer.firstName }</h2> 

<form action="/registrationPage">
	<input type="submit" value="Register"/>
</form>

<form action="/getAllBooks">
	<input type="submit" value="View All Books" />
</form>

<form action="/viewCart">
<input type="hidden" name="customerId" value="${loggedInCustomer.id}"/>
	<input type="submit" value="View Shopping Cart" />
</form>

<form action="/userDetails">
	<input type="submit" value="My Details"/>
</form>
</body>
</html>
