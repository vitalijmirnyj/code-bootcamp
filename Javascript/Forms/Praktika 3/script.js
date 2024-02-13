const bodyMassIndex = document.forms["form1"];
let textContainer = document.getElementById("textContainer");
const button = document.querySelector(".btn");
let valueOfBodyMassIndex = 0;

bodyMassIndex.addEventListener("submit", function (e) {
  e.preventDefault();
  const submittedHeight = parseInt(
    document.getElementsByName("height")[0].value
  );
  const submittedWeight = parseInt(
    document.getElementsByName("weight")[0].value
  );

  valueOfBodyMassIndex = submittedWeight / (submittedHeight / 100) ** 2;
  const roundedBMI = Math.floor(valueOfBodyMassIndex);
  textContainer.textContent = roundedBMI;
});
