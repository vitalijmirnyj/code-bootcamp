package lt.techin.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.BoxOfficeService;
import lt.techin.demo.controllers.BoxOfficeController;
import lt.techin.demo.models.BoxOffice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
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
    private BoxOfficeService boxOfficeService;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void getBoxOffice_saveBoxOffice_returnAll() throws Exception {
        Movie movie = new Movie("Terminator", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        Movie movie2 = new Movie("Terminator 2", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        given(this.boxOfficeService.findAllBoxOffice()).willReturn(List.of(new BoxOffice(movie, (double) 8.5, (long) 500000, (long) 500000),
                new BoxOffice(movie2, (double) 8.5, (long) 500000, (long) 500000)
        ));

        mockMvc.perform(get("/boxoffice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].rating").value(8.5))
                .andExpect(jsonPath("$[0].domesticSales").value(500000))
                .andExpect(jsonPath("$[0].internationalSales").value(500000))
                .andExpect(jsonPath("$[1].rating").value(8.5))
                .andExpect(jsonPath("$[1].domesticSales").value(500000))
                .andExpect(jsonPath("$[1].internationalSales").value(500000));


        verify(this.boxOfficeService).findAllBoxOffice();
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void insertBoxOffice_whenSaveBoxOffice_thenReturnIt() throws Exception {
        Movie movie = new Movie("Terminator", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        BoxOffice boxOffice = new BoxOffice(movie, (double) 8.5, (long) 500000, (long) 500000);
        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class))).willReturn(boxOffice);

        mockMvc.perform(post("/boxoffice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(boxOffice)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));


        verify(this.boxOfficeService).saveBoxOffice(any(BoxOffice.class));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateBoxOffice_whenUpdateFields_thenReturn() throws Exception {
        //given
        Movie movie = new Movie("Terminator", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        Movie movie2 = new Movie("Terminator 2", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        BoxOffice existingBoxOffice = new BoxOffice(movie, (double) 8.5, (long) 500000, (long) 500000);
        BoxOffice updatedBoxOffice = new BoxOffice(movie2, (double) 8.5, (long) 500000, (long) 500000);

        given(this.boxOfficeService.existsBoxOfficeById(anyLong())).willReturn(true);
        given(this.boxOfficeService.findBoxOfficeById(anyLong())).willReturn(existingBoxOffice);
        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class))).willReturn(updatedBoxOffice);
//when
        mockMvc.perform(put("/boxoffice/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedBoxOffice))
                        .accept(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));


        verify(this.boxOfficeService).existsBoxOfficeById(1L);
        verify(this.boxOfficeService).findBoxOfficeById(1L);
        verify(this.boxOfficeService).saveBoxOffice(argThat(m -> {
            assertThat(m.getRating()).isEqualTo(8.5);
            assertThat(m.getDomesticSales()).isEqualTo(500000);
            assertThat(m.getInternationalSales()).isEqualTo(500000);

            return true;
        }));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updatedBoxOffice_whenNoBoxOfficeFound_addNewOne() throws Exception {
        // Given
        Movie movie = new Movie("Terminator", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        BoxOffice boxOffice = new BoxOffice(movie, 8.5, 500000L, 500000L);

        given(this.boxOfficeService.existsBoxOfficeById(anyLong())).willReturn(false);

        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class)))
                .willAnswer(invocation -> {
                    BoxOffice savedBoxOffice = invocation.getArgument(0);
                    savedBoxOffice.setRating(boxOffice.getRating());
                    return savedBoxOffice;
                });

        // When
        mockMvc.perform(put("/boxoffice/{id}", 58)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(boxOffice))
                        .accept(MediaType.APPLICATION_JSON))

                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));

        verify(this.boxOfficeService).existsBoxOfficeById(58L);
        verify(this.boxOfficeService, never()).findBoxOfficeById(anyLong());
        verify(this.boxOfficeService).saveBoxOffice(argThat(persistedBoxOffice -> persistedBoxOffice.getRating() == 8.5));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void deleteBoxOffice_checkIfBoxOfficeDeleted() throws Exception {
        long boxOfficeIdToDelete = 1L;
        mockMvc.perform(delete("/boxoffice/{id}", boxOfficeIdToDelete))
                .andExpect(status().isOk());
        verify(this.boxOfficeService).deleteBoxOfficeById(1L);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void getBoxOffice_checkIfBoxOfficeRetrieved() throws Exception {
        long boxOfficeId = 1L;
        Movie movie = new Movie("Terminator", "James Cameron", LocalDate.of(1991, 10, 10), (short) 144);
        BoxOffice expectedBoxOffice = new BoxOffice(movie, (double) 8.5, (long) 500000, (long) 500000);

        given(boxOfficeService.findBoxOfficeById(boxOfficeId)).willReturn(expectedBoxOffice);
        mockMvc.perform(get("/boxoffice/{id}", boxOfficeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));


        verify(this.boxOfficeService).findBoxOfficeById(boxOfficeId);
    }
}
