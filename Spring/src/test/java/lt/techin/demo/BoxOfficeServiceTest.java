package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.services.BoxOfficeService;
import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
    void findAllBoxOffice_saveBoxOffice_returned() {
        BoxOffice savedBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        BoxOffice savedBoxOffice2 = this.boxOfficeRepository.save(new BoxOffice(2, (double) 9.5, (long) 500000, (long) 500000));
        BoxOffice foundBoxOffice = this.boxOfficeService.findBoxOfficeById(savedBoxOffice.getMovieId());
        then(foundBoxOffice).isEqualTo(savedBoxOffice);
        BoxOffice foundBoxOffice2 = this.boxOfficeService.findBoxOfficeById(savedBoxOffice2.getMovieId());
        then(foundBoxOffice2).isEqualTo(savedBoxOffice2);
    }

    @Test
    void findBoxOfficeById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.boxOfficeService.findBoxOfficeById(1));
        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveBoxOffice() {

        BoxOffice savedBoxOffice = this.boxOfficeService.saveBoxOffice(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));

        BoxOffice foundBoxOffice = this.boxOfficeRepository.findById(savedBoxOffice.getMovieId()).orElse(null);
        then(savedBoxOffice).isEqualTo(foundBoxOffice);

    }

    @Test
    void existsBoxOfficeById_CheckIfExists_ReturnTrue() {
        BoxOffice savedBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        boolean existsBoxOffice = this.boxOfficeService.existsBoxOfficeById(savedBoxOffice.getMovieId());
        then(existsBoxOffice).isTrue();
    }

    @Test
    void deleteBoxOfficeById_delete_cannotFind() {
        BoxOffice savedBoxOffice = this.boxOfficeRepository.save(new BoxOffice(1, (double) 8.5, (long) 500000, (long) 500000));
        this.boxOfficeService.deleteBoxOfficeById(savedBoxOffice.getMovieId());
        then(this.boxOfficeRepository.existsById(savedBoxOffice.getMovieId())).isFalse();
    }
}
