package lt.techin.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.techin.demo.controllers.ActorController;
import lt.techin.demo.controllers.DirectorController;
import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Director;
import lt.techin.demo.models.Movie;
import lt.techin.demo.security.SecurityConfig;
import lt.techin.demo.services.DirectorService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DirectorController.class)
@Import(SecurityConfig.class)
public class DirectorControllerTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorService directorService;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void GetDirectors_whenAdminSaveDirectors_thenReturnAll() throws Exception {
        given(this.directorService.findAllDirectors()).willReturn(List.of(new Director(1, "Christopher Nolan", LocalDate.of(1970, 07, 30), "British", "Christopher Nolan is a British-American film director, screenwriter, and producer.", "3 Oscars, 6 BAFTA Awards"),
                new Director(2, "Quentin Tarantino", LocalDate.of(1963, 03, 27), "American", "Quentin Jerome Tarantino is an American film director, screenwriter, producer, and actor.", "2 Oscars, 2 Golden Globes")
        ));

        mockMvc.perform(get("/directors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].directorName").value("Christopher Nolan"))
                .andExpect(jsonPath("$[0].dateOfBirth").value("1970-07-30"))
                .andExpect(jsonPath("$[0].nationality").value("British"))
                .andExpect(jsonPath("$[0].biography").value("Christopher Nolan is a British-American film director, screenwriter, and producer."))
                .andExpect(jsonPath("$[0].awards").value("3 Oscars, 6 BAFTA Awards"))
                .andExpect(jsonPath("$[1].directorName").value("Quentin Tarantino"))
                .andExpect(jsonPath("$[1].dateOfBirth").value("1963-03-27"))
                .andExpect(jsonPath("$[1].nationality").value("American"))
                .andExpect(jsonPath("$[1].biography").value("Quentin Jerome Tarantino is an American film director, screenwriter, producer, and actor."))
                .andExpect(jsonPath("$[1].awards").value("2 Oscars, 2 Golden Globes"));


        verify(this.directorService).findAllDirectors();
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void insertDirector_whenAdminSaveDirector_thenReturnIt() throws Exception {
        Director director = new Director(1, "Christopher Nolan", LocalDate.of(1970, 07, 30), "British", "Christopher Nolan is a British-American film director, screenwriter, and producer.", "3 Oscars, 6 BAFTA Awards");
        given(this.directorService.saveDirector(any(Director.class))).willReturn(director);

        mockMvc.perform(post("/directors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(director)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.directorName").value("Christopher Nolan"))
                .andExpect(jsonPath("$.dateOfBirth").value("1970-07-30"))
                .andExpect(jsonPath("$.nationality").value("British"))
                .andExpect(jsonPath("$.biography").value("Christopher Nolan is a British-American film director, screenwriter, and producer."))
                .andExpect(jsonPath("$.awards").value("3 Oscars, 6 BAFTA Awards"));

        verify(this.directorService).saveDirector(any(Director.class));
    }
}
