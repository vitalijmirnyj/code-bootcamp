package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.Services.MovieService;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = this.movieRepository.save(new Movie("Toy Story 3", "John Malkovich", (short) 1995, (short) 120));
        List<Movie> movies = this.movieService.findAllMovies();
        assertThat(movies.get(0).getTitle()).isEqualTo(savedMovie1.getTitle());
    }

}
