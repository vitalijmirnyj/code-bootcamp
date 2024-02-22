import React, { useEffect, useState } from "react";

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
    <div>
      {data.map((item) => (
        <div key={item.id}>
          <p>{item.id}</p>
          <p>{item.title}</p>
        </div>
      ))}
      <p></p>
    </div>
  );
}

export default Movies;
