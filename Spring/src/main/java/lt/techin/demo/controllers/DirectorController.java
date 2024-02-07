package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Director;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.ActorService;
import lt.techin.demo.services.DirectorService;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<Director> insertDirector(@RequestBody Director director) {
        Director savedDirector = this.directorService.saveDirector(director);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedDirector.getDirector_id())
                        .toUri())
                .body(savedDirector);

    }

    @PutMapping("/directors/{id}")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director, @PathVariable long id) {
        if (this.directorService.existsById(id)) {
            Director directorFromDb = this.directorService.findDirectorById(id);
            directorFromDb.setDirectorName(director.getDirectorName());
            directorFromDb.setDateOfBirth(director.getDateOfBirth());
            directorFromDb.setNationality(director.getNationality());
            directorFromDb.setBiography(director.getBiography());
            directorFromDb.setAwards(director.getAwards());
            this.directorService.saveDirector(directorFromDb);
            return ResponseEntity.ok(directorFromDb);
        }
        Director savedDirector = this.directorService.saveDirector(director);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedDirector.getDirector_id())
                        .toUri())
                .body(savedDirector);

    }

    @DeleteMapping("/directors/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable long id) {
        if (this.directorService.existsById(id)) {
            this.directorService.deleteDirectorById(id);
            return ResponseEntity.ok().build();
        }
        this.directorService.deleteDirectorById(id);
        return ResponseEntity.notFound().build();
    }
    }
}
