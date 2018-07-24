window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('.reject').click(function(e) {
		  e.preventDefault();
		  $("#msg").html("&nbsp");
		  requestId = $(this).attr('requestId');
		  bookId = $(this).attr('bookId');
		  $.ajax({
	           type: "POST",
	           url: "reject",
	           data: {requestId: $(this).attr('requestId'), bookId:$(this).attr('bookId')},
	           success: function(data)
	           {
	        	   if(data == "Request Rejected"){
	        		   $("#msg").html("Request Rejected");
	        		   $("#result"+requestId).html("Rejected");
	        		   $("#error").html("&nbsp");
	        		   $("#emailIdOwner"+requestId).html("&nbsp");
	        	   }	
	        	   else{
	        		   $("#error").html("Error in Request rejecting");
	        		   $("#msg").html("&nbsp");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in Request Rejecting");
		  		 $("#msg").html("&nbsp");
		  	   }
	         });

	});
});