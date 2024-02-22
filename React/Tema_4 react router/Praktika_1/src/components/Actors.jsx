import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function Actors() {
  const [data, setData] = useState([]);
  const fetchData = async () => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    const response = await fetch("http://localhost:8080/actors", {
      headers: headers,
    });

    const data = await response.json();
    setData(data);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <table class="table">
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
              Name
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Surname
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Gender
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Age
            </th>
            <th
              scope="col"
              className="bg-primary"
            >
              Nationality
            </th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.surname}</td>
              <td>{item.gender}</td>
              <td>{item.age}</td>
              <td>{item.nationality}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <br></br>
    </div>
  );
}

export default Actors;
