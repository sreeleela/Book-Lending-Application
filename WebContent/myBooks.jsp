<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/myBooks.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/bootstrap.min.css"%>
     <%@ include file="css/bootstrap-reboot.min.css"%>
     <%@ include file="css/bootstrap-grid.min.css"%>
</style>
<title>My Books</title>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-sm bg-dark navbar-dark">
    <ul class="nav navbar-nav">
    	<li class="active">
    		<a href="" class="nav-link">| ${sessionScope.sfirstname} |</a>
    	</li>
      <li class="navbar-nav">
      	<a class="nav-link" href="home">Home</a>
      </li>
      <li class="active">
      	<a class="nav-link" href="myBooks">My Books</a>
      </li>
      <li class="navbar-nav">
      	<a class="nav-link" href="addBook.jsp">Add Book</a>
      </li>
      <li class="navbar-nav">
      	<a class="nav-link" href="requestsForApproval">My Lendings</a>
      </li>
      <li class="navbar-nav">
      	<a class="nav-link" href="myRequestsApprovalStatus">My Borrowings</a>
      </li>
      <li class="navbar-nav">
      	<a class="nav-link" href="logout">Logout</a>
      </li>
    </ul>
</nav>
<br><br><br>
<div class="container-fluid">
<h3>My Books</h3>
<div id="msg" style="color:green"> ${msg} &nbsp</div>
<div id="error" style="color:red">${error} &nbsp</div>
<table class="table table-bordered">
	<c:if test = "${books.size() eq 0}">
		<p style="color:red">No books to display. <a href="addBook.jsp">Add book to get started.</a></p>
	</c:if>
	<c:if test = "${books.size() gt 0}">
		<tr>
			<th>ISBN</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Edition</th>
			<th>Description</th>
			<th>Available From</th>
			<th>Available to</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</c:if>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.getBookISBN()}</td>
            <td>${book.getBookName()}</td>
            <td>${book.getBookAuthor()}</td>
            <td>${book.getBookPublisher()}</td>
            <td>${book.getBookEdition()}</td>
            <td>${book.getBookDescription()}</td>
            <td>${book.getBookAvailableFrom()}</td>
            <td>${book.getBookAvailableTo()}</td>
            <c:choose>
  				<c:when test="${book.getBookAvailable() eq 0}">
    				<td style="color:red">Book Lent</td>
    				<td style="color:red">Book Lent</td>
  				</c:when>
  				<c:when test="${book.getBookAvailable() eq 1}">
    				<td><a href="editBook?bookId=${book.getBookId()}">Edit</a></td>
    				<td><a href="deleteBook?bookId=${book.getBookId()}">Delete</a></td>
  				</c:when>
  			</c:choose>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>