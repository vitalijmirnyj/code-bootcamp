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
        <input
          {...register("gender", {
            required: true,
            minLength: 3,
          })}
        />
        {errors?.gender?.type === "required" && <p>This field is required</p>}
        {errors?.gender?.type === "minLength" && (
          <p>Must be more than 3 characters</p>
        )}
        Age:
        <input
          type="number"
          {...register("age", {
            required: true,
            min: 1,
            max: 125,
          })}
        />
        {errors?.age?.type === "required" && <p>This field is required</p>}
        {errors?.age?.type === "min" && <p>Must be at least 1 year old</p>}
        {errors?.age?.type === "max" && (
          <p>Must be not older than 125 years old</p>
        )}
        Nationality:
        <input
          {...register("nationality", {
            required: true,
            minLength: 2,
          })}
        />
        {errors?.nationality?.type === "required" && (
          <p>This field is required</p>
        )}
        {errors?.nationality?.type === "minLength" && (
          <p>Must be more than 3 characters</p>
        )}
        Name:
        <input
          {...register("name", {
            required: true,
            minLength: 2,
          })}
        />
        {errors?.name?.type === "required" && <p>This field is required</p>}
        {errors?.name?.type === "minLength" && (
          <p>Must be more than 3 characters</p>
        )}
        Surname:
        <input
          {...register("surname", {
            required: true,
            minLength: 3,
          })}
        />
        {errors?.surname?.type === "required" && <p>This field is required</p>}
        {errors?.surname?.type === "minLength" && (
          <p>Must be more than 3 characters</p>
        )}
        <input type="submit" />
      </form>
    </div>
  );
}
