import React, { useEffect, useState } from "react";

export default function useEffectFetchData() {
  const [data, setData] = useState([]);
  const [choice, setChoice] = useState("");

  const fetchData = async () => {
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/${choice}`
    );
    const data = await response.json();
    setData(data);
  };

  useEffect(() => {
    fetchData();
  }, [choice]);

  return (
    <div>
      <button onClick={() => setChoice("posts")}>Posts</button>--- 100 posts
      <button onClick={() => setChoice("comments")}>Comments</button>--- 500
      comments
      {choice === "posts" && (
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
      {choice === "comments" && (
        <div>
          {data.map((item) => (
            <div key={item.id}>
              <p>{item.id}</p>
              <p>{item.name}</p>
              <p>{item.email}</p>
            </div>
          ))}
          <p></p>
        </div>
      )}
    </div>
  );
}
