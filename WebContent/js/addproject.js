$(window).on('load',function() {
	$('#po').bind("click",function() {

		// Getting input from TextBox (from the add project)
		var title =$('#ptitle').val();
	   var  desc=$('#dis').val();
		var duedate=$('#pdate').val();
		var status =$('#status').val();
		var url="/smartBook/project?operation=1&ptitle="+ title +"&dis="+ desc +"&date="+ duedate +"&status="+ status;
		$("input[type=text],textarea").val("");
		$.ajax(url)
		.done(function(result) {  // result is the response from Server
			//console.log(result); 

			alert(result);
		})
		.fail(function(result) {  
		alert(result);
		});

	});

	//update tthe project details
	$('#up').click(function(){
		var proid=$('#projectId').val();
		var title =$('#ptitle').val();
	   var  desc=$('#dis').val();
		var duedate=$('#pdate').val();
		var status =$('#status').val();
		var url="http://localhost:8080/smartBook/project?operation=2&projectId="+ proid +"&ptitle="+ title +"&dis="+ desc +"&date="+ duedate +"&status="+status;
		$.ajax(url)
		.done(function(result) {  // result is the response from Server
			console.log(result); 
			//alert(result);
			if(status==1)
			{
				window.location.href='prolist.html';
							}
	})
		.fail(function(result) {  
		alert(result);
		});
});
});