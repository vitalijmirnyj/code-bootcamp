import { useState } from "react";
import Container from "./Container";
import data from "../data/list.json";

export default function PostsList() {
  console.log(data);
  const [posts, setPosts] = useState(data);

  const changeStatus = (id) => {
    const updatedPosts = posts.map((post) => {
      if (post.id === id) {
        return { ...post, status: true };
      }
      return post;
    });
    setPosts(updatedPosts);
  };

  const postsList = posts.map((post) => (
    <Container
      key={post.id}
      id={post.id}
      title={post.title}
      content={post.content}
      img={post.img}
      status={post.status}
      setLearnt={changeStatus}
    />
  ));

  return <div className="row">{postsList.length ? postsList : "Empty"}</div>;
}
