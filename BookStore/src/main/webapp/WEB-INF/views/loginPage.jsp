<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<a href="/"><h1>Katie's Book Store</h1></a>

<h1>Login Page</h1>

<form method="post" action="/validate">

	<table>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" required /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" required /></td>
		</tr>
		
	</table>

	<input type="submit" value="Login" />
	
</form>
<form action="/registrationPage">
	<input type="submit" value="Register" />
</form>

</body>
</html>