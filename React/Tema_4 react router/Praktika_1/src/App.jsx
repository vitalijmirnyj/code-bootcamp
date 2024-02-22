import { BrowserRouter, Routes, Route, NavLink } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";
import ErrorPage from "./components/ErrorPage";

function App() {
  return (
    <>
      <div className="container">
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
        <Route
          path="*"
          element={<ErrorPage />}
        />
      </Routes>
    </>
  );
}

export default App;
