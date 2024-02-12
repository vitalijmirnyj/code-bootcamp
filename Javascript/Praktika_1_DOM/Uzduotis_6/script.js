const image = document.querySelector("#logo");
const container = document.querySelector(".container");
const lastChild = container.lastElementChild;
const buttonLeft = document.querySelector("#Left");
const buttonRight = document.querySelector("#Right");
const buttonHide = document.querySelector("#Hide");
let originalDisplay = "";
originalDisplay = window.getComputedStyle(image).display;
const buttonBellowParagraph = document.querySelector("#BellowParagraph");
const buttonReset = document.querySelector("#Reset");
let initialPosition = null;
const initialPositionTop = image.getBoundingClientRect().top;

buttonLeft.addEventListener("click", function () {
  image.style.position = "relative";
  image.style.left = "-500px";
  image.style.display = originalDisplay;
});

buttonRight.addEventListener("click", function () {
  image.style.position = "relative";
  image.style.left = "500px";
  image.style.display = originalDisplay;
});

buttonHide.addEventListener("click", function () {
  image.style.display = "none";
});

buttonBellowParagraph.addEventListener("click", function () {
  container.insertBefore(image, null);
});

buttonReset.addEventListener("click", function () {
  image.removeAttribute("style");
  image.style.removeProperty("left");
  image.style.removeProperty("display");
});
