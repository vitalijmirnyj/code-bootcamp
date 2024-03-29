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
//Conditional
function findBiggerOfTwoNumbers(number1, number2) {
  if (number1 > number2 && number1 != number2) {
    return number1;
  } else {
    return number2;
  }
}

// Ternary operator
function findBiggerOfTwoNumbers(number1, number2) {
  let biggerNumber = number1 > number2 ? number1 : number2;
  console.log(biggerNumber);
}

//Using Math max
function findBiggerOfTwo(number1, number2) {
  let biggerNumber = Math.max(number1, number2);
  return biggerNumber;
}

//5.
function grade(points) {
  if (points <= 29) {
    console.log("Failed");
  } else if (points > 29 && points <= 34) {
    console.log("Your Grade is 1");
  } else if (points > 34 && points <= 39) {
    console.log("Your Grade is 2");
  } else if (points > 39 && points <= 44) {
    console.log("Your Grade is 3");
  } else if (points > 44 && points <= 49) {
    console.log("Your Grade is 4");
  } else {
    console.log("Your Grade is 5");
  }
}

//swtich with condition method

function grading(points) {
  switch (true) {
    case points < 29:
      console.log("Failed");
      break;
    case points > 29 && points <= 34:
      console.log("Grade 1");
      break;
    case points > 34 && points <= 39:
      console.log("Grade 2");
      break;
    case points > 39 && points <= 44:
      console.log("Grade 3");
      break;
    case points > 44 && points <= 49:
      console.log("Grade 4");
      break;
    case points > 49:
      console.log("Grade 5");
      break;
  }
}

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
function SumOfNumbers() {
  let sum = 0;
  for (let i = 1; i <= 5; i++) {
    sum = sum + i;
  }
  return sum;
}
