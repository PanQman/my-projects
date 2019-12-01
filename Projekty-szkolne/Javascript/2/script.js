
var oldAmountTemp = document.getElementById('amountTemp');
var alertTextVisible = document.getElementById('achtung');


function convertTemperature(){
  var amountTemp = parseInt(document.getElementById("amountTemp").value);
  var radioButtonTemp = document.getElementsByName('radioButtonTemp');
  if (validation(amountTemp)) {

    oldAmountTemp = amountTemp;
    console.log(radioButtonTemp[0].checked);
    console.log(radioButtonTemp[1].checked);
    if (radioButtonTemp[0].checked) {
        amountTemp = Math.round((amountTemp * 1.8) + 32);
        addRow(amountTemp, 1);
    } else if (radioButtonTemp[1].checked) {
        amountTemp = Math.round((amountTemp - 32) / 1.8);
        addRow(amountTemp, 0);
    }
    printOrHideAlert("hidden");
    printTemperature(amountTemp, radioButtonTemp[0].checked);
  } else {
    printOrHideAlert("visible");
  }
}
function printTemperature(amountTemp, checkbox){
  var skala = checkbox ? " F" : " C";
  document.getElementById('resultTemperature').value = amountTemp + skala;
}

function validation(amountTemp){
  if (!isNaN(amountTemp)){
    console.log(typeof(amountTemp));
    return true;
  } else {
    console.log("Błąd walidacji. Podany typ nie jest liczbą");
    return false;
  }
}
function printOrHideAlert(vis){
    document.getElementById('achtung').style.visibility = vis;
}

function addRow(amountTemp, bols) {
  var table = document.getElementById("myTable");
  var row = table.insertRow(0);
  var cell1 = row.insertCell(0);
  console.log(amountTemp);
  if (bols === 1){
  	cell1.innerHTML = oldAmountTemp + '°C --> ' + amountTemp + ' °F';
  } else if (bols === 0) {
  	cell1.innerHTML = oldAmountTemp + '°F --> ' + amountTemp + ' °C';
  }
}

function functionName() {
  var wrt = 0;

  changeImg();
  changeText();

function changeText(){
  var textPogoda = document.getElementById('Job');
  textPogoda.innerText = 'Słonecznie';
}

function changeImg(){
  wrt++;
  if (wrt > 2){
    wrt = 0;
  }
  var tab = ['Słonecznie', 'Przejaśnienia', 'Pochmurno'];
  var textPogoda = document.getElementById("Job");
  textPogoda.innerText = tab[wrt];

  var num = Math.floor(Math.random()*40) + 0;
  num *= Math.floor(Math.random()*2) == 1 ? 1 : -1;
  document.getElementById('Temp').innerText = num + ' stopni';


  TimerRunning=true;
  var timer = setTimeout(function() { changeImg() }, 5000);
}
}
