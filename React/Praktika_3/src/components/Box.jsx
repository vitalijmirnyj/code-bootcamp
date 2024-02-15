import "./Box.css";

const Box = (props) => {
  return (
    <div>
      <div
        className="box"
        style={{ backgroundColor: props.color }}
      />
    </div>
  );
};

export default Box;
