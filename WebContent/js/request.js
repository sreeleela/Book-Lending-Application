window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('.requestBook').click(function(e) {
		  e.preventDefault();
		  $("#msg").html("&nbsp");
		  $("#error").html("&nbsp");
		  bookId= $(this).attr('bookId');
		  $.ajax({
	           type: "POST",
	           url: "request",
	           data: {bookId: $(this).attr('bookId')},
	           success: function(data)
	           {
	        	   if(data == "Request Sent"){
	        		   $("#msg").html("congratulations!! Request sent. Happy Lending.");
	        		   $("#onhold"+bookId).html("On Hold");
	        		   $("#error").html("&nbsp");
	        	   }	
	        	   else{
	        		   $("#error").html("Error in Requesting");
	        		   $("#msg").html("&nbsp");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in Requesting");
		  		 $("#msg").html("&nbsp");
		  	   }
	         });

	});
});