$(window).on('load', function() {
    $(document).on('click', '#lbut', function() {
        var name = $('#Name').val();
        var DoB = $('#dob').val();
        var username = $('#userName').val();
        var pass = $('#pass').val();
        //var image=$('#photo').val();
        var type = $('#type').val();
        var url = "/smartBook/user?operation=1&Name=" + name + "&dob=" + DoB + "&userName=" + username + "&pass=" + pass + "&type=" + type;
        $.ajax(url)
            .done(function(result) {
                var response = JSON.parse(result);
                // result is the response from Server
                //console.log(result);  //alert will not display JSONObject, so using console log
                //alert(result);
                if (response.status == 1) {
                    window.location.href = 'nav.html';
                }
                //get the user name only
                function getusername(){
                    var user=JSON.username({
                        'response':$('#userName').val()
                       
                    });
                    var response=JSON.parse(JSON.username);
                    $("#userName").val(username);
                    return response.username;
                }
            })
            .fail(function(result) { // If any failure, then code will be here
                console.log(result);
            });

    });

});
