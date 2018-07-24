<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/request.js"></script>
<link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css>"/>" >
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/bootstrap.min.css"%>
     <%@ include file="css/bootstrap-reboot.min.css"%>
     <%@ include file="css/bootstrap-grid.min.css"%>
</style>
<title>Home</title>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-sm bg-dark navbar-dark">
    <ul class="nav navbar-nav">
    	<li class="active">
    		<a href="myAccount" class="nav-link">| ${sessionScope.sfirstname} |</a>
    	</li>
      <li class="active">
      	<a class="nav-link" href="home">Home</a>
      </li>
      <li class="navbar-nav">
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
<h3>Books Catalog</h3>

<form action="home" method="post">
<button type="submit" class="btn btn-primary mb-2">Clear All Filters</button>
</form>

<br><br>
<form class="form-inline" method="gets" action="searchBooks">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="name" placeholder="Book Name" value="${name}">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="author" placeholder="Author" value="${author}">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="owner" placeholder="Owners First Name" value="${firstName}">
  </div>
  <div class="form-group mx-sm-3 mb-2">
 		From:&nbsp<input type="date" class="form-control" name="availableFrom" value="${availableFrom}">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    To:&nbsp<input type="date" class="form-control" name="availableTo" value="${availableTo}">
  </div>
  <button type="submit" class="btn btn-primary mb-2">Search</button>
</form>

<div id = "msg" style="color:green">${msg} &nbsp</div>
<div id = "error" style="color:red">${error} &nbsp</div>
<table class="table table-bordered">
	<c:if test = "${books.size() eq 0}">
		<p style="color:red">No Books to Display.</p>
	</c:if>
	<c:if test = "${books.size() gt 0}">
	<tr>
		<th>ISBN</th>
		<th>Book Name</th>
		<th>Author</th>
		<th>Publisher</th>
		<th>Edition</th>
		<th>Description</th>
		<th>Owner</th>
		<th>Available From</th>
		<th>Available to</th>
		<th>Status</th>
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
            <td>${book.getBookOwner()}</td>
            <td>${book.getBookAvailableFrom()}</td>
            <td>${book.getBookAvailableTo()}</td>
            <c:choose>
  				<c:when test="${empty book.getBookAvailableFrom()}">
    				<td style="color:red">Not Available</td>
  				</c:when>
  				<c:when test="${book.getBookHold() eq 1}">
  					<td style="color:blue">On Hold</td>
  				</c:when>
  				<c:when test="${book.getBookOwner() eq sessionScope.sfirstname}">
  					<td style="color:green">Available</td>
  				</c:when>
  				<c:otherwise>
    				<td id="onhold${book.getBookId()}"><a href="" class="requestBook" bookId="${book.getBookId()}">Request to Lend</a></td>		
  				</c:otherwise>
			</c:choose>
        </tr>
    </c:forEach>
</table>
</div>
<input type="hidden" name="susername" value=<%= request.getSession().getAttribute("sessionusername") %>>
<input type="hidden" name="refresh" id = "refresh" value="true">

</body>
</html>