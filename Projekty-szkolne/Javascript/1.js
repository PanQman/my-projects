function factorial2(n){
if (n == 0 || n == 1){
  return 1; 
  }
    n *= factorial2(--n);
    return n; 
}

function reverseFactorial(n){
  return (n == 1) ? n : n * reverseFactorial(--n);  
}
console.log(factorial2(4));



////2

function fibonacci(n){
  if (n <= 1) {
    return 1;
  } else {
    return fibonacci(n-1) + fibonacci(n-2) 
  }
}
console.log(fibonacci(6));
///3

function palindrom(palin){
  str = palin.split('').reverse().join('');
  if (str === palin){
    return true;
  } else return false;

}
console.log(palindrom('ada'));

///4

function sort1(str){
  let sorted = str.split('').sort().join('');
  return sorted;
}
console.log(sort1('dwdasashcash'));

///5

function longWord(word){
  let chars = word.split(' ');
  let maxLength = 0;
  let string = null;
  for (var i = 0; i < chars.length; i++){
    if (maxLength < chars[i].length){
      maxLength = chars[i].length;
      string = chars[i];
    }
  }
  return string;
}

console.log(longWord('Najd³u¿sze s³owo to'));

//6

function liczbaPierwsza(n){
  for(var i=2;i<n;i++)
    if(n%i==0){
      return false;
    }
      return true
}

 console.log(liczbaPierwsza(8));

 //7
function s(n){
  console.log(typeof(n));
}

//8

function h(tab){
  tab.sort(function(x,y) {
    return x-y;
    });
  var uniqa = [tab[0]];
  var result = [];
  
  for(var i=1; i < tab.length; i++) {
    if(tab[i-1] !== tab[i]){
      uniqa.push(tab[i]);
    }
  }
  result.push(uniqa[1],uniqa[uniqa.length-2]);
  return result.join(',');
  }

console.log(h([1,2,3,4,5,6]));

//9

function amountTocoins(amount, coins) {
  if (amount === 0) {
    return [];
    } else {
      if (amount >= coins[0]){
        left = (amount - coins[0]);
        return [coins[0]].concat( amountTocoins(left, coins) );
        } else {
          coins.shift();
          return amountTocoins(amount, coins);
        }
    }
} 
console.log(amountTocoins(46, [25, 10, 5, 2,1]));


//10

function binarySearch(tab, target){
  let first = 0;
  let last = tab.length - 1;
  while(first <= last) {
    let mid = Math.floor((first + last) / 2);
    if(target === tab[mid]) {
      console.log("Znaleziono, indeks: " + mid);
      return;
    }
    if(target > tab[mid]) {
      first = mid + 1;
    }
    if(target < tab[mid]) {
      last = mid - 1;
    }
  }
  console.log("Brak w tablicy");
}

let tab = [1,2,3,4,5,6,7,8,9,10,11,12,13,14];
binarySearch(tab, 4);

//11

const obiekt = {
    a: 'a',
    b: 'b',
    c: true,
    doSometh() {
      console.log('1');
    },
     doSometh2() {
      console.log('2');
    }
};

function showObiekt(obiekt) {
  console.log(obiekt.a);
  console.log(obiekt.b);
  console.log(obiekt.c);
  console.log(typeof(obiekt.a));
  console.log(typeof(obiekt.b));
  console.log(typeof(obiekt.c));
}

showObiekt(obiekt);

//12

function Student(name, surname, index, tab) {
 this.name = name;
 this.surname = surname;
 this.index = index;
 this.tab = tab;
 console.log(this.name + ' ' + this.surname + ' ' + this.index);
}

//13

function StudentInfo(student) {
  console.log(student.name + ' ' + student.surname + ' ' + student.index);
  var sum = 0;
  for( var i = 0; i < student.tab.length; i++ ){
    sum += parseInt( student.tab[i], 10 );
  }

  var avg = sum/student.tab.length;
  console.log(avg);
}

var student = new Student('Adam','PaŸ','s15269', [3,4,5,4,5,4]);
StudentInfo(student);