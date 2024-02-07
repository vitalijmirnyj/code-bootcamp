package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public List<Director> getDirectors() {
        return this.directorService.findAllDirectors();
    }


    @GetMapping("/directors/{id}")
    public Director getDirector(@PathVariable long id) {
        return this.directorService.findDirectorById(id);

    }

    @PostMapping("/directors")
    public Director insertDirector(@RequestBody Director director) {
        return this.directorService.saveDirector(director);
    }

    @PutMapping("/directors/{id}")
    public Director updateDirector(@RequestBody Director director, @PathVariable long id) {
        if (this.directorService.existsById(id)) {
            Director directorFromDb = this.directorService.findDirectorById(id);
            directorFromDb.setDirectorName(director.getDirectorName());
            directorFromDb.setDateOfBirth(director.getDateOfBirth());
            directorFromDb.setNationality(director.getNationality());
            directorFromDb.setBiography(director.getBiography());
            directorFromDb.setAwards(director.getAwards());
            return this.directorService.saveDirector(directorFromDb);
        }
        return this.directorService.saveDirector(director);
    }

    @DeleteMapping("/directors/{id}")
    public void deleteDerector(@PathVariable long id) {
        this.directorService.deleteDirectorById(id);
    }
}
