import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Movie() {
  let { id } = useParams();
  const [data, setData] = useState(null);

  const fetchData = async () => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    const response = await fetch(`http://localhost:8080/movies/${id}`, {
      headers: headers,
    });

    const movieData = await response.json();
    setData(movieData);
  };

  useEffect(() => {
    fetchData();
  }, [id]);

  return (
    <div className="container">
      <table className="table border border-primary">
        <thead className="thead-dark">
          <tr>
            <th
              scope="col"
              className="bg-primary"
            >
              ID
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
              Year of Release
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Length (minutes)
            </th>
          </tr>
        </thead>
        <tbody>
          {data && (
            <tr key={data.id}>
              <td>{data.id}</td>
              <td>{data.title}</td>
              <td>{data.director}</td>
              <td>{data.yearRelease}</td>
              <td>{data.lengthMinutes}</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Movie;
