import "./Card.css";
import { useState } from "react";

export default function Card() {
  const [text, setText] = useState("Task is not done!");
  const [btnText, setBtnText] = useState("Mark as done");
  const [btnColor, setBtnColor] = useState("red");

  const changeText = () => {
    setText("Task is done!");
  };
  const changebtnText = () => {
    setBtnText("Done");
  };
  const changeBtnColor = () => {
    setBtnColor("green");
  };
  return (
    <div
      className="card"
      style={{ width: "18rem" }}
    >
      <div className="card-body ">
        <h5 className="card-title">{text}</h5>
        <p className="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </p>
        <button
          className="btn"
          onClick={() => {
            changeText();
            changebtnText();
            changeBtnColor();
          }}
          style={{ backgroundColor: btnColor }}
        >
          {btnText}
        </button>
      </div>
    </div>
  );
}
