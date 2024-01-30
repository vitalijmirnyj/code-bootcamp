package lt.techin.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.Services.ActorService;
import lt.techin.demo.Services.MovieService;
import lt.techin.demo.controllers.ActorController;
import lt.techin.demo.controllers.BoxOfficeController;
import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BoxOfficeController.class)
public class BoxOfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;

    @Test
    void getActors_saveActors_returnAll() throws Exception {
        given(this.actorService.findAllActors()).willReturn(List.of(new Actor(1, "Male", (short) 49, "USA", "Leonardo", "Dicaprio"),
                new Actor(2, "Female", (short) 49, "USA", "Linda", "Hamilton")
        ));

        mockMvc.perform(get("/actors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].gender").value("Male"))
                .andExpect(jsonPath("$[0].age").value(49))
                .andExpect(jsonPath("$[0].nationality").value("USA"))
                .andExpect(jsonPath("$[0].name").value("Leonardo"))
                .andExpect(jsonPath("$[0].surname").value("Dicaprio"))
                .andExpect(jsonPath("$[1].gender").value("Female"))
                .andExpect(jsonPath("$[1].age").value(49))
                .andExpect(jsonPath("$[1].nationality").value("USA"))
                .andExpect(jsonPath("$[1].name").value("Linda"))
                .andExpect(jsonPath("$[1].surname").value("Hamilton"));


        verify(this.actorService).findAllActors();
    }
}
