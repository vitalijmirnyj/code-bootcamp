package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;


import java.time.LocalDate;
import java.util.NoSuchElementException;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = this.movieRepository.save(new Movie("Toy Story 3", "John Malkovich", LocalDate.of(1991, 10, 10), (short) 120));
        Movie foundMovie = this.movieService.findMovieById(savedMovie1.getId());
        then(foundMovie).isEqualTo(savedMovie1);
    }

    @Test
    void findMovieById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.movieService.findMovieById(1));
        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveMovie() {

        Movie savedMovie = this.movieService.saveMovie(new Movie("Toy Story 3", "John Malkovich", LocalDate.of(1991, 10, 10), (short) 120));

        Movie foundMovie = this.movieRepository.findById(savedMovie.getId()).orElse(null);
        then(savedMovie).isEqualTo(foundMovie);

    }

    @Test
    void existsMovieById_CheckIfExists_ReturnTrue() {
        Movie savedMovie = this.movieRepository.save(new Movie("Toy Story 3", "John Malkovich", LocalDate.of(1991, 10, 10), (short) 120));
        boolean existsMovie = this.movieService.existsById(savedMovie.getId());
        then(existsMovie).isTrue();
    }

    @Test
    void deleteMovieById_delete_cannotFind() {
        Movie savedMovie = this.movieRepository.save(new Movie("Toy Story 3", "John Malkovich", LocalDate.of(1991, 10, 10), (short) 120));
        this.movieService.deleteMovieById(savedMovie.getId());
        then(this.movieRepository.existsById(savedMovie.getId())).isFalse();
    }
}
