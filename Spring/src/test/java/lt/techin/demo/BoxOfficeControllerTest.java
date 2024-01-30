package lt.techin.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.models.Actor;
import lt.techin.demo.services.BoxOfficeService;
import lt.techin.demo.controllers.BoxOfficeController;
import lt.techin.demo.models.BoxOffice;
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
    private BoxOfficeService boxOfficeService;

    @Test
    void getBoxOffice_saveBoxOffice_returnAll() throws Exception {
        given(this.boxOfficeService.findAllBoxOffice()).willReturn(List.of(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000),
                new BoxOffice(2, (double) 8.5, (long) 500000, (long) 500000)
        ));

        mockMvc.perform(get("/boxOffice"))
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
    void insertBoxOffice_whenSaveBoxOffice_thenReturnIt() throws Exception {
        BoxOffice boxOffice = new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000);
        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class))).willReturn(boxOffice);

        mockMvc.perform(post("/boxOffice")
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
    void updateBoxOffice_whenUpdateFields_thenReturn() throws Exception {
        //given
        BoxOffice existingBoxOffice = new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000);
        BoxOffice updatedBoxOffice = new BoxOffice(2, (double) 8.5, (long) 500000, (long) 500000);

        given(this.boxOfficeService.existsBoxOfficeById(anyLong())).willReturn(true);
        given(this.boxOfficeService.findBoxOfficeById(anyLong())).willReturn(existingBoxOffice);
        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class))).willReturn(updatedBoxOffice);
//when
        mockMvc.perform(put("/boxOffice/{id}", 1)
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
    void updatedBoxOffice_whenNoBoxOfficeFound_addNewOne() throws Exception {
        //given
        BoxOffice boxOffice = new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000);

        given(this.boxOfficeService.existsBoxOfficeById(anyLong())).willReturn(false);
        given(this.boxOfficeService.saveBoxOffice(any(BoxOffice.class))).willReturn(new BoxOffice());

        //when
        mockMvc.perform(put("/actors/{id}", 58)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(boxOffice))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));


        verify(this.boxOfficeService).existsBoxOfficeById(58L);
        verify(this.boxOfficeService, never()).findBoxOfficeById(anyLong());
        verify(this.boxOfficeService).saveBoxOffice(argThat(persistedBoxOffice -> persistedBoxOffice.getRating() == 8.5));

    }

    @Test
    void deleteBoxOffice_checkIfBoxOfficeDeleted() throws Exception {
        long boxOfficeIdToDelete = 1L;
        mockMvc.perform(delete("/boxOffice/{id}", boxOfficeIdToDelete))
                .andExpect(status().isOk());
        verify(this.boxOfficeService).deleteBoxOfficeById(1L);
    }

    @Test
    void getBoxOffice_checkIfBoxOfficeRetrieved() throws Exception {
        long boxOfficeId = 1L;
        BoxOffice expectedBoxOffice = new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000);

        given(boxOfficeService.findBoxOfficeById(boxOfficeId)).willReturn(expectedBoxOffice);
        mockMvc.perform(get("/boxOffice/{id}", boxOfficeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating").value(8.5))
                .andExpect(jsonPath("$.domesticSales").value(500000))
                .andExpect(jsonPath("$.internationalSales").value(500000));


        verify(this.boxOfficeService).findBoxOfficeById(boxOfficeId);
    }
}
