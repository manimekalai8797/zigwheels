var app = new function () {
    var countries = [];
    var mode = "";
    var url = "https://zigwheels.herokuapp.com/api/teams/";
    // http://localhost:8080/api/teams/
    // var url = "http://localhost:8080/api/teams/";
    this.FetchAll = function () {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {

            if (this.readyState == 4 && this.status == 200) {
                countries = JSON.parse(xhttp.responseText);
                app.printtable();
            }
        };
        xhttp.open("GET", url, true);
        xhttp.send();
    };
    this.printtable = function () {
        var html = "<table class='table table-bordered'>";
        for (var i  in countries) {
            html += "<tr>";
            html += "<td>" + countries[i].teamid + "</td>";
            html += "<td>" + countries[i].teamname + "</td>";
            html += '<td><button class="glyphicon glyphicon-pencil   btn fa-edit "  onclick="app.Edit(' + countries[i].teamid + ')"></button></td>';
            html += '<td><button class="glyphicon glyphicon-trash btn fa-delete "  onclick="app.Delete(' + countries[i].teamid + ')"></button></td>';
            html += "</tr>";
        }
        html += "</table>";
        document.getElementById("countries").innerHTML = html;
    };

    this.Edit = function (teamid) {
        mode = "edit";
        document.getElementById('btn').innerHTML = "Update";
        for (var i = 0; i < countries.length; i++) {

            if (countries[i].teamid == teamid) {
                // //alert(teamid);
                document.getElementById('teamid').value = countries[i].teamid;
                document.getElementById('teamname').value = countries[i].teamname;
            }
        }
    };

    this.saveorupdate = function () {
        var id = document.getElementById('teamid').value;
        var name = document.getElementById('teamname').value;
        if (mode == "") {
            //alert("save called");
            // {"teamid": 0, "teamname": "TeamIndia"}
            var newTeam = { "teamid": 0, "teamname": name };
            //alert(newTeam);
            //  var url = "http://zigwheels.herokuapp.com/api/teams/";
            var xhr = new XMLHttpRequest();
            xhr.onload = function () {
                if (xhr.readyState == 4 && xhr.status == "201") {
                    app.FetchAll();
                }
            }
            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.send(JSON.stringify(newTeam));
            app.FetchAll();
        }
        else {
            //alert("update called");

            // var updateTeam = {};
            // updateTeam.teamid=id;
            // updateTeam.teamname=name;

            var updateTeam = { "teamid": id, "teamname": name };
            //alert(updateTeam);

            var xhr = new XMLHttpRequest();
            xhr.onload = function () {
                if (xhr.readyState == 4 && xhr.status == "200") {
                    app.FetchAll();
                }
            }
            xhr.open("PUT", url + updateTeam.teamid, true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            //alert(JSON.stringify(updateTeam));
            xhr.send(JSON.stringify(updateTeam));
            document.getElementById('btn').innerHTML = "Add";
            mode = "";
            app.FetchAll();
        }

        document.getElementById('teamid').value = "";
        document.getElementById('teamname').value = "";
    };

    this.Delete = function (teamid) {
        // console.log("delete called " + id);
        var xhr = new XMLHttpRequest();
        xhr.open("DELETE", url + teamid, true);
        xhr.onload = function () {
            if (xhr.readyState == 4 && xhr.status == "204") {
                app.FetchAll();
            }
        }
        xhr.send(null);
        app.FetchAll();
    };
}