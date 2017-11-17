'use strict'

const frontend = (function(){

    const Load = function() {
        ajax("GET", "/search", Render);
        var button = document.querySelector('button');
        var car_brand_input = document.querySelector('input');
        button.addEventListener('click', function () {
          let endpoint = "/search/";
          endpoint += car_brand_input.value;
          console.log(endpoint);
          ajax('GET', endpoint, Render)
        });
    }



    const Render = function(responseData){
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
            tableInnerContent +=`<tr>
            <td>`+ row.plate +`</td>
            <td>`+ row.car_brand +`</td>
            <td>`+ row.car_model +`</td>
            <td>` + row.color + `</td>
            <td>`+ row.year +`</td>
            </tr>`;
        });
            tableInnerContent += `</tbody></table>`;
            table.innerHTML = tableInnerContent;
    }

    return {
        Load : Load
    }

})();

frontend.Load();