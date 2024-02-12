const buttonSmaller = document.querySelector("#buttonSmaller");
const buttonBigger = document.querySelector("button.btn:nth-child(2)");

const image = document.querySelector("#logo");

buttonSmaller.addEventListener("click", function () {
  image.style.width = "200px";
  image.style.height = "auto";
});

buttonBigger.addEventListener("click", function () {
  image.style.width = "400px";
  image.style.height = "auto";
});
