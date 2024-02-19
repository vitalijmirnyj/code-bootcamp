import "./App.css";

import Container from "./components/Container";
import "bootstrap/dist/css/bootstrap.min.css";
import PostsList from "./components/PostsList";
function App() {
  return (
    <>
      <div className="container border border-2">
        <PostsList />
      </div>
    </>
  );
}

export default App;
