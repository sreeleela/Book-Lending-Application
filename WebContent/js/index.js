window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('[name="username"]').focus();
	$check=$("#refresh").val();
	if($check=="false")
	{
		window.location.reload(true);
	}
	$("#refresh").val("false");
	var user = $('[name="susername"]').val();
	if(!(user == "null")){
		document.location.href='/BookLendingApplication/home';
	}
	
	$( "form" ).submit(function() {
		  var username = $('[name="username"]').val();
		  var password = $('[name="password"]').val();
		  if(username == ""){
			  $("#error").html("Enter username");
			  $('[name="username"]').focus();
			  return false;
		  }
		  usernameReg = /^\d{9}$/;
		  if(!usernameReg.test(username)){
			  $("#error").html("Invalid username");
			  $('[name="username"]').focus();
			  return false;
		  }
		  if(password == ""){
			  $("#error").html("Enter password");
			  $('[name="password"]').focus();
			  return false;
		  }
	});
});