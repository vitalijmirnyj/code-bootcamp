import React from "react";
import { useForm } from "react-hook-form";

export default function MyForm() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    console.log(data);

    const postData = async () => {
      const send = await fetch("http://localhost:8080/actors", {
        method: "POST",
        headers: {
          Authorization: "Basic " + btoa("Marius123465:123456544"),
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });
    };
    postData();
  };

  return (
    <div>
      <p>Post to Actors:</p>
      <br />
      <form onSubmit={handleSubmit(onSubmit)}>
        <p></p>
        Gender:
        <input {...register("gender")} />
        Age:
        <input
          type="number"
          {...register("age")}
        />
        Nationality:
        <input {...register("nationality")} />
        Name:
        <input {...register("name")} />
        Surname:
        <input {...register("surname")} />
        <input type="submit" />
      </form>
    </div>
  );
}
