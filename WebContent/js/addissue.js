$(window).on('load',function() {
	$('#send').bind("click",function() {

		// Getting input from TextBox (from the add project)
		var projectId =$('#projectId').val();
		var  desc=$('#description').val();
		var findName=$('#finderName').val();
		var findtime=$('#findTime').val();
		var status =$('#status').val();
		var fixedName=$('#fixedName').val();
		var fixTime=$('#fixTime').val();
	   	
		var url="/smartBook/issue?operation=1&projectId="+ projectId +"&description="+ desc +"&finderName="+ findName +"&findTime="+ findtime +"&status="+ status +"&fixedName="+ fixedName +"&fixTime="+ fixTime;
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
});