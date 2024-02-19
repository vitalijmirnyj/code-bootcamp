import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./TextBox.css";

export default function textBox() {
  let readMore = " ...read more";
  const [textBox1, setTextBox1] = useState(
    "Focused, hard work is the real key"
  );
  const [textBox2, setTextBox2] = useState(
    "Winners embrace hard work. They love"
  );
  function changeTextBox1() {
    setTextBox1(
      "Focused, hard work is the real key. Achievement hinges on dedicated, diligent effort. Success is attained through concentrated, determined labor. The cornerstone of accomplishment is unwavering, industrious dedication. Focused and persistent work is the ultimate determinant of success. Without a doubt, focused, hard work remains paramount in any pursuit. It serves as the bedrock upon which success is built. Those who embrace this ethos invariably find themselves on the path to greatness. In the face of challenges, perseverance coupled with diligent effort becomes indispensable. Ultimately, it is the disciplined execution of tasks that separates the achievers from the dreamers."
    );
  }

  function changeTextBox2() {
    setTextBox2(
      "Winners embrace hard work. They love challenges, striving relentlessly towards their goals. Dedication fuels their journey, propelling them forward. With each obstacle, they find opportunity to grow stronger. Their passion for excellence drives them to surpass expectations. In the pursuit of victory, hard work is their faithful companion."
    );
  }

  return (
    <div>
      <p>
        {textBox1}
        <span
          className="custom-underline"
          onClick={changeTextBox1}
        >
          {readMore}
        </span>
      </p>

      <p>
        {textBox2}
        <span
          className="custom-underline"
          onClick={changeTextBox2}
        >
          {readMore}
        </span>
      </p>
    </div>
  );
}
