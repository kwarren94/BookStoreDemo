<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="/bookRegister" method="post">
Book Title: <input type="text" name="bookName" />
Book Author: <input type="text" name="bookAuthor" />
IBSN: <input type="text" name="bookIsbn" />
Price: <input type="text" name="bookPrice" />
Contents: <input type="text" name="bookContents" />
Overview: <input type="text" name="bookOverview" />

<input type="submit" value="Register" />
</form>
</body>
</html>