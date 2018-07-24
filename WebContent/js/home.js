window.onbeforeunload = function(){  
};
$(document).ready(function(){
	$check=$("#refresh").val();
	if($check=="false")
	{
		window.location.reload(true);
	}
	$("#refresh").val("false");
	var user = $('[name="susername"]').val();
	if(user == "null"){
		document.location.href='index.jsp';
	}
});