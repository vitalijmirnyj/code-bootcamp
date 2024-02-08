package lt.techin.demo.controllers;

import lt.techin.demo.models.*;
import lt.techin.demo.repositories.DirectorMovieRepository;
import lt.techin.demo.services.DirectorMovieService;
import lt.techin.demo.services.DirectorService;
import lt.techin.demo.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorMovieController {

    private final DirectorMovieService directorMovieService;
    private final DirectorService directorService;
    private final MovieService movieService;

    public DirectorMovieController(DirectorMovieService directorMovieService,
                                   DirectorService directorService, MovieService movieService) {
        this.directorMovieService = directorMovieService;
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @GetMapping("/directorsmovies")
    public List<DirectorMovie> getDirectorsMovies() {
        return this.directorMovieService.findAllDirectorsMovies();
    }

    @GetMapping("/directors/{directorId}/movies/{movieId}")
    public DirectorMovie getDirectorMovie(@PathVariable("directorId") long directorId,
                                          @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        return this.directorMovieService.findDirectorMovieById(directorMovieId);

    }

    @PostMapping("/directorsmovies")
    public DirectorMovie insertDirectorMovie(@RequestBody DirectorMovie directorMovie) {
        return this.directorMovieService.saveDirectorMovie(directorMovie);
    }

    @DeleteMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<Void> deleteDirectorMovie(@PathVariable("directorId") long directorId,
                                                    @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);
        if (this.directorMovieService.existsDirectorMovieById(directorMovieId)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieId);
            return ResponseEntity.ok().build();
        }
        this.directorMovieService.deleteDirectorMovieById(directorMovieId);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<DirectorMovie> updateDirectorMovie(@PathVariable("directorId") long directorId,
                                                             @PathVariable("movieId") long movieId,
                                                             @RequestBody DirectorMovie directorMoviePayLoad) {
        Director directorFromDb = this.directorService.findDirectorById(directorId);
        Movie movieFromDb = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieIdPayLoad = new DirectorMovieId(directorFromDb, movieFromDb);
        if (this.directorMovieService.existsDirectorMovieById(directorMovieIdPayLoad)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieIdPayLoad);

            return ResponseEntity.ok(this.directorMovieService.saveDirectorMovie(directorMoviePayLoad));
        }
        return ResponseEntity.notFound().build();
    }

}