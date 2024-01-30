package lt.techin.demo.controllers;

import lt.techin.demo.services.BoxOfficeService;
import lt.techin.demo.models.BoxOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoxOfficeController {

    private final BoxOfficeService boxOfficeService;

    @Autowired
    public BoxOfficeController(BoxOfficeService boxOfficeService) {
        this.boxOfficeService = boxOfficeService;
    }

    @GetMapping("/boxoffice")
    public List<BoxOffice> getBoxOffice() {
        return this.boxOfficeService.findAllBoxOffice();
    }

    @GetMapping("/boxoffice/{id}")
    public BoxOffice getBoxOffice(@PathVariable long id) {
        return this.boxOfficeService.findBoxOfficeById(id);
    }

    @PostMapping("/boxoffice")
    public BoxOffice insertBoxOffice(@RequestBody BoxOffice boxOffice) {
        return this.boxOfficeService.saveBoxOffice(boxOffice);
    }

    @PutMapping("/boxoffice/{id}")
    public BoxOffice updateBoxOffice(@RequestBody BoxOffice boxoffice, @PathVariable long id) {
        if (this.boxOfficeService.existsBoxOfficeById(id)) {
            BoxOffice boxOfficeFromDb = this.boxOfficeService.findBoxOfficeById(id);
            boxOfficeFromDb.setMovieId(boxoffice.getMovieId());
            boxOfficeFromDb.setRating(boxoffice.getRating());
            boxOfficeFromDb.setDomesticSales(boxoffice.getDomesticSales());
            boxOfficeFromDb.setInternationalSales(boxoffice.getInternationalSales());
            return this.boxOfficeService.saveBoxOffice(boxOfficeFromDb);
        } else {
            return this.boxOfficeService.saveBoxOffice(boxoffice);
        }
    }

    @DeleteMapping("/boxoffice/{id}")
    public void deleteBoxOffice(@PathVariable long id) {
        this.boxOfficeService.deleteBoxOfficeById(id);
    }
}
