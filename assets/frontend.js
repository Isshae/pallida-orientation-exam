'use strict'

const frontend = (function(){

    const Load = function() {
        ajax("GET", "/search", Render);
        var brand_button = document.querySelector('.brand_button');
        var car_brand_input = document.querySelector('.brand_input');
        brand_button.addEventListener('click', function () {
          let endpoint = "/search/";
          endpoint += car_brand_input.value;
          console.log(endpoint);
          ajax('GET', endpoint, Render)
        });

        var licence_button = document.querySelector('.licence_button');
        var licence_input = document.querySelector('.licence_input');
        licence_button.addEventListener('click', function () {
          let endpoint = "/licence/";
          endpoint += licence_input.value;
          console.log(endpoint);
          ajax('GET', endpoint, Render)
        });
    }



    const Render = function(responseData){
        console.log(responseData);
        if(responseData !== null){
            let table = document.querySelector('table');
            while(table.firstChild){
                table.removeChild(table.firstChild);
            }
            let tableInnerContent = `<table style="border-width:1px;border-color:black;border-style:solid;">
                                    <thead>
                                        <th>Plate</th>
                                        <th>Car brand</th>
                                        <th>Model</th>
                                        <th>Color</th>
                                        <th>Year</th>
                                    </thead>
                                    <tbody>`;
            responseData.forEach(function(row) {
                let carBrandField = document.createElement('p');
                carBrandField.textContent = row.car_brand;
                carBrandField.addEventListener('click', function(){
                    let url = "/search/"+ carBrandField.textContent;
                        ajax("GET", url, Render);
                });
                tableInnerContent +=`<tr>
                <td>`+ row.plate +`</td>
                <td >[`+ carBrandField.textContent +`]</td>
                <td>`+ row.car_model +`</td>
                <td>` + row.color + `</td>
                <td>`+ row.year +`</td>
                </tr>`;
            });
                tableInnerContent += `</tbody></table>`;
                table.innerHTML = tableInnerContent;
        }else{
            alert("No results!")
        }
    }

    return {
        Load : Load
    }

})();

frontend.Load();