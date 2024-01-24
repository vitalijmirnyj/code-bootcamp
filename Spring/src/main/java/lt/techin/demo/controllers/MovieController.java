package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }

    @PostMapping("/movies")
    public void insertMovie(@RequestBody Movie movie) {
        this.movieRepository.save(movie);
    }

    @PutMapping("/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        Movie movieFromDb = this.movieRepository.findById(id).orElseThrow();
        movieFromDb.setTitle(movie.getTitle());
        movieFromDb.setDirector(movie.getDirector());
        movieFromDb.setYearRelease(movie.getYearRelease());
        movieFromDb.setLengthMinutes(movie.getLengthMinutes());
        this.movieRepository.save(movieFromDb);
    }
}

