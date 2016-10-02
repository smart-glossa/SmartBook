/*
Proper formatting is what makes the code readable. Indent your code.
Just follow some good style guides. One of which is https://google.github.io/styleguide/javascriptguide.xml

Make sure your team follows the same. So that it will be like one man typed code. No matter who types it will look the same

Avoid global selectors. Initially it may look convenient and come handy, but as your product goes. You will be using lots and lots
id's. You dont want the selector to search for the whole document. Rather than limit it to a particular dom. Like
$RefNode.find("#test"). Its an example where you will find the nodes only within the refNode.

*/


$(window).on('load', function() {
    $('#getuser').click(function() {
        var userName = $('#userName').val();
        var url = "/SmartBook/user?operation=3&userName=" + userName;
        $.ajax(url)
            .done(function(result) {
                console.log(result);
                //alert("sucess");
                var res = JSON.parse(result);
                $('#userName').val(res.userName);
                $('#type').val(res.type);
                $('#userId').val(res.userId);
                $('#Name').val(res.Name);
            })
            .fail(function(result) {
                console.log(result);
                //alert("failure");
            });
    });
});
