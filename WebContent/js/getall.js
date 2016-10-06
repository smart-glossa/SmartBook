$(window).on('load',function(){
$('#des').click(function(){
	var url="/smartBook/user?operation=4" ;
$.ajax(url)
.done(function(result) {
	  var res=JSON.parse(result);
  var count = res.length;
var table=$('#div1').children();
  var tablebody=table.remove();
  $('#div1').append("<table  class='table-fill'></table>");
  var table=$('#div1').children();        
 		 		 	
 	table.append("<tr><th  class='text-left'>userName</th><th  class='text-left'>type</th><th  class='text-left'>userId</th><th  class='text-left'>Name</th></tr>");
 	for(var i=0;i<count;i++){
		 var jsonObj =res[i];
 		 var rowString = "<tr><td  class='text-left'>" + jsonObj.userName  +  "</td><td  class='text-left'>"  + jsonObj.type+ "</td><td  class='text-left'>" + jsonObj. userId+ "</td><td  class='text-left'>" + jsonObj.Name +"</td></tr>";
 	table.append(rowString);
 }
//alert("Internal error occurs");
//}
});

});
   
});
