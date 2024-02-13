const sumForm = document.forms["form"];
const sum = 0;
let textContainer = document.getElementById("textContainer1");
const button = document.querySelector("#button1");

sumForm.addEventListener("submit", function (e) {
  e.preventDefault();
  const submittedfirstNumber = parseInt(
    document.getElementsByName("firstNumber")[0].value
  );
  const submittedsecondNumber = parseInt(
    document.getElementsByName("secondNumber")[0].value
  );
  const sum = submittedfirstNumber + submittedsecondNumber;
  textContainer.textContent = sum;
});
