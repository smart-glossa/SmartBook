$(window).on('load',function() {
	$('#lbut').click(function() {
		var name=$('#Name').val();
	   var DoB =$('#dob').val();
		var username=$('#userName').val();
		var pass=$('#pass').val();
		//var image=$('#photo').val();
		var type=$('#type').val();
		var url="/SmartBook/user?operation=1&Name="+name+"&dob="+DoB+"&userName="+username+"&pass="+pass+"&type="+type;	
			$.ajax(url)
		.done(function(result) {  // result is the response from Server
			//console.log(result);  //alert will not display JSONObject, so using console log
			alert(result);
      window.location("nav.html");
		})
		.fail(function(result) {  // If any failure, then code will be here
			console.log(result);
		});

	});
	
});


	   