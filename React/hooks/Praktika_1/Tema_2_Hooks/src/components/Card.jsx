import "./Card.css";
import { useState } from "react";

export default function Card() {
  const [btnPressed, setBtnPressed] = useState(false);
  function changeBtnPressed() {
    setBtnPressed(true);
  }

  return (
    <div
      className="card"
      style={{ width: "18rem" }}
    >
      <div className="card-body ">
        <h5 className="card-title">
          {btnPressed ? "Task is done!" : "Task is not done!"}
        </h5>
        <p className="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </p>
        <button
          className={`btn ${btnPressed ? "btn-green" : ""}`}
          onClick={changeBtnPressed}
        >
          {btnPressed ? "Done" : "Mark as done"}
        </button>
      </div>
    </div>
  );
}
