package lt.techin.demo.models;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DirectorMovieId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Director_id")

    private Director director;

    @ManyToOne
    @JoinColumn(name = "Movie_id")

    private Movie movie;


    public DirectorMovieId(Director director, Movie movie) {
        this.director = director;
        this.movie = movie;

    }

    public Director getDirector() {
        return director;
    }


    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public DirectorMovieId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorMovieId that = (DirectorMovieId) o;
        return Objects.equals(director, that.director) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, movie);
    }
}
