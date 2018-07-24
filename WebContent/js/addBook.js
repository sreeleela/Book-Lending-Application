window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$( "form" ).submit(function(e) {
		  e.preventDefault();
		  $("#msg").html("");
		  var isbn = $('[name="isbn"]').val();
		  var name = $('[name="name"]').val();
		  var author = $('[name="author"]').val();
		  var edition = $('[name="edition"]').val();
		  var publisher = $('[name="publisher"]').val();
		  var description = $('[name="description"]').val();
		  var availableFrom = $('[name="availableFrom"]').val();
		  var availableTo = $('[name="availableTo"]').val();
		  
		  if(isbn == ""){
			  $("#error").html("Enter ISBN");
			  $('[name="isbn"]').focus();
			  return false;
		  }
		  if(name == ""){
			  $("#error").html("Enter book name");
			  $('[name="name"]').focus();
			  return false;
		  }
		  if(author == ""){
			  $("#error").html("Enter author name");
			  $('[name="author"]').focus();
			  return false;
		  }
		  if(edition == ""){
			  $("#error").html("Enter edition");
			  $('[name="edition"]').focus();
			  return false;
		  }
		  if(publisher == ""){
			  $("#error").html("Enter publisher");
			  $('[name="publisher"]').focus();
			  return false;
		  }
		  if(description == ""){
			  $("#error").html("Enter description");
			  $('[name="description"]').focus();
			  return false;
		  }
		  if(availableFrom == ""){
			  $("#error").html("Enter the date available from");
			  $('[name="availableFrom"]').focus();
			  return false;
		  }
		  if(availableTo == ""){
			  $("#error").html("Enter the last date the book is available");
			  $('[name="availableTo"]').focus();
			  return false;
		  }
		  $.ajax({
	           type: "POST",
	           url: "addBook",
	           data: $("#bookAddition").serialize(),
	           success: function(data)
	           {
	        	   if(data == "Book Added"){
	        		   $("#msg").html("congratulations!! Book Added. Happy Lending.");
	        		   $("#error").html("");
	        		   
	        		   $('[name="isbn"]').val('');
	        		   $('[name="name"]').val('');
	        		   $('[name="author"]').val('');
	        		   $('[name="edition"]').val('');
	        		   $('[name="publisher"]').val('');
	        		   $('[name="description"]').val('');
	        		   $('[name="availableFrom"]').val('');
	        		   $('[name="availableTo"]').val('');
	        	   }	
	        	   else{
	        		   $("#error").html("Error in adding book");
	        		   $("#msg").html("");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in adding book");
		  		 $("#msg").html("");
		  	   }
	         });

	});
});