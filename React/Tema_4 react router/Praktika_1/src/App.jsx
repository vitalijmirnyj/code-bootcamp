import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";

function App() {
  return (
    <BrowserRouter>
      <div>
        <ul>
          <li>
            <a href="/movies">Movies</a>
          </li>
          <li>
            <a href="/actors">Actors</a>
          </li>
        </ul>
      </div>

      <Routes>
        <Route
          path="/movies"
          element={<Movies />}
        />
        <Route
          path="/actors"
          element={<Actors />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
