<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/addBook.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/bootstrap.min.css"%>
     <%@ include file="css/bootstrap-reboot.min.css"%>
     <%@ include file="css/bootstrap-grid.min.css"%>
</style>
<title>Add Book</title>
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
      <li class="navbar-nav">
      	<a class="nav-link" href="myBooks">My Books</a>
      </li>
      <li class="active">
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
<h3>Add Book to Lend</h3>

<form id="bookAddition">
<div class="form-group row">
    <label for="bookISBN" class="col-sm-2 col-form-label">Book ISBN</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="isbn" name="isbn" placeholder="Enter ISBN" style="width: 400px;">
    </div>
</div>
<div class="form-group row">
    <label for="bookName" class="col-sm-2 col-form-label">Book Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Enter Book Name" style="width: 400px;">
    </div>
</div>
<div class="form-group row">
    <label for="bookAuthor" class="col-sm-2 col-form-label">Author</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="author" name="author" placeholder="Enter Book Author" style="width: 400px;">
    </div>
</div>
<div class="form-group row">
    <label for="bookEdition" class="col-sm-2 col-form-label">Edition</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="edition" name="edition" placeholder="Enter Book Edition" style="width: 400px;">
    </div>
</div>
<div class="form-group row">
    <label for="bookPublisher" class="col-sm-2 col-form-label">Publisher</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="publisher" name="publisher" placeholder="Enter Book Publisher" style="width: 400px;">
    </div>
</div>
<div class="form-group row">
    <label for="bookDescription" class="col-sm-2 col-form-label">Description</label>
    <div class="col-sm-10">
      <textarea class="form-control" rows="3" id="description" name="description" placeholder="Enter description about book" style="width: 400px;"></textarea>
    </div>
</div>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="date" value="${now}" pattern="yyyy-MM-dd" />

<div class="form-group row">
    <label for="bookAvailableFrom" class="col-sm-2 col-form-label">Available From</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="availableFrom" name="availableFrom" style="width: 400px;" min="${date}">
    </div>
</div>
<div class="form-group row">
    <label for="bookAvailableTo" class="col-sm-2 col-form-label">Available To</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="availableTo" name="availableTo" style="width: 400px;" min="${date}">
    </div>
</div>
<button type="submit" class="btn btn-primary">Add Book</button>
<br>
<div id = "error" style="color:red"></div>
<div id = "msg" style="color:green"></div>
</form>
</div>
</body>
</html>