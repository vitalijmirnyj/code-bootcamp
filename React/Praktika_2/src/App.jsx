import Header from "./components/Header";
import Box from "./components/Box";
import PostContent from "./components/PostContent";
import PostImage from "./components/PostImage";

function App() {
  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <Header />
        </div>
      </div>

      <div className="row">
        <div className="col-6">
          <PostImage />
        </div>

        <div className="col-6">
          <PostImage />
        </div>
      </div>

      <div className="row">
        <div className="col-6">
          <PostContent />
        </div>

        <div className="col-6">
          <PostContent />
        </div>
      </div>

      <div className="row">
        <div className="col-3">
          <Box />
        </div>
        <div className="col-3">
          <Box />
        </div>
        <div className="col-3">
          <Box />
        </div>
        <div className="col-3">
          <Box />
        </div>
      </div>
    </div>
  );
}

export default App;
