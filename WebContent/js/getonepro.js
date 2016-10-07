$(window).on('load',function(){
	$('#getpro').click(function(){
		var projectId=$('#projectId').val();
  var url="/smartBook/project?operation=3&projectId="+projectId;
	$.ajax(url)
.done(function(result) {
  console.log(result);
  //alert(result);
  var r=JSON.parse(result);
  $('#pdate').val(r.duedate);
  $('#ptitle').val(r.ptitle);
  $('#projectId').val(r.proid);
  $('#status').val(r.status);
 $('#dis').val(r.desc);



  }) 
	.fail(function(result){
    console.log(result);
//alert(result);
 $('#pdate').val(r.duedate);
  $('#ptitle').val(r.ptitle);
  $('#projectId').val(r.proid);
  $('#status').val(r.status);
 $('#dis').val(r.desc);





  });
   
});
});
