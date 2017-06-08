<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<a href="/"><h1>Katie's Book Store</h1></a>
<h1>Register Here</h1>


<form action="/register" method="post">
First Name: <input type="text" name="firstName" />
Last name: <input type="text" name="lastName" />
Email: <input type="text" name="email" />
Password: <input type="password" name="password" />

<input type="submit" value="Register" />
</form>


</body>
</html>