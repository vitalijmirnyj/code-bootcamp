import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Actor() {
  let { id } = useParams();
  const [data, setData] = useState(null);

  const fetchData = async () => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    const response = await fetch(`http://localhost:8080/actors/${id}`, {
      headers: headers,
    });

    const actorData = await response.json();
    setData(actorData);
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
              Nationality
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
          </tr>
        </thead>
        <tbody>
          {data && (
            <tr key={data.id}>
              <td>{data.id}</td>
              <td>{data.name}</td>
              <td>{data.surname}</td>
              <td>{data.nationality}</td>
              <td>{data.gender}</td>
              <td>{data.age}</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Actor;
