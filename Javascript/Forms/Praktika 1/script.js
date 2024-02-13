const guessNumberForm = document.forms["form"];
let countOfGuesses = 0;
let textContainer = document.getElementById("textContainer1");
const textContainer3 = document.getElementById("textContainer3");
const randomNumber = Math.floor(Math.random() * 101);
guessNumberForm.addEventListener("submit", function (e) {
  e.preventDefault();
  const submittedNumber = parseInt(document.getElementById("number").value);

  if (submittedNumber < 0 || submittedNumber > 100) {
    textContainer = document.getElementById("textContainer2");
    textContainer.textContent = "Number out of range";
  } else {
    if (submittedNumber === randomNumber) {
      textContainer3.textContent = "Correct!";
    } else if (submittedNumber > randomNumber) {
      textContainer3.textContent = "Number is smaller";
    } else {
      textContainer3.textContent = "Number is bigger";
    }
    countOfGuesses++;
    textContainer = document.getElementById("textContainer1");
    textContainer.textContent = `${countOfGuesses} guesses were done`;
  }
});
