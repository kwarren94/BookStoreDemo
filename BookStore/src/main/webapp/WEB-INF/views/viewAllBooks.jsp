<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Books</title>
</head>
<body>
<a href="/"><h1>Katie's Book Store</h1></a>
<h2>Welcome ${loggedInCustomer.firstName }</h2>
<form action="/viewCart">
	<input type="hidden" name="customerId" value="${loggedInCustomer.id}"/>
	<input type="submit" value="View Shopping Cart" />
</form>

<form action="/viewAllBooks" method="post">
	Search by Book Name: <input type="text" name="bookNameSearch"/>
	<input type="submit" value="Search"/>
</form>

<table>
	
	<tr>
		<th>Book Name</th>
		<th>Author</th>
		<th>ISBN</th>
		<th>Price</th>
		<th>Contents</th>
		<th>Overview</th>
		
	</tr>	

	<c:forEach items="${viewAllBooks}" var="books">
		<tr>
			<form action="/addBookToCart" method="post">
			<input type="hidden" name="bookName" value="${books.bookName}"/><td>${books.bookName}</td>
			<input type="hidden" name="bookAuthor" value="${books.bookAuthor}"/><td>${books.bookAuthor}</td>
			<input type="hidden" name="bookIsbn" value="${books.bookIsbn}"/><td>${books.bookIsbn}</td>
			<input type="hidden" name="bookPrice" value="${books.bookPrice}"/><td>${books.bookPrice}</td>
			<input type="hidden" name="bookContents" value="${books.bookContents}"/><td>${books.bookContents}</td>
			<input type="hidden" name="bookOverview" value="${books.bookOverview}"/><td>${books.bookOverview}</td>
			<input type="hidden" name="customerId" value="${loggedInCustomer.id}"/>
			
					
			<td>
				<input type="text"  name="bookQuantity" value="Enter Quantity" />
				<input type="submit" value="Add to Shopping Cart" />
			</td>
			</form>
			
		</tr>
	</c:forEach>
</table>



</body>
</html>