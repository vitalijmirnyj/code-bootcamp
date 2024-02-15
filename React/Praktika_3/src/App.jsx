import React from "react";
import Header from "./components/Header";
import Box from "./components/Box";
import PostContent from "./components/PostContent";
import PostImage from "./components/PostImage";

function App() {
  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <Header
            title="Labas aš mokausi"
            url="../images/01.jpg"
          />
        </div>
      </div>

      <div className="row">
        <div className="col-6">
          <PostImage url="../images/02.jpg" />
        </div>

        <div className="col-6">
          <PostImage url="../images/03.jpg" />
        </div>
      </div>

      <div className="row">
        <div className="col-6">
          <PostContent
            h3text="Hello world"
            ptext="Hello Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet expedita animi illum ducimus beatae optio, totam sapiente exercitationem, aut autem voluptates aperiam quam in facere quis rem iusto sequi at!"
          />
        </div>
        <div className="col-6">
          <PostContent
            h3text="Hello world"
            ptext="Hello Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet expedita animi illum ducimus beatae optio, totam sapiente exercitationem, aut autem voluptates aperiam quam in facere quis rem iusto sequi at!"
          />
        </div>
      </div>

      <div className="row">
        <div className="col-3">
          <Box color="red" />
        </div>
        <div className="col-3">
          <Box color="green" />
        </div>
        <div className="col-3">
          <Box color="blue" />
        </div>
        <div className="col-3">
          <Box color="yellow" />
        </div>
      </div>
    </div>
  );
}

export default App;
