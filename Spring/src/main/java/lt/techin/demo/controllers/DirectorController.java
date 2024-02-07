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
            directorFromDb.setGender(director.getGender());
            directorFromDb.setAge(director.getAge());
            directorFromDb.setNationality(director.getNationality());
            directorFromDb.setName(director.getName());
            directorFromDb.setSurname(director.getSurname());
            return this.actorService.saveActor(actorFromDb);
        }
        return this.actorService.saveActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable long id) {
        this.actorService.deleteActorById(id);
    }
}
