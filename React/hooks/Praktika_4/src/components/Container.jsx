import "bootstrap/dist/css/bootstrap.min.css";
import "./Container.css";
export default function Container({
  id,
  title,
  content,
  img,
  setLearnt,
  status,
}) {
  console.log(img);
  return (
    <div className="col-4">
      <h2>{title}</h2>
      <img
        src={img}
        alt={title}
        className="img"
      />
      <p>{content}</p>
      <p>{status ? "Išmokau" : "Mokausi"}</p>
      <button onClick={() => setLearnt(id)}>OK</button>
    </div>
  );
}
