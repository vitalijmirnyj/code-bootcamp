import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function AddMovieModal({ isOpen, onClose, onSubmit }) {
  const [formData, setFormData] = useState({
    title: "",
    director: "",
    yearRelease: "",
    lengthMinutes: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <div
      className={`modal ${isOpen ? "show" : ""}`}
      style={{ display: isOpen ? "block" : "none" }}
    >
      <div
        className="modal-content"
        style={{
          width: "75%",
          margin: "auto",
          marginTop: "200px",
          padding: "20px",
        }}
      >
        <span
          className="close"
          onClick={onClose}
        >
          &times;
        </span>
        <form onSubmit={handleSubmit}>
          <label>
            Title
            <br />
            <input
              type="text"
              name="title"
              value={formData.title}
              onChange={handleChange}
            />
          </label>
          <br />
          <br />
          <br />
          <label>
            Director
            <br />
            <input
              type="text"
              name="director"
              value={formData.director}
              onChange={handleChange}
            />
          </label>
          <br />
          <br />
          <br />
          <label>
            Year of Release
            <br />
            <input
              type="date"
              name="yearRelease"
              value={formData.yearRelease}
              onChange={handleChange}
            />
          </label>
          <br />
          <br />
          <br />
          <label>
            Length
            <br />
            <input
              type="number"
              name="lengthMinutes"
              value={formData.lengthMinutes}
              onChange={handleChange}
            />
          </label>
          <br />
          <br />
          <br />
          <button
            className="btn btn-primary btn-lg"
            type="submit"
          >
            Add new movie
          </button>
        </form>
      </div>
    </div>
  );
}
