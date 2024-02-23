import React, { useEffect, useState } from "react";

export default function useEffectFetchData() {
  const [data, setData] = useState([]);
  const [choice, setChoice] = useState("");

  const fetchData = async () => {
    const headers = new Headers();
    headers.set(
      "Authorization",
      "Basic " + btoa("Marius123465" + ":" + "123456544")
    );

    const response = await fetch(`/${choice}`, {
      headers: headers,
    });

    const data = await response.json();
    setData(data);
  };

  useEffect(() => {
    fetchData();
  }, [choice]);

  return (
    <div>
      <button onClick={() => setChoice("movies")}>Movies</button> Show all
      movies
      <button onClick={() => setChoice("directors")}>Directors</button> Show all
      directors
      {choice === "movies" && (
        <div>
          {data.map((item) => (
            <div key={item.id}>
              <p>{item.id}</p>
              <p>{item.title}</p>
            </div>
          ))}
          <p></p>
        </div>
      )}
      {choice === "directors" && (
        <div>
          {data.map((item) => (
            <div key={item.director_id}>
              <p>{item.director_id}</p>
              <p>{item.nationality}</p>
            </div>
          ))}
          <p></p>
        </div>
      )}
    </div>
  );
}
