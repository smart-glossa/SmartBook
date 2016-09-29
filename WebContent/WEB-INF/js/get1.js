$(window).on('load',function(){
	$('#getuser').click(function(){
		var userName=$('#userName').val();
  var url="http://localhost:8080/smartBook/user?operation=3&userName="+userName;
	$.ajax(url)
.done(function(result) {
  console.log(result);
  //alert("sucess");
  var res=JSON.parse(result);
  $('#userName').val(res.userName);
$('#type').val(res.type);
$('#userId').val(res.userId );
$('#Name').val(res.Name);




  }) 
	.fail(function(result){
    console.log(result);
//alert("failure");
   $('#userName').val(res.userName);
$('#type').val(res.type);
$('#userId').val(res.userId );
$('#Name').val(res.Name);


  });
   
});
});
