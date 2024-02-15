import PostContent from "./PostContent";

function PostList() {
  let posts = [
    {
      title: "HTML",
      content: "Lorem ipusm HTML",
      img: "https://images.pexels.com/photos/20153996/pexels-photo-20153996/free-photo-of-man-in-hat-and-checkered-trousers-lying-down-on-concrete-blocks.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
    },
    {
      title: "HTML",
      content: "Lorem ipusm HTML",
      img: "https://images.pexels.com/photos/11517781/pexels-photo-11517781.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
    },
    {
      title: "HTML",
      content: "Lorem ipusm HTML",
      img: "https://images.pexels.com/photos/1249580/pexels-photo-1249580.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
    },
  ];

  let list = posts.map((post) => {
    return (
      <PostContent
        title={post.title}
        content={post.content}
        img={post.img}
      />
    );
  });
  return <div>{list}</div>;
}

export default PostList;
