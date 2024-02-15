import "./PostImage.css";

function PostImage(props) {
  return (
    <div>
      <img
        src={props.url}
        alt="family celebrating"
        className="header__img img-fluid"
      />
      <br />
      <br />
    </div>
  );
}

export default PostImage;
