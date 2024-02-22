import React from "react";
import { BrowserRouter, Routes, Route, NavLink } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";

function App() {
  return (
    <>
      <div>
        <ul>
          <li>
            <NavLink to="/movies">Movies</NavLink>
          </li>
          <li>
            <NavLink to="/actors">Actors</NavLink>
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
    </>
  );
}

export default App;
