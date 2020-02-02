function functionName(){

function printAlert(){
    document.getElementById('achtung').style.visibility = "visible";
}

function checkTextField(field){
    document.getElementById("achtung").visibility =
    (field.value === "") ? "visible" : "hidden";
}
}