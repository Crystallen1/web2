window.onload = function (){
    //绑定事件
    var scyTbl = document.getElementById("tableSCY");

    var rows = scyTbl.rows;
    for (var i = 1; i < rows.length; i++) {
        var tr = rows[i];
        tr.onmouseover = showBGColor;
        tr.onmouseout = clearBGColor;

        var cells = tr.cells;
        var priceTD1 = cells[1];
        priceTD1.onmouseover = showHand;
        priceTD1.onclick = editmassage;
        var priceTD2 = cells[2];
        priceTD2.onmouseover = showHand;
        priceTD2.onclick = editmassage;
    }
}
function editmassage() {
    if (event&&event.srcElement&&event.srcElement.tagName=="TD"){
        var priceTD=event.srcElement;
        if (priceTD.firstChild&&priceTD.firstChild.nodeType==3){
            var oldName = priceTD.innerText;
            priceTD.innerHTML="<input type='text' size ='4'/>"
            var input = priceTD.firstChild;
            if (input.tagName=="INPUT"){
                input.value = oldName;
                input.select();
                input.onblur=updataMessage;
                input.onkeydown= ckInput;
            }
        }

    }
}

function ckInput() {
    var kc = event.keyCode;

    if (kc==13){
        event.srcElement.blur();
    }
}

function updataMessage() {
    if (event&&event.srcElement&&event.srcElement.tagName=="INPUT") {
        var inputnum1 = event.srcElement;
        var newPrice = inputnum1.value;
        var priceTD = inputnum1.parentElement;
        priceTD.innerText = newPrice;
    }
}


function showBGColor(){
    if (event&&event.srcElement&&event.srcElement.tagName=="TD"){
        var td=event.srcElement;
        var tr=td.parentElement;
        tr.style.backgroundColor="Blue";

        var tds=tr.cells;
        for (var i = 0; i < tds.length; i++) {
            tds[i].style.color="white";
        }
    }
}
function clearBGColor() {
    if (event&&event.srcElement&&event.srcElement.tagName=="TD"){
        var td=event.srcElement;
        var tr=td.parentElement;
        tr.style.backgroundColor ="transparent";

        var tds=tr.cells;
        for (var i = 0; i < tds.length; i++) {
            tds[i].style.color="black";
        }
    }
}
function showHand() {
    if (event&&event.srcElement&&event.srcElement.tagName=="TD"){
        var td=event.srcElement;
        td.style.cursor="hand"
    }
}

