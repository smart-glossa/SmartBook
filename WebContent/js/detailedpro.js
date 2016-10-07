$(window).on('load',function(){
	$('#id1').click(function() {
		var url="/smartBook/project?operation=5";
		$.ajax(url)
.done(function(result) {
	  var res=JSON.parse(result);
  var count = res.length;
  var table=$('#div2').children();
  var tablebody=table.remove();
  $('#div2').append("<table class='tablerow1'></table>");
  var table=$('#div2').children();        
  table.append("<tr><th>title</th></tr>");
for(var i=0;i<count;i++){
     var jsonObj =res[i];
     var rowString = "<tr><td>"  + jsonObj.ptitle + "</td></tr>";
     $("td").attr("id","view");
 table.append(rowString);
 
  //var textarea=$('<textarea style="padding-left:100px" class="area" />'); 
//table.append(textarea);   
  
 } 


// create command box using Dom
var divs=document.createElement("div");
  divs.setAttribute("id","heads");

  var com=document.createElement("textarea"); 
  divs.appendChild(com);

  document.body.appendChild(divs);
  var but=document.createElement("button");
  var name=document.createTextNode("post");
    but.appendChild(name);
    divs.appendChild(but);
   document.getElementById("heads");
   //rowString.addEventListener("click", function(){
    $("#view").click(function(){
   if(divs.style.display == 'block' || divs.style.display== '')
    divs.style.display='none';
   else
   {
    divs.style.display='block';
   }
})
   })
	.fail(function(result){
    alert("error");
    });
   }) 
});


