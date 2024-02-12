const container = document.querySelector(".container");
const paragraph = document.querySelector(".container > p:nth-child(1)");
const heading = document.createElement("h1");
heading.textContent = "Pavadinimas";

const button = document.querySelector("#button");

button.addEventListener("click", function () {
  container.insertBefore(heading, paragraph);
});
