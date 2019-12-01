var countRows = 1;

class Prognoza {
  constructor(place, day) {
    this.place = place;
    this.day = day;
    this.tab = [];
  }

  addTemp(temp, cell) {
    if (this.tab.length < 8) {
      this.tab[this.tab.length] = temp;
    }

  }
  printtemps(cell) {
    cell.innerHTML = '';
    console.log(this.tab[0]);
     for (var i = 0; i < this.tab.length; i++) {
       cell.innerHTML += this.tab[i] + ', ';
     }
 }
}

function addNewRow(prog) {

  var table = document.getElementById("myTable");
  var row1 = table.insertRow(countRows);
  var cell1 = row1.insertCell(0);
  var cell2 = row1.insertCell(1);
  var cell3 = row1.insertCell(2);
  var cell4 = row1.insertCell(3);
  var cell5 = row1.insertCell(4);
  var cell6 = row1.insertCell(5);

  cell1.innerHTML = prog.place;
  cell2.innerHTML = prog.day;
  cell4.innerHTML = averageTemp(0);
  cell6.innerHTML = '<input id="writeTemps" type="number">'
  let tempsRow = document.getElementById('writeTemps');
  tempsRow.id = 'rowTemp' + countRows;

  cell5.innerHTML = '<button id="newButton">Dodaj</button>';
  let newButton = document.getElementById('newButton');
  newButton.id = 'rowButton' + countRows;
  newButton.onclick = function () {
    prog.addTemp(parseInt(tempsRow.value), cell6);
    cell4.innerHTML = averageTemp(prog.tab);
    prog.printtemps(cell3);
  }

  countRows++;
}

function addNewPogoda() {
  var temperatura = document.getElementById("dzienTygodnia").value;
  var miejscowosc = document.getElementById("newMiejscowosc").value;
  let prog = new Prognoza(temperatura, miejscowosc);
  addNewRow(prog);
}

function averageTemp(tab){
  let avg = 0;
  for (let i=0; i < tab.length; i++){
    avg += tab[i];
  }
  avg = avg/(tab.length);
  if (isNaN(avg)) {
    return 0;
  } else {
    return avg;
  }
}
