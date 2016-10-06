$(window).on('load',function(){
	$('#getuser').click(function(){
		var userName=$('#userName').val();
  var url="/smartBook/user?operation=3&userName="+userName;
	$.ajax(url)
.done(function(result) {
  console.log(result);
  //alert(result);
  var r=JSON.parse(result);
  $('#userName').val(r.userName);
$('#type').val(r.type);
$('#userId').val(r.userId );
$('#Name').val(r.Name);



  }) 
	.fail(function(result){
    console.log(result);
//alert(result);
$('#userName').val(r.userName);
$('#type').val(r.type);
$('#userId').val(r.userId );
$('#Name').val(r.Name);

  });
   
});
});
