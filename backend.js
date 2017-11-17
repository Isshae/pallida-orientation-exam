'use strict'
let password_string = 'Alga19890505';
let mysql = require('mysql');
let express = require('express');
let app = express();

express.json.type = "application/json";

app.use(express.json());
app.use('/assets',express.static('./assets'));

var sqlConnection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: password_string,
    database: 'Licence'
});

app.get('/', function(request, response){
    response.sendFile(__dirname + '/index.html');
});

app.get("/search", function(request, response){
    console.log("list end point!");
    let data = [];
    sqlConnection.query("SELECT * FROM licence_plates;", function(err, rows){
        if(err){
            console.log("Sql query error!");
        }
        rows.forEach(function(row) {
            data.push(row);
            console.log(row);
        });
        response.json(data);
    });
    
})


app.delete("/tracklists/:id", function(req, res){
    let data = [];
    sqlConnection.query("DELETE FROM Music WHERE id="+req.params.id+" AND system = 0;");
    sqlConnection.query("Select * from Music;", function(err, results, fields){
        results.forEach(function(element){data.push(element)
    })
    res.json(data);
    })
});


app.listen(8080);