$(window).on('load',function() {
  $('#sign').click(function() {
    // Get the value from the textbox
    var un = $('#userName').val();
    var pw = $('#pass').val();
    

    

    var url = "/SmartBook/user?operation=7&userName="+un+"&pass="+pw;
    // Call this URL for Server side actions

    $.ajax(url)
    .done(function(result) {
      var response = JSON.parse(result);
        // converted to JSON Object
        if(response.type=="Admin"){
          
            window.location("nav.html");
          }
          else if(response.type=="User"){
            window.location("employeeadd.html");
          }
          else{
            alert(response);
          }
       
 
    })
    .fail(function(result) {
      console.log(result);
        
    });

  });
  });