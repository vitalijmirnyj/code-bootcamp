import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function Movies() {
  const [data, setData] = useState([]);
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

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div
      className="container"
      style={{ borderRadius: "20px", overflow: "hidden" }}
    >
      <table class="table border border-primary">
        <thead class="thead-dark">
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
            </tr>
          ))}
        </tbody>
      </table>
      <br></br>
    </div>
  );
}

export default Movies;
