package lt.techin.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.services.ActorService;
import lt.techin.demo.controllers.ActorController;
import lt.techin.demo.models.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ActorController.class)
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;

    @Test
    @WithMockUser(roles = {"ADMIN"})
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

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void insertActor_whenSaveActor_thenReturnIt() throws Exception {
        Actor actor = new Actor(1, "Male", (short) 50, "USA", "David", "Duchovni");
        given(this.actorService.saveActor(any(Actor.class))).willReturn(actor);

        mockMvc.perform(post("/actors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(actor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.age").value(50))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.name").value("David"))
                .andExpect(jsonPath("$.surname").value("Duchovni"));


        verify(this.actorService).saveActor(any(Actor.class));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateActor_whenUpdateFields_thenReturn() throws Exception {
        //given
        Actor existingActor = new Actor(1, "Male", (short) 55, "USA", "Adam", "Sandler");
        Actor updatedActor = new Actor(2, "Female", (short) 65, "USA", "Sandra", "Bullock");

        given(this.actorService.existsById(anyLong())).willReturn(true);
        given(this.actorService.findActorById(anyLong())).willReturn(existingActor);
        given(this.actorService.saveActor(any(Actor.class))).willReturn(updatedActor);
//when
        mockMvc.perform(put("/actors/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedActor))
                        .accept(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender").value("Female"))
                .andExpect(jsonPath("$.age").value(65))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.name").value("Sandra"))
                .andExpect(jsonPath("$.surname").value("Bullock"));

        verify(this.actorService).existsById(1L);
        verify(this.actorService).findActorById(1L);
        verify(this.actorService).saveActor(argThat(m -> {
            assertThat(m.getGender()).isEqualTo("Female");
            assertThat(m.getAge()).isEqualTo((short) 65);
            assertThat(m.getNationality()).isEqualTo("USA");
            assertThat(m.getName()).isEqualTo("Sandra");
            assertThat(m.getSurname()).isEqualTo("Bullock");
            return true;
        }));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updatedActor_whenNoActorFound_addNewOne() throws Exception {
        //given
        Actor newActor = new Actor(1, "Male", (short) 55, "USA", "Adam", "Sandler");

        given(this.actorService.existsById(anyLong())).willReturn(false);
        given(this.actorService.saveActor(any(Actor.class))).willReturn(newActor);

        //when
        mockMvc.perform(put("/actors/{id}", 58)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newActor))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.age").value(55))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.name").value("Adam"))
                .andExpect(jsonPath("$.surname").value("Sandler"));

        verify(this.actorService).existsById(58L);
        verify(this.actorService, never()).findActorById(anyLong());
        verify(this.actorService).saveActor(argThat(persistedActor -> persistedActor.getName()
                .equals("Adam")));

    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void deleteActor_checkIfActorDeleted() throws Exception {
        long actorIdToDelete = 1L;
        mockMvc.perform(delete("/actors/{id}", actorIdToDelete))
                .andExpect(status().isOk());
        verify(this.actorService).deleteActorById(1L);
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void deleteActor_whenUserTriesToDelete_thenForbidden() throws Exception {
        long actorIdToDelete = 1L;

        mockMvc.perform(delete("/actors/{id}", actorIdToDelete))
                .andExpect(status().isForbidden());

        verify(actorService, never()).deleteActorById(anyLong());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void getActor_checkIfActorRetrieved() throws Exception {
        long actorId = 1L;
        Actor expectedActor = new Actor(1, "Male", (short) 55, "USA", "Adam", "Sandler");

        given(actorService.findActorById(actorId)).willReturn(expectedActor);
        mockMvc.perform(get("/actors/{id}", actorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.age").value(55))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.name").value("Adam"))
                .andExpect(jsonPath("$.surname").value("Sandler"));

        verify(this.actorService).findActorById(actorId);
    }
}

