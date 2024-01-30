package lt.techin.demo.Services;

import java.util.List;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoxOfficeService {
    private final BoxOfficeRepository boxOfficeRepository;

    @Autowired
    public BoxOfficeService(BoxOfficeRepository boxOfficeRepository) {
        this.boxOfficeRepository = boxOfficeRepository;
    }

    public List<BoxOffice> findAllFromBoxOffice() {
        return this.boxOfficeRepository.findAll();
    }

    public BoxOffice findFromBoxOfficeById(long id) {
        return this.boxOfficeRepository.findById(id).orElseThrow();
    }

    public BoxOffice saveFromBoxOffice(BoxOffice boxOffice) {
        return this.boxOfficeRepository.save(boxOffice);
    }

    public void deleteFromBoxOfficeById(long id) {
        this.boxOfficeRepository.deleteById(id);
    }

    public boolean existsFromBoxOfficeById(long id) {
        return this.boxOfficeRepository.existsById(id);
    }
}
