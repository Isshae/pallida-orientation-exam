'use strict'

const frontend = (function(){

    const Load = function() {
        console.log("Frontend - Load method");
        ajax("GET", "/search", Render);

    }

    const Render = function(responseData){
        let ulBody = document.querySelector('ul');
        
        // while(ulBody.firstChild){
        //     ulBody.removeChild(ulBody.firstChild);
        // }
        responseData.forEach(function(item) {
            let newLi = document.createElement('li');
            newLi.textContent = item;  
            ulBody.appendChild(newLi);
        });
    }

    return {
        Load : Load,
        Create : Create
    }

})();

console.log("Frontend calling...");
frontend.Load();