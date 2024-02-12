const buttonGeltona = document.querySelector(
  "div.border:nth-child(1) > button:nth-child(2)"
);
const paragraph1 = document.querySelector(
  "div.border:nth-child(1) > p:nth-child(1)"
);
buttonGeltona.addEventListener("click", function () {
  paragraph1.style.color = "yellow";
});

const buttonZalia = document.querySelector(
  "div.border:nth-child(1) > button:nth-child(3)"
);
buttonZalia.addEventListener("click", function () {
  paragraph1.style.color = "green";
});

const buttonRaudona = document.querySelector("button.btn:nth-child(4)");
buttonRaudona.addEventListener("click", function () {
  paragraph1.style.color = "red";
});
