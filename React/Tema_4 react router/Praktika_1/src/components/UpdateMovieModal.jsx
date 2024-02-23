import React from "react";

const UpdateMovieModal = ({
  handleUpdateMovieSubmit,
  setIsUpdateMovieModalOpen,
}) => {
  return (
    <div
      className="modal"
      style={{ display: "block" }}
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
          onClick={() => setIsUpdateMovieModalOpen(false)}
        >
          &times;
        </span>
        <form onSubmit={handleUpdateMovieSubmit}>
          <button
            className="btn btn-primary btn-lg"
            type="submit"
          >
            Update Movie
          </button>
        </form>
      </div>
    </div>
  );
};

export default UpdateMovieModal;
