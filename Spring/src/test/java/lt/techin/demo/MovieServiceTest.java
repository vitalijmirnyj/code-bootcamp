package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.Services.MovieService;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.BDDAssumptions;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
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
        Movie savedMovie1 = this.movieRepository.save(new Movie("Toy Story 3", "John Malkovich", (short) 1995, (short) 120));
        Movie foundMovie = this.movieService.findMovieById(savedMovie1.getId());
        then(foundMovie).isEqualTo(savedMovie1);
    }

    @Test
    void findMovieById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.movieService.findMovieById(1));
        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

}
