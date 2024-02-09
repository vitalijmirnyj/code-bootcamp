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

//7.
function weatherConditions(condition) {
  switch (condition) {
    case 1:
      console.log("Sauleta");
      break;
    case 2:
      console.log("Lietinga");
      break;
    case 3:
      console.log("Lietinga");
      break;
    case 4:
      console.log("Sniegas");
      break;
    default:
      console.log("Neaiskus oras");
      break;
  }
}

//8.
function timeOfYear(monthNumber) {
  switch (monthNumber) {
    case 1:
    case 2:
    case 12:
      console.log("Ziema");
      break;
    case 3:
    case 4:
    case 5:
      console.log("Pavasaris");
      break;
    case 6:
    case 7:
    case 8:
      console.log("Vasara");
      break;
    case 9:
    case 10:
    case 11:
      console.log("Ruduo");
      break;
  }
}

//9.
function everyNumberDivisibleFromFive() {
  for (let i = 0; i < 1000; i++) {
    if (i % 5 == 0) {
      console.log(i);
    }
  }
}

//10.
function allNumbersFrom0ToHundred() {
  for (i = 0; i <= 100; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
      console.log("FizzBuzz");
    } else if (i % 3 == 0) {
      console.log("Fizz");
    } else if (i % 5 == 0) {
      console.log("Buzz");
    }
  }
}

//11.
function functionWithinInterval() {
  for (let i = -5; i <= 5; i++) {
    if (i != 0) {
      value = 1 / i;
    }
    console.log(value);
  }
}

//12.
