package lt.techin.demo.controllers;

import lt.techin.demo.Services.BoxOfficeService;
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
        return this.boxOfficeService.findAllFromBoxOffice();
    }

    @GetMapping("/boxoffice/{id}")
    public BoxOffice getBoxOffice(@PathVariable long id) {
        return this.boxOfficeService.findFromBoxOfficeById(id);
    }

    @PostMapping("/boxoffice")
    public BoxOffice insertBoxOffice(@RequestBody BoxOffice boxOffice) {
        return this.boxOfficeService.saveFromBoxOffice(boxOffice);
    }

    @PutMapping("/boxoffice/{id}")
    public BoxOffice updateBoxOffice(@RequestBody BoxOffice boxoffice, @PathVariable long id) {
        if (this.boxOfficeService.existsFromBoxOfficeById(id)) {
            BoxOffice boxOfficeFromDb = this.boxOfficeService.findFromBoxOfficeById(id);
            boxOfficeFromDb.setMovieId(boxoffice.getMovieId());
            boxOfficeFromDb.setRating(boxoffice.getRating());
            boxOfficeFromDb.setDomesticSales(boxoffice.getDomesticSales());
            boxOfficeFromDb.setInternationalSales(boxoffice.getInternationalSales());
            return this.boxOfficeService.saveFromBoxOffice(boxOfficeFromDb);
        } else {
            return this.boxOfficeService.saveFromBoxOffice(boxoffice);
        }
    }

    @DeleteMapping("/boxoffice/{id}")
    public void deleteBoxOffice(@PathVariable long id) {
        this.boxOfficeService.deleteFromBoxOfficeById(id);
    }
}
