<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/password.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/bootstrap.min.css"%>
     <%@ include file="css/bootstrap-reboot.min.css"%>
     <%@ include file="css/bootstrap-grid.min.css"%>
</style>
<title>My Account</title>
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
<h3>My Account</h3>

<div class="form-group row">
    <label for="rid" class="col-sm-2 col-form-label">Red ID</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="rid" name="rid" style="width: 400px;" value="${user.getUsername() }">
    </div>
</div>
<div class="form-group row">
    <label for="nameText" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="name" name="name" style="width: 400px;" value="${user.getFirst_name() } ${user.getLast_name() }">
    </div>
</div>
<div class="form-group row">
    <label for="emailText" class="col-sm-2 col-form-label">Email Id</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="email" name="email" style="width: 400px;" value="${user.getEmail() }">
    </div>
</div>
<div class="form-group row">
    <label for="majorText" class="col-sm-2 col-form-label">Major</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="mojor" name="major" style="width: 400px;" value="${user.getMajor() }">
    </div>
</div>
<div class="form-group row">
    <label for="clgText" class="col-sm-2 col-form-label">College</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="clg" name="clg" style="width: 400px;" value="${user.getCollege() }">
    </div>
</div>
<div class="form-group row">
    <label for="deptText" class="col-sm-2 col-form-label">Department</label>
    <div class="col-sm-10">
      <input readonly type="text" class="form-control" id="dept" name="dept" style="width: 400px;" value="${user.getDept() }">
    </div>
</div>
<button id="vPassword" class="btn btn-primary">Edit Password</button>
<br>
<form id="myAccount" action="editPassword" method="post">
<div id = "error" style="color:red">${error}&nbsp</div>
<div id = "msg" style="color:green">${msg}&nbsp</div>

<input type='hidden' value='${user.getPassword()}' id='password' name='password'>
<input type='hidden' value='${user.getUsername()}' id='username' name='username'>
<input type="password" id="old" name="old" style="width: 400px;visibility: hidden;" placeholder="Old Password">
<input type="password" id="new" name="new" style="width: 400px;visibility: hidden;" placeholder="New Password">
<input type="password" id="newCheck" name="newCheck" style="width: 400px;visibility: hidden;" placeholder="Retype new password">
<button id="psave" type="submit" class="btn btn-primary" style="visibility: hidden;">Save</button>
<br>
</form>
</div>
</body>
</html>