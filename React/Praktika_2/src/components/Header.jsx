import "./Header.css";

export default function Header() {
  return (
    <div className="header text-start">
      <h1 className="header_title">Welcome to my page</h1>
      <img
        src="https://r4.wallpaperflare.com/wallpaper/586/603/742/minimalism-4k-for-mac-desktop-wallpaper-08165d58e0100cf8e0ec214e88e2e4aa.jpg"
        alt="lake and sunset"
        className="header__img w-100 object-fit-cover mb-5"
      />
    </div>
  );
}
