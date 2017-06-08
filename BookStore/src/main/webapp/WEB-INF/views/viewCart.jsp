<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<a href="/"><h1>Katie's Book Store</h1></a>

<h1>My Shopping Cart</h1>

<!-- <form action="/viewAllBooks" method="post">
	Search by Book Name: <input type="text" name="bookNameSearch"/>
	<input type="submit" value="Search"/>
</form> -->

 <h2>Welcome ${loggedInCustomer.firstName }</h2>
 
 <form action="/getAllBooks" >
 	<input type="submit" value="Book Store List"/>
 </form>
 
 <br/>
 <br/>

<table>
	
	<tr>
		
		<th>Book Name</th>
		<th>Author</th>
		<th>ISBN</th>
		<th>Price</th>
		<th>Contents</th>
		<th>Overview</th>
		<th>Quantity</th>
		<th>SubTotal</th>
		
	</tr>	

	<c:set var="total" value="${0}"/>
	<c:set var="subtotal" value="${0}"/>
	<c:forEach items="${viewCart}" var="orders">
		<tr>
			
			<input type="hidden" name="id" value="${orders.id}"/>
			<input type="hidden" name="bookName" value="${orders.bookName}"/><td>${orders.bookName}</td>
			<input type="hidden" name="bookAuthor" value="${orders.bookAuthor}"/><td>${orders.bookAuthor}</td>
			<input type="hidden" name="bookIsbn" value="${orders.bookIsbn}"/><td>${orders.bookIsbn}</td>
			<input type="hidden" name="bookPrice" value="${orders.bookPrice}"/><td>${orders.bookPrice}</td>
			<input type="hidden" name="bookContents" value="${orders.bookContents}"/><td>${orders.bookContents}</td>
			<input type="hidden" name="bookOverview" value="${orders.bookOverview}"/><td>${orders.bookOverview}</td>
			<input type="hidden" name="bookQuantity" value="${orders.bookQuantity}"/><td>${orders.bookQuantity}</td>
			<td>${orders.bookPrice * orders.bookQuantity}</td>
			<c:set var="subtotal" value="${orders.bookPrice * orders.bookQuantity}"/>
			
			
			<form action="/addBookQuantity" method="post">
			<td>
				
				<input type="hidden" name="bookQuantity" value="${orders.bookQuantity}"/>
				<input type="hidden" name="id" value="${orders.id}"/>
				<input type="hidden" name="customerId" value="${orders.customerId}"/>
				<input type="submit" name="addBook" value="+"/>
			</td>
			</form>
			
			<form action="/removeBookQuantity" method="post">
			<td>
				
				<input type="hidden" name="bookQuantity" value="${orders.bookQuantity}"/>
				<input type="hidden" name="id" value="${orders.id}"/>
				<input type="hidden" name="customerId" value="${orders.customerId}"/>
				<input type="submit" name="removeBook" value="-"/>
			</td>
			</form>
			
				
			<c:set var="total" value="${total + subtotal }"/>
		
			
		</tr>
		
	</c:forEach>
	<br/>
	 
</table>
<strong>TOTAL: </strong>£${total }
</body>
</html>