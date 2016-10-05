$(window).on('load',function() {
  $(document).on('click','#sign',function() {
    // Get the value from the textbox
    var un = $('#userName').val();
    var pw = $('#pass').val();
    

    var url = "/smartBook/user?operation=7&userName="+un+"&pass="+pw;
    // Call this URL for Server side actions

    $.ajax(url)
    .done(function(result) {
      
      var response = JSON.parse(result);
      var res = response[0];
        // converted to JSON Object
        if(res.type=="Admin"){
          
            window.location.href='nav.html';
          }
          else if(res.type=="User"){
            
            window.location.href='nav.html';
          }
          else{
            alert("Incorrect User_Name/Password");
          }
    })
    .fail(function(result) {
      console.log(result);
        //alert("Error: " + result);
    });

  });
  });