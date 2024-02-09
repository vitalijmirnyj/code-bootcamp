//1.
let numberOfDays;
function daysInHoursAndMinutes(numberOfDays) {
  let hours;
  let minutes;
  hours = numberOfDays * 24;
  minutes = hours * 60;
  console.log(hours);
  console.log(minutes);
}

//2.
/*let x;
function valueOfY(x) {
    let y;
    y = ((16 * x) ** 4) + (2 * x);
    console.log(y);
}

//2.(with Math.pow)
*/
let x;
function valueOfY(x) {
  let y;
  y = Math.pow(16, 4) + 2 * x;
  console.log(y);
}

//3.
function EvenOrOdd(number) {
  if (number % 2 === 0) {
    console.log("Number is Even");
  } else {
    console.log("Number is Odd");
  }
}

//.4
let number1;
let number2;

function findBiggerOfTwoNumbers(number1, number2) {
  if (number1 > number2 && number1 != number2) {
    return number1;
  } else {
    return number2;
  }
}

//5.

//6.

function BodyIndex(height, weight) {
  bmi = weight / height ** 2;
  if (bmi < 18.5) {
    console.log("Nepakankamas svoris");
  } else if (bmi >= 18.5 && bmi < 25) {
    console.log("Normalus svoris");
  } else if (bmi >= 25 && bmi < 30) {
    console.log("Antsvoris");
  } else {
    console.log("Nutukimas");
  }
}
