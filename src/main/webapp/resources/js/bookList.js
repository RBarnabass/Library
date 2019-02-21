function init(json) {

    const tbodyEl = document.getElementById("tbody");

    json.forEach(function(book) {

        let tr = tbodyEl.appendChild(document.createElement('tr'))

        for (let [key, value] of Object.entries(book)) {

            let td = tr.appendChild(document.createElement('td'));
            td.innerHTML = value;
        }
    });
}