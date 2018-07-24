window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('.withdraw').click(function(e) {
		  e.preventDefault();
		  $("#msg").html("&nbsp");
		  requestId = $(this).attr('requestId');
		  bookId = $(this).attr('bookId');
		  $.ajax({
	           type: "POST",
	           url: "withdraw",
	           data: {requestId: $(this).attr('requestId'), bookId:$(this).attr('bookId')},
	           success: function(data)
	           {
	        	   if(data == "Request Withdrawn"){
	        		   $("#msg").html("Request Withdrawn");
	        		   $("#withdraw"+requestId).html("Withdrawn");
	        		   $("#pending"+requestId).html("Requested");
	        		   $("#error").html("&nbsp");
	        	   }	
	        	   else{
	        		   $("#error").html("Error in Withdrawing Request");
	        		   $("#msg").html("&nbsp");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in Withdrawing Request");
		  		 $("#msg").html("&nbsp");
		  	   }
	         });

	});
});