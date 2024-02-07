package lt.techin.demo.ControllerTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.techin.demo.Security.SecurityConfig;
import lt.techin.demo.services.MovieService;
import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MovieController.class)
@Import(SecurityConfig.class)
public class MovieControllerTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    @WithMockUser
    void getMovies_saveMovies_returnAll() throws Exception {
        given(this.movieService.findAllMovies()).willReturn(List.of(new Movie("Robocop", "Verhoven", LocalDate.of(1991, 10, 10), (short) 114),
                new Movie("Terminator", "Cameron", LocalDate.of(1991, 10, 10), (short) 114)
        ));

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Robocop"))
                .andExpect(jsonPath("$[0].director").value("Verhoven"))
                .andExpect(jsonPath("$[0].yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$[0].lengthMinutes").value(114))
                .andExpect(jsonPath("$[1].title").value("Terminator"))
                .andExpect(jsonPath("$[1].director").value("Cameron"))
                .andExpect(jsonPath("$[1].yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$[1].lengthMinutes").value(114));

        verify(this.movieService).findAllMovies();
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
        Movie movie = new Movie("Die Hard", "Tony Scott", LocalDate.of(1991, 10, 10), (short) 110);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Die Hard"))
                .andExpect(jsonPath("$.director").value("Tony Scott"))
                .andExpect(jsonPath("$.yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$.lengthMinutes").value(110));

        verify(this.movieService).saveMovie(any(Movie.class));
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void insertMovie_whenUserTriesToInsert_thenForbidden() throws Exception {
        Movie movie = new Movie("Die Hard", "Tony Scott", LocalDate.of(1991, 10, 10), (short) 110);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);
        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isForbidden());

        verify(movieService, never()).saveMovie(any(Movie.class));

    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateMovie_whenUpdateFields_thenReturn() throws Exception {
        //given
        Movie existingMovie = new Movie("Existing Movie", "Director A", LocalDate.of(1991, 10, 10), (short) 144);
        Movie updatedMovie = new Movie("Updated Movie", "Director B", LocalDate.of(1991, 10, 10), (short) 120);

        given(this.movieService.existsById(anyLong())).willReturn(true);
        given(this.movieService.findMovieById(anyLong())).willReturn(existingMovie);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(updatedMovie);

        //when
        mockMvc.perform(put("/movies/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedMovie))
                        .accept(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Movie"))
                .andExpect(jsonPath("$.director").value("Director B"))
                .andExpect(jsonPath("$.yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$.lengthMinutes").value(120));

        verify(this.movieService).existsById(1L);
        verify(this.movieService).findMovieById(1L);
        verify(this.movieService).saveMovie(argThat(m -> {

            assertThat(m.getTitle()).isEqualTo("Updated Movie");
            assertThat(m.getDirector()).isEqualTo("Director B");
            assertThat(m.getYearRelease()).isEqualTo(LocalDate.of(1991, 10, 10));
            assertThat(m.getLengthMinutes()).isEqualTo((short) 120);
            return true;
        }));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateMovie_whenNoMovieFound_addNewOne() throws Exception {
        //given
        Movie newMovie = new Movie("New Movie", "Director C", LocalDate.of(1991, 10, 10), (short) 120);

        given(this.movieService.existsById(anyLong())).willReturn(false);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(newMovie);

        //when
        mockMvc.perform(put("/movies/{id}", 58)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newMovie))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Movie"))
                .andExpect(jsonPath("$.director").value("Director C"))
                .andExpect(jsonPath("$.yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$.lengthMinutes").value(120));

        verify(this.movieService).existsById(58L);
        verify(this.movieService, never()).findMovieById(anyLong());
        verify(this.movieService).saveMovie(argThat(persistedMovie -> persistedMovie.getTitle()
                .equals("New Movie")));

    }

    @Test
    @WithMockUser(roles = {"USER"})
    void updateMovie_whenUserTriesToUpdate_thenForbidden() throws Exception {
        long movieIdToUpdate = 58L;
        Movie newMovie = new Movie("New Movie", "Director C", LocalDate.of(1991, 10, 10), (short) 120);

        mockMvc.perform(put("/movies/{id}", movieIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newMovie))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());

        verify(movieService, never()).existsById(anyLong());
        verify(movieService, never()).findMovieById(anyLong());
        verify(movieService, never()).saveMovie(any(Movie.class));

    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void deleteMovie_whenAdminAndMovieExists_thenMovieDeletedSuccessfully() throws Exception {
        given(this.movieService.existsById(anyLong())).willReturn(true);
        long movieIdToDelete = 1L;
        mockMvc.perform(delete("/movies/{id}", movieIdToDelete))
                .andExpect(status().isOk());
        verify(this.movieService).deleteMovieById(1L);
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void deleteMovie_whenUserTriesToDelete_thenForbidden() throws Exception {
        long movieIdToDelete = 1L;

        mockMvc.perform(delete("/movies/{id}", movieIdToDelete))
                .andExpect(status().isForbidden());

        verify(movieService, never()).deleteMovieById(anyLong());
    }

    @Test
    @WithMockUser
    void getMovie_whenExpectedMovieReturned_thenVerifyOk() throws Exception {
        long movieId = 1L;
        Movie expectedMovie = new Movie("Terminator 2", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);

        given(movieService.findMovieById(movieId)).willReturn(expectedMovie);
        mockMvc.perform(get("/movies/{id}", movieId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Terminator 2"))
                .andExpect(jsonPath("$.director").value("James Cameron"))
                .andExpect(jsonPath("$.yearRelease").value("1991-10-10"))
                .andExpect(jsonPath("$.lengthMinutes").value(144));

        verify(this.movieService).findMovieById(movieId);
    }
}
