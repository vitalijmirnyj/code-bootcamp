import React from "react";
import { useForm } from "react-hook-form";

export default function MyForm() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => console.log(data);

  console.log(watch("example"));

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input
        defaultValue="test"
        {...register("example", { minLength: 5 })}
      />
      {errors.example && errors.example.type === "minLength" && (
        <span>Input must be at least 5 characters long</span>
      )}

      <input {...register("exampleRequired", { required: true })} />
      {errors.exampleRequired && <span>This field is required</span>}
      <input type="submit" />
    </form>
  );
}
