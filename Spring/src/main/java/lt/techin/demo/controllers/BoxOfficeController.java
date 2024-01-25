package lt.techin.demo.controllers;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoxOfficeController {

    private final BoxOfficeRepository boxOfficeRepository;

    @Autowired
    public BoxOfficeController(BoxOfficeRepository boxOfficeRepository) {
        this.boxOfficeRepository = boxOfficeRepository;
    }

    @GetMapping("/boxoffice")
    public List<BoxOffice> getBoxOffice() {
        return this.boxOfficeRepository.findAll();
    }

    @GetMapping("/boxoffice/{id}")
    public BoxOffice getBoxOffice(@PathVariable long id) {
        return this.boxOfficeRepository.findById(id).orElseThrow();
    }

    @PostMapping("/boxoffice")
    public BoxOffice insertBoxOffice(@RequestBody BoxOffice boxOffice) {
        return this.boxOfficeRepository.save(boxOffice);
    }

    @PutMapping("/boxoffice/{id}")
    public BoxOffice updateBoxOffice(@RequestBody BoxOffice boxoffice, @PathVariable long id) {
        if (this.boxOfficeRepository.existsById(id)) {
            BoxOffice boxOfficeFromDb = this.boxOfficeRepository.findById(id).orElseThrow();
            boxOfficeFromDb.setMovieId(boxoffice.getMovieId());
            boxOfficeFromDb.setRating(boxoffice.getRating());
            boxOfficeFromDb.setDomesticSales(boxoffice.getDomesticSales());
            boxOfficeFromDb.setInternationalSales(boxoffice.getInternationalSales());
            return this.boxOfficeRepository.save(boxOfficeFromDb);
        } else {
            return this.boxOfficeRepository.save(boxoffice);
        }
    }

    @DeleteMapping("/boxoffice/{id}")
    public void deleteBoxOffice(@PathVariable long id) {
        this.boxOfficeRepository.deleteById(id);
    }
}
