$(window).on('load',function() {
  $('#sign').click(function() {
    // Get the value from the textbox
    var un = $('#userName').val();
    var pw = $('#pass').val();
    

    // construct URL for Add Visitors

    var url = "http://localhost:8080/smartBook/user?operation=7&userName="+un+"&pass="+pw;
    // Call this URL for Server side actions

    $.ajax(url)
    .done(function(result) {
      var response = JSON.parse(result);
        // converted to JSON Object
        if(response.type==admin){
          
            window.location("nav.html");
          }
          else if(user==response.type){
            window.location("employeeadd.html");
          }
          else{
            alert(response);
          }

        
      /*if (response.status == 1) {
        alert ("Successfully Added");
      } else if (response.status == 0) {
        alert ("Error in Form: " + response.message);
      } else {
        alert("Internal Error Occurs");
      }*/
    })
    .fail(function(result) {
      console.log(result);
        //alert("Error: " + result);
    });

  });
  });