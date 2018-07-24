<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/index.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
     <%@ include file="css/login.css"%>
</style>
<title>Login</title>
</head>
<body>
<br><br><br>
	<div class="modal-dialog">
		<div class="loginmodal-container">
			<h1>Book Lending Application</h1><br>
				<form action="login" method="post">
					<input type="text" id="username" name="username" placeholder="Red Id">
					<input type="password" id="password" name="password" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				</form>		
				<h1 style="color:red" id="error">&nbsp ${errormsg}</h1>
		</div>
	</div>	  
	<input type="hidden" name="susername" value=<%= request.getSession().getAttribute("sessionusername") %>>	
	<input type="hidden" name="refresh" id = "refresh" value="true">
</body>
</html>