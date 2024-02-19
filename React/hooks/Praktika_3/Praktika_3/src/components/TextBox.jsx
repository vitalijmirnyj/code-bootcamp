import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./TextBox.css";

export default function textBox({ text, maxLength, text2, maxLength2 }) {
  const [displayText, setDisplayText] = useState(text.substring(0, maxLength));
  const changeText = () => {
    setDisplayText(text);
  };
  const [displayText2, setDisplayText2] = useState(
    text2.substring(0, maxLength2)
  );
  const changeText2 = () => {
    setDisplayText2(text2);
  };

  return (
    <div>
      {displayText}
      <a
        href="#"
        onClick={changeText}
      >
        ...read more
      </a>
      <p></p>
      {displayText2}
      <a
        href="#"
        onClick={changeText2}
      >
        ...read more
      </a>
    </div>
  );
}
