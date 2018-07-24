window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('#vPassword').click(function(e) {
		  $("#msg").html("&nbsp");
		  $("#error").html("&nbsp");
		  $("#old").css('visibility', 'visible');
		  $("#new").css('visibility', 'visible');
		  $("#newCheck").css('visibility', 'visible');
		  $("#psave").css('visibility', 'visible');
		  $('[name="old"]').focus();
	});
	$('#psave').click(function(e) {
		  $("#msg").html("&nbsp");
		  $("#error").html("&nbsp");
		  
		  var pass = $('[name="password"]').val();
		  var old = $('[name="old"]').val();
		  var newPass = $('[name="new"]').val();
		  var newPassCheck = $('[name="newCheck"]').val();
		  var username = $('[name="username"]').val();
		  
		  if(old == ""){
			  $("#error").html("Enter old password.");
			  $('[name="old"]').focus();
			  return false;
		  }
		  else if(newPass == ""){
			  $("#error").html("Enter new password.");
			  $('[name="new"]').focus();
			  return false;
		  }
		  else if(newPassCheck == ""){
			  $("#error").html("Re-Enter new password.");
			  $('[name="newCheck"]').focus();
			  return false;
		  }
		  else if(!(pass == old)){
			  $("#error").html("Wrong password entered.");
			  $('[name="old"]').focus();
			  return false;
		  }
		  else if(newPass.length < 8){
			  $("#error").html("Password too short.");
			  $('[name="new"]').focus();
			  return false;
		  }
		  else if(!(newPass == newPassCheck)){
			  $("#error").html("Passwords don't match.");
			  $('[name="newCheck"]').focus();
			  return false;
		  }
		  
	});
});