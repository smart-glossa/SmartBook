
//get all project list
$(window).on('load', function() {
    //$('#id').click(function() {
            var url = "/smartBook/project?operation=4";

            $.ajax(url)
                .done(function(result) {
                    var res = JSON.parse(result);
                    var count = res.length;
                    var table = $('#div1').children();
                    var tablebody = table.remove();
                    $('#div1').append("<table class='table-fill'></table>");
                    var table = $('#div1').children();
                    table.append("<tr><th class='text-left'>SERIAL NUMBER</th><th  class='text-left'>TITLE</th><th  class='text-left'>DESCRIPTION</th><th  class='text-left'>DUEDATE</th><th  class='text-left'>STATUS</th><th  class='text-left'>ACTION</th></tr>");

                    for (var i = 0; i < count; i++) {
                        var jsonObj = res[i];
                        var rowString = "<tr><td class='text-left'>" + jsonObj.projectId + "</td><td  class='text-left'>"  + jsonObj.ptitle + "</td><td class='text-left'>" + jsonObj.dis + "</td><td  class='text-left'>" + jsonObj.pdate + "</td><td  class='text-left'>" + jsonObj.status + "</td><td>" + "</td></tr>";
                        table.append(rowString);

                        // rowString.append(im);

                    }
                    var im = $("table td:nth-child(6)").append('<img  src="../images/4.png" id="projectId" class="remov"/>');
                    //$(this).attr('id',   this.id + '_' + projectId);
                    $("table td:nth-child(6)").append('<h5 id=""><a href="update.html">Update</a></h5>');

                })

            .fail(function(result) {
                alert(result);
            });
        //})
        //delete the project
    $('#projectId').click(function() {


        //jsonObj[i].projectId==rem;
        //arr=removejsonObj(arr,["projectId"]);
        id = $(this).parent().attr("#projectId");
        //remove("projectId");
        //('projectId').remove();
        //$(this).attr('projectId');
        var url = "http://localhost:8080/ajith/project?mode=3&projectId=1";
        $.ajax(url)
            .done(function(result) {
                //console.log(result);
                $(this).parent().remove();
            })

        .fail(function(result) {
            console.log(result);
        })
    });
});
