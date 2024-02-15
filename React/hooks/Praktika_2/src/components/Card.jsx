import "./Card.css";
import { useState } from "react";

export default function Card() {
  const [likeCount, setLikeCount] = useState(0);
  const [HateCount, setHateCount] = useState(0);

  const changeLikeCount = () => {
    setLikeCount(likeCount + 1);
  };

  const changeHateCount = () => {
    setHateCount(HateCount + 1);
  };

  const reset = () => {
    setLikeCount(0);
    setHateCount(0);
  };

  return (
    <div className="card">
      <img
        src="https://miro.medium.com/v2/resize:fit:3840/1*hm7aE3BdUfUWUgBYK1GiZA.jpeg"
        alt="react logo"
        className="react__logo"
      />
      <div className="card-body ">
        <h1>Post</h1>
        <h5 className="card-title"></h5>
        <p className="card-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Ex fugit
          numquam aliquam cum adipisci culpa facere, eum, incidunt debitis
          dolor, aliquid optio sunt blanditiis! Necessitatibus quos repellendus
          veritatis aperiam corporis! Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Ex fugit numquam aliquam cum adipisci culpa facere,
          eum, incidunt debitis dolor, aliquid optio sunt blanditiis!
          Necessitatibus quos repellendus veritatis aperiam corporis!
        </p>
        <button
          className="btn__1"
          onClick={changeLikeCount}
        >
          Like {likeCount}
        </button>
        <button
          className="btn__2"
          onClick={changeHateCount}
        >
          Hate {HateCount}
        </button>
        <button
          className="btn__3"
          onClick={reset}
        >
          Reset
        </button>
      </div>
    </div>
  );
}
