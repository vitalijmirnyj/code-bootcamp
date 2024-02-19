import "./App.css";
import TextBox from "./components/TextBox";
import "bootstrap/dist/css/bootstrap.min.css";
function App() {
  return (
    <>
      <div className="container border border-2">
        <TextBox
          text="Focused, hard work is the real key. Achievement hinges on dedicated, diligent effort. Success is attained through concentrated, determined labor. The cornerstone of accomplishment is unwavering, industrious dedication. Focused and persistent work is the ultimate determinant of success. Without a doubt, focused, hard work remains paramount in any pursuit. It serves as the bedrock upon which success is built. Those who embrace this ethos invariably find themselves on the path to greatness. In the face of challenges, perseverance coupled with diligent effort becomes indispensable. Ultimately, it is the disciplined execution of tasks that separates the achievers from the dreamers."
          maxLength={35}
        />
        <TextBox
          text="Winners embrace hard work. They love the challenge of pushing their limits and surpassing their goals. With each obstacle they overcome, their determination grows stronger. Every setback is seen as an opportunity to learn and improve. They understand that success is not just about talent, but about perseverance and resilience."
          maxLength={27}
        />
      </div>
    </>
  );
}

export default App;
