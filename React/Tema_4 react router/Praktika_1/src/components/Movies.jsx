import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function Movies() {
  //steitai
  const [data, setData] = useState([]);
  const [isAddMovieModalOpen, setIsAddMovieModalOpen] = useState(false);
  const [isUpdateMovieModalOpen, setIsUpdateMovieModalOpen] = useState(false);
  const [AddMovieFormData, setAddMovieFormData] = useState({
    title: "",
    director: "",
    yearRelease: "",
    lengthMinutes: "",
  });
  //modalai
  const handleAddNewMovieButtonClick = () => {
    setIsAddMovieModalOpen(true);
  };

  const handleUpdateMovieButtonClick = () => {
    setIsUpdateMovieModalOpen(true);
  };
  //fetchas movies rodymui
  const fetchData = async () => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    const response = await fetch("http://localhost:8080/movies", {
      headers: headers,
    });

    const data = await response.json();
    setData(data);
  };
  //efektas
  useEffect(() => {
    fetchData();
  }, []);
  //delete movie funckija
  const deleteMovie = async (id) => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    await fetch(`http://localhost:8080/movies/${id}`, {
      method: "DELETE",
      headers: headers,
    });

    fetchData();
  };
  //submit addMovie handleris
  const handleAddMovieSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/movies", {
        method: "POST",
        headers: {
          Authorization: "Basic " + btoa("Marius123465" + ":" + "123456544"),
          "Content-Type": "application/json",
        },
        body: JSON.stringify(AddMovieFormData),
      });

      if (!response.ok) {
        throw new Error("Failed to add movie");
      }

      setAddMovieFormData({
        title: "",
        director: "",
        yearRelease: "",
        lengthMinutes: "",
      });
      setIsAddMovieModalOpen(false);

      fetchData();
    } catch (error) {
      console.error("Error adding movie:", error);
    }
  };
  //udateMovie submit handleris
  const handleUpdateMovieSubmit = () => {};
  //fieldu papildymas
  const AddMovieHandleChange = (fieldChangeEvent) => {
    setAddMovieFormData({
      ...AddMovieFormData,
      [fieldChangeEvent.target.name]: fieldChangeEvent.target.value,
    });
  };

  return (
    //Movies lentele
    <div className="container container-centered">
      <table className="table border border-primary">
        <thead className="thead-dark">
          <tr>
            <th
              scope="col"
              className="bg-primary"
            >
              Id
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Title
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Director
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Year of release
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Length of minutes
            </th>
            <th
              scope="col"
              className="bg-primary"
            ></th>
            <th
              scope="col"
              className="bg-primary"
            ></th>
            <th
              scope="col"
              className="bg-primary"
            ></th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.title}</td>
              <td>{item.director}</td>
              <td>{item.yearRelease}</td>
              <td>{item.lengthMinutes}</td>
              <td>
                <button
                  onClick={() => deleteMovie(item.id)}
                  className="btn btn-primary btn-lg btn-block"
                >
                  DELETE
                </button>
              </td>
              <td>
                <button
                  onClick={() => {
                    handleAddNewMovieButtonClick();
                  }}
                  className="btn btn-primary btn-lg btn-block"
                >
                  ADD NEW MOVIE
                </button>
              </td>
              <td>
                <button
                  onClick={() => {
                    handleUpdateMovieButtonClick();
                  }}
                  className="btn btn-primary btn-lg btn-block"
                >
                  UPDATE MOVIE
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <div className="AddMovie">
        {isAddMovieModalOpen && (
          <div
            className="modal"
            style={{ display: "block" }}
          >
            <div
              className="modal-content"
              style={{
                width: "75%",
                margin: "auto",
                marginTop: "200px",
                padding: "20px",
              }}
            >
              <span
                className="close"
                onClick={() => setIsAddMovieModalOpen(false)}
              >
                &times;
              </span>

              <form onSubmit={handleAddMovieSubmit}>
                <label>
                  Title
                  <br />
                  <input
                    type="text"
                    name="title"
                    value={AddMovieFormData.title}
                    onChange={AddMovieHandleChange}
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Director
                  <br />
                  <input
                    type="text"
                    name="director"
                    value={AddMovieFormData.director}
                    onChange={AddMovieHandleChange}
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Year of Release
                  <br />
                  <input
                    type="date"
                    name="yearRelease"
                    value={AddMovieFormData.yearRelease}
                    onChange={AddMovieHandleChange}
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Length
                  <br />
                  <input
                    type="number"
                    name="lengthMinutes"
                    value={AddMovieFormData.lengthMinutes}
                    onChange={AddMovieHandleChange}
                  />
                </label>
                <br />
                <br />
                <br />
                <button
                  onClick={() => setIsAddMovieModalOpen(false)}
                  className="btn btn-primary btn-lg"
                  type="submit"
                >
                  Add new movie
                </button>
              </form>
            </div>
          </div>
        )}
      </div>
      <div className="UpdateMovie">
        {isUpdateMovieModalOpen && (
          <div
            className="modal"
            style={{ display: "block" }}
          >
            <div
              className="modal-content"
              style={{
                width: "75%",
                margin: "auto",
                marginTop: "200px",
                padding: "20px",
              }}
            >
              <span
                className="close"
                onClick={() => setIsUpdateMovieModalOpen(false)}
              >
                &times;
              </span>

              <form onSubmit={handleUpdateMovieSubmit}>
                <label>
                  Update Title
                  <br />
                  <input
                    type="text"
                    name="title"
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Update Director
                  <br />
                  <input
                    type="text"
                    name="director"
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Update Year Of Release
                  <br />
                  <input
                    type="text"
                    name="yearRelease"
                  />
                </label>
                <br />
                <br />
                <br />
                <label>
                  Update Length
                  <br />
                  <input
                    type="text"
                    name="lengthMinutes"
                  />
                </label>
                <br />
                <br />
                <br />
              </form>
              <button
                onClick={() => setIsUpdateMovieModalOpen(false)}
                className="btn btn-primary btn-lg"
                type="submit"
              >
                Update Movie
              </button>
            </div>
          </div>
        )}
      </div>
      <br />
    </div>
  );
}

export default Movies;
