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
import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;


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
        Movie savedMovie2 = this.movieRepository.save(new Movie("Toy Story 4", "John M", (short) 1995, (short) 120));
        List<Movie> movies = this.movieService.findAllMovies();
        then(movies.get(0).getTitle()).isEqualTo(savedMovie1.getTitle());
        then(movies.get(0).getDirector()).isEqualTo(savedMovie1.getDirector());
        then(movies.get(0).getYearRelease()).isEqualTo(savedMovie1.getYearRelease());
        then(movies.get(0).getLengthMinutes()).isEqualTo(savedMovie1.getLengthMinutes());

        then(movies.get(1).getTitle()).isEqualTo(savedMovie2.getTitle());
        then(movies.get(1).getDirector()).isEqualTo(savedMovie2.getDirector());
        then(movies.get(1).getYearRelease()).isEqualTo(savedMovie2.getYearRelease());
        then(movies.get(1).getLengthMinutes()).isEqualTo(savedMovie2.getLengthMinutes());
    }

}
