window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$('.approve').click(function(e) {
		  e.preventDefault();
		  $("#msg").html("&nbsp");
		  requestId = $(this).attr('requestId');
		  bookId = $(this).attr('bookId');
		  $.ajax({
	           type: "POST",
	           url: "approve",
	           data: {requestId: $(this).attr('requestId'), bookId:$(this).attr('bookId')},
	           success: function(data)
	           {
	        	   if(data == "Request Approved"){
	        		   $("#msg").html("Request Approved");
	        		   $("#result"+requestId).html("Approved");
	        		   $("#returned"+requestId).html("<a href='' class='return' requestId='"+requestId+"' bookId='"+bookId+"'>To Be Returned</a>");
	        		   $("#error").html("&nbsp");
	        	   }	
	        	   else{
	        		   $("#error").html("Error in Request Approving");
	        		   $("#msg").html("&nbsp");
	        	   }
	           },
		  	   error: function(data)
		  	   {
		  		 $("#error").html("Error in Request Approving");
		  		 $("#msg").html("&nbsp");
		  	   }
	         });

	});
});