import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./TextBox.css";

export default function textBox({ text, maxLength }) {
  const [displayText, setDisplayText] = useState(text.substring(0, maxLength));
  const changeText = () => {
    setDisplayText(text);
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
    </div>
  );
}
