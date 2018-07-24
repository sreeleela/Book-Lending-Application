<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/withdraw.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/bootstrap.min.css"%>
     <%@ include file="css/bootstrap-reboot.min.css"%>
     <%@ include file="css/bootstrap-grid.min.css"%>
</style>
<style>
.tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: black;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;

    /* Position the tooltip */
    position: absolute;
    z-index: 1;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
}
</style>
<title>Requests For Approval</title>
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
      <li class="active">
      	<a class="nav-link" href="myRequestsApprovalStatus">My Borrowings</a>
      </li>
      <li class="navbar-nav">
      	<a class="nav-link" href="logout">Logout</a>
      </li>
    </ul>
</nav>
<br><br><br>
<div class="container-fluid">
<h3>My Borrowings</h3>
<div id="msg" style="color:green"> ${msg} &nbsp</div>
<div id="error" style="color:green">${error} &nbsp</div>
	
<table class="table table-bordered">
	<c:if test = "${books.size() eq 0}">
		<p style="color:red">No borrowings to display.</a></p>
	</c:if>
	<c:if test = "${books.size() gt 0}">
	<p>Note: Lender's information (email) will be available once he approves your request 
. And, it is available 
till the return is complete. 
This is to protect privacy.</p>
		<tr>
			<th>ISBN</th>
			<th>Book Name</th>
			<th>Request Date</th>
			<th>Request Status</th>
			<th>Return Status</th>
			<th>Book Owner and Contact Info</th>
		</tr>
	</c:if>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.getBookISBN()}</td>
            <td>${book.getBookName()}</td>
            <td>${book.getRequestDate()}</td>
            <c:choose>
            	<c:when test="${book.getReject_accept() eq -1 and book.getWithdraw() eq 1}">
    				<td style="color:green">Requested</td>
    				<td style="color:red">Withdrawn</a></td>
    				<td>${book.getBookOwner()}
            		<br>&nbsp
            		</td>
  				</c:when>
            	<c:when test="${book.getReject_accept() eq -1 and book.getWithdraw() eq -1}">
    				<td id="pending${book.getRequestId()}" style="color:green">Pending</td>
    				<td id="withdraw${book.getRequestId()}"><a href='' class="withdraw" requestId="${book.getRequestId()}" bookId="${book.getBookId()}">Withdraw</a></td>
  					<td>${book.getBookOwner()}
            		<br>&nbsp
            		</td>
  				</c:when>
  				<c:when test="${book.getReject_accept() eq 0}">
    				<td style="color:red">Rejected</td>
    				<td>&nbsp</td>
    				<td>${book.getBookOwner()}
            		<br>&nbsp
            		</td>
  				</c:when>
  				<c:when test="${book.getReject_accept() eq 1}">
  					<td style="color:green">Approved</td>
  					<c:choose>
  						<c:when test="${book.getReturned() eq -1}">
    						<td style="color:red">Not Yet Returned</td>
    						<td>${book.getBookOwner()}
            				<br>${book.getBookDescription()}
            				</td>
  						</c:when>
  						<c:when test="${book.getReturned() eq 1}">
  							<td style="color:green">Returned</td>
  							<td>${book.getBookOwner()}
            				<br>&nbsp
            				</td>
  						</c:when>
					</c:choose>
  				</c:when>
			</c:choose>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>