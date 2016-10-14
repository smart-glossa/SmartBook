$(window).on('load', function() {
    //$('#rf').click(function() {

        var url = "/smartBook/home?operation=1";
        $.ajax(url)
            .done(function(result) {
                console.log(result);
                //alert("sucess");
                var response = JSON.parse(result);
                var res = response[0];


                $('#pro').val(res.Project);
                $('#employee').val(res.User);
                $('#issues').val(res.Issue);

            })
            .fail(function(result) {
                console.log(result);
                //alert("failure");

            });
    //});
});
