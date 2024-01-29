package lt.techin.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.Services.MovieService;
import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    void getMovies_saveMovies_returnAll() throws Exception {
        given(this.movieService.findAllMovies()).willReturn(List.of(new Movie("Robocop", "Verhoven", (short) 1984, (short) 114),
                new Movie("Terminator", "Cameron", (short) 1983, (short) 114)
        ));

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Robocop"))
                .andExpect(jsonPath("$[0].director").value("Verhoven"))
                .andExpect(jsonPath("$[0].yearRelease").value(1984))
                .andExpect(jsonPath("$[0].lengthMinutes").value(114))
                .andExpect(jsonPath("$[1].title").value("Terminator"))
                .andExpect(jsonPath("$[1].director").value("Cameron"))
                .andExpect(jsonPath("$[1].yearRelease").value(1983))
                .andExpect(jsonPath("$[1].lengthMinutes").value(114));

        verify(this.movieService).findAllMovies();
    }

    @Test
    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
        Movie movie = new Movie("Die Hard", "Tony Scott", (short) 1988, (short) 110);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(movie)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Die Hard"))
                .andExpect(jsonPath("$.director").value("Tony Scott"))
                .andExpect(jsonPath("$.yearRelease").value(1988))
                .andExpect(jsonPath("$.lengthMinutes").value(110));

        verify(this.movieService).saveMovie(any(Movie.class));
    }
}
