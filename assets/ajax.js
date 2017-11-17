'use strict'


function ajax(request_type, end_point, callback, reqBody){
    
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080";
    xhr.open(request_type, url+end_point,true);
    xhr.setRequestHeader("accept", "application/json");
    xhr.setRequestHeader("content-type", "application/json");
    xhr.onload = function(){
        console.log("Hello callback!");
        callback(JSON.parse(xhr.responseText));
        console.log("Response text in ajax!");
    }
    let bodyDataText = null;
    if(reqBody){
        bodyDataText = JSON.stringify(reqBody);
    }
    console.log("Ajax response sending ...");
    xhr.send(bodyDataText);
}
