package lt.techin.demo.Services;

import java.util.List;

import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return this.movieRepository.findAll();
    }

    public Movie findMovieById(long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }

    public Movie saveMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public void deleteMovieById(long id) {
        this.movieRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return this.movieRepository.existsById(id);
    }
}
