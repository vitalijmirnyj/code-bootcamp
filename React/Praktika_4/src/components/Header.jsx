import "./Header.css";

export default function Header(props) {
  return (
    <div className="header mb-3">
      <h1 className="header__title">{props.title}</h1>
      <img
        src={props.url}
        alt="happy dinner scene with smiling happy people"
        className="header__img w-100 h-25 object-fit-cover"
      />
    </div>
  );
}
