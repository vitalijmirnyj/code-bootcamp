package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.Services.ActorService;
import lt.techin.demo.Services.BoxOfficeService;
import lt.techin.demo.models.Actor;
import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.ActorRepository;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.*;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.NoSuchElementException;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
public class BoxOfficeServiceTest {

    @Autowired
    private BoxOfficeService boxOfficeService;
    @Autowired
    private BoxOfficeRepository boxOfficeRepository;

    @Test
    void findAllFromBoxOffice_saveFromBoxOffice_returned() {
        BoxOffice savedBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        BoxOffice savedBoxOffice2 = this.boxOfficeRepository.save(new BoxOffice(2, (double) 9.5, (long) 500000, (long) 500000));
        BoxOffice foundBoxOffice = this.boxOfficeService.findFromBoxOfficeById(savedBoxOffice.getMovieId());
        then(foundBoxOffice).isEqualTo(savedBoxOffice);
        BoxOffice foundBoxOffice2 = this.boxOfficeService.findFromBoxOfficeById(savedBoxOffice2.getMovieId());
        then(foundBoxOffice2).isEqualTo(savedBoxOffice2);
    }

    @Test
    void findFromBoxOfficeById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.boxOfficeService.findFromBoxOfficeById(1));
        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveFromBoxOffice() {

        BoxOffice savedFromBoxOffice = this.boxOfficeService.saveFromBoxOffice(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));

        BoxOffice foundFromBoxOffice = this.boxOfficeRepository.findById(savedFromBoxOffice.getMovieId()).orElse(null);
        then(savedFromBoxOffice).isEqualTo(foundFromBoxOffice);

    }

    @Test
    void existsFromBoxOfficeById_CheckIfExists_ReturnTrue() {
        BoxOffice savedFromBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        boolean existsFromBoxOffice = this.boxOfficeService.existsFromBoxOfficeById(savedFromBoxOffice.getMovieId());
        then(existsFromBoxOffice).isTrue();
    }

    @Test
    void deleteFromBoxOfficeById_delete_cannotFind() {
        BoxOffice savedFromBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        this.boxOfficeService.deleteFromBoxOfficeById(savedFromBoxOffice.getMovieId());
        then(this.boxOfficeRepository.existsById(savedFromBoxOffice.getMovieId())).isFalse();
    }
}
