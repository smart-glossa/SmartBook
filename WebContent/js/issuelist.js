
//get all project list
$(window).on('load', function() {
    $('#iss').click(function() {
            var url = "/smartBook/issue?operation=5";

            $.ajax(url)
                .done(function(result) {
                    var res = JSON.parse(result);
                    var count = res.length;
                    var table = $('#div1').children();
                    var tablebody = table.remove();
                    $('#div1').append("<table class='table-fill'></table>");
                    var table = $('#div1').children();
                    table.append("<tr><th class='text-left'>ISSUEID</th><th class='text-left'>PROJECTID</th><th  class='text-left'>FINDERNAME</th><th  class='text-left'>FINDTIME</th><th  class='text-left'>FIXERNAME</th><th  class='text-left'>FIXEDTIME</th><th  class='text-left'>STATUS</th><th  class='text-left'>DESCRIPTION</th><th  class='text-left'>UPDATE/DELETE</th></tr>");

                    for (var i = 0; i < count; i++) {
                        var jsonObj = res[i];
                        var rowString = "<tr><td class='text-left'>" + jsonObj.issueId + "</td><td class='text-left'>" + jsonObj.projectId + "</td><td  class='text-left'>"  + jsonObj.finderName + "</td><td class='text-left'>" + jsonObj.findTime + "</td><td  class='text-left'>" + jsonObj.fixedName + "</td><td  class='text-left'>" + jsonObj.fixTime +"</td><td  class='text-left'>" + jsonObj.status + "</td><td  class='text-left'>" + jsonObj.description +"</td><td></td></tr>";
                        table.append(rowString);

                        // rowString.append(im);

                    }
                    var im = $("table td:nth-child(9)").append('<img  src="../images/4.png" id="projectId" class="remov"/>');
                    //$(this).attr('id',   this.id + '_' + projectId);
                    $("table td:nth-child(9)").append('<h5 id=""><a href="update.html">Update</a></h5>')

                })

            .fail(function(result) {
                alert(result);
            });
        })
        //delete the project
    $('#projectId').click(function() {


        //jsonObj[i].projectId==rem;
        //arr=removejsonObj(arr,["projectId"]);
        id = $(this).parent().attr("#projectId");
        //remove("projectId");
        //('projectId').remove();
        //$(this).attr('projectId');
        //var url = "http://localhost:8080/ajith/project?mode=3&projectId=1";
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
