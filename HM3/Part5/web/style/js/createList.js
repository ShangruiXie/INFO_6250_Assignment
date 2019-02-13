function createBooks() {
    let itemForm = document.getElementById("itemForm");
    itemForm.innerText="";
    let item = new Array();
    let itemPrice = new Array();
    item[0] = "Java Servlet Programming";
    itemPrice[0] = 29.95;
    item[1] = "Oracle Database Programming";
    itemPrice[1] = 48.95;
    item[2] = "System Analysis and Design With UML";
    itemPrice[2] = 14.95;
    item[3]= "Object Orient Software Engineer";
    itemPrice[3] = 35.99;
    item[4]= "Java Web Services";
    itemPrice[4] = 27.99;

    for(let i=0; i<5; i++){
        let chk = document.createElement("input");
        chk.setAttribute("type", "checkbox");
        chk.setAttribute("name", "item");
        chk.setAttribute("value", item[i]+ "$" + itemPrice[i]);
        itemForm.appendChild(chk);
        let lbl = document.createElement("label");
        lbl.setAttribute("value", itemPrice[i]);
        lbl.innerText = item[i] + "[$"+ itemPrice[i] +"]";
        itemForm.appendChild(lbl);
        let br = document.createElement("br");
        itemForm.appendChild(br);
    }

    let view = document.getElementById("tit");
    view.innerText = "Shop for Books";

    let btn = document.createElement("input");
    btn.setAttribute("type", "submit");
    btn.setAttribute("value", "Add to Cart")

    let hid = document.createElement("input");
    hid.setAttribute("type", "hidden");
    hid.setAttribute("name", "option");
    hid.setAttribute("value", "add");
    itemForm.appendChild(btn);
    itemForm.appendChild(hid);
}


function createMusic() {
    let itemForm = document.getElementById("itemForm");
    itemForm.innerText="";
    let item = new Array();
    let itemPrice = new Array();
    item[0] = "I'm Going to Tell You a Secret by Madonna";
    itemPrice[0] = 26.99;
    item[1] = "Baby One More Time by Britney Spears";
    itemPrice[1] = 10.95;
    item[2] = "Justified by Justin Timberlake";
    itemPrice[2] = 9.97;
    item[3]= "Loose by Nelly Furtado";
    itemPrice[3] = 13.98;
    item[4]= "Gold Digger by Kanye Went";
    itemPrice[4] = 27.99;

    for(let i=0; i<5; i++){
        let chk = document.createElement("input");
        chk.setAttribute("type", "checkbox");
        chk.setAttribute("name", "item");
        chk.setAttribute("value", item[i] + "$" + itemPrice[i]);
        itemForm.appendChild(chk);
        let lbl = document.createElement("label");
        lbl.setAttribute("value", itemPrice[i]);
        lbl.innerText = item[i] + "[$"+ itemPrice[i] +"]";
        itemForm.appendChild(lbl);
        let br = document.createElement("br");
        itemForm.appendChild(br);
    }

    let view = document.getElementById("tit");
    view.innerText = "Shop for CDs";

    let btn = document.createElement("input");
    btn.setAttribute("type", "submit");
    btn.setAttribute("value", "Add to Cart")
    let hid = document.createElement("input");
    hid.setAttribute("type", "hidden");
    hid.setAttribute("name", "option");
    hid.setAttribute("value", "add");
    itemForm.appendChild(btn);
    itemForm.appendChild(hid);
}


function createComputers() {
    let itemForm = document.getElementById("itemForm");
    itemForm.innerText="";
    let item = new Array();
    let itemPrice = new Array();
    item[0] = "Apple Macbook Pro with 13.3\" Display";
    itemPrice[0] = 1299.99;
    item[1] = "Asus Laptop with Centrmo 2 Black";
    itemPrice[1] = 949.95;
    item[2] = "HP Pavlion Laptop with Centrmo 2 DV7";
    itemPrice[2] = 1199.95;
    item[3]= "Toshiba Satellite Laptop with Centrmo 2 -Copper";
    itemPrice[3] = 899.99;
    item[4]= "Sony VALO Laptop Cosmopolitan Pink";
    itemPrice[4] = 779.99;

    for(let i=0; i<5; i++){
        let chk = document.createElement("input");
        chk.setAttribute("type", "checkbox");
        chk.setAttribute("name", "item");
        chk.setAttribute("value", item[i]+ "$" + itemPrice[i]);
        itemForm.appendChild(chk);
        let lbl = document.createElement("label");
        lbl.setAttribute("value", itemPrice[i]);
        lbl.innerText = item[i] + "[$"+ itemPrice[i] +"]";
        itemForm.appendChild(lbl);
        let br = document.createElement("br");
        itemForm.appendChild(br);
    }

    let view = document.getElementById("tit");
    view.innerText = "Shop for Laptops";

    let btn = document.createElement("input");
    btn.setAttribute("type", "submit");
    btn.setAttribute("value", "Add to Cart")
    let hid = document.createElement("input");
    hid.setAttribute("type", "hidden");
    hid.setAttribute("name", "option");
    hid.setAttribute("value", "add");
    itemForm.appendChild(btn);
    itemForm.appendChild(hid);
}






