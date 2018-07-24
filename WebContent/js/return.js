window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('.return').click(function(e) {
		  e.preventDefault();
		  $("#msg").html("&nbsp");
		  requestId = $(this).attr('requestId');
		  bookId = $(this).attr('bookId');
		  $.ajax({
	           type: "POST",
	           url: "return",
	           data: {requestId: $(this).attr('requestId'), bookId:$(this).attr('bookId')},
	           success: function(data)
	           {
	        	   if(data == "Book Returned"){
	        		   $("#msg").html("Book Returned");
	        		   $("#return"+requestId).html("Returned");
	        		   $("#error").html("&nbsp");
	        		   $("#emailIdOwner"+requestId).html("&nbsp");
	        	   }	
	        	   else{
	        		   $("#error").html("Error in Returning Book Request");
	        		   $("#msg").html("&nbsp");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in Returning Book Request");
		  		 $("#msg").html("&nbsp");
		  	   }
	         });

	});
});