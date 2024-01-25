package lt.techin.demo.controllers;

import lt.techin.demo.Services.MovieService;
import lt.techin.demo.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.movieService.findAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return this.movieService.findMovieById(id);
    }

    @PostMapping("/movies")
    public Movie insertMovie(@RequestBody Movie movie) {
        return this.movieService.saveMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        if (this.movieService.existsById(id)) {
            Movie movieFromDb = this.movieService.findMovieById(id);
            movieFromDb.setTitle(movie.getTitle());
            movieFromDb.setDirector(movie.getDirector());
            movieFromDb.setYearRelease(movie.getYearRelease());
            movieFromDb.setLengthMinutes(movie.getLengthMinutes());
            return this.movieService.saveMovie(movieFromDb);
        }

        return this.movieService.saveMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable long id) {
        this.movieService.deleteMovieById(id);
    }
}

