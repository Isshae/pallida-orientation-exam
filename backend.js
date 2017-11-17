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
    let data = [];
    sqlConnection.query("SELECT * FROM licence_plates;", function(err, rows){
        if(err){
            console.log("Sql query error!");
        }
        rows.forEach(function(row) {
            data.push(row);
        });
        if(data === null){

        }
        response.json(data);
    });
    
})


app.get("/search/:brand", function(req, res){
    let data = [];
    console.log(req.params.brand);
    sqlConnection.query('SELECT * FROM licence_plates WHERE LOWER(car_brand) like LOWER("'+req.params.brand+'");', function(err, results, fields){
        if(err){
            console.log("Sql query error!");
        }
        results.forEach(function(element){
            data.push(element);
            console.log(element);
        });
    res.json(data);
    });
});

app.get("/licence/:number", function(req, res){
    let data = [];
    console.log(req.params.number);
    if(req.params.number.length <= 7){
        console.log("After IF");
        sqlConnection.query('SELECT * FROM licence_plates WHERE UPPER(plate) like UPPER("'+req.params.number+'");', function(err, results, fields){
            if(err){
                console.log("Sql query error!")
            }
            if(results = null){
                data = {
                    "Message":"Not in db!"
                }
            }else{
                results.forEach(function(element){
                    data.push(element);
                    console.log(element);
                });
            }
            console.log("result: " + results);
        console.log(data);
        res.json(data);
        });
    }else{
        data = {
            "result": "error", 
            "message": "invalid input" 
        }
        
    }
    res.json(data);
});


app.listen(8080);